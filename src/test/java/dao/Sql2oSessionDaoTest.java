package dao;

import models.Cohort;
import models.Module;
import models.Sessions;
import org.junit.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.sql.Timestamp;
import java.util.Date;

import static org.junit.Assert.*;

public class Sql2oSessionDaoTest {

    private static Connection conn;
    private static Sql2oSessionDao sessionDao;
    private static Sql2oCohortDao cohortDao;
    private static Sql2oModuleDao moduleDao;

    @BeforeClass
    public static void setUp() throws Exception {
        //this method executes once and before all tests
        //TODO make sure to change this to your localhost before running tests
//        String connectionString = "jdbc:postgresql://localhost:5432/class_schedule_test";
//        Sql2o sql2o = new Sql2o(connectionString, "gideon", "33450715");

        String connectionString = "jdbc:postgresql://ec2-52-200-111-186.compute-1.amazonaws.com:5432/d9dbmvjbe8ikml";
        Sql2o sql2o = new Sql2o(connectionString, "mwstdukciefqhd", "077938e0cb68bfccc22eb8b19804f13757c2fbd4876103c77b525b70e499f110");

        sessionDao = new Sql2oSessionDao(sql2o);
        cohortDao = new Sql2oCohortDao(sql2o);
        moduleDao = new Sql2oModuleDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        //this method executes after each test
        System.out.println("Clearing database");
        sessionDao.clearAll();
        cohortDao.clearAll();
        moduleDao.clearAll();
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
        java.util.Date start_date =  new Date();
        Cohort cohort = new Cohort("MC30",start_date);
        cohortDao.createCohort(cohort);
        Module module = new Module("Angular");
        moduleDao.createModule(module);
        Sessions session = new Sessions("Unblocking session", "Heroku deployment and endpoints testing", 1, 1, start_time, end_time);
        sessionDao.createSession(session);
        return session;
    }
}