package models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Technical_mentorTest {
    @Test
    public void mentorInstantiatesCorrectly() {
        Technical_mentor technical_mentor = new Technical_mentor("Samora", "F87dafxvdhfa987");
        assertEquals(true, technical_mentor instanceof Technical_mentor);
    }

    @Test
    public void getName() {
        Technical_mentor technical_mentor = new Technical_mentor("Samora", "F87dafxvdhfa987");
        assertEquals("Samora", technical_mentor.getName());
    }

    @Test
    public void setName() {
        Technical_mentor technical_mentor = new Technical_mentor("Samora", "F87dafxvdhfa987");
        technical_mentor.setName("Samora");
        assertEquals("Samora", technical_mentor.getName());
    }

    @Test
    public void getUid() {
        Technical_mentor technical_mentor = new Technical_mentor("Samora", "F87dafxvdhfa987");
        assertEquals("F87dafxvdhfa987", technical_mentor.getUid());
    }

    @Test
    public void setUid() {
        Technical_mentor technical_mentor = new Technical_mentor("Samora", "F87dafxvdhfa987");
        technical_mentor.setUId("F87dafxvdhfa987");
        assertEquals("F87dafxvdhfa987", technical_mentor.getUid());
    }

    @Test
    public void setId() {
        Technical_mentor technical_mentor = new Technical_mentor("Samora", "F87dafxvdhfa987");
        technical_mentor.setId(1);
        assertEquals(1, technical_mentor.getId());
    }
}