package models;

import java.util.Date;
import java.util.Objects;

public class Cohort {

    private String name;
    private Date start_date;
    private int id;

    public Cohort(String name, Date start_date) {
        this.name = name;
        this.start_date = start_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cohort cohort = (Cohort) o;
        return id == cohort.id &&
                Objects.equals(name, cohort.name) &&
                Objects.equals(start_date, cohort.start_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, start_date, id);
    }
}
