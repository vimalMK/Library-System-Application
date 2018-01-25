package edu.txstate.simpleLibB_a74;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/** 
 * User super class. Holds variables that make up a user. Contain this list of users and
 * methods to manipulate, display, or verify users from the list. 
 * @author Bernadette Aguirre
 */
public class User {
	public List<User> userList = new ArrayList<User>();
	Scanner adReader = new Scanner(System.in);
	private String name;
	private int id;
	private int amountDoc;
	
	private Set<Document> document;
	private Library library;

	/**
	 * Gets the name of a user.
	 * @return the name
	 */
	public String getName(){
		return name;
	}
	/**
	 * Sets name of a user.
	 * @param name the name
	 */
	public void setName(String name){
		this.name = name;
	}
	/**
	 * Gets the id of a user.
	 * @return the id
	 */
	public int getId(){
		return id;
	}
	/**
	 * Sets the id of a user.
	 * @param id the id
	 */
	public void setId(int id){
		this.id = id;
	}
	/**
	 * Gets the number of documents of a user.
	 * @return the number of documents
	 */
	public int getAmountDoc(){
		return amountDoc;
	}
	/**
	 * Sets the number of documents a user has.
	 * @param amountDoc the number of documents
	 */
	public void setAmountDoc(int amountDoc){
		this.amountDoc = amountDoc;
	}
	/** 
	 * Gets document.
	 *  @return the document
	 */
	public Set<Document> getDocument() {
		return document;
	}

	/** 
	 * Sets document.
	 *  @param document the document to set
	 */
	public void setDocument(Set<Document> document) {
		this.document = document;
	}

	/** 
	 * Gets library.
	 *  @return the library
	 */
	public Library getLibrary() {
		return library;
	}

	/** 
	 * Sets library.
	 * @param library the library to set
	 */
	public void setLibrary(Library library) {
		this.library = library;
	}
	/**
	 * Default constructed of a user.
	 * <p>
	 * Sets name and id to null.
	 */
	public User(){
		name = null;
		id = 0;
	}
	/**
	 * The parameterized constructor of a user
	 * <p>
	 * Sets name given to name, etc.
	 * @param name the name given.
	 * @param id the id given.
	 */
	public User(String name, int id){
		this.name = name;
		this.id = id;
	}
	/**
	 * Adds a user to user system.
	 * <p>
	 * Admin can select to add a student or faculty member and is asked to enter the name and id.
	 * Once that is done, the new student or faculty is added to the list of users.
	 */
	public void addUser(){
		int selection = 0;
		System.out.println("\n--- Choose Type of User ---\n[1] Student \n[2] Faculty \n");
		selection = Library.getInteger();
	
		if(selection == 1){				// Add student user
			Student student = new Student();
			
			adReader.nextLine();
			System.out.println("\nEnter Name To Add: ");
			student.setName(adReader.nextLine());
			
			System.out.println("\nEnter Name To ID: ");
			student.setId(Library.getInteger());	// Exception ensures input is int
			
			student.setAmountDoc(0);				// Default -- set copies to 0
			
			userList.add(student);					// Add student entered to users
		} else if (selection == 2) {	// Add faculty user
			Faculty faculty = new Faculty();
			
			adReader.nextLine();
			System.out.println("\nEnter Name To Add: ");
			faculty.setName(adReader.nextLine());
			
			System.out.println("\nEnter Name To ID: ");
			faculty.setId(Library.getInteger());	// Exception ensures input is int
			
			faculty.setAmountDoc(0);				// Default -- set copies to 0
			
			userList.add(faculty);					// Add faculty entered to users
		}
		
	}
	/**
	 * Removes a user from the system given a target name.
	 * <p>
	 * Method iterates through the list of users to find target and delete it.
	 * If the system fails to find a user with target name, then the admin is informed.
	 * If there are no users in the system, then a message is displayed.
	 */
	public void removeUser(){
		
		if (userList.size() != 0){
			String targetName = null;	// Name to find
			
			adReader.nextLine();		// Clear
			System.out.println("\nEnter Name To Remove: ");
			targetName = adReader.nextLine();

			Iterator<User> it = userList.iterator();
			while (it.hasNext()) {		// Iterate through userList
				User user = it.next();
				if (user.getName().equals(targetName)) {	// If name found
					it.remove();		// Remove User
					System.out.println("\nUser named '" + targetName + "' successfully removed!!\n");
				} else {				// Name entered not found
					System.out.println("\nNo user with that name...\n");
				}
			}
		} else {		// No users in system
			System.out.println("\nNo users to remove... ");
		}
	}

