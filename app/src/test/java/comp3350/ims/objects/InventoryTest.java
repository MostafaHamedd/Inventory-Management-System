package comp3350.ims.objects;

import junit.framework.TestCase;

public class InventoryTest extends TestCase {

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
        ItemType testType = new ItemType();
        Inventory test = new Inventory();
        assertTrue(test.addItem(testType));
        test.addItem(new ItemType());
        assertFalse(test.addItem(testType));
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