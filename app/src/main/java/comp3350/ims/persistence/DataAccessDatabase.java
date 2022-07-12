package comp3350.ims.persistence;

import java.util.ArrayList;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLWarning;
import java.sql.DatabaseMetaData;

import comp3350.ims.objects.Inventory;
import comp3350.ims.objects.Item;
import comp3350.ims.objects.ItemType;

public class DataAccessDatabase implements DataAccess{
    private Statement st1, st2, st3;
    private Connection c1;
    private ResultSet rs2, rs3, rs4, rs5;

    private String dbName;
    private String dbType;

    private String cmdString;
    private int updateCount;
    private String result;
    private static String EOF = "  ";

    public DataAccessDatabase(String dbName)
    {
        this.dbName = dbName;
    }

    public void open(String dbPath){
        String url;
        try
        {
            dbType = "HSQL";
            Class.forName("org.hsqldb.jdbcDriver").newInstance();
            url = "jdbc:hsqldb:file:" + dbPath;
            c1 = DriverManager.getConnection(url, "IMS", "");
            st1 = c1.createStatement();
            st2 = c1.createStatement();
            st3 = c1.createStatement();
//            getActiveInventory() ;
//            addCategory("test");
//            isCategory("Bakery");
//            isCategory("test");
           addLocation("Test");
//             isLocation("Test");
//            removeLocation("Test");
//            removeLocation("Test");
          //  insertItem( new ItemType("Mostafa",15,15,"test","test","test")) ;

        }
        catch (Exception e)
        {
            processSQLError(e);
        }
        System.out.println("Opened " +dbType +" database " +dbPath);
    }

    public void close(){

    }

    public Inventory getActiveInventory(){
        Inventory i1 = new Inventory();
        String invId ;
      try{
          cmdString = "Select * from Inventory";
          rs2 = st1.executeQuery(cmdString);
      }
      catch(Exception e){
          processSQLError(e);
        }
      try{
          while (rs2.next()) {
              invId = rs2.getString("INVENTORYID") ;
              System.out.println(invId + " Lets GOOOO" );
          }

      }
      catch(Exception e){
          processSQLError(e);
      }


      return i1;
    }

    public void insertItem(ItemType item){
        String values ;


        try{
            values = "\'"+item.getName()+"\'"
                    +", '" +"MAIN"
                    +"', '" +item.getPrice()
                    +"', '" +item.getCategory()
                    +"', '" +item.getLocation()
                    +"', '" +item.getDate()
                    +"', '" +item.getQuantity()
                    +"'";
            System.out.println(values);
            cmdString = "Insert into ITEMTYPE " + " Values(" +values +")";
            updateCount = st1.executeUpdate(cmdString);
            System.out.println("Hereeee");
            cmdString = "Select * from Item";
            rs2 = st1.executeQuery(cmdString);
            String itemName ;
            try{
                while (rs2.next()) {
                    itemName = rs2.getString("NAME") ;
                    System.out.println(itemName + " Lets GOOOO" );

                }

            }
            catch(Exception e){
                processSQLError(e);
            }


        }
        catch (Exception e)
        {
            result = processSQLError(e);
        }

    }

    public String getCategoryList(ArrayList< String > categoryList){
        String category;
        String myName = EOF;

        try
        {
            cmdString = "Select * from CATEGORY";
            rs3 = st1.executeQuery(cmdString);

            while (rs3.next())
            {
                myName = rs3.getString("NAME");
                categoryList.add(myName);
            }
            rs3.close();
        } catch (Exception e)
        {
            processSQLError(e);
        }

        return null;
    }


    public void addItem(Item item, ItemType itemType) {
        String values;


        try {
            values = "\'" + item.getId() + "\'"
                    + "', '" + itemType.getName()
                    + "', '" + item.getDate()
                    + "', '" + item.getLocation()
                    + "'";
            System.out.println(values);
            cmdString = "Insert into ITEM " + " Values(" + values + ")";
            updateCount = st1.executeUpdate(cmdString);
            cmdString = "Select * from Item";
            rs2 = st1.executeQuery(cmdString);
            String itemName;
        }
        catch (Exception e)
        {
            processSQLError(e);
        }
    }


    public String getLocationList(ArrayList < String > locationList){
        String category;
        String myName = EOF;

        try
        {
            cmdString = "Select * from LOCATION";
            rs3 = st1.executeQuery(cmdString);

            while (rs3.next())
            {
                myName = rs3.getString("NAME");
                locationList.add(myName);
            }
            rs3.close();
        } catch (Exception e)
        {
            processSQLError(e);
        }

        return null;
    }

    public void addCategory(String category){
        String values;
        result = null;
        try
        {
            values = category;
            cmdString = "INSERT INTO CATEGORY " +" VALUES(\'" +values+ "\')";
            updateCount = st1.executeUpdate(cmdString);
            result = checkWarning(st1, updateCount);
        }
        catch (Exception e) {
            result = processSQLError(e);
        }
    }

    public void addLocation(String location){
        String values;
        result = null;
        try
        {
            values = location;
            cmdString = "INSERT INTO LOCATION " +" VALUES(\'" +values+ "\')";
            updateCount = st1.executeUpdate(cmdString);
            result = checkWarning(st1, updateCount);
        }
        catch (Exception e) {
            result = processSQLError(e);
        }
    }

    public boolean removeLocation(String name){
        boolean flag = false ;
        try{
            cmdString = "Delete from LOCATION where NAME= " +"\'"+name+"\'" ;
            rs2 = st1.executeQuery(cmdString);
            flag = true ;

        }
        catch(Exception e){
            processSQLError(e);
        }
        return flag ;
    }

    public boolean removeCategory(String name) {
        boolean flag = false;
        try {
            cmdString = "Delete from CATEGORY where NAME= " + "\'" + name + "\'";
            rs2 = st1.executeQuery(cmdString);
            flag = true;

        } catch (Exception e) {
            processSQLError(e);
        }
        return flag;
    }

    public boolean isCategory(String name){
        try{
            cmdString = "select * from CATEGORY where NAME= "+"\'"+name+"\'" ;
            rs2 = st1.executeQuery(cmdString);
            System.out.println(rs2.next() + " Lets goo #2");

        }
        catch(Exception e){
            processSQLError(e);
        }
        return false ;
    }

    public boolean isLocation(String name){
        try{
        cmdString = "select * from LOCATION where NAME= "+"\'"+name+"\'"  ;
        rs2 = st1.executeQuery(cmdString);
            System.out.println(rs2.next() + " Lets goo #2 loc");

    }
    catch(Exception e){
        processSQLError(e);
    }
        return false ;
    }

    public ArrayList<String> getLocationList(){return null;}

    public String processSQLError(Exception e)
    {
        String result = "*** SQL Error: " + e.getMessage();

        e.printStackTrace();

        return result;
    }

    public String checkWarning(Statement st, int updateCount)
    {
        String result;

        result = null;
        try
        {
            SQLWarning warning = st.getWarnings();
            if (warning != null)
            {
                result = warning.getMessage();
            }
        }
        catch (Exception e)
        {
            result = processSQLError(e);
        }
        if (updateCount != 1)
        {
            result = "Tuple not inserted correctly.";
        }
        return result;
    }
}
