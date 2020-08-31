package dao;

import models.Module;
import org.junit.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class Sql2oModuleDaoTest {

    private static Connection conn;
    private static Sql2oModuleDao moduleDao;

    @BeforeClass
    public static void setUp() throws Exception {
        //this method executes once and before all tests
        //TODO make sure to change this to your localhost before running tests
        //String connectionString = "jdbc:postgresql://localhost:5432/class_schedule_test";
//        Sql2o sql2o = new Sql2o(connectionString, "gideon", "33450715");
        //Sql2o sql2o = new Sql2o(connectionString, "User", "7181");

        String connectionString = "jdbc:postgres://ec2-52-70-15-120.compute-1.amazonaws.com:5432/dc3s96ls8kqvhf";
        Sql2o sql2o = new Sql2o(connectionString, "bdmoxcpjclbybe", "1721f547f35ba2a92f727c64d258d4e09b8466ec13618191633451f0e958faa3");

        moduleDao = new Sql2oModuleDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        //this method executes after each test
        System.out.println("Clearing database");
        moduleDao.clearAll();
    }

    @AfterClass
    public static void shutDown() throws Exception {
        conn.close();
        System.out.println("Connection closed");
    }


    @Test
    public void creatingModuleSetsId() {
        Module testModule = setupModule();
        assertNotEquals(0, testModule.getId());
    }

    @Test
    public void getAllReturnsAllModuleInstances() {
        Module testModule = setupModule();
        assertEquals(1, moduleDao.getAll().size());
    }

    @Test
    public void findByIdReturnsCorrectModuleInstance() {
        Module testModule = setupModule();
        assertEquals(testModule, moduleDao.findById(testModule.getId()));
    }

    @Test
    public void deleteByIdRemovesCorrectModuleInstance() {
        Module testModule = setupModule();
        Module otherModule = setupModule();
        moduleDao.deleteById(testModule.getId());
        assertEquals(1, moduleDao.getAll().size());
    }

    @Test
    public void clearAll() {
        Module testModule = setupModule();
        Module otherModule = setupModule();
        moduleDao.clearAll();
        assertEquals(0, moduleDao.getAll().size());
    }

    //helpers
    private Module setupModule() {
        Module module = new Module("Angular");
        moduleDao.createModule(module);
        return module;
    }
}