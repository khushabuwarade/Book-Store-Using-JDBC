package in.coder.bookstore.pojo;

public class Customer 
{
	/*
	 * custid int(11) AI PK 
custname varchar(45) 
address varchar(45) 
emailid varchar(45) 
username varchar(45) 
phoneno int(11) 
password varchar(45)
	 */

	int custid;
	long phoneno;
	String custname,address,emailid,username,password;
	
	public int getCustid() 
	{
		return custid;
	}
	public void setCustid(int custid)
	{
		this.custid = custid;
	}
	
	
	
	public long getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(long phoneno) {
		this.phoneno = phoneno;
	}
	public String getCustname() 
	{
		return custname;
	}
	public void setCustname(String custname) 
	{
		this.custname = custname;
	}
	public String getAddress() 
	{
		return address;
	}

	@Override
	public String toString() {
		return "Customer [custid=" + custid + ", phoneno=" + phoneno + ", custname=" + custname + ", address=" + address
				+ ", emailid=" + emailid + ", username=" + username + ", password=" + password + "]";
	}
	public void setAddress(String address) 
	{
		this.address = address;
	}
	public String getEmailid() 
	{
		return emailid;
	}
	public void setEmailid(String emailid) 
	{
		this.emailid = emailid;
	}
	public String getUsername() 
	{
		return username;
	}
	public void setUsername(String username) 
	{
		this.username = username;
	}
	public String getPassword() 
	{
		return password;
	}
	public void setPassword(String password) 
	{
		this.password = password;
	}
	
	
	
}
