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
import in.coder.bookstore.pojo.Order;

public class BookStoreTest
{
	public static void main(String[] args) throws IOException, SQLException 
	{
		Cart c=new Cart();
		String username;
		List<Cart> cartList;
		CartDaoImpl cdi=new CartDaoImpl();
		
		
		Scanner sc=new Scanner(System.in);
		
		OrderDaoImpl odi=new OrderDaoImpl();
		Order o=new Order();
		List<Order> orderList;
		
		
		LoginDao log=new LoginDaoImpl();
		
		
		
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br= new BufferedReader(isr);
		
		Book b=new Book();
		BookDaoImpl bdi=new BookDaoImpl();
		List<Book> bookList;
		
		int choice;
		boolean status=false;
		
		String bookName,bookCategory,description, authorNm,publisher; 
		double price; 
		int quantity,bookid;
		
		System.out.println("Enter Usertype(a)admin/customer");
		String usertype=br.readLine();
		
		System.out.println("Enter username");
		username=br.readLine();
		
		System.out.println("Enter password");
		String password=br.readLine();
		
		status=log.login(username,password,usertype);
		if(status==true)
		{
			System.out.println("Successfull");
		}
		else
		{
			System.out.println("Invalid Credentialss");
		}
		
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
		
		
		System.out.println("1.Insert Book");
		System.out.println();
		System.out.println("2.Display Book \n");
		System.out.println("3.Update Book \n");
		System.out.println("4.Delete Book\n ");
		System.out.println();
		System.out.println("Searching operation...............");
		System.out.println("5. Search_By_Name");
		System.out.println("6. Search by Author  Name");
		System.out.println("7. Search by Publisher");
		System.out.println("8. Search by Category");
		System.out.println("9. Add to Cart");
		System.out.println("10. Get Cart");
		System.out.println("11. Delete Cart");
		System.out.println("12. Place order");
		System.out.println("13. Get All Placed Orders");
		System.out.println("14.Get all Placed Orders By Using USERNAME");
		
		
		
		
		System.out.println("Enter choice");
		choice=sc.nextInt();
		switch(choice)
		{
		case 1:
			System.out.println("Inserting book");
			
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
			
		case 2:
			System.out.println("All Books");
			bookList=bdi.getAllBooks();
			for(Book b2:bookList)
			{
				System.out.println(b2);
			}
			break;
			
			
		case 3:
		
			try
			{
				System.out.println("Updating Book");
				
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
		
		case 4:
			try
			{
				System.out.println("Enter existinh book id");
				bookid=sc.nextInt();
				b.setBookid(bookid);
				
				status=bdi.deleteBook(bookid);
				if(status==true)
				{
					System.out.println("Book deleted successfully");
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
		
		case 5:
		{
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
		}
		
		case 6:
		{
			try
			{
				System.out.println("Search Book by Author Name ");
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
		}
		
		case 7:
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
		}
		
		case 8:
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
		}
		case 9:
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
			
		}
		case 10:
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
		case 11:
		{
			try
			{
				System.out.println("Deleting cart");
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
			
		}
		case 12:
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
		
		case 13:
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
		case 14:
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
			}
			
			break;
		}
		
			
		default:
			System.out.println("wrong choice");
			
	}
}
}



