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

    public String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Students students = (Students) o;

        if (cohort_id != students.cohort_id) return false;
        if (id != students.id) return false;
        if (!studentName.equals(students.studentName)) return false;
        if (!uid.equals(students.uid)) return false;
        return track.equals(students.track);
    }

    @Override
    public int hashCode() {
        int result = studentName.hashCode();
        result = 31 * result + uid.hashCode();
        result = 31 * result + track.hashCode();
        result = 31 * result + cohort_id;
        result = 31 * result + id;
        return result;
    }
}
