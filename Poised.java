package poised;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

/**
 * The main class representing the Poised package
 * 
 * @author Kelcey Webb
 *
 */
public class Poised {
	
	private static final String ERROR = "ERROR! FAILED TO EDIT PROJECT";
	//Constants
	private static final String PRO = "PROJECT ";
	private static final String CU = "Customer";
	private static final String CO = "Contractor";
	private static final String A = "Architect";
	private static final String ENTER_CUST = "PLEASE ENTER THE CUSTOMER'S NEW ";
	private static final String ENTER_CON = "PLEASE ENTER THE CONTRACTOR'S NEW ";
	private static final String ENTER_ARC = "PLEASE ENTER THE ARCHITECT'S NEW ";
	private static final String CONFIRM = " \n\nY - CONFIRM\nN - BACK";
	private static final String INPUT_REQUIRED = "THIS FIELD IS REQUIRED. PLEASE ENTER A VALID INPUT:";
	private static final String TEXT_FILE = "Projects.txt";
	private static final String TEL = "TELEPHONE NUMBER:";
	private static final String ADDRESS = "PHYSICAL ADDRESS:";
	private static final String LAST = "LAST NAME:";
	private static final String FIRST = "FIRST NAME:";
	private static final String EMAIL = "EMAIL ADDRESS:";
	
	//Variables
	static Scanner input = new Scanner(System.in);
	static Scanner intInput = new Scanner(System.in);
	static LocalDate today = LocalDate.now();
	
	//Array lists
	static ArrayList<Object> projects = new ArrayList<> ();
	static ArrayList<String> projectsToTextFile = new ArrayList<>();
	static ArrayList<String> allProjects = new ArrayList<>();
	static ArrayList<String> completeProjects = new ArrayList<>();
	static ArrayList<String> incompleteProjects = new ArrayList<>();
	static ArrayList<String> overdueProjects = new ArrayList<>();
	static ArrayList<String> searchList = new ArrayList<>();
	
	/**
	 * The main method.
	 * Method to implement all the other methods and run the program as a whole
	 * 
	 * @param args The command line arguments
	 */
	public static void main (String [] args) {
		
		System.out.println("WELCOME TO POISED PROJECT MANAGER!");
		Boolean valid = true;
		
		while (Boolean.TRUE.equals(valid)) {
			try {
				System.out.println("""
						
						MAIN MENU:
						
						A - ADD PROJECTS
						E - EDIT PROJECTS
						F - FINALISE PROJECTS
						V - VIEW PROJECTS
						S - SEARCH
						Q - QUIT
						""");
				String userInput = input.nextLine().toUpperCase();
				
				if(userInput.isEmpty()) {
					System.out.println(INPUT_REQUIRED);
				}
				
				if(userInput.equals("Q")) {
					break;
				}
				
				if(userInput.equals("A")) {
					projects.clear();
					
					createProject();
					getInfo();
					
					projects.clear();
					createProject();
				}
				
				if(userInput.equals("V")) { 
					allProjects.clear();
					completeProjects.clear();
					incompleteProjects.clear();
					overdueProjects.clear();
					
					createProject();
					viewProjectList();
				}
				
				if(userInput.equals("E")) { 
					allProjects.clear();
					projectsToTextFile.clear();
					
					createProject();
					edit();
				}
						
				if(userInput.equals("S")) {
					searchList.clear();
					
					createProject();
					search();
				}
				
				if(userInput.equals("F")) {
					incompleteProjects.clear();
					projectsToTextFile.clear();
					completeProjects.clear();
					
					createProject();
					finaliseProject();
				}
				
			} catch (Exception error) {
				System.out.println("ERROR!");
			}
		}
	}
		
