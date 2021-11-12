import controllers.CategoryController;
import controllers.ICategoryController;
import controllers.INewsController;
import controllers.NewsController;
import data.ICategory;
import data.INews;
import decorator.BestAuthorsNewsController;
import decorator.CensuredNewsController;
import decorator.PositeveNewsController;

import java.util.List;

public class Facade implements IFacade{
    INewsController newsController;
    ICategoryController categoryController;
    String sadWords[];
    String forbitten[];
    String bestAuthors[];

    public Facade(String sadWords[],String forbitten[], String bestAuthors[]){
        this.sadWords = sadWords;
        this.forbitten = forbitten;
        this.bestAuthors = bestAuthors;
        newsController = new NewsController();
        categoryController = new CategoryController();
        if(sadWords!=null){
            newsController = new PositeveNewsController(newsController,sadWords);
        }
        if (forbitten !=null){
            newsController = new CensuredNewsController(newsController,forbitten);
        }
        if(bestAuthors != null){
            newsController = new BestAuthorsNewsController(newsController,bestAuthors);
        }
    }

    @Override
    public void addNews(INews news) {
        newsController.add(news);
    }

    @Override
    public INews getNews(int id) {
        return newsController.getNewsItem(id);
    }

    @Override
    public List<INews> getNewsList() {
        return newsController.getAllNews();
    }

    @Override
    public void changeNews(int id, INews news) {
        newsController.changeNewsItem(news);
    }

    @Override
    public void deleteNews(int id) {
        newsController.deleteNewsItem(id);
    }

    @Override
    public List<ICategory> getCategoriesList() {
        return categoryController.getCategoriesList();
    }

    @Override
    public void addCategory(String category) {
        categoryController.addCategory(category);
    }

    @Override
    public void changeCategory(int id, String category) {
        categoryController.changeCategory(id,category);
    }

    @Override
    public void deleteCategory(int id) {
        categoryController.deleteCategory(id);
    }
}
