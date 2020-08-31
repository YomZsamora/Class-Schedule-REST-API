package dao;

import models.Cohort;

import java.util.List;
import java.util.zip.CheckedOutputStream;

public interface CohortDao {

    //create new cohort
    void createCohort(Cohort cohort);

    List<Cohort> getAll();
    Cohort findById(int id);

    //delete
    void deleteById(int id);
    void clearAll();
}

