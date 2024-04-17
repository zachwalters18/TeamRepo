package TermApp;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Scanner;

public class TEMPARRAYS {
    private ArrayList<Object[]> arrays;
    private Object[] Users = new Object[10];    //adjust amount of objects in the array here
    private Object[] Managers = new Object[30];
    Scanner scn = new Scanner(System.in);

    public TEMPARRAYS() {
        arrays = new ArrayList<>();
        arrays.add(Managers);
        arrays.add(Users);
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
    public Object[] getUsers() {
        return this.users;
    }
    
    public void setUsers(Object[] users) {
        this.users = users;
    }
   
    public void addUser(String givenUsername, String givenPassword) {  
        User newUser = new User(givenUsername, givenPassword);
        //user is added to "users" array list
        Object[] updatedUsers = getUsers();
        updatedUsers.add(newUser);
        setUsers(updatedUsers);
    }
    //username and password are able to be edited
    public void updateUser(int givenUserID) {
        User selectedUser = findUser(givenUserID);
        ArrayList<Object> updatedUsers = getUsers();
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
        User selectedUser = findUser(givenUserID);
        //selected user is deleted from "users" array list
        ArrayList<Object> updatedUsers = getUsers();
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
        ArrayList<Object> updatedUsers = getUsers();
        updatedUsers.add(fake1);
        updatedUsers.add(fake2);
        updatedUsers.add(fake3);
        setUsers(updatedUsers);
    }
    //locates user with the givens then outputs that user
    public Object findUser(String givenUsername, String givenPassword, int givenUserID) {
        ArrayList<User> users = getUsers();
        String answer;
        boolean noUserfound = true;
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
            if (filteredUsers.isEmpty()) {  
                //if user is not found, re-enter information or quit searching
                System.out.println("INCORRECT INFORMATION");
                System.out.println("Do you wish to keep searching? (y/n)")
                answer = scnr.nextLine();
                if (answer == 'y') {
                    break;
                } else {
                    continue;
                }
                System.out.println("Re-enter Username: ");
                givenUsername = scnr.nextLine();
                System.out.println("Re-enter Password: ");
                givenPassword = scnr.nextLine();
                System.out.println("Re-enter User ID: ");
                givenUserID = scnr.nextLine();
            } else {
                noUserfound = false;
                User selectedUser = filteredUsers.get(0);
            }
        }
        //FIXME bug program will crash if a user is not found
        return selectedUser;
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
}