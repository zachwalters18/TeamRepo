package TermApp;

import java.util.Scanner;
import java.util.random.*;

public class Questions {
    // Properties 
    private double questionID;
    private String questionType;
    private String[] questions;
    private String[] answers;

    Scanner scn = new Scanner(System.in);

    //Methods 
    public Questions(int n){
        this.questionID = Math.random();
        this.questions[n] = "";
        this.questionType = " ";
        this.answers[n] = " ";



    }
    public void setQuestions(int index)
    {
        System.out.println("Enter the questions for # " + index+1);
        questions[index] = scn.nextLine();
    }

    public String getQuestions(int index)
    {
        return questions[index];
    }

    public void deleteQuestion(int index)
    {
        System.out.println("Enter the # question you want to remove.");
        questions[index] = " ";
    }

    public void setAnswers(String ans, int index)
    {
        this.answers[index] = ans;
    }

    public String getAnswers(int index)
    {
        return answers[index];
    }

}
