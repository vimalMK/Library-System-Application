package edu.txstate.simpleLibB_a74;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Iterator;
import java.io.Serializable;

/** 
 * Document super class. Holds variables that make up a document. Contain this list of documents and
 * methods to manipulate, display, or verify document from the list. 
 * @author Bernadette Aguirre
 */
public class Document implements Serializable {
	Scanner libReader = new Scanner(System.in);
	public List<Document> documentList = new ArrayList<Document>();
	
	private String title;
	private String publisher;
	private String author;
	private int copies;
	
	public Library library = new Library();
	private User user;
	private Library lib;
	/**
	 *  Gets the title of a document.
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/** 
	 * Set the title of a document. 
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/** 
	 * Get the publisher of a document.
	 * @return the publisher
	 */
	public String getPublisher() {
		return publisher;
	}
	/** 
	 * Sets the publisher of a document.
	 * @param publisher the publisher to set
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	/** 
	 * Gets the author of a document.
	 * @return the author
	 */
	public String getAuthor(){
		return author;
	}
	/**
	 * Sets the author of a document.
	 * @param author the author to set
	 */
	public void setAuthor(String author){
		this.author = author;
	}
	/** 
	 * Gets the amount of copies available for a document.
	 * @return the number of copies
	 */
	public int getCopies(){
		return copies;
	}
	/** 
	 * Sets the amount of copies available for a document
	 * @param copies the number of copies to set
	 */
	public void setCopies(int copies){
		this.copies = copies;
	}
	
	/** 
	 * Gets the user
	 *  @return the user 
	 */
	public User getUser() {
		return user;
	}

	/** 
	 * Sets the user
	 *  @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/** 
	 * Gets the library 
	 * @return the library
	 */
	public Library getLib() {
		return lib;
	}

