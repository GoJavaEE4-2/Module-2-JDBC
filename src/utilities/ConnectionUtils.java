package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class ConnectionUtils {

    public static Connection connection = null;
    public static Statement statement = null;
    public static PreparedStatement preparedStatement = null;

    public static Properties getProperties() {

        FileInputStream fileInputStream;
        Properties property = new Properties();
        String path = "config.properties";

        try {
            fileInputStream = new FileInputStream(path);
            property.load(fileInputStream);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return property;
    }


    public static void ConnectionToDatabase(Properties properties) throws SQLException, ClassNotFoundException {
        String driver = properties.getProperty("db.driver");
        Class.forName(driver);
        connection = DriverManager.getConnection(properties.getProperty("db.url_up_to_9.3"),
                properties.getProperty("db.login"), properties.getProperty("db.password"));
    }

    public static void closeConnection() throws SQLException {
        connection.close();
    }

    public static void closeStatement() throws SQLException {
        statement.close();
    }

    public static void closePrepearedStatement() throws SQLException {
        preparedStatement.close();
    }

    public static ResultSet performStatement(String query) throws SQLException, ClassNotFoundException {
        ConnectionToDatabase(getProperties());
        statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        return resultSet;
    }

    public static PreparedStatement PrepearedStatementcreate(String create) throws SQLException, ClassNotFoundException {
        ConnectionToDatabase(getProperties());
        preparedStatement = connection.prepareStatement(create);
        preparedStatement.executeUpdate();
        return preparedStatement;
    }

    public static ResultSet PrepearedStatementGet(String get, int id) throws SQLException, ClassNotFoundException {
        ConnectionToDatabase(getProperties());
        preparedStatement = connection.prepareStatement(get);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet;
    }

    public static PreparedStatement PrepearedStatementdelete(String delete) throws SQLException, ClassNotFoundException {
        ConnectionToDatabase(getProperties());
        preparedStatement = connection.prepareStatement(delete);
        preparedStatement.executeUpdate();
        return preparedStatement;
    }

    public static ResultSet PrepearedStatementFindbyName (String FindbyName, String name) throws SQLException, ClassNotFoundException {
        ConnectionToDatabase(getProperties());
        preparedStatement = connection.prepareStatement(FindbyName);
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet;
    }


}

