package poised;

/**
 * The main class to represent a Person Object
 * <br>
 * @author Kelcey Webb
 */
public class Person {
	
	//Create Attributes
	String type;
	String firstName;
	String lastName;
	String telNum;
	String emailAddress;
	String physicalAdd;
	
	/**
	 * Class constructor to create a Person Object,
	 * using the specified details
	 * 
	 * @param type The person's occupation
	 * @param firstName The person's first name
	 * @param lastName The person's last name
	 * @param telNum The person's telephone number
	 * @param emailAddress The person's email address
	 * @param physicalAdd The person's physical address
	 */
	public Person(String type, String firstName, String lastName, String telNum, String emailAddress, String physicalAdd) {
		this.type = type;
		this.firstName = firstName;
		this.lastName = lastName;
		this.telNum = telNum;
		this.emailAddress = emailAddress;
		this.physicalAdd = physicalAdd;
	}
	
	/**
	 * Method to change the person's telephone number,
	 * specifying the new telephone number
	 * 
	 * @param telNum The person's new telephone number
	 */
	public void setTelNum (String telNum) {
		this.telNum = telNum;
	}
	
	/**
	 * Method to change the person's email address,
	 * specifying the new email address
	 * 
	 * @param emailAddress The person's new email address
	 */
	public void setEmail (String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	/**
	 * Method to change the person's first name,
	 * specifying the new first name
	 * 
	 * @param firstName The person's new first name
	 */
	public void setFirstName (String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * Method to change the person's last name, 
	 * specifying the person's new last name
	 * 
	 * @param lastName The person's new last name
	 */
	public void setLastName (String lastName) {
		this.lastName = lastName; 
	}
	
	/**
	 * Method to change the person's physical address,
	 * specifying the person's new physical address
	 * 
	 * @param physicalAdd The person's new physical address
	 */
	public void setAddress (String physicalAdd) {
		this.physicalAdd = physicalAdd;
	}
	
	/**
	 * Method to display the person's last name
	 * 
	 * @return The person's last name
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Method to display all the person's details.
	 * 
	 * @return All the person's details with headings
	 * describing the information displayed
	 */
	public String toString() {
		String output ="\n"+type+" Name:\s \s \s \s \s \s \s \s \s\s\s\s\s\s\s\s\s\s" + firstName + " " + lastName;
		output += "\n"+type+" Telephone Number:\t\t" + telNum;
		output += "\n"+type+" Email Address:\s \s \s \s \s \s \s \s \s" + emailAddress;
		output += "\n"+type+" Physical Address:\t\t" + physicalAdd;
		   
		return output;
	}
	
	/**
	 * Method to display the person's details in a specific format,
	 * suitable for a text file
	 * 
	 * @return All the person's details separated by a comma and space
	 */
	public String toTextFile() {
		return firstName + ", " + lastName + ", " + telNum + ", " + emailAddress + ", " + physicalAdd;
	}
}
		
	


