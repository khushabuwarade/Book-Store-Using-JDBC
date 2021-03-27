package in.coder.bookstore.pojo;

public class Book 
{
	private int bookid,quantity;
	private double price;
	private String bookName,bookCategory,description,authorNm,publisher;

	public int getBookid() 
	{
		return bookid;
	}

	public void setBookid(int bookid)
	{
		this.bookid = bookid;
	}

	public int getQuantity() 
	{
		return quantity;
	}

	@Override
	public String toString() {
		return "Book [bookid=" + bookid + ", quantity=" + quantity + ", price=" + price + ", bookName=" + bookName
				+ ", bookCategory=" + bookCategory + ", description=" + description + ", authorNm=" + authorNm
				+ ", publisher=" + publisher + "]";
	}

	public void setQuantity(int quantity) 
	{
		this.quantity = quantity;
	}

	public double getPrice() 
	{
		return price;
	}

	public void setPrice(double price) 
	{
		this.price = price;
	}

	public String getBookName() 
	{
		return bookName;
	}

	public void setBookName(String bookName) 
	{
		this.bookName = bookName;
	}

	public String getBookCategory() 
	{
		return bookCategory;
	}

	public void setBookCategory(String bookCategory) 
	{
		this.bookCategory = bookCategory;
	}

	public String getDescription() 
	{
		return description;
	}

	public void setDescription(String description) 
	{
		this.description = description;
	}

	public String getAuthorNm() 
	{
		return authorNm;
	}

	public void setAuthorNm(String authorNm)
	{
		this.authorNm = authorNm;
	}

	public String getPublisher() 
	{
		return publisher;
	}

	public void setPublisher(String publisher)
	{
		this.publisher = publisher;
	}

}