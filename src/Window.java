//Written By: Royce Duncan, 9/27/2018

import javax.swing.*; 	//needed for Swing classes
import java.awt.*;		//needed for FlowLayout class
import java.awt.event.*;//needed for action listeners

public class Window extends JFrame {
	
	JPanel mainPanel;
	
	JPanel panel1;
	JPanel panel2;
	JPanel panel3;
	JPanel panel4;
	JPanel panel5;
	JPanel panel6;
	JPanel panel7;
	JPanel panel8;
	JPanel panel9;
	JPanel panel10;
	JPanel panel11;
	JPanel panel12;
	
	JButton addNewCustomerButton;
	JButton payButton;
	
	JButton clearButton;
	JButton addCusButton;
	JButton returnButton;
	
	JComboBox nameBox;
	
	JLabel customerLabel;		
	JLabel currentSpentLabel;
	JLabel currentDiscountLabel;
	JLabel transactionAmountLabel;
	JLabel amountDiscountedLabel;
	JLabel pendingPaymentLabel;
	
	JLabel firstNameLabel;
	JLabel lastNameLabel;
	JLabel addressLabel;
	JLabel cityLabel;
	JLabel stateLabel;
	JLabel zipLabel; 
	JLabel phoneLabel;
	JLabel moneySpentLabel; 
	JLabel mailListLabel;
	
	JLabel firstNameLabelError;  
	JLabel lastNameLabelError;   
	JLabel addressLabelError;    
	JLabel cityLabelError;	     
	JLabel stateLabelError;      
	JLabel zipLabelError;        
	JLabel phoneLabelError;      
	JLabel moneySpentLabelError; 
	                       
	JLabel addCustomerLabelError;
	
	JTextField currentSpentField;
	JTextField currentDiscountField;
	JTextField transactionAmountField;
	JTextField amountDiscountedField;
	JTextField pendingPaymentField;
	
	JTextField firstNameField;
	JTextField lastNameField; 
	JTextField addressField;
	JTextField cityField;	
	JTextField stateField;
	JTextField zipField;
	JTextField phoneField;
	JTextField moneySpentField;
	
	ButtonGroup mailListRadioGroup;
	JRadioButton radio1;
	JRadioButton radio2;

	int tempInt;
	
	float calculatedAmountDiscounted;
	float calculatedPendingPayment;
	
	String PCfName;
	String PClName;
	String PCaddress;
	String PCcity;
	String PCstate;
	String PCzip;
	String PCphone;
	String PCmoneySpent;
	
	boolean error;
	
	StringBuilder strBuild;
	
	private final int WINDOW_WIDTH = 300;
	private final int WINDOW_HEIGHT = 460;
	
	private PreferredCustomer[] PCarray = {
		new PreferredCustomer("Royce","Duncan","123 Roady rd","Panama City","FL",32405,8501234567L,1, true, 750.00f),
		new PreferredCustomer("Stevie","Nicks","456 Streety st","Panama City","FL",32405,8501234567L,2,false,1200.00f),
		new PreferredCustomer("Eric","Clapton","789 Circly cir","Panama City","FL",32405,8501234567L,3,false,2075.00f),
		new PreferredCustomer("Lindsey","Stirling","741 Highway hwy","Panama City","FL",32405,8501234567L,4,true,200.00f),
		new PreferredCustomer("John","Ray","456 Streety st","Panama City","FL",32405,8501234567L,5,false,1600.00f)
	};
	
	private String[] names = {
		PCarray[0].getFName(),
		PCarray[1].getFName(),
		PCarray[2].getFName(),
		PCarray[3].getFName(),
		PCarray[4].getFName()
	};

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
		getContentPane().removeAll();
		
		//create main panel
		mainPanel = new JPanel();
		
		//create sub panels
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel4 = new JPanel();
		panel5 = new JPanel();
		panel6 = new JPanel();
		panel7 = new JPanel();
		panel8 = new JPanel();
		panel9 = new JPanel();
		panel10 = new JPanel();
		panel11 = new JPanel();
		panel12 = new JPanel();
		
		//buttons
		addNewCustomerButton = new JButton("Add New Customer");
		payButton = new JButton("Pay");
		
		//create combo box
		nameBox = new JComboBox(names);
		nameBox.setSelectedIndex(-1);
		
		//create labels
		customerLabel = 		new JLabel("Customer ");
		currentSpentLabel = 	new JLabel("Current Spent ");
		currentDiscountLabel = 	new JLabel("Current Discount ");
		transactionAmountLabel =new JLabel("Transaction Amount ");
		amountDiscountedLabel =	new JLabel("Discounted ");
		pendingPaymentLabel = 	new JLabel("Pending Payment ");
		
		//create text fields
		currentSpentField = 	new JTextField(10);
		currentDiscountField = 	new JTextField(10);
		transactionAmountField =new JTextField(10);
		amountDiscountedField =	new JTextField(10);
		pendingPaymentField = 	new JTextField(10);
		
