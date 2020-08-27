package models;

import org.junit.Test;

import java.sql.Timestamp;

import static org.junit.Assert.assertEquals;

public class SessionsTest {
    @Test
    public void sessionsInstantiatesCorrectly() {
        Sessions sessions = setUpSession();
        assertEquals(true, sessions instanceof Sessions);
    }

    @Test
    public void getSessionName() {
        Sessions sessions = setUpSession();
        assertEquals("Standup", sessions.getSessionName());
    }

    @Test
    public void getDescription() {
        Sessions sessions = setUpSession();
        assertEquals("Yesterdays recap", sessions.getDescription());
    }

    @Test
    public void getCohortId() {
        Sessions sessions = setUpSession();
        assertEquals(29, sessions.getCohortId());
    }

    @Test
    public void getModuleId() {
        Sessions sessions = setUpSession();
        assertEquals(1, sessions.getModuleId());
    }

    @Test
    public void setSessionName() {
        Sessions sessions = setUpSession();
        sessions.setSessionName("Standup");
        assertEquals("Standup", sessions.getSessionName());
    }

    @Test
    public void setDescription() {
        Sessions sessions = setUpSession();
        sessions.setDescription("Yesterdays recap");
        assertEquals("Yesterdays recap", sessions.getDescription());
    }

    @Test
    public void setCohortId() {
        Sessions sessions = setUpSession();
        sessions.setCohortId(29);
        assertEquals(29, sessions.getCohortId());
    }

    @Test
    public void setModuleId() {
        Sessions sessions = setUpSession();
        sessions.setModuleId(1);
        assertEquals(1, sessions.getModuleId());
    }

    @Test
    public void setId() {
        Sessions sessions = setUpSession();
        sessions.setId(1);
        assertEquals(1, sessions.getId());
    }

    //helper methods
    private Sessions setUpSession() {
        Timestamp start_time = new Timestamp(System.currentTimeMillis());
        try{
            //we make our thread 'sleep' to simulate different start and end times
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Timestamp end_time = new Timestamp(System.currentTimeMillis());
        Sessions sessions = new Sessions("Standup", "Yesterdays recap", 29,1,start_time, end_time);
        return sessions;
    }

}