package providers;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;


import data.DOCategory;
import data.DONews;
import data.IBaseData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class DatabaseFP implements IProvider{
    public static final String news = "news";
    public static final String category = "category";

    private static final String username = "root";
    private static final String password = "";

    private static final String jdbsDriver = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/BD_NAME";
    public <T extends IBaseData> T get(String entry, int id) {
        DbUtils.loadDriver(jdbsDriver);
        if (news.equals(entry)) {
            return (T) getNews(id);
        }
        return (T) getCategory(id);
    }

    public <T extends IBaseData> List<T> getAll(String entry) {
        DbUtils.loadDriver(jdbsDriver);
        if(news.equals(entry)) {
            return (List<T>) getAllNews();
        } else {
            return (List<T>) getAllCategories();
        }
    }

    public <T extends IBaseData> void change(String entry, T item) {
        DbUtils.loadDriver(jdbsDriver);
        if (news.equals(entry)) {
            changeNews((DONews) item);
        } else {
            changeCategory((DOCategory) item);
        }
    }

    public <T extends IBaseData> void add(String entry, T item) {
        DbUtils.loadDriver(jdbsDriver);
        if (news.equals(entry)) {
            addNews((DONews) item);
        } else {
            addCategory((DOCategory) item);
        }
    }

    /*
    Функция может быть объединена в одну из-за отсутсиия необходимости в хенддете.
     */
    public <T extends IBaseData> void del(String entry, int id) {
        DbUtils.loadDriver(jdbsDriver);
        String query = "DELETE FROM " + entry + " WHERE id = ?";
        QueryRunner queryRunner = new QueryRunner();
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            queryRunner.update(connection, query, id);
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getID(String data) {
        String query = "SELECT * FROM category WHERE data = ?";
        ResultSetHandler<DOCategory> handler = new BeanHandler<>(DOCategory.class);
        QueryRunner queryRunner = new QueryRunner();

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            return queryRunner.query(connection, query, handler, data).getId();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    /*
    Функции для возвращзения конкретного DO . Необходимы из-за необходимости объявлять handler.
     */
    private DONews getNews(int id){
        String query = "SELECT * FROM news WHERE id = ?";
        ResultSetHandler<DONews> handler = new BeanHandler<>(DONews.class);
        QueryRunner queryRunner = new QueryRunner();

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            return queryRunner.query(connection, query, handler, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    private DOCategory getCategory(int id){
        String query = "SELECT * FROM category WHERE id = ?";
        ResultSetHandler<DOCategory> handler = new BeanHandler<>(DOCategory.class);
        QueryRunner queryRunner = new QueryRunner();

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            return queryRunner.query(connection, query, handler, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*
    Функция для возвращения листа DO. То же самое с хендлером.
     */
    private List<DOCategory> getAllCategories() {
        String query = "SELECT * FROM category";
        ResultSetHandler<List<DOCategory>> handler = new BeanListHandler<>(DOCategory.class);
        QueryRunner queryRunner = new QueryRunner();

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            return queryRunner.query(connection, query, handler);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    private List<DONews> getAllNews() {
        String query = "SELECT * FROM news";
        ResultSetHandler<List<DONews>> handler = new BeanListHandler<>(DONews.class);
        QueryRunner queryRunner = new QueryRunner();

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            return queryRunner.query(connection, query, handler);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    /*
    Функции изменения конкретного DO. Всё та же истоиря с хенлером.
     */
    private void changeNews(DONews item) {
        String query = "UPDATE news SET title = ?, date = ?, categoryId = ?, text = ?, author = ? WHERE id = ?";
        QueryRunner queryRunner = new QueryRunner();

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            //TODO:Доделать обновление
            queryRunner.update(connection, query, item.getTitle(),item.getCategoryId(), item.getText(), item.getAuthor(), item.getId());
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void changeCategory(DOCategory item) {
        String query = "UPDATE category SET data = ? WHERE id = ?";
        QueryRunner queryRunner = new QueryRunner();

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            queryRunner.update(connection, query, item.getData(), item.getId());
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
    Функции добавления нового значения  в дб. Не имеет смысла совмещать из-за огромной разницы между добавляемыми объектами.
     */
    private void addNews(DONews item) {
        String query = "INSERT INTO news (id, title, date, categoryId, text, author) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        QueryRunner queryRunner = new QueryRunner();

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            queryRunner.update(connection, query, item.getId(),
                    item.getTitle(),item.getCategoryId(), item.getText(), item.getAuthor());
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void addCategory(DOCategory item) {
        String query = "INSERT INTO category (id, name) VALUES (?, ?)";
        QueryRunner queryRunner = new QueryRunner();


        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            queryRunner.update(connection, query, item.getId(), item.getData());
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
