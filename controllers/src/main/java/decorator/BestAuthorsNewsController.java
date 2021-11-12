package decorator;

import controllers.INewsController;
import data.INews;

import java.util.ArrayList;
import java.util.List;

public class BestAuthorsNewsController extends NewsControllerDecorator{
    private String bestAuthors[];

    public BestAuthorsNewsController(INewsController newsController,String bestAuthors[]){
        super(newsController);
        this.bestAuthors = bestAuthors;
    }

    @Override
    public List<INews> getAllNews() {
        List<INews> result = new ArrayList<>();
        for (INews news : super.getAllNews()){
            for (String author:bestAuthors){
                if (author.equals(news.getAuthor())){
                    result.add(news);
                    break;
                }
            }
        }
        return result;
    }
}
