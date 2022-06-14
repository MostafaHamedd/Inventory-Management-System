package comp3350.ims.presentation;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import comp3350.ims.R;
import comp3350.ims.business.AccessInventory;
import comp3350.ims.objects.ItemType;


public class viewAllActivity extends Activity {

    private ItemType item;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AccessInventory accessInventory = new AccessInventory();
        int position = accessInventory.getCurrentItemPosition();
        ItemType currentItem = accessInventory.getItem(position);

        setContentView(R.layout.activity_view_all);
        listView = (ListView) findViewById(R.id.viewAllListView);
        listView.setAdapter(new ViewAllAdapter(this, currentItem));
    }
}
