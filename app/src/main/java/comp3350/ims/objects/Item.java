package comp3350.ims.objects;

public class Item {

    private String id;
    private String location;
    private String date;

    public Item() {
        id = "";
        location = "";
        date = "";
    }

    public Item(String location, String date) {
        this.date = date;
        this.location = location;
        id = "";
    }

    public Item(String id, String location, String date) {
        this.id = id;
        this.date = date;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public void setId(String i) {
        this.id = i;
    }

    public String getDate() {
        return date;
    }

    public String getLocation() {
        return location;
    }

}