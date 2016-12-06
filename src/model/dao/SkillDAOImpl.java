package model.dao;

import java.sql.*;
import java.util.List;

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

    public static void ConnectDB() throws SQLException, ClassNotFoundException {
        Class.forName(DRIVER);
        Connection connection = DriverManager.getConnection(URL, System.getProperty("User"), System.getProperty("Password"));

    }





    @Override
    public void create(Skill skill) {

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
