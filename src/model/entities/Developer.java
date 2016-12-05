package model.entities;
import java.util.Date;
/**
 * Created by asevruk on 12/5/2016.
 */
public class Developer {

    public Developer(int developerId, String developerName, int developerCompanyId, int developerProjectId, Date developerJoinDate) {
        this.developerId = developerId;
        this.developerName = developerName;
        this.developerCompanyId = developerCompanyId;
        this.developerProjectId = developerProjectId;
        this.developerJoinDate = developerJoinDate;
    }

    public int getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(int developerId) {
        this.developerId = developerId;
    }

    public String getDeveloperName() {
        return developerName;
    }

    public void setDeveloperName(String developerName) {
        this.developerName = developerName;
    }

    public int getDeveloperCompanyId() {
        return developerCompanyId;
    }

    public void setDeveloperCompanyId(int developerCompanyId) {
        this.developerCompanyId = developerCompanyId;
    }

    public int getDeveloperProjectId() {
        return developerProjectId;
    }

    public void setDeveloperProjectId(int developerProjectId) {
        this.developerProjectId = developerProjectId;
    }

    public Date getDeveloperJoinDate() {
        return developerJoinDate;
    }

    public void setDeveloperJoinDate(Date developerJoinDate) {
        this.developerJoinDate = developerJoinDate;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "developerId=" + developerId +
                ", developerName='" + developerName + '\'' +
                ", developerCompanyId=" + developerCompanyId +
                ", developerProjectId=" + developerProjectId +
                ", developerJoinDate=" + developerJoinDate +
                '}';
    }

    private int developerId ;
    private String developerName;
    private int  developerCompanyId;
    private int developerProjectId;
    private Date developerJoinDate;


}
