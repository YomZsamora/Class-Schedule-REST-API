package models;

public class Sessions {

    private final String mentor;
    private String title;

    public Sessions(String title, String mentor, String venue) {
        this.title = title;
        this.mentor = mentor;
    }

    public String getSessionsTitle() {
        return title;

    }

    public String getSessionsMentor() {
        return mentor;
    }
}
