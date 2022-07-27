package comp3350.ims.intergration;

import junit.framework.TestCase;

import comp3350.ims.application.Main;
import comp3350.ims.application.Services;
import comp3350.ims.business.AccessInventory;
import comp3350.ims.objects.ItemType;

public class BusinessPersistenceSeamTest extends TestCase {
    public BusinessPersistenceSeamTest(String arg0)
    {
        super(arg0);
    }

    public void testAccessInventorySimpleCases(){
        AccessInventory accessInventory ;
        ItemType itemType ;
        Services.closeDataAccess();
        System.out.println("\nStarting Integration test of AccessStudents to persistence");
        Services.createDataAccess(Main.dbName);
        accessInventory = new AccessInventory();

        assertEquals(0,accessInventory.getActiveInventory().items.size());

        accessInventory.addCategory("Dairy");
        accessInventory.addLocation("ware house");

        assertTrue(accessInventory.isCategory("Dairy")) ;
        assertTrue(accessInventory.isLocation("ware house")) ;

        accessInventory.insertItemType("Milk",1.99f, 25, "ware house", "2022/07/23" ,"Dairy");
        itemType = accessInventory.getItem(0) ;

        assertTrue("Milk".equals(itemType.getName()) );
        assertEquals(25,itemType.getQuantity());
        assertEquals(1.99f,itemType.getPrice());
        assertEquals(1,accessInventory.getActiveInventory().items.size());

        accessInventory.addItem(itemType.getLocation(),itemType.getDate(),itemType);
        assertEquals(26,itemType.getQuantity());


        accessInventory.removeCategory("Dairy");
        accessInventory.removeLocation("ware house");

        assertFalse(accessInventory.isCategory("Dairy"));
        assertFalse(accessInventory.isLocation("ware house"));

        accessInventory.setCurrentItem(0);
        accessInventory.removeIndividualItem(0);

        assertEquals(25,itemType.getQuantity());

        accessInventory.editItemType(itemType,"Orange juice", 2.99f, "Drinks");
        assertTrue("Orange juice".equals(itemType.getName()));
        assertEquals(25,itemType.getQuantity());
        assertEquals(2.99f,itemType.getPrice());

        accessInventory.insertItemType("Milk",1.99f, 25, "ware house", "2022/07/23" ,"Dairy");

        assertEquals(2,accessInventory.getActiveInventory().items.size());

        itemType = accessInventory.getItem(1);
        assertTrue("Milk".equals(itemType.getName()));
        assertEquals(25,itemType.getQuantity());
        assertEquals(1.99f,itemType.getPrice());
        Services.closeDataAccess();
    }

    public void testAccessInventoryEdgeCases(){
        AccessInventory accessInventory ;
        ItemType itemType ;
        Services.closeDataAccess();
        Services.createDataAccess(Main.dbName);
        accessInventory = new AccessInventory();

        accessInventory.addCategory("Dairy");
        accessInventory.addLocation("ware house");

        accessInventory.insertItemType("Milk",1.99f, 5, "ware house", "2022/07/23" ,"Dairy");
        itemType = accessInventory.getItem(0);

        // Remove category/location after creating an itemType with both
        assertTrue(accessInventory.removeCategory("Dairy"));
        assertTrue(accessInventory.removeLocation("ware house"));
        assertFalse(accessInventory.isCategory("Dairy")) ;
        assertFalse(accessInventory.isLocation("ware house")) ;

        accessInventory.setCurrentItem(0);
        accessInventory.removeIndividualItem(0);
        accessInventory.removeIndividualItem(0);
        accessInventory.removeIndividualItem(0);
        accessInventory.removeIndividualItem(0);
        accessInventory.removeIndividualItem(0);


        assertEquals(0,itemType.getQuantity());

        accessInventory.removeIndividualItem(0);
        accessInventory.removeIndividualItem(0);
        accessInventory.removeIndividualItem(0);
        accessInventory.removeIndividualItem(0);

        assertEquals(0,itemType.getQuantity());


        System.out.println("Finished Integration test of AccessStudents to persistence");

    }

}
