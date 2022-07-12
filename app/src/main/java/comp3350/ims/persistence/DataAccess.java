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

    public String getLocationList(ArrayList < String > locationList);

    public void addCategory(String category);

    public void addLocation(String location);

    public boolean removeLocation(String name);

    public boolean removeCategory(String name);

    public boolean isCategory(String name);

    public boolean isLocation(String name);
}
