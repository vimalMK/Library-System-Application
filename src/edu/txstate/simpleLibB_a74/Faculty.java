package edu.txstate.simpleLibB_a74;
/**
 * Faculty class extends user class. Inherits name and id from user. Contains a toString.
 * @author Bernadette Aguirre
 */
public class Faculty extends User {
	/**
	 * 
	 */
	public String toString(){
		return "\nName: " + getName() + "\t\tID: " +  getId() + "\t\t#Doc: " + getAmountDoc() + "\t\tType: Faculty";

	}
}
