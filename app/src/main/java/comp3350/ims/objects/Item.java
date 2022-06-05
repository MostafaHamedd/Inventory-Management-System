package comp3350.ims.objects;

import java.util.List;

public class Item extends ItemType{

    private String id;
    private String location;
    private String date;

    public Item(){} //Base constructor

    public Item(String id,String location,String date, String name,
                float price, int quantity, List<String> categories){
        super(name,price,quantity,categories);
        this.id = id;
        this.location = location;
        this.date = date;
    }

    public String getId(){
        return id;
    }

    public void setId(String i){
        this.id = i;
    }

    public String getLocation(){
        return location;
    }

    public void setLocation(String l){
        location = l;
    }

    public String getDate(){
        return date;
    }

    public void setDate(String d){
        date = d;
    }
}
