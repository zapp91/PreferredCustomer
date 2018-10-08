//Written By: Royce Duncan, 9/27/2018

/**
 * @author Royce
 *	Class to create preferred customer objects
 */
public class PreferredCustomer extends Customer {

	//retains the amount the customer has spent
	private float amountSpent;
	
	/**
	 * @param fName				customer's first name
	 * @param lName				customer's last name
	 * @param streetAddress		customer's address
	 * @param city				customer's city
	 * @param state				customer's state
	 * @param zip				customer's zip
	 * @param phone				customer's phone
	 * @param cusNum			customer's number
	 * @param mailList			customer's mail listing preference
	 * @param amountSpent		customer's amount spent
	 */
	public PreferredCustomer(String fName, String lName, String streetAddress, String city, String state, int zip, long phone, int cusNum, boolean mailList, float amountSpent) {
		super(fName, lName, streetAddress, city, state, zip, phone, cusNum, mailList);
		this.amountSpent = amountSpent;
	}//end constructor

	/**
	 * @return the amount the customer has spent
	 */
	public float getAmountSpent() {
		return amountSpent;
	}//end getAmountSpent method
	
	/**
	 * @param amountSpent is the amount the customer has spent
	 */
	public void setAmountSpent(int amountSpent) {
		this.amountSpent = amountSpent;
	}//end setAmountSpent method
	
	/**
	 * @return the determined discount rate
	 */
	public float getDiscountRate() {
		if (amountSpent < 500) {		//if the amount spent is less than $500 then..
			return 0.0f;					//return a 0% discount
		}
		else if (amountSpent < 1000) {	//else if the amount spent is less than $1000 then..
			return 0.05f;					//return a 5% discount
		}
		else if (amountSpent < 1500) {	//else if the amount spent is less than $1500 then..
			return 0.06f;					//return a 6% discount
		}
		else if (amountSpent < 2000) {	//else if the amount spent is less than $2000 then..
			return 0.07f;					//return a 7% discount
		}
		else {							//else..
			return 0.10f;					//return a 10% discount
		} //end if else sequence
	}//end getDiscountRate method
	
	/**
	 * @param moneyPayed is the amount to add to amount spent
	 */
	public void addMoneySpent (float moneyPayed) {
		amountSpent += moneyPayed;
	}//end getAmountSpent method
}
