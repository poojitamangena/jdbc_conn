
package connectmanager;

import java.sql.*;

public class ConnectionManager {
       Connection cn=null;
       public Connection establishConnection() throws ClassNotFoundException, SQLException
       {
    	   Class.forName("com.mysql.cj.jdbc.Driver");
    	   cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","root");
    			   return cn;
       }
       public void closeConnection() throws SQLException
       {
    	   cn.close();
       }
}