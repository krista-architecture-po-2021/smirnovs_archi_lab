package data;

public class DOCategory implements IDOCategory{
    int id;
    String data;
    public DOCategory(int id,String data){
        this.id = id;
        this.data = data;
    }
    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
