package BasicClassesCoding;
import java.util.Scanner;


public class Job 
{
// Properties
    private String Title;
    private int Experience;

    Scanner scn = new Scanner(System.in);
//Methods:
    private void setTitle() // sets job title
    {
        Title = scn.nextLine();
    }

    private void setExperience() // Sets the number of months on the job.
    {
        Experience = scn.nextInt();
    }

    private String getTitle() // Retrieves the job title
    {
        return Title;
    }

    private int getExperiencel() // Retrieves the number of months on the job
    {
        return Experience;
    }
    
    private void displayDetails() //Displays the jobs and lengths of time in months on the job
    {
        System.out.println("Title: " + Title + ", Experience: " + Experience + "years,")
    }
}