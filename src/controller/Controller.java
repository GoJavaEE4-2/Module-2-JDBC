package controller;

import model.dao.SkillDAOImpl;
import model.entities.Skill;
import view.ConsoleDataInput;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Controller {

    SkillDAOImpl skillDAOImpl;

    public Controller(SkillDAOImpl skillDAOImpl) {
        this.skillDAOImpl = skillDAOImpl;
    }

    public void createSkillDB() throws IOException {
        Skill skill = new Skill(ConsoleDataInput.readString());
        skillDAOImpl.create(skill);
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
