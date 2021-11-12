package controllers;

import data.ICategory;

import java.util.List;

/**
 * Интерфейс для контроллера категорий
 */
public interface ICategoryController {
    /**
     * Возврат всех категорий.
     */
    List<ICategory> getCategoriesList();

    ICategory getCategory(int id);

    /**
     * Добавление категории
     */
    void addCategory(String data);

    /**
     * Изменение категории
     */
    void changeCategory(int id, String newData);

    /**
    удаление категории
     */
    void deleteCategory(int id);
}
