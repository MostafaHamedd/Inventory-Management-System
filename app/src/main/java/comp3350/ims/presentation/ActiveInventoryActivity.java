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
import comp3350.ims.objects.ItemType;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

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


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate menu with items using MenuInflator
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        // Initialise menu item search bar
        // with id and take its object
        MenuItem searchViewItem = menu.findItem(R.id.search_bar);
        SearchView searchView = MenuItemCompat.getActionView(searchViewItem);

        // attach setOnQueryTextListener
        // to search view defined above
        searchView.setOnQueryTextListener(
                new SearchView.OnQueryTextListener() {

                    // Override onQueryTextSubmit method
                    // which is call
                    // when submitquery is searched

                    @Override
                    public boolean onQueryTextSubmit(String query)
                    {
                        // If the list contains the search query
                        // than filter the adapter
                        // using the filter method
                        // with the query as its argument
                        if (list.contains(query)) {
                            adapter.getFilter().filter(query);
                        }
                        else {
                            // Search query not found in List View
                            Toast
                                    .makeText(MainActivity.this,
                                            "Not found",
                                            Toast.LENGTH_LONG)
                                    .show();
                        }
                        return false;
                    }

                    // This method is overridden to filter
                    // the adapter according to a search query
                    // when the user is typing search
                    @Override
                    public boolean onQueryTextChange(String newText)
                    {
                        adapter.getFilter().filter(newText);
                        return false;
                    }
                });

        return super.onCreateOptionsMenu(menu);
    }

    public void buttonViewAllOnClick(View v) {

        int position = listView.getPositionForView((View) v.getParent());
        accessInventory.setCurrentItem(position);
        Intent viewAllIntent = new Intent(this, ViewAllActivity.class);
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