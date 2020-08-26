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

}