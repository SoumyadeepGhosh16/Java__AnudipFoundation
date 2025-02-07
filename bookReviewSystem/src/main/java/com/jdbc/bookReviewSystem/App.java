package com.jdbc.bookReviewSystem;

//IOException import for exception handling in main method
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args ) throws NumberFormatException, IOException
    {
        System.out.println( "Hello World!" );
        Menu menu=new Menu();//Menu object
        menu.displayMainMenu();//displayMainMenu() to perform multiple functions throughout the whole program
    }
}
