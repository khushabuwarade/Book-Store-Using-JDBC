package in.coder.bookstore.dao;
import in.coder.bookstore.pojo.Book;
import in.coder.bookstore.utility.DBUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public  class BookDaoImpl implements BookDao
{
	Connection con=null;
	int x=0;
	boolean status;
	List<Book> bookList;
	Book book;
	
	@Override
	public boolean insertBook(Book book)
	{
		try
		{
			con=DBUtility.getDBConnection();
		
				/*
				 *  bookid int(11) AI PK 
					bookName varchar(45) 
					bookCategory varchar(45) 
					description varchar(45) 
					authorNm varchar(45) 
					publisher varchar(45) 
					price double 
					quantity int(11)
				 */
			
			String s="insert into book(bookName,bookCategory,description,authorNm,publisher,price,quantity) values(?,?,?,?,?,?,?)";
				PreparedStatement pstr=con.prepareStatement(s);
				pstr.setString(1,book.getBookName());
				pstr.setString(2,book.getBookCategory());
				pstr.setString(3,book.getDescription());
				pstr.setString(4,book.getAuthorNm());
				pstr.setString(5,book.getPublisher());
				pstr.setDouble(6,book.getPrice());
				pstr.setInt(7,book.getQuantity());
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
	
	public List<Book> getAllBooks() throws SQLException
	{
		bookList = new ArrayList<>();
		con=DBUtility.getDBConnection();
		String sql="select * from book";
		PreparedStatement ps=con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			book=new Book();
			book.setBookid(rs.getInt("bookid"));
			book.setBookName(rs.getString("bookName"));
			book.setAuthorNm(rs.getString("authorNm"));
			book.setPublisher(rs.getString("publisher"));
			book.setDescription(rs.getString("description"));
			book.setBookCategory(rs.getString("bookCategory"));
			book.setPrice(rs.getInt("price"));
			book.setQuantity(rs.getInt("quantity"));
			bookList.add(book);
		}
		return bookList;
			
	}

	@Override
	public boolean updateBook(Book book) 
	{
		
		try
		{
			con=DBUtility.getDBConnection();
			String sql="update book set bookName=?,authorNm=?,publisher=?,description=?,bookCategory=?,price=?,quantity=? where bookid=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,book.getBookName());
			ps.setString(2,book.getAuthorNm());
			ps.setString(3,book.getPublisher());
			ps.setString(4,book.getDescription());
			ps.setString(5,book.getBookCategory());
			ps.setDouble(6,book.getPrice());
			ps.setInt(7,book.getQuantity());
			ps.setInt(8,book.getBookid());
			
			x= ps.executeUpdate();
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
	
	public boolean deleteBook(int bookid)
	{
		try
		{
			con=DBUtility.getDBConnection();
			String sql="delete from book where bookid=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1,bookid);
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
	public List<Book> getBookByName(String bookName) throws SQLException 
	{
		bookList=new ArrayList<Book>();
		con=DBUtility.getDBConnection();
		String sql="select * from book where bookName like ?";
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setString(1,"%"+bookName+"%");
		ResultSet rs=pst.executeQuery();
		while(rs.next())
		{
			book=new Book();
			book.setBookid(rs.getInt("bookid"));
			book.setBookName(rs.getString("bookName"));
			book.setAuthorNm(rs.getString("authorNm"));
			book.setPublisher(rs.getString("publisher"));
			book.setDescription(rs.getString("description"));
			book.setBookCategory(rs.getString("bookCategory"));
			book.setPrice(rs.getDouble("price"));
			book.setQuantity(rs.getInt("quantity"));
			bookList.add(book);
		}
		return bookList;
	}

	@Override
	public List<Book> getBookByAuthor(String authorNm) throws SQLException
	{

		bookList=new ArrayList<Book>();
		con=DBUtility.getDBConnection();
		String sql="select * from book where authorNm like ?";
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setString(1,"%"+authorNm+"%");
		ResultSet rs=pst.executeQuery();
		while(rs.next())
		{
			book=new Book();
			book.setBookid(rs.getInt("bookid"));
			book.setBookName(rs.getString("bookName"));
			book.setAuthorNm(rs.getString("authorNm"));
			book.setPublisher(rs.getString("publisher"));
			book.setDescription(rs.getString("description"));
			book.setBookCategory(rs.getString("bookCategory"));
			book.setPrice(rs.getInt("price"));
			book.setQuantity(rs.getInt("quantity"));
			bookList.add(book);
		}
		return bookList;
	}

	@Override
	public List<Book> getBookByPublisher(String publisher) throws SQLException 
	{

		bookList=new ArrayList<Book>();
		con=DBUtility.getDBConnection();
		String sql="select * from book where publisher like ?";
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setString(1,"%"+publisher+"%");
		ResultSet rs=pst.executeQuery();
		while(rs.next())
		{
			book=new Book();
			book.setBookid(rs.getInt("bookid"));
			book.setBookName(rs.getString("bookName"));
			book.setAuthorNm(rs.getString("authorNm"));
			book.setPublisher(rs.getString("publisher"));
			book.setDescription(rs.getString("description"));
			book.setBookCategory(rs.getString("bookCategory"));
			book.setPrice(rs.getInt("price"));
			book.setQuantity(rs.getInt("quantity"));
			bookList.add(book);
		}
		return bookList;
	}

	@Override
	public List<Book> getBookByCategory(String bookCategory) throws SQLException 
	{
		bookList=new ArrayList<Book>();
		con=DBUtility.getDBConnection();
		String sql="select * from book where bookCategory like ?";
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setString(1,"%"+bookCategory+"%");
		ResultSet rs=pst.executeQuery();
		while(rs.next())
		{
			book=new Book();
			book.setBookid(rs.getInt("bookid"));
			book.setBookName(rs.getString("bookName"));
			book.setAuthorNm(rs.getString("authorNm"));
			book.setPublisher(rs.getString("publisher"));
			book.setDescription(rs.getString("description"));
			book.setBookCategory(rs.getString("bookCategory"));
			book.setPrice(rs.getInt("price"));
			book.setQuantity(rs.getInt("quantity"));
			bookList.add(book);
		}
		return bookList;
	}
}
		
	
