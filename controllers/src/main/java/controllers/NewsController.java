package controllers;

import dao.IDao;
import data.*;
import model.ModelFactory;

import java.util.ArrayList;
import java.util.List;

public class NewsController implements INewsController{

    public List<INews> getAllNews() {
        IDao<DONews> daoNews = ModelFactory.getModel().getNewsDAO(1);
        List <DONews> allNewsDO = daoNews.getAll();
        List<INews> afterConverting = new ArrayList<INews>();
        for(IDONews donews : allNewsDO){
            afterConverting.add(new News(
                    //id
                    donews.getId(),
                    //title
                    donews.getTitle(),
                    //author
                    donews.getAuthor(),
                    //text
                    donews.getText(),
                    //category
                    ModelFactory.getModel().getCategoryDAO(1).get(donews.getCategoryId()).getData()

            ));
        }
        return  afterConverting;
    }

    public INews getNewsItem(int id) {
        IDONews doNews  =  ModelFactory.getModel().getNewsDAO(1).get(id);
        return new News(
                //id
                doNews.getId(),
                //title
                doNews.getTitle(),
                //author
                doNews.getAuthor(),
                //text
                doNews.getText(),
                //category
                ModelFactory.getModel().getCategoryDAO(1).get(doNews.getCategoryId()).getData()
        );
    }

    public void add(INews news) {
        int id = ModelFactory.getModel().getCategoryDAO(1).getID(news.getCategory());
        if (id!=-1){
            DONews dOnews = new DONews(
                    //id
                    news.getId(),
                    //title
                    news.getTitle(),
                    //author
                    news.getAuthor(),
                    //text
                    news.getText(),
                    //category
                    id
            );
            ModelFactory.getModel().getNewsDAO(1).add(dOnews);
        }

    }

    public void changeNewsItem(INews newNews) {
        int id = ModelFactory.getModel().getCategoryDAO(1).getID(newNews.getCategory());
        if (id!=-1){
             ModelFactory.getModel().getNewsDAO(1).change(new DONews(newNews.getId(), newNews.getTitle(), newNews.getAuthor(), newNews.getText(),id));
        }
    }

    public void deleteNewsItem(int id) {
        ModelFactory.getModel().getNewsDAO(1).del(id);
    }

    public List<INews> getNewsWithCategory(String category) {
        List<INews> news = new ArrayList<INews>();
        for(INews newz : this.getAllNews()){
            if(newz.getCategory() != category){
                news.add(newz);
            }
        }
        return news;
    }
}
