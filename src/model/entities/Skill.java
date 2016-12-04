package model.entities;

/**
 * Created by Vlad on 04.12.2016.
 */
public class Skill {
    private int skillID;
    private String skillName;

    public Skill(int skillID, String skillName) {
        this.skillID = skillID;
        this.skillName = skillName;
    }

    public int getSkillID() {
        return skillID;
    }

    public void setSkillID(int skillID) {
        this.skillID = skillID;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }
}
