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
    public void setCurrentTeamMembers(String[] currentTeamMembers) {
        this.currentTeamMembers = currentTeamMembers;
    }
    public void setRequiredSkills(String[] requiredSkillString) {
        this.requiredSkills = requiredSkills;
    }
    public void setJobIDs(int[] jobIDs) {
        this.jobIDs = jobIDs;
    }
    public void setPastProjectIDs(int[] pastProjectIDs) {
        this.pastProjectIDs = pastProjectIDs;
    }
    public void setTeamID(int teamID) {
        this.teamID = teamID;
    }
    public void setCurrentProjectID(int currentProjectID) {
        this.currentProjectID = currentProjectID;
    }
    //getters
    public String[] getCurrentTeamMembers() {
        return currentTeamMembers;
    }
    public String[] getRequiredSkills() {
        return requiredSkills;
    }
    public int[] getJobIDs() {
        return jobIDs;
    }
    public int[] getPastProjects() {
        return pastProjects;
    }
    public int getTeamID() {
        return teamID;
    }
    public int getCurrentProjectID() {
        return currentProjectID;
    }
    //creates a list of current team members

    //creates new teamID
    public createNewTeamID() {
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
