package TermApp;
import java.util.ArrayList;

public class Project extends TEMPARRAYS {
    public int projectID;
    private String projectName;
    private String startDate;
    private String endDate;
    private String status;
    private String[] projectTeam;
    //default constructor
    public Project() {

    }

    public Project(String givenProjectName, String givenStartDate, String givenEndDate, String givenStatus, String[] givenProjectTeam,int givenID) {
        setProjectID(givenID);
        setProjectName(givenProjectName);
        setStartDate(givenStartDate);
        setEndDate(givenEndDate);
        setStatus(givenStatus);
        setProjectTeam(givenProjectTeam);
    }
    //setters
    protected void setProjectID(int projectID) {
        this.projectID = projectID;
    }
    protected void setProjectName(String projectName) {
        this.projectName = projectName;
    }
    protected void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    protected void setEndDate(String endDate) {
        this.endDate = endDate;
    }
    protected void setStatus(String status) {
        this.status = status;
    }
    protected void setProjectTeam(String[] projectTeam) {
        this.projectTeam = projectTeam;
    }
    //getters
    protected int getProjectID() {
        return projectID;
    }
    protected String getProjectName() {
        return projectName;
    }
    protected String getStartDate() {
        return startDate;
    }
    protected String getEndDate() {
        return endDate;
    }
    protected String getStatus() {
        return status;
    }
    protected String[] getProjectTeam() {
        return projectTeam;
    }
    protected String getStringProjectTeam() {
        String stringProjectTeam = String.join(",", getProjectTeam());
        return stringProjectTeam;
    }
    //finds selected project
    protected Project findProject(ArrayList<Project> projects, int givenProjectID) {
        boolean noProjectfound = true;
        Project selectedProject = new Project();
        while (noProjectfound) {
            //loop checks any product with same ID
            for (Project project : projects) {
                if (project.getProjectID() == givenProjectID) {
                    noProjectfound = false;
                    selectedProject = project;
                    break;
                }
            }
            //if project is not found, re-enter information or quit searching
            if (noProjectfound) {
                System.out.println("INCORRECT INFORMATION");
            }
        }
        return selectedProject;
    }
}
