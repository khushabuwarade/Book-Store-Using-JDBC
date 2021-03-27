package in.coder.bookstore.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import in.coder.bookstore.dao.BookDaoImpl;
import in.coder.bookstore.dao.CartDaoImpl;
import in.coder.bookstore.dao.LoginDao;
import in.coder.bookstore.dao.LoginDaoImpl;
import in.coder.bookstore.dao.OrderDaoImpl;
import in.coder.bookstore.pojo.Book;
import in.coder.bookstore.pojo.Cart;
import in.coder.bookstore.pojo.Customer;
import in.coder.bookstore.pojo.Order;
import in.coder.bookstore.dao.CustomerDaoImpl;

public class Test 
{
	
	public static void main(String[] args) throws IOException,SQLException
	{

		Scanner sc=new Scanner(System.in);
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br= new BufferedReader(isr);
		
		String username,bookName,bookCategory,description, authorNm,publisher,usertype,custname,address,emailid;
		double price; 
		int quantity,bookid;
		int choice,custid;
		boolean status=false;
		long phoneno;
		
		//Book.java
		Book b=new Book();
		BookDaoImpl bdi=new BookDaoImpl();
		List<Book> bookList;

		//Cart
		Cart c=new Cart();		
		List<Cart> cartList;
		CartDaoImpl cdi=new CartDaoImpl();
		
		//Customer
		List<Customer> customerList;
		Customer customer;
		CustomerDaoImpl custdi=new CustomerDaoImpl();
		Customer cust=new Customer();
		
		
		//LoginDaoImpl.java
		LoginDao log=new LoginDaoImpl();
		
		//Order
		OrderDaoImpl odi=new OrderDaoImpl();
		Order o=new Order();
		List<Order> orderList;
		
		System.out.println("Enter Usertype(a)admin/customer");
		usertype=br.readLine();
		
		System.out.println("Enter username");
		username=br.readLine();
		
		System.out.println("Enter password");
		String password=br.readLine();
		
		status=log.login(username,password,usertype);
		if(status==true)
		{
			System.out.println("Successfull Admin Login");
			if(usertype.equals("admin"))
			{
				do
				{
				
				System.out.println("1. Change Password");
				System.out.println("2. Add Book");
				System.out.println("3. Update The Book");
				System.out.println("4. Delete the Book");
				System.out.println("5. Get Information Of all books");
				System.out.println("6. Get Infomartion about All Customers");
				System.out.println("7. Get All Orders");
				System.out.println("0. Exit The Case");
				
				System.out.println("\n Enter your choice:-------");
				choice=sc.nextInt();
				
				
				switch(choice)
				{
					case 1:
					{
						System.out.println("Enter Usertype(a)admin/customer");
						usertype=br.readLine();
						
						System.out.println("Enter username");
						username=br.readLine();
						
						System.out.println("Enter new password");
						String newpass=sc.next();
						
						if(log.changePassword(username,newpass, usertype)==true)
						{
							System.out.println("password changed successfully");
						}
						else
						{
							System.out.println("NO such user prsent");
						}
						break;
					}//case1
					
					case 2:
					{
						System.out.println("Inserting book---------------");
						
						System.out.println("Enter Book Name");
						bookName=br.readLine();
						
						System.out.println("Enter category name");
						bookCategory=br.readLine();
						
						System.out.println("Enter description");
						description=br.readLine();
						
						System.out.println("Enter Author Name");
						authorNm=br.readLine();
						
						System.out.println("Enter Publisher");
						publisher=br.readLine();
						
						System.out.println("Enter price");
						price=sc.nextDouble();
						
						System.out.println("Enter Quantity");
						quantity=sc.nextInt();
						
						b.setBookName(bookName);
						b.setBookCategory(bookCategory);
						b.setDescription(description);
						b.setPublisher(publisher);
						b.setAuthorNm(authorNm);
						b.setPrice(price);
						b.setQuantity(quantity);
						
						status=bdi.insertBook(b);
						
						if(status==true)
						{
							System.out.println("Record inserted successfully");
						}
						else
						{
							System.out.println("Something went wrong");
						}
						break;
					}//case 2
					
					case 3:
					{
						try
						{
							System.out.println("Updating the book------------");
							System.out.println("Enter Existing Book Id");
							bookid=sc.nextInt();
							
							System.out.println("Enter Book Name");
							bookName=br.readLine();
							
							System.out.println("Enter category name");
							bookCategory=br.readLine();
							
							System.out.println("Enter description");
							description=br.readLine();
							
							System.out.println("Enter Author Name");
							authorNm=br.readLine();
							
							System.out.println("Enter Publisher");
							publisher=br.readLine();
							
							System.out.println("Enter price");
							price=sc.nextDouble();
							
							System.out.println("Enter Quantity");
							quantity=sc.nextInt();
							
							b.setBookid(bookid);
							b.setBookName(bookName);
							b.setBookCategory(bookCategory);
							b.setDescription(description);
							b.setPublisher(publisher);
							b.setAuthorNm(authorNm);
							b.setPrice(price);
							b.setQuantity(quantity);
							
							status=bdi.updateBook(b);
							if(status==true)
							{
								System.out.println("Book updated successfully");
							}
							else
							{
								System.out.println("Book record not found");
							}
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
						break;
				}//case 3
				
					case 4:
					{
						try
						{
							System.out.println("Deleting cart:-------");
							System.out.println("Enter cart id");
							int cartid=sc.nextInt();
							System.out.println("Enter Username");
							username=sc.next();
							status=cdi.deleteCart(cartid, username);
							
							if(status==true)
							{
								System.out.println("Cart Deleted");
							}
							else
							{
								System.out.println("Something went wrong");
							}
						}
						catch (Exception e)
						{
							e.printStackTrace();
						}
						break;
						
					}//case 4
					
					case 5:
					{
						System.out.println("All Books Information:---------");
						bookList=bdi.getAllBooks();
						for(Book b2:bookList)
						{
							System.out.println(b2);
						}
						break;
					}
					
					case 6:
					{
						
						System.out.println("All Customers Information");
						try 
						{
							customerList=custdi.getAllCustomer();
							for(Customer b2:customerList)
							{
								System.out.println(b2);
							}
						}
						catch (SQLException e1)
						{
							e1.printStackTrace();
						}
						break;
					}
					case 7:
					{
						try 
						{
							System.out.println("Displaying all orders");
							orderList=odi.getAllOrder();
							
							for(Order o2:orderList)
							{
								System.out.println(o2);
							}
							break;
						}
						catch (Exception e) 
						{
							e.printStackTrace();
						}
						break;
					}
					case 0:
					{
						System.out.println("Exiting");
						System.exit(0);
						break;
					}
					default:
						System.out.println("Invalid choice");
						
				
				}//switch case
				}while(choice>0);
				
			}//if "admin"
			else if(usertype.equals("customer"))
			{	
				do
				{
					System.out.println("1. Change Password");
					System.out.println("2. Add Customer");
					System.out.println("3. Update Customer");
					System.out.println("4. Add To Cart");
					System.out.println();
					System.out.println("5. Searching the book");
					System.out.println("6. Get Infomartion about All Books");
					System.out.println("7. View Profile");//getCustomerBy Username
					System.out.println("8. Get Cart");
					System.out.println("9. Get All Order");
					System.out.println("9. Place Order");
					
					System.out.println("\n Enter your choice:-------");
					choice=sc.nextInt();
					switch(choice)
					{
					case 1:
					{
						usertype=br.readLine();
						
						System.out.println("Enter username");
						username=br.readLine();
						
						System.out.println("Enter new password");
						String newpass=sc.next();
						
						if(log.changePassword(username,newpass, usertype)==true)
						{
							System.out.println("password changed successfully");
						}
						else
						{
							System.out.println("NO such user prsent");
						}
						break;
					}//case1
					
					case 2:
					{
						System.out.println("aDDING Customer");
						
						System.out.println("Enter Customer Name");
						custname=br.readLine();
						
						System.out.println("Enter address");
						address=br.readLine();
						
						System.out.println("Enter Email-id");
						emailid=br.readLine();
						
						System.out.println("Enter username");
						username=br.readLine();
						
						System.out.println("Enter Password");
						password=br.readLine();
						
						System.out.println("Enter Phone-number");
						phoneno=sc.nextLong();
						
						cust.setCustname(custname);
						cust.setAddress(address);
						cust.setEmailid(emailid);
						cust.setUsername(username);
						cust.setPhoneno(phoneno);
						cust.setPassword(password);
						
						status=custdi.insertCustomer(cust);
						
						if(status==true)
						{
							System.out.println("Record inserted successfully");
						}
						else
						{
							System.out.println("Something went wrong");
						}
						break;
					}//case 2
					case 3:
					{
						try
						{
							
							System.out.println("Updating Book");
							
							System.out.println("enter customer id");
							custid=sc.nextInt();
							
							System.out.println("Enter Customer Name");
							custname=br.readLine();
							
							System.out.println("Enter address");
							address=br.readLine();
							
							System.out.println("Enter Email-id");
							emailid=br.readLine();
							
							System.out.println("Enter username");
							username=br.readLine();
							
							System.out.println("Enter Password");
							password=br.readLine();
							
							System.out.println("Enter Phone-number");
							phoneno=sc.nextLong();
							
							cust.setCustid(custid);
							cust.setCustname(custname);
							cust.setAddress(address);
							cust.setEmailid(emailid);
							cust.setUsername(username);
							cust.setPhoneno(phoneno);
							cust.setPassword(password);
							
							status=custdi.updateCustomer(cust);
							
							if(status==true)
							{
								System.out.println("Book updated successfully");
							}
							else
							{
								System.out.println("Book record not found");
							}
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
							
						break;
					}//case 3
					case 4:
					{
						System.out.println("Adding into cart..............");
						 
						 System.out.println("Enter book id");
						 bookid=sc.nextInt();
						 
						 System.out.println("Enter username");
						 username=sc.next();
						 
						 quantity=1;
						 
						 System.out.println("Enter Price");
						 price=sc.nextDouble();
						 
						 c.setBookid(bookid);
						 c.setUsername(username);
						 c.setQuantity(quantity);
						 c.setPrice(price);
						 
						 status=cdi.addToCart(c);
							
							if(status==true)
							{
								System.out.println("Record inserted successfully");
							}
							else
							{
								System.out.println("Something went wrong");
							}
							break;
						
					}//case 4
					case 5:
					{
						System.out.println("Searching The Book By:-------");
						System.out.println("1. Search By Book Name ");
						System.out.println("2. Search By Author Name ");
						System.out.println("3. Search By Catergory");
						System.out.println("4. Search By Publisher");
						
						System.out.println("Enter Your Choice");
						int ch=sc.nextInt();
						
						if(ch==1)
						{
							System.out.println("Seaching By Book Name!!!!!!!!!!!!!!!!");
							try
							{
								System.out.println("Search Book by name ");
								System.out.println("Enter book name");
								bookName=br.readLine();
								bookList=bdi.getBookByName(bookName);
								
								if(bookList.isEmpty())
								{
									System.out.println("empty");
								}
								else
								{
									for(Book b3: bookList)
									{
										System.out.println(b3);
									}
								}
							}
							catch(Exception e )
							{
								System.out.println(e);
							}
							break;
						}//if
						else if(ch==2)
						{
							try
							{
								System.out.println("Searching By Author Name!!!!!!!!!!!!!!!!");
								System.out.println("Enter author name");
								authorNm=br.readLine();
								bookList=bdi.getBookByAuthor(authorNm);
								
								if(bookList.isEmpty())
								{
									System.out.println("empty");
								}
								else
								{
									for(Book b3: bookList)
									{
										System.out.println(b3);
									}
								}
							}
							catch(Exception e)
							{
								System.out.println(e);
							}
							break;
						}//else if
						
						else if(ch==3)
						{
							try
							{
								System.out.println("Search Book by Category ");
								System.out.println("Enter book category");
								bookCategory=br.readLine();
								bookList=bdi.getBookByCategory(bookCategory);
								
								if(bookList.isEmpty())
								{
									System.out.println("empty");
								}
								else
								{
									for(Book b3: bookList)
									{
										System.out.println(b3);
									}
								}
							}
							catch(Exception e )
							{
								System.out.println(e);
							}
							break;
						}//else if
					 
						else if(ch==4)
						{
						  try
							{
								System.out.println("Search Book by Publisher");
								System.out.println("Enter book Publisher name");
								publisher=br.readLine();
								bookList=bdi.getBookByPublisher(publisher);
								
								if(bookList.isEmpty())
								{
									System.out.println("empty");
								}
								else
								{
									for(Book b3: bookList)
									{
										System.out.println(b3);
									}
								}
							}
							catch(Exception e )
							{
								System.out.println(e);
							}
							break;
					  }// else if
					
						else
						{
							System.out.println("Invalid Option");
						}
					}//case 5
					
					case 6:
					{
						System.out.println(" Get All Books--------------");
						bookList=bdi.getAllBooks();
						for(Book b2:bookList)
						{
							System.out.println(b2);
						}
						break;
					}
					case 7:
					{
						try
						{
							System.out.println("View Profile");
							System.out.println("Enter User name");
							username=br.readLine();
							customerList=custdi.getCustomerByUsername(username);
							
							if(customerList.isEmpty())
							{
								System.out.println("empty");
							}
							else
							{
								for(Customer c3: customerList)
								{
									System.out.println(c3);
								}
							}
						}
						catch(Exception e )
						{
							System.out.println(e);
						}
						break;
					}//case 7
					
					case 8:
					{
						try 
						{
							System.out.println("Getting cart...........");
							System.out.println("Enter Username");
							username=sc.next();
							cartList=cdi.getCart(username);
							
							if(cartList!=null && !cartList.isEmpty())
							{
								for(Cart c2: cartList)
								{
									System.out.println(c2);
								}
							}
						}
						
						catch (Exception e)
						{
							e.printStackTrace();
						}
					}//case 8
					
					case 9:
					{
						try
						{
							System.out.println("Placing Order.....");
							System.out.println("Enter username");
							username=sc.next();
							status=odi.placeOrder(username);
							if(status==true)
							{
								System.out.println("Order placed successfully");
							}
							else
							{
								System.out.println("Sumthing went wrong");
							}
						}
						catch (Exception e) 
						{
							System.out.println(e);
						}
						break;
					}//case 9
					
					case 10:
					{
						try 
						{
							System.out.println("Search By Username order ");
							System.out.println("Enter username");
							username=sc.next();
							
							orderList=odi.getOrderByUsername(username);
							
							if(orderList.isEmpty())
							{
								System.out.println("empty");
							}
							else
							{
								for(Order o3: orderList)
								{
									System.out.println(o3);
								}
							}
							
						} 
						catch (Exception e)
						{
							e.printStackTrace();
						}
						
						
						break;
					}
						
					}
					
			}while(choice>0);
				
			}//if status
			
		}

	}	
		
	}

