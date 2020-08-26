package models;

public class Students {
    private String studentName;
    private String uid;
    private String track;
    private int cohort_id;
    private int id;


    public Students(String studentName, String uid, String track, int cohort_id) {
        this.studentName = studentName;
        this.uid = uid;
        this.track = track;
        this.cohort_id = cohort_id;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getCohortId() {
        return cohort_id;
    }

    public String getUid() {
        return uid;
    }

    public void setStudentName(String studentName) {
        this.studentName= studentName;
    }

    public void setUid(String uid) {
        this.uid = uid;;
    }

    public void setCohortId(int cohort_id) {
        this.cohort_id = cohort_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
