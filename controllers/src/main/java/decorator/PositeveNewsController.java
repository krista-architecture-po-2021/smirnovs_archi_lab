package decorator;

import controllers.INewsController;
import data.INews;

import java.util.ArrayList;
import java.util.List;

public class PositeveNewsController extends NewsControllerDecorator {
    private String sadWords[];

    public PositeveNewsController(INewsController newsController, String sadWords[]){
        super(newsController);
        this.sadWords = sadWords;
    }

    @Override
    public List<INews> getAllNews() {
        List<INews> result = new ArrayList<>();
        for (INews news : super.getAllNews()){
            for (String sadWord:sadWords){
                if (!news.getText().contains(sadWord)){
                    result.add(news);
                }
            }
        }
        return result;
    }

}
