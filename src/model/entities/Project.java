package model.entities;

import java.util.Date;

public class Project {

    private int projectID;
    private String projectName;
    private int projectCompanyId;
    private int projectCustomerId;
    private Date projectTimeStamp;

    public Project(int projectID, String projectName, int projectCompanyId, int projectCustomerId, Date projectTimeStamp) {
        this.projectID = projectID;
        this.projectName = projectName;
        this.projectCompanyId = projectCompanyId;
        this.projectCustomerId = projectCustomerId;
        this.projectTimeStamp = projectTimeStamp;
    }

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public int getProjectCompanyId() {
        return projectCompanyId;
    }

    public void setProjectCompanyId(int projectCompanyId) {
        this.projectCompanyId = projectCompanyId;
    }

    public int getProjectCustomerId() {
        return projectCustomerId;
    }

    public void setProjectCustomerId(int projectCustomerId) {
        this.projectCustomerId = projectCustomerId;
    }

    public Date getProjectTimeStamp() {
        return projectTimeStamp;
    }

    public void setProjectTimeStamp(Date projectTimeStamp) {
        this.projectTimeStamp = projectTimeStamp;
    }
}
