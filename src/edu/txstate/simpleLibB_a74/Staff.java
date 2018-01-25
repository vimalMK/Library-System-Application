package edu.txstate.simpleLibB_a74;

import java.util.Scanner;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Bernadette
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class Staff extends User {
	static Scanner reader = new Scanner(System.in);
	/**
	 * Gives the staff options.
	 * <p>
	 * The staff can select to login as a admin, librarian, or go back. If the staff selects admin
	 * then they must enter the password, "Admin", to access the admin options. If they enter it
	 * right, then they can select to add a user, remove a user, display list of users, or go back.
	 * If the staff selects librarian, they must enter the password "Librarian". If they enter it
	 * right, then they can select to add a document, remove a document, display documents,
	 * or go back. If staff fails to enter the right password they are given the option to be given
	 * a hint, enter password again, or exit login. If the staff fails to input a option listed, then
	 * they are informed and the loop iterates again.
	 * @param user the user
	 * @param document the document
	 */
	public void staffOptions(User user, Document document){
		int optionStaff = 0, optionAd = 0, optionLib = 0;	// User options
		String password = null;	// Password inputed
		do{
			System.out.println("\nStaff Menu: \n[1] Admin \n[2] Librarian\n[3] Back");
			optionStaff = Library.getInteger();	// Exception ensures input is int
			
				if(optionStaff == 1){ 	// Admin login
					boolean cancelLoop = false;
					
					reader.nextLine(); // Clear
					System.out.println("\n--- Admin Login ---\nEnter Password:");
					password = reader.nextLine();
					
					while (!password.equals("Admin") && cancelLoop == false){	// Password invalid
						System.out.println("\n--- Wrong Admin Password ---\n[1] Hint \n[2] Re-Enter Password \n[3] Cancel Login");
						optionAd = Library.getInteger();
						
						if(optionAd == 1){		// Sends a hint
							System.out.println("\nHint: Admin...");
						}
						else if(optionAd == 2){
							reader.nextLine(); // Clear
							System.out.println("\nRe-Enter Password:");
							password = reader.nextLine();	
						}					// Re-Enter password
						else if(optionAd == 3){
							cancelLoop = true;
						}
					}
					
					while (optionAd != 4 && cancelLoop == false){	// Not back and not exit
						System.out.println("\nAdmin Menu: \n[1] Add User \n[2] Remove User \n[3] List of Users \n[4] Back");
						optionAd = Library.getInteger();	
						if(optionAd == 1){	// Add User
							user.addUser();
						}
						else if(optionAd == 2){	// Remove User
							user.removeUser();
						}
						else if(optionAd == 3){	// Display list of Users
							user.displayUser();
						}
						else if(optionAd == 4){	// Do nothing & Back
						}
						else{	// Option inputed Not listed
							System.out.println("\nInput Option not Listed");
						}
					}
				}
				else if(optionStaff == 2){ 	// Librarian Login
					boolean cancelLoop = false;
					
					reader.nextLine(); 	// Clear
					System.out.println("\n--- Librarian Login ---\nEnter Password:");
					password = reader.nextLine();
					while (!password.equals("Librarian") && cancelLoop == false){
						System.out.println("\n--- Wrong Librarian Password ---\n" 
											+ "[1] Hint \n[2] Re-Enter Password \n"
											+ "[3] Cancel Login");
						optionLib = Library.getInteger();
						if(optionLib == 1){	// Display Hint
							System.out.println("\nHint: Librarian...");
						}
						else if(optionLib == 2){	// Re-Enter Password
							reader.nextLine(); // Clear
							System.out.println("\nRe-Enter Password:");
							password = reader.nextLine();	
						}
						else if(optionLib == 3){	// Exit Login
							cancelLoop = true;
						}
					}
					
					while (optionLib != 4 && cancelLoop == false){	//Librarian menu
						System.out.println("\n--- Librarian Menu: ---\n[1] Add document \n[2] Remove document \n[3] List of Documents \n[4] Back");
						optionLib = Library.getInteger();
						if(optionLib == 1){		// Add document
							document.addDocument();
						}						// Remove document
						else if(optionLib == 2){
							document.removeDocument();
						}						// List documents
						else if(optionLib == 3){
							document.displayDocuments();
						}						// Do nothing & Back
						else if(optionLib == 4){	
						}
						else{	
							System.out.println("\nInput Not Listed\n");
						}
					}
				}
				else if(optionStaff == 3){ // Do nothing and exit menu
				}
				else{
					System.out.println("\nInput Not Listed\n");
				}
		}while (optionStaff != 3); 
	}
	
	

}