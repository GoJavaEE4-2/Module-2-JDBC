package controller;

import model.dao.SkillDAOImpl;
import model.entities.Skill;

public class Main {
    public static void main(String[] args) {
        Skill skill = new Skill("testname");
        SkillDAOImpl skillDAO = new SkillDAOImpl();
       skillDAO.create(skill);

       // System.out.println(skillDAO.get(1));

        skillDAO.update(skill);
    }
}
