package TermApp;


public class Skills {
    String skillID;
    String hardSkill;
    String softSkill;
    

    public Skills(String skillID, String hardSkill, String softSkill) {
        this.skillID = skillID;
        this.hardSkill = hardSkill;
        this.softSkill = softSkill;
    }

    public void setSkillID(String skillID) {
        this.skillID = skillID;
    }
    
    public void setHardSkill(String hardSkill) {
        this.hardSkill = hardSkill;
    }
    
    public void setSoftSkill(String softSkill) {
        this.softSkill = softSkill;
    }
    
    public String getSkillID() {
        return skillID;
    }

    
    public String getHardSkill() {
        return hardSkill;
    }
    
    public String getSoftSkill() {
        return softSkill;
    }
}
