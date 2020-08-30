package dao;

import models.TechnicalMentor;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oTechnicalMentorDao implements TechnicalMentorDao {

    private final Sql2o sql2o;

    public Sql2oTechnicalMentorDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void createTechnicalMentorAccount(TechnicalMentor technicalMentor) {
        String sqlString = "INSERT INTO technical_mentors (name, uid) VALUES (:name, :uid)";

        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(sqlString, true)
                    .bind(technicalMentor)
                    .executeUpdate()
                    .getKey();
            technicalMentor.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<TechnicalMentor> getAll() {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM technical_mentors")
                    .executeAndFetch(TechnicalMentor.class);
        }
    }

    @Override
    public TechnicalMentor findById(int id) {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM technical_mentors WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(TechnicalMentor.class);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from technical_mentors WHERE id = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();

        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public void clearAll() {
        String sql = "DELETE from technical_mentors";
        String resetSql = "ALTER SEQUENCE technical_mentors_id_seq RESTART WITH 1;";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
            con.createQuery(resetSql).executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
}
