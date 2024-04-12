package TermApp;

public class Teams extends Projects {
    private String[] currentTeamMembers;
    private String[] requiredSkills;
    private String[] jobIDs;
    private String[] pastProjects;
    private String teamID;
    private String currentProjectID;

    //setters
    private void setCurrentTeamMembers(String[] currentTeamMembers) {
        this.currentTeamMembers = currentTeamMembers;
    }
    private void setRequiredSkills(String[] requiredSkillString) {
        this.requiredSkills = requiredSkills;
    }
    private void setJobIDs(String[] jobIDs) {
        this.jobIDs = jobIDs;
    }
    private void setPastProjects(String[] pastProjects) {
        this.pastProjects = pastProjects;
    }
    private void setTeamID(String teamID) {
        this.teamID = teamID;
    }
    private void setCurrentProjectID(String currentProjectID) {
        this.currentProjectID = currentProjectID;
    }
    //getters
    private String[] getCurrentTeamMembers() {
        return currentTeamMembers;
    }
    private String[] getRequiredSkills() {
        return requiredSkills;
    }
    private String[] getJobIDs() {
        return jobIDs;
    }
    private String[] getPastProjects() {
        return pastProjects;
    }
    private String getTeamID() {
        return teamID;
    }
    private String getCurrentProjectID() {
        return currentProjectID;
    }

    //other methods
    private void addTeam() {
        //FIXME add team to array
    }

    private void updateTeam() {
        //FIXME update team with new information
    }

    private void deleteTeam() {
        //FIXME delete team in array
    }
}
