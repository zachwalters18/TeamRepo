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
    protected ArrayList<User> getUsers() {
        return this.users;
    }
    protected void setUsers(ArrayList<User> updatedUsers) {
        this.users = updatedUsers;
    }
    //employees methods

    //questions methods

    //teams methods
    protected ArrayList<Teams> getTeams() {
        return this.teams;
    }
    protected void setTeams(ArrayList<Teams> updatedTeams) {
        this.teams = updatedTeams;
    }
    //projects methods
    protected ArrayList<Projects> getProjects() {
        return this.projects;
    }
    protected void setProjects(ArrayList<Projects> updatedProjects) {
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