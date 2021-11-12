package data;

/**
 * Интерфейс с набором очевидных гетеров и сетеров для новости.
 */
public interface INews {

   int getId();
   void setId(int id);

    String getTitle();

    void setTitle(String title);

    String getAuthor();

   void setAuthor(String author);

    String getText();


    void setText(String text);


    String getCategory();


   void setCategory(String category);
}
