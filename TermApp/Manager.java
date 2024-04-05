package TermApp;

public abstract class Manager 
{
    //Properties 
    private String firstName;
    private String lastName;
    private int phoneNunber;
    private String address;
    private String emailAddress;
    private String managerID;

    //pull tempArray
    TEMPARRAYS temp = new TEMPARRAYS();

    // 
    public Evaluation manageEvals(int index, Evaluation evaluation)
    {
        return evaluation.getEval(index);
    }



}
