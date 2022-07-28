package comp3350.ims.business;

import junit.framework.TestCase;

public class AccessInventoryTest extends TestCase {


    public void testCategoryCases(){
        AccessInventory test = new AccessInventory();

        //Testing basic adding and removing of categories
        assertFalse(test.isCategory("test123"));
        test.addCategory("test123");
        assertTrue(test.isCategory("test123"));

        assertTrue(test.removeCategory("test123"));
        assertFalse(test.isCategory("test123"));
    }

    public void testLocationCases(){

        AccessInventory test = new AccessInventory();

        test.addLocation("test123");
        assertTrue(test.isLocation("test123"));

        assertTrue(test.isLocation("test123"));

        assertTrue(test.removeLocation("test123"));
        assertFalse(test.isLocation("test123"));
    }
}