	/**
	 * Method to get information from a user,
	 * and save the information to a specified text file.
	 * <br>
	 * Certain inputs have to be in specific data types or they will be rejected.
	 * The information saved to the text file is then used to create a Project Object
	 * @see createProject()
	 * 
	 */
	public static void getInfo() {
		
		try (FileWriter fileWriter = new FileWriter(TEXT_FILE, true);
				Formatter formatter = new Formatter(fileWriter);) {
			File file = new File (TEXT_FILE);
			
			if(file.length() > 0) {
				formatter.format("%s", "\n");
			}
			
			StringBuilder stringBuilder = new StringBuilder();
			
			System.out.println("PLEASE ENTER THE PROJECT DETAILS BELOW:\n");
		
			int projectNumber = projects.size() +1;
			stringBuilder.append(projectNumber + ", ");
			
			System.out.println("PLEASE ENTER THE PROJECT NAME:");
			String projectName = input.nextLine();
			
			System.out.println("PLEASE ENTER THE BUILDING TYPE:");
			String buildingType = input.nextLine();
			buildingType = emptyCheck(buildingType);
			stringBuilder.append(buildingType + ", ");

			System.out.println("PLEASE ENTER THE " + ADDRESS + ":");
			String physicalAddress = input.nextLine();
			physicalAddress = emptyCheck(physicalAddress);
			stringBuilder.append(physicalAddress + ", ");

			System.out.println("PLEASE ENTER THE ERF NUMBER:");
			String num = input.nextLine();
			num = intCheck(num);
			int erfNum = Integer.parseInt(num);
			stringBuilder.append(erfNum + ", ");
		
			System.out.println("PLEASE ENTER THE DEADLINE (YYYY-MM-DD):");
			String date = input.nextLine();
			date = dateCheck(date);
			LocalDate deadline = LocalDate.parse(date);
			stringBuilder.append(deadline + ", ");

			System.out.println("PLEASE ENTER THE TOTAL FEE CHARGED:");
			String fee = input.nextLine();
			fee = doubleCheck(fee);
			double totalFee = Double.parseDouble(fee);
			stringBuilder.append(totalFee + ", ");

			System.out.println("PLEASE ENTER THE TOTAL AMOUNT PAID TO DATE:");
			String paid = input.nextLine();
			paid = doubleCheck(paid);
			double totalPaid = Double.parseDouble(paid);
			stringBuilder.append(totalPaid + ", ");
			
			System.out.println("\nPLEASE ENTER THE ARCHITECT'S DETAILS BELOW:");
			
			System.out.println(FIRST);
			String arcFirstName = input.nextLine();
			arcFirstName = emptyCheck(arcFirstName);
			stringBuilder.append(arcFirstName + ", ");
			  	
			System.out.println(LAST);
			String arcLastName = input.nextLine();
			arcLastName = emptyCheck(arcLastName);
			stringBuilder.append(arcLastName + ", ");
			  
			System.out.println(TEL);
			String arcTelNum = input.nextLine();
			arcTelNum = emptyCheck(arcTelNum);
			stringBuilder.append(arcTelNum + ", ");
			  
			System.out.print(EMAIL);
			String arcEmail = input.nextLine();
			arcEmail = emptyCheck(arcEmail);
			stringBuilder.append(arcEmail + ", ");
			  
			System.out.print(ADDRESS);
			String arcAdd = input.nextLine();
			arcAdd = emptyCheck(arcAdd);
			stringBuilder.append(arcAdd + ", ");
			
			System.out.println("\nPLEASE ENTER THE CONTRACTOR'S DETAILS BELOW:");
			
			System.out.println(FIRST);
			String conFirstName = input.nextLine();
			conFirstName = emptyCheck(conFirstName);
			stringBuilder.append(conFirstName + ", ");
		  	
			System.out.println(LAST);
			String conLastName = input.nextLine();
			conLastName = emptyCheck(conLastName);
			stringBuilder.append(conLastName + ", ");
		  
			System.out.println(TEL);
			String conTelNum = input.nextLine();
			conTelNum = emptyCheck(conTelNum);
			stringBuilder.append(conTelNum + ", ");
		  
			System.out.print(EMAIL);
			String conEmail = input.nextLine();
			conEmail = emptyCheck(conEmail);
			stringBuilder.append(conEmail + ", ");
		  
			System.out.print(ADDRESS);
			String conAddress = input.nextLine();
			conAddress = emptyCheck(conAddress);
			stringBuilder.append(conAddress + ", ");
			
			System.out.println("\nPLEASE ENTER THE CUSTOMERS'S DETAILS BELOW:");
			
			System.out.println(FIRST);
			String custFirstName = input.nextLine();
			custFirstName = emptyCheck(custFirstName);
			stringBuilder.append(custFirstName + ", ");
			  	
			System.out.println(LAST);
			String custLastName = input.nextLine();
			custLastName = emptyCheck(custLastName);
			stringBuilder.append(custLastName + ", ");
			  
			System.out.println(TEL);
			String custTelNum = input.nextLine();
			custTelNum = emptyCheck(custTelNum);
			stringBuilder.append(custTelNum + ", ");
			  
			System.out.print(EMAIL);
			String custEmail = input.nextLine();
			custEmail = emptyCheck(custEmail);
			stringBuilder.append(custEmail + ", ");
			  
			System.out.print(ADDRESS);
			String custAddress = input.nextLine();
			custAddress = emptyCheck(custAddress);
			stringBuilder.append(custAddress + ", ");
				
			if (projectName.isEmpty()) {
				projectName = buildingType + " " + custLastName;
			}
				
			stringBuilder.append(projectName + ", ");
			
			String complete = "No";
			stringBuilder.append(complete);
		
			System.out.println("\nCONFIRM ADD NEW PROJECT " + projectName + CONFIRM);
			String confirmAdd = input.nextLine().toUpperCase();
			
			if (confirmAdd.equals("Y")) {
				formatter.format("%s",stringBuilder.toString());
				
				StringBuilder stringBuilder1 = new StringBuilder();
				stringBuilder1.append(PRO + projectName + " ADDED SUCCESSFULLY!");
			
				System.out.println(stringBuilder1);
			}
			
		} catch (Exception error) {
			System.out.println ("ERROR! FAILED TO ADD PROJECT");
		}
	}
		
