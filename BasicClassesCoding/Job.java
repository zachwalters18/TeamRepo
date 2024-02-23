package BasicClassesCoding;


public class Job 
{
// Properties
    private String Title; // title prop
    private int Experience;

//Methods:
    public void setTitle(String Title) // sets job title
    {
        this.Title = Title;
    }

    public void setExperience(int Experience) // Sets the number of months on the job.
    {
        this.Experience = Experience;
    }

    public String getTitle() // Retrieves the job title
    {
        return Title;
    }

    public int getExperience() // Retrieves the number of months on the job
    {
        return Experience;
    }
    
    public void  displayDetails() //Displays the jobs and lengths of time in months on the job
    {
        System.out.println(String.format("Job Title: %s Job Experience: %d months.", getTitle(), getExperience()));
    }
}