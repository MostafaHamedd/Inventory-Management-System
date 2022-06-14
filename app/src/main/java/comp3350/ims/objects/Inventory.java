package comp3350.ims.objects;
import java.util.ArrayList;
public class Inventory {
    private int numofItems ;
    ArrayList<ItemType> itemTypes  ;



    public Inventory(){

        itemTypes  = new ArrayList() ;
        numofItems = 0;
    }

    public int getNumOfItems(){
        return numofItems ;
    }

    public boolean addItem(Item newItem){
        if(!itemTypes.contains(newItem)) {
            itemTypes.add(newItem) ;
            numofItems++ ;
            return true ;
        }
        return false ;
    }

    public boolean removeItem(String itemTypeName){
        String targetName= itemTypeName ;
        boolean removed = false ;
        for(int i = 0 ; i < itemTypes.size() ; i++) {
            if(itemTypes.get(i).getName().equals(targetName)) {
                itemTypes.remove(i) ;
                removed = true ;
                numofItems-- ;
            }
        }

        return removed ;
    }

    public ItemType getItem(String itemName){
        String targetId = itemName;
        ItemType item = null ;
        for(int i = 0 ; i < itemTypes.size() ; i++) {
            if(itemTypes.get(i).getName().equals(targetId)) {
                item = itemTypes.get(i) ;
            }
        }

        return item ;
    }


}
