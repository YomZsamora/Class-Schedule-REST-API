package dao;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class Sql2oSessionDaoTest {

    private static Connection conn;
    private static Sql2oSessionDao sessionDao;

    @BeforeClass
    public static void setUp() throws Exception {
        //this method executes once and before all tests
        //TODO make sure to change this to your localhost before running tests
        String connectionString = "jdbc:postgresql://User:7181@localhost:5432/class_schedule_test";
        Sql2o sql2o = new Sql2o(connectionString);

        sessionDao = new Sql2oSessionDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void createSession() {
    }

    @Test
    public void getAll() {
    }

    @Test
    public void findById() {
    }

    @Test
    public void deleteById() {
    }

    @Test
    public void clearAll() {
    }
}