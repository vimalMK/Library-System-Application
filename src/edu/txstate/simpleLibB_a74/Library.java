package edu.txstate.simpleLibB_a74;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

/** 
 * Library system super class contains the main method and exceptions methods.
 * @author Bernadette Aguirre
 */
public class Library {
	static String fileName = null;
	static Scanner reader = new Scanner(System.in);
	static Document document = new Document();
	static User user = new User();
	static Staff staff = new Staff();

	/** 
	 * Main method of the library. 
	 * <p>
	 * This method asks for file names to import. After doing such, It
	 * welcomes the user to the library. The user is given the option to select who they are. They
	 * can select from student, faculty, and staff. They can also choose to save and quit the program.
	 * For each identity that is selected, this user is sent to their appropriate login. If the user
	 * fails to select a option listed, then the system informs the user and starts the loop over.
	 * Upon exiting, the method saves and quits, and the scanner is closed.
	 * @throws FileNotFoundException 
	 */
	public static void main(String args[]) throws FileNotFoundException {
		int option = 0; 		// Main menu option 
		boolean login = false;	// Indicates if login was successful
		
		Scanner reader = new Scanner(System.in);	// Scanner Declaration
	
		// Body of Main
		System.out.println("--- Welcome To Bernadette's Library2 ---");
		
		//------------------------file---------------------
		System.out.println("\nEnter the file name to load:");
		//loadFile(reader.next());
		//------------------------file---------------------
		
		do {
			System.out.println("\nMain Menu: \n[1] Student \n[2] Faculty \n[3] Staff \n[4] Save and Quit");
			option = getInteger();	// Exception ensures input is int
			
			if(option == 1 || option == 2){	// Student or Faculty Login
				login = user.userLogin();
				if(login == true){				// Login successful
					user.userMenu(user, document);
				}
			} else if (option == 3) {		// Staff Menu
				staff.staffOptions(user, document);
			} else if (option == 4) {		// Save and Quit
				saveAndQuit();
			} else { 						// Input is not listed
				System.out.println("\nOption Input Not Listed\n");
			}
		} while (option != 4); 		// Exits System
		reader.close();				// Close Scanner
	} 
	
	/** 
	 * /**
	 *  * @param document the document to set
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static int getInteger(){
	    int input = 0;	// Integer User Enters

	    for(boolean flag = false; flag == false;){
	        try{
		        System.out.println("Enter Number ");
		        input = reader.nextInt();	
	
		        flag = true;	// Input is valid
		        return input;
	        } catch(InputMismatchException e) {	// Exception Catches Invalid Input
	        	System.out.println("Invalid input");	// Error Message
	        }
	        reader.nextLine();	// Read next line
	    }
	    return input;
	} 
	
	private static void saveAndQuit(){
		System.out.println("Enter file name: ");
		fileName = reader.next();
		
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		try {
			fos = new FileOutputStream(fileName);
			out = new ObjectOutputStream(fos);
			
			out.writeObject(document);
			
			fos.close();
			out.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void loadFile(String name){
		FileInputStream fis = null;
		ObjectInputStream in = null;
		
		File file = new File(name);
		if(file.exists()){
			try{
				fis = new FileInputStream(file);
				in = new ObjectInputStream(fis);
				Object obj = null;
				while((obj = (Document) in.readObject()) != null){
					if(obj instanceof Document){
						Document document = (Document) obj;
						document.documentList.add(document);
					}
				}
				fis.close();
				in.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch(IOException e){
				e.printStackTrace();
			}  catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("\nFile doesn't exist...");
		}
	}
}
