package model;

public interface DaoSkills {

    public Skill create();

    public Skill read(int id);

    public void update(Skill skill);

    public void delete(Skill skill);

    public List<Skill> getAll();
}
