package models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SessionsTest {
    @Test
    public void sessionsInstantiatesCorrectly() {
        Sessions sessions = new Sessions("Standup", "Yesterdays recap", 29,1,"https://meet.google.com/fxm-xjtr-dxm");
        assertEquals(true, sessions instanceof Sessions);
    }

    @Test
    public void getSessionName() {
        Sessions sessions = new Sessions("Standup", "Yesterdays recap", 29,1,"https://meet.google.com/fxm-xjtr-dxm");
        assertEquals("Standup", sessions.getSessionName());
    }

    @Test
    public void getDescription() {
        Sessions sessions = new Sessions("Standup", "Yesterdays recap", 29,1,"https://meet.google.com/fxm-xjtr-dxm");
        assertEquals("Yesterdays recap", sessions.getDescription());
    }

    @Test
    public void getCohortId() {
        Sessions sessions = new Sessions("Standup", "Yesterdays recap", 29,1,"https://meet.google.com/fxm-xjtr-dxm");
        assertEquals(29, sessions.getCohortId());
    }

    @Test
    public void getModuleId() {
        Sessions sessions = new Sessions("Standup", "Yesterdays recap", 29,1,"https://meet.google.com/fxm-xjtr-dxm");
        assertEquals(1, sessions.getModuleId());
    }

    @Test
    public void getSessionsVenue() {
        Sessions sessions = new Sessions("Standup", "Yesterdays recap", 29,1,"https://meet.google.com/fxm-xjtr-dxm");
        assertEquals("https://meet.google.com/fxm-xjtr-dxm", sessions.getSessionsVenue());
    }

    @Test
    public void setSessionName() {
        Sessions sessions = new Sessions("Standup", "Yesterdays recap", 29,1,"https://meet.google.com/fxm-xjtr-dxm");
        sessions.setSessionName("Standup");
        assertEquals("Standup", sessions.getSessionName());
    }

    @Test
    public void setDescription() {
        Sessions sessions = new Sessions("Standup", "Yesterdays recap", 29,1,"https://meet.google.com/fxm-xjtr-dxm");
        sessions.setDescription("Yesterdays recap");
        assertEquals("Yesterdays recap", sessions.getDescription());
    }

    @Test
    public void setsSessionsVenue() {
        Sessions sessions = new Sessions("Standup", "Yesterdays recap", 29,1,"https://meet.google.com/fxm-xjtr-dxm");
        sessions.setSessionsVenue("https://meet.google.com/fxm-xjtr-dxm");
        assertEquals("https://meet.google.com/fxm-xjtr-dxm", sessions.getSessionsVenue());
    }

    @Test
    public void setCohortId() {
        Sessions sessions = new Sessions("Standup", "Yesterdays recap", 29,1,"https://meet.google.com/fxm-xjtr-dxm");
        sessions.setCohortId(29);
        assertEquals(29, sessions.getCohortId());
    }

    @Test
    public void setModuleId() {
        Sessions sessions = new Sessions("Standup", "Yesterdays recap", 29,1,"https://meet.google.com/fxm-xjtr-dxm");
        sessions.setModuleId(1);
        assertEquals(1, sessions.getModuleId());
    }

    @Test
    public void setId() {
        Sessions sessions = new Sessions("Standup", "Yesterdays recap", 29,1,"https://meet.google.com/fxm-xjtr-dxm");
        sessions.setId(1);
        assertEquals(1, sessions.getId());
    }

}