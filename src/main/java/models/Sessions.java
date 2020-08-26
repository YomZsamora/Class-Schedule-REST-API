package models;

import java.sql.Time;
import java.sql.Timestamp;

public class Sessions {
    private String session_name;
    private String description;
    private int cohort_id;
    private int module_id;
    private Timestamp start_time;
    private Timestamp end_time;
    private int id;

    public Sessions(String session_name, String description, int cohort_id, int module_id, Timestamp start_time, Timestamp end_time) {
        this.session_name = session_name;
        this.description = description;
        this.cohort_id = cohort_id;
        this.module_id = module_id;
        this.start_time =start_time;
        this.end_time = end_time;
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

    public int getModuleId() { return module_id; }

    public void setModuleId(int module_id) { this.module_id = module_id; }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getStart_time() {
        return start_time;
    }

    public void setStart_time(Timestamp start_time) {
        this.start_time = start_time;
    }

    public Timestamp getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Timestamp end_time) {
        this.end_time = end_time;
    }
}
