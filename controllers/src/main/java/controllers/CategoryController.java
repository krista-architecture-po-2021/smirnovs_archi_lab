package controllers;

import data.Category;
import data.DOCategory;
import data.ICategory;
import data.IDOCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CategoryController implements ICategoryController {
    @Override
    public List<ICategory> getCategoriesList() {
        List<ICategory> result = new ArrayList<>();
        for (IDOCategory doCategory : CategoryCache.newInstance().getAllCategories()){
            result.add(new Category(
               doCategory.getId(),
               doCategory.getData()
            ));
        }
        return result;
    }

    @Override
    public ICategory getCategory(int id) {
        IDOCategory doCategory = CategoryCache.newInstance().getCategory(id);
        return new Category(doCategory.getId(),doCategory.getData());
    }

    @Override
    public void addCategory(String data) {
        CategoryCache.newInstance().add(data);
    }

    @Override
    public void changeCategory(int id, String newData) {
        CategoryCache.newInstance().change(id,newData);
    }

    @Override
    public void deleteCategory(int id) {
        CategoryCache.newInstance().deleteCategory(id);
    }
}
