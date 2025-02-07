package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Utility.ConnectionProvider;
import dao.UserDAO;
import model.User;

//implementation of the methods from UserDAO interface
	public class UserDAOImpl implements UserDAO{

		Connection con = ConnectionProvider.getConnection();
		@Override
		public boolean saveUser(User u) {
			try {
				PreparedStatement pstmt=con.prepareStatement("insert into Users(bid,bname,username) values(?,?,?)");
			    pstmt.setInt(1, u.getBid());
				pstmt.setString(2, u.getBname());
			    pstmt.setString(3, u.getUsername());
			    pstmt.executeUpdate();
			    return true;
			}
			catch (SQLException e) {
				
				//e.printStackTrace();
				System.out.println("Something Went wrong while inserting User.");
				return false;
			}
		}
		@Override
		public User viewUserById(int id) {
			User user=new User();
			try {
				PreparedStatement pstmt=con.prepareStatement("select * from Users where bid=?");
			    pstmt.setInt(1,id);
				ResultSet rs=pstmt.executeQuery();
				boolean res=rs.next();
				if(res==false)
				{
					System.out.println("NO book or user with this id.");
				    return null;
				}
				else {
					user.setBid(rs.getInt(1));
					user.setBname(rs.getString(2));
					user.setUsername(rs.getString(3));
					return user;
				}
			} catch (SQLException e) {
				
				//e.printStackTrace();
				System.out.println("Something Went wrong while retrieving record.");
				return null;
			}		
		}
		
		@Override
		public List<User> viewAllUsers(){
			
			List<User> ulist=new ArrayList<User>();
			try {
				PreparedStatement pstmt=con.prepareStatement("select * from Users");
			   	ResultSet rs=pstmt.executeQuery();
			  	
				while(rs.next())
				{
				    User view=new User();
					view.setBid(rs.getInt(1));
					view.setBname(rs.getString(2));
					view.setUsername(rs.getString(3));
					ulist.add(view);
				}
				
				if(ulist.isEmpty())
				{
					System.out.println("No book in DB");
					return null;
				}
				
				return ulist;	
				
				
			} catch (SQLException e) {
				
				//e.printStackTrace();
				System.out.println("Something Went wrong while retrieving book username list.");
				return null;
			}		
		}
		
		public boolean updateUser(User u) {
			try {
				PreparedStatement pstmt=con.prepareStatement("update Users set Username=? where bid=?");
			    pstmt.setString(1,u.getUsername() );
			    pstmt.setInt(2, u.getBid());
			    int i=pstmt.executeUpdate();
			    if(i>0)
			      return true;
			    return false;
			} catch (SQLException e) {
				
				//e.printStackTrace();
				System.out.println("Something Went wrong while updating user.");
				return false;
			}
		}
		

		@Override
		public boolean deleteUser(int id) {
			try {
				PreparedStatement pstmt=con.prepareStatement("delete from Users where bid=?");
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

