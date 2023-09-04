package dao;

import java.sql.*;

import connectmanager.ConnectionManager;
import model.Product;

public class ProductDAO {
	public void addProduct(Product p) throws ClassNotFoundException, SQLException {
		ConnectionManager cm= new ConnectionManager();
		Connection con=cm.establishConnection();
		String que="insert into product(prod_id ,prod_name,min_qual ,price,quant) values(?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(que);
		ps.setInt(1,p.getProd_id());
		ps.setString(2,p.getProd_name());
		ps.setInt(3,p.getMin_qual());
		ps.setInt(4,p.getPrice());
		ps.setInt(5,p.getQuant());
		ps.executeUpdate();
		cm.closeConnection();
	}
	public void update(Product p) throws ClassNotFoundException, SQLException 
	{
		ConnectionManager cm= new ConnectionManager();
		Connection con=cm.establishConnection();
		String que="update product set Prod_name=?,min_qual=?,price=?,quant=? where prod_id=?";
		PreparedStatement ps=con.prepareStatement(que);
		ps.setString(1,p.getProd_name());
		ps.setInt(2,p.getMin_qual());
		ps.setInt(3,p.getPrice());
		ps.setInt(4,p.getQuant());
		ps.setInt(5,p.getProd_id());
		ps.executeUpdate();
		cm.closeConnection();
	}
	public void delete(Product p) throws ClassNotFoundException, SQLException 
	{
		ConnectionManager cm= new ConnectionManager();
		Connection con=cm.establishConnection();
		String que="delete from product where prod_id=?";
		PreparedStatement ps=con.prepareStatement(que);
		ps.setInt(1,p.getProd_id());
		ps.executeUpdate();
		cm.closeConnection();
	}

	public void dispaly() throws ClassNotFoundException, SQLException {
		ConnectionManager cm= new ConnectionManager();
		Connection con=cm.establishConnection();
		//where we are going to write the queries
		//3.statement class
		Statement st=con.createStatement();
		//4.create  query and execute query
		ResultSet rt=st.executeQuery("select * from product");
		while(rt.next()) {
			{
				System.out.println(rt.getInt("prod_id")+"||"+rt.getString("prod_name")+"||"+rt.getInt("min_qual")+"||"+rt.getInt("price")+"||"+rt.getInt("quant"));
			}
		}
		cm.closeConnection();
	}
}
