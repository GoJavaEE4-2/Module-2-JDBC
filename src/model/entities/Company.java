package model.entities;

/**
 * Created by Vlad on 04.12.2016.
 */
public class Company {
    private int companieID;
    private String companieName;

    public Company(int companieID, String companieName) {
        this.companieID = companieID;
        this.companieName = companieName;
    }

    public int getCompanieID() {
        return companieID;
    }

    public void setCompanieID(int companieID) {
        this.companieID = companieID;
    }

    public String getCompanieName() {
        return companieName;
    }

    public void setCompanieName(String companieName) {
        this.companieName = companieName;
    }
}
