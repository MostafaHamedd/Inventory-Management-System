package comp3350.ims.business;
import java.util.ArrayList;
import java.util.Collections;

import comp3350.ims.objects.ItemType;

public class ProcessReorder {

    private ArrayList<ItemType> items;

    public ProcessReorder( ArrayList<ItemType> items){
        this.items = items;
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
