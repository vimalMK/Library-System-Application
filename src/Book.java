
public class Book extends Document{

	private static int ISBN;
	//private Document[] is;
        
        Book(){
            Document.setType("Book");
        }
        
        public void printEverything(){
            Book.printAll();
            System.out.print(ISBN);
            System.out.print("\n");
        }
        
        public int getISBN(){
            return ISBN;
        }
        public static void setISBN(int inISBN){
            ISBN = inISBN;
        }
        //public Document [] getIs(){
        //    return is;
        //}
        //public void setIs(Document [] inIs){
        //    is = inIs;
        //}

}
