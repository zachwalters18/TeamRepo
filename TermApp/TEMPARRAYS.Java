package TermApp;
import java.util.Scanner;
import java.util.ArrayList;

public class TEMPARRAYS extends Employee {
    static Scanner scn = new Scanner(System.in);
    private ArrayList<Object[]> arrays;

    public static int employeeCount = 0;
    public static int jobCount = 0;
    public static int skillCount = 0;

    static Skills[] skillArray = new Skills[50];
    static Employee[] employeeArray = new Employee[50];
    static Job[] jobArray = new Job[50];

    public TEMPARRAYS() {
        arrays = new ArrayList<>();
        arrays.add(jobArray);
        arrays.add(employeeArray);
        arrays.add(skillArray);
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

    // Method to add a new array
    public void addArray(Object[] newArray) {
        arrays.add(newArray);
    }

    public static void addEmployee(Object[] array) {
        int index = 0;
        while (index < array.length && array[index] != null) {
            index++;
        }

        if (index < array.length) {
        System.out.println("Enter Employee First Name:");
        String firstName = scn.nextLine();

        System.out.println("Enter Employee Last Name:");
        String lastName = scn.nextLine();

        System.out.println("Enter Phone Number:");
        int phoneNumber = scn.nextInt();

        System.out.println("Enter Email Address:");
        String emailAddress = scn.nextLine();

        System.out.println("Enter Address:");
        String address = scn.nextLine();

        System.out.println("Enter Employee ID:");
        String employeeID = scn.nextLine();

        employeeArray[employeeCount] = new Employee(firstName, lastName, phoneNumber, address, emailAddress, employeeID);
        employeeCount++;
        }
    }

    public static void addJob() {
        System.out.println("Enter Job Title:");
        String title = scn.nextLine();

        System.out.println("Enter Job ID:");
        String jobID = scn.nextLine();

        jobArray[jobCount] = new Job(jobID, title);
        jobCount++;
    }

    public static void addSkill() {

        System.out.println("Enter Skill ID:");
        String skillID = scn.nextLine();
        
        System.out.println("Enter Hard Skill:");
        String hardSkill = scn.nextLine();
        
        System.out.println("Enter Soft Skill:");
        String softSkill = scn.nextLine();

        skillArray[skillCount] = new Skills(skillID, hardSkill, softSkill);
        skillCount++;
    }


}