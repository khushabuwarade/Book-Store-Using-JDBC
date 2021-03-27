package in.coder.bookstore.dao;

import java.sql.SQLException;
import java.util.List;

import in.coder.bookstore.pojo.Order;

public interface OrderDao
{
	boolean placeOrder(String username) throws SQLException;
	
	List<Order> getAllOrder() throws SQLException;
	
	List<Order> getOrderByUsername(String custUsername)throws SQLException;

}
