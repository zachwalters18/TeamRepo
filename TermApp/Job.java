
package TermApp;

public class Job {
    private String jobID;
    private String currentTitle;
    private String currentCompany;
    private String currentSupervisor;
    private String pastTitle;
    private String pastCompany;
    private String pastSupervisor;
    private String yearsExperience;

    public Job(String jobID, String currentTitle, String currentCompany, String currentSupervisor, String pastTitle, String pastCompany, String pastSupervisor, String yearsExperience) {
        this.jobID = jobID;
        this.currentTitle = currentTitle;
        this.currentCompany = currentCompany;
        this.currentSupervisor = currentSupervisor;
        this.pastTitle = pastTitle;
        this.pastCompany = pastCompany;
        this.pastSupervisor = pastSupervisor;
        this.yearsExperience = yearsExperience;
    }
    
    public void setJobID(String jobID) {
        this.jobID = jobID;
    }
    
    public void setCurrentTitle(String currentTitle) {
        this.currentTitle = currentTitle;
    }

    public void setCurrentCompany(String currentCompany) {
        this.currentCompany = currentCompany;
    }

    public void setCurrentSupervisor(String currentSupervisor) {
        this.currentSupervisor = currentSupervisor;
    }

    public void setPastTitle(String pastTitle) {
        this.pastTitle = pastTitle;
    }

    public void setPastCompany(String pastCompany) {
        this.pastCompany = pastCompany;
    }

    public void setPastSupervisor(String pastSupervisor) {
        this.pastSupervisor = pastSupervisor;
    }

    public void setYearsExperience(String yearsExperience) {
        this.yearsExperience = yearsExperience;
    }
    
    public String getJobID() {
        return jobID;
    }
    
    public String getCurrentTitle() {
        return currentTitle;
    }

    public String getCurrentCompany() {
        return currentCompany;
    }

    public String getCurrentSupervisor() {
        return currentSupervisor;
    }

    public String getPastTitle() {
        return pastTitle;
    }       

    public String getPastCompany() {
        return pastCompany;
    }

    public String getPastSupervisor() {
        return pastSupervisor;
    }

    public String getYearsExperience() {
        return yearsExperience;
    }

}