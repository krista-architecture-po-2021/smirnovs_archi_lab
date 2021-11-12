import data.ICategory;
import data.INews;

import java.util.List;

public interface IFacade {
    void addNews(INews news);
    INews getNews(int id);
    List<INews> getNewsList();
    void changeNews(int id, INews news);
    void deleteNews(int id);

    List<ICategory> getCategoriesList();
    void addCategory(String category);
    void changeCategory(int id, String category);
    void deleteCategory(int id);
}
