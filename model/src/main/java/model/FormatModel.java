package model;

import dao.DAOCategory;
import dao.DAONews;
import providers.DatabaseFP;
import providers.IProvider;
import providers.JsonFP;

public class FormatModel extends ModelFactory{
    //1 - DB
    //2 - JSON
    public DAONews getNewsDAO(int value) {
        IProvider provider;
        if (value==1){
            provider = new DatabaseFP();
        }
        else{
            provider = new JsonFP();
        }
        return new DAONews(provider);
    }

    public DAOCategory getCategoryDAO(int value) {
        IProvider provider;
        if (value==1){
            provider = new DatabaseFP();
        }
        else{
            provider = new JsonFP();
        }
        return new DAOCategory(provider);
    }
}
