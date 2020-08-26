package models;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SessionsTest {
    @Test
    public void sessionsInstantiatesCorrectly() {
        Sessions sessions = new Sessions("Standup", "Samora", "https://meet.google.com/fxm-xjtr-dxm");
        assertEquals(true, sessions instanceof Sessions);
    }

    @Test
    public void getsSessionsTitle() {
        Sessions sessions = new Sessions("Standup", "Samora", "https://meet.google.com/fxm-xjtr-dxm");
        assertEquals("Standup", sessions.getSessionsTitle());
    }

}