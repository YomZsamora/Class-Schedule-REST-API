package dao;

import models.Cohort;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oCohortDao implements CohortDao {

    private final Sql2o sql2o;

    public Sql2oCohortDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void createCohort(Cohort cohort) {
        String sqlString = "INSERT INTO cohort (name, start_date) VALUES (:name, :start_date)";

        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(sqlString, true)
                    .addParameter("name",cohort.getName())
                    .addParameter("start_date",cohort.getStart_date())
                    .executeUpdate()
                    .getKey();
            cohort.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    public void add(Cohort cohort) {
        String sqlString = "INSERT INTO cohort (name, start_date) VALUES (:name, :start_date)";

        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(sqlString, true)
                    .addParameter("name",cohort.getName())
                    .addParameter("start_date",cohort.getStart_date())
                    .executeUpdate()
                    .getKey();
            cohort.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Cohort> getAll() {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM cohort")
                    .executeAndFetch(Cohort.class);
        }
    }

    @Override
    public Cohort findById(int id) {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM cohort WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Cohort.class);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from cohort WHERE id = :id";
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
        String sql = "DELETE from cohort";
        String resetSql = "ALTER SEQUENCE cohort_id_seq RESTART WITH 1;";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
            con.createQuery(resetSql).executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
}
