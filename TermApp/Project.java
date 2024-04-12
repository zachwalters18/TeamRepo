package TermApp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Project extends Job {
    Scanner scnr = new Scanner(System.in);
    private int productID;
    private String productName;
    private String startDate;
    private String endDate;
    private String status;
    //default constructor
    public Project() {

    }
    //setters
    private void setProjectID(int projectID) {
        this.projectID = productID;
    }
    private void setProjectName(String projectName) {
        this.projectName = projectName;
    }
    private void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    private void setEndDate(String endDate) {
        this.endDate = endDate;
    }
    private void setStatus(String status) {
        this.status = status;
    }
    //getters
    private int getProjectID() {
        return projectID;
    }
    private String getProjectName() {
        return projectName;
    }
    private String getStartDate() {
        return startDate;
    }
    private String getEndDate() {
        return endDate;
    }
    private String getStatus() {
        return status;
    }
    //adds a new project to the array
    private void addProject(String givenProjectName, String givenStartDate, String givenEndDate, String givenStatus) {
        Project newProject = new Project();
        newProject.setProjectID(createProjectID());
        newProject.setProjectName(givenProjectName);
        newProject.setStartDate(givenStartDate);
        newProject.setEndDate(givenEndDate);
        newProject.setStatus(givenStatus);
        ArrayList<Project> updatedProjects = getProjects();
        updatedProjects.add(newProject);
        setProjects(updatedProjects);
    }
    //updates selected project
    private static void updateProject(int givenProductID) {
        Project selectedProject = findProject(givenProductID);   //locates project
        ArrayList<Project> updatedProjects = getProjects();
        updatedProjects.remove(selectedProject);          //removes old project
        String newProductName = nextLine();
        String newStartDate = nextLine();
        String newEndDate = nextLine();
        String newStatus = nextLine();
        selectedProject.setProjectName(newProductName); //update projectName
        selectedProject.setStartDate(newStartDate);
        selectedProject.setEndDate(newEndDate);
        selectedProject.setStatus(newStatus);
        updatedProjects.add(newProject);                  //adds updated project
        setProjects(updatedProjects);
    }
    //deletes selected project
    private void deleteProject(int givenProductID) {
        Project selectedProject = findProject(givenProductID);   //locates project
        //selected user is deleted from "users" array list
        ArrayList<Project> updatedProjects = getProjects();
        updatedProjects.remove(selectedProject);
        setProjects(updatedProjects);
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
    //FIXME this is for the data
    public void createFakeProjects() {
        //creates 3 fake projects
        Project fake1 = new Project();
        fake1.setProjectID(1);
        fake1.setStartDate("01/02/24");
        fake1.setEndDate("12/02/25");
        fake1.setStatus("For this project, we are collecting as much gold fish that we can.");
        Project fake2 = new Project();
        fake2.setProjectID(2);
        fake2.setStartDate("07/02/04");
        fake2.setEndDate("04/07/24");
        fake2.setStatus("Buy all the items within Walmart...");
        Project fake3 = new Project();
        fake3.setProjectID(3);
        fake3.setStartDate("12/12/12");
        fake3.setEndDate("24/11/24");
        fake3.setStatus("Create a HR application that has all the bells and wristles.");
        //adds fake projects to arrayList "projects"
        ArrayList<Project> updatedProjects = getProjects();
        updatedProjects.add(fake1);
        updatedProjects.add(fake2);
        updatedProjects.add(fake3);
    }
}
