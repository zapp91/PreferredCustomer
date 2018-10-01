//Written By: Royce Duncan, 9/27/2018

import javax.swing.*; 	//needed for Swing classes
import java.awt.*;		//needed for FlowLayout class
import java.awt.event.*;//needed for action listeners

public class Window extends JFrame {
	
	private final int WINDOW_WIDTH = 300;
	private final int WINDOW_HEIGHT = 370;
	
	private String[] names = {"Royce", "Steve", "John"};

	public Window() {
		
		//set the title bar text
		setTitle("Check Out");
		
		//set the size of the window
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		
		//setResizable(false);
		
		//specify an action for the close button
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//add a BorderLayout manager to the content pane
		setLayout(new FlowLayout(FlowLayout.CENTER));
		
		buildCheckout();
		
		//pack and display the window
		//pack();
		setVisible(true);
		
	}
	
	private void buildCheckout() {
		
		//create main panels
		JPanel topPanel = new JPanel();
		JPanel mainPanel = new JPanel();
		
		//create sub panels
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel();
		JPanel panel6 = new JPanel();
		JPanel panel7 = new JPanel();
		JPanel panel8 = new JPanel();
		
		//create three buttons
		JButton addNewCustomerButton = new JButton("Add New Customer");
		addNewCustomerButton.addActionListener(new addCusButtonListener());
		JButton payButton = new JButton("Pay");
		
		//create combo box
		JComboBox nameBox = new JComboBox(names);
		
		//create labels
		JLabel customerLabel = 			new JLabel("Customer ");
		JLabel currentSpentLabel = 		new JLabel("Current Spent $");
		JLabel currentDiscountLabel = 	new JLabel("Current Discount ");
		JLabel transactionAmountLabel = new JLabel("Transaction Amount $");
		JLabel amountDiscountedLabel =	new JLabel("Discounted $");
		JLabel pendingPaymentLabel = 	new JLabel("Pending Payment $");
		
		//create text fields
		JTextField currentSpentField = 		new JTextField(10);
		JTextField currentDiscountField = 	new JTextField(10);
		JTextField transactionAmountField = new JTextField(10);
		JTextField amountDiscountedField =	new JTextField(10);
		JTextField pendingPaymentField = 	new JTextField(10);
		
		//change component sizes
		nameBox.setPreferredSize(new Dimension(115, 25));
		
		//change some text fields to uneditable
		currentSpentField.setEditable(false);
		currentDiscountField.setEditable(false);
		amountDiscountedField.setEditable(false);
		pendingPaymentField.setEditable(false);
		
		//add main panel features
		panel1.add(addNewCustomerButton);
		
		panel2.add(customerLabel);
		panel2.add(nameBox);
		
		panel3.add(currentSpentLabel);
		panel3.add(currentSpentField);
		
		panel4.add(currentDiscountLabel);
		panel4.add(currentDiscountField);
		
		panel5.add(transactionAmountLabel);
		panel5.add(transactionAmountField);
		
		panel6.add(amountDiscountedLabel);
		panel6.add(amountDiscountedField);
		
		panel7.add(pendingPaymentLabel);
		panel7.add(pendingPaymentField);

		panel8.add(payButton);
		
		mainPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		mainPanel.setPreferredSize(new Dimension(260, 220));
		
		topPanel.add(panel1);
		mainPanel.add(panel2);
		mainPanel.add(panel3);
		mainPanel.add(panel4);
		mainPanel.add(panel5);
		mainPanel.add(panel6);
		mainPanel.add(panel7);
		
		add(topPanel);
		add(mainPanel);
		add(panel8);

	}
	
	private void buildAddCus() {
		
		//removeAll(); //or remove(JComponent)
		//revalidate();
		//repaint();
		
		//create main panel
		JPanel mainPanel = new JPanel();
		
		//create sub panels
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel();
		JPanel panel6 = new JPanel();
		JPanel panel7 = new JPanel();
		JPanel panel8 = new JPanel();
		
		//create labels
		JLabel firstNameLabel = new JLabel("First Name ");
		JLabel lastNameLabel = 	new JLabel("Last Name ");
		JLabel addressLabel = 	new JLabel("Address ");
		JLabel phoneLabel = 	new JLabel("Phone ");
		JLabel spentLabel =		new JLabel("Money Spent ");
		JLabel mailListLabel = 	new JLabel("Mail List ");
		
		//create text fields
		JTextField firstNameField = new JTextField(10);
		JTextField lastNameField = 	new JTextField(10);
		JTextField addressField = 	new JTextField(10);
		JTextField phoneField =		new JTextField(10);
		JTextField spentField = 	new JTextField(10);
		
		//create three buttons
		JButton clearButton = new JButton("Clear");
		JButton addCusButton = new JButton("Add Customer");
		JButton returnButton = new JButton("Return to Checkout");
		//addNewCustomerButton.addActionListener(new addCusButtonListener());
		
		//add main panel features
		panel1.add(firstNameLabel);
		panel1.add(firstNameField);
		
		panel2.add(lastNameLabel);
		panel2.add(lastNameField);
		
		panel3.add(addressLabel);
		panel3.add(addressField);
		
		panel4.add(phoneLabel);
		panel4.add(phoneField);
		
		panel5.add(spentLabel);
		panel5.add(spentField);
		
		//panel6.add();
		//panel6.add();
		
		panel7.add(clearButton);
		panel7.add(addCusButton);
		
		panel8.add(returnButton);
		
		mainPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		mainPanel.setPreferredSize(new Dimension(260, 220));
		
		mainPanel.add(panel1);
		mainPanel.add(panel2);
		mainPanel.add(panel3);
		mainPanel.add(panel4);
		mainPanel.add(panel5);
		mainPanel.add(panel6);
		mainPanel.add(panel7);
		
		add(mainPanel);
	}
	
	private class addCusButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			System.out.println("running buildAddCus()");
			
			buildAddCus();
			
		}
		
	}
	
	public static void main(String[] args) {
		
		new Window();
		
	}

}
