package comp3350.ims.objects;
import java.util.ArrayList;

public class Inventory {
    private int numofItems ;
    public ArrayList<Item> items = new ArrayList() ;
    //private int size ;


    public Inventory(){
        numofItems = 0;
    }

    public int getNumOfItems(){
        return numofItems ;
    }

    public boolean addItem(Item newItem){
        if(!items.contains(newItem)) {
            items.add(newItem) ;
            numofItems++ ;
            return true ;
        }
        return false ;
    }

    public boolean removeItem(Item item){
        String targetId = item.getId() ;
        boolean removed = false ;
        for(int i = 0 ; i < items.size() ; i++) {
            if(items.get(i).getId().equals(targetId)) {
                items.remove(i) ;
                removed = true ;
                numofItems-- ;
            }
        }

        return removed ;
    }

    public Item getItem(String id){
        String targetId = id;
        Item item = null ;
        for(int i = 0 ; i < items.size() ; i++) {
            if(items.get(i).getId().equals(targetId)) {
                item = items.get(i) ;
            }
        }

        return item ;
    }

    public Item getItem(int index){

        return items.get(index) ;
    }


}
