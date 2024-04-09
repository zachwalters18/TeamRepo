package TermApp;

import java.util.ArrayList;

public class TEMPARRAYS {
    private ArrayList<User> users = new ArrayList<User>();
    public ArrayList<Employee> employees = new ArrayList<Employee>();
    public ArrayList<String> questions = new ArrayList<String>();
    public ArrayList<Teams> teams = new ArrayList<Teams>();
    public ArrayList<Projects> projects = new ArrayList<Projects>();
    public ArrayList<Evaluation> evaluations = new ArrayList<Evaluation>();
    public ArrayList<Skills> skills = new ArrayList<Skills>();
    public ArrayList<Job> jobs = new ArrayList<Job>();
    //users methods
    private ArrayList<User> getUsers() {
        return this.users;
    }
    private void setUsers(ArrayList<User> updatedUsers) {
        this.users = updatedUsers;
    }
    public void updateUsers(User newUser) {
        ArrayList<User> updatedUsers = getUsers();
        updatedUsers.add(newUser);
        setUsers(updatedUsers);
    }
    //employees methods

    //questions methods

    //teams methods

    //projects methods

    //evaluations methods
    public ArrayList<Evaluation> getEvaluations(){
        return this.evaluations;
    }
    public void setEvaluations(ArrayList<Evaluation> evaluations) {
        this.evaluations = evaluations;
    }
    public void updateEvaluations(Evaluation newEvaluation) {
        ArrayList<Evaluation> updatedEvaluations = getEvaluations();
        updatedEvaluations.add(newEvaluation);
        setEvaluations(updatedEvaluations);
    }
    //skills methods

    //jobs methods
}