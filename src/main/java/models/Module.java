package models;

public class Module {
    private String name;
    private int id;

    public Module(String name) {
        this.name = name;
    }

    public String getModuleName() {
        return name;
    }

    public void setModuleName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