	/** 
	 * Sets the library
	 * @param library the library to set
	 */
	public void setLib(Library lib) {
		this.lib = lib;
	}
	/** 
	 * Default constructor for a document. Initializes title and publisher to a null string.
	 */
	public Document(){
		title = null;
		publisher = null;
	}
	/**
	 * Parameterized constructor for a document. Sets this publisher to publisher taken
	 * and sets this title to the title taken.
	 * @param title the title taken
	 * @param publisher the publisher taken
	 */
	public Document(String title, String publisher){
		this.publisher = publisher;
		this.title = title;
	}
	/**
	 * Adds a document to the document list.
	 * <p>
	 * First, the User is prompted to choose whether
	 * they want to add a book, journal, or go back. If the user wants to add a book or journal, 
	 * then a new book or journal variable is generated. The system then asks the user for various 
	 * inputs that is required for the book or journals. (Example: Title, publisher, date...) After
	 * all variables are set the the new book or journal, then the new book or journal is added
	 * to the documents list. Else if the user selected to go back, then the system does nothing and
	 * exits the method. Else the user failed to input a option number from 1 to 3, and a message
	 * is displayed saying the user failed to select a listed option. All of this is nested in a
	 * while loop to ensure the menu is not exited unless the user requested to go back.
	 */
	public void addDocument(){
		int selection = 0;	// Input of users choice
		
		while(selection != 3){
			System.out.println("\nSelect Document Type To Add: \n[1] Book \n[2] Journal\n[3] Back");
			selection = Library.getInteger();	// Exception ensures input is int
			if(selection == 1){ 		// Add book
				Book book = new Book();	
				// Input of book information to add
				libReader.nextLine(); 	// Clear
				System.out.println("\nEnter Title: ");
				book.setTitle(libReader.nextLine());
				
				System.out.println("Enter Publisher: ");
				book.setPublisher(libReader.nextLine());
				
				System.out.println("Enter Date: (DD/MM/YY) ");
				book.setDate(libReader.nextLine());
				
				System.out.println("Enter ISBN: ");
				book.setIsbn(Library.getInteger());
				
				libReader.nextLine(); 	// Clear
				System.out.println("Enter Author: ");
				book.setAuthor(libReader.nextLine());
				
				book.setCopies(1);	// Default -- copies of new = 1
				
				documentList.add(book); // Add book created to list							
			}
			else if(selection == 2){
				Journal journal = new Journal();
				// Input of journal information to add
				libReader.nextLine();
				System.out.println("\nEnter Title: ");
				journal.setTitle(libReader.nextLine());
				
				System.out.println("\nEnter Publisher: ");
				journal.setPublisher(libReader.nextLine());
				
				System.out.println("\nEnter Publisher Date: (DD/MM/YY) ");
				journal.setPublisherDate(libReader.nextLine());
				
				System.out.println("\nEnter Volume: ");
				journal.setVolume(Library.getInteger());
				
				libReader.nextLine(); 	// Clear
				System.out.println("\nEnter Author: ");
				journal.setAuthor(libReader.nextLine());
	
				journal.setCopies(1);	// Default -- copies of new = 1
				
				documentList.add(journal);	// Add journal created to list
			}
			else if(selection == 3){	// Do nothing & Exit
			}
			else{	// Option selected is not on menu
				System.out.println("\nOption Input not Listed");
			}
		}
	}
	/**
	 * Removes a document to the document list.
	 * <p>
	 * If there are documents in the document list. If there are documents, then the system then asks 
	 * the title of the document that is to be deleted. Once the target title is entered, the method 
	 * iterates through the list of documents. If it finds a title that equals the target title, then the 
	 * method removes the document completely and prints a success message. If it does not find a document with the 
	 * target title, then it informs the user that there is not a document in the system with that title.
	 * Else there are no documents in the document list, and the system informs the user.
	 */
	public void removeDocument(){
		if (documentList.size() != 0){
			String targetTitle = null;	// Title to find
			
			libReader.nextLine();		// Clear
			System.out.println("\nEnter Title To Remove: ");
			targetTitle = libReader.nextLine();

			Iterator<Document> it = documentList.iterator();
			while (it.hasNext()) {		// Iterate through documents
				Document doc = it.next();
				if (doc.getTitle().equals(targetTitle)) {	// Document found
					it.remove();
					System.out.println("\nDocument titled '" + targetTitle + "' successfully removed!!\n");
				} else {				// Document not found
					System.out.println("\nNo document with that name...\n");
				}
			}
		} else {			// No documents in system
			System.out.println("\nNo documents to remove... ");
		}
		
	}
	/**
	 * This method searches for a document given a title and author. 
	 * <p>
	 * First the system prints out
	 * the option to search by title, author, or quit search. If the user selects to search by
	 * title or author, then the method iterates through the list of documents to find the target
	 * if the method finds a document with a matching title or author, then the system prints
	 * out the documents information. Else if it does not find a document with the given title or author
	 * then it informs the user there is no such document. If there are no documents in the list
	 * then the system informs the user there are no documents to search through. If the user
	 * selects to quit the search then the loop is exited. And, lastly, if the input isn't listed
	 * the system informs the user and the loop is iterated again to search by title, author, or quit.
	 */
	public void searchDocument(){
		String targetTitle = null, targetAuthor = null;	// To find
		int option = 0;			// Input option selected by user
		while(option != 3){
			if (documentList.size() != 0){
				System.out.println("\n--- Search by ---\n[1] Title\n[2] Author\n[3] Quit Search");
				option = Library.getInteger();	// Exception ensures input is int
					if(option == 1){			// Search by Title
						libReader.nextLine();	// Clear
						System.out.println("\nEnter Title To Search: ");
						targetTitle = libReader.nextLine();
			
						Iterator<Document> it = documentList.iterator();
						while (it.hasNext()) {	// Iterate through documents
							Document doc = it.next();
							if (doc.getTitle().equals(targetTitle)) {	// Title Found
								System.out.println(doc.toString());
							} else {			// Title not found
								System.out.println("\nDocument not found with title " + targetTitle + "..." );
							}
						}
						
					} else if (option == 2){ 	// Search by Author
						libReader.nextLine();
						System.out.println("\nEnter Title To Search: ");
						targetAuthor = libReader.nextLine();
			
						Iterator<Document> it = documentList.iterator();
						while (it.hasNext()) {	// Iterate through documents
							Document doc = it.next();
							if (doc.getAuthor().equals(targetAuthor)) {	// Author found
								System.out.println(doc.toString());
							} else {			// Author not found
								System.out.println("\nDocument not found with title " + targetAuthor+ "..." );
							}
						}
					} else if (option == 3){ // Do nothing and exit
					} else {	// Option that is inputed is not listed
						System.out.println("\nOption Input Not Listed");
					}
					
			} else {	// Document list size is 0 -- no documents
				System.out.println("\nNo documents to search... ");
			}
		}
	}
	/**
	 * This method displays all documents in a list using a string builder.
	 * <p>
	 * If there are no documents in the system, then the system informs user.
	 */
	public void displayDocuments(){
		if(documentList.size() != 0){
			StringBuilder builder = new StringBuilder();	// String Builder
			for (Document value : documentList) {	// For each document
			    builder.append(value);			// Add document to builder
			}
			String text = builder.toString();	
			System.out.println(text);	// Prints out list
		} else {
			System.out.println("There are no documents in system yet...");
		}
	}
	/**
	 * This method increments a copy to the desired document.
	 * <p>
	 * Using the target
	 * title, it iterates through the list of documents. If it is found, then it's copies
	 * is incremented and the system informs the user. If it is not found, then the system
	 * informs the user there is no such document with target title. If there is no documents
	 * in the system, then the system informs the user.
	 * @param user the user 
	 * @param document the document
	 * @param targetTitle the target title
	 */
	public void addCopies(User user, Document document, String targetTitle){
		Iterator<Document> it = documentList.iterator();
		while (it.hasNext()) {	// Iterate through documents
			Document doc = it.next();	
			if (doc.getTitle().equals(targetTitle)) {	// If title is found
				System.out.println("\n--- System Notification ---" +
									"\nCopies of " + targetTitle + " was " + doc.getCopies() + ".");
				doc.setCopies(doc.getCopies() + 1);		// Add a copy back
				System.out.println("Copies of " + targetTitle + " is now " + doc.getCopies() + ".");
				user.removeFromInv(user, document);		// Decrement user #items
			} else {	// No document with title
				System.out.println("\nDocument not found with title " + targetTitle + "..." );
			}
		}
	}
	/**
	 * This method decrements a copy to the desired document. 
	 * <p>
	 * Using the target
	 * title, it iterates through the list of documents. If it is found, then it's copies
	 * is decremented and the system informs the user. If it is not found, then the system
	 * informs the user there is no such document with target title. If there is no documents
	 * in the system, then the system informs the user.
	 * @param user the user 
	 * @param document the document
	 * @param targetTitle the target title
	 */
	public void removeCopies(User user, Document document, String targetTitle){
		Iterator<Document> it = documentList.iterator();
		while (it.hasNext()) {	// Iterate through documents
			Document doc = it.next();
			if (doc.getTitle().equals(targetTitle)) {	// If title found
				if(doc.getCopies() > 0){			// And there are copies available 
					System.out.println("\n--- System Notification ---" +
										"\nCopies of " + targetTitle + " in library was " + doc.getCopies() + ".");
					doc.setCopies(doc.getCopies() - 1);	// Remove a copy from library
					System.out.println("Copies of " + targetTitle + " in library is now " + doc.getCopies() + ".");
					user.addToInv(user, document);		// Increment user #item
				} else {	// Document of title has no copies
					System.out.println("\nNo copies avaiable... \n" 
										+ targetTitle + " has " + doc.getCopies() + "copies..." );
				}
			} else {		// Document with title is not in documents
				System.out.println("\nDocument not found with title " + targetTitle+ "..." );
			}
		}
	}
	
	
	
	/** 
	 */
		
	@Override
	public String toString(){
		String total = "\n";
		for(int i = 0; i<documentList.size(); i++){
			Document b = documentList.get(i);
			total = total + b;
		}
		return total;
		
	}
}
