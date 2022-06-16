package comp3350.ims.presentation;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import comp3350.ims.R;
import comp3350.ims.objects.Inventory;

public class ActiveInventoryAdapter extends BaseAdapter {
    private Context context;
    private Inventory activeInventory;
    private static LayoutInflater inflater = null;

    public ActiveInventoryAdapter(Context context, Inventory inventory){
        this.context = context;
        this.activeInventory = inventory;
        this.activeInventory.reorderByQuantity();
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View vi = convertView;

        if(vi == null){
            vi = inflater.inflate(R.layout.inventory_row,null);
        }

        TextView itemName = (TextView) vi.findViewById(R.id.itemName);
        itemName.setText("Name: " + activeInventory.getItem(position).getName());

        TextView categoryName = (TextView) vi.findViewById(R.id.categoryName);
        categoryName.setText("Category: " + activeInventory.getItem(position).getCategorie() + "");

        TextView itemQuantity = (TextView) vi.findViewById(R.id.itemQuantity);
        itemQuantity.setText("Quantity: " + activeInventory.getItem(position).getQuantity() + "");

        if(activeInventory.getItem(position).needsRefill()){
            itemQuantity.setTextColor(Color.parseColor("RED"));
        }

        TextView itemPrice = (TextView) vi.findViewById(R.id.itemPrice);
        itemPrice.setText("Price: $" + activeInventory.getItem(position).getPrice() + "");

        return vi;
    }

    @Override
    public int getCount(){
        return activeInventory.items.size();
    }

    @Override
    public Object getItem(int position){
        return activeInventory.getItem(position);
    }

    @Override
    public long getItemId(int position){
        return position;
    }

}
