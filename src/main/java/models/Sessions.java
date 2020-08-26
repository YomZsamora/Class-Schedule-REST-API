package models;

public class Sessions {

    private String title;
    private String mentor;
    private String venue;
    private int sessionsId;

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
}
