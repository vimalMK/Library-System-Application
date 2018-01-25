
public class Student extends User{
    Student(){
        User.setUserType("Staff"); //The default length for checkouts is for faculty and staff since they share the same length
        User.setMaxItems(6);
        User.setMaxMonthsForDocs(6); // Therefore the student class has to change the time on construction to differentiate itself
    }
    
    public void printEverything(){
        Faculty.printAll();
        System.out.print("   ");
        System.out.print(User.getUserType());
        System.out.print("\n");
        
    }
    
	//private User[] consistOf;

	
}
