package TermApp;

public class Manager{
    //Properties 
    private String firstName;
    private String lastName;
    private double phoneNunber;
    private String address;
    private String emailAddress;
    private String managerID;

    public Manager(String first, String last)
    {
            this.firstName = first;
            this.lastName = last;
            this.phoneNunber = Math.floor(Math.random() * 1000000000);
            this.address = " ";
            this.emailAddress = " ";
            this.managerID = " ";

            
    }
}
