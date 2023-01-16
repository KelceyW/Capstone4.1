package poised;

import java.time.LocalDate;

/**
 * The main class to represent a Building Object.
 * <br>
 * @author Kelcey Webb
 *
 */
public class Building {
	
	String buildingType;
	String physicalAddress;
	int erfNum;
	LocalDate deadline;
	double totalFee;
	double totalPaid;
	
	/**
	 * Class constructor to create a Building Object
	 * using the specified details.
	 * 
	 * @param buildingType The type of building.
	 * @param physicalAddress The physical address of the building.
	 * @param erfNum The ERF number of the building.
	 * @param deadline The date of required completion of the building.
	 * @param totalFee The total fee being charged for the building.
	 * @param totalPaid The total amount paid to date.
	 */
	public Building (String buildingType, String physicalAddress, int erfNum, LocalDate deadline, double totalFee, double totalPaid) {
		this.buildingType = buildingType;
		this.physicalAddress = physicalAddress;
		this.erfNum = erfNum;
		this.deadline = deadline;
		this.totalFee = totalFee;
		this.totalPaid = totalPaid;
	}
		
	/**
	 * Method to display the building's total fee
	 * 
	 * @return The building's total fee
	 */
	public double getTotalFee() {
		return totalFee;
	}
	
	/**Method to display the building's total amount paid
	 * 
	 * @return The building's total amount paid
	 */
	public double getTotalPaid() {
		return totalPaid;
	}
	
	/**
	 * Method to change the building's deadline,
	 * specifying the new deadline
	 * 
	 * @param deadline The building's new deadline
	 */
	public void setDeadline (LocalDate deadline) {
		this.deadline = deadline;
	}
	
	/**
	 * Method to change the building's type
	 * 
	 * @param buildingType The building's new type
	 */
	public void setBuildingType (String buildingType) {
		this.buildingType = buildingType;
	}
	
	/**
	 * Method to change the building's total fee
	 * 
	 * @param totalFee The building's new total fee
	 */
	public void setTotalFee (double totalFee) {
		this.totalFee = totalFee;
	}
	
	/**
	 * Method to change the building's total amount paid
	 * 
	 * @param totalPaid The buildings new total amount paid
	 */
	public void setTotalPaid (double totalPaid) {
		this.totalPaid = totalPaid;
	}
	
	/**
	 * Method to display all the building's details
	 * with headings describing the information displayed.
	 * 
	 * @return All the building's details with headings
	 * describing the information displayed
	 */
	public String toString() {
		String output = "\nBuilding Type:\t\t\t\t" + buildingType;
		output += "\nPhysical Address:\t\t\t" + physicalAddress;
		output += "\nERF Number:\t\t\t\t" + erfNum;
		output += "\nDeadline:\t\t\t\t" + deadline;
		output += "\nTotal Fee:\t\t\t\t" + totalFee;
		output += "\nTotal Paid:\t\t\t\t" + totalPaid;
		
		return output;
	}
	
	/**
	 * Method to display the buildings details in a specific format, 
	 * suitable for a text file
	 * 
	 * @return All the building's details separated by a comma and space
	 */
	public String toTextFile() {
		return buildingType + ", " + physicalAddress + ", " + erfNum + ", " + deadline + ", " + totalFee + ", " + totalPaid;
	}
}
	
	
	

	


