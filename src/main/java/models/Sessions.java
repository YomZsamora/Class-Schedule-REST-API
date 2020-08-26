package models;

public class Sessions {

    private String title;
    private String mentor;
    private String venue;

    public Sessions(String title, String mentor, String venue) {
        this.title = title;
        this.mentor = mentor;
        this.venue = venue;
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
}
