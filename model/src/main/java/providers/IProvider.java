package providers;

import dao.IDao;
import data.DOCategory;
import data.IBaseData;

import java.util.List;

public interface IProvider {
    <T extends IBaseData> T get(String entry, int id);

    <T extends IBaseData> List<T> getAll(String entry);

    <T extends IBaseData> void change(String entry, T item);

    <T extends IBaseData> void add(String entry, T item);

    <T extends IBaseData> void del(String entry, int id);

    /*
    Вынужденная мера для совместимости DONews и News
     */
    int getID(String data);
}