		//change component sizes
		nameBox.setPreferredSize(new Dimension(115, 25));
		
		//change some text fields to uneditable
		currentSpentField.setEditable(false);
		currentDiscountField.setEditable(false);
		amountDiscountedField.setEditable(false);
		pendingPaymentField.setEditable(false);
		
		//listeners
		addNewCustomerButton.addActionListener(new addNewCusButtonListener());
		nameBox.addActionListener(new nameComboBoxListener());
		transactionAmountField.addActionListener(new transactionAmountFieldListener());
		payButton.addActionListener(new payButtonListener());
		
		
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
		mainPanel.setPreferredSize(new Dimension(250, 320));
		
		add(panel1);
		
		mainPanel.add(panel2);
		mainPanel.add(panel3);
		mainPanel.add(panel4);
		mainPanel.add(panel5);
		mainPanel.add(panel6);
		mainPanel.add(panel7);
		
		add(mainPanel);
		add(panel8);
		
		revalidate();
		repaint();
	}
	
	private void buildAddCus() {
		getContentPane().removeAll();
		
		//create main panel
		mainPanel = new JPanel();
		
		//create sub panels
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel4 = new JPanel();
		panel5 = new JPanel();
		panel6 = new JPanel();
		panel7 = new JPanel();
		panel8 = new JPanel();
		panel9 = new JPanel();
		panel10 = new JPanel();
		panel11 = new JPanel();
		panel12 = new JPanel();
		
		//buttons
		clearButton = new JButton("Clear");
		addCusButton = new JButton("Add Customer");
		returnButton = new JButton("Return to Check Out");
		
		//radio buttons
		radio1 = new JRadioButton("Yes", true);
		radio2 = new JRadioButton("No");
		
		mailListRadioGroup = new ButtonGroup();
		mailListRadioGroup.add(radio1);
		mailListRadioGroup.add(radio2);
		
		//create labels
		firstNameLabel = 	new JLabel("First Name ");
		lastNameLabel = 	new JLabel("Last Name ");
		addressLabel = 		new JLabel("Street Address ");
		cityLabel =			new JLabel("City ");
		stateLabel =		new JLabel("State ");
		zipLabel =			new JLabel("Zip ");
		phoneLabel =		new JLabel("Phone ");
		moneySpentLabel =	new JLabel("Money Spent ");
		mailListLabel =		new JLabel("Mail List ");
		
		firstNameLabelError = 	new JLabel("");
		lastNameLabelError = 	new JLabel("");
		addressLabelError = 	new JLabel("");
		cityLabelError = 		new JLabel("");
		stateLabelError = 		new JLabel("");
		zipLabelError = 		new JLabel("");
		phoneLabelError = 		new JLabel("");
		moneySpentLabelError = 	new JLabel("");
		
		addCustomerLabelError = new JLabel("");
		
		//create text fields
		firstNameField = 	new JTextField(10);
		lastNameField = 	new JTextField(10);
		addressField =		new JTextField(10);
		cityField =			new JTextField(10);
		stateField =		new JTextField(10);
		zipField = 			new JTextField(10);
		phoneField =		new JTextField(10);
		moneySpentField = 	new JTextField(10);
		
		//change component sizes
		nameBox.setPreferredSize(new Dimension(115, 25));
		
		//listeners
		clearButton.addActionListener(new clearButtonListern());
		addCusButton.addActionListener(new addCusButtonListener());
		returnButton.addActionListener(new returnButtonListener());
		
		//add main panel features
		panel1.add(firstNameLabel);
		panel1.add(firstNameLabelError);
		panel1.add(firstNameField);
		
		panel2.add(lastNameLabel);
		panel2.add(lastNameLabelError);
		panel2.add(lastNameField);
		
		panel3.add(addressLabel);
		panel3.add(addressLabelError);
		panel3.add(addressField);
		
		panel4.add(cityLabel);
		panel4.add(cityLabelError);
		panel4.add(cityField);
		
		panel5.add(stateLabel);
		panel5.add(stateLabelError);
		panel5.add(stateField);
		
		panel6.add(zipLabel);
		panel6.add(zipLabelError);
		panel6.add(zipField);
		
		panel7.add(phoneLabel);
		panel7.add(phoneLabelError);
		panel7.add(phoneField);
		
		panel8.add(moneySpentLabel);
		panel8.add(moneySpentLabelError);
		panel8.add(moneySpentField);
		
		panel9.add(mailListLabel);
		panel9.add(radio1);
		panel9.add(radio2);
		
		panel10.add(clearButton);
		panel10.add(addCusButton);

		panel11.add(returnButton);
		
		panel12.add(addCustomerLabelError);
		
		mainPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		mainPanel.setPreferredSize(new Dimension(250, 320));
		
		mainPanel.add(panel1);
		mainPanel.add(panel2);
		mainPanel.add(panel3);
		mainPanel.add(panel4);
		mainPanel.add(panel5);
		mainPanel.add(panel6);
		mainPanel.add(panel7);
		mainPanel.add(panel8);
		mainPanel.add(panel9);
			
		add(mainPanel);
		add(panel10);
		add(panel11);
		add(panel12);
		
		revalidate();
		repaint();
	}
	
	private class addNewCusButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			buildAddCus();
		}
	}
	
	private class nameComboBoxListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			tempInt = getSelectedCustomerIndex();
			currentSpentField.setText("$" + String.format("%.2f", PCarray[tempInt].getAmountSpent()));
			currentDiscountField.setText(((int)(100 * PCarray[tempInt].getDiscountRate())) + "%");
			transactionAmountField.setText("");
			amountDiscountedField.setText("");
			pendingPaymentField.setText("");
		}
	}
	
	private class transactionAmountFieldListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				tempInt = getSelectedCustomerIndex();
				
				calculatedAmountDiscounted = Float.parseFloat(transactionAmountField.getText()) * PCarray[tempInt].getDiscountRate();
				calculatedPendingPayment = Float.parseFloat(transactionAmountField.getText()) - calculatedAmountDiscounted;
				
				amountDiscountedField.setText("$" + String.format("%.2f", calculatedAmountDiscounted));
				pendingPaymentField.setText("$" + String.format("%.2f", calculatedPendingPayment));
			}
			catch (Exception ex) {
				amountDiscountedField.setText("Improper Input");
				pendingPaymentField.setText("Improper Input");
			}
		}
	}
	
	private class payButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				tempInt = getSelectedCustomerIndex();
				if (tempInt != -1) {
					PCarray[tempInt].addMoneySpent(Float.parseFloat(pendingPaymentField.getText().substring(1)));
					nameBox.setSelectedIndex(tempInt);
				}
			}
			catch (Exception ex) {
				//do nothing
			}
		}
	}
	
	private class clearButtonListern implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			firstNameField.setText("");
			lastNameField.setText("");
			addressField.setText("");
			phoneField.setText("");
			moneySpentField.setText("");
		}
	}
	
	private class addCusButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			PCfName = 		firstNameField.getText();
			PClName = 		lastNameField.getText();
			PCaddress = 	addressField.getText();
			PCcity = 		cityField.getText();
			PCstate = 		stateField.getText();
			PCzip = 		zipField.getText();
			PCphone = 		phoneField.getText();
			PCmoneySpent =	moneySpentField.getText();
			error = false;
			
			try {
				strBuild = new StringBuilder(PCfName.toLowerCase().trim());
				if (PCfName.matches("^[a-z]+$")) {
					strBuild.setCharAt(0,Character.toUpperCase(strBuild.charAt(0)));
					PCfName = strBuild.toString();
				}
				else {
					error = true;
					firstNameLabelError.setText("*");
				}
				
				strBuild = new StringBuilder(PClName.toLowerCase().trim());
				if (PClName.matches("^[a-z]+$")) {
					strBuild.setCharAt(0,Character.toUpperCase(strBuild.charAt(0)));
					PClName = strBuild.toString();
				}
				else {
					error = true;
				}
				
				strBuild = new StringBuilder(PCaddress.toLowerCase().trim());
				if (PCaddress.matches("^[0-9]+[\\s][a-z]+$")) {
				
				}
				else {
					error = true;
				}

				strBuild = new StringBuilder(PCcity.toLowerCase().trim());
				if (PCcity.matches("^[a-z]+$")) {
					
				}
				else {
					error = true;
				}
				
				strBuild = new StringBuilder(PCstate.toUpperCase().trim());
				if (PCstate.matches("^[a-z]{2}$")) {
					
				}
				else {
					error = true;
				}
				
				strBuild = new StringBuilder(PCzip.trim());
				if (PCzip.matches("^[0-9]{5}$")) {
					
				}
				else {
					error = true;
				}
				
				strBuild = new StringBuilder(PCphone.trim());
				if (PCphone.matches("^[0-9]{10}$")) {
					
				}
				else {
					error = true;
				}
				
				strBuild = new StringBuilder(PCmoneySpent.trim());
				if (PCmoneySpent.matches("^([0-9]*\\.[0-9]+|[0-9]+|[0-9]+\\.)$")) {
					
				}
				else {
					error = true;
				}
				
				if (error) {
					throw new Exception("Customer input error.");
				}
				else {
					
				}
			}
			catch (Exception ex) {
				System.out.println(ex);
			}
		}
	}
	
	private class returnButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			buildCheckout();
		}
	}
	
	private int getSelectedCustomerIndex() {
		String selection = (String) nameBox.getSelectedItem();
		int tempInt = 0;
		for (int i = 0; i < PCarray.length; i++) {
			if (selection.equals(PCarray[i].getFName())) {
				tempInt = i;
				i = PCarray.length;
			}
		}
		return tempInt;
	}

	public static void main(String[] args) {
		new Window();
	}
}
