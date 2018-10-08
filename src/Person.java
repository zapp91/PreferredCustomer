//Written By: Royce Duncan, 9/27/2018

/**
 * @author Royce
 *	Class to create person objects
 */
public class Person {

	private String fName;			//person's first name
	private String lName;           //person's last name 
	private String streetAddress;   //person's address   
	private String city;            //person's city      
	private String state;           //person's state     
	private int zip;                //person's zip       
	private long phone;             //person's phone     
	
	/**
	 * @param fName           person's first name
	 * @param lName           person's last name 
	 * @param streetAddress   person's address   
	 * @param city            person's city      
	 * @param state           person's state     
	 * @param zip             person's zip       
	 * @param phone           person's phone     
	 */
	public Person(String fName, String lName, String streetAddress, String city, String state, int zip, long phone) {
		this.fName = fName;
		this.lName = lName;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone = phone;
	}//end constructor

	//getters
	/**
	 * @return person's first name
	 */
	public String getFName() {
		return fName;
	}//end getFName method
	
	/**
	 * @return  person's last name
	 */
	public String getLName() {
		return lName;
	}//end getLName method

	/**
	 * @return person's address 
	 */
	public String getStreetAddress() {
		return streetAddress;
	}//end getStreetAddress method
	
	/**
	 * @return person's city 
	 */
	public String getCity() {
		return city;
	}//end city method

	/**
	 * @return person's state
	 */
	public String getState() {
		return state;
	}//end state method
	
	/**
	 * @return person's zip
	 */
	public int getZip() {
		return zip;
	}//end zip method
	
	/**
	 * @return person's phone
	 */
	public long getPhone() {
		return phone;
	}//end getPhone method
	
	//setters
	/**
	 * @param fName is person's first name
	 */
	public void setFName(String fName) {
		this.fName = fName;
	}//end setFName method
	
	/**
	 * @param lName is person's last name
	 */
	public void setLName(String lName) {
		this.lName = lName;
	}//end setLName method
	
	/**
	 * @param streetAddress is person's address
	 */
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}//end setStreetAddress method
	
	/**
	 * @param city is person's city
	 */
	public void setCity(String city) {
		this.city = city;
	}//end setCity method

	/**
	 * @param state is person's state
	 */
	public void setState(String state) {
		this.state = state;
	}//end setState method
	
	/**
	 * @param zip is person's zip
	 */
	public void setZip(int zip) {
		this.zip = zip;
	}//end setZip method
	
	/**
	 * @param phone
	 */
	public void setPhone(long phone) {
		this.phone = phone;
	}//end setPhone method
}//end Person class
