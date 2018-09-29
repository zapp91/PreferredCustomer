//Written By: Royce Duncan, 9/27/2018

import javax.swing.*; 	//needed for Swing classes
import java.awt.*;		//needed for FlowLayout class

public class Window extends JFrame {
	
	private final int WINDOW_WIDTH = 270;
	private final int WINDOW_HEIGHT = 350;
	
	private String[] names = {"Royce", "Steve", "John"};

	public Window() {
		
		//set the title bar text
		setTitle("Check Out");
		
		//set the size of the window
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		
		setResizable(false);
		
		//specify an action for the close button
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//add a BorderLayout manager to the content pane
		setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		System.out.println(getContentPane().getSize());
		
		//create panels
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel();
		JPanel panel6 = new JPanel();
		JPanel panel7 = new JPanel();
		JPanel panel8 = new JPanel();
		
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		panel1.setPreferredSize(new Dimension(WINDOW_WIDTH-40, 30));
		//mainPanel.setPreferredSize(new Dimension(200, 300));
		
		//create three buttons
		JButton addNewCustomerButton = new JButton("Add New Customer");
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
		
		add(panel1);
		add(panel2);
		add(panel3);
		add(panel4);
		add(panel5);
		add(panel6);
		add(panel7);
		add(panel8);
		
		//pack and display the window
		//pack();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		new Window();
		
	}

}
