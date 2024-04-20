package TermApp;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Arrays;

public class EmployeeGUI extends JFrame {
    private JTable employeeTable;

    public EmployeeGUI() {
        setTitle("Employee Information");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
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
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(updateButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Populate the table with fake employees
        displayEmployees();

        // Make the GUI visible
        setVisible(true);
    }

    private void displayEmployees() {
        // Access the TEMPARRAYS instance to retrieve the employees
        TEMPARRAYS tempArrays = new TEMPARRAYS();

        // Populate the Employees array (You may have already done this elsewhere in your application)
        tempArrays.createFakeEmployees();
        // Iterate over the Employees array and display each employee in the table
        DefaultTableModel model = (DefaultTableModel) employeeTable.getModel();
        for (Object employee : tempArrays.Employees) {
            if (employee != null) {
                Employee emp = (Employee) employee;
                model.addRow(new Object[]{
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

    private void addEmployeeDialog() {
        // Prompt the user to enter each component of the employee constructor
        String firstName = JOptionPane.showInputDialog(this, "Enter First Name:");
        String lastName = JOptionPane.showInputDialog(this, "Enter Last Name:");
        String phoneNumber = JOptionPane.showInputDialog(this, "Enter Phone Number:");
        String address = JOptionPane.showInputDialog(this, "Enter Address:");
        String emailAddress = JOptionPane.showInputDialog(this, "Enter Email Address:");
        String employeeID = JOptionPane.showInputDialog(this, "Enter Employee ID:");
    
    
        // Create a new Employee object with the provided information
        Employee newEmployee = new Employee(firstName, lastName, phoneNumber, address, emailAddress, employeeID);
    
        // Access the TEMPARRAYS instance to add the new employee to the array
        TEMPARRAYS tempArrays = new TEMPARRAYS();
        tempArrays.addEmployee(firstName, lastName, phoneNumber, address, emailAddress, employeeID);
    
        // Add the new employee to the table
        DefaultTableModel model = (DefaultTableModel) employeeTable.getModel();
        model.addRow(new Object[]{
                newEmployee.getFirstName(),
                newEmployee.getLastName(),
                newEmployee.getPhoneNumber(),
                newEmployee.getAddress(),
                newEmployee.getEmailAddress(),
                newEmployee.getEmployeeID()
        });
    }
    

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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(EmployeeGUI::new);
    }
}