package model;

import java.util.Date;

public class Project {

    private int projectID;
    private String projectName;
    private Date projectTimestamp;
    private double projectCost;

    public Project(int projectID, String projectName, Date projectTimestamp, double projectCost) {
        this.projectID = projectID;
        this.projectName = projectName;
        this.projectTimestamp = projectTimestamp;
        this.projectCost = projectCost;
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

    public Date getProjectTimestamp() {
        return projectTimestamp;
    }

    public void setProjectTimestamp(Date projectTimestamp) {
        this.projectTimestamp = projectTimestamp;
    }

    public double getProjectCost() {
        return projectCost;
    }

    public void setProjectCost(double projectCost) {
        this.projectCost = projectCost;
    }
}
