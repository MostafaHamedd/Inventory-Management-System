package comp3350.ims.presentation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

import comp3350.ims.R;
import comp3350.ims.business.AccessInventory;
import comp3350.ims.objects.ItemType;

public class ItemCreate extends AppCompatActivity {

    private EditText itemName;
    private EditText itemPrice;
    private EditText itemQuantity;
    private Spinner itemCategory;
    private Spinner itemLocation;
    private Button createBtn;
    private AccessInventory accessInventory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_create);

        Spinner spinCategory = findViewById(R.id.spinnerCategory);
        ArrayAdapter<CharSequence> adapterCategory = ArrayAdapter.createFromResource(this,
                R.array.categories, android.R.layout.simple_spinner_item);
        adapterCategory.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinCategory.setAdapter(adapterCategory);

        Spinner spinLocation = findViewById(R.id.spinnerLocation);
        ArrayAdapter<CharSequence> adapterLocation = ArrayAdapter.createFromResource(this,
                R.array.locations, android.R.layout.simple_spinner_item);
        adapterLocation.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinLocation.setAdapter(adapterLocation);

        //setting default date to today's date.
        SimpleDateFormat currentDate = new SimpleDateFormat("dd/mm/yyyy");
        Date todayDate = new Date();
        String thisDate = currentDate.format(todayDate);
        EditText date = (EditText) findViewById(R.id.editTextDate);
        date.setText(thisDate);

        itemName = findViewById(R.id.itemNameInput);
        itemPrice = findViewById(R.id.itemPriceInput);
        itemQuantity = findViewById(R.id.itemQuantityInput);
        itemCategory = spinCategory;
        itemLocation = spinLocation;
        createBtn = findViewById(R.id.itemCreateBtn);

        createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ItemCreate.this, "New Item Created", Toast.LENGTH_SHORT).show();
                String nameString = itemName.getText().toString();

                String priceString = itemPrice.getText().toString();
                float price = Float.parseFloat(priceString);

                String quantityString = itemQuantity.getText().toString();
                int quantity = Integer.parseInt(quantityString);

                String categoryString = "test cat";

                String locationString = "test Location";

                ItemType newItem = new ItemType(nameString, price, quantity, locationString, thisDate,
                        categoryString );

                accessInventory = new AccessInventory();
                accessInventory.insertItem(newItem);
            }
        });
    }
}