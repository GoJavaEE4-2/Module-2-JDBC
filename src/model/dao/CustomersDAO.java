package model.dao;

import model.entities.Customer;

import java.util.List;

/**
 * Created by Vlad on 04.12.2016.
 */
public interface CustomersDAO<T> extends DAO<T> {
    public Customer create();

    public Customer read(int id);

    public void update(Customer customer);

    public void delete(Customer customer);

    public List<Customer> getAll();

    public String findByName(String name);
}
