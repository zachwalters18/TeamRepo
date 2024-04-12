package TermApp;

public class Team extends Project {
    private String[] currentTeamMembers;//utilizes employee name and id (String)
    private String[] requiredSkills;    //utilizes skills (Strings)
    private int[] jobIDs;               //utilizes id (integers)
    private int[] pastProjectIDs;       //utilizes id (integers)
    private int teamID;
    private int currentProjectID;
    //default constuctor
    public Team() {

    }
    //setters
    private void setCurrentTeamMembers(String[] currentTeamMembers) {
        this.currentTeamMembers = currentTeamMembers;
    }
    private void setRequiredSkills(String[] requiredSkillString) {
        this.requiredSkills = requiredSkills;
    }
    private void setJobIDs(int[] jobIDs) {
        this.jobIDs = jobIDs;
    }
    private void setPastProjectIDs(int[] pastProjectIDs) {
        this.pastProjectIDs = pastProjectIDs;
    }
    private void setTeamID(int teamID) {
        this.teamID = teamID;
    }
    private void setCurrentProjectID(int currentProjectID) {
        this.currentProjectID = currentProjectID;
    }
    //getters
    private String[] getCurrentTeamMembers() {
        return currentTeamMembers;
    }
    private String[] getRequiredSkills() {
        return requiredSkills;
    }
    private int[] getJobIDs() {
        return jobIDs;
    }
    private int[] getPastProjects() {
        return pastProjects;
    }
    private int getTeamID() {
        return teamID;
    }
    private int getCurrentProjectID() {
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
    //creates new teamID
    private createNewTeamID() {
        ArrayList<Team> teams = getTeams();
        int newTeamID = 0;
        int i = 0;
        while ((!(filteredTeams.isEmpty())) || i == 0) {        //when filteredTeams is empty, a new ID is made
            newTeamID = (int)(Math.random() * 100);  //only 100 IDs available
            List<Team> filteredTeams = teams.stream()
                .filter(team -> 
                    team.getTeamID.equals(newTeamID))
                .collect(Collectors.toList());
            i++;
        }
        return newTeamID;
    }
}
