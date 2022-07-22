package comp3350.ims.presentation;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.support.v7.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import comp3350.ims.R;
import comp3350.ims.business.AccessInventory;
import comp3350.ims.objects.Inventory;
import comp3350.ims.objects.ItemType;

public class ActiveInventoryActivity extends AppCompatActivity {

    private Inventory activeInventory;
    private ListView listView;
    public ActiveInventoryAdapter adapter;
    private AccessInventory accessInventory;
    private ArrayList <String> categoryList;
    private ArrayList <String> locationList;
    private Spinner categories;
    private Spinner locations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_active_inventory);

        Toolbar mTopToolbar = (Toolbar) findViewById(R.id.my_toolbar);
         setSupportActionBar(mTopToolbar);

        accessInventory = new AccessInventory();

        activeInventory = accessInventory.getActiveInventory();
        categoryList = new ArrayList<>();
        locationList = new ArrayList<>();

        accessInventory.getCategories(categoryList);
        accessInventory.getLocations(locationList);

        categoryList.add(0,"Choose a category to filter");
        locationList.add(0,"Choose a location to filter");

        categories = findViewById(R.id.CategorySpinner);
        locations = findViewById(R.id.LocationSpinner);

        ArrayAdapter <String> adapterCategory = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, categoryList);
        adapterCategory.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        categories.setAdapter(adapterCategory);

        categories.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedCatergory = categories.getSelectedItem().toString();
                if(!selectedCatergory.equals("Choose a category to filter")){
                    //filter category added here
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });

        ArrayAdapter <String> adapterLocation = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, locationList);
        adapterLocation.setDropDownViewResource(android.R.layout.simple_spinner_item);
        locations.setAdapter(adapterLocation);

        locations.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedLocation = locations.getSelectedItem().toString();
                if(!selectedLocation.equals("Choose a location to filter")){
                    //filter location added here
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });

        listView = (ListView) findViewById(R.id.activeInventoryList);
        adapter = new ActiveInventoryAdapter(this, activeInventory);
        listView.setAdapter(adapter);

    }

    public void buttonViewAllOnClick(View v) {

        int position = listView.getPositionForView((View) v.getParent());
        accessInventory.setCurrentItem(position);
        Intent viewAllIntent = new Intent(this, ViewAllActivity.class);
        this.startActivity(viewAllIntent);
    }

    private String saveName = "";
    private float savePrice = 0;
    private String saveCategory;
//    @RequiresApi(api = Build.VERSION_CODES.M)
    public void buttonEditDialogOnClick(View v) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Edit");

        int position = listView.getPositionForView((View) v.getParent());
        ItemType item = accessInventory.getItem(position);

        final LayoutInflater inflater = getLayoutInflater();
        final View inflator = inflater.inflate(R.layout.activity_edit_dialog_inventory_row, null);

        Spinner spinCategory = (Spinner) inflator.findViewById(R.id.spinnerCategory);
        ArrayList < String > categoryList = new ArrayList < > ();
        accessInventory.getCategories(categoryList);

        ArrayAdapter < String > adapterCategory = new ArrayAdapter < > (this, R.layout.support_simple_spinner_dropdown_item, categoryList);
        adapterCategory.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinCategory.setAdapter(adapterCategory);

        EditText newName = (EditText) inflator.findViewById(R.id.itemNameInputs);
        newName.setText(item.getName());
        newName.setInputType(InputType.TYPE_CLASS_TEXT);

        EditText newPrice = (EditText) inflator.findViewById(R.id.itemPriceInput);
        String priceText = ""+item.getPrice();
        newPrice.setText(priceText);

        Spinner newCategory = (Spinner) inflator.findViewById(R.id.spinnerCategory);
        ArrayAdapter<String> spinnerAdap =  (ArrayAdapter<String>) newCategory.getAdapter();
        int spinnerPosition = spinnerAdap.getPosition(item.getCategory());
        newCategory.setSelection(spinnerPosition);

        builder.setView(inflator);

        // Set up the buttons
        builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                saveName = newName.getText().toString();
                savePrice = Float.parseFloat(newPrice.getText().toString());
                saveCategory = spinCategory.getSelectedItem().toString();

                item.setName(saveName);
                item.setPrice(savePrice);
                item.setCategory(saveCategory);
                adapter.notifyDataSetChanged();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();

    }

    public void buttonAddOnClick(View v) {

        int position = listView.getPositionForView((View) v.getParent());
        ItemType itemType = accessInventory.getItem(position);

        SimpleDateFormat currentDate = new SimpleDateFormat("dd/MM/yyyy");
        Date todayDate = new Date();
        String thisDate = currentDate.format(todayDate);

        accessInventory.addItem(itemType.getLocation(),thisDate,itemType);

        TextView itemQuantity = ((View) v.getParent()).findViewById(R.id.itemQuantity);
        try {
            if (activeInventory.getItem(position).needsRefill()) {
                itemQuantity.setTextColor(Color.parseColor("RED"));
            } else {
                itemQuantity.setTextColor(Color.parseColor("BLACK"));
            }

            updateDataChanges();

            Toast.makeText(this, "Item Added", Toast.LENGTH_SHORT).show();
        } catch (IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }


        updateDataChanges();

        Toast.makeText(this, "Item Added", Toast.LENGTH_SHORT).show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_home,menu);

        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setQueryHint("Enter item name...");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    public void updateDataChanges() {
        adapter.notifyDataSetChanged();

    }

    @Override
    public void onRestart() {
        activeInventory = accessInventory.getActiveInventory();
        activeInventory.reorderByQuantity();
        updateDataChanges();
        super.onRestart();
    }

    @Override
    public void onResume() {
        activeInventory = accessInventory.getActiveInventory();
        updateDataChanges();
        super.onResume();
    }

    public void sortNameAscending(View v){
        activeInventory.sortByName();
        updateDataChanges();
    }

    public void sortNameDescending(View v){
        activeInventory.reverseSortByName();
        updateDataChanges();
    }

    public void sortPriceAscending(View v){
        activeInventory.sortByPrice();
        updateDataChanges();
    }

    public void sortPriceDescending(View v){
        activeInventory.reverseSortByPrice();
        updateDataChanges();
    }


    @Override
    public void onBackPressed(){
        Intent coursesIntent = new Intent(this, HomeActivity.class);
        this.startActivity(coursesIntent);
    }


}
