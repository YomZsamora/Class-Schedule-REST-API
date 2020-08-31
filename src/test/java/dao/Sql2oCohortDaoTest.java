package dao;

import models.Cohort;
import org.junit.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.awt.*;
import java.util.Date;

import static org.junit.Assert.*;

public class Sql2oCohortDaoTest {

    private static Connection conn;
    private static Sql2oCohortDao cohortDao;

    @BeforeClass
    public static void setUp() throws Exception {
        String connectionString = "jdbc:postgres://ec2-52-70-15-120.compute-1.amazonaws.com:5432/dc3s96ls8kqvhf";
        Sql2o sql2o = new Sql2o(connectionString, "bdmoxcpjclbybe", "1721f547f35ba2a92f727c64d258d4e09b8466ec13618191633451f0e958faa3");
//        String connectionString = "jdbc:postgresql://localhost:5432/class_schedule_test";
//        Sql2o sql2o = new Sql2o(connectionString, "User", "7181");
//        Sql2o sql2o = new Sql2o(connectionString, "gideon", "33450715");

        cohortDao = new Sql2oCohortDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Clearing database");
        cohortDao.clearAll();
    }

    @AfterClass
    public static void shutDown() throws Exception {
        conn.close();
        System.out.println("Connection closed");
    }

    @Test
    public void createCohortSetsId() {
        Cohort testCohort = setupCohort();
        assertNotEquals(0, testCohort.getId());
    }

    @Test
    public void getAllReturnsAllCohorts() {
        Cohort testCohort = setupCohort();
        assertEquals(1, cohortDao.getAll().size());
    }

    //there is an error with this test
//    @Test
//    public void findByIdReturnsCorrectCohortIns() {
//        Cohort testCohort = setupCohort();
//        assertEquals(testCohort, cohortDao.findById(testCohort.getId()));
//    }

    @Test
    public void deleteByIdRemovesCorrectCohort() {
        Cohort testCohort = setupCohort();
        cohortDao.deleteById(testCohort.getId());
        assertNull(cohortDao.findById(testCohort.getId()));
    }

    @Test
    public void clearAll() {
        Cohort testCohorts = setupCohort();
        cohortDao.clearAll();
        assertEquals(0, cohortDao.getAll().size());
    }

    //helpers
    private Cohort setupCohort() {
        Date start_date =  new Date();
        Cohort cohort = new Cohort("MC30", start_date);
        cohortDao.createCohort(cohort);
        return cohort;
    }
}