package comp3350.ims.business;

import java.util.ArrayList;

import comp3350.ims.application.Main;
import comp3350.ims.application.Services;
import comp3350.ims.objects.Inventory;
import comp3350.ims.objects.ItemType;
import comp3350.ims.persistence.DataAccessStub;

public class AccessInventory
{
	private DataAccessStub dataAccess;
	private Inventory activeInventory;
	private static int currentItemPosition;

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

	public void setCurrentItem(int index){
		currentItemPosition = index;
	}

	public int getCurrentItemPosition(){
		return currentItemPosition;
	}

	public ItemType getItem(int index){
		return activeInventory.items.get(index);
	}

	public String getCategories(ArrayList<String> categoryList){
		categoryList.clear();
		return dataAccess.getCategoryList(categoryList);
	}

	public void addCategory(String category){
		dataAccess.addCategory(category);
	}

}
