
//import static java.io.FileDescriptor.out;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
//import static java.lang.System.out;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
//import static sun.misc.MessageUtils.out;


public class LibrarySystem { // each of these is a library
	private User usedBy; //not yet utilized, may be in the future
        private User allUsers[]; //These thre are the databases
        private Document[] allDocuments;
        private log allLogs[];
        public int allDocCount = 0; //initial counts for the databases
        public int allUserCount = 0;
        public int allLogCount = 0;
        
        //public static void createUser(String name){
        //    User person = new User();
        //    person.setName(name);
        //};
        
       // public void importData(){
       //     System.out.println("Would you like to import Document Data?");
       //     try {
       //         char response = (char) System.in.read();
       //     } catch (IOException ex) {
        //        Logger.getLogger(LibrarySystem.class.getName()).log(Level.SEVERE, null, ex);
       //     }

    public LibrarySystem() {
        this.allUsers = new User[200]; //initializations
        this.allDocuments = new Document[200];
        this.allLogs = new log[200];
    }
            

        //}
        
        //public void importUsers(){
        //    System.out.println("Would you like to import User Data?");
        //}
        
        
        public void introMenu() throws IOException{ //This provides a list of options for the user
            char response='z';            
            do{
            System.out.println("What would you like to do?\n"
                    + "a) Add Document\n"
                    + "s) Search Documents\n"
                    + "u) Add User\n"
                    //+ "U) Manage Users\n"
                    //+ "O) Quick Checkout\n"
                    //+ "I) Quick Checkin\n"
                    + "e) Exit Program");

            try {
                response = (char) System.in.read();
            } catch (IOException ex) {
                Logger.getLogger(LibrarySystem.class.getName()).log(Level.SEVERE, null, ex);
            }
            switch (response){ //This executes each option
                case 'a': addDocument();
                    break;
                case 's': searchDocuments();
                    break;
                case 'u': addUser();
                    break;
                //case 'u': searchUsers();
                //case 'o': quickCheckout();
                //case 'i': quickCheckin();
                case 'e': exitProgram();
                    break;
                default: introMenu(); break;
            }
            }while(response != 'e'); //menu continues until you enter e for exit
        }
        
        
        // search documents - remove
        // add documents
        // search users
        // add/remove users
        // checkout, checkin

    private void addDocument() throws IOException { //this allows you to create a new document
        
        Scanner terminalInput = new Scanner(System.in); //this chunk of text gets all the data necessary for any kind of document
        terminalInput.nextLine();
        System.out.println("Enter author: ");
        String author = terminalInput.nextLine();
        System.out.println("Enter title: ");
        String title = terminalInput.nextLine();
        System.out.println("Enter date published: ");
        int datePublished = terminalInput.nextInt();
        terminalInput.nextLine();
        System.out.println("Enter publisher: ");
        String publisher = terminalInput.nextLine();
        System.out.println("Enter copies: ");
        int copies = terminalInput.nextInt();
        terminalInput.nextLine();
        char response = 'z';        
        
        do{
        System.out.println("Is this an? \n" //after all the standard data types are entered then the user is asked to specify the document type
                + "a) audio/video \n"
                + "b) book \n"
                + "j) journal \n");
        
        //String temp = terminalInput.next().
        response = (char) System.in.read(); 
        }
        while ((response != 'a') && (response != 'b') && (response != 'j'));
        
        if (response == 'b'){ //creates either a book journal of videoaudio
            allDocuments[allDocCount] = new Book(); 
            //allDocuments[allDocCount].(author, title, datePublished, publisher, copies);
            System.out.println("Enter ISBN: ");
            int ISBN = terminalInput.nextInt();
            Book.setISBN(ISBN);
        } else if (response == 'j') {
            allDocuments[allDocCount] = new Journal();
            System.out.println("Enter volume: ");
            int volume = terminalInput.nextInt();
            System.out.println("Enter issue: ");
            int issue = terminalInput.nextInt();
            terminalInput.nextLine();
            System.out.println("Enter all articles: ");
            String articles = terminalInput.nextLine();
            Journal.setVolume(volume);
            Journal.setIssue(issue);
            Journal.setArticles(articles);
        } else {//is audio/video
            allDocuments[allDocCount] = new videoAudio();
        }
        
        allDocuments[allDocCount].setAuthor(author);
        allDocuments[allDocCount].setTotalCopies(copies);
        allDocuments[allDocCount].setDatePublished(datePublished);
        allDocuments[allDocCount].setTitle(title);
        allDocuments[allDocCount].setPublisher(publisher);
        allDocuments[allDocCount].setStatus("created");
        allDocuments[allDocCount].setAvailableCopies(copies); //all the data is entered for the document
        allDocCount++; //number of documents in database is updated
        System.out.println("Document successfully created \n");
        terminalInput.nextLine();
    }

