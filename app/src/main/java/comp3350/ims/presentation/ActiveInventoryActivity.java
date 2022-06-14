package comp3350.ims.presentation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import comp3350.ims.R;
import comp3350.ims.business.AccessInventory;
import comp3350.ims.objects.Inventory;
import comp3350.ims.objects.Item;
import comp3350.ims.objects.ItemType;


public class ActiveInventoryActivity extends Activity {

    private Inventory activeInventory;
    private ListView listView;
    private AccessInventory accessInventory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        accessInventory = new AccessInventory();

        activeInventory = accessInventory.getActiveInventory();

        setContentView(R.layout.activity_active_inventory);
        listView = (ListView) findViewById(R.id.activeInventoryList);
        listView.setAdapter(new ActiveInventoryAdapter(this, activeInventory));
    }

    public void buttonViewAllOnClick(View v) {
        int position = listView.getPositionForView((View)v.getParent());
        accessInventory.setCurrentItem(position);
        Intent viewAllIntent = new Intent(this, viewAllActivity.class);
        this.startActivity(viewAllIntent);
    }
}
