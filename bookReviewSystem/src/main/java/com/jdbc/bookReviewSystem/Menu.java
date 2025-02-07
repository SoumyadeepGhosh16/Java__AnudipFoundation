package com.jdbc.bookReviewSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

//Book related variable,interface,method implementation
import daoimpl.BookDAOImpl;
import model.Book;
import dao.BookDAO;

//Review related variable,interface,method implementation
import daoimpl.ReviewDAOImpl;
import model.Review;
import dao.ReviewDAO;

//User related variable,interface,method implementation
import daoimpl.UserDAOImpl;
import model.User;
import dao.UserDAO;


public class Menu {

	void displayMainMenu() throws NumberFormatException, IOException {
		Scanner scan = new Scanner(System.in);
		//functionality based on the choice of the user
		System.out.println("Main Menu :");
		System.out.println("1. Book :");
		System.out.println("2. User :");
		System.out.println("3. Review :");
		System.out.println("9. Exit :");

		System.out.println("Please Enter your Choice :");
		int ch = scan.nextInt();

		switch (ch) {//choice to move through the separate functions
		case 1:
			displayBookMenu();
			break;
		case 2:
			displayUserMenu();
			break;
		case 3:
			displayReviewMenu();
			break;
		case 9:
			System.exit(0);
			break;
		default: {
			System.out.println("Please enter a valid choice :");
			System.out.println("Please Enter your Choice :");
			ch = scan.nextInt();
		}
		}

	}

	//method to perform fuctions related to Review details
	private void displayReviewMenu() throws NumberFormatException,IOException{
		// TODO Auto-generated method stub
		
		ReviewDAO reviewdao = new ReviewDAOImpl();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char choice;
		
		 do {
				System.out.println("Book Review system :");
				System.out.println("1. Enter review :");
				System.out.println("2. View Review :");
				System.out.println("3. View All Review :");
				System.out.println("6. Return to Main Menu   :");

				System.out.println("Please Enter your Choice :");
				int ch = Integer.parseInt(br.readLine());
				
				switch(ch){
					
				//method for entering review of a particular book
					case 1:{
						System.out.println("Enter Book Id :");
						int bid = Integer.parseInt(br.readLine());
						System.out.println("Enter Book Name :");
						String bname = br.readLine();
						System.out.println("Enter remarks");
						String remarks = br.readLine();
						System.out.println("Enter rating :");
						int rating = Integer.parseInt(br.readLine());
						
						Review review = new Review(bid, bname, remarks, rating);

						boolean res = reviewdao.saveReview(review);
						if (res)
							System.out.println("Book review added");
						else
							System.out.println("Somethong went wrong");
						break;
					}
					
					//method to display review of a particular book with its book id
					case 2:{
						System.out.println("Enter Book Id :");
						int bid = Integer.parseInt(br.readLine());
						Review review = reviewdao.viewReview(bid);
						if (review == null) {
							System.out.println("Book review with this id does not exist :");
							break;
						}
						System.out.println(review);
						break;
					}
					
					//show all books and their review
					case 3:{
						List<Review> bookreview = reviewdao.viewAllReview();
						if (bookreview == null) {
							System.out.println("There is no book stored in system :");
							break;
						}
						for (Review r : bookreview) {
							System.out.println(r);
						}
						break;
					}	
					
					//return to main menu
					case 6:{
						displayMainMenu();
						break;
					}
				}
				
				System.out.println("Do you want to continue (y/n):");
			    choice=br.readLine().charAt(0);
		 }while(choice=='y'|| choice=='Y');
	}
	
