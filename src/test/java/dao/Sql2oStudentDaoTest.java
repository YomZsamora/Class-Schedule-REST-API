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

        String connectionString = "jdbc:postgres://ec2-52-70-15-120.compute-1.amazonaws.com:5432/dc3s96ls8kqvhf";
        Sql2o sql2o = new Sql2o(connectionString, "bdmoxcpjclbybe", "1721f547f35ba2a92f727c64d258d4e09b8466ec13618191633451f0e958faa3");


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