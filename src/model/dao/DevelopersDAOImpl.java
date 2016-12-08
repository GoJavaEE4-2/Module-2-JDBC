package model.dao;


import model.entities.Company;
import model.entities.Developer;
import model.entities.Project;

import javax.management.Query;
import java.sql.*;
import java.util.*;
import java.util.Date;


/**
 * Created by Vlad on 04.12.2016.
 */
public class DevelopersDAOImpl implements DevelopersDAO<Developer> {

    static void connect() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(DB, System.getProperty(User), System.getProperty(Password));
    }

    static ResultSet performStatement(String query) throws SQLException, ClassNotFoundException {
        connect();
        statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        return resultSet;
    }

    private static final String DB = "jdbc:postgresql://localhost:5433/postgres";
    private static final String User = "postgres";
    private static final String Password = "19071993";
    public static PreparedStatement preparedStatement = null;
    public static Statement statement = null;
    public static Connection connection = null;

    @Override
    public void create(Developer developer) {
        try {
            connect();
            preparedStatement = connection.prepareStatement("INSERT INTO DEVELOPERS (developerName) VALUES (?)");
            preparedStatement.setString(1, developer.getDeveloperName());
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
    public Developer get(int id) {
        String resultName = "";
        Developer developer = null;
        try {
            connect();
            preparedStatement = connection.prepareStatement("SELECT*FROM DEVELOPERS WHERE id=?");
            preparedStatement.setString(1, resultName);
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                resultSet.getInt("developerId");
                resultSet.getString("developerName");
            }
            developer.setDeveloperId(id);
            developer.setDeveloperName(resultName);
            preparedStatement.close();
            connection.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return developer;
    }

    @Override
    public void update(Developer developer) {
        try {
            connect();
            preparedStatement = connection.prepareStatement("UPDATE DEVELOPERS SET developerName = ?");
            preparedStatement.setString(1, developer.getDeveloperName());
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
    public void delete(int id) {
        try {
            connect();
            preparedStatement = connection.prepareStatement("DELETE * FROM DEVELOPERS WHERE developerId=?");
            preparedStatement.setInt(1, id);
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
    public String findByName(String name) {
        String resultName = "";
        try {
            connect();
            preparedStatement = connection.prepareStatement("SELECT developerName FROM DEVELOPERS WHERE developerName = ?");
            preparedStatement.setString(1, resultName);
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                resultName = resultSet.getString("developerName");
            }
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultName;
    }

    @Override
    public String findByFullName(String firstName, String lastName) {
        String resultName = "";
        try {
            connect();
            preparedStatement=connection.prepareStatement("SELECT * FROM DEVELOPERS" +
                    " WHERE DEVELOPERS firstName=?? && DEVELOPERS lastName=??");
            preparedStatement.setString(1, resultName);
            preparedStatement.executeUpdate();
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()){
                resultName= resultSet.getString("DeveloperFirstName" + "developerLastName");
            }
            preparedStatement.close();
            connection.close();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }

        return resultName;
    }
}
