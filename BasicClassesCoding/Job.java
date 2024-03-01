package BasicClassesCoding;


public class Job 
{
<<<<<<< Updated upstream
// Properties for job class
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
=======
    //variables
    private String jobTitle;
    private int mExperience;

    //instantiate the name
    public void setJobTitle(String title){
        this.jobTitle = title;
    }
    //obtain the name
    public String getTitle() {
        return jobTitle;
    }
    //instantiate the age
    public void setExperience(int experience) {
        this.mExperience = experience;
    }
    //obtain the age
    public int getExperience() {
        return mExperience;
    }
    //display the name and age
    public void displayDetails() {
        System.out.println("Job Title: " + getTitle() + " Months: " + getExperience());
>>>>>>> Stashed changes
    }

}