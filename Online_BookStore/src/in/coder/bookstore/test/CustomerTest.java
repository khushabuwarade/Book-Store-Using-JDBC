package in.coder.bookstore.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import in.coder.bookstore.dao.CustomerDaoImpl;
import in.coder.bookstore.pojo.Customer;

public class CustomerTest
{

	public static void main(String[] args) throws IOException, SQLException
	{
	
		Scanner sc=new Scanner(System.in);

		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br= new BufferedReader(isr);
		
		Customer c=new Customer();
		CustomerDaoImpl cdi=new CustomerDaoImpl();
		List<Customer> customerList;
		
		int choice;
		boolean status=false;

		int custid;
		String custname, address,emailid ,username,password,phoneno; 
		
		System.out.println("1.Add Customer");
		System.out.println();
		System.out.println("2.Display Customer \n");
		System.out.println("3.Update Customer Profile \n");
		System.out.println("4.Delete Customer\n ");
		System.out.println("Enter choice");
		choice=sc.nextInt();
		switch(choice)
		{
		case 1:
			System.out.println("aDDING Customer");
			
			System.out.println("Enter Customer Name");
			custname=br.readLine();
			
			System.out.println("Enter address");
			address=br.readLine();
			
			System.out.println("Enter Email-id");
			emailid=br.readLine();
			
			System.out.println("Enter username");
			username=br.readLine();
			
			System.out.println("Enter Password");
			password=br.readLine();
			
			System.out.println("Enter Phone-number");
			phoneno=br.readLine();
			
			c.setCustname(custname);
			c.setAddress(address);
			c.setEmailid(emailid);
			c.setUsername(username);
			c.setPhoneno(phoneno);
			c.setPassword(password);
			
			status=cdi.insertCustomer(c);
			
			if(status==true)
			{
				System.out.println("Record inserted successfully");
			}
			else
			{
				System.out.println("Something went wrong");
			}
			break;
			
		case 2:
			
			System.out.println("All Customers Information");
			try 
			{
				customerList=cdi.getAllCustomer();
				for(Customer b2:customerList)
				{
					System.out.println(b2);
				}
			}
			catch (SQLException e1)
			{
				e1.printStackTrace();
			}
			break;
			
			
		case 3:
		
			try
			{
				
				System.out.println("Updating Book");
				
				System.out.println("enter customer id");
				custid=sc.nextInt();
				
				System.out.println("Enter Customer Name");
				custname=br.readLine();
				
				System.out.println("Enter address");
				address=br.readLine();
				
				System.out.println("Enter Email-id");
				emailid=br.readLine();
				
				System.out.println("Enter username");
				username=br.readLine();
				
				System.out.println("Enter Password");
				password=br.readLine();
				
				System.out.println("Enter Phone-number");
				phoneno=br.readLine();
				
				c.setCustid(custid);
				c.setCustname(custname);
				c.setAddress(address);
				c.setEmailid(emailid);
				c.setUsername(username);
				c.setPhoneno(phoneno);
				c.setPassword(password);
				
				status=cdi.updateCustomer(c);
				
				if(status==true)
				{
					System.out.println("Book updated successfully");
				}
				else
				{
					System.out.println("Book record not found");
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
				
			break;
		
		case 4:
			try
			{
				System.out.println("Enter existinh book id");
				custid=sc.nextInt();
				c.setCustid(custid);
				
				status=cdi.deleteCustomer(custid);
				if(status==true)
				{
					System.out.println("Book deleted successfully");
				}
				else
				{
					System.out.println("Book record not found");
				}
			}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			
		break;
			
			
		default:
			System.out.println("wrong choice");
			
		}	
	}

}
