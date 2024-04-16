package TermApp;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Scanner;

public class TEMPARRAYS {

    private ArrayList<ArrayList> arrays;
    public Scanner scnr = new Scanner();
    //public constructor
    public TEMPARRAYS() {
        ArrayList<User> users = new ArrayList<User>();
        arrays.add(users);
        ArrayList<Team> teams = new ArrayList<Team>();
        arrays.add(teams);
        ArrayList<Project> projects = new ArrayList<Project>();
        array.add(projects);
    //decide what to do later
    private ArrayList<Object[]> arrays;
    private Object[] Managers;
    Scanner scn = new Scanner(System.in);

    public TEMPARRAYS() {
        arrays = new ArrayList<>();
        Managers = new Object[30];
        arrays.add(Managers);
    }

    // Method to add an item to an array
    public void addItemToArray(int arrayIndex, Object item) {
        if (arrayIndex >= 0 && arrayIndex < arrays.size()) {
            arrays.get(arrayIndex)[arrays.get(arrayIndex).length - 1] = item;
        } else {
            System.err.println("Array index out of bounds");
        }
    }

    // Method to edit an item in an array
    public void editItemInArray(int arrayIndex, int itemIndex, Object newItem) {
        if (arrayIndex >= 0 && arrayIndex < arrays.size()) {
            if (itemIndex >= 0 && itemIndex < arrays.get(arrayIndex).length) {
                arrays.get(arrayIndex)[itemIndex] = newItem;
            } else {
                System.err.println("Item index out of bounds");
            }
        } else {
            System.err.println("Array index out of bounds");
        }
    }

    // Method to delete an item from an array
    public void deleteItemFromArray(int arrayIndex, int itemIndex) {
        if (arrayIndex >= 0 && arrayIndex < arrays.size()) {
            if (itemIndex >= 0 && itemIndex < arrays.get(arrayIndex).length) {
                Object[] array = arrays.get(arrayIndex);
                Object[] newArray = new Object[array.length - 1];
                int newIndex = 0;
                for (int i = 0; i < array.length; i++) {
                    if (i != itemIndex) {
                        newArray[newIndex++] = array[i];
                    }
                }
                arrays.set(arrayIndex, newArray);
            } else {
                System.err.println("Item index out of bounds");
            }
        } else {
            System.err.println("Array index out of bounds");
        }
    }

    // Method to read all the items in an array
    public void readItemsInArray(int arrayIndex) {
        if (arrayIndex >= 0 && arrayIndex < arrays.size()) {
            Object[] array = arrays.get(arrayIndex);
            System.out.print("Items in array " + arrayIndex + ": ");
            for (Object item : array) {
                System.out.print(item + " ");
            }
            System.out.println();
        } else {
            System.err.println("Array index out of bounds");
        }
    }

    public void addManager()
    {
        int index = 0;
        while (index < Managers.length && Managers[index] != null) 
        {
            index++;
        }

        // Check if there is space in the array
        if (index < Managers.length) 
        {
            System.out.println("Enter Manager First Name:");
            String firstName = scn.nextLine();

            System.out.println("Enter Manager Last Name:");
            String lastName = scn.nextLine();

            System.out.println("Enter Manager Phone Number:");
            long phoneNumber = scn.nextLong();
            scn.nextLine();

            System.out.println("Enter Manager Physical Address:");
            String address = scn.nextLine();

            System.out.println("Enter Manager Email Address");
            String emailAddress = scn.nextLine();

            System.out.println("Enter Manager Manager ID:");
            String managerID = scn.nextLine();

            Managers[index] = new Manager(firstName, lastName, phoneNumber, address, emailAddress, managerID);
        } else {
            System.out.println("Array is full, cannot add more objects.");
        }
    }

    // Method to add a new array
    public void addArray(Object[] newArray) {
        arrays.add(newArray);
    }

    //USERS
    //getter for users
    public void getUsers() {
        return users;
    }
    //a new User is created and added to the users array
    public void addUser(String givenUsername, String givenPassword) {  
        User newUser = new User();
        newUser.setUserID(createNewUserID());
        newUser.setUsername(givenUsername);
        newUser.setPassword(givenPassword);
        //user is added to "users" array list
        ArrayList<User> updatedUsers = getUsers();
        updatedUsers.add(newUser);
        setUsers(updatedUsers);
    }
    //username and password are able to be edited
    public void updateUser(int givenUserID, String givenUsername, String givenPassword) {
        User selectedUser = findUser(               //locates user
            givenUsername,
            givenPassword,
            givenUserID                             //FIXME should i check for an integer?
        );
        ArrayList<User> updatedUsers = getUsers();
        updatedUsers.remove(selectedUser);          //removes old user
        String newUsername = scnr.nextLine();
        String newPassword = scnr.nextLine();
        selectedUser.setUsername(newUsername);      //update username
        selectedUser.setPassword(newPassword);      //update password
        updatedUsers.add(newUser);                  //adds updated user
        setUsers(updatedUsers);
    }
    //deletes selected user
    public void deleteUser(int givenUserID, String givenUsername, String givenPassword) {
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
    //creates fake users and adds them to the users array
    public void createFakeUsers() {
        //creates 3 fake users
        User fake1 = new User("player12", "memeLord123");
        User fake2 = new User("LOOK1", "password");
        User fake3 = new User("David", "ijustdo");
        //adds fake users to arrayList "users"
        ArrayList<User> updatedUsers = getUsers();
        updatedUsers.add(fake1);
        updatedUsers.add(fake2);
        updatedUsers.add(fake3);
    }
    //TEAMS
    //getter for teams
    public void getTeams() {
        return teams;
    }
    //adds a new team
    
    //PROJECTS
    //getter for projects
    public void getProjects() {
        return projects;
    }
    //adds a new project to the array list (projects)
    public void addProject(String givenProjectName, String givenStartDate, String givenEndDate, String givenStatus) {
        Project newProject = new Project();
        newProject.setProjectID(createProjectID());
        newProject.setProjectName(givenProjectName);
        newProject.setStartDate(givenStartDate);
        newProject.setEndDate(givenEndDate);
        newProject.setStatus(givenStatus);
        ArrayList<Project> updatedProjects = getProjects();
        updatedProjects.add(newProject);
        setProjects(updatedProjects);
    }
    //updates selected project
    public void updateProject(int givenProductID) {
        Project selectedProject = findProject(givenProductID);   //locates project
        ArrayList<Project> updatedProjects = getProjects();
        updatedProjects.remove(selectedProject);          //removes old project
        String newProductName = nextLine();
        String newStartDate = nextLine();
        String newEndDate = nextLine();
        String newStatus = nextLine();
        selectedProject.setProjectName(newProductName); //update projectName
        selectedProject.setStartDate(newStartDate);
        selectedProject.setEndDate(newEndDate);
        selectedProject.setStatus(newStatus);
        updatedProjects.add(newProject);                  //adds updated project
        setProjects(updatedProjects);
    }
    //deletes selected project
    private void deleteProject(int givenProductID) {
        Project selectedProject = findProject(givenProductID);   //locates project
        //selected user is deleted from "users" array list
        ArrayList<Project> updatedProjects = getProjects();
        updatedProjects.remove(selectedProject);
        setProjects(updatedProjects);
    }
    public void createFakeProjects() {
        //creates 3 fake projects
        Project fake1 = new Project("Delta", "01/02/24", "12/02/25", "For this project, we are collecting as much gold fish that we can.");
        Project fake2 = new Project("Alpha", "07/02/04", "04/07/24", "Buy all the items within Walmart...");
        Project fake3 = new Project("Project Awesome!", "12/12/12", "24/11/24", "Create a HR application that has all the bells and wristles.");
        //adds fake projects to arrayList "projects"
        ArrayList<Project> updatedProjects = getProjects();
        updatedProjects.add(fake1);
        updatedProjects.add(fake2);
        updatedProjects.add(fake3);
    }
}