package model.dao;

import model.entities.Project;

import java.sql.*;

/**
 * Created by asevruk on 12/9/2016.
 */
public class ProjectDAOImpl implements ProjectDAO<Project> {

    private static final String DB = "jdbc:postgresql://localhost:5433/test13";
    private static final String USER = "user1";
    private static final String PASS ="apppassword" ;
    private static  final String insertSql = "INSERT into Projects VALUES (?,?,?,?,?)";
    private static  final String selectById = "Select * from Companies where companie_id = ?";
    private static final String deleteSql = "DELETE from COMPANIES where companie_id  = ?  ";
    private static final String findByNameSql = "Select * from Companies where companie_name = ? ";
    private  static final String getAllSql  = "Select * from Companies";
    private  static final String updatetSql = "UPDATE Companies set companie_name = ? where companie_id = ?";

    PreparedStatement statement;


    @Override
    public void create(Project project) {
        try {
            loadDriver();
            Connection connection = connectToDB();
            statement = connection.prepareStatement(insertSql);
            statement.setInt(1, project.getProjectId());
            statement.setString(2,project.getProjectName());
            statement.setInt(3,project.getProjectCompanyId().getCompanyID());
            statement.setInt(4,project.getProjectCustomerId().getCustomerId());
            statement.setDate(5,  project.getProjectTimeStamp());

            statement.executeUpdate();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Project get(int id) {
        return null;
    }

    @Override
    public void update(Project project) {

    }

    @Override
    public void delete(int id) {

    }


    private Connection connectToDB() throws SQLException {
        return DriverManager.getConnection(DB,USER,PASS);
    }

    private void loadDriver() throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
    }
}
