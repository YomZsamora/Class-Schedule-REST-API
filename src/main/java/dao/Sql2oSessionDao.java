package dao;

import models.Sessions;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oSessionDao implements SessionDao{

    private final Sql2o sql2o;

    public Sql2oSessionDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void createSession(Sessions session) {
        String sqlString = "INSERT INTO sessions (session_name, description, cohort_id, module_id, start_time, end_time) VALUES " +
                "(:session_name, :description, :cohort_id, :module_id, :start_time, :end_time)";

        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(sqlString, true)
                    .bind(session)
                    .executeUpdate()
                    .getKey();
            session.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }

    }

    @Override
    public List<Sessions> getAll() {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM sessions")
                    .executeAndFetch(Sessions.class);
        }
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
