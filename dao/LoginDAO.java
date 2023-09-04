package dao;

import java.sql.*;

import connectmanager.ConnectionManager;
import model.Login;
public class LoginDAO {
	public boolean checkCredential(Login l) throws ClassNotFoundException, SQLException{
		//1.get the details from login.java file
		String username=l.getUsername();
		String password=l.getPassword();
		//2.jdbc connection.
		ConnectionManager cm= new ConnectionManager();
		Connection con=cm.establishConnection();
		//where we are going to write the queries
		//3.statement class
		Statement st=con.createStatement();
		//4.create  query and execute query
		ResultSet rt=st.executeQuery("select * from login");
		while(rt.next()) {
			if(username.equals(rt.getString("username")) && password.equals(rt.getString("paswd")))
			{
				cm.closeConnection();
				return true;
			}
		}
		cm.closeConnection();
		return true;
	}
}
