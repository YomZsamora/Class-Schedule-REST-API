package models;

public class Mentor {
    public String mentorName;

    public Mentor(String mentorName, int sessionsId) {
        this.mentorName = mentorName;
    }

    public String getMentorName() {
        return mentorName;
    }

    public void setMentorName(String mentorName) {
        this.mentorName = mentorName;
    }
}
