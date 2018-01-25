 // Daniel Amador - Ngu OOD Spring 2016
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
This program creates a library system that allows users to make documents and system users and provides the ability to check items in.
Documents can range from books, journals, etc; users of the system can students, faculty, staff.
 */
//import java.util;
//import java.io;
//import javax.swing;

/**
 *
 * @author Daniel
 */
public class HW2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    LibrarySystem texasState = new LibrarySystem();
        try {
            texasState.introMenu();
        } catch (IOException ex) {
            Logger.getLogger(HW2.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
}
