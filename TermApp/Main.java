package TermApp;

import java.util.Scanner;
import java.util.ArrayList;

public class Main extends TEMPARRAYS{
    static Scanner scnr = new Scanner(System.in);
    public static void main(String[] args) {
        /*
        TEMPARRAYS temp = new TEMPARRAYS();
        //creating fake information
        temp.setFakeLog();
        temp.createFakeUsers();
        temp.createFakeProjects();
        //input information (will be replaced with GUI)
        int givenID;
        String givenUsername;
        String givenPassword;
        String givenProjectName;
        String givenStartDate;
        String givenEndDate;
        String givenStatus;
        boolean closeProgram = false;
        String index = "";
        //testing code (we should mostly develop the app to work in the console first)
        //loops until option to close program is chosen
        //Testing code for users
        while(!closeProgram) {
            System.out.println("Select an option by inputting its index: ");
            System.out.println("1.Log in\n2.Create a new User\n3.Edit User\n4.Delete User\n5.Display Users\n6.Log out\n7.Close Program");
            index = scnr.nextLine();
            //depending on the input an option will be chosen
            if (index.equals("1")) {
                System.out.println("Input username to log in:");
                givenUsername = scnr.nextLine();
                System.out.println("Input password to log in:");
                givenPassword = scnr.nextLine();
                temp.logInUser(givenUsername, givenPassword);
            } else if (index.equals("2")) {
                System.out.println("In order to add a new user:\nInput a username:");
                givenUsername = scnr.nextLine();
                System.out.println("Input a password:");
                givenPassword = scnr.nextLine();
                temp.addUser(givenUsername, givenPassword);
            } else if (index.equals("3")) {
                System.out.println("Input an ID to find this user: ");
                givenID = scnr.nextInt();
                temp.updateUser(givenID);
            } else if (index.equals("4")) {
                System.out.println("Input an ID to find this user: ");
                givenID = scnr.nextInt();
                temp.deleteUser(givenID);
            } else if (index.equals("5")) {
                temp.displayAllUsers();
            } else if (index.equals("6")) {
                temp.logOutUser();
            } else if (index.equals("7")) {
                System.out.println("Terminating Program...");
                closeProgram = true;
            } else {
                System.out.println("INCORRECT INPUT ");
            }
        }
        //testing code for projects
        while(!closeProgram) {
            System.out.println("Select an option by inputting its index: ");
            System.out.println("1.Create new Project\n2.Edit a project\n3.Delete a project\n4.Display all projects' IDs\n5.Close Program");
            index = scnr.nextLine();

            if (index.equals("1")) {
                System.out.println("In order to create a new project...\nInput a project name:");
                givenProjectName = scnr.nextLine();
                System.out.println("Input a start date (00/00/00):");
                givenStartDate = scnr.nextLine();
                System.out.println("Input a end date (00/00/00):");
                givenEndDate = scnr.nextLine();
                System.out.println("Input the project's status:");
                givenStatus = scnr.nextLine();
                temp.addProject(givenProjectName, givenStartDate, givenEndDate, givenStatus);
            } else if (index.equals("2")) {
                System.out.println("Input ID to locate project:");
                givenID = scnr.nextInt();
                temp.updateProject(givenID);
            } else if (index.equals("3")) {
                System.out.println("Input a project's ID:");
                givenID = scnr.nextInt();
                temp.deleteProject(givenID);
            } else if (index.equals("4")) {
                temp.displayAllProjects();
            } else if (index.equals("5")) {
                System.out.println("Terminating Program...");
                closeProgram = true;
            } else {
                System.out.println("INCORRECT INPUT ");
            }
        }
        */
    }
}