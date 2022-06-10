package comp3350.ims.objects;

import java.util.List;

public class Item{

    private String name;
    private float price;
    private String id;
    private String location;
    private String date;
    private List<String> categories;

    public Item(){} //Base constructor

    public Item(String id,String location,String date, String name,
                float price, List<String> categories){
        this.id = id;
        this.location = location;
        this.date = date;
        this.name = name;
        this.price = price;
        this.categories = categories;
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

    public List<String> getCategories() {
        return categories;
    }

    public void addCategorie(String categorie) {
       categories.add(categorie);
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
