package TermApp;

public class Evaluation extends Manager 
{
    // Properties 
    private int evaluationID;
    private String evalaluationType;
    private String evaluationAnswers;
    private String evaluator;
    private Object[] EvalArray;

    //Methods
    public Evaluation(String evaler, int evalID)
    {
        this.evaluator = evaler;
        this.evaluationID = evalID;
        
    }

    public Object getEval(int index)
    {
        return EvalArray[index];
    }
}
