package comp3350.ims.presentation;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import comp3350.ims.R;
import comp3350.ims.business.AccessInventory;


public class LocationActivity extends Activity {

    private ArrayList<String> locationList;
    private ArrayAdapter adapter;
    private Button createButton;
    private EditText userText;
    private AccessInventory accessInventory;
    ListView listView;
    Button deleteButton ;
    int selectedIndex ;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.active_location);
        locationList = new ArrayList<String>();

        accessInventory = new AccessInventory();

        accessInventory.getLocations(locationList);

        adapter = new ArrayAdapter<String>(this, R.layout.activtylist_view, locationList);
         listView = (ListView) findViewById(R.id.LocationList);
        listView.setAdapter(adapter);
        createButton = (Button) findViewById(R.id.btnCreateLocation);
        deleteButton = (Button) findViewById(R.id.btnDeleteLocation);
        userText = (EditText) findViewById(R.id.txtLocationName);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int  index = position;
                selectItem(index,view) ;

            }

        });
        deleteButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                deleteSelected() ;
            }

        } );

    }

   public void selectItem(int index,View view){
       if(!listView.isItemChecked(index)){
           listView.setItemChecked(index,true) ;
           view.setBackgroundColor(Color.GRAY);
           selectedIndex = index ;
       }else{
           view.setBackgroundColor(Color.BLUE);
           listView.setItemChecked(index,false) ;

       }

   }
   public void deleteSelected(){
       accessInventory.removeLocation(selectedIndex);
        locationList.remove(selectedIndex) ;
       adapter.notifyDataSetChanged();
       Toast toast = Toast.makeText(getApplicationContext(), "Item deleted", Toast.LENGTH_SHORT);
       toast.show();



   }


    public void buttonsCreateLocationOnClick(View v) {
        String name = userText.getText().toString().trim();
        if (!TextUtils.isEmpty(name)) {
            accessInventory.addLocation(name);
            locationList.add(name);
            adapter.notifyDataSetChanged();
            userText.setText("");
            Toast toast = Toast.makeText(getApplicationContext(), "Location created", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            Toast toast = Toast.makeText(getApplicationContext(), "Error: Please enter a valid input", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void buttonsDeleteLocationOnClick(View v) {
//      listView.getItemC
    }

}



