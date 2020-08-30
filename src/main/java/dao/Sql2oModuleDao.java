package dao;

import models.Module;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oModuleDao implements ModuleDao {
    private final Sql2o sql2o;

    public Sql2oModuleDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void createModule(Module module) {
        String sqlString = "INSERT INTO module (name) VALUES (:name)";

        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(sqlString, true)
                    .addParameter("name", module.getModuleName())
                    .executeUpdate()
                    .getKey();
            module.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void add(Module module) {
        String sqlString = "INSERT INTO module (name) VALUES (:name)";

        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(sqlString, true)
                    .addParameter("name", module.getModuleName())
                    .executeUpdate()
                    .getKey();
            module.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Module> getAll() {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM module")
                    .executeAndFetch(Module.class);
        }
    }

    @Override
    public Module findById(int id) {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM module WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Module.class);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from module WHERE id = :id";
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
        String sql = "DELETE from module";
        String resetSql = "ALTER SEQUENCE module_id_seq RESTART WITH 1;";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
            con.createQuery(resetSql).executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
}
