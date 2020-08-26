package models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StudentTest {
    @Test
    public void studentInstantiatesCorrectly() {
        Student student = new Student ("Gideon", 1, 1);
        assertEquals(true, student instanceof Student);
    }

    @Test
    public void getStudentName() {
        Student student = new Student ("Gideon", 1,1);
        assertEquals("Gideon", student.getName());
    }

    @Test
    public void getStudentId() {
        Student student = new Student ("Gideon", 1, 1);
        assertEquals(1, student.getStudentId());
    }

    @Test
    public void getSessionId() {
        Student student = new Student ("Gideon", 1, 1);
        assertEquals(1, student.getSessionId());
    }
}