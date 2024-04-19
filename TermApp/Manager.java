package TermApp;

public class Manager{
    //Properties 
    private String firstName;
    private String lastName;
    private int phoneNunber;
    private String address;
    private String emailAddress;
    private String managerID;

    public Manager(String first, String last, int phone, String location, String email, String mID)
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

    public void setfirstName(String first)
    {
        this.firstName = first;
    }

    public void setlastName(String last)
    {
        this.lastName = last;
    }

    public void setphoneNumber(int phone)
    {
        phoneNunber = phone;
    }

    public void setAddress(String location)
    {
        this.address = location;
    }

    public void setemailAddress(String email)
    {
        this.emailAddress = email;
    }

    public void setmanagerID(String m)
    {
        this.managerID = m;
    }

    
}
