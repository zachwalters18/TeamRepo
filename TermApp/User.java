package TermApp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class User extends TEMPARRAYS{
    Scanner scnr = new Scanner(System.in);
    private String userID;
    private String username;
    private String password;
    private Boolean loggedIn = false;
    //default constructors
    public User() {

    }

    public User(String givenUsername, String givenPassword) {
        setUserID(createNewUserID());
        setUsername(givenUsername);
        setPassword(givenPassword);
    }
    //setters
    public void setUserID(String userID) {
        this.userID = userID;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    //getters
    public String getUserID() {
        return userID;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    //creates a new user ID, validates it, and returns it
    public int createNewUserID() {
        Object[] users = getUsers();
        int newUserID = 0;
        while (!(filteredUsers.isEmpty())) {        //when filteredUsers is empty, a new ID is made
            newUserID = (int)(Math.random() * 100);  //only 100 IDs available
            List<User> filteredUsers = users.stream()
                .filter(user -> 
                    user.getUserID.equals(newUserID))
                .collect(Collectors.toList());
        }
        return newUserID;
    }
    //checks for correct username and password then logs in by setting loggedIn to true
    public void logIn(String givenUsername, String givenPasword) {
        while (loggedIn) {
            this.loggedIn = validateUser(givenUsername, givenPassword);
        }

    }
    //log out -> loggedIn = false
    public void logOut() {
        this.loggedIn = false;
    }
    //validates User when given username and password and searches for a match
    public boolean validateUser(String givenUsername, String givenPassword) {
        ArrayList<User> users = getUsers();
        //stream checks any user with same username or password
        List<User> filteredUsers = users.stream()
            .filter(user -> 
                user.getUsername().equals(givenUsername)
                &&
                user.getPassword().equals(givenPassword))
            .collect(Collectors.toList());

        if (filteredUsers.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
}