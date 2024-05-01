package TermApp;

import java.util.ArrayList;
import java.util.Scanner;

public class User extends TEMPARRAYS{
    Scanner scnr = new Scanner(System.in);
    private int userID;
    //username needs to be public to be validated in validateUsername()
    public String username;
    protected String password;
    //used in TEMPARRAYS
    protected Boolean loggedIn = false;
    //default constructors
    public User() {

    }

    public User(String givenUsername, String givenPassword, int givenID) {
        setUserID(givenID);
        setUsername(givenUsername);
        setPassword(givenPassword);
    }
    //setters
    protected void setUserID(int userID) {
        this.userID = userID;
    }
    protected void setUsername(String username) {
        this.username = username;
    }
    protected void setPassword(String password) {
        this.password = password;
    }
    //getters
    protected int getUserID() {
        return userID;
    }
    protected String getUsername() {
        return username;
    }
    protected String getPassword() {
        return password;
    }
    //locates User
    protected User findUser(ArrayList<User> users, int givenUserID) {
        boolean noUserfound = true;
        User selectedUser = new User("temp", "temp", 0);
        while (noUserfound) {
            //loop checks any user with same ID
            if (givenUserID == 0) {
                System.out.println("Test user identified!");
                break;
            }
            for (User user : users) {
                if ((user.getUserID() == givenUserID)) {
                    noUserfound = false;
                    selectedUser = user;
                    break;
                }
            }
            //if user is not found, re-enter information.
            if (noUserfound && givenUserID != 0) {
                System.out.println("INCORRECT INFORMATION");
                System.out.println("Re-enter User ID: ");
                givenUserID = scnr.nextInt();
            }
        }
        return selectedUser;
    }
    //loggedIn sets to true or false
    //logIn -> loggedIn = true
    protected void logIn() {
        this.loggedIn = true;
    }
    //log out -> loggedIn = false
    protected void logOut() {
        this.loggedIn = false;
    }
}