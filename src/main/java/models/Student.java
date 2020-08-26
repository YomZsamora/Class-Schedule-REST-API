package models;

import java.util.Objects;

public class Student {
    public String studentName;
    public int studentId;
    public int sessionsId;
    public int id;


    public Student(String studentName, int studentId, int sessionsId) {
        this.studentName = studentName;
        this.studentId = studentId;
        this.sessionsId = sessionsId;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getSessionsId() {
        return sessionsId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentName(String studentName) {
        this.studentName= studentName;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setSessionsId(int sessionsId) {
        this.sessionsId = sessionsId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
