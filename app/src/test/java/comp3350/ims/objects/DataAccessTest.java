//package comp3350.ims.objects;
//
//import junit.framework.TestCase;
//
//import java.util.ArrayList;
//
//import comp3350.ims.persistence.DataAccess;
//
//public class DataAccessTest extends TestCase {
//
//    private DataAccess dataAccess;
//
//    public DataAccessTest(String arg0)
//    {
//        super(arg0);
//    }
//
//    public void setUp() {
//        System.out.println("\nStarting Persistence test DataAccess (using stub)");
//
//        // Use the following statements to run with the stub database:
//        dataAccess = new DataAccessStub();
//        dataAccess.open("Stub");
//
//    }
//
//    public void tearDown() {
//        System.out.println("Finished Persistence test DataAccess (using stub)");
//    }
//
//    public void testSimpleCases(){
//
//        Inventory inventory;
//        ItemType item;
//        ArrayList<String> categoryList = new ArrayList<String>();
//        ArrayList<String> locationList = new ArrayList<String>();
//
//        inventory = dataAccess.getActiveInventory();
//
//        dataAccess.getCategoryList(categoryList);
//        dataAccess.getLocationList(locationList);
//
//        item = new ItemType("Milk", 5.55f, 13, "Ware House", "12/06/2022", "Dairy");
//        assertTrue(inventory.getItem(0).equals(item));
//        assertEquals(inventory.getNumOfItems(),8);
//
//        assertEquals(categoryList.size(),8);
//        assertEquals(locationList.size(),2);
//
//        assertTrue(categoryList.contains("Dairy"));
//        assertTrue(categoryList.contains("Fruits & vegetables"));
//        assertTrue(categoryList.contains("Meat"));
//        assertTrue(categoryList.contains("Drinks"));
//
//        assertTrue(locationList.contains("WareHouse"));
//        assertTrue(locationList.contains("Sales-floor"));
//
//    }
//
//    public void testTypicalCases(){
//
//        Inventory inventory;
//        ArrayList<String> categoryList = new ArrayList<String>();
//        ArrayList<String> locationList = new ArrayList<String>();
//        ItemType item = new ItemType("TestItem", 5.55f, 13, "TestCategory", "12/06/2022", "TestLocation");
//
//        inventory = dataAccess.getActiveInventory();
//
//        dataAccess.addLocation("TestLocation");
//        dataAccess.addCategory("TestCategory");
//        dataAccess.addItem(new Item("warehouse","12/02/22"),item.getID() );
//
//        dataAccess.getLocationList(locationList);
//        dataAccess.getCategoryList(categoryList);
//
//        assertEquals(inventory.getNumOfItems(),9);
//        assertEquals(locationList.size(),3);
//        assertEquals(categoryList.size(),9);
//
//        assertTrue(locationList.contains("TestLocation"));
//        assertTrue(categoryList.contains("TestCategory"));
//
//        assertTrue(inventory.getItem(8).equals(item));
//
//    }
//
//    public void testEdgeCases(){
//
//        Inventory inventory;
//        ArrayList<String> categoryList = new ArrayList<String>();
//        ArrayList<String> locationList = new ArrayList<String>();
//
//        inventory = dataAccess.getActiveInventory();
//
//        dataAccess.removeCategory("TestCategory");
//        dataAccess.removeLocation("TestLocation");
//
//        dataAccess.getLocationList(locationList);
//        dataAccess.getCategoryList(categoryList);
//
//        assertEquals(inventory.getNumOfItems(),8);
//        assertEquals(locationList.size(),2);
//        assertEquals(categoryList.size(),8);
//
//        dataAccess.removeLocation("warehouse");
//        assertTrue(locationList.contains("Sales-floor"));
//        assertFalse(locationList.contains("warehouse"));
//    }
//
//    public void testInvalidCases(){
//
//        Inventory inventory;
//        ArrayList<String> categoryList = new ArrayList<String>();
//        ArrayList<String> locationList = new ArrayList<String>();
//
//        inventory = dataAccess.getActiveInventory();
//
//        //dataAccess.addItem(new Item("warehouse","12/02/22"),null);
//        dataAccess.addCategory(null);
//        dataAccess.addLocation(null);
//
//        dataAccess.getLocationList(locationList);
//        dataAccess.getCategoryList(categoryList);
//        assertEquals(inventory.getNumOfItems(),8);
//        assertEquals(locationList.size(),2);
//        assertEquals(categoryList.size(),8);
//
//        assertFalse(locationList.contains(null));
//        assertFalse(categoryList.contains(null));
//
//    }
//
//}
