package data;

public class Category implements ICategory {
    int id;
    String data;

    public Category(int id, String data){
        this.id = id;
        this.data = data;
    }
    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getData() {
        return data;
    }

    @Override
    public void setData(String data) {
        this.data = data;
    }
}
