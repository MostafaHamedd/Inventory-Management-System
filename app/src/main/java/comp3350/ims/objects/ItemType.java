package comp3350.ims.objects;

import java.util.*;

public class ItemType implements Comparable<ItemType> {
    public static final int MIN_QUANTITY = 10;
    private String name;
    private float price;
    private int quantity;
    private String location;
    private String date;
    private String category;
    private ArrayList < Item > items;
    private static int id = 0;
    private boolean needsRefill;

    public ItemType() {
        name = "";
        price = 0;
        quantity = 0;
        location = "";
        date = "";
        category = "";
        items = new ArrayList<>();
        needsRefill = true;
    } //Base constructor

    public ItemType(String name, float price, int quantity, String location, String date, String category) {
        this.name = name;
        this.price = price;
        this.quantity = 0;
        this.location = location;
        this.date = date;
        this.category = category;
        items = new ArrayList < Item > ();

        for (int i = 0; i < quantity; i++) {
            addItem(location, date);
        }

        checkRefill();
    }

    public void addItem(String location, String date) {
        Item item;
        id++;
        String stringId = Integer.toString(id);
        item = new Item(stringId, location, date);
        items.add(item);
        quantity++;
        checkRefill();
    }

    public void removeItem(int index) {
        if (!items.isEmpty() && index >= 0) {
            items.remove(index);
            quantity--;
        }
        checkRefill();
    }

    @Override
    public boolean equals(Object o){
        boolean isEqual = false;
        if(o instanceof ItemType){
            ItemType item = (ItemType) o;
            if((this.name).equals(item.getName())){
                isEqual = true;
            }
        }
        return isEqual;
    }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        this.name = n;
    }

    public float getPrice() {
        return price;
    }

    public Item getItem(int index) {
        return items.get(index);
    }

    public void setPrice(float p) {
        price = p;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getSize() {
        return items.size();
    }

    public void setQuantity(int q) {
        quantity = q;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String c) {
        category = c;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String l) {
        location = l;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String d) {
        date = d;
    }

    public boolean needsRefill() {
        return needsRefill;
    }

    public void setNeedsRefill(boolean needsRefill) {
        this.needsRefill = needsRefill;
    }

    private void checkRefill(){
        this.needsRefill = this.quantity <= MIN_QUANTITY;
    }

    @Override
    public int compareTo(ItemType o) {
        if(this.quantity == o.getQuantity())
            return 0;
        else if(this.quantity > o.getQuantity())
            return 1;
        else
            return -1;
    }
}
