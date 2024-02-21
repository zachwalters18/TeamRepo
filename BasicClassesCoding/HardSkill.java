package BasicClassesCoding;

class hardSkill{
    private String title;
    private String level;

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