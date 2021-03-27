package in.coder.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.coder.bookstore.pojo.Book;
import in.coder.bookstore.pojo.Customer;
import in.coder.bookstore.utility.DBUtility;

public class CustomerDaoImpl implements CustomerDao
{
	Connection con=null;
	int x=0;
	boolean status;
	List<Customer> customerList;
	Customer customer;
	PreparedStatement pstr;
	
	@Override
	public boolean insertCustomer(Customer customer) 
	{

		try
		{
			con=DBUtility.getDBConnection();
		
				/*
				 * custid int(11) AI PK 
					custname varchar(45) 
					address varchar(45) 
					emailid varchar(45) 
					username varchar(45) 
					phoneno int(11) 
					password varchar(45)
				 */
			
			String s="insert into customer(custname,address,emailid,username,phoneno,password) values(?,?,?,?,?,?)";
				pstr=con.prepareStatement(s);
				pstr.setString(1,customer.getCustname());
				pstr.setString(2,customer.getAddress());
				pstr.setString(3,customer.getEmailid());
				pstr.setString(4,customer.getUsername());
				pstr.setLong(5,customer.getPhoneno());
				pstr.setString(6,customer.getPassword());
				
				x=pstr.executeUpdate();
				
				if(x>0)
				{
					status=true;
				}
				else
				{
					status=false;
				}
				
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return status;
	
	}

	@Override
	public List<Customer> getAllCustomer() throws SQLException 
	{
		customerList = new ArrayList<>();
		con=DBUtility.getDBConnection();
		String sql="select * from customer";
		PreparedStatement ps=con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();

		/*
		 * custid int(11) AI PK 
			custname varchar(45) 
			address varchar(45) 
			emailid varchar(45) 
			username varchar(45) 
			phoneno int(11) 
			password varchar(45)
		 */
		while(rs.next())
		{
			customer= new Customer();
			customer.setCustid(rs.getInt("custid"));
			customer.setCustname(rs.getString("custname"));
			customer.setAddress(rs.getString("address"));
			customer.setEmailid(rs.getString("emailid"));
			customer.setUsername(rs.getString("username"));
			customer.setPhoneno(rs.getLong("phoneno"));
			customer.setPassword(rs.getString("password"));
			customerList.add(customer);
		}
		return customerList;
			
	}

	@Override
	public boolean updateCustomer(Customer customer) 
	{
		try
		{
			con=DBUtility.getDBConnection();
			String sql="update customer set custname=?,address=?,emailid=?,username=?,phoneno=?,password=? where custid=?";
			
			PreparedStatement pstr=con.prepareStatement(sql);
			pstr.setString(1,customer.getCustname());
			pstr.setString(2,customer.getAddress());
			pstr.setString(3,customer.getEmailid());
			pstr.setString(4,customer.getUsername());
			pstr.setLong(5,customer.getPhoneno());
			pstr.setString(6,customer.getPassword());
			pstr.setInt(7, customer.getCustid());
			
			x= pstr.executeUpdate();

			if(x>0)
			{
				status=true;
			}
			else
			{
				status=false;
			}			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public boolean deleteCustomer(int custid)
	{
		try
		{
			con=DBUtility.getDBConnection();
			String sql="delete from customer where custid=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1,custid);
			x=ps.executeUpdate();
			if(x>0)
			{
				status=true;
			}
			else
			{
				status=false;
			}			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return status;
			
	}

	@Override
	public List<Customer> getCustomerById(int custid) throws SQLException
	{
		customerList=new ArrayList<Customer>();
		con=DBUtility.getDBConnection();
		String sql="select * from customer where custid=?";
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setInt(1,custid);
		ResultSet rs=pst.executeQuery();
		while(rs.next())
		{
			customer= new Customer();
			customer.setCustid(rs.getInt("custid"));
			customer.setCustname(rs.getString("custname"));
			customer.setAddress(rs.getString("address"));
			customer.setEmailid(rs.getString("emailid"));
			customer.setUsername(rs.getString("username"));
			customer.setPhoneno(rs.getLong("phoneno"));
			customer.setPassword(rs.getString("password"));
			customerList.add(customer);
		}
		return customerList;
	}

	@Override
	public List<Customer> getCustomerByUsername(String username) throws SQLException 
	{
		customerList=new ArrayList<Customer>();
		con=DBUtility.getDBConnection();
		String sql="select * from customer where username=?";
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setString(1,username);
		ResultSet rs=pst.executeQuery();
		while(rs.next())
		{
			customer= new Customer();
			customer.setCustid(rs.getInt("custid"));
			customer.setCustname(rs.getString("custname"));
			customer.setAddress(rs.getString("address"));
			customer.setEmailid(rs.getString("emailid"));
			customer.setUsername(rs.getString("username"));
			customer.setPhoneno(rs.getLong("phoneno"));
			customer.setPassword(rs.getString("password"));
			customerList.add(customer);
		}
		return customerList;

	}
	


}


