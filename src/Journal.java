
public class Journal extends Document {

	private static int Volume;
	private static int Issue;
        private static String articles;
	//private Document[] is;
        
        Journal(){
            Document.setType("Journal");
        }
        
        public void printEverything(){
            Journal.printAll();
            System.out.print(Volume);
            System.out.print("   ");
            System.out.print(Issue);
            System.out.print("   ");
            System.out.print(articles);
            System.out.print("\n");
        }
        
        
        public int getVolume(){
            return Volume;
        }
        
        public static void setVolume(int inVolume){
            Volume = inVolume;
        }
        
        public int getIssues(){
            return Issue;
        }
        
        public static void setIssue(int inNumber){
            Issue = inNumber;
        }
        
        public String getArticles(){
            return articles;
        }
        
        public static void setArticles(String inArticles){
            articles = inArticles;
        }
        
        //public Document [] getIs(){
        //    return is;
        //}
        
        //public void setIs(Document [] inIs){
        //    is = inIs;
        //}
	
}
