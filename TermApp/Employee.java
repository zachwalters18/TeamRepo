package TermApp;

public class Employee {
    String firstName;
    String lastName;
    String phoneNumber;
    String address;
    String emailAddress;
    String employeeID;
    

    public Employee(String firstName, String lastName, String phoneNumber, String address, String emailAddress, String employeeID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.emailAddress = emailAddress;
        this.employeeID = employeeID;
    }

    @Override 
    public String toString() {
        return "Employee: " + firstName + " " + lastName +
        "  Phone: " + phoneNumber + 
        "  Email Address: " + emailAddress + 
        "  Address: " + address + 
        "  EmployeeID: " + employeeID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
        
    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    

}

