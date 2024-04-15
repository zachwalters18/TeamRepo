package TermApp;

import java.util.ArrayList;
import java.util.Scanner;

public class TEMPARRAYS {
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
}