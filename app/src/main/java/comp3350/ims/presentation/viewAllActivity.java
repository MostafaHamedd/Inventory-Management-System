package comp3350.ims.presentation;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import comp3350.ims.R;
import comp3350.ims.objects.ItemType;


public class viewAllActivity extends Activity {

    private ItemType item;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayList<String> category = new ArrayList<String>();
        category.add("Dairy");

        item =  new ItemType("Milk", 5.55f, 12, "Ware House", "12/06/2022" ,category );
        item.addItem();
        item.addItem();

        setContentView(R.layout.activity_view_all);
        listView = (ListView) findViewById(R.id.viewAllListView);
        listView.setAdapter(new ViewAllAdapter(this, item));
    }
}
