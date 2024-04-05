
package TermApp;

public class Job extends Manager {
TEMPARRAYS tempArrays = new TEMPARRAYS();
private String jobID;
private String title;
private String experienceReq;

public Job() {
    
}

public void setJobID(String jobID) {
    this.jobID = jobID;
}

public void setTitle(String title) {
    this.title = title;
}

public void setExperienceReq(String experienceReq) {
    this.experienceReq = experienceReq;
}

public String getJobID() {
    return jobID;
}

public String getTitle() {
    return title;
}

public String getExperienceReq() {
    return experienceReq;
}

public void addJob() {

}

public void editJob() {

}

public void delJob() {

}

}
