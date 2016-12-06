package model.entities;

import java.util.Date;

public class Project {

    private int project_id ;
    private String project_name;
    private Company project_company_id;
    private Customer project_customer_id;
    private Date project_start_timestamp;
    private double project_cost;

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public Company getProject_company_id() {
        return project_company_id;
    }

    public void setProject_company_id(Company project_company_id) {
        this.project_company_id = project_company_id;
    }

    public Customer getProject_customer_id() {
        return project_customer_id;
    }

    public void setProject_customer_id(Customer project_customer_id) {
        this.project_customer_id = project_customer_id;
    }

    public Date getProject_start_timestamp() {
        return project_start_timestamp;
    }

    public void setProject_start_timestamp(Date project_start_timestamp) {
        this.project_start_timestamp = project_start_timestamp;
    }

    public double getProject_cost() {
        return project_cost;
    }

    public void setProject_cost(double project_cost) {
        this.project_cost = project_cost;
    }

    @Override
    public String toString() {
        return "Project{" +
                "project_id=" + project_id +
                ", project_name='" + project_name + '\'' +
                ", project_company_id=" + project_company_id +
                ", project_customer_id=" + project_customer_id +
                ", project_start_timestamp=" + project_start_timestamp +
                ", project_cost=" + project_cost +
                '}';
    }








}