	/**
	 * Allows a user to login and returns whether the login was a success or failure using a boolean.
	 * <p>
	 * Iterates through the list of users to find target name and id. If not found, then the user is
	 * informed of invalid login. If there are no users in the system, then the user is informed.
	 * @return
	 */
	public Boolean userLogin() {
		boolean status = false;
		if (userList.size() != 0){
			String targetName = null;	// Name to find
			int targetID = 0;			// Id to find
			
			adReader.nextLine();		// Clear 
			System.out.println("\nEnter Name:");
			targetName = adReader.next();
			
			System.out.println("\nEnter ID:");
			targetID = Library.getInteger(); 	// Exception ensures input is int

			Iterator<User> it = userList.iterator();
			while (it.hasNext()) {		// Iterate through userList
				User u = it.next();
				if (u.getName().equals(targetName) && u.getId() == targetID) {
					status = true;		// Name and ID is valid
				} else {				// Name and ID not in system
					System.out.println("\nInvalid Login...\nNote: Caps Sensitive");
				}
			}
		} else {	// No users in system
			System.out.println("\nNo Users in System...");
		}
		return status;
	}
	/**
	 * Displays all the users in the system.
	 * <p>
	 * Iterates through a list of users in the systems to display all to console.
	 * If there are none, the admin is informed.
	 */
	public void displayUser(){	
		StringBuilder builder = new StringBuilder();	// Builds so no "[ .. ],.."
		for (User value : userList) {	// For every user in userList
		    builder.append(value);		// Add to builder
		}
		String text = builder.toString();	
		System.out.println(text);		// Output list of all users
	}
	
	/** 
	 * Allows the user to borrow a document.
	 * <p>
	 * User enters id. If they have max documents allowed, then they cannot borrow. If they do not
	 * then they can enter the name of document to borrow and the system is sent to remove a copy
	 * from the selected title in the method "removeCopies()" in document class.
	 */
	public void borrowDocument(User user, Document document) {
		boolean status = false; // If user has less than 6 documents then status is true
		int userID = 0; 		// User ID for checkout
		String targetTitle = null; // The title to borrow
		
		System.out.println("\nEnter ID: ");
		userID = Library.getInteger();
		
		Iterator<User> it = userList.iterator();
		while (it.hasNext()) {
			User u = it.next();
			if (u.getId() == userID) {
				if(u.getAmountDoc() < 6){	//Inventory is not full
					status = true;
				} else {
					System.out.println("\nInventory is Full...\nPlease Return A Document to Borrow");
				}
			} else {
				System.out.println("\nInvalid ID...");
			}
		}
		if (status == true)	{	// User can borrow
			adReader.nextLine();
			System.out.println("\nEnter Title of Document to Borrow:");
			targetTitle = adReader.nextLine();
			document.removeCopies(user, document, targetTitle);
		}
	}

	/** 
	 * Allows the user to return a document.
	 * <p>
	 * User enters id. If they don't have any documents in amountDoc then they cannot return anything. 
	 * If they do have documents, then they can enter the name of document to return and the system 
	 * is sent to add a copy from the selected title in the method "addCopies()" in document class.
	 */
	public void returnDocument(User user, Document document) {
		boolean status = false;		// If inventory is not empty then student can return book
		int userID = 0; 			// User ID for checkout
		String targetTitle = null;	 // The title to borrow
		
		System.out.println("\nRe-Enter ID: ");
		userID = Library.getInteger();
		
		Iterator<User> it = userList.iterator();
		while (it.hasNext()) {
			User u = it.next();
			if (u.getId() == userID) {
				if(u.getAmountDoc() > 0){
					status = true;	// Inventory is not empty 
				} else {
					System.out.println("\nYou have no books to return...");
				}
			} else {
				System.out.println("\nInvalid ID...");
			}
		}
		if(status == true){			// User can return
			adReader.nextLine(); 
			System.out.println("\nEnter Title of Document to Return:");
			targetTitle = adReader.nextLine();
			document.addCopies(user, document, targetTitle);
		}
	}

