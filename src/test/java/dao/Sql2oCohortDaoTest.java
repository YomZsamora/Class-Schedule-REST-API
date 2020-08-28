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
        String connectionString = "jdbc:postgresql://localhost:5432/class_schedule_test";
        Sql2o sql2o = new Sql2o(connectionString, "User", "7181");

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

    @Test
    public void findByIdReturnsCorrectCohortIns() {

        Date start_date =  new Date();
        Cohort testCohort = new Cohort("MC30", start_date);
        cohortDao.createCohort(testCohort);
        assertEquals(testCohort, cohortDao.findById(testCohort.getId()));
    }

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