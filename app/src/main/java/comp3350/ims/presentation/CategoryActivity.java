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
   private ArrayList<String> categoryList ;
   private ArrayAdapter adapter ;
   private Button createButton ;
   private EditText userText ;
   private ListView listView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.active_category);
        categoryList = new ArrayList<String>() ;

        categoryList.add("Dairy") ;
        categoryList.add("Fruits") ;
        categoryList.add("Fruits & vegetables") ;
        categoryList.add("Meat") ;
        categoryList.add("Pantry") ;
        categoryList.add("Fish & seafood") ;
        categoryList.add("Drinks") ;
        categoryList.add("Frozen") ;
        categoryList.add("Bakery") ;

         adapter = new ArrayAdapter<String>(this,
         R.layout.activtylist_view,categoryList );
         listView = (ListView) findViewById(R.id.categoryList);
        listView.setAdapter(adapter);
       createButton = (Button) findViewById(R.id.btnCreateCategory) ;
        userText = (EditText) findViewById(R.id.txtCategoryName) ;

    }

    public void buttonsCreateCategoryOnClick(View v){
        String name = userText.getText().toString();
        categoryList.add(name) ;
        System.out.println(categoryList.toString()) ;
        adapter.notifyDataSetChanged();
        userText.setText("");
    }



}
