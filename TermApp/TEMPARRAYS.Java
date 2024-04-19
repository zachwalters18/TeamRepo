package TermApp;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Scanner;

public class TEMPARRAYS {
    private ArrayList<Object[]> arrays;
    private ArrayList<User> users = new ArrayList<User>();    //adjust amount of objects in the array here
    private Object[] Managers = new Object[30];
    Scanner scn = new Scanner(System.in);

    public TEMPARRAYS() {
        arrays = new ArrayList<>();
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
    //MANAGER   
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
            int phoneNumber = scn.nextInt();
            scn.nextLine();

            System.out.println("Enter Manager Physical Address:");
            String address = scn.nextLine();

            System.out.println("Enter Manager Email Address");
            String emailAddress = scn.nextLine();

            System.out.println("Enter Manager Manager ID:");
            String managerID = scn.nextLine();
                // takes in the new scanenr inputs and passes it to the Manager constructor
            Managers[index] = new Manager(firstName, lastName, phoneNumber, address, emailAddress, managerID);
        } else {
            System.out.println("Array is full, cannot add more objects.");
        }
    }

    public void deleteManager(int index)
    {
                // checks the index to make sure it isnt out of bounds and throws an exceptionn if it is
            if (index < 0 || index >= Managers.length) {
                throw new IndexOutOfBoundsException("Index out of bounds");
            }
    
            // Shift elements to the left starting from the index to remove
            for (int i = index; i < Managers.length - 1; i++) {
                Managers[i] = Managers[i + 1];
            }
    
            // Set the last element to null to remove it
            Managers[Managers.length - 1] = null;
    }

    public void updateManager(int index)
    {
        String firstName = scn.nextLine();
        String lastName = scn.nextLine();
        int phoneNumber = scn.nextInt();
        scn.nextLine();
        String address = scn.nextLine();
        String emailAddress = scn.nextLine();
        String managerID = scn.nextLine();

        // Assuming Managers is an array of Manager objects
        if (index >= 0 && index < Managers.length) 
        {
            Managers[index].setFirstName(firstName);
            Managers[index].setLastName(lastName);
            Managers[index].setPhoneNumber(phoneNumber);
            Managers[index].setAddress(address);
            Managers[index].setEmailAddress(emailAddress);
            Managers[index].setManagerID(managerID);
        } else {
            System.out.println("Invalid index specified.");
        }

    // Method to add a new array
    public void addArray(Object[] newArray) {
        
            arrays.add(newArray);
        
    }
}