package in.coder.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.coder.bookstore.utility.DBUtility;

public class LoginDaoImpl implements LoginDao
{
	boolean status=false;
	Connection con=DBUtility.getDBConnection();
	PreparedStatement ps;
	ResultSet rs;
	String sql;
	

	@Override
	public boolean login(String username, String password,String usertype) throws SQLException 
	{
		if(usertype.equals("admin"))
		{
			sql= "select adminnm,password from admin where adminnm=? and password=?";
			ps=con.prepareStatement(sql);
			ps.setString(1,username);
			ps.setString(2,password);
			rs=ps.executeQuery();
			while(rs.next())
			{
				status=true;
			}
			
		}
		else if(usertype.equals("customer"))
		{
			sql="select username,password from customer where username=? and password=?";
			ps=con.prepareStatement(sql);
			ps.setString(1,username);
			ps.setString(2,password);
			rs=ps.executeQuery();
			while(rs.next())
			{
				status=true;
			}
			
		}
		else
		{
			System.out.println("Invalid choice changepasswords");
			
		}
		return status;
	}

	@Override
	public boolean changePassword(String username, String password, String usertype) throws SQLException 
	{
		if(usertype.equals("admin"))
		{
			sql= "update admin set password=? where adminnm=?";
			ps=con.prepareStatement(sql);
			ps.setString(1,password);
			ps.setString(2,username);
			int x=ps.executeUpdate();
			if(x>0)
			{
				status=true;
			}
			else
			{
				status=false;
			}
			
		}
		else if(usertype.equals("customer"))
		{
			sql="update customer set password=? where username=?";
			ps=con.prepareStatement(sql);
			ps.setString(2,username);
			ps.setString(1,password);
			int x=ps.executeUpdate();
			if(x>0)
			{
				status=true;
			}
			else
			{
				status=false;
			}
			
		}
		else
		{
			
		}
		return status;
		
	}
	

}