	/**
	 * Method to create a Project Object.
	 * <br>
	 * The Person, Building and Project Object is created and saved to certain lists 
	 * depending on the Projects attributes
	 * 
	 * @see getInfo()
	 */
	public static void createProject() {
		
		File file = new File(TEXT_FILE);
		
		if (file.exists()) {
			try(Scanner scanner = new Scanner (file);) {
				
				while (scanner.hasNextLine()) {
					
					String string = scanner.nextLine();
					String [] details = string.split(", ");
				
					int projNum = Integer.parseInt(details[0]);
					int erfNum = Integer.parseInt (details[3]);
					LocalDate deadline = LocalDate.parse(details[4]);
					double totalFee = Double.parseDouble(details[5]);
					double totalPaid = Double.parseDouble(details[6]);
				
					Person architect = new Person (A, details[7], details[8], details[9], details[10], details[11]);
					Person contractor = new Person (CO, details[12], details[13], details[14], details[15], details[16]);
					Person customer = new Person (CU, details[17], details[18], details[19], details[20], details[21]);
		
					Building building =  new Building (details[1], details[2], erfNum, deadline, totalFee, totalPaid);
					Project project = new Project (projNum, details[22], building, architect, contractor, customer, details[23]);
					
					projects.add(project);
					allProjects.add("\n" + PRO + projNum + " " + details[22]);
					projectsToTextFile.add(project.toTextFile());
					
					if (details[23].equals("No")) {
						incompleteProjects.add("\n" + PRO + " " + projNum + " " + details[22]);
					
					} else {
						completeProjects.add("\n" + PRO + " " + projNum + " " + details[22]);
					}
				
					if (today.isAfter(deadline) && details[23].equals("No")) {
					overdueProjects.add("\n" + PRO + " " + projNum + " " + details[22]);
					}
				}
				
			} catch (FileNotFoundException error ) {
				System.out.println("ERROR! FILE NOT FOUND");
			}
		}
	}
		
	/**
	 * Method to specify which details of a Project Object to change.
	 * <br>
	 * This method allows the user to choose which Project and which details
	 * of the Project they would like to edit
	 *  
	 * @see projectEditor
	 * @see architectEditor
	 * @see contractorEditor
	 * @see customerEditor
	 * 
	 */
	public static void edit() {
		
		if(allProjects.isEmpty()) {
			System.out.println("THERE ARE NO PROJECTS AVAILABLE TO EDIT, PLEASE ADD A PROJECT FIRST");
			
		} else {
			System.out.println("""
				PLEASE ENTER THE NUMBER OF THE PROJECT YOU WOULD LIKE TO EDIT:
				
				"""+ printArrayList(allProjects));
		
		int editNum = intInput.nextInt();
		Project editProject =(Project) (projects.get(editNum - 1));
	
		System.out.println(editProject);
		System.out.println("""
				
				1 - EDIT PROJECT DETAILS
				2 - EDIT ARCHITECT DETAILS
				3 - EDIT CONTRACTOR DETAILS
				4 - EDIT CUSTOMER DETAILS
				""");
		
		String editChoice = input.nextLine().toUpperCase();
		
		if(editChoice.equals("1")) {
			System.out.println(editProject.getProject());
			projectEditor(editNum);
		}
		
		if(editChoice.equals("2")) {
			System.out.println(editProject.getArchitect());
			architectEditor(editNum);
		}
		
		if(editChoice.equals("3")) {
			System.out.println(editProject.getContractor());
			contractorEditor(editNum);
		}
		
		if(editChoice.equals("4")) {
			System.out.println(editProject.getCustomer());
			customerEditor(editNum);
		}
		}
	}
		
