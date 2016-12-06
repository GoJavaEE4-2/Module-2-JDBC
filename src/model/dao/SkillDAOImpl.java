package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

public class SkillDAOImpl<Skill> implements SkillDAO<Skill> {

    public static final String JDBC_DRIVER = "org.postgresql.Driver";
    public static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/postgres";
    public static Connection connection = null;
    public static Statement statement = null;
    public static PreparedStatement preparedStatement = null;



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
