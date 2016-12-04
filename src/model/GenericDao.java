package model;

/**
 * Created by Vlad on 04.12.2016.
 */
public interface GenericDao <T>{
    T create(T t);
    T get(long id);
    T update(T t);
    T delete(long id);

}
