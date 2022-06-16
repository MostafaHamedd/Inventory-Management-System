package comp3350.ims.presentation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import comp3350.ims.R;
import comp3350.ims.business.AccessInventory;
import comp3350.ims.objects.ItemType;


public class viewAllActivity extends Activity {

    private ItemType item;
    ListView listView;
    private AccessInventory accessInventory;
    private ViewAllAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        accessInventory = new AccessInventory();
        int position = accessInventory.getCurrentItemPosition();
        ItemType currentItem = accessInventory.getItem(position);

        setContentView(R.layout.activity_view_all);
        listView = (ListView) findViewById(R.id.viewAllListView);
        adapter = new ViewAllAdapter(this, currentItem);
        listView.setAdapter(adapter);
    }

    public void buttonRemoveItem(View v){
        int position = listView.getPositionForView((View)v.getParent());
        if(position >=0 ) {
            accessInventory.removeIndividualItem(position);
            adapter.notifyDataSetChanged();
            Toast.makeText(this, "Item Removed", Toast.LENGTH_SHORT).show();

        }
    }
}