	/**
	 * Method to change the details of a Project Object,
	 * specifying the number of the project to be changed.
	 * <br>
	 * This method changes the details of a specified Project Object, replaces the new details in the 
	 * specified lists and re-writes the new information to the text file
	 * 
	 * @param num The number of the Project Object which needs to be edited
	 * 
	 * @see edit()
	 * 
	 */
	public static void projectEditor(int num) {
		
		Project project = (Project) projects.get(num-1);
		Building building = (Building) project.getBuilding();

				System.out.println("""
						
						1 - EDIT BUILDING TYPE
						2 - EDIT DEADLINE
						3 - EDIT TOTAL FEE
						4 - EDIT TOTAL PAID
						""");
				String editProj = input.nextLine();
				
		if(editProj.equals("1")) {
			System.out.println("PLEASE ENTER THE NEW BUILDING TYPE:");
			String newType = input.nextLine();
			newType = emptyCheck(newType);
			
			building.setBuildingType(newType);
		}
			
		if(editProj.equals("2")) {
			System.out.println("PLEASE ENTER THE NEW DEALINE(YYYY-MM-DD):");
			String newProjDeadline = input.nextLine();
			newProjDeadline = dateCheck(newProjDeadline);
			
			building.setDeadline(LocalDate.parse(newProjDeadline));
		}
		
		if(editProj.equals("3")) {
			System.out.println("PLEASE ENTER THE NEW TOTAL FEE:");
			String newProjFee = input.nextLine();
			newProjFee = doubleCheck(newProjFee);
			
			building.setTotalFee(Double.parseDouble(newProjFee));
		}
		
		if(editProj.equals("4")) {
			System.out.println("PLEASE ENTER THE NEW TOTAL AMOUNT PAID:");
			String newProjPaid = input.nextLine();
			newProjPaid = doubleCheck(newProjPaid);
			
			building.setTotalPaid(Double.parseDouble(newProjPaid));
		}
		
		System.out.println("""
				
				CONFIRM CHANGE:
				CHANGE PROJECT DETAILS TO:
				""" + project.getProject() + CONFIRM
				);
		String projectChoice = input.nextLine().toUpperCase();
		
		if(projectChoice.equals("Y")) {
			projectsToTextFile.set(num - 1, project.toTextFile());
			
			try (FileWriter fileWriter = new FileWriter(TEXT_FILE);
					Formatter formatter = new Formatter(fileWriter);) {
				
				formatter.format("%s", printArrayList(projectsToTextFile));
				System.out.println("PROJECT EDITED SUCCESSFULLY");
				
			} catch (Exception error) {
				System.out.println(ERROR);
			}
		}
	}
			
	/**
	 * Method to change the details of a Person Object type 'Architect',
	 * specifying the number of the project to be changed.
	 * <br>
	 * This method changes the details of a specified Person Object, replaces the new details in the 
	 * specified lists and re-writes the new information to the text file
	 * 
	 * @param num The number of the Project Object which needs to be edited
	 *  
	 * @see edit()
	 * 
	 */
	public static void architectEditor(int num) {
		
		Project project = (Project) projects.get(num-1);
		Person architect = (Person) project.getArchitect();
		
		System.out.println("""
					
					1 - EDIT ARCHITECT FIRST NAME
					2 - EDIT ARCHITECT LAST NAME
					3 - EDIT ARCHITECT TELEPHONE NUMBER
					4 - EDIT ARCHITECT EMAIL ADDRESS
					5 - EDIT ARCHITECT PHYSICAL ADDRESS
					""");
		String editArc = input.nextLine();
		
		if(editArc.equals("1")) {
			System.out.println("PLEASE ENTER THE ARCHITECT'S FIRST NAME:");
			String newArcFirst = input.nextLine();
			newArcFirst = emptyCheck(newArcFirst);
			
			architect.setFirstName(newArcFirst);
		}
		
		if(editArc.equals("2")) {
			System.out.println("PLEASE ENTER THE ARCHITECT'S LAST NAME:");
			String newArcLast = input.nextLine();
			newArcLast = emptyCheck(newArcLast);
			
			architect.setLastName(newArcLast);
		}
	
		if(editArc.equals("3")) {
			System.out.println(ENTER_ARC + TEL +":");
			String newArcTel = input.nextLine();
			newArcTel = emptyCheck(newArcTel);
			
			architect.setTelNum(newArcTel);
		}
				
		if(editArc.equals("4")) {
			System.out.println(ENTER_ARC + EMAIL + ":");
			String newArcEmail = input.nextLine();
			newArcEmail = emptyCheck(newArcEmail);
			
			architect.setEmail(newArcEmail);
		}
			
		if(editArc.equals("5")) {
			System.out.println(ENTER_ARC + ADDRESS + ":");
			String newArcAdd = input.nextLine();
			newArcAdd = emptyCheck(newArcAdd);
		
			architect.setAddress(newArcAdd);
		}
		
		System.out.println("""
				
				CONFIRM CHANGE:
				CHANGE ARCHITECT DETAILS TO:
				""" + project.getArchitect() + CONFIRM
				);
		String arcChoice = input.nextLine().toUpperCase();
		
		if(arcChoice.equals("Y")) {
			projectsToTextFile.set(num - 1, project.toTextFile());
			
			try (FileWriter fileWriter = new FileWriter(TEXT_FILE);
					Formatter formatter = new Formatter(fileWriter);) {
				
				formatter.format("%s", printArrayList(projectsToTextFile));
				System.out.println("ARCHITECT EDITED SUCCESSFULLY");
				
			} catch (Exception error) {
				System.out.println(ERROR);
			}
		}
	}
		
