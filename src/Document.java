
public class Document { //Book, Journal, and Aucio/videos are subclasses with the only difference being added variables unique to each other

	private static String Author; //data types that are shared by all documents
	private static String Title;
	private static int datePublished;
	private static String Publisher;


	private User user;
	private LibrarySystem manages;
	private String Status;
	//private int issues;
        private static int totalCopies;
        private static int availableCopies;
        private static String type;
        //private log allLogs[];
        
        Document(){}
        
        Document(String inAuthor, String inTitle, int inDatePublished, //This is a constructor for quick creation
                String inPublisher, int inCopies//, User inUser, LibrarySystem inManages,
                //String inStatus, LibrarySystem[] inIssues
        )
        {
            Author = inAuthor;
            Title = inTitle;
            datePublished = inDatePublished;
            Publisher = inPublisher;
            totalCopies = inCopies;
            availableCopies = inCopies;
            //user = inUser;
            //manages = inManages;
            //Status = inStatus;
            //issues = inIssues;
        }
        
        public static void printAll(){ //prints all info
            System.out.print(Author);
            System.out.print("   ");
            System.out.print(Title);
            System.out.print("   ");
            System.out.print(datePublished);
            System.out.print("   ");
            System.out.print(Publisher);
            System.out.print("   ");
            System.out.print(availableCopies);
            System.out.print("/");
            System.out.print(totalCopies);
            System.out.print("   ");
        }
        
        public static void setType(String inType){
            type = inType;
        }
        
        public static String getType(){
            return type;
        }
        
        public void decrementAvailableCopies(){ //a series of setters and getters for all the variables
            if (availableCopies == 0){
                System.out.println("Error: cannot decrement available copies below zero");
                return;
            }
            
            availableCopies--;
        }
        public void incrementAvailableCopies(){
            if (availableCopies == totalCopies){
            System.out.println("Error: cannot increment above total copies");            
            return;
            }
            availableCopies++;
        }
        public String getAuthor(){
            return Author;
        }
        public void setAuthor(String inAuthor){
            Author = inAuthor;
        }
        public String getTitle(){
            return Title;
        }
        public void setTitle(String inTitle){
            Title = inTitle;
        }
        public int getDatePublished(){
            return datePublished;
        }
        public void setDatePublished(int inDatePublished){
          datePublished = inDatePublished;  
        }
        public String getPublisher(){
            return Publisher;
        }
        public void setPublisher(String inPublisher){
            Publisher = inPublisher;
        }
        public String getStatus(){
            return Status;
        }
        public void setStatus(String inStatus){
            Status = inStatus;
        }
        public User getUser(){
            return user;
        }
        public void setUser(User inUser){
            user = inUser;
        }
        public LibrarySystem getManages(){
            return manages;
        }
        public void setManages(LibrarySystem inManages){
            manages = inManages;
        }
        //public int getIssues(){
        //    return issues;
        //}
        //public void setIssues(int inIssues){
        //    issues = inIssues;
        //}
        public int getTotalCopies(){
            return totalCopies;
        }
        public void setTotalCopies(int inCopies){
            totalCopies = inCopies;

        }
        public void setAvailableCopies(int inCopies){
            availableCopies = inCopies;
        }
        
        
	}
