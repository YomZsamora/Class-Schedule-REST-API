package models;

public class Module {
    private String module_name;
    private int id;

    public Module(String module_name) {
        this.module_name = module_name;
    }

    public String getModuleName() {
        return module_name;
    }

    public void setModuleName(String module_name) {
        this.module_name = module_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
