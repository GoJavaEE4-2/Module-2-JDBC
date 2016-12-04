package model.dao;

import java.util.List;

/**
 * Created by Vlad on 04.12.2016.
 */
public interface DevelopersDAO<T> extends DAO<T> {
    public Developer create();

    public Developer read(int id);

    public void update(Developer developer);

    public void delete(Developer developer);

    public List<Developer> getAll();

    public String findByName(String name);

    public String findByFullName(String firstName, String lastName);
}
