package dao;

import java.util.List;
import model.Book;//import the data members of the book model

//interface where we create necessary methods and the implementation are to be dome inn respective DAOimpl class
public interface BookDAO {

	boolean saveBook(Book b);
	Book viewBookById(int id);
	List<Book> viewAllBooks();
	boolean updateBook(Book b);
	boolean deleteBook(int id);
	
}
