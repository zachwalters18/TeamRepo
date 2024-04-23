package TermApp;

import java.util.Scanner;
import java.util.ArrayList;

public class TEMPARRAYS {
    private ArrayList<Object[]> arrays;
    private ArrayList<User> users = new ArrayList<User>();    //adjust amount of objects in the array here
    private Object[] Evaluations = new Object[30]; //add the evaluations array and sets its capacity
    public Object[] Employees = new Object[30];
    public Object[] Jobs = new Object[30];
    public Object[] Skills = new Object[30];
    Scanner scn = new Scanner(System.in);


    public TEMPARRAYS() {
        arrays = new ArrayList<>();
        arrays.add(Evaluations); //adds evaluations array of objects to the arraylist
        arrays.add(Jobs);
        arrays.add(Skills);
        arrays.add(Employees);
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
    //USER 
    public ArrayList<User> getUsers() {
        return this.users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }
    //adds a new user to the "users" array
    public void addUser(String givenUsername, String givenPassword) {  
        ArrayList<User> updatedUsers = getUsers();
        User newUser = new User(givenUsername, givenPassword, updateUsers);
        //user is added to "users" array list
        updatedUsers.add(newUser);
        setUsers(updatedUsers);
    }
    //username and password are able to be edited
    public void updateUser(int givenUserID) {
        User selectedUser = new User();     //findUser requires a User to be created to call the method (findUser)
        ArrayList<User> updatedUsers = getUsers();
        selectedUser = selectedUser.findUser(updatedUsers, givenUserID);
        updatedUsers.remove(selectedUser);          //removes old user
        String newUsername = scnr.nextLine();
        String newPassword = scnr.nextLine();
        selectedUser.setUsername(newUsername);      //update username
        selectedUser.setPassword(newPassword);      //update password
        updatedUsers.add(newUser);                  //adds updated user
        setUsers(updatedUsers);
    }
    //deletes selected user
    public void deleteUser(int givenUserID) {
        User selectedUser = new User();
        ArrayList<User> updatedUsers = getUsers();
        User selectedUser = selectedUser.findUser(updatedUsers, givenUserID);
        //selected user is deleted from "users" array list
        updatedUsers.remove(selectedUser);
        setUsers(updatedUsers);
    }
    //creates fake users and adds them to the users array
    public void createFakeUsers() {
        ArrayList<User> updatedUsers = getUsers();
        //creates 3 fake users
        User fake1 = new User("player12", "memeLord123", updateUsers);
        User fake2 = new User("LOOK1", "password", updatedUsers);
        User fake3 = new User("David", "ijustdo", updatedUsers);
        //adds fake users to arrayList "users"
        updatedUsers.add(fake1);
        updatedUsers.add(fake2);
        updatedUsers.add(fake3);
        setUsers(updatedUsers);
    }
    
    // Evaluation methods 
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

    public void displayEvals(int index)
    {
        // takes the object at the specified index and prints it as a string
        System.out.println(Evaluations[index]);
    }

    //EMPLOYEE
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