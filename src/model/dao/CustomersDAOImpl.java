package model.dao;

import model.entities.Customer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vlad on 04.12.2016.
 */
public class CustomersDAOImpl<T> implements CustomersDAO<T>{
    List<T>customersList=new ArrayList<T>();
    @Override
    public void create(T t) {

    }

    @Override
    public T get(int id) {
        return customersList.get(id);
    }

    @Override
    public void update(T t) {

    }

    @Override
    public void delete(int id) {
        customersList.remove(id);
    }

    @Override
    public Customer create() {
        return null;
    }

    @Override
    public Customer read(int id) {
        return null;
    }

    @Override
    public void update(Customer customer) {

    }

    @Override
    public void delete(Customer customer) {

    }

    @Override
    public List<Customer> getAll() {
        return null;
    }

    @Override
    public String findByName(String name) {
        return null;
    }
}
