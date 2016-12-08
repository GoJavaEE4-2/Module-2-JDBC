package model.dao;

import model.entities.Skill;
import utilities.ConnectionUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
        try {
            ConnectionUtils.PrepearedStatementcreate(sqlCreate).setString(1, skill.getSkillName());
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
            ResultSet resultSet = ConnectionUtils.PrepearedStatementGet(sqlGet, id);
            while (resultSet.next()) {
                id = resultSet.getInt("skill_id");
                resultName = resultSet.getString("skill_name");
            }
            skill.setSkillId(id);
            skill.setSkillName(resultName);
            ConnectionUtils.closePrepearedStatement();
            ConnectionUtils.closeConnection();

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
            ConnectionUtils.PrepearedStatementcreate(sqlUpdate).setString(1, skill.getSkillName());
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
            ConnectionUtils.PrepearedStatementcreate(sqlUpdate).setInt(1, id);
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
           ResultSet resultSet = ConnectionUtils.PrepearedStatementFindbyName(sqlFindByName, name);
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
