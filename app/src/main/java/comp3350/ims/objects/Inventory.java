package comp3350.ims.objects;
import java.util.ArrayList;
import java.util.Collections;

public class Inventory {
    private int numOfItems;
    public ArrayList < ItemType > items;

    public Inventory() {
        items = new ArrayList<>();
        numOfItems = 0;
    }

    public int getNumOfItems() {
        return numOfItems;
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
        if(index < 0|| index >= items.size())
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
}