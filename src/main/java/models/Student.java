package models;

public class Student {
    private final String name;
    private final int sessionId;
    private final int studentId;

    public Student(String name, int studentId, int sessionsId) {
        this.name = name;
        this.studentId = studentId;
        this.sessionId = sessionsId;
    }

    public String getName() {
        return name;
    }

    public int getSessionId() {
        return sessionId;
    }

    public int getStudentId() {
        return studentId;
    }
}
