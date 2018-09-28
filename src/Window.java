//Written By: Royce Duncan, 9/27/2018

import javax.swing.*; 	//needed for Swing classes
import java.awt.*;		//needed for FlowLayout class

public class Window extends JFrame {
	
	private final int WINDOW_WIDTH = 300;
	private final int WINDOW_HEIGHT = 500;
	
	private String[] names = {"Royce", "Steve", "John"};

	public Window() {
		
		//set the title bar text
		setTitle("Check Out");
		
		//set the size of the window
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		
		//specify an action for the close button
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//add a BorderLayout manager to the content pane
		setLayout(new BorderLayout());
		
		//create regional panels
		JPanel northPanel = new JPanel();
		JPanel eastPanel = new JPanel();
		JPanel westPanel = new JPanel();
		
		eastPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		westPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		//create three buttons
		//JButton addNewCustomerButton = new JButton("Add New Customer");
		JButton payButton = new JButton("Pay");
		
		//create combo box
		JComboBox nameBox = new JComboBox(names);
		
		//create labels
		JLabel customerLabel = 			new JLabel("Customer ");
		JLabel currentSpentLabel = 		new JLabel("Current Spent ");
		JLabel currentDiscountLabel = 	new JLabel("Current Discount ");
		JLabel transactionAmountLabel = new JLabel("Transaction Amount ");
		JLabel amountDiscountedLabel =	new JLabel("Discounted ");
		JLabel pendingPaymentLabel = 	new JLabel("Pending Payment ");
		
		//create text fields
		JTextField currentSpentField = 		new JTextField(10);
		JTextField currentDiscountField = 	new JTextField(10);
		JTextField transactionAmountField = new JTextField(10);
		JTextField amountDiscountedField =	new JTextField(10);
		JTextField pendingPaymentField = 	new JTextField(10);
		
		//change some text fields to uneditable
		currentSpentField.setEditable(false);
		currentDiscountField.setEditable(false);
		amountDiscountedField.setEditable(false);
		pendingPaymentField.setEditable(false);
		
		//add west panel features
		//centerPanel.add(addNewCustomerButton);
		westPanel.add(customerLabel);
		westPanel.add(currentSpentLabel);
		westPanel.add(currentDiscountLabel);
		westPanel.add(transactionAmountLabel);
		westPanel.add(amountDiscountedLabel);
		westPanel.add(pendingPaymentLabel);
		
		//add east panel features
		eastPanel.add(nameBox);
		eastPanel.add(currentSpentField);
		eastPanel.add(currentDiscountField);
		eastPanel.add(transactionAmountField);
		eastPanel.add(amountDiscountedField);
		eastPanel.add(pendingPaymentField);
		//eastPanel.add(payButton);
		
		//add the three buttons to the content pane
		add(westPanel, BorderLayout.WEST);
		add(eastPanel, BorderLayout.EAST);
		
		//pack and display the window
		//pack();
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		
		new Window();
		
	}

}