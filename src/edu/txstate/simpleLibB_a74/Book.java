package edu.txstate.simpleLibB_a74;

import java.io.Serializable;
/**
 * Book class extends document class. Contains the variables that make up a book.
 * Holds getters and setters of these variables. Has constructors and a toString.
 * @author Bernadette Aguirre
 */
public class Book extends Document implements Serializable {
	private String date;
	private int isbn;
	
	/** 
	 * Gets the date.
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	/** 
	 * Sets the date.
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/** 
	 * Gets the isbn.
	 *  @return the isbn
	 */
	public int getIsbn() {
		return isbn;
	}
	/** 
	 * Sets the isbn
	 *  @param isbn the isbn to set
	 */
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	
	/**
	 * Default constructor of a book.
	 * <p>
	 * Sets date and isbn to zero.
	 */
	public Book(){
		date = null;
		isbn = 0;
	}

	/**
	 * Parameterized constructor of a book.
	 * <p>
	 * Sets this date to the date given and this isbn to the isbn given.
	 */
	public Book(String date, int isbn) {
		this.date = date;
		this.isbn = isbn;
	}
	
	/**
	 * 
	 */
	public String toString(){
		return  "\nTitle: " + getTitle() + "\t\tPublisher: " +  getPublisher() +  "\t\tDate: " 
				+ date + "\t\tISBN: " + isbn + "\t\tCopies: " +  getCopies() + "\tAuthor: " 
				+ getAuthor() + "\t\tType: Book";
	}
}
