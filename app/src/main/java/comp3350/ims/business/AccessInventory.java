package comp3350.ims.business;

import java.util.ArrayList;
import java.util.List;

import comp3350.ims.application.Main;
import comp3350.ims.application.Services;
import comp3350.ims.objects.Inventory;
import comp3350.ims.objects.ItemType;
import comp3350.ims.objects.Student;
import comp3350.ims.persistence.DataAccessStub;

public class AccessInventory
{
	private DataAccessStub dataAccess;
	private Inventory activeInventory;

	public AccessInventory()
	{
		dataAccess = (DataAccessStub) Services.getDataAccess(Main.dbName);
		activeInventory = dataAccess.getActiveInventory();
	}

    public Inventory getActiveInventory()
    {
		return activeInventory;
    }


	public String insertItem(ItemType item)
	{
		return dataAccess.insertItem(item);
	}


	public String deleteItem(ItemType item)
	{
		return dataAccess.deleteItem(item);
	}

	public String getSequentialItems(ArrayList<ItemType> itemList)
	{
		itemList.clear();
		return dataAccess.getSequentialItems(itemList);
	}

}
