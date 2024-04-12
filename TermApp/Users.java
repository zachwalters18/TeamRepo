package TermApp;

import java.util.Scanner;

public class Users implements Helper{
    Scanner scnr = new Scanner(System.in);
    private String userID;
    private String username;
    private String password;
    private Boolean loggedIn = false;
    //setters
    private void setUserID(String userID) {
        this.userID = userID;
    }
    private void setUsername(String username) {
        this.username = username;
    }
    private void setPassword(String password) {
        this.password = password;
    }
    //getters
    private String getUserID() {
        return userID;
    }
    private String getUsername() {
        return username;
    }
    private String getPassword() {
        return password;
    }

    //other methods
    private void addUser() {
        //FIXME Add user to the user array
        //FIXME include username and password and userID
    }

    private void updateUser() {
        //FIXME updates new information to user
    }

    private void deleteUser() {
        //FIXME Delete user from user array
    }
    //overrides the interface
    public boolean validateUser(String givenUsername, String givenPassword) {
        boolean isUser = false;
        if ((username == givenUsername) && (password == givenPassword)) {
            isUser = true;
        } else {
            System.out.println("INCORRECT");
            //FIXME Should I make it more specific?
        }
        return isUser;
    }

    public void logIn() {
        String givenUsername;
        String givenPassword;
        while (loggedIn) {
            System.out.println("Please enter your username:");
            givenUsername = scnr.nextLine();
            System.out.println("Please enter your password: ");
            givenPassword = scnr.nextLine();
            loggedIn = validateUser(givenUsername, givenPassword);
        }

    }

    public void logOut() {
        loggedIn = false;
    }
}
