package comp3350.ims.objects;

import junit.framework.TestCase;

public class ItemTest extends TestCase {

    public void setUp() {
    }

    public void tearDown() {
    }


    public void testTypicaCases(){
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


}