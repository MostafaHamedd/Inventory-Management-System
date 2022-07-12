package comp3350.ims.business;

import java.util.ArrayList;

import comp3350.ims.application.Main;
import comp3350.ims.application.Services;
import comp3350.ims.objects.Inventory;
import comp3350.ims.objects.ItemType;
import comp3350.ims.persistence.DataAccess;
import comp3350.ims.persistence.DataAccessStub;

public class AccessInventory {
	private DataAccess dataAccess;
	private Inventory activeInventory;
	private static int currentItemPosition;

	public AccessInventory() {
		dataAccess =  Services.getDataAccess(Main.dbName);
		activeInventory = dataAccess.getActiveInventory();
	}

	public Inventory getActiveInventory() {
		return activeInventory;
	}

	public String insertItem(ItemType item) {
		return dataAccess.insertItem(item);
	}

	public void setCurrentItem(int index) {
		currentItemPosition = index;
	}

	public int getCurrentItemPosition() {
		return currentItemPosition;
	}

	public ItemType getItem(int index) {
		return activeInventory.items.get(index);
	}

	public String getCategories(ArrayList<String> categoryList) {
		categoryList.clear();
		return dataAccess.getCategoryList(categoryList);
	}

	public String getLocations(ArrayList<String> categoryList) {
		categoryList.clear();
		return dataAccess.getLocationList(categoryList);
	}

	public void addCategory(String category) {
		if (category != null) {
			dataAccess.addCategory(category);
		}
	}

	public void addLocation(String location) {
		if (location != null) {
			dataAccess.addLocation(location);
		}
	}

	public boolean removeLocation(String name){
		return dataAccess.removeLocation(name);
	}
	public boolean removeCategory (String name){
		return dataAccess.removeCategory(name);

	}
		public void removeIndividualItem ( int index){

			if (index >= 0) {
				ItemType item = getItem(currentItemPosition);
				item.removeItem(index);
			}

		}
	public boolean isCategory(String name){
		return dataAccess.isCategory(name) ;
	}
	public boolean isLocation(String name){
		return dataAccess.isLocation(name) ;
	}


	}
