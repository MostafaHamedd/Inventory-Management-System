package comp3350.ims.presentation;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;



import java.text.SimpleDateFormat;
import java.util.Date;

import comp3350.ims.R;
import comp3350.ims.business.AccessInventory;
import comp3350.ims.objects.Inventory;
import comp3350.ims.objects.Item;
import comp3350.ims.objects.ItemType;

public class ActiveInventoryActivity extends Activity {

    private Inventory activeInventory;
    private ListView listView;
    public ActiveInventoryAdapter adapter;
    private AccessInventory accessInventory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        accessInventory = new AccessInventory();

        activeInventory = accessInventory.getActiveInventory();

        setContentView(R.layout.activity_active_inventory);
        listView = (ListView) findViewById(R.id.activeInventoryList);
        adapter = new ActiveInventoryAdapter(this, activeInventory);
        listView.setAdapter(adapter);
    }

    public void buttonViewAllOnClick(View v) {

        int position = listView.getPositionForView((View) v.getParent());
        accessInventory.setCurrentItem(position);
        Intent viewAllIntent = new Intent(this, viewAllActivity.class);
        this.startActivity(viewAllIntent);
    }

    public void buttonAddOnClick(View v) {

        int position = listView.getPositionForView((View) v.getParent());
        ItemType item = accessInventory.getItem(position);

        SimpleDateFormat currentDate = new SimpleDateFormat("dd/MM/yyyy");
        Date todayDate = new Date();
        String thisDate = currentDate.format(todayDate);

        item.addItem("Ware House", thisDate);

        TextView itemQuantity = ((View) v.getParent()).findViewById(R.id.itemQuantity);
        if (activeInventory.getItem(position).needsRefill()) {
            itemQuantity.setTextColor(Color.parseColor("RED"));
        } else {
            itemQuantity.setTextColor(Color.parseColor("BLACK"));
        }

        updateDataChanges();

        Toast.makeText(this, "Item Added", Toast.LENGTH_SHORT).show();

    }

    public void updateDataChanges() {
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onRestart() {
        activeInventory.reorderByQuantity();
        super.onRestart();
        updateDataChanges();
    }
}