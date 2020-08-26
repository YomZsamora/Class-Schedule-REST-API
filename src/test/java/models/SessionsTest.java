package models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SessionsTest {
    @Test
    public void sessionsInstantiatesCorrectly() {
        Sessions sessions = new Sessions("Standup", "Samora", "https://meet.google.com/fxm-xjtr-dxm", 1);
        assertEquals(true, sessions instanceof Sessions);
    }

    @Test
    public void getsSessionsTitle() {
        Sessions sessions = new Sessions("Standup", "Samora", "https://meet.google.com/fxm-xjtr-dxm", 1);
        assertEquals("Standup", sessions.getSessionsTitle());
    }

    @Test
    public void getSessionsMentor() {
        Sessions sessions = new Sessions("Standup", "Samora", "https://meet.google.com/fxm-xjtr-dxm", 1);
        assertEquals("Samora", sessions.getSessionsMentor());
    }

    @Test
    public void getSessionsVenue() {
        Sessions sessions = new Sessions("Standup", "Samora", "https://meet.google.com/fxm-xjtr-dxm", 1);
        assertEquals("https://meet.google.com/fxm-xjtr-dxm", sessions.getSessionsVenue());
    }

    @Test
    public void getSessionsId() {
        Sessions sessions = new Sessions("Standup", "Samora", "https://meet.google.com/fxm-xjtr-dxm", 1);
        assertEquals(1, sessions.getSessionsId());
    }

    @Test
    public void setsSessionsTitle() {
        Sessions sessions = new Sessions("Standup", "Samora", "https://meet.google.com/fxm-xjtr-dxm", 1);
        sessions.setSessionsTitle("Standup");
        assertEquals("Standup", sessions.getSessionsTitle());
    }

    @Test
    public void setsSessionsMentor() {
        Sessions sessions = new Sessions("Standup", "Samora", "https://meet.google.com/fxm-xjtr-dxm", 1);
        sessions.setSessionsMentor("Samora");
        assertEquals("Samora", sessions.getSessionsMentor());
    }

}