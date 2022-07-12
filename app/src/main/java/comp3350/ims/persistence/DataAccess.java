package comp3350.ims.persistence;
import java.util.ArrayList;
import java.util.List;

import comp3350.ims.objects.Inventory;
import comp3350.ims.objects.ItemType;

public interface DataAccess {
    void open(String string);

    void close();

    public Inventory getActiveInventory();

    public String insertItem(ItemType item);

    public String getCategoryList(ArrayList < String > categoryList);

    public void addCategory(String category);
}
