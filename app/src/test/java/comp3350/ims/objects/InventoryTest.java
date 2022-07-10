package comp3350.ims.objects;

import junit.framework.TestCase;

public class InventoryTest extends TestCase {

    public void setUp() {
    }

    public void tearDown() {
    }

    public void testSimpleCases(){

        Inventory inventory = new Inventory();
        assertEquals(0,inventory.getNumOfItems());

        ItemType item = new ItemType("Coke 12 pk", 8f, 12, "Ware House", "12/06/2022", "Drinks");
        ItemType item1 = new ItemType("Pepsi 12 pk", 8f, 12, "Ware House", "12/06/2022", "Drinks");

        assertTrue(inventory.addItem(item));
        assertTrue(inventory.addItem(item1));
        //checking if they are actually added.
        assertTrue(inventory.items.get(0).equals(item));
        assertTrue(inventory.items.get(0).equals(item));
        assertEquals(inventory.getNumOfItems(), 2);

        assertTrue(inventory.removeItem(item));
        assertTrue(inventory.removeItem(item1));
        //checking if they are actually removed
        assertEquals(inventory.items.size(), 0);

        assertTrue(inventory.addItem(item));
        assertTrue(inventory.addItem(item1));

        assertTrue(inventory.getItem(0).equals(item));
        assertTrue(inventory.getItem(1).equals(item1));

        ItemType item2 = new ItemType("DrPepper 12 pk", 8f, 0, "Ware House", "12/06/2022", "Drinks");
        assertTrue(inventory.addItem(item2));
        //checking re-order, if the 0 quantity item is at top of list.
        inventory.reorderByQuantity();
        assertTrue(inventory.getItem(0).equals(item2));

    }

    public void testTypicalCases(){

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
        assertFalse(inventory.addItem(item2));
        assertFalse(inventory.addItem(item3));
        assertFalse(inventory.addItem(item4));

        assertEquals(inventory.getNumOfItems(), 5);

        assertTrue(inventory.removeItem(item));
        assertTrue(inventory.removeItem(item1));
        assertTrue(inventory.removeItem(item2));
        assertTrue(inventory.removeItem(item3));
        assertTrue(inventory.removeItem(item4));

        assertEquals(inventory.getNumOfItems(), 0);

        assertTrue(inventory.addItem(item));
        assertTrue(inventory.addItem(item1));
        assertTrue(inventory.addItem(item2));
        assertTrue(inventory.addItem(item3));
        assertTrue(inventory.addItem(item4));

        ItemType lowQuantityItem = new ItemType("Chair", 8f, 0, "Ware House", "12/06/2022", "Drinks");
        ItemType lowQuantityItem1 = new ItemType("Chocolate", 8f, 3, "Ware House", "12/06/2022", "Drinks");
        ItemType lowQuantityItem2 = new ItemType("Gum", 8f, 5, "Ware House", "12/06/2022", "Drinks");

        assertTrue(inventory.addItem(lowQuantityItem));
        assertTrue(inventory.addItem(lowQuantityItem1));
        assertTrue(inventory.addItem(lowQuantityItem2));
        //should not be re-order
        assertFalse(inventory.items.get(0).equals(lowQuantityItem));
        assertFalse(inventory.items.get(1).equals(lowQuantityItem1));
        assertFalse(inventory.items.get(2).equals(lowQuantityItem2));

        inventory.reorderByQuantity();

        assertTrue(inventory.items.get(0).equals(lowQuantityItem));
        assertTrue(inventory.items.get(1).equals(lowQuantityItem1));
        assertTrue(inventory.items.get(2).equals(lowQuantityItem2));

        assertEquals(inventory.getNumOfItems(), 8);

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


    public void testInvalidCases(){

        Inventory inventory = new Inventory();

        assertFalse(inventory.addItem(null));
        assertFalse(inventory.removeItem(null));

        boolean thrown = false;

        try {
            inventory.getItem(-1);
        } catch (IndexOutOfBoundsException e){
            thrown = true;
        }

        thrown = false;
        try {
            inventory.getItem(100);
        } catch (IndexOutOfBoundsException e){
            thrown = true;
        }

        assertTrue(thrown);
    }

}