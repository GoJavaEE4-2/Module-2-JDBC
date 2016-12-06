package model.dao;

import java.sql.*;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;

public class SkillDAOImpl<Skill> implements SkillDAO<Skill> {

    public static final String DRIVER = "org.postgresql.Driver";
    public static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    public static Connection connection = null;
    public static Statement statement = null;
    public static PreparedStatement preparedStatement = null;

    String sqlStartTransaction = "START TRANSACTION";
    String commit = "COMMIT";
    String sqlCreate = "insert into skills (skill_name) VALUES (?)";
    String sqlGet = "select skill_name from SKILLS where skill_id = ?";
    String sqlUpdate = "update skills set skill_name = ?";
    String sqlDelete = "delete from SKILLS where skill_id = ?";
    String sqlFindByName = "select skill_name from SKILLS where skill_name LIKE ?";
    String sqlGetAll = "select * from SKILLS";

    public static void ConnectionToDatabase() throws SQLException, ClassNotFoundException {
        Class.forName(DRIVER);
        // -Dusername = XXX -Dpassword-YYY (добавить логин и пароль в edit configurations в VM options)
        connection = DriverManager.getConnection(URL, System.getProperty("User"), System.getProperty("Password"));
    }

    public static void closeConnection() throws SQLException {
        connection.close();
    }


    @Override
    public void create(Skill skill) {
        try {
            ConnectionToDatabase();
            preparedStatement = connection.prepareStatement(sqlCreate);
            preparedStatement.setString(1, skill.toString());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Skill get(int id) {
        return null;
    }

    @Override
    public void update(Skill skill) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public String findByName(String name) {
        return null;
    }

    @Override
    public List<Skill> getAll() {
        return null;
    }
}
