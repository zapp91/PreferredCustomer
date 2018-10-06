//Written By: Royce Duncan, 9/27/2018

public class Customer extends Person {
	
	private int cusNum;
	private boolean mailList;
	
	public Customer(String fName, String lName, String streetAddress, String city, String state, int zip, long phone, int cusNum, boolean mailList) {
		super(fName, lName, streetAddress, city, state, zip, phone);
		this.cusNum = cusNum;
		this.mailList = mailList;
	}

	//getters
	public int getCusNum() {
		return cusNum;
	}

	public boolean isMailList() {
		return mailList;
	}

	//setters
	public void setCusNum(int cusNum) {
		this.cusNum = cusNum;
	}
	public void setMailList(boolean mailList) {
		this.mailList = mailList;
	}
	
}
