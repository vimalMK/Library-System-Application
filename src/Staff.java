
public class Staff extends User {
    
    Staff(){
        User.setUserType("Staff");
    }
    
    
    public void printEverything(){
        Faculty.printAll();
        System.out.print("   ");
        System.out.print(User.getUserType());
        System.out.print("\n");
        
    }
    
	//private User[] consistOf;


}
