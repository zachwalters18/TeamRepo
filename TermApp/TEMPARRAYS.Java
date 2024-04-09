package TermApp;

import java.util.ArrayList;

public class TEMPARRAYS {
    private ArrayList<User> users = new ArrayList<User>();
    private ArrayList<Employee> employees = new ArrayList<Employee>();
    private ArrayList<String> questions = new ArrayList<String>();
    private ArrayList<Team> teams = new ArrayList<Team>();
    private ArrayList<Project> projects = new ArrayList<Project>();
    private ArrayList<Evaluation> evaluations = new ArrayList<Evaluation>();
    private ArrayList<Skills> skills = new ArrayList<Skills>();
    private ArrayList<Job> jobs = new ArrayList<Job>();
    //users methods
    protected ArrayList<User> getUsers() {
        return this.users;
    }
    protected void setUsers(ArrayList<User> updatedUsers) {
        this.users = updatedUsers;
    }
    //employees methods

    //questions methods

    //teams methods
    protected ArrayList<Team> getTeams() {
        return this.teams;
    }
    protected void setTeams(ArrayList<Team> updatedTeams) {
        this.teams = updatedTeams;
    }
    //projects methods
    protected ArrayList<Project> getProjects() {
        return this.projects;
    }
    protected void setProjects(ArrayList<Project> updatedProjects) {
        this.projects = updatedProjects;
    }
    //evaluations methods
    protected ArrayList<Evaluation> getEvaluations(){
        return this.evaluations;
    }
    protected void setEvaluations(ArrayList<Evaluation> updatedEvaluations) {
        this.evaluations = updatedEvaluations;
    }
    //skills methods

    //jobs methods
}