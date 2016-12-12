package model.dao;


import model.entities.Company;
import model.entities.Developer;
import model.entities.Project;
import utilities.ConnectionUtils;

import javax.management.Query;
import java.sql.*;
import java.util.*;
import java.util.Date;


/**
 * Created by Vlad on 04.12.2016.
 */
public class DevelopersDAOImpl implements DevelopersDAO<Developer> {
    private static final String DB = "jdbc:postgresql://localhost:5433/postgres";
    private static final String User = "postgres";
    private static final String Password = "19071993";
    public static PreparedStatement preparedStatement = null;
    public static Statement statement = null;
    public static Connection connection = null;

    static void connect() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(DB, System.getProperty(User), System.getProperty(Password));
    }




    @Override
    public void create(Developer developer) {
        try {
            ConnectionUtils.PrepearedStatementcreateDeveloper("INSERT INTO DEVELOPERS (developerName) VALUES (?)",  developer);
            connect();
            ConnectionUtils.closePrepearedStatement();
            ConnectionUtils.closeConnection();
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
            ResultSet resultSet = ConnectionUtils.PrepearedStatementGet("SELECT * FROM DEVELOPERS WHERE developerId = ?", id);
            while (resultSet.next()) {
                id = resultSet.getInt("developerId");
                resultName = resultSet.getString("developerName");

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
            ConnectionUtils.updateDeveloper("UPDATE DEVELOPERS SET developerName = ?",  developer);
            ConnectionUtils.closePrepearedStatement();
            ConnectionUtils.closeConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            ConnectionUtils.PrepearedStatementdelete("delete from DEVELOPERS where developerId = ?", id);
            ConnectionUtils.closePrepearedStatement();
            ConnectionUtils.closeConnection();
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
            ResultSet resultSet = ConnectionUtils.PrepearedStatementFindbyName("SELECT developerName FROM DEVELOPERS WHERE customerName = ?", name);
            while (resultSet.next()) {
                resultName = resultSet.getString("skill_name");
            }
            ConnectionUtils.closePrepearedStatement();
            ConnectionUtils.closeConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultName;
    }


}
