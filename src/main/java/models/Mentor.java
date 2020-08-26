package models;

public class Mentor {
    public String mentorName;
    public int sessionsId;
    public int id;

    public Mentor(String mentorName, int sessionsId) {
        this.mentorName = mentorName;
        this.sessionsId = sessionsId;
    }

    public String getMentorName() {
        return mentorName;
    }

    public void setMentorName(String mentorName) {
        this.mentorName = mentorName;
    }

    public int getSessionsId() {
        return sessionsId;
    }

    public void setSessionsId(int sessionsId) {
        this.sessionsId = sessionsId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
