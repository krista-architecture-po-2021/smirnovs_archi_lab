package decorator;

import controllers.INewsController;
import controllers.NewsController;
import data.INews;

import java.util.List;

public  abstract class NewsControllerDecorator implements INewsController {
    private INewsController newsController;
    public NewsControllerDecorator(INewsController newsController){
        this.newsController = newsController;
    }
    @Override
    public List<INews> getAllNews() {
        return newsController.getAllNews();
    }

    @Override
    public INews getNewsItem(int id) {
        return newsController.getNewsItem(id);
    }

    @Override
    public void add(INews news) {
        newsController.add(news);
    }

    @Override
    public void changeNewsItem (INews newNews) {
        newsController.changeNewsItem(newNews);
    }

    @Override
    public void deleteNewsItem(int id) {
        newsController.deleteNewsItem(id);
    }

    @Override
    public List<INews> getNewsWithCategory(String category) {
        return newsController.getNewsWithCategory(category);
    }
}
