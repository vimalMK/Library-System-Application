
public class User { //User is the master class for Faculty Staff and Student

	private static String Name; //types all users require
	private static int idNumber;
	private static int itemsCheckedOut;
	private static int registrationStatus;
	//private LibrarySystem[] usedBy;
	//private Document[] request;
        private static String userType;
        private static final int MAXITEMSFORFACULTYSTAFF = 12; //default times for each user type are constants
        private static int maxItems = MAXITEMSFORFACULTYSTAFF;
        private static final int JOURNALMAXDAYS = 3;
        private static final int MAXMONTHSDOCUMENTSFORFACULTYSTAFF = 12;
        private static int maxMonthsForDocs = MAXMONTHSDOCUMENTSFORFACULTYSTAFF;
        private static final int GOODCONDITION = 1;
        
        

        User(){
        registrationStatus = GOODCONDITION; //means registration is complete and there are no problems
        itemsCheckedOut = 0;
        }
        
        User(String inName, int inIdNumber, int inItemsCheckedOut,
                int inRegistrationStatus, LibrarySystem[] inUsedBy,
                Document[] inRequest){
            Name = inName;
            idNumber = inIdNumber;
            itemsCheckedOut = inItemsCheckedOut;
            registrationStatus = inRegistrationStatus;
            //usedBy = inUsedBy;
            //request = inRequest;
}
        
        public static void setMaxMonthsForDocs(int inMonths){
            maxMonthsForDocs = inMonths;
        }
        
        public static int getMaxMonthsForDocs(){
            return maxMonthsForDocs;
        }
        
        public static void setMaxItems(int inMaxItems){
            maxItems = inMaxItems;
        }
        
        public static int getMaxItems(){
            return maxItems;
        }
        
        public static String getUserType(){
            return userType;
        }
        
        public static void setUserType(String inUserType){
            userType = inUserType;
        }
        
        public void setName(String inName){
            Name = inName;
        }
        public String getName(){
            return Name;
        }
        public void setIdNumber(int inIdNumber){
            idNumber = inIdNumber;
        }
        public int getIdNumber(){
            return idNumber;
        }
        public void setItemsCheckedOut(int inItemsCheckedOut){
            idNumber = inItemsCheckedOut;
        }
        
        public void decrementItemsCheckedOut(){
            if (itemsCheckedOut == 0){
                System.out.println("Error: cannot decrement items checked out below zero");
                return;
            }
            itemsCheckedOut--;            
            
        }
        
        public void incrementItemsCheckedOut(){            
            itemsCheckedOut++;            
        }
        
        
        public int getItemsCheckedOut(){
            return itemsCheckedOut;
        }
        public void setRegistrationStatus(int inRegistrationStatus){
            registrationStatus = inRegistrationStatus;
        }
        public int getRegistrationStatus(){
            return registrationStatus;
        }
        //public void setUsedBy(LibrarySystem[] inUsedBy){
        //    usedBy = inUsedBy;
        //}
        //public LibrarySystem [] getUsedBy(){
        //    return usedBy;
        //}
        //public void setRequest(Document [] inRequest){
        //    request = inRequest;
        //}
        //public Document [] getRequest(){
        //    return request;
       // }

        public static void printAll(){
            System.out.print(Name);
            System.out.print("   ");
            System.out.print(idNumber);
            System.out.print("   ");
            System.out.print(itemsCheckedOut);
            System.out.print("   ");
            
        }
}
