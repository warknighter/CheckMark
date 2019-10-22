package sample;
import java.sql.*;
import java.util.Properties;

public class Database {
    public Connection ConnectDB()
    throws ClassNotFoundException, SQLException{
        String ConnectionURL = "jdbc:sqlserver://";

        Properties prop = new Properties();
        prop.setProperty("database","MASTERUTM");
        prop.setProperty("server", "VPICD2");
        prop.setProperty("user","sa");
        prop.setProperty("password","egais123@");
        prop.setProperty("port","1433");
        prop.setProperty("LoginTimeOut","30");

        Connection con = null;
        try {
            con = DriverManager.getConnection(ConnectionURL,prop);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
         return con;
    }

    public  ResultSet select(){
      PreparedStatement pr = null;
      ResultSet rs = null;
      try {
          pr = ConnectDB().prepareStatement("select fararid from Organization");
          rs = pr.executeQuery();
      }
      catch (SQLException e){
          e.printStackTrace();
      }
      catch (ClassNotFoundException e){
          e.printStackTrace();
      }

      return rs;

    }
}