    private void searchDocuments() throws IOException {
        Scanner terminalInput = new Scanner(System.in);
        
        if (allDocCount == 0){ //checks to see there are documents present
            System.out.println("Error: There are no documents to search");
            terminalInput.nextLine();
            return;
            
        }
        
        char response = 'z';
        terminalInput.nextLine();
        do{
        System.out.println("How would you like to search? \n" // choices
            + "t) title \n"
            + "a) author \n"
            + "p) publisher \n");
        try {
            response = (char) System.in.read();
        } catch (IOException ex) {
            Logger.getLogger(LibrarySystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        while ((response != 't') && (response != 'a') && (response != 'p'));
           //int [] locations; //advanced feature that checks for duplicates ; not yet necessary
           //locations = new int[200];
           //int locationCount = 0;
           terminalInput.nextLine();
           int location = 0;
        if (response == 't'){ //first it searches the database by either title, author or publisher then gives the option to check out check in or end search
           System.out.println("Enter title: ");
           String title = terminalInput.nextLine();

           for (int i = 0; i < allDocCount; i++)
           {
               String tempTitle = allDocuments[i].getTitle();
               if (title.equals(tempTitle)){
                   //locations[locationCount] = i;
                   //locationCount++;
                   location = i;
                   System.out.println("Found");
                   allDocuments[i].printAll();
                   System.out.print("\n");
                   i = allDocCount;
               }else if ((i+1) == allDocCount){
                   System.out.println("Error: not found");
                   return;
               }
           }
        } else if (response == 'a') {
           System.out.println("Enter author: ");
           String author = terminalInput.nextLine();

           for (int i = 0; i < allDocCount; i++)
           {
               String tempAuthor = allDocuments[i].getAuthor();
               if (author.equals(tempAuthor)){
                   //locations[locationCount] = i;
                   //locationCount++;
                   location = i;
                   System.out.println("Found");
                   allDocuments[i].printAll();
                   System.out.print("\n");
                   i = allDocCount;
               }else if ((i+1) == allDocCount){
                   System.out.println("Error: not found");
                   return;
               }
           }
        } else {//publisher
           System.out.println("Enter publisher: ");
           String publisher = terminalInput.nextLine();

           for (int i = 0; i < allDocCount; i++)
           {
               String tempPublisher = allDocuments[i].getPublisher();
               if (publisher.equals(tempPublisher)){
                   //locations[locationCount] = i;
                   //locationCount++;
                   location = i;
                   System.out.println("Found");
                   allDocuments[i].printAll();
                   i = allDocCount;
               }else if ((i+1) == allDocCount){
                   System.out.println("Error: not found");
                   return;
               }
           }
        }
        int p = 0;           
        //if (locationCount > 1){ // advanced functionality for dubplicates
        //    for (int i = 0; i < locationCount; i++){
        //        System.out.print(i);
        //        System.out.println(" ");
        //        allDocuments[locations[i]].printAll();
        //    }
        //    System.out.println("\n Which did you mean?\n");
//
        //    do{
        //    p = terminalInput.nextInt();
        //    }while (p >= locationCount);
        //}
        //terminalInput.nextLine();
        do{
        System.out.println("What would you like to do?\n" //options to implement on found document
                + "i) check in\n"
                + "o) check out\n"
                + "r) return to main menu");
        
        response = (char) System.in.read();
        }while ((response != 'i') && (response != 'o') && (response != 'r'));
        
        if (response == 'r'){ //return to main menu
            terminalInput.nextLine();
            return;
        }
        
        if (allUserCount == 0){ //checks user databse to see that it is not empty
            System.out.println("There are no users'n");
            terminalInput.nextLine();
            return;
        }
        
        if (response == 'o'){
            System.out.println("Enter id of user: \n");
            int userId =  terminalInput.nextInt();
            
            
            for (int j = 0; j < allUserCount; j++){
                if (userId == allUsers[j].getIdNumber()){
                    if (allUsers[j].getItemsCheckedOut() == allUsers[j].getMaxItems()){
                        System.out.println("Error: User has reached macimum items to check out"); //checks to see that user hasn't checked out more than they are allowed
                        terminalInput.nextLine();
                        return;
                    }
                    
                    int locate = location;
                    if (allDocuments[locate].getType() == "Journal"){ //log is made with default due date being 3 days for everyone
                        allLogs[allLogCount] = new log(userId, location); 
                    }else{
                    allLogs[allLogCount] = new log(userId, location, allUsers[userId].getMaxMonthsForDocs()); //a new log is made with due date depending on user Type
                    }
                    allUsers[userId].incrementItemsCheckedOut(); //if user is found then docs checked out is incremented and available copies are decremented
                   
                    allDocuments[locate].decrementAvailableCopies();
                    System.out.println("Item successfully checked out\n");
                    allLogCount++;
                    return;
                }else if((j+1) == allUserCount){ //if user is not found returns to main menu
                    System.out.println("Couldn't find user\n");
                    return;
                }
            }
        }else{//checking in
            System.out.println("Enter id of user: \n");
            int userId =  terminalInput.nextInt();
            for (int j = 0; j < allUserCount; j++){
                if (userId == allUsers[j].getIdNumber()){
                    for (int r = 0; r < allLogCount; r++){
                        int docId = location;
                        if ((userId == allLogs[r].getUserId()) && (docId == allLogs[r].getDocumentId())){ //checks database of logs created and finds the right one
                            //Future note: This will create the problem of empty random spots, log should be checked for open spots before inserting to the end
                            allUsers[userId].decrementItemsCheckedOut();
                            allDocuments[docId].incrementAvailableCopies();
                            allLogs[r] = null;
                            System.out.println("Item successfully returned\n"); // the log is deleted and the appropriate values are incremented/decremented
                            return;
                        };
                        
                    }
                    return;
                }else if((j+1) == allUserCount){
                    System.out.println("Couldn't find user\n"); //if none is found the operation is terminated early and you are returned to the main menu
                    return;
                }
            }
        }

        }
        
    

    private void addUser() {
        Scanner terminalInput = new Scanner(System.in);
        terminalInput.nextLine();
        System.out.println("Enter name");
        String name = terminalInput.nextLine();
        char response = 'z';    
        do{
        int idNumber = allUserCount;      
                System.out.println("Is this an? \n"
                + "s) student \n"
                + "f) faculty \n"
                + "t) staff \n");
        
        try {
            response = (char) System.in.read();
        } catch (IOException ex) {
            Logger.getLogger(LibrarySystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        }while ((response != 's') && (response != 'f') && (response != 't'));
        
        if (response == 's'){ // determines whether new user is student faculty or staff
           allUsers[allUserCount] = new Student();
        } else if (response == 'f') {
           allUsers[allUserCount] = new Faculty();
        } else {//faculty
            allUsers[allUserCount] = new Staff();
        }
        allUserCount++;
        System.out.println("User successfully created\n");
        terminalInput.nextLine();
    }

    private void printAllUsers() { // for debugging purposes
        System.out.println("Name       ID       Items Checked Out\n");
        for (int i = 0; i < allUserCount ; i++){
            allUsers[i].printAll();
        }
        
    }
    
    private void printAllDocuments(){ // for debugging purposes
        System.out.println("Author    Title              Date     Publisher    Copies");
        for (int i = 0; i < allDocCount ; i++){
            allDocuments[i].printAll();
        }
    
    }

    //private void quickCheckout() {
    //    Scanner terminalInput = new Scanner(System.in);        
    //}

    //private void quickCheckin() {
    //    Scanner terminalInput = new Scanner(System.in);        
    //}

    private void exitProgram() throws FileNotFoundException, UnsupportedEncodingException { //  exports all databases into a text file
    PrintWriter writer = new PrintWriter("libraryArchive.txt", "UTF-8");
    for (int i = 0; i < allDocCount; i++){
        writer.print(allDocuments[i].getAuthor());
        writer.print(allDocuments[i].getPublisher());
        writer.print(allDocuments[i].getTitle());
        writer.print(allDocuments[i].getStatus());        
    }
    for (int j = 0; j < allUserCount; j++){
        writer.print(allUsers[j].getIdNumber());
        writer.print(allUsers[j].getItemsCheckedOut());
        writer.print(allUsers[j].getName());
        writer.print(allUsers[j].getRegistrationStatus());
    }
    for (int r = 0; r < allLogCount; r++){
        writer.print(allLogs[r].getUserId());
        writer.print(allLogs[r].getDocumentId());
        writer.print(allLogs[r].getDueDate());
    }
    writer.println("The second line");
    writer.close();
        
        return;
    }
        

}
