package BasicClassesCoding;


public class Job 
{
// Properties
    private String jobTitle;
    private int jobExperience;

//Methods:
    public void setjobTitle(String jobTitle) // sets job title
    {
        this.jobTitle = jobTitle;
    }

    public void setjobExperience(int jobExperience) // Sets the number of months on the job.
    {
        this.jobExperience = jobExperience;
    }

    public String getjobTitle() // Retrieves the job title
    {
        return jobTitle;
    }

    public int getjobExperience() // Retrieves the number of months on the job
    {
        return jobExperience;
    }
    
    public void  displayjobDetails() //Displays the jobs and lengths of time in months on the job
    {
        System.out.println("Job Title: " + getjobTitle() + " Job Experience: "+ getjobExperience() + " months.");
    }
}