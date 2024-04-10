/*
package TermApp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class User {
    Scanner scnr = new Scanner(System.in);
    private String userID;
    private String username;
    private String password;
    private Boolean loggedIn = false;
    //default constructor
    public User() {

    }
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
    //adds a new user to the user array
    public void addUser(int givenUserID, String givenUsername, String givenPassword) {
        User newUser = new User();
        newUser.setUserID(givenUserID);
        newUser.setUsername(givenUsername);
        newUser.setPassword(givenPassword);
        //user is added to "users" array list
        ArrayList<User> updatedUsers = getUsers();
        updatedUsers.add(newUser);
        setUsers(updatedUsers);
    }
    //username and password are able to be edited
    public void updateUser(int givenUserID, String givenUsername, String givenPassword) {
        User selectedUser = findUser(   //locates user
            givenUsername,
            givenPassword,
            givenUserID          //FIXME should i check for an integer?
        );
        ArrayList<User> updatedUsers = getUsers();
        updatedUsers.remove(selectedUser);          //removes old user
        String newUsername = scnr.nextLine();
        String newPassword = scnr.nextLine();
        selectedUser.setUsername(newUsername); //update username
        selectedUser.setPassword(newPassword); //update password
        updatedUsers.add(newUser);                  //adds updated user
        setUsers(updatedUsers);
    }
    //deletes selected user
    private void deleteUser(int givenUserID, String givenUsername, String givenPassword) {
        User selectedUser = findUser(   //locates user
            givenUsername,
            givenPassword,
            givenUserID
        );
        //selected user is deleted from "users" array list
        ArrayList<User> updatedUsers = getUsers();
        updatedUsers.remove(selectedUser);
        setUsers(updatedUsers);
    }
    //creates a new user ID, validates it, and returns it
    private int createNewUserID() {
        ArrayList<User> users = getUsers();
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
    //locates user with the givens then outputs that user
    private User findUser(String givenUsername, String givenPassword, int givenUserID) {
        ArrayList<User> users = getUsers();
        while (noUserfound) {
            List<User> filteredUsers = users.stream()   //stream checks any user with same username or password
                .filter(user -> 
                    user.getUsername().equals(givenUsername)
                    &&
                    user.getPassword().equals(givenPassword)
                    &&
                    user.getUserID().equals(givenID))
                .collect(Collectors.toList());
            //checks if user is found
            boolean noUserfound = true;
            if (filteredUsers.isEmpty()) {  
                //FIXME I CANNOT DO THIS UNTIL I GET ARRAY LIST HERE
            } else {
                noUserfound = false;
                User selectedUser = filteredUsers.get(0);
            }
        }
        return selectedUser;
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
    private boolean validateUser(String givenUsername, String givenPassword) {
        ArrayList<User> users = getUsers();
        List<User> filteredUsers = users.stream()   //stream checks any user with same username or password
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
    //FIXME this is for the data
    public void createFakeUsers() {
        //creates 3 fake users
        User fake1 = new User();
        fake1.setUserID(1);
        fake1.setUsername("player12");
        fake1.setPassword("memeLord123");
        User fake2 = new User();
        fake2.setUserID(3);
        fake2.setUsername("LOOK1");
        fake2.setPassword("password");
        User fake3 = new User();
        fake3.setUserID(2);
        fake3.setUsername("David");
        fake3.setPassword("ijustdo");
        //adds fake users to arrayList "users"
        ArrayList<User> updatedUsers = getUsers();
        updatedUsers.add(fake1);
        updatedUsers.add(fake2);
        updatedUsers.add(fake3);
    }
}
*/