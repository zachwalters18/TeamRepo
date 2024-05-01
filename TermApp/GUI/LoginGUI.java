package TermApp.GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import TermApp.TEMPARRAYS;

public class LoginGUI extends JFrame {
    private TEMPARRAYS tmp;
    //these will be used to switch between and reload the different panels
    private JPanel loginPanel = loginPanel();
    private JPanel createUserPanel = createUserPanel();
    //constructor for the login GUI
    public LoginGUI(TEMPARRAYS tmp) {
        this.tmp = tmp;
        this.setTitle("HRApp.Login");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        //add the login panel to the frame
        this.add(loginPanel, BorderLayout.CENTER);
        //this.add(createUserPanel, BorderLayout.CENTER);
        this.setSize(350, 500);
        this.setResizable(false);       //frame cannot resize
        this.setLocationRelativeTo(null);       //frame launches in the middle of the screen
    }
        //creates a layered panel containing the login information
        private JPanel loginPanel() {
            JPanel loginPanel = new JPanel();
            //all of the information is added in order
            loginPanel.setLayout(new GridLayout(6,1, 0, 0));
            loginPanel.add(loginLabel());
            JTextField obtainUsername = obtainUsername();
            JTextField obtainPassword = obtainPassword();
            loginPanel.add(obtainUsername);
            loginPanel.add(obtainPassword);
            loginPanel.add(loginButton(obtainUsername, obtainPassword));
            loginPanel.add(noUserLabel());
            loginPanel.add(openCreateUserButton());
            return loginPanel;
        }
        //creates a label describing instruction for logging in
        private JLabel loginLabel() {
            JLabel loginLabel = new JLabel("Enter username and password to login:");
            loginLabel.setFont(new Font("Clarendon",Font.PLAIN,15));
            loginLabel.setFocusable(false);
            return loginLabel;
        }
        //asks user if they dont have a user
        private JLabel noUserLabel() {
            JLabel noUserLabel = new JLabel("Don't have an account?");
            noUserLabel.setFont(new Font("Clarendon",Font.PLAIN,15));
            noUserLabel.setFocusable(false);
            return noUserLabel;
        }
        //these textfields are used to login into an user
        //textfield for the username
        protected JTextField obtainUsername() {
            JTextField obtainUsername = new JTextField();
            obtainUsername.setFont(new Font("Clarendon",Font.PLAIN,15));
            setPreferredSize(new Dimension(250, 40));
            return obtainUsername;
        }
        //textfield for the password
        protected JTextField obtainPassword() {
            JTextField obtainPassword = new JTextField();
            obtainPassword.setFont(new Font("Clarendon",Font.PLAIN,15));
            obtainPassword.setPreferredSize(new Dimension(250, 40));
            return obtainPassword;
        }
        //creates a button to login once information is collected
        private JButton loginButton(JTextField obtainUsername, JTextField obtainPassword) {
            JButton loginButton = new JButton();
            //choice to determine which popup
            int choice = 0;
            //button will validate username and password to log user in
            loginButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String username = obtainUsername.getText();
                    String password = obtainPassword.getText();
                    boolean found = tmp.logInUser(username, password);
                    if (found) {
                        dispose();
                        MainGUI mainGUI = new MainGUI(tmp);
                    } else {
                        generatePopUp(choice);
                    }
                }
            });
            loginButton.setText("LOGIN");
            loginButton.setFont(new Font("Impact",Font.BOLD,25));//font, style, and font size
            loginButton.setFocusable(false);
            return loginButton;
        }
        //creates a button to open a new panel
        private JButton openCreateUserButton() {
            JButton openCreateUserButton = new JButton();
            //button's action: to switch the panel from login to createUser
            openCreateUserButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    switchPanels(createUserPanel);
                    //reloads the panel and textfield
                    loginPanel = loginPanel();
                }
            });
            openCreateUserButton.setText("Create New Account");
            openCreateUserButton.setFont(new Font("Impact",Font.BOLD,25));//font, style, and font size
            openCreateUserButton.setFocusable(false);
            return openCreateUserButton;
        }
        //***********createUserPane and its methods***************
        private JPanel createUserPanel() {
            JPanel createUserPanel = new JPanel();
            createUserPanel.setLayout(new GridLayout(5,1, 0, 0));
            createUserPanel.add(loginReturnButton());
            createUserPanel.add(createUserLabel());
            JTextField obtainUsername = obtainUsername();
            JTextField obtainPassword = obtainPassword();
            createUserPanel.add(obtainUsername);
            createUserPanel.add(obtainPassword);
            createUserPanel.add(createUserButton(obtainUsername, obtainPassword));
            return createUserPanel;
        }
        //creates a label describing instruction for creating a new user
        private JLabel createUserLabel() {
            JLabel createUserLabel = new JLabel("Create a new username and password:");
            createUserLabel.setFont(new Font("Clarendon",Font.PLAIN,15));
            createUserLabel.setFocusable(false);
            return createUserLabel;
        }
        //creates a button to create a new user once information is collected
        private JButton createUserButton(JTextField obtainUsername, JTextField obtainPassword) {
            JButton createUserButton = new JButton();
            //choice to determine which popup
            int choice = 1;
            //creates a new User with the information supplied by its textfields
            createUserButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String username = obtainUsername.getText();
                    String password = obtainPassword.getText();
                    boolean unique = tmp.addUser(username, password);
                    if (unique) {
                        //switches back to the login
                        switchPanels(loginPanel);
                        //reloads the panel
                        createUserPanel = createUserPanel();
                    } else {
                        generatePopUp(choice);
                    }
                }
            });
            createUserButton.setText("Create New Account");
            createUserButton.setFont(new Font("Impact",Font.BOLD,25));
            createUserButton.setFocusable(false);
            return createUserButton;
        }
        //return to login button
        private JButton loginReturnButton() {
            JButton loginReturnButton = new JButton();
            //button's action: to switch the panel from login to createUser
            loginReturnButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    switchPanels(loginPanel);
                    //reloads the panel
                    loginPanel = loginPanel();
                }
            });
            loginReturnButton.setText("Return to Login ->");
            loginReturnButton.setFont(new Font("Impact",Font.BOLD,25));
            loginReturnButton.setFocusable(false);
            return loginReturnButton;
        }
        //creates a pop up to tell the user that the username or password is wronge or to change the username
        private void generatePopUp(int choice) {
            JFrame popUp = new JFrame();
            if (choice == 0) {
                JOptionPane.showMessageDialog(popUp, "INCORRECT INFORMATION\nPlease re-enter username or password.");
                //System.out.println("Checking choice 0");
            } else if (choice == 1) {
                JOptionPane.showMessageDialog(popUp, "Username has already been taken.\nPlease choose a different username.");
                //System.out.println("Checking choice 1");
            }
        }
        //used to switch the panels
        private void switchPanels(JPanel panel) {
            getContentPane().removeAll();
            getContentPane().add(panel, BorderLayout.CENTER);
            getContentPane().revalidate();
            getContentPane().repaint();
        }
}
