package dao;

import models.Module;

import java.util.List;

public interface ModuleDao {
    //create new module
    void createModule(Module module);
    void add(Module module);

    List<Module> getAll();
    Module findById(int id);

    //delete
    void deleteById(int id);
    void clearAll();
}
