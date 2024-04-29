package TermApp;


public class Evaluation 
{
    // Properties 
    private String evaluationDate;
    private String evaluator;
    private String a1, a2, a3;
    private String q1, q2, q3;


    //Methods
    public Evaluation(String evaler, String date, String an1, String an2, String an3)
    {

        this.evaluator = evaler;
        this.evaluationDate = date;
        q1 = "How would you describe your mental state while at the workplace?";
        this.a1 = an1;

        q2 = "On a scale of 1 to 10 how would you ";
        this.a2 = an2;

        q3 = "Notes:";
        this.a3 = an3; 


    }

    public String geta1()
    {
        return this.a1;
    }

    public String geta2()
    {
        return this.a2;
    }

    public String geta3()
    {
        return this.a3;
    }

    public String getq1()
    {
        return this.q1;
    }

    public String getq2()
    {
        return this.q2;
    }

    public String getq3()
    {
        return this.q3;
    }

    public void seta1(String response)
    {
        this.a1 = response;
    }

    public void seta2(String response)
    {
        this.a2 = response;
    }

    public void seta3(String response)
    {
        this.a3 = response;
    }

    @Override
    public String toString()
    {
        return (this.evaluator + "\n " + this.evaluationDate + "\n " + this.q1 + this.a1 + "\n " + this.q2 + this.a2 + "\n" + this.q3 + this.a3);
    }
    

}
