package comp3350.ims.persistence;

import junit.framework.TestCase;

import java.util.ArrayList;

import comp3350.ims.objects.Inventory;
import comp3350.ims.objects.Item;
import comp3350.ims.objects.ItemType;


public class DataAccessTest extends TestCase {

    private DataAccess dataAccess;

    public DataAccessTest(String arg0)
    {
        super(arg0);
    }

    public void setUp() {
        System.out.println("\nStarting Persistence test DataAccess (using stub)");

        dataAccess = new DataAccessStub();
        dataAccess.open("Stub");
    }

    public static void dataAccessTest(DataAccess dataAccess) {
        DataAccessTest dataAccessTest = new DataAccessTest("");
        dataAccessTest.dataAccess = dataAccess;
        dataAccessTest.testSimpleCases();
    }

    public void tearDown() {
        System.out.println("Finished Persistence test DataAccess (using stub)");
    }

    public void testSimpleCases(){
        Inventory inventory;
        ArrayList<String> categoryList = new ArrayList<String>();
        ArrayList<String> locationList = new ArrayList<String>();

        inventory = dataAccess.getActiveInventory();
        dataAccess.getCategoryList(categoryList);
        dataAccess.getLocationList(locationList);
        assertEquals(inventory.getNumOfItems(),0);
        assertEquals(categoryList.size(),0);
        assertEquals(locationList.size(),0);

        //Item Type Tests
        ItemType milk = new ItemType("Milk",5,"Warehouse","7/27/2022","Dairy");
        dataAccess.insertItem(milk);
        inventory = dataAccess.getActiveInventory();
        assertTrue(inventory.contains(milk));

        dataAccess.editItemType(milk,"Chocolate Milk",milk.getPrice(), milk.getCategory());
        inventory = dataAccess.getActiveInventory();
        assertEquals("Chocolate Milk",milk.getName());

        //Category Tests
        dataAccess.addCategory("Dairy");
        categoryList.clear();
        dataAccess.getCategoryList(categoryList);
        assertTrue(categoryList.contains("Dairy"));

        dataAccess.removeCategory("Dairy");
        categoryList.clear();
        dataAccess.getCategoryList(categoryList);
        assertFalse(categoryList.contains("Dairy"));

        //Location Tests
        dataAccess.addLocation("Warehouse");
        locationList.clear();
        dataAccess.getLocationList(locationList);
        assertTrue(locationList.contains("Warehouse"));

        dataAccess.removeLocation("Warehouse");
        locationList.clear();
        dataAccess.getLocationList(locationList);
        assertFalse(locationList.contains("Warehouse"));

        //Item Tests
        Item firstMilk = new Item(milk.getLocation(),milk.getDate());
        dataAccess.addItem(firstMilk,milk.getID());
        inventory = dataAccess.getActiveInventory();
        assertEquals(firstMilk.getId(),inventory.getItem(0).getItem(0).getId());

        dataAccess.editItem(firstMilk,"Warehouse2");
        inventory = dataAccess.getActiveInventory();
        assertEquals("Warehouse2",inventory.getItem(0).getItem(0).getLocation());

        dataAccess.removeItem(firstMilk.getId(),milk.getID(),milk.getQuantity());
        inventory = dataAccess.getActiveInventory();
        assertNull(inventory.getItem(0).getItem(0));
    }

    public void testTypicalCases(){
        Inventory inventory;
        ArrayList<String> categoryList = new ArrayList<String>();
        ArrayList<String> locationList = new ArrayList<String>();


    }

    public void testEdgeCases(){

        Inventory inventory;
        ArrayList<String> categoryList = new ArrayList<String>();
        ArrayList<String> locationList = new ArrayList<String>();

        inventory = dataAccess.getActiveInventory();

        dataAccess.removeCategory("TestCategory");
        dataAccess.removeLocation("TestLocation");

        dataAccess.getLocationList(locationList);
        dataAccess.getCategoryList(categoryList);

        assertEquals(inventory.getNumOfItems(),8);
        assertEquals(locationList.size(),2);
        assertEquals(categoryList.size(),8);

        dataAccess.removeLocation("warehouse");
        assertTrue(locationList.contains("Sales-floor"));
        assertFalse(locationList.contains("warehouse"));
    }

    public void testInvalidCases(){

        Inventory inventory;
        ArrayList<String> categoryList = new ArrayList<String>();
        ArrayList<String> locationList = new ArrayList<String>();

        inventory = dataAccess.getActiveInventory();

        //dataAccess.addItem(new Item("warehouse","12/02/22"),null);
        dataAccess.addCategory(null);
        dataAccess.addLocation(null);

        dataAccess.getLocationList(locationList);
        dataAccess.getCategoryList(categoryList);
        assertEquals(inventory.getNumOfItems(),8);
        assertEquals(locationList.size(),2);
        assertEquals(categoryList.size(),8);

        assertFalse(locationList.contains(null));
        assertFalse(categoryList.contains(null));

    }

}
