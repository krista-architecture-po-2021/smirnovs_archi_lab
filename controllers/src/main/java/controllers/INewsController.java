package controllers;

import data.INews;

import java.util.List;

public interface INewsController {
    /**
     * Получение всех новостей
     */
    List<INews> getAllNews();

    /**
     * Получение конкретной новости
     */
    INews getNewsItem(int id);

    /**
     * Добавление новости
     */
    void add(INews news);

    /**
     * Изменение новости
     */
    void changeNewsItem(INews newNews);

    /**
     * Удаление новости
     */
    void deleteNewsItem(int id);

    /**
     * Получение новостей с нужной категорией.
     */
    List<INews> getNewsWithCategory(String category);
}
