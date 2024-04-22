package TermApp;

import java.util.ArrayList;
import java.util.Scanner;

public class Project extends TEMPARRAYS {
    Scanner scnr = new Scanner(System.in);
    private int projectID;
    private String projectName;
    private String startDate;
    private String endDate;
    private String status;
    //default constructor
    public Project() {

    }

    public Project(String givenProjectName, String givenStartDate, String givenEndDate, String givenStatus, int givenID) {
        setProjectID(givenID);
        setProjectName(givenProjectName);
        setStartDate(givenStartDate);
        setEndDate(givenEndDate);
        setStatus(givenStatus);
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
                System.out.println("Re-enter Product ID: ");
                givenProjectID = scnr.nextInt();
            }
        }
        return selectedProject;
    }
}
