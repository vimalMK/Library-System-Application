
import java.util.Calendar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Daniel
 */
class log {
    private static int userId;
    private static int documentId;
    private static Calendar dueDate;

    log(int inUserId, int inDocumentId, int lengthWeeks){
        userId = inUserId;
        documentId = inDocumentId;
        dueDate = Calendar.getInstance();
        dueDate.add(Calendar.WEEK_OF_YEAR, +lengthWeeks);
    }
    log(int inUserId, int inDocumentId){
        userId = inUserId;
        documentId = inDocumentId;
        dueDate = Calendar.getInstance();
        dueDate.add(Calendar.DAY_OF_YEAR, +3);
    }    
    
    
    public static int getUserId(){
        return userId;
    }
    public static int getDocumentId(){
        return documentId;
    }
    public static Calendar getDueDate(){
        return dueDate;
    }




}
