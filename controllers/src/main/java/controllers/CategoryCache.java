package controllers;

import dao.DAOCategory;
import data.DOCategory;
import data.IDOCategory;
import model.ModelFactory;

import java.util.ArrayList;
import java.util.List;

public class CategoryCache
{
    private static CategoryCache link;
    private static List<DOCategory> categoryCache;
    private static DAOCategory daoCategory;
    private static int freeID;
    private CategoryCache(){
        //do nothing
    }


    public static CategoryCache newInstance() {
        if(link == null){
            link = new CategoryCache();
            daoCategory = ModelFactory.getModel().getCategoryDAO(1);
            categoryCache = new ArrayList<>();
            categoryCache = daoCategory.getAll();
            freeID = 1;
        }
        return link;
    }




    public IDOCategory getCategory(int index) {
        return categoryCache.get(index);
    }

    public void add(String category){
        DOCategory doCategory = new DOCategory(freeID,category);
        categoryCache.add(doCategory);
        freeID++;
        daoCategory.add(doCategory);
    }

    public void change(int id,String newData){
        daoCategory.change(new DOCategory(id,newData) );
    }

    public void deleteCategory(int index) {
        categoryCache.remove(index);
        daoCategory.del(index);
    }


    public List<DOCategory> getAllCategories() {
        return categoryCache;
    }
}
