package in.coder.bookstore.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import in.coder.bookstore.pojo.Book;
import in.coder.bookstore.pojo.Customer;
import in.coder.bookstore.pojo.Order;
import in.coder.bookstore.utility.DBUtility;

public class OrderDaoImpl implements OrderDao
{
	String query;
	Connection con= DBUtility.getDBConnection();
	List<Order> orderList;
	Order order;
	PreparedStatement ps;
	ResultSet rs;
	double totalbill=0.0;
	int x;
	String sql;
	boolean status,status1 ;
	CartDaoImpl cartdao=new CartDaoImpl();
	

	@Override
	public boolean placeOrder(String username) throws SQLException
	{
		sql="select sum(price) from cart where username=?";
		
		ps=con.prepareStatement(sql);
		ps.setString(1,username);
		rs=ps.executeQuery();
		while(rs.next())
		{
			totalbill=rs.getDouble(1);
			
		}
		if(totalbill>0)
		{
			Date orderdate=Date.valueOf(LocalDate.now());
			
			query="insert into order474(totalbill,orderdate,username) values(?,?,?)";
			
			ps=con.prepareStatement(query);
			ps.setDouble(1,totalbill);
			ps.setDate(2,orderdate);
			ps.setString(3,username);
			x=ps.executeUpdate();
			status1=cartdao.clearCart(username);
		}
		if(x>0 && status1==true)
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
	public List<Order> getAllOrder() throws SQLException 
	{
		orderList = new ArrayList<>();
		con=DBUtility.getDBConnection();
		String sql="select * from order474";
		PreparedStatement ps=con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();

		/*
		 * orderid int(11) AI PK 
username varchar(45) 
orderdate date 
totalbill double
		 */
		while(rs.next())
		{
			order= new Order();
			order.setUsername(rs.getString("username"));
			order.setOrderdate(rs.getDate("orderdate").toLocalDate());
			order.setTotalbill(rs.getDouble("totslbill"));
			orderList.add(order);
		}
		return orderList;
	}

	@Override
	public List<Order> getOrderByUsername(String username) throws SQLException 
	{
		orderList=new ArrayList<>();
		con=DBUtility.getDBConnection();
		String sql="select * from order474 where username like ?";
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setString(1,username);
		ResultSet rs=pst.executeQuery();
		while(rs.next())
		{
			order=new Order();
			order.setUsername(rs.getString("username"));
			order.setOrderdate(rs.getDate("orderdate").toLocalDate());
			order.setTotalbill(rs.getDouble("totslbill"));
			orderList.add(order);
		}
		return orderList;
	
	}
}	

