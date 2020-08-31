package dao;

import models.Sessions;
import org.junit.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.sql.Timestamp;

import static org.junit.Assert.*;

public class Sql2oSessionDaoTest {

    private static Connection conn;
    private static Sql2oSessionDao sessionDao;

    @BeforeClass
    public static void setUp() throws Exception {
        //this method executes once and before all tests
        //TODO make sure to change this to your localhost before running tests
//        String connectionString = "jdbc:postgresql://localhost:5432/class_schedule_test";
//        Sql2o sql2o = new Sql2o(connectionString, "gideon", "33450715");

        String connectionString = "jdbc:postgres://ec2-52-70-15-120.compute-1.amazonaws.com:5432/dc3s96ls8kqvhf";
        Sql2o sql2o = new Sql2o(connectionString, "bdmoxcpjclbybe", "1721f547f35ba2a92f727c64d258d4e09b8466ec13618191633451f0e958faa3");

        sessionDao = new Sql2oSessionDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        //this method executes after each test
        System.out.println("Clearing database");
        sessionDao.clearAll();
    }

    @AfterClass
    public static void shutDown() throws Exception {
        conn.close();
        System.out.println("Connection closed");
    }

    @Test
    public void creatingSessionSetsId() {
        Sessions testSession = setupSession();
        assertNotEquals(0, testSession.getId());
    }

    @Test
    public void getAllReturnsAllSessions() {
        Sessions sessions = setupSession();
        assertEquals(1, sessionDao.getAll().size());
    }

    @Test
    public void findByIdReturnsCorrectSession() {
        Sessions testSession = setupSession();
        Sessions otherSession = setupSession();
        assertEquals(testSession, sessionDao.findById(testSession.getId()));
    }

    @Test
    public void deleteByIdDeletesTheCorrectSession() {
        Sessions testSession = setupSession();
        Sessions otherSession = setupSession();
        sessionDao.deleteById(otherSession.getId());
        assertEquals(1, sessionDao.getAll().size());
    }

    @Test
    public void clearAllDeletesAllRecords() {
        Sessions testSession = setupSession();
        Sessions otherSession = setupSession();
        sessionDao.clearAll();
        assertEquals(0, sessionDao.getAll().size());
    }
    //helper methods
    private Sessions setupSession() {
        Timestamp start_time = new Timestamp(System.currentTimeMillis());
        try{
            //we make our thread 'sleep' to simulate different start and end times
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Timestamp end_time = new Timestamp(System.currentTimeMillis());
        Sessions session = new Sessions("Unblocking session", "Heroku deployment and endpoints testing", 1, 1, start_time, end_time);
        sessionDao.createSession(session);
        return session;
    }
}