	/** 
	 * Displays the user menu where the user can select to search, borrow, return a document
	 * ot go back. Each document manipulative option is sent to the appropriate method in the
	 * document class. (Example: searchDocument, borrowDocument, etc)
	 */
	
	public void userMenu(User user, Document document){
		int option = 0;			// User input of 
		
		do{
		System.out.println("\n--- User Menu ---" 
							+ "\n[1] Search Document \n[2] Borrow Document \n[3] Return Document"
							+ "\n[4] Back");
				option = Library.getInteger(); 	// Exception ensures input is int
				
				if(option == 1){					// Search Doc
					document.searchDocument();
				} else if (option == 2){			// Borrow Doc
					borrowDocument(user, document);
				} else if (option == 3){			// Return Doc
					returnDocument(user, document);
				} else if (option == 4){			// Do nothing & Exit Loop
				} else {
				System.out.println("\nOption Input not Listed\n");
				}
		} while (option != 4);	// While exit is not chosen
	}
	/**
	 * Increments the amount of documents a user holds
	 * <p>
	 * User enters ID and title. If title exists, then amount of documents
	 * the user has is incremented and the system is sent the remove a copy of the document
	 * from the document class. Else, the user is informed the title doesn't exist.
	 */
	public void addToInv(User user, Document document){
		int userID;						// User input ID to find
		
		System.out.println("\nRe-Enter ID For Receipt: ");
		userID = Library.getInteger();	// Exception ensures input is int
		
		Iterator<User> it = userList.iterator();	
		while (it.hasNext()) {			// Iterated through userList
			User u = it.next();			// Next user
			if (u.getId() == userID) {	// If ID is found
					System.out.println("--- User Receipt ---" + 
										"\nYou had " + u.getAmountDoc() 
										+ " documents checked out.");
					u.setAmountDoc(u.getAmountDoc() + 1);
					System.out.println("Now you have " + u.getAmountDoc() 
										+ " documents checked out.");
			} else {	// ID entered not in system
				System.out.println("\nInvalid ID...");	
			}
		}
	}
	/**
	 * Decrements the amount of documents a user holds
	 * <p>
	 * User enters ID and title. If title exists, then amount of documents
	 * the user has is decremented and the system is sent the add a copy of the document
	 * from the document class. Else, the user is informed the title doesn't exist.
	 */
	public void removeFromInv(User user, Document document){
		int userID;						// User input ID to find
		
		System.out.println("\nRe-Enter ID For Receipt: ");
		userID = Library.getInteger();	// Exception ensures input is int
		
		Iterator<User> it = userList.iterator();
		while (it.hasNext()) {			// Iterated through userList
			User u = it.next();			// Next user
			if (u.getId() == userID) {	// If ID is found
				if(u.getAmountDoc() != 0){
					System.out.println("--- User Receipt ---" + 
										"\nYou had " + u.getAmountDoc() + " documents checked out.");
					u.setAmountDoc(u.getAmountDoc() - 1);
					System.out.println("Now you have " + u.getAmountDoc() + " documents checked out.");
				} else {				// User has no document in inventory
					System.out.println("\nSystem Error: You have no books to remove...");
				}
			} else {	// ID entered not in system
				System.out.println("\nInvalid ID...");
			}
		}
	}
	/**
	 * 
	 */
	@Override
	public String toString(){
		String total = "\n";
		for(int i = 0; i<userList.size(); i++){
			User u = userList.get(i);
			total = total + u;
		}
		return total;
		
	}
	
}
