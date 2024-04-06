package TermApp;

import java.util.ArrayList;

public class TEMPARRAYS {
    private ArrayList<User> users = new ArrayList<User>();
    private ArrayList<Employee> employees = new ArrayList<Employee>();
    private ArrayList<String> questions = new ArrayList<String>();
    private ArrayList<Teams> teams = new ArrayList<Teams>();
    private ArrayList<Projects> projects = new ArrayList<Projects>();
    private ArrayList<Evaluation> evaluations = new ArrayList<Evaluation>();
    private ArrayList<Skills> skills = new ArrayList<Skills>();
    private ArrayList<Job> jobs = new ArrayList<Job>();
    //users methods
    private ArrayList<User> getUsers() {
        return this.users;
    }
    private void setUsers(ArrayList<User> updatedUsers) {
        this.users = updatedUsers;
    }
    public void updateUsers(User newUser) {     //this method will be called in required classes
        ArrayList<User> updatedUsers = getUsers();
        updatedUsers.add(newUser);
        setUsers(updatedUsers);
    }
    //employees methods

    //questions methods

    //teams methods
    private ArrayList<Teams> getTeams() {
        return this.teams;
    }
    private void setTeams(ArrayList<Teams> updatedTeams) {
        this.teams = updatedTeams;
    }
    public void updatedTeams(Teams newTeam) {
        ArrayList<Teams> updatedTeams = getTeams();
        updatedTeams.add(newTeam);
        setTeams(updatedTeams);
    }
    //projects methods
    private ArrayList<Projects> getProjects() {
        return this.projects;
    }
    private void setProjects(ArrayList<Projects> updatedProjects) {
        this.projects = updatedProjects;
    }
    public void updateProjects(Projects newproject) {
        ArrayList<Projects> updatedProjects = getProjects();
        updatedProjects.add(newProject);
        setProject(updatedProjects);
    }
    //evaluations methods
    private ArrayList<Evaluation> getEvaluations(){
        return this.evaluations;
    }
    private void setEvaluations(ArrayList<Evaluation> updatedEvaluations) {
        this.evaluations = updatedEvaluations;
    }
    public void updateEvaluations(Evaluation newEvaluation) {
        ArrayList<Evaluation> updatedEvaluations = getEvaluations();
        updatedEvaluations.add(newEvaluation);
        setEvaluations(updatedEvaluations);
    }
    //skills methods

    //jobs methods
}