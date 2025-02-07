package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import dao.BookDAO;
import model.Book;
import Utility.ConnectionProvider;

//implementation of the methods from BookDAO interface
public class BookDAOImpl implements BookDAO{

	Connection con=ConnectionProvider.getConnection();
	@Override
	public boolean saveBook(Book b) {
		try {
			PreparedStatement pstmt=con.prepareStatement("insert into Book(bid,bname,price,publisher) values(?,?,?,?)");
		    pstmt.setInt(1, b.getBid());
			pstmt.setString(2, b.getBname());
		    pstmt.setInt(3, b.getPrice());
		    pstmt.setString(4, b.getPublisher());
		    pstmt.executeUpdate();
		    return true;
		}
		catch (SQLException e) {
			
			//e.printStackTrace();
			System.out.println("Something Went wrong while inserting record.");
			return false;
		}		
	}
	
	
	@Override
	public Book viewBookById(int id) {
		Book book=new Book();
		try {
			PreparedStatement pstmt=con.prepareStatement("select * from book where bid=?");
		    pstmt.setInt(1,id);
			ResultSet rs=pstmt.executeQuery();
			boolean res=rs.next();
			if(res==false)
			{
				System.out.println("NO book with this id.");
			    return null;
			}
			else {
				book.setBid(rs.getInt(1));
				book.setBname(rs.getString(2));
				book.setPrice(rs.getInt(3));
				book.setPublisher(rs.getString(4));
				return book;
			}
		} catch (SQLException e) {
			
			//e.printStackTrace();
			System.out.println("Something Went wrong while retrieving record.");
			return null;
		}		
	}
	
	
	@Override
	public List<Book> viewAllBooks() {
		
		List<Book> blist=new ArrayList<Book>();
		try {
			PreparedStatement pstmt=con.prepareStatement("select * from book");
		   	ResultSet rs=pstmt.executeQuery();
		  	
			while(rs.next())
			{
			    Book book=new Book();
				book.setBid(rs.getInt(1));
				book.setBname(rs.getString(2));
				book.setPrice(rs.getInt(3));
				book.setPublisher(rs.getString(4));
				blist.add(book);
			}
			
			if(blist.isEmpty())
			{
				System.out.println("No book in DB");
				return null;
			}
			
			return blist;	
			
			
		} catch (SQLException e) {
			
			//e.printStackTrace();
			System.out.println("Something Went wrong while retrieving book list.");
			return null;
		}		
	}

	
	@Override
	public boolean updateBook(Book b) {
		try {
			PreparedStatement pstmt=con.prepareStatement("update book set bname=?,price=?,publisher=? where bid=?");
		    pstmt.setString(1,b.getBname() );
			pstmt.setInt(2, b.getPrice());
		    pstmt.setString(3, b.getPublisher());
		    pstmt.setInt(4, b.getBid());
		    int i=pstmt.executeUpdate();
		    if(i>0)
		      return true;
		    return false;
		} catch (SQLException e) {
			
			//e.printStackTrace();
			System.out.println("Something Went wrong while updating book.");
			return false;
		}
	}
	

	@Override
	public boolean deleteBook(int id) {
		try {
			PreparedStatement pstmt=con.prepareStatement("delete from book where bid=?");
		    pstmt.setInt(1,id);
		    int i=pstmt.executeUpdate();
		    if(i>0)
		    	return true;
		    return false;
		}
		catch(SQLException e) {
			System.out.println("Something Went wrong while deleting the book.");
			return false;
		}		
	}


}