	/**
	 * Method to change the details of a Person Object type 'Contractor', 
	 * specifying the number of the project to be changed.
	 * <br>
	 * This method changes the details of a specified Person Object, replaces the new details in the 
	 * specified lists and re-writes the new information to the text file
	 * 
	 * @param num The number of the Project Object which needs to be edited
	 *  
	 * @see edit()
	 * 
	 */
	public static void contractorEditor(int num) {
		
		Project project = (Project) projects.get(num-1);
		Person contractor = (Person) project.getContractor();
		
		System.out.println("""
					
					1 - EDIT CONTRACTOR FIRST NAME
					2 - EDIT CONTRACTOR LAST NAME
					3 - EDIT CONTRACTOR TELEPHONE NUMBER
					4 - EDIT CONTRACTOR EMAIL ADDRESS
					5 - EDIT CONTRACTOR PHYSICAL ADDRESS
					""");
		String editCon = input.nextLine();
		
		if(editCon.equals("1")) {
			System.out.println("PLEASE ENTER THE CONTRACTOR'S FIRST NAME:");
			String newConFirst = input.nextLine();
			newConFirst = emptyCheck(newConFirst);
			
			contractor.setFirstName(newConFirst);
		}
		
		if(editCon.equals("2")) {
			System.out.println("PLEASE ENTER THE CONTRACTOR'S LAST NAME:");
			String newConLast = input.nextLine();
			newConLast = emptyCheck(newConLast);
			
			contractor.setLastName(newConLast);
		}

		if(editCon.equals("3")) {
			System.out.println(ENTER_CON + TEL +":");
			String newConTel = input.nextLine();
			newConTel = emptyCheck(newConTel);
			
			contractor.setTelNum(newConTel);
		}
		
		if(editCon.equals("4")) {
			System.out.println(ENTER_CON + EMAIL + ":");
			String newConEmail = input.nextLine();
			newConEmail = emptyCheck(newConEmail);
			
			contractor.setEmail(newConEmail);
		}
	
		if(editCon.equals("5")) {
			System.out.println(ENTER_CON + ADDRESS + ":");
			String newConAdd = input.nextLine();
			newConAdd = emptyCheck(newConAdd);
			
			contractor.setAddress(newConAdd);
		}
		
		System.out.println("""
				
				CONFIRM CHANGE:
				CHANGE CONTRACTOR DETAILS TO:
				""" + project.getContractor() + CONFIRM
				);
		String conChoice = input.nextLine().toUpperCase();
		
		if(conChoice.equals("Y")) {
			projectsToTextFile.set(num - 1, project.toTextFile());
			
			try (FileWriter fileWriter = new FileWriter(TEXT_FILE);
					Formatter formatter = new Formatter(fileWriter);) {
				
				formatter.format("%s", printArrayList(projectsToTextFile));
				System.out.println("CONTRACTOR EDITED SUCCESSFULLY");
				
			} catch (Exception error) {
				System.out.println(ERROR);
			}
		}
	}

