package comp3350.ims.objects;
import java.util.ArrayList;

public class Inventory {
    private int numofItems;
    public ArrayList<ItemType> items = new ArrayList();
    //private int size ;

    public Inventory(){
        numofItems = 0;
    }

    public int getNumOfItems(){
        return numofItems ;
    }

    public boolean addItem(ItemType newItem){
        if(!items.contains(newItem)) {
            items.add(newItem);
            numofItems++;
            return true;
        }
        return false;
    }

    public boolean removeItem(ItemType item){
        String targetId = item.getName();
        boolean removed = false;
        for(int i = 0; i < items.size(); i++) {
            if(items.get(i).getName().equals(targetId)) {
                items.remove(i);
                removed = true;
                numofItems--;
            }
        }
        return removed;
    }

    public ItemType getItem(int index){
        if(index < numofItems)return items.get(index);
        return null;
    }

    public ArrayList<ItemType> reorderByQuantity(){
        ArrayList<ItemType> newItemTypeList = new ArrayList<>();

        if(items.size() > 1) {
            for (int i = 0; i < items.size(); i++) {
                if (items.get(i).needsRefill()) {
                    newItemTypeList.add(0, items.get(i));
                } else {
                    newItemTypeList.add(items.get(i));
                }
            }

            items = newItemTypeList;
        }else{
            newItemTypeList = items;
        }

        return newItemTypeList;
    }
}
