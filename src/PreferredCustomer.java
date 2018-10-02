//Written By: Royce Duncan, 9/27/2018

public class PreferredCustomer extends Customer {

	private float amountSpent;
	
	/**
	 * @param fName
	 * @param lName
	 * @param address
	 * @param phone
	 * @param cusNum
	 * @param mailList
	 * @param amountSpent
	 */
	public PreferredCustomer(String fName, String lName, String address, String phone, int cusNum, boolean mailList, float amountSpent) {
		super(fName, lName, address, phone, cusNum, mailList);
		this.amountSpent = amountSpent;
	}

	public float getAmountSpent() {
		return amountSpent;
	}
	
	public void setAmountSpent(int amountSpent) {
		this.amountSpent = amountSpent;
	}
	
	public int getDiscountRate() {
		if (amountSpent < 500) {
			return 0;
		}
		else if (amountSpent < 1000) {
			return 5;
		}
		else if (amountSpent < 1500) {
			return 6;
		}
		else if (amountSpent < 2000) {
			return 7;
		}
		else {
			return 10;
		}
	}
}
