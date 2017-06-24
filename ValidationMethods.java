/*
 * author Keilah Soares
 * 
 * Class that contains all the validation methods for the program
 */

// import relevant packages / classes
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Class ValidationMethods
public class ValidationMethods {
	// declare global variable
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
// Method that check if input from user is only letters and shows error messages in case input is something else (ex: numbers)
public static String getOnlyLetters(String lineMessage ){
	boolean check = true;
	String letters = "";
	//loop that will check if the input from user are letters
	do{
		check = true;
		System.out.print(lineMessage);
		try {
			letters = br.readLine();
		} catch (IOException  | StringIndexOutOfBoundsException e) {
			System.out.println("Error getting letters");
		}
		//condition that runs through the size of letters and change check value to false
		for (int l = 0; l < letters.length(); l++){
			if((((int)letters.charAt(l) < 65) || ((int)letters.charAt(l) > 90) ) &&
			   (((int)letters.charAt(l) < 97) || ((int)letters.charAt(l) > 122)))
				check = false;
		}
		if (check == false)
			System.out.println("Invalid input! Try again!");
	// loop runs while check == false
	} while (check == false);
	return letters;
}
// Method that check if the email is a valid one, shows error message in case the format is wrong
public static String getEmail(String lineMessage ){
	boolean check = true;
	String letters = "";
	// loop that will check the email format
	do{
		check = true;
		System.out.print(lineMessage);
		try {
			letters = br.readLine();
		} catch (IOException e) {
			System.out.println("Error getting email");
		}
		for (int l = 0; l < letters.length(); l++){
			if((((int)letters.charAt(l) < 65) || ((int)letters.charAt(l) > 90) ) && /* A - Z */
			   (((int)letters.charAt(l) < 97) || ((int)letters.charAt(l) > 122)) && /* a - z */
			   ((int)letters.charAt(l) != 46) && /* . */
			   ((int)letters.charAt(l) != 64))   /* @ */
				check=false;
		}
		if (check == false)
			System.out.println("Invalid input! Try again!");
		else {
			if( ! letters.contains("@")) {
				System.out.println("Invalid format, please enter email");
				check = false;
			}
			else if(! letters.contains(".")){
				System.out.println("Invalid format, please enter email");
				check = false;
			}
			else if( letters.indexOf("@") > letters.indexOf(".") ){
				System.out.println("Invalid format, please enter email");
			}
		}
	// loop runs while check == false	
	} while (check == false);
	return letters;
}	

// Method that check is the field is empty, show error message in case it is	
public static boolean emptyField( String fieldValue ){
	boolean check = false;
	
	//String[] empty = new String[4];
	// loop through a students in the list
		if ( fieldValue.isEmpty() )
		{
			check = true;
			System.out.println();
			System.out.println("The field is empty, please enter input.");
			System.out.println();
		}	

	return check;
}

// Method that checks if the id is in the list. If it is return "true"
public static boolean checkID( int id, ArrayList<Student> list )
{
	boolean check = false;
	
	// loop that runs the list looking for the id
	for ( int x = 0; x < list.size() ; x++ )
	{	
		if ( list.get(x).getId() == id )
			{
				check = true;
			}	
	}
	return check;
}

// Method that checks phone number
public static String getPhone(String lineMessage ){
	boolean flag = true;
	String letters = "";
	//loop that will run the program to check phone number and treat exceptions if there's any error
	do{
		flag = true;
		System.out.print(lineMessage);
		try {
			letters = br.readLine();
			if(letters.length()!= 9){
				flag = false;
			}
			for (int l = 0; l < letters.length(); l++){
				Integer.parseInt(String.valueOf( letters.charAt(l) ) );
			}
		} catch (IOException e) {
		} catch( NumberFormatException nfe){
			flag=false;
		}
		//condition that shows message in case input from user is in the wrong format
		if (flag==false)
			System.out.println("Invalid input! Please enter a valid phone number (9 digits - numbers only).");
	} 
	//condition that will run the loop while flag is false
	while (flag == false);
	return letters;
}

}
