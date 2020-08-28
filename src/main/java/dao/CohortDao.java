package dao;

import models.Cohort;

import java.util.List;

public interface CohortDao {

    //create new cohort
    void createCohort(Cohort cohort);

    List<Cohort> getAll();
    Cohort findById(int id);

    //delete
    void deleteById(int id);
    void clearAll();
}

