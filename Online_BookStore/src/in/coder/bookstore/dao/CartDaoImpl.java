package in.coder.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.coder.bookstore.pojo.Cart;
import in.coder.bookstore.pojo.Customer;
import in.coder.bookstore.utility.DBUtility;

public class CartDaoImpl implements CartDao 
{
	PreparedStatement ps;
	Connection con;
	String sql;
	boolean status;
	Cart cart;
	int x;
	List<Cart> cartList;
	ResultSet rs;

	/*Table: cart
Columns:
cartid int(11) AI PK 
bookid int(11) 
username varchar(45) 
quantity int(11) 
price double
	 */
	@Override
	public boolean addToCart(Cart cart) 
	{
		try
		{
			con=DBUtility.getDBConnection();
			sql="insert into cart(bookid,username,quantity,price) values(?,?,?,?)";
			PreparedStatement pstr=con.prepareStatement(sql);
			pstr.setInt(1,cart.getBookid());
			pstr.setString(2,cart.getUsername());
			pstr.setInt(3,cart.getQuantity());
			pstr.setDouble(4,cart.getPrice());
			
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
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public boolean deleteCart(int cartid, String username) 
	{
		try
		{
			con=DBUtility.getDBConnection();
			String sql="delete from cart where cartid=? and username=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1,cartid);
			ps.setString(2,username);
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
	public boolean clearCart(int cartid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean clearCart(String username) throws SQLException
	{
		cartList=new ArrayList<>();
		con=DBUtility.getDBConnection();
		sql="delete from cart where username=?";
		ps=con.prepareStatement(sql);
		ps.setString(1,username);
		x=ps.executeUpdate();
		if(x>0)
		{
			status=true;
		}
		else
		{
			status=false;
		}
		return status;
		
	}

	@Override
	public List<Cart> getCart(String username) throws SQLException
	{
		cartList = new ArrayList<>();
		con=DBUtility.getDBConnection();
		String sql="select * from cart";
		PreparedStatement ps=con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();

		while(rs.next())
		{
			cart= new Cart();
			cart.setCartid(rs.getInt("cartid"));
			cart.setBookid(rs.getInt("bookid"));
			cart.setUsername(rs.getString("username"));
			cart.setQuantity(rs.getInt("quantity"));
			cart.setPrice(rs.getDouble("price"));
			
			cartList.add(cart);
		}
		return cartList;
	}
	

}
