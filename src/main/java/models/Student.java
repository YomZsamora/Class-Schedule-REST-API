package models;

public class Student {
    private final String name;

    public Student(String name, int sessionsId) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
