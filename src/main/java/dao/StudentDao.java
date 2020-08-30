package dao;

import models.Students;

import java.util.List;

public interface StudentDao {

    //student creates an account
    void createStudentAccount(Students students);

    //get all students
    List<Students> getAll();

    //get student by id
    Students findById(int id);

    //delete student account
    void deleteById(int id);
    void clearAll();
}
