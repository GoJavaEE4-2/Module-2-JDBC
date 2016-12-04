package model;

/**
 * Created by Vlad on 04.12.2016.
 */
public class Company {
    private Integer companie_id;
    private String companie_name;

    public Company(Integer companie_id, String companie_name) {
        this.companie_id = companie_id;
        this.companie_name = companie_name;
    }

    public Integer getCompanie_id() {
        return companie_id;
    }

    public void setCompanie_id(Integer companie_id) {
        this.companie_id = companie_id;
    }

    public String getCompanie_name() {
        return companie_name;
    }

    public void setCompanie_name(String companie_name) {
        this.companie_name = companie_name;
    }
}
