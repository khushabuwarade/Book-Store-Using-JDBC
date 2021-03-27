package in.coder.bookstore.dao;

import java.sql.SQLException;
import java.util.List;

import in.coder.bookstore.pojo.Book;

public interface BookDao 
{
	public boolean insertBook(Book book);
	
	public boolean updateBook(Book book);
	
	public boolean deleteBook(int bookid);
	
	public List<Book> getAllBooks() throws SQLException;
	
	public List<Book> getBookByName(String bookName) throws SQLException;
	
	public List<Book> getBookByAuthor(String authorNm) throws SQLException;

	public List<Book> getBookByPublisher(String publisher) throws SQLException;
	
	public List<Book> getBookByCategory(String bookCategory)  throws SQLException;
	
	
	
	
}
