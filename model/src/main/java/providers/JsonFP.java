package providers;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;


import data.DOCategory;
import data.IBaseData;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JsonFP implements IProvider{
    public static final String news = "news";
    public static final String category = "category";
    public static final String newsPath = "news.json";
    public static final String categoryPath = "category.json";

    ObjectMapper om;
    String path;

    public JsonFP(){
        om = new ObjectMapper();
    }

    public <T extends IBaseData> T get(String entry, int id) {
        configurate(entry);
        List<T> list = read();
        return list.get(id);
    }

    public <T extends IBaseData> List<T> getAll(String entry) {
        configurate(entry);
        return read();
    }

    public <T extends IBaseData> void change(String entry, T item) {
        configurate(entry);
        List<T> list = read();
        list.set(item.getId(),item);
        write(list);
    }

    public <T extends IBaseData> void add(String entry, T item) {
        configurate(entry);
        List<T> list = read();
        list.add(item);
        write(list);
    }

    public <T extends IBaseData> void del(String entry, int id) {
        configurate(entry);
        List<T> list = read();
        list.remove(id);
        write(list);
    }

    @Override
    public int getID(String data) {
            configurate(category);
            List<DOCategory> list = read();
            for (DOCategory category : list){
                if (category.getData().equals(data)){
                    return category.getId();
                }
            }
            return -1;
    }


    public <T> List<T> read(){
        File file = new File(path);
        try{
            return om.readValue(file, new TypeReference<List<T>>() {});
        }catch (StreamReadException e) {
            e.printStackTrace();
        } catch (DatabindException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public <T> void write(List<T> list){
        try {
            FileWriter fw = new FileWriter(path);
            fw.write(om.writeValueAsString(list));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void configurate(String configuration){
        if (configuration.equals(news)){
            path = newsPath;
        }
        else{
            path = categoryPath;
        }
    }
}
