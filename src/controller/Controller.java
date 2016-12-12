package controller;

import model.dao.*;
import model.entities.Company;
import model.entities.Customer;
import model.entities.Skill;
import view.ConsoleDataInput;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Controller {

    SkillDAOImpl skillDAOImpl;
    CustomersDAOImpl customersDAOimpl;
    CompaniesDAOImpl companiesDAOimpl;
    DevelopersDAOImpl developersDAOimpl;
    ProjectDAOImpl projectDAOimpl;

    public Controller(SkillDAOImpl skillDAOImpl, CustomersDAOImpl customersDAOimpl, CompaniesDAOImpl companiesDAOimpl, DevelopersDAOImpl developersDAOimpl, ProjectDAOImpl projectDAOimpl) {
        this.skillDAOImpl = skillDAOImpl;
        this.customersDAOimpl = customersDAOimpl;
        this.companiesDAOimpl = companiesDAOimpl;
        this.developersDAOimpl = developersDAOimpl;
        this.projectDAOimpl = projectDAOimpl;
    }

    public void createSkillDB() throws IOException {
        Skill skill = new Skill(ConsoleDataInput.readString());
        skillDAOImpl.create(skill);
    }
    public void createCustomersDB(CustomersDAOImpl customersDAOimpl) throws IOException{
        Customer customer=new Customer(ConsoleDataInput.readString());
        customersDAOimpl.create(customer);
    }
    public void createCompaniesDB(CompaniesDAOImpl companiesDAOimpl) throws IOException{
        Company company=new Company(ConsoleDataInput.readString());
        companiesDAOimpl.create(company);
    }



    public void updateSkillDB() throws IOException {
        Skill skill = new Skill(ConsoleDataInput.readString());
        skillDAOImpl.update(skill);
    }

    public Skill getSkillDB() throws IOException {
        Skill skill = skillDAOImpl.get(ConsoleDataInput.readInt());
        return skill;
    }

    public void deleteSkillFromDb() throws IOException {
        skillDAOImpl.delete(ConsoleDataInput.readInt());
    }

    public Skill findByNameSkillDB() throws IOException {
        Skill skill = new Skill(skillDAOImpl.findByName(ConsoleDataInput.readString()));
        return skill;
    }

    public List<Skill> getAllSkillsFromDb() throws IOException {
        List<Skill> skills = new ArrayList<>();
        return skills = skillDAOImpl.getAll();
    }

}
