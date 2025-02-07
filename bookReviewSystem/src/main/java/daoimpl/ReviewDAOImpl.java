package daoimpl;

import dao.ReviewDAO;
import model.Review;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Utility.ConnectionProvider;

//implementation of the methods from ReviewDAO interface
public class ReviewDAOImpl implements ReviewDAO{

	Connection con = ConnectionProvider.getConnection();
	@Override
	public boolean saveReview(Review r) {
		try {
			PreparedStatement pstmt=con.prepareStatement("insert into Review(bid,bname,remarks,rating) values(?,?,?,?)");
		    pstmt.setInt(1, r.getBid());
			pstmt.setString(2, r.getBname());
		    pstmt.setString(3, r.getRemarks());
		    pstmt.setInt(4, r.getRating());
		    pstmt.executeUpdate();
		    return true;
		}
		catch (SQLException e) {
			
			//e.printStackTrace();
			System.out.println("Something Went wrong while inserting review.");
			return false;
		}
	}
	@Override
	public Review viewReview(int id) {
		Review review=new Review();
		try {
			PreparedStatement pstmt=con.prepareStatement("select * from Review where bid=?");
		    pstmt.setInt(1,id);
			ResultSet rs=pstmt.executeQuery();
			boolean res=rs.next();
			if(res==false)
			{
				System.out.println("NO book with this id.");
			    return null;
			}
			else {
				review.setBid(rs.getInt(1));
				review.setBname(rs.getString(2));
				review.setRemarks(rs.getString(3));
				review.setRating(rs.getInt(4));
				return review;
			}
		} catch (SQLException e) {
			
			//e.printStackTrace();
			System.out.println("Something Went wrong while retrieving record.");
			return null;
		}		
	}
	@Override
	public List<Review> viewAllReview(){
		
		List<Review> rlist=new ArrayList<Review>();
		try {
			PreparedStatement pstmt=con.prepareStatement("select * from Review");
		   	ResultSet rs=pstmt.executeQuery();
		  	
			while(rs.next())
			{
			    Review view=new Review();
				view.setBid(rs.getInt(1));
				view.setBname(rs.getString(2));
				view.setRemarks(rs.getString(3));
				view.setRating(rs.getInt(4));
				rlist.add(view);
			}
			
			if(rlist.isEmpty())
			{
				System.out.println("No book in DB");
				return null;
			}
			
			return rlist;	
			
			
		} catch (SQLException e) {
			
			//e.printStackTrace();
			System.out.println("Something Went wrong while retrieving book review list.");
			return null;
		}		
	}
}
