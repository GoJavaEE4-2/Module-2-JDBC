package model.dao;

import model.entities.Company;

import java.sql.*;
import java.util.List;

/**
 * Created by asevruk on 12/7/2016.
 */
public class CompaniesDAOImpl implements CompaniesDAO<Company> {

    private static final String DB = "jdbc:postgresql://localhost:5433/test13";
    private static final String USER = "user1";
    private static final String PASS ="apppassword" ;


    @Override
    public void create(Company company) {
        try {

            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(DB,USER,PASS);

            PreparedStatement statement =
                    connection.prepareStatement("INSERT into Companies VALUES (?,?)");

            statement.setInt(1,company.getCompanyID());
            statement.setString(2,company.getCompanyName());


            //statement.setString(2,company.getCompanyName());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){


            }





        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Company get(int id) {
        String name = "";
        Company company = new Company(id,name);
        try {

            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(DB,USER,PASS);
            connection.setAutoCommit(false);
            PreparedStatement statement =
                    connection.prepareStatement("SELECT  * from COMPANIES where companie_id  = ?  ");
            statement.setInt(1,id);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){

                id = resultSet.getInt("companie_id ");
                name = resultSet.getString("companie_name ");
            }

            company.setCompanyID(id);
            company.setCompanyName(name);



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    public void update(Company company) {

    }

    @Override
    public void delete(int id) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(DB,USER,PASS);
            PreparedStatement statement =
                    connection.prepareStatement("DELETE from COMPANIES where companie_id  = ?  ");
            statement.setInt(1,id);
            statement.executeUpdate();
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

    @Override
    public List<Company> getAll() {
        return null;
    }
}
