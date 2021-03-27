package in.coder.bookstore.utility;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtility 
{
	public static Connection getDBConnection() //or wite this n dont write try catch...throws SQLException, ClassNotFoundException
	{
		Connection con=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/book_db","root","root");
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e);
		}
		return con;
	}
}
