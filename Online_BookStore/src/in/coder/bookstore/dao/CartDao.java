package in.coder.bookstore.dao;

import java.sql.SQLException;
import java.util.List;

import in.coder.bookstore.pojo.Cart;

public interface CartDao 
{
	boolean addToCart(Cart cart);
	
	boolean deleteCart(int cartid, String username);  //b4 order if i dont want to purchase use delete
	
	boolean clearCart(int cartid); //after order if i want to clear after purchasing
	
	boolean clearCart(String username) throws SQLException;
	
	List<Cart> getCart(String username) throws SQLException;
	
	
	
}
