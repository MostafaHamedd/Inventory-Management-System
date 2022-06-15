package comp3350.ims.objects;

import java.util.*;

public class ItemType {
    public static final int MIN_QUANTITY = 10;
    private String name;
    private float price;
    private int quantity;
    private String location;
    private String date;
    private ArrayList<String> categories; //Going to change once we get category class
    private ArrayList<Item> items;
    private static int id = 0;
    private boolean needsRefill;

    public ItemType(){} //Base constructor

    //Constructor for creating the ItemType itself
    public ItemType(String name, float price, int quantity, String location, String date, List<String> categories){
        this.name = name;
        this.price = price;
        this.quantity = 0;
        this.location = location;
        this.date = date;
        this.categories = new ArrayList<String>(categories);
        this.needsRefill = this.quantity > MIN_QUANTITY ? false : true;
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
        needsRefill = quantity > MIN_QUANTITY ? false : true;
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

    public ArrayList<String> getCategories(){
        return categories;
    }

    public void addCategory(String q){
        categories.add(q);
    }

    public void setCategories(ArrayList<String> c){
        categories = c;
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

    public boolean needsRefill() {
        return needsRefill;
    }

    public void setNeedsRefill(boolean needsRefill) {
        this.needsRefill = needsRefill;
    }
}
