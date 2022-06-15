package comp3350.ims.presentation;

import comp3350.ims.R;
import comp3350.ims.application.Main;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class HomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Main.startUp();

        setContentView(R.layout.activity_home);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Main.shutDown();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    public void buttonCreateNewItemOnClick(View v) {
        Intent itemCreateIntent = new Intent(HomeActivity.this, ItemCreate.class);
        HomeActivity.this.startActivity(itemCreateIntent);
    }

    public void buttonInventoryOnClick(View v) {
        Intent coursesIntent = new Intent(HomeActivity.this, ActiveInventoryActivity.class);
        HomeActivity.this.startActivity(coursesIntent);
    }

    public void buttonCategoryOnClick(View v) {
        Intent coursesIntent = new Intent(HomeActivity.this, CategoryActivity.class);
        HomeActivity.this.startActivity(coursesIntent);
    }

}
