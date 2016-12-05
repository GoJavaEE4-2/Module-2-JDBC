package model.dao;

import model.entities.Developer;

import java.util.List;

/**
 * Created by Vlad on 04.12.2016.
 */
public interface DevelopersDAO<T> extends DAO<T> {
    String findByName(String name);
    String findByFullName(String firstName, String lastName);
}
