/*
 * author Keilah Soares
 *
 * Class that contains the student data, all getters and setters
 */
// Class Student
public class Student {
	
	//Student data
	//Student_number;Last_name;First_name;email_address;mobile_number
	
	//declare variables and give them values
	private int id;
	private String lastName;
	private String firstName;
	private String email;
	private String mobile;

	public Student(int id, String lastName, String firstName, String email, String mobile) {
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.mobile = mobile;
	}
	
	// setters and getters
	public void setId(int id){
		this.id = id;
	}
	public void setLastName(String lastName){
		this.lastName = lastName;		
	}
	public void setFirstName(String firstname){
		this.firstName = firstname;
	}
	public void setEmail(String email){
		this.email = email;
	}
	public void setMobile(String mobile){
		this.mobile = mobile;
	}
	public int getId(){
		return this.id;
	}
	public String getLastName(){
		return this.lastName;
	}
	public String getFirstName(){
		return this.firstName;
	}
	public String getEmail(){
		return this.email;
	}
	public String getMobile(){
		return this.mobile;
	}
	// class toString
	public String toString(){
		
		String s = "Student ID: " + this.id + "\n" +
				   "First Name: " + this.firstName + "\n" +
				   "Last Name: " + this.lastName + "\n" +
				   "E-mail: " + this.email + "\n" +
				   "Mobile: " + this.mobile + "\n";			   
		return s;
	}

}
