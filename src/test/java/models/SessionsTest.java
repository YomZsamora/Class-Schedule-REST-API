package models;

import junit.framework.TestCase;
import org.junit.Test;

public class SessionsTest {
    @Test
    public void sessionsInstantiatesCorrectly() {
        Sessions sessions = new Sessions("Standup", "Samora", "https://meet.google.com/fxm-xjtr-dxm");
    }

}