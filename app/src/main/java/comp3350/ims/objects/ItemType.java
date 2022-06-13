package comp3350.ims.objects;

import java.util.*;

public class ItemType {

    private String name;
    private float price;
    private int quantity;
    private ArrayList<String> categories; //Going to change once we get category class
    private ArrayList<Item> items;

    public ItemType(){} //Base constructor

    //Constructor for creating the ItemType itself
    public ItemType(String name, float price, int quantity, List<String> categories){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.categories = new ArrayList<String>(categories);
        items = new ArrayList<Item>();
    }

    public String getName(){
        return name;
    }

    public void setName(String n){
        this.name = n;
    }

    public float getPrice(){
        return price;
    }

    public void setPrice(float p){
        price = p;
    }

    public int getQuantity(){
        return quantity;
    }

    public void setQuantity(int q){
        quantity = q;
    }

    public ArrayList<String> getCategories(){
        return categories;
    }

    public void addCatergory(String q){
        categories.add(q);
    }

    public void setCategories(ArrayList<String> c){
        categories = c;
    }

    public void addItem(Item i){
        items.add(i);
    }
}