	/**
	 * Method to change the details of a Person Object type 'Customer', 
	 * specifying the number of the project to be changed.
	 * <br>
	 * This method changes the details of a specified Person Object, replaces the new details in the 
	 * specified lists and re-writes the new information to the text file
	 * 
	 * @param num The number of the Project Object which needs to be edited
	 * 
	 * @see edit() 
	 */
	public static void customerEditor(int num) {
		
		Project project = (Project) projects.get(num-1);
		Person customer = (Person) project.getCustomer();
		
		System.out.println("""
					
					1 - EDIT CUSTOMER FIRST NAME
					2 - EDIT CUSTOMER LAST NAME
					3 - EDIT CUSTOMER TELEPHONE NUMBER
					4 - EDIT CUSTOMER EMAIL ADDRESS
					5 - EDIT CUSTOMER PHYSICAL ADDRESS
					""");
		String editCust = input.nextLine();
		
		if(editCust.equals("1")) {
			System.out.println("PLEASE ENTER THE CUSTOMER'S FIRST NAME:");
			String newCustFirst = input.nextLine();
			newCustFirst = emptyCheck(newCustFirst);
			
			customer.setFirstName(newCustFirst);
		}
		
		if(editCust.equals("2")) {
			System.out.println("PLEASE ENTER THE CUSTOMER'S LAST NAME:");
			String newCustLast = input.nextLine();
			newCustLast = emptyCheck(newCustLast);
			
			customer.setLastName(newCustLast);
		}
		
		if(editCust.equals("3")) {
			System.out.println(ENTER_CUST + TEL);
			String newCustTel = input.nextLine();
			newCustTel = emptyCheck(newCustTel);
			
			customer.setTelNum(newCustTel);
		}
	
		if(editCust.equals("4")) {
			System.out.println(ENTER_CUST + EMAIL + ":");
			String newCustEmail = input.nextLine();
			newCustEmail = emptyCheck(newCustEmail);
			
			customer.setEmail(newCustEmail);
		}

		if(editCust.equals("5")) {
			System.out.println(ENTER_CUST + ADDRESS + ":");
			String newCustAdd = input.nextLine();
			newCustAdd = emptyCheck(newCustAdd);
			
			customer.setAddress(newCustAdd);
		}
		
		System.out.println("""
				
				CONFIRM CHANGE:
				CHANGE CUSTOMER DETAILS TO:
				""" + project.getCustomer() + CONFIRM
				);
		String custChoice = input.nextLine().toUpperCase();
		
		if(custChoice.equals("Y")) {
			projectsToTextFile.set(num - 1, project.toTextFile());
			
			try (FileWriter fileWriter = new FileWriter(TEXT_FILE);
					Formatter formatter = new Formatter(fileWriter);) {
				
				formatter.format("%s", printArrayList(projectsToTextFile));
				System.out.println("CUSTOMER EDITED SUCCESSFULLY");
				
			} catch (Exception error) {
				System.out.println(ERROR);
			}
		}
	}

	/**
	 * Method to finalise a Project Object.
	 * <br>
	 * This method adds a completion date to a specified Project Object, replaces the new details in the 
	 * specified lists and re-writes the new information to the text file 
	 *
	 * @see createInvoice
	 */
	public static void finaliseProject() {
		
		if(projects.isEmpty()) {
			System.out.println("THERE ARE NO PROJECTS AVAILABLE TO FINALISE, PLEASE ADD A PROJECT FIRST");
			
		} else {
			System.out.println("""
			PLEASE ENTER THE NUMBER OF THE PROJECT YOU WOULD LIKE TO FINALISE:
				
			""" + printArrayList(incompleteProjects));
			int finNum = intInput.nextInt();
			
			Project project = (Project)projects.get(finNum -1);
			
			if("No".equals(project.getComplete())) {
				
				System.out.println("\nPLEASE ENTER THE COMPLETION DATE OF THE PROJECT:(YYYY-MM-DD):");
				String compDate = input.nextLine();
		
				Person customer = (Person)project.getCustomer();
				Building building = (Building)project.getBuilding();
		
				double totalFee = building.getTotalFee();
				double totalPaid = building.getTotalPaid();
				double balanceDue = totalFee - totalPaid;
				int invoice = completeProjects.size() +1;
		
				StringBuilder invoiceNum = new StringBuilder();
				invoiceNum.append(" 00" + invoice);
		
				project.setComplete("Yes " + compDate);
		
				System.out.println("""
				
					CONFIRM CHANGE:
					FINALISE PROJECT""" + " " + finNum + CONFIRM
					);
				String finChoice = input.nextLine().toUpperCase();
		
				if (finChoice.equals("Y")) {
					projectsToTextFile.set(finNum - 1, project.toTextFile());
			
					try (FileWriter fileWriter = new FileWriter(TEXT_FILE);
							Formatter formatter = new Formatter(fileWriter);) {
						
						formatter.format("%s", printArrayList(projectsToTextFile));
						System.out.println("PROJECT FINALISED SUCCESSFULLY!");
					
						createInvoice(invoiceNum.toString(), balanceDue, customer);
						
					} catch (Exception error) {
						System.out.println("ERROR! FAILED TP FINALISE PROJECT");
					}
				}
				
			} else {
				System.out.println(PRO + finNum + " CANNOT BE EDITED, AS IT IS ALREADY COMPLETE\n");
				finaliseProject();
			}
		}
	}
	
