package comp3350.ims.presentation;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import comp3350.ims.R;
import comp3350.ims.objects.Inventory;
import comp3350.ims.objects.Item;


public class ActiveInventoryActivity extends Activity {

    private Inventory activeInventory;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayList<String> list = new ArrayList<>();
        list.add("Dairy");
        activeInventory = new Inventory();
        activeInventory.addItem(new Item("0","gone","fdf", "item1",
        4, 5, list));
        activeInventory.addItem(new Item("0","gone","fdf", "item1",
                4, 5, list));
        activeInventory.addItem(new Item("0","gone","fdf", "item1",
                4, 5, list));
        activeInventory.addItem(new Item("0","gone","fdf", "item1",
                4, 5, list));
        activeInventory.addItem(new Item("0","gone","fdf", "item1",
                4, 5, list));
        activeInventory.addItem(new Item("0","gone","fdf", "item1",
                4, 5, list));
        activeInventory.addItem(new Item("0","gone","fdf", "item1",
                4, 5, list));
        activeInventory.addItem(new Item("0","gone","fdf", "item1",
                4, 5, list));
        activeInventory.addItem(new Item("0","gone","fdf", "item1",
                4, 5, list));
        activeInventory.addItem(new Item("0","gone","fdf", "item1",
                4, 5, list));
        activeInventory.addItem(new Item("0","gone","fdf", "item1",
                4, 5, list));
        activeInventory.addItem(new Item("0","gone","fdf", "item1",
                4, 5, list));
        setContentView(R.layout.activity_active_inventory);
        listView = (ListView) findViewById(R.id.activeInventoryList);
        listView.setAdapter(new ActiveInventoryAdapter(this, activeInventory));
    }
}
