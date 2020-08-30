package dao;

import models.Comments;

import java.util.List;

public interface CommentDao {
    //create new comment
    void createComment(Comments comment);

    List<Comments> getAll();
    Comments findById(int id);

    //delete
    void deleteById(int id);
    void clearAll();
}
