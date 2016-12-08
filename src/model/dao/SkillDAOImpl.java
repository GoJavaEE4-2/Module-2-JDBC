package model.dao;

import model.entities.Skill;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import utilities.ConnectionUtils;

public class SkillDAOImpl implements SkillDAO<Skill> {

    String sqlStartTransaction = "START TRANSACTION";
    String commit = "COMMIT";
    String sqlCreate = "insert into skills (skill_name) VALUES (?)";
    String sqlGet = "select * from SKILLS where skill_id = ?";
    String sqlUpdate = "update skills set skill_name = ?";
    String sqlDelete = "delete from SKILLS where skill_id = ?";
    String sqlFindByName = "select skill_name from SKILLS where skill_name = ?";
    String sqlGetAll = "select * from SKILLS";


    @Override
    public void create(Skill skill) {
PreparedStatement preparedStatement ;
        try {
            ConnectionUtils.ConnectionToDatabase(ConnectionUtils.getProperties());
            ConnectionUtils.performPrepearedStatement(sqlCreate).setString(1, skill.getSkillName());
            ConnectionUtils.closePrepearedStatement();
            ConnectionUtils.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Skill get(int id) {


        String resultName = "";
        Skill skill = new Skill(id, resultName);
        try {
            ConnectionUtils.ConnectionToDatabase(ConnectionUtils.getProperties());


            ResultSet resultSet =  ConnectionUtils.performPrepearedStatement(sqlGet).setInt(1, id);
            while (resultSet.next()) {
                id = resultSet.getInt("skill_id");
                resultName = resultSet.getString("skill_name");
            }

            skill.setSkillId(id);
            skill.setSkillName(resultName);
            preparedStatement.close();
            closeConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return skill;
    }

    @Override
    public void update(Skill skill) {
        try {
            ConnectionToDatabase();
            preparedStatement = connection.prepareStatement(sqlUpdate);
            preparedStatement.setString(1, skill.getSkillName());
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
    public void delete(int id) {
        try {
            ConnectionToDatabase();
            preparedStatement = connection.prepareStatement(sqlDelete);
            preparedStatement.setInt(1, id);
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
    public String findByName(String name) {
        String resultName = "";
        try {
            ConnectionToDatabase();
            preparedStatement = connection.prepareStatement(sqlFindByName);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                resultName = resultSet.getString("skill_name");
            }
            preparedStatement.close();
            closeConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultName;
    }

    @Override
    public List<Skill> getAll() {
        List<Skill> skills = new ArrayList<>();
        try {
            while (ConnectionUtils.performStatement(sqlGetAll).next()) {
                skills.add(new Skill(ConnectionUtils.performStatement(sqlGetAll).getInt("skill_id"),
                        ConnectionUtils.performStatement(sqlGetAll).getString("skill_name")));
            }
            ConnectionUtils.closeStatement();
            ConnectionUtils.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return skills;
    }
}
