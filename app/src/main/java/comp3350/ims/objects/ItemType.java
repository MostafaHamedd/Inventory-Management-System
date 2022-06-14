package comp3350.ims.objects;

import java.util.*;

public class ItemType {

    private String name;
    private float price;
    private int quantity;
    private String location;
    private String date;
    private String category; //Going to change once we get category class
    private ArrayList<Item> items;
    private static int id = 0;

    public ItemType(){} //Base constructor

    //Constructor for creating the ItemType itself
    public ItemType(String name, float price, int quantity, String location, String date,
                    String category){
        this.name = name;
        this.price = price;
        this.quantity = 0;
        this.location = location;
        this.date = date;
        this.category = category;
        items = new ArrayList<Item>();

        for(int i = 0; i < quantity; i++){
            addItem(location, date);
        }
    }

    public void addItem(String location, String date){
        Item item; ;
        id++;
        String stringId = Integer.toString(id);
       item =  new Item(stringId,location, date);
        items.add(item);
        quantity++;
    }

    public void removeItem(){
        if(!items.isEmpty()){
            items.remove(0);
            quantity--;
        }
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

    public Item getItem(int index){ return items.get(index) ; }



    public void setPrice(float p){
        price = p;
    }

    public int getQuantity(){
        return quantity;
    }

    public int getSize(){ return items.size();}
    public void setQuantity(int q){
        quantity = q;
    }

    public String getCategory(){
        return category;
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
