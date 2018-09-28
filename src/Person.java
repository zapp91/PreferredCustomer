//Written By: Royce Duncan, 9/27/2018

public class Person {

	private String fName;
	private String lName;
	private String address;
	private String phone;
	
	/**
	 * @param fName
	 * @param lName
	 * @param address
	 * @param phone
	 */
	public Person(String fName, String lName, String address, String phone) {
		this.fName = fName;
		this.lName = lName;
		this.address = address;
		this.phone = phone;
	}

	//getters
	public String getFName() {
		return fName;
	}
	
	public String getLName() {
		return fName;
	}

	public String getAddress() {
		return address;
	}
	
	public String getPhone() {
		return phone;
	}
	
	//setters
	public void setFName(String fName) {
		this.fName = fName;
	}
	
	public void setLName(String lName) {
		this.lName = lName;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
