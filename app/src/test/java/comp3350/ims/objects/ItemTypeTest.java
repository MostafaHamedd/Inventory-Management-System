package comp3350.ims.objects;

import junit.framework.TestCase;

public class ItemTypeTest extends TestCase {

    public void setUp() {
    }

    public void tearDown() {
    }

    public void testItemType(){
        //Test base case constructor
        ItemType test = new ItemType();
        assertEquals("",test.getName());
        assertEquals((float)0.0,test.getPrice());
        assertEquals(0,test.getQuantity());
        assertEquals("",test.getLocation());
        assertEquals("",test.getDate());
        assertEquals("",test.getCategory());

        ItemType test2 = new ItemType("name", (float) 1.11,2,
                "location","date","Category");

        assertEquals("name",test2.getName());
        assertEquals((float)1.11,test2.getPrice());
        assertEquals(2,test2.getQuantity());
        assertEquals("location",test2.getLocation());
        assertEquals("date",test2.getDate());
        assertEquals("Category",test2.getCategory());
        assertEquals(2,test2.getSize());
    }

    public void testAddItem() {
        ItemType test = new ItemType();
        test.addItem("location","date");
        assertEquals("location",test.getItem(0).getLocation());
    }

    public void testRemoveItem() {
        ItemType test = new ItemType();
        test.addItem("location","date");
        test.addItem("location2","date2");
        test.removeItem(0);
        assertEquals("location2",test.getItem(0).getLocation());
        assertEquals(1,test.getSize());
    }

    public void testGetName() {
        ItemType test = new ItemType();
        assertEquals("",test.getName());
    }

    public void testSetName() {
        ItemType test = new ItemType();
        test.setName("New Name");
        assertEquals("New Name",test.getName());
    }

    public void testGetPrice() {
        ItemType test = new ItemType();
        assertEquals((float)0.0,test.getPrice());
    }

    public void testGetItem() {
        ItemType test = new ItemType("name", (float) 1.11,2,
                "location","date","categorie");
        assertEquals("2",test.getItem(0).getId());
    }

    public void testSetPrice() {
        ItemType test = new ItemType();
        test.setPrice((float) 1.11);
        assertEquals((float)1.11,test.getPrice());
    }

    public void testGetQuantity() {
        ItemType test = new ItemType("name", (float) 1.11,2,
                "location","date","categorie");
        assertEquals(2,test.getQuantity());
    }

    public void testGetSize() {
        ItemType test = new ItemType("name", (float) 1.11,2,
                "location","date","categorie");
        assertEquals(2,test.getSize());
    }

    public void testSetQuantity() {
        ItemType test = new ItemType();
        test.setQuantity(5);
        assertEquals(5,test.getQuantity());
    }

    public void testGetCategorie() {
        ItemType test = new ItemType();
        assertEquals("",test.getCategory());
    }

    public void testSetCategories() {
        ItemType test = new ItemType();
        test.setCategories("Category");
        assertEquals("Category",test.getCategory());
    }

    public void testGetLocation() {
        ItemType test = new ItemType();
        assertEquals("",test.getLocation());
    }

    public void testSetLocation() {
        ItemType test = new ItemType();
        test.setLocation("location");
        assertEquals("location",test.getLocation());
    }

    public void testGetDate() {
        ItemType test = new ItemType();
        assertEquals("",test.getDate());
    }

    public void testSetDate() {
        ItemType test = new ItemType();
        test.setDate("March");
        assertEquals("March",test.getDate());
    }

    public void testNeedsRefill(){
        ItemType test = new ItemType();
        assertTrue(test.needsRefill());
    }

    public void testSetNeedsRefill(){
        ItemType test = new ItemType();
        test.setNeedsRefill(false);
        assertFalse(test.needsRefill());
    }
}