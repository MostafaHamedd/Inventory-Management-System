package comp3350.ims.objects;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Inventory {
    private int numOfItems;
    public ArrayList <ItemType> items;
    private  ArrayList<ItemType> inventory;

    public Inventory() {
        items = new ArrayList();
        inventory = new ArrayList();
        numOfItems = 0;
    }

    public int getNumOfItems() {
        return items.size();
    }

    public boolean addItem(ItemType newItem) {
        if (!items.contains(newItem)) {
            items.add(newItem);
            numOfItems++;
            return true;
        }
        return false;
    }

    public boolean removeItem(ItemType item) {
        String targetId = item.getName();
        boolean removed = false;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getName().equals(targetId)) {
                items.remove(i);
                removed = true;
                numOfItems--;
            }
        }
        return removed;
    }

    public ItemType getItem(int index) {
        if (index < numOfItems) return items.get(index);
        return null;
    }

    public ArrayList <ItemType> reorderByQuantity() {
        ArrayList <ItemType> newItemTypeList = new ArrayList <> ();

        if (items.size() > 1) {
            for (int i = 0; i < items.size(); i++) {
                if (items.get(i).needsRefill()) {
                    newItemTypeList.add(0, items.get(i));
                } else {
                    newItemTypeList.add(items.get(i));
                }
            }
            items = newItemTypeList;
        } else {
            newItemTypeList = items;
        }

        return newItemTypeList;
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