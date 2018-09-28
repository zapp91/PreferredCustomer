//Written By: Royce Duncan, 9/27/2018

public class Customer extends Person {
	
	private int cusNum;
	private boolean mailList;
	
	/**
	 * @param fName
	 * @param lName
	 * @param address
	 * @param phone
	 * @param cusNum
	 * @param mailList
	 */
	public Customer(String fName, String lName, String address, String phone, int cusNum, boolean mailList) {
		super(fName, lName, address, phone);
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
