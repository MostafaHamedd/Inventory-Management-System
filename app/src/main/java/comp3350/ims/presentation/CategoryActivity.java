package comp3350.ims.presentation;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import comp3350.ims.R;
import comp3350.ims.objects.Category;

public class CategoryActivity extends Activity {

   private ArrayList<Category> Categories  ;
   private ArrayList<String> cateogryList ;
   private ArrayAdapter adapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.active_category);
        String[] testArray = {"Dairy","Fruits & vegetables","Meat","Pantry",
                "Fish & seafood","Drniks","Deli","Frozen","Bakery"};
        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.activtylist_view,testArray );
        ListView listView = (ListView) findViewById(R.id.categoryList);
        listView.setAdapter(adapter);
//        cateogryList.add( "1") ;
//        cateogryList.add( "1") ;
//        cateogryList.add( "1") ;
//        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_activated_2,cateogryList) ;
//        final ListView listView = (ListView)findViewById(R.id.categoryList);
////        listView.setAdapter(adapter);

    }

}
