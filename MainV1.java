/*
 * author Keilah Soares
 * 
 * Main Assignment - Main Program (MainV1)
 */

// import relevant packages / classes
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
// Class MainV1
public class MainV1 {
	// declare global variables

	// string that will receive the file
	static String filename = "Student.txt";
	// array list that will receive the data of the file Student.txt
	static ArrayList<Student> list = new ArrayList<Student>();
	// declare a new File object and pass the name of the file to it as a
	// parameter
	static File f = new File(filename);
	// declare a new FileReader
	static FileReader fr = null;
	// create a new BufferedReader to read input from user
	static BufferedReader br = new BufferedReader(new InputStreamReader(
			System.in));
	// Create an object if itself
	public static void main(String[] args) {
		new MainV1();
	}

	// Main program
	public MainV1() {
		// call methods
		readFile();
		showMenu();
	}// end of MainV1

	// Method to read the file (Student.txt)
	public void readFile() {

		FileReader fr = null;

		// Try and catch to find exceptions or errors when trying to read the file
		try {
			fr = new FileReader(f);
		} catch (FileNotFoundException e) {
			// Error message in case the file is missing
			System.out.println("Couldn't find File");
		}
		// Declare and create a BufferedReader object and pass in the FileReader object fr.
		BufferedReader br = new BufferedReader(fr);
		// declare a string to save each line of the file (Student.txt)
		String line;

		try {
			// Read first line
			line = br.readLine();
			// While line is not null keep reading
			while (line != null) {
				// Array of Strings that will break the data into smaller pieces to read 
				String[] data = line.split(";");
				// Create an Student object and set the value of the attributes (Id, last name, first name, email, mobile)
				Student s = new Student(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4]);
				// Add to the ArrayList 
				list.add(s);
				// Keep reading lines
				line = br.readLine();
			}
			// Close BufferedReader
			br.close();
			// Show error message if there is an error reading the file
		} catch (IOException ioe) {
			System.out.println("*** Error reading file *** ");
		}
		// print an empty line
		System.out.println();
	}// end of method readFile
	// Method to show the main menu
	public void showMenu() {
		// String that will receive input from user
		String input = " ";
		// loop that will print the main menu on the screen until the user press "x" to go out of program
		do {
			// print the menu on the screen
			System.out.println("***** Student Records Management System ******");
			System.out.println("| a - Add new Student                        |");                  
			System.out.println("| b - Search for a Student                   |");             
			System.out.println("| c - Display details of a Student           |");
			System.out.println("| d - Modify details of a Student            |");
			System.out.println("| e - Delete a Student                       |");
			System.out.println("| x - Exit Program                           |");
			System.out.println("**********************************************");

			// print "Please choose one option: " on the screen
			System.out.print("Please choose one option: ");
			System.out.println();
			// Try to get errors / exceptions
			try {
				// String receive the input from user
				input = br.readLine();
				// Show message in case there's an error
			} catch (IOException e) {
				System.out.println("Something went wrong..! ");
			}

			// condition switch case to add student in case input is 'a' 
			switch (input) {
			// call methods according to the option chosen by user
			case "a":
				addNewStudent();
				break;
			// condition switch case to search student case input is 'b'
			case "b":
				searchStudent();
				break;
			// condition switch case to display student case input is 'c'
			case "c":
				displayStudent();
				break;
			// condition switch case to modify student case input is 'd'
			case "d":
				modifyStudent();
				break;
			// condition switch case to delete student case input is 'e'
			case "e":
				deleteStudent();
				break;
			// condition switch case to exit program case input is 'x'
			// show message on the screen and write the information on the file
			case "x":
				System.out.println("*** Thank you for using SRMS - Student Records Management System ***");
				writeFile();
				break;
			// if the option is not valid shows an error message
			default:
				// empty line
				System.out.println();

				// display error message and asks user to enter a new option
				System.out.println();
				System.out.println("*** NOT a valid option ! Please try again ! ***");

				// blank line
				System.out.println();
				break;
			}// end of switch
			// program runs until the user press the "x"
		} while (! input.equalsIgnoreCase("x"));
	}// end of method show menu
	// Method that will write data on the file (Student.txt)
	public void writeFile() {
		// creates a new file f 
		File f = new File(filename);
		FileWriter fw = null;
		// Try to write to the file
		try {
			// write to the file
			fw = new FileWriter(f); 
			// show message if there's an error creating the file
		} catch (IOException e) {
			System.out.println("*** Error creating file *** ");
		}
		// creates a new BufferedWriter bw
		BufferedWriter bw = new BufferedWriter(fw);
		// Try to write data to the file line by line
		try {
			// loop that will run the array list "list"
			for (int x = 0; x < list.size(); x++) {
				//writes variables(values) to the file
				bw.write(list.get(x).getId() + ";"); 
				bw.write(list.get(x).getLastName() + ";");
				bw.write(list.get(x).getFirstName() + ";");
				bw.write(list.get(x).getEmail() + ";");
				bw.write(list.get(x).getMobile() + ";");

				bw.write(System.getProperty("line.separator"));
			}
			// show message in case there's an error writing to buffer
		} catch (IOException ioe) {
			System.out.println("*** Error writing to the buffer ***");
		}
		// Try to close BufferedWriter
		try {
			bw.close();
			// show message in case ther's an error closing BufferedWriter
		} catch (IOException e) {
			System.out.println("*** Error closing BufferedWriter ***");
		}
		// Try to close FileWriter
		try {
			fw.close();
			// show message in case there's an error closing FileWriter
		} catch (IOException e) {
			System.out.println("*** Error closing FileWriter ***");
		}
	}// end of method writeFile
	// Method to add new student 
	public void addNewStudent() {
		/* Method should get input from user
		 * add details to the list
		 * add details to the file */
		// declare variables
		int id = 0;
		String firstName = " ";
		String lastName = " ";
		String email = " ";
		String mobile = " ";
		String confirm = " ";
		// loop that will ask the user to input student data
		do {
		// Try to get input from user	
		try {
			// flag
			boolean flag = false;
			// loop that will validate the ID and check it already exists. 
			// if it does exist, show message and ask user to input new ID
			do{
				// show message asking user to input ID
				System.out.println("Please enter student ID (numbers only): ");
				System.out.println();
				// id receives the input from user and flag uses checkID method to check if ID already exists
				id = Integer.parseInt(br.readLine());
				flag = ValidationMethods.checkID(id,list);
				//condition if flag == true show message ID already exists
				if(flag == true){
					System.out.println();
					System.out.println("***** The ID already exists, please enter new ID *****");
					System.out.println();
				}
			// loop runs while flag == true	
			}while(flag == true);
						
			// loop that ask input from user, checks if the input are letters and if the field isn't blank
			do{
				firstName = ValidationMethods.getOnlyLetters("Please enter student first Name (letters only): ");
				ValidationMethods.emptyField(firstName);
			// while field is empty ask the user to input again	
			}while(firstName.isEmpty());
			
			// loop that ask input from user, checks if the input are letters and if the field isn't blank
			do{
				lastName = ValidationMethods.getOnlyLetters("Please enter student last Name (letters only): ");
				ValidationMethods.emptyField(lastName);
			// while field is empty ask the user to input again	
			}while(lastName.isEmpty());
			
			// loop that ask input from user, checks if the input is a valid email and if the field isn't blank
			do{
				email = ValidationMethods.getEmail("Please enter student email address: ");
				//ValidationMethods.emptyField(email);
				if( ValidationMethods.emptyField(email) )
					email="";
			// while field is empty ask the user to input again	
			}while(email.isEmpty());
			
			// loop that ask input from user, checks if the input is a valid number and if the field isn't blank
			do{
				//System.out.println("Please enter student mobile number (numbers only): ");
				mobile = ValidationMethods.getPhone("Please enter student mobile number (numbers only): ");
				ValidationMethods.emptyField(mobile);
				System.out.println();
			// while field is empty ask the user to input again	
			}while(mobile.isEmpty());
			do{	
				try {
					// Show message asking user to confirm input for the student
					System.out.println("Confirm informations for this student? Y/N");
					// confirm receive the input from user
					confirm = br.readLine();
				// catch exception and show message in case there's an error	
				} catch (IOException e) {
					System.out.println("*** Something went wrong *** ");
				}
				// condition in case user input is Y, delete the student from list
				if (confirm.equalsIgnoreCase("Y")) {
					// Create an Student object and set the value of the attributes
					Student s = new Student(id, lastName, firstName, email, mobile);
					// Add to the ArrayList (list)
					list.add(s);					// show message that student was removed successfully and an empty line
					System.out.println("****** Student added successfully !!! ******");
					System.out.println();
				}
			// loop runs while user input isn't Y or N	
			} while	( ! confirm.equalsIgnoreCase("Y") && ! confirm.equalsIgnoreCase("N") );	
			break;
		// Catch errors / exceptions	
		} catch (IOException  | NumberFormatException | StringIndexOutOfBoundsException e) {
			// show message if there's an error and ask the user to input data again
			System.out.println("***** Invalid input..! Please enter a valid format *****");
			System.out.println();
		}
		// while the condition is true prints an empty line and call method pressEnter()
		} while(true);
		System.out.println();
		pressEnter();
	}// end of method addNewStudent
	// Method to search Student
	public void searchStudent() {
		/* Program should search by student number or first name or last name
		 * search should display all students who meet the search*/
		// declare variables
		int id = 0;
		String firstName = " ";
		String lastName = " ";
		String input = " ";
		// Try to get input from user to refine search by Student Id, first name or last name
		try {
			System.out.println("Would you like to search by: ");
			System.out.println("****************************");
			System.out.println("| 1 - Student ID           |");
			System.out.println("| 2 - Student first Name   |");
			System.out.println("| 3 - Student last Name    |");
			System.out.println("****************************");
			input = br.readLine();
			// flag 
			boolean found = false;

			// condition switch case to add student case input is 'a'
			switch (input) {
			// ask user to input student details by id
			case "1":
				// ask input from user
				System.out.println("Please enter Student ID: ");
				System.out.println();
				try{
					id = Integer.parseInt(br.readLine());
					found = false;
					// ask user to input student details by ID
					for (Student s : list) {
						// if found the student that match the id shows it on the screen and change flag to true
						if ( String.valueOf(s.getId()).contains(String.valueOf(id))) {
							System.out.println(s);
							found = true;
						}
					}				
					// if id not found shows message "ID not found" and an empty line
					if (found == false) {
						System.out.println("***** ID not found *****");
						System.out.println();
					}
				// in case there are exceptions show error message	
				}catch(IOException | NumberFormatException nf){
					System.out.println("***** Invalid input, please try again *****");
					System.out.println();
				}	
				break;
			// ask user to input student details by first name	
			case "2":
				do{
					firstName = ValidationMethods.getOnlyLetters("Please enter student first Name: ");
					ValidationMethods.emptyField(firstName);
				// if field is empty ask the user to input again	
				}while(firstName.isEmpty());
				found = false;
				// loop that runs the list
				for (Student s : list) {
					// if found the student that match the first name shows it on the screen and change flag to true
					if (s.getFirstName().contains(firstName)) {
						System.out.println(s);
						found = true;
					}
				}
				// if id not found shows message "First name not found" and an empty line
				if (found == false) {
					System.out.println("***** First name not found *****");
					System.out.println();
				}
				break;
				// ask user to input student details by last name		
			case "3":
				do{
					lastName = ValidationMethods.getOnlyLetters("Please enter student last Name: ");
					ValidationMethods.emptyField(lastName);
				// if field is empty ask the user to input again	
				}while(lastName.isEmpty());
				found = false;
				//loop that runs the list
				for (Student s : list) {
					// if found the student that match the last name shows it on the screen and change flag to true
					if (s.getLastName().contains(lastName)) {
						System.out.println(s);
						found = true;
					}
				}
				// if id not found shows message "Last name not found" and an empty line
				if (found == false) {
					System.out.println("***** Last name not found *****");
					System.out.println();
				}
				break;
			// case that will display an error message in case input from user isn't valid 	
			default:
				// empty line
				System.out.println();
				// display error message and asks user to enter a new option
				System.out.println("***** NOT a valid option ! Please try again ! *****");
				// blank line
				System.out.println();
				break;
			}
		//catch exception and show message in case there's an error	
		} catch (IOException e) {
			System.out.println("*** Something went wrong..! ***");
		}
	}// end of method searchStudent
	// Method that will display student
	public void displayStudent() {
		// declare variables and give them values
		int input = 0;
		boolean f = false;
		do{	
			f = false;
			// display details of student by student number
			System.out.println("Please enter Student ID: ");
			try {
				// input receives user id
				input = Integer.parseInt(br.readLine());
				// flag
				boolean found = false;
				// loop that runs the list
				for (Student s : list) {
					// if id is in the list shows it on the screen and change flag to true
					if ( String.valueOf(s.getId()).contains(String.valueOf(input))) {
						System.out.println(s);
						found = true;
					}
				}
				// if id is not on the list show message "ID not found" and an empty line
				if (found == false) {
					System.out.println("***** ID not found *****");
					System.out.println();
				}
			// catch exception and show message in case there's an error	
			} catch (IOException | NumberFormatException nf) {
				// show message if there's an error and ask the user to input data again
				System.out.println("***** Ooops! Something went wrong, try again! *****");
				System.out.println();
				f = true;
			}
		} while( f );
	}// end of method displayStudent
	// Method to modify student
	public void modifyStudent() {
		/* Program should change details (lastName,firstName,email, mobile)except student number
		 * changes must be saved in the list and the file */
		// declare variables and give them values
		int input = 0;
		String data = " ";
		String firstName = " ";
		String lastName = " ";
		String email = " ";
		String mobile = " ";
		String confirm = " ";

		// display details of student by student number
		System.out.println("Please enter Student ID: ");
		// try to get id from user
		try {
			// input receives the id from user
			input = Integer.parseInt(br.readLine());
			//flag
			boolean found = false;
			// creates an object student std as null
			Student std = null;
			// loop that runs the list
			for (Student s : list) {
				// if id is on the list shows details of student and change flag to true
				if ( String.valueOf(s.getId()).contains(String.valueOf(input))) {
					//System.out.println(s);
					std = s;
					found = true;
				}
			}
			// if id is not on the list show message "ID not found" and an empty line
			if (found == false) {
				System.out.println("***** ID not found *****");
				System.out.println();
			// if ID is on the list	
			} else {
				// loop that will ask user to update student's info by: first name, last name, email or telephone number 
				// or back to main menu
				//information of first name, last name, email or telephone number will be saved in "case 5"
				
				firstName = std.getFirstName();
				lastName = std.getLastName();
				email = std.getEmail();
				mobile = std.getMobile();
				do{
					System.out.println("Student ID: " + std.getId() + "\n" +
							   		   "First Name: " + firstName + "\n" +
							   		   "Last Name: " + lastName + "\n" +
							   		   "E-mail: " + email + "\n" +
							   		   "Mobile: " + mobile + "\n");
					System.out.println("*****************************************");
					System.out.println("Please update student information by:    ");
					System.out.println("| 1 - Student first Name                 |");
					System.out.println("| 2 - Student last Name                  |");
					System.out.println("| 3 - Student email                      |");
					System.out.println("| 4 - Student mobile number              |");
					System.out.println("| 5 - Save changes & Return to Main Menu |");
					System.out.println("| 0 - Back to Main Menu                  |");
					System.out.println("*****************************************");
					data = br.readLine();
					found = false;

					// condition switch case to add student case input is 'a'
					switch (data) {
					// ask user to input student first name if option is 1
					case "1":
						do{
							firstName = ValidationMethods.getOnlyLetters("Please enter student first Name (letters only): ");
							ValidationMethods.emptyField(firstName);
						// if field is empty ask the user to input again	
						}while(firstName.isEmpty());
						System.out.println();
						break;
					// ask user to input student last name if option is 2	
					case "2":
						do{
							lastName = ValidationMethods.getOnlyLetters("Please enter student last Name (letters only): ");
							ValidationMethods.emptyField(lastName);
						// if field is empty ask the user to input again	
						}while(lastName.isEmpty());
						System.out.println();
						break;
					// ask user to input student email if option is 3	
					case "3":
						do{
							email = ValidationMethods.getEmail("Please enter Student email address: ");
							ValidationMethods.emptyField(email);	
						// if field is empty ask the user to input again	
						}while(email.isEmpty());
						System.out.println();
						break;
					// ask user to input student mobile if option is 4	
					case "4":
						do{
							mobile = ValidationMethods.getPhone("Please enter Student mobile number: ");
							ValidationMethods.emptyField(mobile);
						// if field is empty ask the user to input again	
						}while(mobile.isEmpty());
						System.out.println();
						break;
					case "5":
						do{
							System.out.println("Confirm update information? Y/N");
							try {
								// confirm receive the input from user
								confirm = br.readLine();
							// catch exception and show message in case there's an error	
							} catch (IOException e) {
								System.out.println("***** Something went wrong..! ***** ");
							}
							// condition in case user input is Y, delete the student from list
							if (confirm.equalsIgnoreCase("Y")) {
								/* if save (Y) */
								std.setFirstName(firstName);
								std.setLastName(lastName);
								std.setEmail(email);
								std.setMobile(mobile);
								// show message that student was removed successfully and an empty line
								System.out.println("Student updated successfully !!!");
								System.out.println();
							}
						// loop runs while confirm isn't Y or N	
						} while	( ! confirm.equalsIgnoreCase("Y") && ! confirm.equalsIgnoreCase("N") );	
						break;
					// if case is 0 go back to main menu	
					case "0":
						break;
					// case that will display an error message in case input from user isn't valid  	
					default:
						// empty line
						System.out.println();
						// display error message and asks user to enter a new option
						System.out.println("***** NOT a valid option ! Please try again ! *****");
						// blank line
						System.out.println();
						break;	
					}
				// run the loop until case is 0	
				}while(! data.equals("0") && ! data.equals("5"));
			}	
		// catch exception and show message in case there's an error	
		} catch (IOException | NumberFormatException nfe) {
			System.out.println("***** Invalid input..! Please try again *****");
			System.out.println();
		}
	}// end of method modifyStudent
	// Method to delete student
	public void deleteStudent() {
		/* Program should delete student by student number
		 * delete from list and file */
		// declare variables and give them values
		int input = 0;
		String confirm = " ";

		// display details of student by student number
		System.out.println("Please enter Student ID: ");
		// try to get student ID
		try {
			// input receives the id from user
			input = Integer.parseInt(br.readLine());
		// catch exception and show message in case there's an error	
		} catch (IOException | NumberFormatException nfe) {
			System.out.println("***** Something went wrong..! Please try again *****");
		}
		// flag
		boolean found = false;
		Student std = null;
		// loop that will run the list. If the id matches show the student and change flag to true
		for (Student s : list) {
			if (s.getId() == input) {
				System.out.println(s);
				std = s;
				found = true;
			}
		}
		// if id not found show message "ID not found" and an empty line
		if (found == false) {
			System.out.println("***** ID not found *****");
			System.out.println();
		// if student found show message asking user to confirm and delete the student	
		} else { 
			do{
				System.out.println("Delete this student? Y/N");
				try {
					// confirm receive the input from user
					confirm = br.readLine();
				// catch exception and show message in case there's an error	
				} catch (IOException e) {
					System.out.println("***** Something went wrong..! *****");
				}
				// condition in case user input is Y, delete the student from list
				if (confirm.equalsIgnoreCase("Y")) {
					list.remove(std);
					// show message that student was removed successfully and an empty line
					System.out.println("***** Student removed successfully !!! *****");
					System.out.println();
				}
			// loop runs while confirm isn't Y or N	
			} while	( ! confirm.equalsIgnoreCase("Y") && ! confirm.equalsIgnoreCase("N") );	
		}
		// call method pressEnter
		pressEnter();
	}// end of method deleteStudent
	// Method pressEnter
	public void pressEnter() {
		// try to press enter to continue
		try {
			System.out.print("Press <Enter> to continue ... ");
			br.readLine();
			System.out.println();
		// catch exception if there's an error	
		} catch (IOException ioe ) {
		}
	}// end of method pressEnter
}// end of class MainV1
