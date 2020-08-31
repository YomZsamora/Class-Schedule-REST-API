package models;

import java.util.Objects;

public class Students {
    private String name;
    private String uid;
    private String track;
    private int cohort_id;
    private int id;


    public Students(String name, String uid, String track, int cohort_id) {
        this.name = name;
        this.uid = uid;
        this.track = track;
        this.cohort_id = cohort_id;
    }

    public String getName() {
        return name;
    }

    public int getCohortId() {
        return cohort_id;
    }

    public String getUid() {
        return uid;
    }

    public void setName(String name) {
        this.name = name;
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
        return cohort_id == students.cohort_id &&
                id == students.id &&
                Objects.equals(name, students.name) &&
                Objects.equals(uid, students.uid) &&
                Objects.equals(track, students.track);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, uid, track, cohort_id, id);
    }

    //    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Students students = (Students) o;
//
//        if (cohort_id != students.cohort_id) return false;
//        if (id != students.id) return false;
//        if (!studentName.equals(students.studentName)) return false;
//        if (!uid.equals(students.uid)) return false;
//        return track.equals(students.track);
//    }
//
//    //hashcode error(Find why student name could be null)
//    @Override
//    public int hashCode() {
//        int result = studentName.hashCode();
//        result = 31 * result + uid.hashCode();
//        result = 31 * result + track.hashCode();
//        result = 31 * result + cohort_id;
//        result = 31 * result + id;
//        return result;
//    }
}
