package TermApp.GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import TermApp.TEMPARRAYS;

public class ProfileGUI extends JFrame {
    private TEMPARRAYS tmp;

    public ProfileGUI(TEMPARRAYS tmp) {
        this.tmp = tmp;
        this.setTitle("HRApp.Profile");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        this.setLayout(null);
        //adding panels to the frame
        JButton mainButton = mainButton();
        this.add(mainButton);
        mainButton.setBounds(250,0,150,30);
        JPanel photoPanel = photoPanel();
        this.add(photoPanel);
        photoPanel.setBounds(0,30,200,370);
        JPanel userPanel = userPanel(tmp);
        this.add(userPanel);
        userPanel.setBounds(200,30,200,370);
    }
    //user panel allows displaying and editing
    private JPanel userPanel(TEMPARRAYS tmp) {
        JPanel userPanel = new JPanel();
        userPanel.setLayout(null);
        //add label and button
        JLabel userLabel = userLabel(tmp);
        JButton editButton = editButton(tmp);
        userPanel.add(userLabel);
        userPanel.add(editButton);
        //set each position
        userLabel.setBounds(50,75, 200, 75);
        editButton.setBounds(50,175, 100, 50);
        return userPanel;
    }
    //label for username and password
    private JLabel userLabel(TEMPARRAYS tmp) {
        JLabel userLabel = new JLabel();
        //displays username and password
        String username = tmp.getLoggedInUsername();
        String password = tmp.getLoggedInPassword();

        userLabel.setText("<html>Username:<br/>" + username + "<br/>Password:<br/>" + password + "</html>");
        userLabel.setFont(new Font("Clarendon",Font.PLAIN,15));
        return userLabel;
    }
    //button to edit user
    private JButton editButton(TEMPARRAYS tmp) {
        JButton editButton = new JButton("EDIT");
        editButton.addActionListener(new ActionListener() {
            //FIXME SOMETHING IS WRONGE
            public void actionPerformed(ActionEvent e) {
                JFrame editFrame = new JFrame();
                JTextField obtainUsername = new JTextField(10);
                JTextField obtainPassword = new JTextField(10);

                JPanel editPanel = new JPanel();
                editPanel.add(new JLabel("Enter New Username:"));
                editPanel.add(obtainUsername);
                editPanel.add(Box.createHorizontalStrut(15)); // a spacer
                editPanel.add(new JLabel("Enter New Password:"));
                editPanel.add(obtainPassword);

                int result = JOptionPane.showConfirmDialog(null, editPanel, 
                        "Edit User", JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                    //TEMPARRAYS methods are here: where the edit to the data base happends
                    boolean unique = tmp.updateUser(tmp.getLoggedInID(), obtainUsername.getText(), obtainPassword.getText());
                    if (unique) {
                        dispose();
                        ProfileGUI profileGUI = new ProfileGUI(tmp);
                    } else {
                        generatePopUp();
                    }
                }
            }
        });
        editButton.setFont(new Font("Impact",Font.BOLD,20));
        editButton.setFocusable(false);
        return editButton;
    }
    //photo panel displays the user's photo
    private JPanel photoPanel() {
        JPanel photoPanel = new JPanel();
        photoPanel.setBackground(Color.blue);
        photoPanel.add(photoLabel());
        return photoPanel;
    }

    private JLabel photoLabel() {
        JLabel photoLabel = new JLabel();
        photoLabel.setText("<html><font color='white'>NO PHOTO FOUND</font></html>");
        photoLabel.setFont(new Font("Clarendon",Font.BOLD,15));
        return photoLabel;
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
        mainButton.setFont(new Font("Impact",Font.BOLD,15));
        mainButton.setFocusable(false);
        return mainButton;
    }
    //creates a pop up to tell the user that the username or password is wronge or to change the username
    private void generatePopUp() {
        JFrame popUp = new JFrame();
        JOptionPane.showMessageDialog(popUp, "Username has already been taken.\nPlease choose a different username.");
    }
}
