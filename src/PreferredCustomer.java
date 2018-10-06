//Written By: Royce Duncan, 9/27/2018

public class PreferredCustomer extends Customer {

	private float amountSpent;
	
	public PreferredCustomer(String fName, String lName, String streetAddress, String city, String state, int zip, long phone, int cusNum, boolean mailList, float amountSpent) {
		super(fName, lName, streetAddress, city, state, zip, phone, cusNum, mailList);
		this.amountSpent = amountSpent;
	}

	public float getAmountSpent() {
		return amountSpent;
	}
	
	public void setAmountSpent(int amountSpent) {
		this.amountSpent = amountSpent;
	}
	
	public float getDiscountRate() {
		if (amountSpent < 500) {
			return 0.0f;
		}
		else if (amountSpent < 1000) {
			return 0.05f;
		}
		else if (amountSpent < 1500) {
			return 0.06f;
		}
		else if (amountSpent < 2000) {
			return 0.07f;
		}
		else {
			return 0.10f;
		}
	}
	
	public void addMoneySpent (float moneyPayed) {
		amountSpent += moneyPayed;
	}
}
