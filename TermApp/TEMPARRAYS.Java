package TermApp;

import java.util.Scanner;
import java.util.ArrayList;

public class TEMPARRAYS {
    Scanner scn = new Scanner(System.in);
    Scanner scnr = new Scanner(System.in);
    //Arrays
    private ArrayList<Object[]> arrays;
    public Object[] Evaluations = new Object[30]; //add the evaluations array and sets its capacity
    public Object[] Employees = new Object[30];
    public Object[] Jobs = new Object[30];
    public Object[] Skills = new Object[30];
    //ArrayLists
    private ArrayList<User> users = new ArrayList<User>();
    private ArrayList<Project> projects = new ArrayList<Project>();
    //needed for the creation of unique indexes for each object (specific to my classes)
    private int userIndex = 1;
    private int projectIndex = 1;
    //is important to check track of the current user accessing the program
    private User loggedInUser;


    public TEMPARRAYS() {
        arrays = new ArrayList<>();
        arrays.add(Evaluations); //adds evaluations array of objects to the arraylist
        arrays.add(Jobs);
        arrays.add(Skills);
        arrays.add(Employees);
    }
    //INCREASES INDEXES
    private void increaseUserIndex() {
        this.userIndex = this.userIndex + 1;
    }
    private void increaseProjectIndex() {
        this.projectIndex = this.projectIndex + 1;
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
    //**********USER************ 
    //getter and setter to obtain the "users" array
    private ArrayList<User> getUsers() {
        return this.users;
    }

    private void setUsers(ArrayList<User> users) {
        this.users = users;
    }
    //sets up a fake user in index 0 to check for loggin to be false
    protected void setFakeLog() {
        loggedInUser = new User("temp", "temp", 0);
    }
    //adds a new user to the "users" array
    protected void addUser(String givenUsername, String givenPassword) {  
        ArrayList<User> updatedUsers = getUsers();
        givenUsername = validateUsername(givenUsername);
        User newUser = new User(givenUsername, givenPassword, this.userIndex);
        increaseUserIndex();
        //user is added to "users" array list
        updatedUsers.add(newUser);
        setUsers(updatedUsers);
    }
    //username and password are able to be edited
    protected void updateUser(int givenUserID) {
        //findUser requires a User to be created to call the method (findUser)
        User selectedUser = new User();
        ArrayList<User> updatedUsers = getUsers();
        selectedUser = selectedUser.findUser(updatedUsers, givenUserID);
        updatedUsers.remove(selectedUser);          //removes old user
        System.out.println("Input new username:");//changes username and password
        String newUsername = scnr.nextLine();
        newUsername = validateUsername(newUsername);
        System.out.println("Input new password:");
        String newPassword = scnr.nextLine();
        selectedUser.setUsername(newUsername);      //update username
        selectedUser.setPassword(newPassword);      //update password
        updatedUsers.add(selectedUser);             //adds updated user
        setUsers(updatedUsers);
    }
    //deletes selected user
    protected void deleteUser(int givenUserID) {
        User selectedUser = new User();
        ArrayList<User> updatedUsers = getUsers();
        selectedUser = selectedUser.findUser(updatedUsers, givenUserID);
        //selected user is deleted from "users" array list
        updatedUsers.remove(selectedUser);
        setUsers(updatedUsers);
    }
    //displays all users in "users" array by their ID
    protected void displayAllUsers() {
        for (User user : users) {
            System.out.println(user.getUserID());
        }
    }
    //logging in a User
    protected void logInUser(String givenUsername, String givenPassword) {
        boolean found = false;
        //checks to see if loggedInUser is loggedIn to prevent more than one user from being loggedIn
        if (loggedInUser.loggedIn) {
            System.out.println("A User is already logged in.");
        } else {
            //validates User when given username and password and searches for a match
            while (!found) {
                for (User user : users) {
                    if (user.getUsername().equals(givenUsername) && user.getPassword().equals(givenPassword)) {
                        user.logIn();
                        loggedInUser = user;
                        found = true;
                    }
                }
                if (found) {
                    System.out.println("Logging user in...");
                    break;
                } else {
                    System.out.println("INCORRECT INFORMATION");
                    System.out.println("Re-enter username:");
                    givenUsername = scnr.nextLine();
                    System.out.println("Re-enter password:");
                    givenPassword = scnr.nextLine();
                }
            }
        }
    }
    //logs user out and resets loggedInUser to logout as well
    protected void logOutUser() {
        for (User user : users) {
            if (user == loggedInUser) {
                user.logOut();
                loggedInUser.logOut();
                System.out.println("Logging out user...");
            }
        }
    }
    //validates if username is unique to avoid two users with the same username
    protected String validateUsername(String givenUsername) {
        ArrayList<User> users = getUsers();
        boolean unique = false;
        int counter = 0;
        //while not unique execute code to find an unique username
        while (!unique) {
            counter = 0;
            for (User user : users) {
                if (user.username.equals(givenUsername)) {
                    //if username is not unique get a new username
                    System.out.println("Username is already in use...\nInput a different username:");
                    givenUsername = scnr.nextLine();
                    counter = 1;
                    break;
                }
            }
            //checks to see if unique
            if (counter == 0) {
                unique = true;
            }
        }
        return givenUsername;       //returns unique username
    }
    //creates fake users and adds them to the users array
    protected void createFakeUsers() {
        ArrayList<User> updatedUsers = getUsers();
        //creates 3 fake users
        User fake1 = new User("player12", "memeLord123", this.userIndex);
        increaseUserIndex();
        User fake2 = new User("LOOK1", "password", this.userIndex);
        increaseUserIndex();
        User fake3 = new User("David", "ijustdo", this.userIndex);
        increaseUserIndex();
        //adds fake users to arrayList "users"
        updatedUsers.add(fake1);
        updatedUsers.add(fake2);
        updatedUsers.add(fake3);
        setUsers(updatedUsers);
    }
    //********PROJECT*******
    //getter and setter for "projects" array
    private ArrayList<Project> getProjects() {
        return this.projects;
    }

    private void setProjects(ArrayList<Project> projects) {
        this.projects = projects;
    }
    //adds a new project to the "projects" array
    protected void addProject(String givenProjectName, String givenStartDate, String givenEndDate, String givenStatus) {  
        ArrayList<Project> updatedProjects = getProjects();
        //constructor has much data passed to it
        Project newProject = new Project(givenProjectName, givenStartDate, givenEndDate, givenStatus, this.projectIndex);
        increaseProjectIndex();
        updatedProjects.add(newProject);
        setProjects(updatedProjects);
    }
    //selected project can be edited
    protected void updateProject(int givenProjectID) {
        //findProject requires a Project to be created to call the method (findProject)
        Project selectedProject = new Project();
        ArrayList<Project> updatedProjects = getProjects();
        selectedProject = selectedProject.findProject(updatedProjects, givenProjectID);
        updatedProjects.remove(selectedProject);        //removes old user
        System.out.println("Input new project name:");//gets input to replace old data
        String newProjectName = scnr.nextLine();
        System.out.println("Input new start date:");
        String newStartDate = scnr.nextLine();
        System.out.println("Input new end date:");
        String newEndDate = scnr.nextLine();
        System.out.println("Input new status:");
        String newStatus = scnr.nextLine();
        selectedProject.setProjectName(newProjectName); //update project name
        selectedProject.setStartDate(newStartDate);     //update start date
        selectedProject.setEndDate(newEndDate);         //update end date
        selectedProject.setStatus(newStatus);           //update status
        updatedProjects.add(selectedProject);           //adds updated project
        setProjects(updatedProjects);
    }
    //deletes selected project
    protected void deleteProject(int givenProjectID) {
        Project selectedProject = new Project();
        ArrayList<Project> updatedProjects = getProjects();
        //I need a new Project to call the findProject method
        selectedProject = selectedProject.findProject(updatedProjects, givenProjectID);
        //selected project is deleted from "projects" array list
        updatedProjects.remove(selectedProject);
        setProjects(updatedProjects);
    }
    //displays all projects in "projects" array by their ID
    protected void displayAllProjects() {
        for (Project project : projects) {
            System.out.println(project.getProjectID());
        }
    }
    //creates a fake project and adds it to the "projects" array
    protected void createFakeProjects() {
        ArrayList<Project> updatedProjects = getProjects();
        //constructor is passed all required data
        Project fake1 = new Project("Project 103", "01/01/04", "02/02/05",
        "Successful for the most part, but the project needs a better name.", this.projectIndex);
        increaseProjectIndex();
        updatedProjects.add(fake1);        //adds fake project to array
        setProjects(updatedProjects);
    }
    //*******Evaluation**********
    public void deleteEval(int index)
    {
                // checks the index to make sure it isnt out of bounds and throws an exceptionn if it is
            if (index < 0 || index >= Evaluations.length) {
                throw new IndexOutOfBoundsException("Index out of bounds");
            }
    
            // Shift elements to the left starting from the index to remove
            for (int i = index; i < Evaluations.length - 1; i++) {
                Evaluations[i] = Evaluations[i + 1];
            }
    
            // Set the last element to null to remove it
            Evaluations[Evaluations.length - 1] = null;
    }

    public void updateEvals(int index, String evalp,String time,String ans1,String ans2,String ans3)
    {

        // Evaluations index out of bounds check
        if (index >= 0 && index < Evaluations.length) 
        {
            Evaluations[index] = new Evaluation(evalp, time, ans1, ans2, ans3);
        } else {
            System.out.println("Invalid index specified.");
        }
    }

    public void addEvals(String evalp,String time,String ans1,String ans2,String ans3)
    {
        int index = 0;
        while (index < Evaluations.length && Evaluations[index] != null) 
        {
            index++;
        }

        // Check if there is space in the array
        if (index < Evaluations.length)
        {

                // takes in arguments and passes it to the Evaluation constructor
            Evaluations[index] = new Evaluation(evalp, time, ans1, ans2, ans3);
        } else {
            System.out.println("Array is full, cannot add more objects.");
        }
    }

    public String displayEvals(int index)
    {
        // Check if the index is within bounds
        if (index < 0 || index >= Evaluations.length) {
            return "Error: Index is out of bounds.";
        }

        // Check if the object at the specified index is null
        if (Evaluations[index] == null) {
            return "Error: Object at index " + index + " is null.";
        }
        // takes the object at the specified index and prints it as a string
            return Evaluations[index].toString();
    }

    public void makeFakeEvals()
    {
        addEvals("Robert Kyle", "10/24/2016", "horrible","2", "notes would go here");
        addEvals("Stacy Clarke", "3/24/1986", "decent", "6", "need a watercoolr closer to the south sector");
    }

    //********EMPLOYEE************
    public void addEmployee(String firstName, String lastName, String phoneNumber, String address, String email, String employeeID) {
        int index = 0;
        while (index < Employees.length && Employees[index] != null) {
            index++;
        }
        //Check if there is space in the array
        if (index < Employees.length) {
            Employees[index] = new Employee(firstName, lastName, phoneNumber, address, email, employeeID);
            
        } else {
            System.out.println("Array is full, cannot add more objects.");
        }
    } 

    public void editEmployeeInfo(int index, String firstName, String lastName, String phoneNumber, String address, String emailAddress, String employeeID) {
        if (index >= 0 && index < Employees.length) {
            // Check if the employee at the specified index exists
            if (Employees[index] != null) {
                // Update employee information
                Employee employee = (Employee) Employees[index];
                employee.setFirstName(firstName);
                employee.setLastName(lastName);
                employee.setPhoneNumber(phoneNumber);
                employee.setAddress(address);
                employee.setEmailAddress(emailAddress);
                employee.setEmployeeID(employeeID);
                Employees[index] = employee; // Reassign the updated employee to the array
                System.out.println("Employee information updated successfully.");
            } else {
                System.out.println("No employee found at index " + index);
            }
        } else {
            System.out.println("Invalid index specified.");
        }
    }

    public void deleteEmployee(int index) {
        // checks the index to make sure it isnt out of bounds and throws an exceptionn if it is
    if (index < 0 || index >= Employees.length) {
        throw new IndexOutOfBoundsException("Index out of bounds");
    }

    // Shift elements to the left starting from the index to remove
    for (int i = index; i < Employees.length - 1; i++) {
        Employees[i] = Employees[i + 1];
    }

    // Set the last element to null to remove it
    Employees[Employees.length - 1] = null;
    }

    public void createFakeEmployees() {
            
        // Create fake employees
        addEmployee("Kendrick", "Lamar", "1234567890", "123 Main St", "klamar@gmail.com", "EMP001");
        addEmployee("Post", "Malone", "9876543210", "456 Oak St", "pmalone@hotmail.com", "EMP002");
        addEmployee("Peter", "Parker", "6183243454", "987 Fair st", "pparker@yahoo.com", "EMP003");

        // Add more fake employees as needed

        // Print confirmation message
        System.out.println("Fake employees created successfully.");
    }
  
//Job
    public void addJob(String jobID, String currentTitle, String currentCompany, String currentSupervisor, String pastTitle, String pastCompany, String pastSupervisor, String yearsExperience) {
        int index = 0;
    while (index < Jobs.length && Jobs[index] != null) {
        index++;
    }
    //Checks if there is space in the array
    if (index < Employees.length) {
        Jobs[index] = new Job(jobID, currentTitle, currentCompany, currentSupervisor, pastTitle, pastCompany, pastSupervisor, yearsExperience);
        
    } else {
        System.out.println("Array is full, cannot add more objects.");
    }
}

public void editJobInfo(int index, String jobID, String currentTitle, String currentCompany, String currentSupervisor, String pastTitle, String pastCompany, String pastSupervisor, String yearsExperience) {
    if (index >= 0 && index < Jobs.length) {
        // Check if the job at the specified index exists
        if (Jobs[index] != null) {
            // Update job information
            Job job = (Job) Jobs[index];
            job.setJobID(jobID);
            job.setCurrentTitle(currentTitle);
            job.setCurrentCompany(currentCompany);
            job.setCurrentSupervisor(currentSupervisor);
            job.setPastTitle(pastTitle);
            job.setPastCompany(pastCompany);
            job.setPastSupervisor(pastSupervisor);
            job.setYearsExperience(yearsExperience);
            Jobs[index] = job; // Reassign the updated job to the array
            System.out.println("Job information updated successfully.");
        } else {
            System.out.println("No job found at index " + index);
        }
    } else {
        System.out.println("Invalid index specified.");
    }
}


    public void deleteJob(int index) {
        // checks the index to make sure it isnt out of bounds and throws an exceptionn if it is
    if (index < 0 || index >= Jobs.length) {
        throw new IndexOutOfBoundsException("Index out of bounds");
    }

    // Shift elements to the left starting from the index to remove
    for (int i = index; i < Jobs.length - 1; i++) {
        Jobs[i] = Jobs[i + 1];
    }

    // Set the last element to null to remove it
    Jobs[Jobs.length - 1] = null;
    }
  
    //Skill
    public void addSkill(String skillID, String hardSkill, String softSkill) {
    int index = 0;
    while (index < Skills.length && Skills[index] != null) {
    index++;
    }
    if (index < Employees.length) {
    Skills[index] = new Skill(skillID, hardSkill, softSkill);

    } else {
    System.out.println("Array is full, cannot add more objects.");
    }
    }

    public void editSkillInfo(int index, String skillID, String hardSkill, String softSkill) {
        if (index >= 0 && index < Skills.length) {
            // Check if the skill at the specified index exists
            if (Skills[index] != null) {
                // Update skill information
                Skill skill = (Skill) Skills[index];
                skill.setSkillID(skillID);
                skill.setHardSkill(hardSkill);
                skill.setSoftSkill(softSkill);
                Skills[index] = skill; // Reassign the updated skill to the array
                System.out.println("Skill information updated successfully.");
            } else {
                System.out.println("No skill found at index " + index);
            }
        } else {
            System.out.println("Invalid index specified.");
        }
    }
    

    public void deleteSkill(int index) {
    // checks the index to make sure it isnt out of bounds and throws an exceptionn if it is
    if (index < 0 || index >= Skills.length) {
    throw new IndexOutOfBoundsException("Index out of bounds");
    }

    // Shift elements to the left starting from the index to remove
    for (int i = index; i < Skills.length - 1; i++) {
    Skills[i] = Skills[i + 1];
    }

    // Set the last element to null to remove it
    Skills[Skills.length - 1] = null;
    }

    // Method to add a new array
    public void addArray(Object[] newArray) {
        
            arrays.add(newArray);
        
    }
}