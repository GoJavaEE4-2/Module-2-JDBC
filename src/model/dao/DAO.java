package model.dao;;


import java.util.List;

/**
 * Created by Vlad on 04.12.2016.
 */
public interface DAO<T>{
    void create(T t);
    int get(long id);
    void update(T t);
    int delete(long id);

}
