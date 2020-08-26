package dao;

import models.Sessions;
import org.sql2o.Sql2o;

import java.util.List;

public class Sql2oSessionDao implements SessionDao{

    private final Sql2o sql2o;

    public Sql2oSessionDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void createSession(Sessions session) {

    }

    @Override
    public List<Sessions> getAll() {
        return null;
    }

    @Override
    public Sessions findById(int id) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void clearAll() {

    }
}
