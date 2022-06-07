package comp3350.ims.presentation;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import comp3350.ims.R;

public class ActiveInventoryActivity extends Activity {

    private Inventory activeInventory;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_active_inventory);
        listView = (ListView) findViewById(R.id.activeInventoryList);
        listView.setAdapter(new ActiveInventoryAdapter(this, activeInventory));
    }
}
