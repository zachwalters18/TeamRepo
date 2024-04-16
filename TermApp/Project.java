package TermApp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Project extends Job {
    public Scanner scnr = new Scanner(System.in);
    private int productID;
    private String productName;
    private String startDate;
    private String endDate;
    private String status;
    //default constructor
    public Project() {

    }

    public Project(String givenProjectName, String givenStartDate, String givenEndDate, String givenStatus) {
        setProjectID(createProjectID());
        setProjectName(givenProjectName);
        setStartDate(givenStartDate);
        setEndDate(givenEndDate);
        setStatus(givenStatus);
    }
    //setters
    public void setProjectID(int projectID) {
        this.projectID = productID;
    }
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    //getters
    public int getProjectID() {
        return projectID;
    }
    public String getProjectName() {
        return projectName;
    }
    public String getStartDate() {
        return startDate;
    }
    public String getEndDate() {
        return endDate;
    }
    public String getStatus() {
        return status;
    }
    //checks project id
    private int createProjectID() {
        ArrayList<Project> projects = getProjects();
        int newProjectID = 0;
        while (!(filteredProjects.isEmpty())) {           //when filteredProjects is empty, a new ID is made
            newProjectID = (int)(Math.random() * 100);  //only 100 IDs available
            List<Project> filteredProjects = projects.stream()
                .filter(project -> 
                    project.getProjectID.equals(newProjectID))
                .collect(Collectors.toList());
        }
        return newProjectID;
    }
    //finds selected project
    private Project findProject(int givenID) {
        ArrayList<Project> projects = getProjects();
        while (noProjectfound) {
            List<Project> filteredProjects = projects.stream()   //stream checks any project with same productID
                .filter(project -> 
                    project.getProjectID().equals(givenID))
                .collect(Collectors.toList());
            //checks if project is found
            boolean noProjectfound = true;
            if (filteredProjects.isEmpty()) {
                System.out.println("INCORRECT. Re-enter information.");
                givenID = nextLine("Enter project ID: ")
            } else {
                noProjectfound = false;
                Project selectedProject = filteredProjects.get(0);
            }
        }
        return selectedProject;
    }
}
