package models;

public class TechnicalMentor {
    private String name;
    private String uid;
    private int id;

    public TechnicalMentor(String name, String uid) {
        this.name = name;
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUid() {
        return uid;
    }

    public void setUId(String uid) {
        this.uid = uid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TechnicalMentor that = (TechnicalMentor) o;

        if (id != that.id) return false;
        if (!name.equals(that.name)) return false;
        return uid.equals(that.uid);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + uid.hashCode();
        result = 31 * result + id;
        return result;
    }
}
