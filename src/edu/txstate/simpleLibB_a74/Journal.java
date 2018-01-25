package edu.txstate.simpleLibB_a74;

import java.io.Serializable;

/**
 * Journal class extends document class. Contains the variables that make up a journal.
 * Holds getters and setters of these variables. Has constructors and a toString.
 * @author Bernadette Aguirre
 */
public class Journal extends Document implements Serializable {
	public String publisherDate;
	public int isbn;
	public Integer volume;
	public Integer issue;

	/** 
	 * Gets a publisher date
	 * @return the publisher date
	 */
	public String getPublisherDate() {
		return publisherDate;
	}

	/** 
	 * Sets a publisher date
	 * @param publisherDate the publisher date
	 */
	public void setPublisherDate(String publisherDate) {
		this.publisherDate = publisherDate;
	}
	/**
	 * Gets the isbn.
	 * @return the isbn
	 */
	public int getIsbn(){
		return isbn;
	}
	/**
	 * Sets the isbn.
	 * @param isbn the isbn
	 */
	public void setIsbn(int isbn){
		this.isbn = isbn;
	}
	/** 
	 * Gets the volume number.
	 */
	public Integer getVolume() {
		return volume;
	}

	/** 
	 * Sets the volume number.
	 */
	public void setVolume(Integer volume) {
		this.volume = volume;
	}

	/** 
	 * Gets the issue number.
	 */
	public Integer getIssue() {
		return issue;
	}

	/** 
	 * Sets the issue number.
	 */
	public void setIssue(Integer issue) {
		this.issue = issue;
	}
	
	/**
	 * Default constructor for a journal.
	 */
	public Journal(){
		publisherDate = null;
		isbn = 0;
		volume = 0;
		issue = 0;
	}
	/**
	 * Parameterized constructor for a journal.
	 * @param publisherDate the publisher date
	 * @param isbn the isbn number
	 * @param volume the volume number
	 * @param issue the issue number
	 */
	public Journal(String publisherDate, int isbn, int volume, int issue) {
		this.publisherDate = publisherDate;
		this.isbn = isbn;
		this.volume = volume;
		this.issue = issue;
	}
	
	/**
	 *
	 */
	public String toString(){
		return "\nTitle: " + getTitle() + "\t\tPublisher: " + getPublisher() + "\t\tDate: " +  publisherDate 
				+ "\t\tISBN: " +  isbn + "\t\tVolume: " +  volume + "\tIssue: " +  issue + "\tAuthor: " 
				+ getAuthor() + "\tCopies: " +   getCopies() + "\t\tType: Journal";
	}
}