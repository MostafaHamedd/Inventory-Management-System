package comp3350.ims.objects;

import junit.framework.TestCase;

public class ItemTest extends TestCase {

    public void testItem(){
        Item test = new Item();
        assertEquals(test.getDate(),"");
        assertEquals(test.getId(),"");
        assertEquals(test.getLocation(),"");

        Item test2 = new Item("location","date");
        assertEquals(test2.getLocation(),"location");
        assertEquals(test2.getId(),"");
        assertEquals(test2.getDate(),"date");

        Item test3 = new Item("id","location","date");
        assertEquals(test3.getLocation(),"location");
        assertEquals(test3.getId(),"id");
        assertEquals(test3.getDate(),"date");
    }

    public void testGetId() {
        Item test = new Item("123","location","date");
        assertEquals(test.getId(),"123");
    }

    public void testSetId() {
        Item test = new Item();
        test.setId("test");
        assertEquals(test.getId(),"test");
    }

    public void testGetDate() {
        Item test = new Item("location","Today");
        assertEquals(test.getDate(),"Today");
    }

    public void testGetLocation() {
        Item test = new Item("Here","date");
        assertEquals(test.getLocation(),"Here");
    }
}