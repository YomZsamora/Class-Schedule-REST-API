package dao;

import models.Students;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oStudentDao implements StudentDao {

    private final Sql2o sql2o;

    public Sql2oStudentDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void createStudentAccount(Students students) {
        String sqlString = "INSERT INTO students (name, cohort_id, track, uid) VALUES (:name, :cohort_id, :track, :uid)";

        try(Connection con = sql2o.open()){
            int id = (int)con.createQuery(sqlString, true)
                    .addParameter("name", students.getName())
                    .addParameter("cohort_id", students.getCohortId())
                    .addParameter("track", students.getTrack())
                    .addParameter("uid", students.getUid())
                    .executeUpdate()
                    .getKey();
            students.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Students> getAll() {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM students")
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Students.class);
        }
    }

    @Override
    public Students findById(int id) {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM students WHERE id = :id")
                    .addParameter("id", id)
                    .throwOnMappingFailure(false)
                    .executeAndFetchFirst(Students.class);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from students WHERE id = :id";
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
        String sql = "DELETE from students";
        String resetSql = "ALTER SEQUENCE students_id_seq RESTART WITH 1;";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).throwOnMappingFailure(false).executeUpdate();
            con.createQuery(resetSql).throwOnMappingFailure(false).executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
}
