//Written By: Royce Duncan, 9/27/2018

public class PreferredCustomer extends Customer {

	private float amountSpent;
	private int discountLevel;
	
	/**
	 * @param fName
	 * @param lName
	 * @param address
	 * @param phone
	 * @param cusNum
	 * @param mailList
	 * @param amountSpent
	 * @param discountLevel
	 */
	public PreferredCustomer(String fName, String lName, String address, String phone, int cusNum, boolean mailList, float amountSpent, int discountLevel) {
		super(fName, lName, address, phone, cusNum, mailList);
		this.amountSpent = amountSpent;
		this.discountLevel = discountLevel;
	}

	public float getAmountSpent() {
		return amountSpent;
	}

	public int getDiscountLevel() {
		return discountLevel;
	}
	
	public void setAmountSpent(int amountSpent) {
		this.amountSpent = amountSpent;
	}
	
	public void setDiscountLevel(int discountLevel) {
		this.discountLevel = discountLevel;
	}
	
}
