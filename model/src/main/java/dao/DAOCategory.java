package dao;

import data.DOCategory;
import providers.IProvider;

import java.util.List;

public class DAOCategory implements IDao<DOCategory> {
    IProvider provider;
    public static final String target = "category";

    public DAOCategory(IProvider provider){
        this.provider = provider;
    }

    public DOCategory get(int id) {
        return provider.get(target,id);
    }

    public List<DOCategory> getAll() {
        return provider.getAll(target);
    }

    public void change(DOCategory item) {
        provider.change(target,item);
    }

    public void add(DOCategory item) {
        provider.add(target,item);
    }

    public void del(int id) {
        provider.del(target,id);
    }

    /*
    Метод ищет ID категории по её data.
     */
    public int getID(String data) {
        return provider.getID(data);
    }
}
