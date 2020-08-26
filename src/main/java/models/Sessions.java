package models;

public class Sessions {
    private String session_name;
    private String description;
    private int cohort_id;
    private String venue;
    private int module_id;
    private int id;

    public Sessions(String session_name, String description, int cohort_id, int module_id, String venue) {
        this.session_name = session_name;
        this.description = description;
        this.cohort_id = cohort_id;
        this.module_id = module_id;
        this.venue = venue;
    }

    public String getSessionName() { return session_name; }

    public void setSessionName(String session_name) {
        this.session_name = session_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCohortId() {
        return cohort_id;
    }

    public void setCohortId(int cohort_id) { this.cohort_id = cohort_id; }

    public String getSessionsVenue() {
        return venue;
    }

    public void setSessionsVenue(String venue) {
        this.venue = venue;
    }

    public int getModuleId() { return module_id; }

    public void setModuleId(int module_id) { this.module_id = module_id; }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