	//method to perform fuctions related to Book details
	private void displayBookMenu() throws NumberFormatException, IOException {

		BookDAO bookdao = new BookDAOImpl();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char choice;
       do {
		System.out.println("Book Menu :");
		System.out.println("1. Create Book :");
		System.out.println("2. View Book :");
		System.out.println("3. View All Books :");
		System.out.println("4. Update Book :");
		System.out.println("5. Delete Book :");

		System.out.println("6. Return to Main Menu   :");

		System.out.println("Please Enter your Choice :");
		int ch = Integer.parseInt(br.readLine());

		switch (ch) {

		//create book 
		case 1: {

			System.out.println("Enter Book Id :");
			int bid = Integer.parseInt(br.readLine());
			System.out.println("Enter Book Name :");
			String name = br.readLine();
			System.out.println("Enter Price");
			int price = Integer.parseInt(br.readLine());
			System.out.println("Enter publisher :");
			String publisher = br.readLine();

			Book book = new Book(bid, name, price, publisher);

			boolean res = bookdao.saveBook(book);
			if (res)
				System.out.println("Book Created");
			else
				System.out.println("Somethong went wrong");
			break;
		}
		
		//view particular book by its id
		case 2: {
			System.out.println("Enter Book Id :");
			int bid = Integer.parseInt(br.readLine());
			Book book = bookdao.viewBookById(bid);
			if (book == null) {
				System.out.println("Book with this id does not exist :");
				break;
			}
			System.out.println(book);
			break;
		}
		
		//view all books that are entered in the table
		case 3: {
			List<Book> booklist = bookdao.viewAllBooks();
			if (booklist == null) {
				System.out.println("There is no book stored in system :");
				break;
			}
			for (Book b : booklist) {
				System.out.println(b);
			}
			break;
		}

		//update book from the table
		case 4: {
			System.out.println("Enter Book Id :");
			int bid = Integer.parseInt(br.readLine());
			Book book = bookdao.viewBookById(bid);
			if (book == null) {
				System.out.println("Book with this id does not exist :");
				break;
			}
			System.out.println("Enter Book Name :");
			String name = br.readLine();
			System.out.println("Enter Price");
			int price = Integer.parseInt(br.readLine());
			System.out.println("Enter publisher :");
			String publisher = br.readLine();

			book = new Book(bid, name, price, publisher);
			boolean res = bookdao.updateBook(book);
			if (res)
				System.out.println("Book Updated");
			else
				System.out.println("Somethong went wrong");
			break;

		}
		
		//delete book from the table by its id
		case 5: {
			System.out.println("Enter Book Id :");
			int bid = Integer.parseInt(br.readLine());
			Book book = bookdao.viewBookById(bid);
			if (book == null) {
				System.out.println("Book with this id does not exist :");
				break;
			}
			boolean res = bookdao.deleteBook(bid);
			if (res)
				System.out.println("Book Deleted");
			else
				System.out.println("Somethong went wrong");
			break;
		}

		//return to main method menu
		case 6: {
			displayMainMenu();
			break;
		}

		default: {
			System.out.println("Please enter a valid choice :");
			System.out.println("Please Enter your Choice :");
			ch = Integer.parseInt(br.readLine());
		}

		}
		System.out.println("Do you want to continue (y/n):");
	    choice=br.readLine().charAt(0);
       }while(choice=='y'|| choice=='Y');
      
	}

	//method to perform fuctions related to User details
	private void displayUserMenu() throws NumberFormatException,IOException{
		// TODO Auto-generated method stub

		UserDAO userdao = new UserDAOImpl();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char choice;
       do {
		System.out.println("Book-user Menu :");
		System.out.println("1. Create User :");
		System.out.println("2. View User :");
		System.out.println("3. View All Book users :");
		System.out.println("4. Update user :");
		System.out.println("5. Delete user :");

		System.out.println("6. Return to Main Menu   :");

		System.out.println("Please Enter your Choice :");
		int ch = Integer.parseInt(br.readLine());
		
		switch(ch) {
		
		//create user for a a particular book
		case 1:{
			System.out.println("Enter Book Id :");
			int bid = Integer.parseInt(br.readLine());
			System.out.println("Enter Book Name :");
			String bname = br.readLine();
			System.out.println("Enter username");
			String username = br.readLine();

			User user = new User(bid, bname, username);

			boolean res = userdao.saveUser(user);
			if (res)
				System.out.println("Book user added");
			else
				System.out.println("Somethong went wrong");
			break;
		}
		
		//view user by book id
		case 2:{
			System.out.println("Enter Book Id :");
			int bid = Integer.parseInt(br.readLine());
			User user = userdao.viewUserById(bid);
			if (user == null) {
				System.out.println("Book with this id does not exist :");
				break;
			}
			System.out.println(user);
			break;
		}
		
		//view all user of the books
		case 3:{
			List<User> userlist = userdao.viewAllUsers();
			if (userlist == null) {
				System.out.println("There is no book stored in system :");
				break;
			}
			for (User u : userlist) {
				System.out.println(u);
			}
			break;
			
		}
		
		//update user of a book by its id
		case 4:{
			System.out.println("Enter Book Id :");
			int bid = Integer.parseInt(br.readLine());
			User user = userdao.viewUserById(bid);
			if (user == null) {
				System.out.println("Book user with this id does not exist :");
				break;
			}
			System.out.println("Enter Book Name :");
			String bname = br.readLine();
			System.out.println("Enter username");
			String username = br.readLine();

			user = new User(bid, bname, username);
			boolean res = userdao.updateUser(user);
			if (res)
				System.out.println("Book user Updated");
			else
				System.out.println("Somethong went wrong");
			break;

		}
		
		//delete user from book id
		case 5:{
			System.out.println("Enter Book Id :");
			int bid = Integer.parseInt(br.readLine());
			User user = userdao.viewUserById(bid);
			if (user == null) {
				System.out.println("Book user with this id does not exist :");
				break;
			}
			boolean res = userdao.deleteUser(bid);
			if (res)
				System.out.println("User Deleted");
			else
				System.out.println("Somethong went wrong");
			break;
		}
		
		//return to main menu
		case 6: {
			displayMainMenu();
			break;
		}

		default: {
			System.out.println("Please enter a valid choice :");
			System.out.println("Please Enter your Choice :");
			ch = Integer.parseInt(br.readLine());
		    }
		}
		
		System.out.println("Do you want to continue (y/n):");
	    choice=br.readLine().charAt(0);
	    }while(choice=='y' || choice == 'Y');

	}
	
}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	