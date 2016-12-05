package model.dao;

import model.entities.Customer;

import java.util.List;

/**
 * Created by Vlad on 04.12.2016.
 */
public interface CustomersDAO<T> extends DAO<T> {

   public String findByName(String name);

}
