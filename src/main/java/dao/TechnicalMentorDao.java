package dao;

import models.TechnicalMentor;

import java.util.List;

public interface TechnicalMentorDao {

    //create new account
    void createTechnicalMentorAccount(TechnicalMentor technicalMentor);
    void add(TechnicalMentor technicalMentor);

    //get a list of all TMs
    List<TechnicalMentor> getAll();
    TechnicalMentor findById(int id);

    //delete
    void deleteById(int id);
    void clearAll();
}
