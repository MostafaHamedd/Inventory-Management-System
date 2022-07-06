package comp3350.ims.objects;
import java.util.ArrayList;

import comp3350.ims.business.ProcessReorder;

public class Inventory {
    private int numOfItems;
    private ProcessReorder checkReorder;
    public ArrayList < ItemType > items;

    public Inventory() {
        items = new ArrayList();
        checkReorder = new ProcessReorder(items);
        numOfItems = 0;
    }

    public int getNumOfItems() {
        return numOfItems;
    }

    public boolean addItem(ItemType newItem) {
        if (newItem != null && !items.contains(newItem)) {
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

    public ItemType getItem(int index) {
         return items.get(index);
    }

    public void reorderByQuantity() {
        checkReorder.reorderByQuantity();
    }
}