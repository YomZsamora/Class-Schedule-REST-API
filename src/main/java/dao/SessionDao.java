package dao;

import models.Sessions;

import java.util.List;

public interface SessionDao {

    //create new session'
    void createSession(Sessions sessions);

    //read db
    List<Sessions> getAll();
    Sessions findById(int id);

    //delete
    void deleteById(int id);
    void clearAll();
}
