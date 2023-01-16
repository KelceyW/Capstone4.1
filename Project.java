package poised;
/**
 * The main class to represent a Project Object.
 * <br>
 * @author Kelcey Webb
 */
public class Project {
	
	int projectNumber;
	String projectName;
	Object building;
	Object architect;
	Object contractor;
	Object customer;
	String complete;
	
	/**
	 * Class constructor to create a Project Object
	 * using the specified details.
	 * 
	 * @param projectNumber The number of the project, automatically allocated.
	 * @param projectName The name of the project.
	 * @param building The building details for the project in the form of a Building Object.
	 * @param architect The architect for the project in the form of a Person Object.
	 * @param contractor The contractor for the project in the form of a Person Object.
	 * @param customer The customer for the project in the form of a Person Object.
	 * @param complete If the project has been completed or not, automatically set as 'No'.
	 */
	public Project(int projectNumber,String projectName,Object building,Object architect,Object contractor,
			Object customer,String complete) {
		this.projectNumber = projectNumber;
		this.projectName = projectName;
		this.building = building;
		this.architect = architect;
		this.contractor = contractor;
		this.customer = customer;
		this.complete = complete;	
	}
	
	/**
	 * Method to display the contractor's details.
	 * 
	 * @return The contractor's details.
	 */
	 public Object getContractor() {
	     return contractor;
	 }
	 
	 /**
	  * Method to display the architect's details.
	  * 
	  * @return The architect's details.
	  */
	 public Object getArchitect() {
		 return architect;
	 }
	 /**
	  * Method to display the project number
	  * 
	  * @return The project number 
	  */
	 public int getProjectNum() {
		 return projectNumber;
	 }
	 
	 /**
	  * Method to display whether a project is complete or not
	  * 
	  * @return The project's completion status
	  */
	 public String getComplete() {
		 return complete;
	 }
	 
	 /**
	  * Method to change the contractor
	  * specifying the new contractor.
	  * 
	  * @param contractor The new contractor in the form of a Person Object
	  */
	 public void setContractor (Object contractor) {
		 this.contractor = contractor;
	 }
	 
	 /**
	  * Method to change the project's completion status
	  * 
	  * @param complete The new completion status
	  */
	 public void setComplete(String complete) {
		 this.complete = complete;
	 }
	 
	 /**
	  * Method to display the customer's details.
	  * 
	  * @return The customer's details
	  */
	 public Object getCustomer() {
		 return customer;
	 }
	 
	 /**
	  * Method to display the building details.
	  * 
	  * @return The building details.
	  */
	 public Object getBuilding() {
		 return building;
	 }
	 
	 /**
	  * Method to display the project details.
	  * 
	  * @return the project details.
	  */
	 public Object getProject() {
		String output = building.toString();
		output += "\nProject Completed:\t\t\t" + complete;
		
		return output;
	 }
	 
	/**
	 * Method to display all the project details.
	 * 
	 * @return All the project details
	 * with headings describing the information displayed	 
	 */
	public String toString() {
		String output = "\n\nProject Number:\t\t\t\t" + projectNumber;
		output += "\nProject name:\t\t\t\t" + projectName;
		output += building.toString();
		output += "\nProject Completed:\t\t\t" + complete;
		output += "\n" + architect;
		output += "\n" + contractor;
		output += "\n" + customer;
		   
		return output;
	}
	
	/**
	 * Method to display the project's details in a specific format, 
	 * suitable for a text file
	 * 
	 * @return The project's details separated by a comma and a space
	 */
	public String toTextFile() {
		return "\n" + projectNumber + ", " + ((Building)building).toTextFile() + 
				", " + ((Person)architect).toTextFile() + ", " + ((Person)contractor).toTextFile() +
				", " + ((Person)customer).toTextFile() + ", " + projectName + ", " + complete;
	}
}
