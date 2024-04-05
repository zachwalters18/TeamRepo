package TermApp;

import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Stream;
//FIXME I NEED CONSTRUCTOR!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
public class User extends TEMPARRAYS implements Helper{
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

    //other methods
    //adds a new user to the user array
    private void addUser() {
        User newUser = new User();
        //FIXME Add random ids with unique characters
        newUser.setUserID(" ");
        newUser.setUsername(nextLine("Enter new username: "));
        newUser.setPassword(nextLine("Enter new password: "));
        //FIXME add the newUser to the array
        users.add(newUser);
    }

    private void updateUser() {
        //FIXME updates new information to user
    }

    private void deleteUser() {
        //FIXME Delete user from user array
    }
    //creates a new user ID, validates it, and adds it
    public createNewUserID() {
        boolean isNewUserID = true;
        //while false
        while(!isNewUserID()) {
            String newUserID = "";
            int range;
            for (int i = 0; i <= 8; i++) {
                if (i = 0) {
                    range = (90 - 65) + 1;                                  //range is determined
                    newUserID += (char)((int)(Math.random() * range) + 65); //the first character of newUserID is a letter
                } else {
                    range = (9 - 0) + 1;
                    newUserID += String((int)(Math.random() * range) + 0);  //the rest of the string is numbers (0-9)
                }
            }
            isNewUserID = validateID(newUserID);                            //validates the newUserID
        }
    }

    public boolean validateUser(String givenUsername, String givenPassword) {
        boolean isUser = false;
        //FIXME uses streams to find a user in users with the same username and password
        return isUser;
    }
    //validates username and password for login by setting loggedIn to true
    public void logIn() {
        String givenUsername;
        String givenPassword;
        while (loggedIn) {
            System.out.println("Please enter your username:");
            givenUsername = scnr.nextLine();
            System.out.println("Please enter your password: ");
            givenPassword = scnr.nextLine();
            this.loggedIn = validateUser(givenUsername, givenPassword);
        }

    }
    //log out -> loggedIn = false
    public void logOut() {
        this.loggedIn = false;
    }

    //FIXME this is for the data
    public void createFakeUsers() {
        //creates 3 fake users
        User fake1 = new User();
        fake1.setUserID("M9102345");
        fake1.setUsername("player12");
        fake1.setPassword("memeLord123");
        User fake2 = new User();
        fake2.setUserID("T1324234");
        fake2.setUsername("LOOK1");
        fake2.setPassword("password");
        User fake3 = new User();
        fake3.setUserID("A1285321");
        fake3.setUsername("David");
        fake3.setPassword("ijustdo");
        //adds fake users to arrayList "users"
        users.add(fake1);
        users.add(fake2);
        users.add(fake3);
    }
}
