//Written By: Royce Duncan, 9/27/2018

/**
 * @author Royce
 *	Class to create customer objects 
 */
public class Customer extends Person {
	
	//retains the customers account number
	private int cusNum;
	
	//retains the customers mail list preference
	private boolean mailList;
	
	/**
	 * @param fName				customer's first name             
	 * @param lName             customer's last name              
	 * @param streetAddress     customer's address                
	 * @param city              customer's city                   
	 * @param state             customer's state                  
	 * @param zip               customer's zip                    
	 * @param phone             customer's phone                  
	 * @param cusNum            customer's number                 
	 * @param mailList          customer's mail listing preference
	 */
	public Customer(String fName, String lName, String streetAddress, String city, String state, int zip, long phone, int cusNum, boolean mailList) {
		super(fName, lName, streetAddress, city, state, zip, phone);
		this.cusNum = cusNum;
		this.mailList = mailList;
	} //end constructor

	//getters
	/**
	 * @return the customer's account number
	 */
	public int getCusNum() {
		return cusNum;
	} //end getCusNum method

	/**
	 * @return the customer's mail list preference
	 */
	public boolean isMailList() {
		return mailList;
	}//end isMailList method

	//setters
	/**
	 * @param cusNum is the customer's number
	 */
	public void setCusNum(int cusNum) {
		this.cusNum = cusNum;
	}//end setCusNum method
	/**
	 * @param mailList is the customer's mail list preference
	 */
	public void setMailList(boolean mailList) {
		this.mailList = mailList;
	}//end setMailList method
	
}
