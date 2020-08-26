package dao;

import models.Students;
import org.sql2o.Sql2o;

import java.util.List;

public class Sql2oStudentDao implements StudentDao {

    private final Sql2o sql2o;

    public Sql2oStudentDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void createStudentAccount(Students student) {

    }

    @Override
    public List<Students> getAll() {
        return null;
    }

    @Override
    public Students findById(int id) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void clearAll() {

    }
}
