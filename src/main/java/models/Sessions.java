package models;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sessions sessions = (Sessions) o;

        if (cohort_id != sessions.cohort_id) return false;
        if (module_id != sessions.module_id) return false;
        if (id != sessions.id) return false;
        if (!session_name.equals(sessions.session_name)) return false;
        if (!description.equals(sessions.description)) return false;
        if (!start_time.equals(sessions.start_time)) return false;
        return end_time.equals(sessions.end_time);
    }

    @Override
    public int hashCode() {
        int result = session_name.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + cohort_id;
        result = 31 * result + module_id;
        result = 31 * result + start_time.hashCode();
        result = 31 * result + end_time.hashCode();
        result = 31 * result + id;
        return result;
    }
}
