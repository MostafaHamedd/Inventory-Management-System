package comp3350.ims.intergration;

import junit.framework.TestCase;

import comp3350.ims.application.Main;
import comp3350.ims.application.Services;
import comp3350.ims.persistence.DataAccess;
import comp3350.ims.persistence.DataAccessTest;

public class BusinessPresistenceTests extends TestCase {
    private static String dbName = Main.dbName;
    public BusinessPresistenceTests(String arg0)
    {
        super(arg0);
    }
    public void testDataAccess(){
        BusinessPersistenceSeamTest test = new BusinessPersistenceSeamTest(dbName);

        Services.closeDataAccess();

        System.out.println("\nStarting Integration test DataAccess (using default DB)");

        Services.createDataAccess(dbName);
        Services.setAutoCommitOff();
        test.testAccessInventorySimpleCases();
        Services.closeDataAccess();

        Services.createDataAccess(dbName);
        Services.setAutoCommitOff();
        test.testAccessInventoryEdgeCases();
        Services.closeDataAccess();

        System.out.println("Finished Integration test DataAccess (using default DB)");
    }
}
