package dao;

import java.util.List;
import model.Review;//import the data members of the review model

//interface where we create necessary methods and the implementation are to be dome inn respective DAOimpl class
public interface ReviewDAO {
	
	boolean saveReview(Review r);
	Review viewReview(int id);
	List<Review> viewAllReview();
	
}
