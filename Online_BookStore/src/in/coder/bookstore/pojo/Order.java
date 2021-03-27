package in.coder.bookstore.pojo;

import java.time.LocalDate;

public class Order 
{
	int orderid;
	String username;
	LocalDate orderdate;
	double totalbill;
	
	
	@Override
	public String toString()
	{
		return "Order [orderid=" + orderid + ", username=" + username + ", orderdate=" + orderdate + ", totalbill="
				+ totalbill + "]";
	}
	
	public int getOrderid()
	{
		return orderid;
	}
	public void setOrderid(int orderid)
	{
		this.orderid = orderid;
	}
	
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username) 
	{
		this.username = username;
	}
	
	public LocalDate getOrderdate()
	{
		return orderdate;
	}
	public void setOrderdate(LocalDate orderdate) 
	{
		this.orderdate = orderdate;
	}
	
	public double getTotalbill() 
	{
		return totalbill;
	}
	public void setTotalbill(double totalbill) 
	{
		this.totalbill = totalbill;
	}
	
}
