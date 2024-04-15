package TermApp;

public class Manager{
    //Properties 
    private String firstName;
    private String lastName;
    private long phoneNunber;
    private String address;
    private String emailAddress;
    private String managerID;

    public Manager(String first, String last, long phone, String location, String email, String mID)
    {
            this.firstName = first;
            this.lastName = last;
            this.phoneNunber = phone;
            this.address = location;
            this.emailAddress = email;
            this.managerID = mID;
    }

    public String getfirstName()
    {
        return firstName;
    }

    public String getlastName()
    {
        return lastName;
    }

    public long getphoneNumber()
    {
        return phoneNunber;
    }

    public String getAddress()
    {
        return address;
    }

    public String getemailAddress()
    {
        return emailAddress;
    }

    public String getmanagerID()
    {
        return managerID;
    }
}
