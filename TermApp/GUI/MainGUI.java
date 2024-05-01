package TermApp.GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import TermApp.TEMPARRAYS;

public class MainGUI extends JFrame{
    private TEMPARRAYS tmp;
    private JPanel dataPanel = dataPanel();

    public MainGUI(TEMPARRAYS tmp) {
        this.tmp = tmp;
        this.setTitle("HRApp.Main");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 800);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        //be sure to add componets before the pack()
        this.setJMenuBar(menuBar());
        this.add(welcomeLabel(), BorderLayout.PAGE_START);
        this.add(dataPanel, BorderLayout.CENTER);     //call methods within the add()
    }
    private JPanel dataPanel() {
        JPanel dataPanel = new JPanel();
        dataPanel.setLayout(null);
        JLabel employeeLabel = employeeLabel();
        JButton employeeButton = employeeButton();
        JLabel projectLabel = projectLabel();
        JButton projectButton = projectButton();
        dataPanel.add(employeeLabel);
        dataPanel.add(projectLabel);
        dataPanel.add(employeeButton);
        dataPanel.add(projectButton);
        employeeLabel.setBounds(150,0,200,100);
        projectLabel.setBounds(450,0,200,100);
        employeeButton.setBounds(175,100,150,75);
        projectButton.setBounds(475,100,150,75);
        return dataPanel;
    }
    private JLabel welcomeLabel() {
        JLabel welcomeLabel = new JLabel("Welcome " + tmp.getLoggedInUsername() + "!",SwingConstants.CENTER);
        welcomeLabel.setPreferredSize(new Dimension(100, 50));
        welcomeLabel.setFont(new Font("Clarendon",Font.BOLD,15));
        welcomeLabel.setFocusable(false);
        return welcomeLabel;
    }
    private JLabel employeeLabel() {
        JLabel employeeLabel = new JLabel(
            "<html><div style='text-align: center;'>Select \"EMPLOYEES\" to examine specific employees.</div></html>"
        );
        employeeLabel.setFont(new Font("Clarendon",Font.PLAIN,15));
        employeeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        return employeeLabel;
    }

    private JLabel projectLabel() {
        JLabel projectLabel = new JLabel(
            "<html><div style='text-align: center;'>Select \"PROJECTS\" to examine entire projects.</div></html>"
        );
        projectLabel.setFont(new Font("Clarendon",Font.PLAIN,15));
        projectLabel.setHorizontalAlignment(SwingConstants.CENTER);
        return projectLabel;
    }

    private JButton employeeButton() {
        JButton employeeButton = new JButton();
        employeeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //FIXME calls employee GUI
                dispose();
                EmployeeGUI employeeGUI = new EmployeeGUI(tmp);
            }
        });
        employeeButton.setText("EMPLOYEES");
        employeeButton.setFont(new Font("Impact",Font.BOLD,20));
        employeeButton.setFocusable(false);
        return employeeButton;
    }

    private JButton projectButton() {
        JButton projectButton = new JButton();
        projectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                ProjectGUI projectGUI = new ProjectGUI(tmp);
            }
        });
        projectButton.setText("PROJECTS");
        projectButton.setFont(new Font("Impact",Font.BOLD,20));
        projectButton.setFocusable(false);
        return projectButton;
    }

    private JMenuBar menuBar() {
        JMenuBar menuBar = new JMenuBar();
        //sets the menus to the right of the menu bar
        menuBar.add(Box.createHorizontalGlue());
        //create menus to the menu bar
        JMenu menu = new JMenu("Menu");
        //create menu items for the menu
        JMenuItem profileMenu = new JMenuItem("Profile");
        profileMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                ProfileGUI profileGUI = new ProfileGUI(tmp);
            }
        });
        JMenuItem settingsMenu = new JMenuItem("Settings");
        settingsMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("SETTINGS");
            }
        });
        JMenuItem logOutMenu = new JMenuItem("Log Out");
        logOutMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("LOG OUT");
            }
        });
        //adding in order
        menu.add(profileMenu);
        menu.add(settingsMenu);
        menu.add(logOutMenu);
        menuBar.add(menu);
        return menuBar;
    }
    //actionlister for all menu items
}