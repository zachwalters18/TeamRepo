package TermApp.GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import TermApp.TEMPARRAYS;

public class ProjectGUI extends JFrame{
    private TEMPARRAYS tmp;
    private JLabel projectLabel = projectLabel();
    private JLabel instructionsLabel = instructionLabel();
    private JButton mainButton = mainButton();
    //private JButton reloadButton = reloadButton();
    private JButton projectButton = projectButton();
    private JButton addProjectButton = addProjectButton();
    private String[] chosenEmployees;
    private boolean employeesChanged = false;

    public ProjectGUI(TEMPARRAYS tmp) {
        this.tmp = tmp;
        this.setTitle("HRApp.Project");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(525, 550);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        JPanel projectsPanel = projectsPanel();
        this.add(projectsPanel, BorderLayout.CENTER);
        projectsPanel.setBounds(-1,0,550,580);
        //JPanel projectInfoPanel = projectInfoPanel(1);
        //this.add(projectInfoPanel, BorderLayout.CENTER);
        //projectInfoPanel.setBounds(-1,0,550,580);
    }
    //panel containing all the components
    private JPanel projectsPanel() {
        JPanel projectsPanel = new JPanel();
        projectsPanel.setLayout(null);
        projectsPanel.setVisible(true);
        //be sure to add componets
        JScrollPane projectTable = projectsNameTable();
        projectsPanel.add(projectTable);
        projectTable.setBounds(7,205,500,250);
        projectsPanel.add(projectLabel);
        projectLabel.setBounds(10,10,200,100);
        projectsPanel.add(instructionsLabel);
        instructionsLabel.setBounds(10, 155, 395, 50);
        projectsPanel.add(addProjectButton);
        addProjectButton.setBounds(353,145,160,20);
        projectsPanel.add(projectButton);
        projectButton.setBounds(353, 171, 160, 20);
        projectsPanel.add(mainButton);
        mainButton.setBounds(250,0,263,50);
        return projectsPanel;
    }
    //panel containing specific project information
    private JPanel projectInfoPanel(int id) {
        JPanel projectInfoPanel = new JPanel();
        projectInfoPanel.setLayout(null);
        projectInfoPanel.setVisible(true);
        //adding components
        JLabel selectedProject = selectedProject(id);
        JScrollPane scrollPane = new JScrollPane(selectedProject);
        projectInfoPanel.add(scrollPane);
        scrollPane.setBounds(7,50,500,460);
        JButton editButton = editButton(id);
        projectInfoPanel.add(editButton);
        editButton.setBounds(0,0,100,30);
        JButton deleteButton = deleteButton(id);
        projectInfoPanel.add(deleteButton);
        deleteButton.setBounds(120,0,100,30);
        JButton exitButton = exitButton();
        projectInfoPanel.add(exitButton);
        exitButton.setBounds(413,0,100,30);
        return projectInfoPanel;
    }
    //more information stored on the project
    private JLabel selectedProject(int id) {
        String[] formatedData = tmp.displayProject(id);
        String[] columnNames = {"ID", "Name", "Start Date", "End Date", "Status", "Team Members"};
        StringBuilder labelText = new StringBuilder();
        // Construct the label text
        for (int i = 0; i < columnNames.length; i++) {
            labelText.append(columnNames[i]).append(": ").append(formatedData[i]).append("<br>");
        }
        // Create the JLabel
        JLabel selectedProjectLabel = new JLabel("<html>" + labelText.toString() + "</html>");
        selectedProjectLabel.setLayout(new FlowLayout());
        selectedProjectLabel.setFont(new Font("Clarendon",Font.BOLD,15));
        selectedProjectLabel.setFocusable(false);
        return selectedProjectLabel;
    }
    //button to edit project information
    private JButton editButton(int id) {
        JButton editButton = new JButton();
        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame editProjectFrame = new JFrame();
                JTextField obtainProjectName = new JTextField(10);
                JTextField obtainStartDate = new JTextField(10);
                JTextField obtainEndDate = new JTextField(10);
                JTextField obtainStatus = new JTextField(10);

                JPanel editProjectPanel = new JPanel();
                editProjectPanel.add(new JLabel("New Project Name:"));
                editProjectPanel.add(obtainProjectName);
                editProjectPanel.add(new JLabel("New Start Date:"));
                editProjectPanel.add(obtainStartDate);
                editProjectPanel.add(new JLabel("New End Date:"));
                editProjectPanel.add(obtainEndDate);
                editProjectPanel.add(Box.createHorizontalStrut(15)); // a spacer
                editProjectPanel.add(new JLabel("New Status:"));
                editProjectPanel.add(obtainStatus);
                editProjectPanel.add(new JLabel("New Team Members:"));
                String[] employees = {};
                //creates a Button to check specific employees for the team
                JButton teamSelectionButton = new JButton();
                teamSelectionButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        JFrame employeelist = new JFrame();
                        //gets the current employees from the data base in tmp
                        String[] employees = tmp.currentEmployees();
                        // Create a checkbox array for employees
                        JCheckBox[] checkBoxes = new JCheckBox[employees.length];
                        for (int i = 0; i < employees.length; i++) {
                            checkBoxes[i] = new JCheckBox(employees[i]);
                        }
                        // Create a panel to hold the checkboxes
                        JPanel panel = new JPanel();
                        panel.setLayout(new GridLayout(employees.length, 1));
                        for (JCheckBox checkBox : checkBoxes) {
                            panel.add(checkBox);
                        }
                        // Show the employee selection dialog
                        int result = JOptionPane.showConfirmDialog(employeelist, panel, "Select Employees",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                        if (result == JOptionPane.OK_OPTION) {
                            // User clicked OK, process the selected employees
                            StringBuilder selectedEmployees = new StringBuilder("Selected employees:\n");
                            for (JCheckBox checkBox : checkBoxes) {
                                if (checkBox.isSelected()) {
                                    selectedEmployees.append(checkBox.getText()).append("\n");
                                }
                            }
                            //adds selected employees to tmp
                            JOptionPane.showMessageDialog(employeelist, selectedEmployees.toString(), "Selected Employees",
                            JOptionPane.INFORMATION_MESSAGE);
                            String unformattedEmployees = selectedEmployees.toString();
                            String[] formattedEmployees = unformattedEmployees.split(", ");
                            chosenEmployees = formattedEmployees;
                            employeesChanged = true;
                        } else {
                            // User clicked Cancel or closed the dialog
                            JOptionPane.showMessageDialog(employeelist, "No employees selected.", "Info",
                            JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                });
                teamSelectionButton.setText("Team Selection");
                teamSelectionButton.setFont(new Font("Impact",Font.BOLD,10));
                teamSelectionButton.setFocusable(false);
                //adds the button to the project panel
                editProjectPanel.add(teamSelectionButton);
                int result = JOptionPane.showConfirmDialog(null, editProjectPanel, 
                        "Add Project", JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                    //TEMPARRAYS methods are here: where the edit to the data base happends
                    if (employeesChanged) {
                        boolean noInput = tmp.updateProject(
                            id, obtainProjectName.getText(), obtainStartDate.getText(), obtainEndDate.getText(),
                            obtainStatus.getText(), chosenEmployees);
                        employeesChanged = false;
                        if (!(noInput)) {   //if there is no input generate pop up otherwise open up projectGUI
                            JPanel projectInfoPanel = projectInfoPanel(id);
                            switchPanels(projectInfoPanel);
                        } else {
                            generatePopUp(2);
                        }
                    } else {
                        boolean noInput = tmp.addProject(
                            obtainProjectName.getText(), obtainStartDate.getText(), obtainEndDate.getText(),
                            obtainStatus.getText(), employees);
                        employeesChanged = false;
                        if (!(noInput)) {   //if there is no input generate pop up otherwise open up projectGUI
                            JPanel projectInfoPanel = projectInfoPanel(id);
                            switchPanels(projectInfoPanel);
                        } else {
                            generatePopUp(2);
                        }
                    }
                }
            }
        });
        editButton.setText("EDIT");
        editButton.setFont(new Font("Impact",Font.BOLD,10));
        editButton.setFocusable(false);
        return editButton;
    }
    //button to delete project information
    private JButton deleteButton(int id) {
        JButton deleteButton = new JButton();
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(null,"Are you sure you want to delete this Project?",
                    "Delete Confirmation",JOptionPane.YES_NO_OPTION
                );
                if (result == JOptionPane.YES_OPTION) {
                    tmp.deleteProject(id);
                    JPanel projectsPanel = projectsPanel();
                    switchPanels(projectsPanel);
                }
            }
        });
        deleteButton.setText("DELETE");
        deleteButton.setFont(new Font("Impact",Font.BOLD,10));
        deleteButton.setFocusable(false);
        return deleteButton;
    }
    //exit button returns to the default panel
    private JButton exitButton() {
        JButton exitButton = new JButton();
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JPanel projectsPanel = projectsPanel();
                switchPanels(projectsPanel);
            }
        });
        exitButton.setText("Exit");
        exitButton.setFont(new Font("Impact",Font.BOLD,10));
        exitButton.setFocusable(false);
        return exitButton;
    }
    //GUI elements on the frame
    //Jtable contains specificProjectLabel and projectButton
    private JScrollPane projectsNameTable() {
        //call the displayAllProjects() to get all the known ids and project names
        ArrayList<String[]> data = tmp.displayAllProjects();
        int dataSize = data.size();
        String[][] formatedData = new String[dataSize][2];
        for (int i = 0; i < formatedData.length; i++) {
            formatedData[i] = data.get(i);
        }
        //create the table with the data and column Names
        String[] columnNames = {"Project ID", "Project Name"};
        JTable projectNameTable = new JTable(formatedData, columnNames);
        projectNameTable.getColumnModel().getColumn(0).setPreferredWidth(50);
        projectNameTable.getColumnModel().getColumn(1).setPreferredWidth(300);
        projectNameTable.setEnabled(false);
        projectNameTable.setFocusable(false);
        // Create a scroll pane and add the projectsPanel to it
        JScrollPane scrollPane = new JScrollPane(projectNameTable);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        return scrollPane;
    }
    //used as an over-the-top title
    private JLabel projectLabel() {
        JLabel projectLabel = new JLabel("Projects");
        projectLabel.setFont(new Font("Impact",Font.BOLD,50));
        projectLabel.setFocusable(false);
        return projectLabel;
    }
    //holds instructions about the layout
    private JLabel instructionLabel() {
        JLabel instructionLabel = new JLabel(
            "Select the button labeled \"Info\" to display specific projects."
            );
        instructionLabel.setFont(new Font("Clarendon",Font.BOLD,12));
        instructionLabel.setFocusable(false);
        return instructionLabel;
    }
    //button adds a new project
    private JButton addProjectButton() {
        JButton addProjectButton = new JButton();
        addProjectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame addProjectFrame = new JFrame();
                JTextField obtainProjectName = new JTextField(10);
                JTextField obtainStartDate = new JTextField(10);
                JTextField obtainEndDate = new JTextField(10);
                JTextField obtainStatus = new JTextField(10);

                JPanel addProjectPanel = new JPanel();
                addProjectPanel.add(new JLabel("New Project Name:"));
                addProjectPanel.add(obtainProjectName);
                addProjectPanel.add(new JLabel("New Start Date:"));
                addProjectPanel.add(obtainStartDate);
                addProjectPanel.add(new JLabel("New End Date:"));
                addProjectPanel.add(obtainEndDate);
                addProjectPanel.add(Box.createHorizontalStrut(15)); // a spacer
                addProjectPanel.add(new JLabel("New Status:"));
                addProjectPanel.add(obtainStatus);
                addProjectPanel.add(new JLabel("New Team Members:"));
                String[] employees = {};
                //creates a Button to check specific employees for the team
                JButton teamSelectionButton = new JButton();
                teamSelectionButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        JFrame employeelist = new JFrame();
                        //gets the current employees from the data base in tmp
                        String[] employees = tmp.currentEmployees();
                        // Create a checkbox array for employees
                        JCheckBox[] checkBoxes = new JCheckBox[employees.length];
                        for (int i = 0; i < employees.length; i++) {
                            checkBoxes[i] = new JCheckBox(employees[i]);
                        }
                        // Create a panel to hold the checkboxes
                        JPanel panel = new JPanel();
                        panel.setLayout(new GridLayout(employees.length, 1));
                        for (JCheckBox checkBox : checkBoxes) {
                            panel.add(checkBox);
                        }
                        // Show the employee selection dialog
                        int result = JOptionPane.showConfirmDialog(employeelist, panel, "Select Employees",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                        if (result == JOptionPane.OK_OPTION) {
                            // User clicked OK, process the selected employees
                            StringBuilder selectedEmployees = new StringBuilder("Selected employees:\n");
                            for (JCheckBox checkBox : checkBoxes) {
                                if (checkBox.isSelected()) {
                                    selectedEmployees.append(checkBox.getText()).append("\n");
                                }
                            }
                            //adds selected employees to tmp
                            JOptionPane.showMessageDialog(employeelist, selectedEmployees.toString(), "Selected Employees",
                            JOptionPane.INFORMATION_MESSAGE);
                            String unformattedEmployees = selectedEmployees.toString();
                            String[] formattedEmployees = unformattedEmployees.split(", ");
                            chosenEmployees = formattedEmployees;
                            employeesChanged = true;
                        } else {
                            // User clicked Cancel or closed the dialog
                            JOptionPane.showMessageDialog(employeelist, "No employees selected.", "Info",
                            JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                });
                teamSelectionButton.setText("Team Selection");
                teamSelectionButton.setFont(new Font("Impact",Font.BOLD,10));
                teamSelectionButton.setFocusable(false);
                //adds the button to the project panel
                addProjectPanel.add(teamSelectionButton);
                int result = JOptionPane.showConfirmDialog(null, addProjectPanel, 
                        "Add Project", JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                    //TEMPARRAYS methods are here: where the edit to the data base happends
                    if (employeesChanged) {
                        boolean noInput = tmp.addProject(
                            obtainProjectName.getText(), obtainStartDate.getText(), obtainEndDate.getText(),
                            obtainStatus.getText(), chosenEmployees);
                        employeesChanged = false;
                        if (!(noInput)) {   //if there is no input generate pop up otherwise open up projectGUI
                            dispose();
                            ProjectGUI projectGUI = new ProjectGUI(tmp);
                        } else {
                            generatePopUp(2);
                        }
                    } else {
                        boolean noInput = tmp.addProject(
                            obtainProjectName.getText(), obtainStartDate.getText(), obtainEndDate.getText(),
                            obtainStatus.getText(), employees);
                        employeesChanged = false;
                        if (!(noInput)) {   //if there is no input generate pop up otherwise open up projectGUI
                            dispose();
                            ProjectGUI projectGUI = new ProjectGUI(tmp);
                        } else {
                            generatePopUp(2);
                        }
                    }
                }
            }
        });
        addProjectButton.setText("Add New Project");
        addProjectButton.setFont(new Font("Impact",Font.BOLD,10));
        addProjectButton.setFocusable(false);
        return addProjectButton;
    }
    //opens up specific projects when given a project id
    private JButton projectButton() {
        JButton projectButton = new JButton();
        //DISPLAYS MORE INFORMATION ABOUT ALL PROJECTS
        projectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //creates a new window
                JFrame validateFrame = new JFrame();
                JPanel validatePanel = new JPanel();
                validateFrame.add(validatePanel);
                validatePanel.add(new JLabel("Enter Project ID:"));
                JTextField obtainID = new JTextField(10);
                validatePanel.add(obtainID);

                int result = JOptionPane.showConfirmDialog(null, validatePanel, 
                        "HRApp.Project", JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                    //TEMPARRAYS methods are here: where the edit to the data base happends
                    if (isNumeric(obtainID.getText())) {
                        boolean found = tmp.validateProject(convert(obtainID.getText()));
                        if (found) {
                            JPanel projectInfoPanel = projectInfoPanel(convert(obtainID.getText()));
                            switchPanels(projectInfoPanel);
                        } else {
                            generatePopUp(0);
                        }
                    }
                }
            }
        });
        projectButton.setText("Info");
        projectButton.setFont(new Font("Impact",Font.BOLD,10));
        projectButton.setFocusable(false);
        return projectButton;
    }
    //opens up main GUI
    private JButton mainButton() {
        JButton mainButton = new JButton();
        mainButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                MainGUI mainGUI = new MainGUI(tmp);
            }
        });
        mainButton.setText("Return to Main Menu");
        mainButton.setFont(new Font("Impact",Font.BOLD,20));
        mainButton.setFocusable(false);
        return mainButton;
    }
    //creates a pop up to tell the user something is wrong
    private void generatePopUp(int index) {
        JFrame popUp = new JFrame();
        if (index == 0) {
            JOptionPane.showMessageDialog(popUp, "Project ID NOT FOUND");
        } else if (index == 1) {
            JOptionPane.showMessageDialog(popUp, "INCORRECT INPUT");
        } else if (index == 2) {
            JOptionPane.showMessageDialog(popUp, "NO INPUT DETECTED");
        }
    }
    //used to switch the panels
    private void switchPanels(JPanel panel) {
        getContentPane().removeAll();
        getContentPane().add(panel);
        getContentPane().revalidate();
        getContentPane().repaint();
    }
    //checks if int
    public boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            generatePopUp(1);
            return false;
        }
    }
    //converts to int
    public int convert(String str) {
        int val = 0;
        // Convert the String
        try {
            val = Integer.parseInt(str);
        }
        catch (NumberFormatException e) {
            System.out.println("ERROR NUMBERFORMAT");
        }
        return val;
    }
    
}
