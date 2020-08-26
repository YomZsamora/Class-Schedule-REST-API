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
        assertEquals("Gideon", student.getStudentName());
    }

    @Test
    public void getStudentId() {
        Student student = new Student ("Gideon", 1, 1);
        assertEquals(1, student.getStudentId());
    }

    @Test
    public void getSessionsId() {
        Student student = new Student ("Gideon", 1, 1);
        assertEquals(1, student.getSessionsId());
    }

    @Test
    public void setStudentName() {
        Student student = new Student ("Gideon", 1, 1);
        student.setStudentName("Gideon");
        assertEquals("Gideon", student.getStudentName());
    }

    @Test
    public void setStudentId() {
        Student student = new Student ("Gideon", 1, 1);
        student.setStudentId(1);
        assertEquals(1, student.getStudentId());
    }

    @Test
    public void setSessionsId() {
        Student student = new Student ("Gideon", 1, 1);
        student.setSessionsId(1);
        assertEquals(1, student.getSessionsId());
    }

    @Test
    public void setId() {
        Student student = new Student ("Gideon", 1, 1);
        student.setId(1);
        assertEquals(1, student.getId());
    }
}