	/**
	 * Method to create a Tax Invoice in the form of text file,
	 * specifying the name of the invoice, the balance due and the customer.
	 * <br>
	 * This method creates a text file with an invoice number, which includes the customer's details
	 * and amount payable 
	 * 
	 * @param name The invoice number 
	 * @param balance The amount payable
	 * @param customer The customer's details 
	 * 
	 * @see finaliseProject()
	 */
	public static void createInvoice (String name, double balance, Object customer) {
		
		if (balance > 0) {
			System.out.println ("THERE IS AN OUTSTANDING BALANCE ON THIS PROJECT OF R" + balance);
			
			try (FileWriter fileWriter = new FileWriter("Invoice" + name + ".txt", true);
					Formatter formatter = new Formatter(fileWriter);) {
				
				formatter.format("%s", "\t\t\tTAX INVOICE\n\n");
				formatter.format("%s", "DATE:\t" + today + "\t\t\tINVOICE NUMBER:\t" + name + "\n\n");
				formatter.format("%s", "INVOICE FROM:\nPOSIED PROJECT MANAGEMENT\n\nINVOICE TO:\n");
				formatter.format("%s", customer.toString()+"\n\n\nAMOUNT PAYABLE:\t\t\t\tR" + balance);
			
				System.out.println ("INVOICE" + name + " HAS BEEN GENERATED");
				
			} catch (Exception error) {
				System.out.println ("ERROR! FAILED TO CREATE INVOICE");
			}
		}
	}
		
	/**
	 * Method to view a list of Project Objects,
	 * according to specified conditions.
	 * <br>
	 * This method allows the user to choose which list they would like to view
	 */
	public static void viewProjectList() {
		
		if(projects.isEmpty()) {
			System.out.println("THERE ARE NO PROJECTS AVAILABLE TO VIEW, PLEASE ADD A PROJECT FIRST");
			
		} else {
			System.out.println("""
				
				1 - VIEW ALL PROJECTS
				2 - VIEW COMPLETED PROJECTS
				3 - VIEW INCOMPLETE PROJECTS
				4 - VIEW OVERDUE PROJECTS
				
				""");
			String viewChoice = input.nextLine().toUpperCase();
			
			if(viewChoice.equals("1")) {
				System.out.println(printArrayList(allProjects));
				viewFullProject();
			}
				
			if(viewChoice.equals("2")) {
				System.out.println(printArrayList(completeProjects));
				viewFullProject();
			}
			
			if(viewChoice.equals("3")) {
				System.out.println(printArrayList(incompleteProjects));
				viewFullProject();
			}
			
			if(viewChoice.equals("4")) {
				System.out.println(printArrayList(overdueProjects));
				viewFullProject();
			}
		}
	}
				
	/**
	 * Method to view all the details of a specified Project Object.
	 * <br>
	 * This method allows the user to choose a Project number and view all
	 * the details for that Project Object 
	 */
	public static void viewFullProject() {
		
		System.out.println("""
				
				ENTER THE PROJECT NUMBER TO VIEW THE FULL PROJECT
				ENTER M TO RETURN TO THE MAIN MENU:
				""");
		String view = input.nextLine().toUpperCase();
		
		if (!"M".equals(view)) {
			view = intCheck(view);
			int viewInt = Integer.parseInt(view);
			System.out.println(projects.get(viewInt - 1));
		}
	}
		
