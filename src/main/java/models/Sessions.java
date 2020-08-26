package models;

import java.util.Objects;

public class Sessions {

    public String title;
    public String mentor;
    public String venue;
    public int sessionsId;
    public int id;

    public Sessions(String title, String mentor, String venue, int sessionsId) {
        this.title = title;
        this.mentor = mentor;
        this.venue = venue;
        this.sessionsId = sessionsId;
    }

    public String getSessionsTitle() {
        return title;

    }

    public String getSessionsMentor() {
        return mentor;
    }

    public String getSessionsVenue() {
        return venue;
    }

    public int getSessionsId() {
        return sessionsId;
    }

    public void setSessionsTitle(String title) {
        this.title = title;
    }

    public void setSessionsMentor(String mentor) {
        this.mentor = mentor;
    }

    public void setSessionsVenue(String venue) {
        this.venue = venue;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sessions)) return false;
        Sessions sessions = (Sessions) o;
        return sessionsId == sessions.sessionsId &&
                id == sessions.id &&
                Objects.equals(title, sessions.title) &&
                Objects.equals(mentor, sessions.mentor) &&
                Objects.equals(venue, sessions.venue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, mentor, venue, sessionsId, id);
    }
}
