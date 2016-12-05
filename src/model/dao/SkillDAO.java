package model.dao;


import model.entities.Skill;

import java.util.List;

public interface SkillDAO<Skill> extends DAO<Skill> {
    public String findByName(String name);
    public List<Skill> getAll();
}
