package data;


public class News implements INews {
    private  int id;
    private  String title;
    private  String author;
    private  String text;
    private  String category;
    public News(int id, String title, String author, String text, String category) {
        this.id = id;
        this.title = title;
        this. author = author;
        this.text = text;
        this.category = category;
    }

    public int getId() {
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
