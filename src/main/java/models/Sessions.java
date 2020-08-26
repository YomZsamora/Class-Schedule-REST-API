package models;

public class Sessions {

    private String title;

    public Sessions(String title, String mentor, String venue) {
        this.title = title;
    }

    public String getSessionsTitle() {
        return title;
    }
}
