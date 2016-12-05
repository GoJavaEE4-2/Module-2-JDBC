package model.dao;


import model.entities.Developer;

import java.util.List;

/**
 * Created by Vlad on 04.12.2016.
 */
public class DevelopersDAOImpl<T> implements DevelopersDAO<T>{
    @Override
    public void create(T t) {
        
    }

    @Override
    public T get(int id) {
        return null;
    }

    @Override
    public void update(T t) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Developer create() {
        return null;
    }

    @Override
    public Developer read(int id) {
        return null;
    }

    @Override
    public void update(Developer developer) {

    }

    @Override
    public void delete(Developer developer) {

    }

    @Override
    public List<Developer> getAll() {
        return null;
    }

    @Override
    public String findByName(String name) {
        return null;
    }

    @Override
    public String findByFullName(String firstName, String lastName) {
        return null;
    }
}
