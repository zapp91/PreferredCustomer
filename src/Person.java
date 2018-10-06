//Written By: Royce Duncan, 9/27/2018

public class Person {

	private String fName;
	private String lName;
	private String streetAddress;
	private String city;
	private String state;
	private int zip;
	private long phone;
	
	public Person(String fName, String lName, String streetAddress, String city, String state, int zip, long phone) {
		this.fName = fName;
		this.lName = lName;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone = phone;
	}

	//getters
	public String getFName() {
		return fName;
	}
	
	public String getLName() {
		return lName;
	}

	public String getStreetAddress() {
		return streetAddress;
	}
	
	public String city() {
		return city;
	}

	public String state() {
		return state;
	}
	
	public int zip() {
		return zip;
	}
	
	public long getPhone() {
		return phone;
	}
	
	//setters
	public void setFName(String fName) {
		this.fName = fName;
	}
	
	public void setLName(String lName) {
		this.lName = lName;
	}
	
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	
	public void setCity() {
		this.city = city;
	}

	public void setState() {
		this.state = state;
	}
	
	public void setZip() {
		this.zip = zip;
	}
	
	public void setPhone(long phone) {
		this.phone = phone;
	}
	
}
