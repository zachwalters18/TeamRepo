package TermApp.GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import TermApp.TEMPARRAYS;
import TermApp.Employee;
import TermApp.Job;
import TermApp.Skill;

public class EmployeeGUI extends JFrame {
    private JTable employeeTable;
    private TEMPARRAYS tempArrays;

    public EmployeeGUI(TEMPARRAYS tempArrays) {
        this.tempArrays = tempArrays;
        setTitle("Employee Information");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 700);
        setLocationRelativeTo(null);

        // Create the table model and table
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("First Name");
        model.addColumn("Last Name");
        model.addColumn("Phone Number");
        model.addColumn("Address");
        model.addColumn("Email Address");
        model.addColumn("Employee ID");

        employeeTable = new JTable(model);
        employeeTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        JScrollPane scrollPane = new JScrollPane(employeeTable);
        add(scrollPane, BorderLayout.CENTER);

        // Add some padding around the table
        JPanel paddingPanel = new JPanel();
        paddingPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        paddingPanel.setLayout(new BorderLayout());
        paddingPanel.add(scrollPane, BorderLayout.CENTER);
        add(paddingPanel, BorderLayout.CENTER);

        // Add buttons for actions
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton addButton = new JButton("Add Employee");
        addButton.addActionListener(e -> addEmployeeDialog());
        JButton deleteButton = new JButton("Delete Employee");
        deleteButton.addActionListener(e -> deleteSelectedEmployee());
        JButton updateButton = new JButton("Update Employee");
        updateButton.addActionListener(e -> updateSelectedEmployee());
        JButton jobButton = new JButton("Job Info");
        jobButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayJobInfo();
            }
        });
        JButton skillButton = new JButton("Skill Info");
        skillButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displaySkillInfo();
            }
        });

        JButton evalButton = new JButton("Evaluations");
        evalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EvalsGUI evalGUI = new EvalsGUI();
            }
        });

        // adding a main button to return to the main menu
        JButton mainButton = new JButton("Return to Main");
        mainButton.addActionListener(e -> returnToMain());

        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(jobButton);
        buttonPanel.add(skillButton);
        buttonPanel.add(evalButton);
        buttonPanel.add(mainButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Initialize data (fake employees and job information)
        initializeData();

        // Populate the table with employees
        displayEmployees();

        // Make the GUI visible
        setVisible(true);
    }

    // Create fake skills and job information
    private void initializeData() {

        
        tempArrays.createJobInfo();
        tempArrays.createSkillInfo();
    }

    // display the employees and their variables
    private void displayEmployees() {
        // Populate the Employees array (You may have already done this elsewhere in
        // your application)
        // Assume TEMPARRAYS instance is already populated
        // Iterate over the Employees array and display each employee in the table
        DefaultTableModel model = (DefaultTableModel) employeeTable.getModel();
        for (Object employee : tempArrays.Employees) {
            if (employee != null) {
                Employee emp = (Employee) employee;
                model.addRow(new Object[] {
                        emp.getFirstName(),
                        emp.getLastName(),
                        emp.getPhoneNumber(),
                        emp.getAddress(),
                        emp.getEmailAddress(),
                        emp.getEmployeeID()
                });
            }
        }
    }

    // adds the prompts to enter information for an employee to have its variables,
    // as well as skill and job info
    private void addEmployeeDialog() {
        // Prompt the user to enter each component of the employee constructor
        String firstName = JOptionPane.showInputDialog(this, "Enter First Name:");
        String lastName = JOptionPane.showInputDialog(this, "Enter Last Name:");
        String phoneNumber = JOptionPane.showInputDialog(this, "Enter Phone Number:");
        String address = JOptionPane.showInputDialog(this, "Enter Address:");
        String emailAddress = JOptionPane.showInputDialog(this, "Enter Email Address:");
        String employeeID = JOptionPane.showInputDialog(this, "Enter Employee ID:");

        String currentTitle = JOptionPane.showInputDialog(this, "Enter Current Title:");
        String currentCompany = JOptionPane.showInputDialog(this, "Enter Current Company:");
        String currentSupervisor = JOptionPane.showInputDialog(this, "Enter Current Supervisor:");
        String pastTitle = JOptionPane.showInputDialog(this, "Enter Past Title:");
        String pastCompany = JOptionPane.showInputDialog(this, "Enter Past Company:");
        String pastSupervisor = JOptionPane.showInputDialog(this, "Enter Past Superviror");
        String yearsExperience = JOptionPane.showInputDialog(this, "Enter Years of Experience");

        String hardSkills = JOptionPane.showInputDialog(this, "Enter Hard Skills:");
        String softSkills = JOptionPane.showInputDialog(this, "Enter Soft Skills:");

        // Create a new Employee object with the provided information
        Employee newEmployee = new Employee(firstName, lastName, phoneNumber, address, emailAddress, employeeID);

        // Add the new employee to the TEMPARRAYS instance
        tempArrays.addEmployee(firstName, lastName, phoneNumber, address, emailAddress, employeeID);
        tempArrays.addJob(employeeID, currentTitle, currentCompany, currentSupervisor, pastTitle, pastCompany,
                pastSupervisor, yearsExperience);
        tempArrays.addSkill(employeeID, hardSkills, softSkills);

        // Add the new employee to the table
        DefaultTableModel model = (DefaultTableModel) employeeTable.getModel();
        model.addRow(new Object[] {
                newEmployee.getFirstName(),
                newEmployee.getLastName(),
                newEmployee.getPhoneNumber(),
                newEmployee.getAddress(),
                newEmployee.getEmailAddress(),
                newEmployee.getEmployeeID()
        });
    }

    // method that will delete the highlighted employee you select
    private void deleteSelectedEmployee() {
        DefaultTableModel model = (DefaultTableModel) employeeTable.getModel();
        int selectedRow = employeeTable.getSelectedRow();
        if (selectedRow != -1) {
            model.removeRow(selectedRow);
            JOptionPane.showMessageDialog(this, "Employee deleted successfully.",
                    "Delete Employee", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Please select an employee to delete.",
                    "Delete Employee", JOptionPane.WARNING_MESSAGE);
        }

    }

    // method that will update each part of an employee - including their skills and
    // job info
    private void updateSelectedEmployee() {
        DefaultTableModel model = (DefaultTableModel) employeeTable.getModel();
        int selectedRow = employeeTable.getSelectedRow();
        if (selectedRow != -1) {
            // Retrieve selected employee data
            String firstName = (String) model.getValueAt(selectedRow, 0);
            String lastName = (String) model.getValueAt(selectedRow, 1);
            String phoneNumber = (String) model.getValueAt(selectedRow, 2);
            String address = (String) model.getValueAt(selectedRow, 3);
            String emailAddress = (String) model.getValueAt(selectedRow, 4);
            String employeeID = (String) model.getValueAt(selectedRow, 5);

            // Prompt user to update employee information
            firstName = JOptionPane.showInputDialog(this, "Enter First Name:", firstName);
            lastName = JOptionPane.showInputDialog(this, "Enter Last Name:", lastName);
            phoneNumber = JOptionPane.showInputDialog(this, "Enter Phone Number:", phoneNumber);
            address = JOptionPane.showInputDialog(this, "Enter Address:", address);
            emailAddress = JOptionPane.showInputDialog(this, "Enter Email Address:", emailAddress);
            employeeID = JOptionPane.showInputDialog(this, "Enter Employee ID:", employeeID);

            // Ask user if they want to update job and skill info
            int choice = JOptionPane.showConfirmDialog(this, "Do you want to update job and skill information as well?",
                    "Update Job/Skill Info", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                // Prompt user for job information
                String currentTitle = JOptionPane.showInputDialog(this, "Enter Current Title:");
                String currentCompany = JOptionPane.showInputDialog(this, "Enter Current Company:");
                String currentSupervisor = JOptionPane.showInputDialog(this, "Enter Current Supervisor:");
                String pastTitle = JOptionPane.showInputDialog(this, "Enter Past Title:");
                String pastCompany = JOptionPane.showInputDialog(this, "Enter Past Company:");
                String pastSupervisor = JOptionPane.showInputDialog(this, "Enter Past Supervisor:");
                String yearsExperience = JOptionPane.showInputDialog(this, "Enter Years of Experience");

                // Prompt user for skill information
                String hardSkills = JOptionPane.showInputDialog(this, "Enter Hard Skills:");
                String softSkills = JOptionPane.showInputDialog(this, "Enter Soft Skills:");

                // Update the job and skill information in TEMPARRAYS instance
                tempArrays.editJobInfo(selectedRow, employeeID, currentTitle, currentCompany, currentSupervisor,
                        pastTitle, pastCompany, pastSupervisor, yearsExperience);
                tempArrays.editSkillInfo(selectedRow, employeeID, hardSkills, softSkills);
            }

            // Update the selected employee in the TEMPARRAYS instance
            tempArrays.editEmployeeInfo(selectedRow, firstName, lastName, phoneNumber, address, emailAddress,
                    employeeID);

            // Update the selected employee in the table
            model.setValueAt(firstName, selectedRow, 0);
            model.setValueAt(lastName, selectedRow, 1);
            model.setValueAt(phoneNumber, selectedRow, 2);
            model.setValueAt(address, selectedRow, 3);
            model.setValueAt(emailAddress, selectedRow, 4);
            model.setValueAt(employeeID, selectedRow, 5);

            JOptionPane.showMessageDialog(this, "Employee updated successfully.",
                    "Update Employee", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Please select an employee to update.",
                    "Update Employee", JOptionPane.WARNING_MESSAGE);
        }
    }

    // method to display the job info of the employees created
    private void displayJobInfo() {
        // Create a dialog window
        JDialog jobInfoDialog = new JDialog(this, "Job Information", true);
        jobInfoDialog.setSize(1000, 700);
        jobInfoDialog.setLocationRelativeTo(this);

        // Create the table model and table
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Employee ID");
        model.addColumn("Current Title");
        model.addColumn("Current Company");
        model.addColumn("Current Supervisor");
        model.addColumn("Past Title");
        model.addColumn("Past Company");
        model.addColumn("Past Supervisor");
        model.addColumn("Years of Experience");

        JTable jobTable = new JTable(model);

        // Populate the job information
        for (Object job : tempArrays.Jobs) {
            if (job != null) {
                Job jobObj = (Job) job;
                model.addRow(new Object[] {
                        jobObj.getJobID(),
                        jobObj.getCurrentTitle(),
                        jobObj.getCurrentCompany(),
                        jobObj.getCurrentSupervisor(),
                        jobObj.getPastTitle(),
                        jobObj.getPastCompany(),
                        jobObj.getPastSupervisor(),
                        jobObj.getYearsExperience()
                });
            }
        }

        // Add a button to delete job information for the selected row
        JButton deleteJobButton = new JButton("Delete Job");
        deleteJobButton.addActionListener(e -> {
            int selectedRow = jobTable.getSelectedRow();
            if (selectedRow != -1) {
                // Remove the job information from TEMPARRAYS and update the table
                tempArrays.deleteJob(selectedRow);
                model.removeRow(selectedRow);
            } else {
                JOptionPane.showMessageDialog(jobInfoDialog, "Please select a job to delete.",
                        "Delete Job", JOptionPane.WARNING_MESSAGE);
            }
        });

        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton source = (JButton) e.getSource();
                // Find the parent dialog window
                JDialog window = (JDialog) SwingUtilities.getWindowAncestor(source);
                // Close the dialog window
                window.dispose();
            }
        });

        // Add the job table to a scroll pane
        JScrollPane scrollPane = new JScrollPane(jobTable);

        // Add components to the dialog window
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(deleteJobButton);
        buttonPanel.add(closeButton);
        jobInfoDialog.add(scrollPane, BorderLayout.CENTER);
        jobInfoDialog.add(buttonPanel, BorderLayout.SOUTH);

        // Set the dialog window visible
        jobInfoDialog.setVisible(true);
    }

    // method that will display the skill info of the employees created
    private void displaySkillInfo() {
        // Create a dialog window
        JDialog skillInfoDialog = new JDialog(this, "Skill Information", true);
        skillInfoDialog.setSize(1000, 700);
        skillInfoDialog.setLocationRelativeTo(this);

        // Create the table model and table
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Employee ID");
        model.addColumn("Hard Skill");
        model.addColumn("Soft Skill");

        JTable skillTable = new JTable(model);

        // Populate the skill information
        for (Object skill : tempArrays.Skills) {
            if (skill != null) {
                Skill skillObj = (Skill) skill;
                model.addRow(new Object[] {
                        skillObj.getSkillID(),
                        skillObj.getHardSkill(),
                        skillObj.getSoftSkill(),

                });
            }
        }

        // Add a button to delete skill information for the selected row
        JButton deleteSkillButton = new JButton("Delete Skill");
        deleteSkillButton.addActionListener(e -> {
            int selectedRow = skillTable.getSelectedRow();
            if (selectedRow != -1) {
                // Remove the skill information from TEMPARRAYS and update the table
                tempArrays.deleteJob(selectedRow);
                model.removeRow(selectedRow);
            } else {
                JOptionPane.showMessageDialog(skillInfoDialog, "Please select a skill to delete.",
                        "Delete Skill", JOptionPane.WARNING_MESSAGE);
            }
        });

        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton source = (JButton) e.getSource();
                // Find the parent dialog window
                JDialog window = (JDialog) SwingUtilities.getWindowAncestor(source);
                // Close the dialog window
                window.dispose();
            }
        });

        // Add the job table to a scroll pane
        JScrollPane scrollPane = new JScrollPane(skillTable);

        // Add components to the dialog window
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(deleteSkillButton);
        buttonPanel.add(closeButton);
        skillInfoDialog.add(scrollPane, BorderLayout.CENTER);
        skillInfoDialog.add(buttonPanel, BorderLayout.SOUTH);

        // Set the dialog window visible
        skillInfoDialog.setVisible(true);
    }

    private void returnToMain() {
        dispose();
        MainGUI mainGUI = new MainGUI(tempArrays);
    }

}
