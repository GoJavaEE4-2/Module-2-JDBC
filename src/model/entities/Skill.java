package model.entities;


public class Skill {
    private int skillId;
    private String skillName;

    public Skill(String skillName) {
        this.skillName = skillName;
    }

    public Skill(int skillId, String skillName) {
        this.skillId = skillId;
        this.skillName = skillName;
    }

    public int getskillId() {
        return skillId;
    }

    public void setskillId(int skillId) {
        this.skillId = skillId;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }
}
