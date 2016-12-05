package model.entities;
import java.util.Date;
/**
 * Created by asevruk on 12/5/2016.
 */
public class Developer {

    public Developer(int developer_id, String developer_name, int developer_company_id, int developer_project_id, Date developer_join_date) {
        this.developer_id = developer_id;
        this.developer_name = developer_name;
        this.developer_company_id = developer_company_id;
        this.developer_project_id = developer_project_id;
        this.developer_join_date = developer_join_date;
    }

    public int getDeveloper_id() {
        return developer_id;
    }

    public void setDeveloper_id(int developer_id) {
        this.developer_id = developer_id;
    }

    public String getDeveloper_name() {
        return developer_name;
    }

    public void setDeveloper_name(String developer_name) {
        this.developer_name = developer_name;
    }

    public int getDeveloper_company_id() {
        return developer_company_id;
    }

    public void setDeveloper_company_id(int developer_company_id) {
        this.developer_company_id = developer_company_id;
    }

    public int getDeveloper_project_id() {
        return developer_project_id;
    }

    public void setDeveloper_project_id(int developer_project_id) {
        this.developer_project_id = developer_project_id;
    }

    public Date getDeveloper_join_date() {
        return developer_join_date;
    }

    public void setDeveloper_join_date(Date developer_join_date) {
        this.developer_join_date = developer_join_date;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "developer_id=" + developer_id +
                ", developer_name='" + developer_name + '\'' +
                ", developer_company_id=" + developer_company_id +
                ", developer_project_id=" + developer_project_id +
                ", developer_join_date=" + developer_join_date +
                '}';
    }

    private int developer_id ;
    private String developer_name;
    private int  developer_company_id;
    private int developer_project_id;
    private Date developer_join_date;


}
