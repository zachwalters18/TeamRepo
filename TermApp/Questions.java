package TermApp;

import java.util.Scanner;

public class Questions extends Evaluation {
    // Properties 
    private String questionID;
    private String questionType;
    private String[] questions;
    private String answers;

    Scanner scn = new Scanner(System.in);

    //Methods 
    public void setQuestions(int index)
    {
        System.out.println("Enter the questions for # " + index+1 );
        questions[index] = scn.nextLine();
    }

    public String getQuestions(int index)
    {
        return questions[index];
    }

}
