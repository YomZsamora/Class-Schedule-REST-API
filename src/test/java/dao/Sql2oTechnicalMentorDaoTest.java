package dao;

import models.TechnicalMentor;
import org.junit.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class Sql2oTechnicalMentorDaoTest {

    private static Connection conn;
    private static Sql2oTechnicalMentorDao technicalMentorDao;

    @BeforeClass
    public static void setUp() throws Exception {
        String connectionString = "jdbc:postgresql://localhost:5432/class_schedule_test";
        Sql2o sql2o = new Sql2o(connectionString, "User", "7181");

        technicalMentorDao = new Sql2oTechnicalMentorDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Clearing database");
        technicalMentorDao.clearAll();
    }

    @AfterClass
    public static void shutDown() throws Exception {
        conn.close();
        System.out.println("Connection closed");
    }

    @Test
    public void createTechnicalMentorAccountSetsId() {
        TechnicalMentor testTechnicalMentor = setupTechnicalMentor();
        assertNotEquals(0, testTechnicalMentor.getId());
    }

    @Test
    public void getAllReturnsAllTMs() {
        TechnicalMentor testTechnicalMentor = new TechnicalMentor("Samora", "7hi687bh8shf9780u");
        technicalMentorDao.createTechnicalMentorAccount(testTechnicalMentor);
        assertEquals(1, technicalMentorDao.getAll().size());
    }

    @Test
    public void findByIdReturnsCorrectResult() {
        TechnicalMentor testTechnicalMentor = setupTechnicalMentor();
        TechnicalMentor otherTechnicalMentor = setupTechnicalMentor();
        assertEquals(otherTechnicalMentor,technicalMentorDao.findById(otherTechnicalMentor.getId()));
    }

    @Test
    public void deleteByIdRemovesCorrectTM() {
        TechnicalMentor testTechnicalMentor = setupTechnicalMentor();
        TechnicalMentor otherTechnicalMentor = setupTechnicalMentor();
        technicalMentorDao.deleteById(otherTechnicalMentor.getId());
        assertEquals(1, technicalMentorDao.getAll().size());
    }

    @Test
    public void clearAllRemovesAllRecords() {
        TechnicalMentor testTechnicalMentor = setupTechnicalMentor();
        TechnicalMentor otherTechnicalMentor = setupTechnicalMentor();
        technicalMentorDao.clearAll();
        assertEquals(0, technicalMentorDao.getAll().size());
    }

    //helper methods
    private TechnicalMentor setupTechnicalMentor(){
        TechnicalMentor technicalMentor = new TechnicalMentor("Samora", "7hi687bh8shf9780u");
        technicalMentorDao.createTechnicalMentorAccount(technicalMentor);
        return technicalMentor;
    }
}