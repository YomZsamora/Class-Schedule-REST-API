package models;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StudentTest {
    @Test
    public void studentInstantiatesCorrectly() {
        Student student = new Student ("Gideon", 1);
        assertEquals(true, student instanceof Student);
    }

    @Test
    public void getStudentName() {
        Student student = new Student ("Gideon", 1);
        assertEquals("Gideon", student.getName());
    }
}