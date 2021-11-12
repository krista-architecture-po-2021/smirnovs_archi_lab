package data;

public interface IDONews extends IBaseData{
    void setTitle(String title);
    String getTitle();
    void setAuthor(String author);
    String getAuthor();

    void setText(String text);
    String getText();

    int getCategoryId();
    void setCategoryId();
}
