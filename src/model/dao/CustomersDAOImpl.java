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


    @Override
    public void create(Customer customer) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(DB, System.getProperty(User), System.getProperty(Password));
            PreparedStatement statement =
                    connection.prepareStatement("INSERT into Customer VALUES (?,?)");

            statement.setInt(1, customer.getCustomerId());
            statement.setString(2, customer.getCustomerName());


            //statement.setString(2,company.getCompanyName());
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    @Override
    public Customer get(int id) {
        String resultName = "";
        Customer customer=new Customer(id, resultName);
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection =
                    DriverManager.getConnection(DB, System.getProperty(User), System.getProperty(Password));
            PreparedStatement statement =
                    connection.prepareStatement("INSERT into Customer VALUES (?,?)");

            statement.setInt(1, id);
            statement.executeUpdate();


            //statement.setString(2,company.getCompanyName());
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                id = resultSet.getInt("skill_id");
                resultName = resultSet.getString("skill_name");
            }

            customer.setCustomerId(id);
            customer.setCustomerName(resultName);
            connection.close();
            statement.close();



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Customer customer) {

    }

    @Override
    public void delete(int id) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection =
                    DriverManager.getConnection(DB, System.getProperty(User), System.getProperty(Password));
            PreparedStatement preparedStatement =
                    connection.prepareStatement("DELETE from COMPANIES where companie_id  = ?  ");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String findByName(String name) {
        return null;
    }
}
