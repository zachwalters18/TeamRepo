package TermApp;

import java.util.ArrayList;
import java.util.Arrays;

public class Evaluation 
{
    // Properties 
    private int evaluationID;
    private String evaluationDate;
    private String evaluator;
    private ArrayList<String> answers;
    private ArrayList<String> questions;

    //Methods
    public Evaluation(String evaler, String date)
    {
        questions = new ArrayList<>();
        answers = new ArrayList<>();
        this.evaluator = evaler;
        this.evaluationDate = date;
        questions.add(0, "How would you describe your mental state while at the workplace?");
        answers.add(0, " ");

        questions.add(1, "On a scale of 1 to 10 how would you ");
        answers.add(1, " ");


        
    }
}
