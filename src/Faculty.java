
public class Faculty extends User{
    
    Faculty(){ //All usertypes provide their user type to the Super class
        User.setUserType("Faculty");
    }
    
    
    public void printEverything(){
        Faculty.printAll();
        System.out.print("   ");
        System.out.print(User.getUserType());
        System.out.print("\n");
        
    }
    
	//private Users[] is;

}
