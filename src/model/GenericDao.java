package model;

import java.util.List;

/**
 * Created by Vlad on 04.12.2016.
 */
public interface GenericDao <T>{
    T create(T t);
    List<T> get(long id);
    void update(T t);
    void delete(long id);

}
