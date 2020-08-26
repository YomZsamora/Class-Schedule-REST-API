package models;

public class Student {
    private final String name;
    private final int sessionId;

    public Student(String name, int sessionsId) {
        this.name = name;
        this.sessionId = sessionsId;
    }

    public String getName() {
        return name;
    }

    public int getSessionId() {
        return sessionId;
    }
}
