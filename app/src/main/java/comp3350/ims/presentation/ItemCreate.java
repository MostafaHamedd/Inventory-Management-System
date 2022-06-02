package comp3350.ims.presentation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import comp3350.ims.R;

public class ItemCreate extends AppCompatActivity {

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

    }
}