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
    public void createSession(Sessions sessions) {
        String sqlString = "INSERT INTO sessions (session_name, description, cohort_id, module_id, start_time, end_time) VALUES (:session_name, :description, :cohort_id, :module_id, :start_time, :end_time)";

        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(sqlString, true)
                    .bind(sessions)
                    .addParameter("session_name", sessions.getSessionName())
                    .addParameter("description", sessions.getDescription())
                    .addParameter("cohort_id", sessions.getCohortId())
                    .addParameter("module_id", sessions.getModuleId())
                    .addParameter("start_time", sessions.getStart_time())
                    .addParameter("end_time", sessions.getEnd_time())
                    .executeUpdate()
                    .getKey();
            sessions.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(String.format("Problem here ! Sql2oException : %s", ex));
        }

    }

    @Override
    public List<Sessions> getAll() {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM sessions")
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Sessions.class);
        }
    }

    @Override
    public Sessions findById(int id) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM sessions WHERE id = :id")
                    .addParameter("id", id)
                    .throwOnMappingFailure(false)
                    .executeAndFetchFirst(Sessions.class);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from sessions WHERE id = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .throwOnMappingFailure(false)
                    .executeUpdate();

        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public void clearAll() {
        String sql = "DELETE from sessions";
        //this command resets the auto generated table ids
        //without this the ids will continue to increment even after clearing the table
        String resetSql = "ALTER SEQUENCE sessions_id_seq RESTART WITH 1;";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).throwOnMappingFailure(false).executeUpdate();
            con.createQuery(resetSql).throwOnMappingFailure(false).executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
}
