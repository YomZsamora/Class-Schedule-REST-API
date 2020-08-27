package dao;

import models.TechnicalMentor;
import org.sql2o.Sql2o;

import java.util.List;

public class Sql2oTechnicalMentorDao implements TechnicalMentorDao {

    private final Sql2o sql2o;

    public Sql2oTechnicalMentorDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void createTechnicalMentorAccount(TechnicalMentor technicalMentor) {

    }

    @Override
    public List<TechnicalMentor> getAll() {
        return null;
    }

    @Override
    public TechnicalMentor findById(int id) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void clearAll() {

    }
}
