package TermApp.GUI;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import TermApp.TEMPARRAYS;

public class ProjectGUI extends JFrame{
    private TEMPARRAYS tmp;
    private JPanel projectsPanel = projectsPanel();
    private JLabel projectLabel = projectLabel();
    private JLabel instructionsLabel = instructionLabel();
    private JButton mainButton = mainButton();

    public ProjectGUI(TEMPARRAYS tmp) {
        this.tmp = tmp;
        this.setTitle("HRApp.Project");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 800);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        //be sure to add componets before the pack()
        this.add(projectsPanel);
        projectsPanel.setBounds(0,200,800,600);
        this.add(projectLabel);
        projectLabel.setBounds(10,10,200,100);
        this.add(instructionsLabel);
        instructionsLabel.setBounds(10, 150, 600, 50);
        this.add(mainButton);
        mainButton.setBounds(550,0,250,50);
    }

    private JPanel projectsPanel() {
        JPanel projectsPanel = new JPanel();
        projectsPanel.setBackground(Color.lightGray);
        projectsPanel.setLayout(new FlowLayout(0));
        projectsPanel.add(specificProjectLabel());
        projectsPanel.add(projectButton());
        return projectsPanel;
    }
    //elements belonging to the projectsPanel
    private JButton projectButton() {
        JButton projectButton = new JButton();
        //DISPLAYS MORE INFORMATION ABOUT ALL PROJECTS
        projectButton.setText("Info");
        projectButton.setFont(new Font("Impact",Font.BOLD,10));
        projectButton.setFocusable(false);
        return projectButton;
    }

    private JLabel specificProjectLabel() {
        JLabel specificProjectLabel = new JLabel("current project");
        specificProjectLabel.setSize(25,800);
        specificProjectLabel.setFont(new Font("Clarendon",Font.BOLD,15));
        specificProjectLabel.setFocusable(false);
        return specificProjectLabel;
    }
    //elements belonging to the tab of projectButton
    //panel containing information
    private JPanel projectInfoPanel() {
        JPanel projectInfoPanel = new JPanel();
        projectInfoPanel.setLayout(new FlowLayout(0));
        projectInfoPanel.add(selectedProject());
        projectInfoPanel.add(editButton());
        projectInfoPanel.add(deleteButton());
        return projectInfoPanel;
    }
    //more information stored on the project
    private JLabel selectedProject() {
        JLabel instructionLabel = new JLabel();
        instructionLabel.setFont(new Font("Clarendon",Font.BOLD,20));
        instructionLabel.setFocusable(false);
        return instructionLabel;
    }
    //button to edit project information
    private JButton editButton() {
        JButton editButton = new JButton();
        //DISPLAYS MORE INFORMATION ABOUT ALL PROJECTS
        editButton.setText("EDIT");
        editButton.setFont(new Font("Impact",Font.BOLD,10));
        editButton.setFocusable(false);
        return editButton;
    }
    //button to delete project information
    private JButton deleteButton() {
        JButton deleteButton = new JButton();
        //DISPLAYS MORE INFORMATION ABOUT ALL PROJECTS
        deleteButton.setText("DELETE");
        deleteButton.setFont(new Font("Impact",Font.BOLD,10));
        deleteButton.setFocusable(false);
        return deleteButton;
    }
    //GUI elements on the frame
    //used as an over-the-top title
    private JLabel projectLabel() {
        JLabel projectLabel = new JLabel("Projects");
        projectLabel.setFont(new Font("Clarendon",Font.BOLD,50));
        projectLabel.setFocusable(false);
        return projectLabel;
    }
    //holds instructions about the layout
    private JLabel instructionLabel() {
        JLabel instructionLabel = new JLabel(
            "Either select \"DISPLAY ALL\" to display all projects or select specific info tabs."
            );
        instructionLabel.setFont(new Font("Clarendon",Font.BOLD,15));
        instructionLabel.setFocusable(false);
        return instructionLabel;
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
    
}
