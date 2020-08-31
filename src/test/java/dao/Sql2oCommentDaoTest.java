package dao;

import models.Comments;
import models.Students;
import org.junit.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.nio.channels.Pipe;

import static org.junit.Assert.*;

public class Sql2oCommentDaoTest {

    private static Connection conn;
    private static Sql2oCommentDao commentDao;
    private static Sql2oStudentDao studentDao;

    @BeforeClass
    public static void setUp() throws Exception {
//        String connectionString = "jdbc:postgresql://localhost:5432/class_schedule_test";
//        Sql2o sql2o = new Sql2o(connectionString, "gideon", "33450715");

        String connectionString = "jdbc:postgresql://ec2-52-200-111-186.compute-1.amazonaws.com:5432/d9dbmvjbe8ikml";
        Sql2o sql2o = new Sql2o(connectionString, "mwstdukciefqhd", "077938e0cb68bfccc22eb8b19804f13757c2fbd4876103c77b525b70e499f110");

        commentDao = new Sql2oCommentDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Clearing database");
        commentDao.clearAll();
    }

    @AfterClass
    public static void shutDown() throws Exception {
        conn.close();
        System.out.println("Connection closed");
    }

    @Test
    public void creatingCommentSetsId() {
        Comments testComments = setupComments();
        assertNotEquals(0, testComments.getId());
    }

    @Test
    public void getAllReturnsAllComments() {
        Comments testComments = setupComments();
        assertEquals(1, commentDao.getAll().size());
    }

    @Test
    public void findByIdReturnsCorrectObject() {
        Comments testComments = setupComments();
        assertEquals(testComments, commentDao.findById(testComments.getId()));
    }

    @Test
    public void deleteByIdRemovesCorrectObject() {
        Comments comments = setupComments();
        Comments otherComments = setupComments();
        commentDao.deleteById(comments.getId());
        assertEquals(1, commentDao.getAll().size());
    }

    @Test
    public void clearAllRemovesAllRecords() {
        Comments comments = setupComments();
        commentDao.clearAll();
        assertEquals(0, commentDao.getAll().size());
    }

    //helpers
    private Comments setupComments(){
        Comments comments = new Comments(1, "productive session");
        commentDao.createComment(comments);
        return comments;
    }
}