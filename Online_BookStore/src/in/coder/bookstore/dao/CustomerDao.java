package in.coder.bookstore.dao;

import java.sql.SQLException;
import java.util.List;

import in.coder.bookstore.pojo.Book;
import in.coder.bookstore.pojo.Customer;

public interface CustomerDao
{
	public boolean insertCustomer(Customer cust);
	public List<Customer> getAllCustomer() throws SQLException;
	public boolean updateCustomer(Customer cust);
	public boolean deleteCustomer(int custid);
	
	public List<Customer> getCustomerById(int custid) throws SQLException;
	
	public List<Customer> getCustomerByUsername(String username) throws SQLException;
	
	
}
