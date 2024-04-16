package TermApp;

public class Employee {
    private static String firstName;
    private static String lastName;
    private static int phoneNumber;
    private static String address;
    private static String emailAddress;
    private static String employeeID;

    public Employee() {}

    public Employee(String firstName, String lastName, int phoneNumber, String address, String emailAddress, String employeeID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.emailAddress = emailAddress;
        this.employeeID = employeeID;
    }
    

     public void setEmpFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setEmpLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmpPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
        
    public void setEmpAddress(String address) {
        this.address = address;
    }

    public void setEmpEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    } 

    public static String getEmpFirstName() {
        return firstName;
    }

    public static String getEmpLastName() {
        return lastName;
    }

    public static int getEmpPhoneNumber() {
        return phoneNumber;
    }

    public static String getEmpAddress() {
        return address;
    }

    public static String getEmpEmailAddress() {
        return emailAddress;
    }

    public static String getEmpEmployeeID() {
        return employeeID;
    }

}
