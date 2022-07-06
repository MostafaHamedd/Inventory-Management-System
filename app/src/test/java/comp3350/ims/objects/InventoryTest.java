package comp3350.ims.objects;

import junit.framework.TestCase;

public class InventoryTest extends TestCase {

    public void setUp() {
    }

    public void tearDown() {
    }

    public void testInventory(){
        Inventory test = new Inventory();
        assertEquals(0,test.getNumOfItems());
    }

    public void testGetNumOfItems() {
        Inventory test = new Inventory();
        assertEquals(0,test.getNumOfItems());
        test.addItem(new ItemType());
        assertEquals(1,test.getNumOfItems());
    }

    public void testAddItem() {

        Inventory inventory = new Inventory();

        ItemType item = new ItemType("Coke 12 pk", 8f, 12, "Ware House", "12/06/2022", "Drinks");
        ItemType item1 = new ItemType("Pepsi 12 pk", 8f, 12, "Ware House", "12/06/2022", "Drinks");
        ItemType item2 = new ItemType("Fanta 12 pk", 8f, 12, "Ware House", "12/06/2022", "Drinks");
        ItemType item3 = new ItemType("IceTea 12 pk", 8f, 12, "Ware House", "12/06/2022", "Drinks");
        ItemType item4 = new ItemType("DrPepper 12 pk", 8f, 12, "Ware House", "12/06/2022", "Drinks");

        assertTrue(inventory.addItem(item));
        assertTrue(inventory.addItem(item1));
        assertTrue(inventory.addItem(item2));
        assertTrue(inventory.addItem(item3));
        assertTrue(inventory.addItem(item4));

        //duplicate
        assertFalse(inventory.addItem(item));
        assertFalse(inventory.addItem(item1));

        //invalid
        assertFalse(inventory.addItem(null));
    }

    public void testRemoveItem() {

        ItemType testType = new ItemType();
        Inventory test = new Inventory();
        test.addItem(testType);
        assertTrue(test.removeItem(testType));
        assertFalse(test.removeItem(testType));

    }

    public void testGetItem() {
        ItemType testType = new ItemType();
        Inventory test = new Inventory();
        test.addItem(testType);
        assertEquals(testType,test.getItem(0));
    }

    public void testReorderByQuantity(){

        Inventory test = new Inventory();
        ItemType testType = new ItemType();
        ItemType testType2 = new ItemType();

        //Set first item to not need a refill
        testType.setNeedsRefill(false);
        test.addItem(testType);
        test.addItem(testType2);

        test.reorderByQuantity();
        assertEquals(testType2,test.getItem(0));
    }
}