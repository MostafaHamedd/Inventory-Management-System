package comp3350.ims.persistence;

import java.util.ArrayList;
import java.util.List;

import comp3350.ims.application.Main;
import comp3350.ims.objects.Inventory;
import comp3350.ims.objects.ItemType;
import comp3350.ims.objects.Item;


public class DataAccessStub
{
	private String dbName;
	private String dbType = "stub";

	private Inventory activeInventory;
	private ArrayList<String> category;

	public DataAccessStub(String dbName)
	{
		this.dbName = dbName;
	}

	public DataAccessStub()
	{
		this(Main.dbName);
	}

	public void open(String dbName)
	{
		ItemType item;

		activeInventory = new Inventory();
		category = new ArrayList<>();
		category.add("Dairy");

		item = new ItemType("Milk", 5.55f, 12, "Ware House", "12/06/2022" ,category );
		activeInventory.addItem(item);
		item = new ItemType("Cheese", 6.5f, 12, "Ware House", "12/06/2022" ,category );
		activeInventory.addItem(item);
		item = new ItemType("Butter", 3.5f, 12, "Ware House", "12/06/2022" ,category );
		activeInventory.addItem(item);
		item = new ItemType("Cream", 5.55f, 12, "Ware House", "12/06/2022" ,category );
		activeInventory.addItem(item);


		System.out.println("Opened " +dbType +" database " +dbName);
	}

	public void close()
	{
		System.out.println("Closed " +dbType +" database " +dbName);
	}

	public Inventory getActiveInventory()
	{
		return activeInventory;
	}


	public String insertItem(ItemType item)
	{
		// don't bother checking for duplicates
		activeInventory.addItem(item);
		return null;
	}


	public String deleteItem(ItemType item)
	{
		int index;
		
		index = activeInventory.items.indexOf(item);

		if (index >= 0)
		{
			activeInventory.items.remove(index);
		}
		return null;
	}

	public String getSequentialItems(ArrayList<ItemType> itemList){

		itemList.addAll(activeInventory.items);
		return null;
	}



}
