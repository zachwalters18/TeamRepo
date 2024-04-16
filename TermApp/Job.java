
package TermApp;

public class Job {
    private String jobID;
    private String title;
    
    
    public Job(String jobID, String title) {
        this.jobID = jobID;
        this.title = title;
    }
    
    public void setJobID(String jobID) {
        this.jobID = jobID;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getJobID() {
        return jobID;
    }
    
    public String getTitle() {
        return title;
    }
    
    
}
