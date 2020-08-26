package models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StudentTest {
    @Test
    public void studentInstantiatesCorrectly() {
        Students student = new Students("Gideon", "F87dafhjdhfa987", "Android",1);
        assertEquals(true, student instanceof Students);
    }

    @Test
    public void getStudentName() {
        Students student = new Students("Gideon", "F87dafhjdhfa987", "Android",1);
        assertEquals("Gideon", student.getStudentName());
    }

    @Test
    public void getUid() {
        Students student = new Students("Gideon", "F87dafhjdhfa987", "Android",1);
        assertEquals("F87dafhjdhfa987", student.getUid());
    }

    @Test
    public void getCohortId() {
        Students student = new Students("Gideon", "F87dafhjdhfa987", "Android",1);
        assertEquals(1, student.getCohortId());
    }

    @Test
    public void setStudentName() {
        Students student = new Students("Gideon", "F87dafhjdhfa987", "Android",1);
        student.setStudentName("Gideon");
        assertEquals("Gideon", student.getStudentName());
    }

    @Test
    public void setUid() {
        Students student = new Students("Gideon", "F87dafhjdhfa987", "Android",1);
        student.setUid("F87dafhjdhfa987");
        assertEquals("F87dafhjdhfa987", student.getUid());
    }

    @Test
    public void setCohortId() {
        Students student = new Students("Gideon", "F87dafhjdhfa987", "Android",1);
        student.setCohortId(1);
        assertEquals(1, student.getCohortId());
    }

    @Test
    public void setId() {
        Students student = new Students("Gideon", "F87dafhjdhfa987", "Android",1);
        student.setId(1);
        assertEquals(1, student.getId());
    }
}