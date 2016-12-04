package model;

import java.util.Date;

public class Project {

    private Integer project_id;
    private String project_name;
    private Date project_timestamp;
    private double project_cost;

    public Project(Integer project_id, String project_name, Date project_timestamp, double project_cost) {
        this.project_id = project_id;
        this.project_name = project_name;
        this.project_timestamp = project_timestamp;
        this.project_cost = project_cost;
    }

    public Integer getProject_id() {
        return project_id;
    }

    public void setProject_id(Integer project_id) {
        this.project_id = project_id;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public Date getProject_timestamp() {
        return project_timestamp;
    }

    public void setProject_timestamp(Date project_timestamp) {
        this.project_timestamp = project_timestamp;
    }

    public double getProject_cost() {
        return project_cost;
    }

    public void setProject_cost(double project_cost) {
        this.project_cost = project_cost;
    }
}
