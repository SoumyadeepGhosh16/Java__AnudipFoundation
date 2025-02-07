package dao;

import java.util.List;
import model.User;//import the data members of the user model

//interface where we create necessary methods and the implementation are to be dome inn respective DAOimpl class
public interface UserDAO {

	boolean saveUser(User b);
	User viewUserById(int id);
	List<User> viewAllUsers();
	boolean updateUser(User b);
	boolean deleteUser(int id);
	
}
