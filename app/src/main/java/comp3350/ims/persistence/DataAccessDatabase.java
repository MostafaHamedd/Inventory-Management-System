package comp3350.ims.persistence;

import java.util.ArrayList;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLWarning;
import java.sql.DatabaseMetaData;

import comp3350.ims.objects.Inventory;
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
        return null;
    }

    public String insertItem(ItemType item){
        return null;
    }

    public String getCategoryList(ArrayList< String > categoryList){
        return null;
    }

    public String getLocationList(ArrayList < String > locationList){return null;}

    public void addCategory(String category){return;}

    public void addLocation(String location){return;}

    public boolean removeLocation(String name){return false;}

    public boolean removeCategory(String name){return false;}

    public boolean isCategory(String name){return false;}

    public boolean isLocation(String name){return false;}
    public ArrayList<String> getLocationList(){return null;}

    public String processSQLError(Exception e)
    {
        String result = "*** SQL Error: " + e.getMessage();

        e.printStackTrace();

        return result;
    }
}
