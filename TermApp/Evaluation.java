package TermApp;

public class Evaluation extends Manager 
{
    // Properties 
    private int evaluationID;
    private String evalaluationType;
    private String evaluationAnswers;
    private String evaluator;

    //Methods
    public Evaluation(String evaler, int evalID)
    {
        this.evaluator = evaler;
        this.evaluationID = evalID;
        
    }

    public int getEval(int index)
    {
        TEMPARRAYS.findEval(index);
    }

    public String setAnswers()
    {
        return answer;
    }
}
