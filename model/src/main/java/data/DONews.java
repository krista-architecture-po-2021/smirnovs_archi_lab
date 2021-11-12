package data;

public class DONews implements IDONews{

    String title;
    String author;
    String text;
    int categoryId;
    int id;

    public DONews(int id, String title, String author, String text, int categoryId){
        this.id = id;
        this.title = title;
        this.author = author;
        this.text = text;
        this.categoryId = categoryId;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId() {
        this.categoryId = categoryId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
