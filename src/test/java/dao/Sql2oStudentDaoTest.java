package dao;

import models.Students;
import org.junit.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class Sql2oStudentDaoTest {

    private static Connection conn;
    private static Sql2oStudentDao studentDao;

    @BeforeClass
    public static void setUp() throws Exception {
//        Sql2o sql2o = new Sql2o(connectionString, "gideon", "33450715");
//        String connectionString = "jdbc:postgresql://localhost:5432/class_schedule_test";
//        Sql2o sql2o = new Sql2o(connectionString, "User", "7181");

        String connectionString = "jdbc:postgresql://ec2-52-200-111-186.compute-1.amazonaws.com:5432/d9dbmvjbe8ikml";
        Sql2o sql2o = new Sql2o(connectionString, "mwstdukciefqhd", "077938e0cb68bfccc22eb8b19804f13757c2fbd4876103c77b525b70e499f110");


        studentDao = new Sql2oStudentDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Clearing database");
        studentDao.clearAll();
    }

    @AfterClass
    public static void shutDown() throws Exception {
        conn.close();
        System.out.println("Connection closed");
    }

    @Test
    public void creatingStudentAccountSetsId() {
        Students testStudent = setupStudent();
        assertNotEquals(0, testStudent.getId());
    }

    @Test
    public void getAllReturnsAllStudents() {
        Students testStudents = new Students("Ben","79adf126ad4", "Android", 1);
        studentDao.createStudentAccount(testStudents);
        assertEquals(1, studentDao.getAll().size());
    }

    @Test
    public void findByIdReturnsCorrectStudent() {
        Students testStudent = setupStudent();
        Students otherStudent = setupStudent();
        assertEquals(otherStudent, studentDao.findById(otherStudent.getId()));
    }

    @Test
    public void deleteByIdDeletesCorrectStudent() {
        Students testStudent = setupStudent();
        Students otherStudent = setupStudent();
        studentDao.deleteById(otherStudent.getId());
        assertEquals(1, studentDao.getAll().size());
    }

    @Test
    public void clearAllDeleteRecords() {
        Students testStudents = setupStudent();
        Students otherStudents = setupStudent();
        studentDao.clearAll();
        assertEquals(0, studentDao.getAll().size());
    }

    //helper methods
    private Students setupStudent(){
        Students student = new Students("Ben","79adf126ad4", "Android", 1);
        studentDao.createStudentAccount(student);
        return student;
    }
}