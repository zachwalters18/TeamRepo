package BasicClassesCoding;

class hardSkill{
    //instances
    private String title;
    private String level;
    //methods
    void setTitle(String title) {
        this.title = title;
    }

    void setLevel(String level) {
        this.level = level;
    }

    String getTitle() {
        return title;
    }

    String getLevel() {
        return level;
    }

    void displayDetails() {
        System.out.println("Title: " + title + ", Level: " + level);
    }
}