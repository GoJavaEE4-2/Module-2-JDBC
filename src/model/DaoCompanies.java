package model;

public interface DaoCompanies {
    public Company create();

    public Company read(int id);

    public void update(Company company);

    public void delete(Company company);

    public List<Company> getAll();
}
