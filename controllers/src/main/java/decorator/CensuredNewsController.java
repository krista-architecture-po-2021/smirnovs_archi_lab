package decorator;

import controllers.INewsController;
import data.INews;
import data.News;

import java.util.ArrayList;
import java.util.List;

public class CensuredNewsController extends NewsControllerDecorator{
    private String forbitten[];
    INews censuredNews;

    public CensuredNewsController(INewsController newsController, String forbitten[]){
        super(newsController);
        this.forbitten = forbitten;
        this.censuredNews = new News(0,"[ИНФОРМАЦИЯ СКРЫТА НАСТРОЙКАМИ]","[ИНФОРМАЦИЯ СКРЫТА НАСТРОЙКАМИ]","[ИНФОРМАЦИЯ СКРЫТА НАСТРОЙКАМИ]","[ИНФОРМАЦИЯ СКРЫТА НАСТРОЙКАМИ]");
    }

    @Override
    public List<INews> getAllNews() {
        List<INews> result = new ArrayList<>();
        for (INews news : super.getAllNews()){
            for (String forb:forbitten){
                if (news.getText().contains(forb)){
                    result.add(censuredNews);
                    break;
                }
                else{
                    result.add(news);
                }
            }
        }
        return result;
    }
}
