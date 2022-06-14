package comp3350.ims.presentation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import comp3350.ims.R;
import comp3350.ims.objects.Category;

public class CategoryActivity extends Activity {

   private ArrayList<Category> Categories  ;
   private ArrayList<String> cateogryList ;
   private ArrayAdapter adapter ;
   private Button createButton ;
   private EditText userText ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.active_category);
        cateogryList = new ArrayList<String>() ;

        cateogryList.add("Dairy") ;
        cateogryList.add("Fruits") ;
        cateogryList.add("Fruits & vegetables") ;
        cateogryList.add("Meat") ;
        cateogryList.add("Pantry") ;
        cateogryList.add("Fish & seafood") ;
        cateogryList.add("Drinks") ;
        cateogryList.add("Frozen") ;
        cateogryList.add("Bakery") ;
        cateogryList.add("Test") ;


//
//        String[] testArray = {"Dairy","Fruits & vegetables","Meat","Pantry",
//                "Fish & seafood","Drinks","Deli","Frozen","Bakery"};
        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.activtylist_view,cateogryList );
        ListView listView = (ListView) findViewById(R.id.categoryList);
        listView.setAdapter(adapter);
       createButton = (Button) findViewById(R.id.btnCreateCategory) ;
        userText = (EditText) findViewById(R.id.txtCategoryName) ;

    }

    public void buttonsCreateCategoryOnClick(View v){

        String name = userText.getText().toString();
        cateogryList.add(name) ;
    }

}
