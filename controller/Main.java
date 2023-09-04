package controller;
import java.sql.SQLException;
import java.util.Scanner;

import dao.LoginDAO;
import dao.ProductDAO;
import model.Login;
import model.Product;
public class Main {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc=new Scanner(System.in);
     int choice,option;
     Login l=new Login();
     LoginDAO ldao=new LoginDAO();
     Product p=new Product();
     ProductDAO pdao=new ProductDAO();
	 do
	 {
		System.out.println("1.Admin");
		System.out.println("2.Agent");
		System.out.println("3.Exit");
		System.out.println("******************");
		System.out.println("Enter your choice:");
		choice=sc.nextInt();
		switch(choice) {
		case 1:
			System.out.println("Admin Login");
			System.out.println("Enter The User name");
			String username=sc.next();
			System.out.println("Enter The Password");
			String password=sc.next();
			l.setUsername(username);
			l.setPassword(password);
			if(ldao.checkCredential(l))
			{
				System.out.println("Login sucessful****");			  
			  do
			  {
				  System.out.println("1.Add Product \n2.Display Product \n3.Update\n4.Delete\n5.Logout" );
				  option=sc.nextInt();
				  switch(option)
				  {				  
						case 1:
							{System.out.println("Add Product");
						System.out.println("Enter the productId");
						int prod_id = sc.nextInt();
						sc.nextLine();
						System.out.println("Enter the productName");
						String prod_name = sc.nextLine();
						System.out.println("Enter the minimum sell quantity");
						int min_quant = sc.nextInt();
						System.out.println("Enter the price");
						int price = sc.nextInt();
						System.out.println("Enter the quantity");
						int quant = sc.nextInt();
						 p.setProd_id(prod_id);
    					 p.setProd_name(prod_name);
    					 p.setMin_qual(min_quant);
    					 p.setPrice(price);
    					 p.setQuant(quant);
    					 pdao.addProduct(p);
    					 break;	
							}
						case 2:
							System.out.println("Display Product");					  
						    pdao.dispaly();
						  break;
						case 3:
						{
							System.out.println("Update The Table");
							System.out.println("Enter the productId");
							int prod_id = sc.nextInt();
							sc.nextLine();
							System.out.println("Enter the productName");
							String prod_name = sc.nextLine();
							System.out.println("Enter the minimum sell quantity");
							int min_quant = sc.nextInt();
							System.out.println("Enter the price");
							int price= sc.nextInt();
							System.out.println("Enter the quantity");
							int quant = sc.nextInt();
							 p.setProd_id(prod_id);
	    					 p.setProd_name(prod_name);
	    					 p.setMin_qual(min_quant);
	    					 p.setPrice(price);
	    					 p.setQuant(quant);
							 pdao.update(p);
						   }
							break;
						case 4:
						{
							System.out.println("Delete The Table");
							System.out.println("Enter The Product Id");
							 int prod_id=sc.nextInt();	
							 p.setProd_id(prod_id);
							 pdao.delete(p);
							break;
						}
						case 5:
							System.out.println("Logout");
						break;
				  }
			  }while(option!=5);
			} 
			else
				System.out.println("OOPs!......Incorrect Username Or password1");
			break;
		case 2:
			System.out.println("Agent Login");
			System.out.println("Enter The User name");
			String username1=sc.next();
			System.out.println("Enter The Password");
			String password1=sc.next();
			l.setUsername(username1);
			l.setPassword(password1);
			if(ldao.checkCredential(l))
			{
				System.out.println("Login sucessful ****");			
			  do
			  {
				  System.out.println("1.Display Product \n2.Logout" );
				  option=sc.nextInt();
				  switch(option)
					{
						case 1:System.out.println("Display Product");
						pdao.dispaly();
						break;
						case 2:System.out.println("Logout");
						break;
						case 3: System.out.println("Exit");
						break;
					}
					
				}while(option!=2);
			}
			else
			{
				System.out.println("Incorrect Username/Password");
			}
			break;
			case 3: System.out.println("Exit");
			break;
		}
	}while(choice!=5);
	 sc.close();
	}
}