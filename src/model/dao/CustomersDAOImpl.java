package model.dao;

import model.entities.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.entities.Customer;
import sun.security.util.Password;

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
     static  ResultSet performStatement(String query) throws SQLException, ClassNotFoundException {
        connect();
        statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        return resultSet;
    }


    @Override
    public void create(Customer customer) {
        try {
            connect();
            preparedStatement = connection.prepareStatement("INSERT INTO CUSTOMERS (customerName) VALUES (?)");
            preparedStatement.setString(1, customer.getCustomerName());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public Customer get(int id) {
        String resultName = "";
        Customer customer =null;
        try {
            connect();
            preparedStatement = connection.prepareStatement("SELECT * FROM CUSTOMERS WHERE customerId = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getInt("");
                resultName = resultSet.getString("");
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
            connect();
            preparedStatement = connection.prepareStatement("UPDATE CUSTOMERS SET customerName = ?");
            preparedStatement.setString(1, customer.getCustomerName());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(int id) {
        try {
            connect();
            preparedStatement = connection.prepareStatement("DELETE FROM CUSTOMERS WHERE customerId = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
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
            connect();
            preparedStatement = connection.prepareStatement("SELECT customerName FROM CUSTOMERS WHERE customerName = ?");
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                resultName = resultSet.getString("customerName");
            }
            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultName;
    }
}
