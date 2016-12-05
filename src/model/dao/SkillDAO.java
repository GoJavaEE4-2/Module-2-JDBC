package model.dao;


import model.entities.Skill;

import java.util.List;

public interface SkillDAO extends DAO {
    public String findByName(String name);
    public List<Skill> getAll();
}
