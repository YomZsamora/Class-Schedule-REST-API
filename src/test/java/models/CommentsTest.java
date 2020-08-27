package models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CommentsTest {

    @Test
    public void commentInstantiatesCorrectly() {
        Comments comments = new Comments(1, "Session was well coordinated");
        assertTrue(true);
    }

    @Test
    public void getStudentId() {
        Comments comments = new Comments(1, "Session was well coordinated");
        assertEquals(1, comments.getStudentId());
    }

    @Test
    public void setStudentId() {
        Comments comments = new Comments(1, "Session was well coordinated");
        comments.setStudentId(1);
        assertEquals(1, comments.getStudentId());
    }

    @Test
    public void getContent() {
        Comments comments = new Comments(1, "Session was well coordinated");
        assertEquals("Session was well coordinated", comments.getContent());
    }

    @Test
    public void setContent() {
        Comments comments = new Comments(1, "Session was well coordinated");
        comments.setContent("Session was well coordinated");
        assertEquals("Session was well coordinated", comments.getContent());
    }
}