package in.coder.bookstore.pojo;

public class Cart
{
	
	String username;
	int quantity, cartid,bookid;
	double price;
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getCartid() {
		return cartid;
	}
	public void setCartid(int cartid) {
		this.cartid = cartid;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	@Override
	public String toString() {
		return "Cart [username=" + username + ", quantity=" + quantity + ", cartid=" + cartid + ", bookid=" + bookid
				+ ", price=" + price + "]";
	}

	
	
}
