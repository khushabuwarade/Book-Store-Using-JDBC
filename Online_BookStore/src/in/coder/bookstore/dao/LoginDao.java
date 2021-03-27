package in.coder.bookstore.dao;

import java.sql.SQLException;

public interface LoginDao 
{
	boolean login(String username,String password,String usertype) throws SQLException;
	boolean changePassword(String username,String password,String usertype) throws SQLException;

}
