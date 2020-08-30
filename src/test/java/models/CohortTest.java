package models;

import org.junit.Test;

import java.sql.Timestamp;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CohortTest {
    @Test
    public void cohortInstantiatesCorrectly() {
        Cohort cohort = setUpCohort();
        assertEquals(true, cohort instanceof Cohort);
    }

    @Test
    public void setId() {
        Cohort cohort = setUpCohort();
        cohort.setId(1);
        assertEquals(1, cohort.getId());
    }


    //helpers
    private Cohort setUpCohort() {
        Date start_date = new Date();
        return new Cohort("MC30", start_date);
    }
}