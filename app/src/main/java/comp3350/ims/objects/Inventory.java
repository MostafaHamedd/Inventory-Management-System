package comp3350.ims.objects;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Inventory {
    private int numOfItems;
    public ArrayList <ItemType> items;

    public Inventory() {
        items = new ArrayList<>();
        numOfItems = 0;
    }

    public Inventory(ArrayList<ItemType> items) {
        this.items = items;
        numOfItems = items.size();
    }

    public int getNumOfItems() {
        return items.size();
    }

    public boolean addItem(ItemType newItem) {
        if (newItem != null && !(items.contains(newItem))) {
            items.add(newItem);
            numOfItems++;
            return true;
        }
        return false;
    }

    public boolean removeItem(ItemType item){

        boolean removed = false;

        for (int i = 0; i < items.size(); i++) {
            if ((items.get(i)).equals(item)) {
                items.remove(i);
                removed = true;
                numOfItems--;
            }
        }
        return removed;
    }

    public ItemType getItem(int index) throws IndexOutOfBoundsException {
        if(index < 0|| index >= items.size() || items.size() == 0)
            throw new IndexOutOfBoundsException();
        return items.get(index);
    }

    public void reorderByQuantity() {

        int numberOfRefill = 0;
        if (items.size() > 0) {

            for (int i = 0; i < items.size(); i++) {
                if (items.get(i).needsRefill()) {
                    items.add(0,items.remove(i));
                    numberOfRefill++;
                }
            }

            Collections.sort(items.subList(0, numberOfRefill));
        }
    }

    public void sortByName(){
        Collections.sort(items, new Comparator<ItemType>() {
            @Override
            public int compare(ItemType itemType1, ItemType itemType2) {
                return itemType1.getName().compareTo(itemType2.getName());
            }
        });
    }

    public void reverseSortByName(){
        Collections.sort(items, new Comparator<ItemType>() {
            @Override
            public int compare(ItemType itemType1, ItemType itemType2) {
                return itemType2.getName().compareTo(itemType1.getName());
            }
        });
    }

    public void sortByPrice() {
        Collections.sort(items, new Comparator<ItemType>() {
            @Override
            public int compare(ItemType itemType1, ItemType itemType2) {
                return Float.compare(itemType1.getPrice(),itemType2.getPrice());
            }
        });
    }

    public void reverseSortByPrice() {
        Collections.sort(items, new Comparator<ItemType>() {
            @Override
            public int compare(ItemType itemType1, ItemType itemType2) {
                return Float.compare(itemType2.getPrice(),itemType1.getPrice());
            }
        });
    }
}
