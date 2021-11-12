package dao;

import java.util.List;

public interface IDao<T> {
    T get(int id);
    List<T> getAll();
    void change(T item);
    void add(T item);
    void del(int id);

}
