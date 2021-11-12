package dao;

import data.DONews;
import providers.IProvider;

import java.util.List;

public class DAONews implements IDao<DONews> {
    IProvider provider;
    public static final String target = "news";


    public DAONews(IProvider provider){
        this.provider = provider;
    }

    public DONews get(int id) {
        return provider.get(target,id);
    }

    public List<DONews> getAll() {
        return provider.getAll(target);
    }

    public void change(DONews item) {
        provider.change(target,item);
    }

    public void add(DONews item) {
        provider.add(target,item);
    }

    public void del(int id) {
        provider.del(target,id);
    }
}
