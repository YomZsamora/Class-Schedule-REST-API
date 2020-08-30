package dao;

import models.Comments;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oCommentDao implements CommentDao {

    private final Sql2o sql2o;

    public Sql2oCommentDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void createComment(Comments comments) {
        String sqlString = "INSERT INTO comments (student_id, content) VALUES (:student_id, :content)";

        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(sqlString, true)
                    .bind(comments)
                    .addParameter("student_id", comments.getStudentId())
                    .addParameter("content", comments.getContent())
                    .executeUpdate()
                    .getKey();
            comments.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Comments> getAll() {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM comments")
                    .executeAndFetch(Comments.class);
        }
    }

    @Override
    public Comments findById(int id) {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM comments WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Comments.class);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from comments WHERE id = :id";
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
        String sql = "DELETE from comments";
        String resetSql = "ALTER SEQUENCE comments_id_seq RESTART WITH 1;";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
            con.createQuery(resetSql).executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
}
