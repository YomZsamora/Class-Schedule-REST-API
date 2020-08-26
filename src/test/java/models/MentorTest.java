package models;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MentorTest {
    @Test
    public void mentorInstantiatesCorrectly() {
        Mentor mentor = new Mentor ("Samora", 1);
        assertEquals(true, mentor instanceof Mentor);
    }

    @Test
    public void getMentorName() {
        Mentor mentor = new Mentor ("Samora", 1);
        assertEquals("Samora", mentor.getMentorName());
    }

    @Test
    public void setMentorName() {
        Mentor mentor = new Mentor ("Samora", 1);
        mentor.setMentorName("Samora");
        assertEquals("Samora", mentor.getMentorName());
    }
}