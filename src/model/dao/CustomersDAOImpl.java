package model.dao;

import model.entities.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.entities.Customer;
import sun.security.util.Password;
import utilities.ConnectionUtils;

/**
 * Created by Vlad on 04.12.2016.
 */
public class CustomersDAOImpl implements CustomersDAO<Customer> {
    private static final String DB = "jdbc:postgresql://localhost:5433/postgres";
    private static final String User = "postgres";
    private static final String Password = "19071993";
    public static PreparedStatement preparedStatement = null;
    public static Statement statement=null;
    public static Connection connection = null;

    static void connect() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(DB, System.getProperty(User), System.getProperty(Password));
    }



    @Override
    public void create(Customer customer) {
        try {
            ConnectionUtils.PrepearedStatementcreateCustomers("INSERT INTO CUSTOMERS (customerName) VALUES (?)",  customer);
            ConnectionUtils.closePrepearedStatement();
            ConnectionUtils.closeConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public Customer get(int id) {
        String resultName = "";
        Customer customer =new Customer(id, null);
        try {
            ResultSet resultSet = ConnectionUtils.PrepearedStatementGet("SELECT * FROM CUSTOMERS WHERE customerId = ?", id);
            while (resultSet.next()) {
                id = resultSet.getInt("customerId");
                resultName = resultSet.getString("customerName");
            }
            customer.setCustomerId(id);
            customer.setCustomerName(resultName);
            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return customer;
    }

    @Override
    public void update(Customer customer) {
        try {
            ConnectionUtils.PrepearedStatementcreateCustomers("UPDATE CUSTOMERS SET customerName = ?",  customer);
            ConnectionUtils.closePrepearedStatement();
            ConnectionUtils.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(int id) {
        try {
            ConnectionUtils.PrepearedStatementdelete("DELETE FROM CUSTOMERS WHERE customerId = ?", id);
            ConnectionUtils.closePrepearedStatement();
            ConnectionUtils.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String findByName(String name) {
        String resultName = "";
        try {
            ResultSet resultSet = ConnectionUtils.PrepearedStatementFindbyName("SELECT customerName FROM CUSTOMERS WHERE customerName = ?", name);
            while (resultSet.next()) {
                resultName = resultSet.getString("skill_name");
            }
            ConnectionUtils.closePrepearedStatement();
            ConnectionUtils.closeConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultName;
    }
}