	/**
	 * Method to find a specified Project Object.
	 * <br>
	 * This method allows the user to enter either a project number,
	 * or name and see a list of all the projects containing that number or name
	 */
	public static void search() {
		
		if(projects.isEmpty()) {
			System.out.println("THERE ARE NO PROJECTS AVAILABLE TO SEARCH, PLEASE ADD A PROJECT FIRST");
			
		} else {
			System.out.println("PLEASE ENTER A PROJECT NAME OR NUMBER:\n");
			String searchInput = input.nextLine().toUpperCase();
		
			File file = new File(TEXT_FILE);
			
			try(Scanner scanner = new Scanner(file);) {
				while (scanner.hasNextLine()) {
					String nextLine = scanner.nextLine();
					String [] findDetails = nextLine.split(", ");
				
					if (findDetails[0].contains(searchInput)||findDetails[22].toUpperCase().contains(searchInput)) {
						searchList.add(PRO + findDetails[0] + " " + findDetails[22] + "\n");
					}
				}
				
				System.out.println(printArrayList(searchList));
				viewFullProject();
				
			} catch (Exception e) {
				System.out.println("Error in search");
			}
		}
	}
		
	/**
	 * Method to check if a specified input is in the correct Integer format,
	 * specifying a String to be checked.
	 * <br>
	 * @param num The input to be checked
	 * 
	 * @return True or False
	 */
	public static boolean isInt(String num) {
		
		try {
			Integer.parseInt(num);
	        return true;
	        
		} catch (NumberFormatException error) {
			return false;
		}
	}

	/**
	 * Method to check if a specified input is in the correct double format,
	 * specifying a string to be checked
	 * <br>
	 * @param num The input to be checked 
	 * 
	 * @return True or False
	 */
	public static boolean isDouble(String num) {
		
		try {
			Double.parseDouble(num);
			return true;
			
		} catch (NumberFormatException error) {
			return false;
		}
	}
	
	/**
	 * Method to check if a specified input is in the correct date format,
	 * specifying a string to be checked.
	 * <br>
	 * @param date The input to be checked
	 * 
	 * @return True or False
	 */
	public static boolean isDate(String date) {
		
		try {
			LocalDate.parse(date);
			return true;
			
		} catch (DateTimeParseException error) {
			return false;
		}
	}
	
	/**
	 * Method to print an ArrayList to the screen in a specified format,
	 * specifying the ArrayList to be printed.
	 * <br>
	 * 
	 * @param arrayList The ArrayList to be printed
	 * 
	 * @return The ArrayList in the specified format
	 */
	public static String printArrayList (List<String> arrayList) {
		
		String formattedString = arrayList.toString();
		formattedString = formattedString.replace(", \n", "\n");
		formattedString = formattedString.replace("[", "");
		formattedString = formattedString.replace("]", "");
		formattedString = formattedString.replace(", ", "");
		formattedString = formattedString.trim();
		
		return formattedString;
	}
	
	/**
	 * Method to continuously request a new input, while an input is empty
	 * specifying a string to be checked
	 * <br>
	 * @param variable The input to be checked
	 * 
	 * @return The input when is it in the correct format (not empty) 
	 */
	public static String emptyCheck (String variable) {
		
		while (variable.isEmpty()) {
			System.out.println(INPUT_REQUIRED);
			variable = input.nextLine();
		}
		return variable;
	}
	
	/**
	 * Method to continuously request a new input, while an input
	 * is not in the correct Integer format, specifying a string to be checked
	 * 
	 * @param num The input to be checked
	 * 
	 * @see isInt
	 * 
	 * @return The input when it is in the correct format
	 */
	public static String intCheck (String num) {
		
		while (!isInt(num)) {  
			System.out.println(INPUT_REQUIRED);
			num = input.nextLine();
		}
		
		return num;
	}
	
	/**
	 * Method to continuously request a new input, while an input 
	 * is not in the correct double format, specifying a string to be checked
	 * 
	 * @param num The input to be checked
	 * 
	 * @see isDouble
	 * 
	 * @return The input when is in the correct format 
	 */
	public static String doubleCheck (String num) {
		
		while (!isDouble(num)) {
			System.out.println(INPUT_REQUIRED);
			num = input.nextLine();
		}
		
		return num;
	}
	
	/**
	 * Method to continuously request a new input, while an input 
	 * is not in the correct date format, specifying a string to be checked
	 * 
	 * @param date The input to be checked
	 *
	 * @see isDate
	 * 
	 * @return The input when is in the correct format 
	 */
	public static String dateCheck (String date) {
		
		while (!isDate(date)) {
			System.out.println(INPUT_REQUIRED);
			date = input.nextLine();
		}
		
		return date;
	}
}