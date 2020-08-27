package models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ModuleTest {
    @Test
    public void moduleInstantiatesCorrectly() {
        Module module = new Module("Angular");
        assertEquals(true, module instanceof Module);
    }
}