//Written By: Royce Duncan, 9/27/2018

import javax.swing.*; 		//needed for Swing classes
import java.awt.*;			//needed for FlowLayout class
import java.awt.event.*;	//needed for action listeners
import java.util.ArrayList;	//needed for ArrayLists

public class Window extends JFrame {
	
	//panels for Checkout & New Customer windows.
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
	
	//buttons for Checkout window
	JButton addNewCustomerButton;
	JButton payButton;
	
	//buttons for New Customer window
	JButton clearButton;
	JButton addCusButton;
	JButton returnButton;
	
	//ComboBox for Checkout window
	JComboBox nameBox;
	
	//descriptive labels for Checkout window
	JLabel customerLabel;		
	JLabel currentSpentLabel;
	JLabel currentDiscountLabel;
	JLabel transactionAmountLabel;
	JLabel amountDiscountedLabel;
	JLabel pendingPaymentLabel;
	
	//error labels for Checkout window
	JLabel transactionAmountLabelError;
	JLabel checkoutWindowError;
	
	//descriptive labels for New Customer window
	JLabel firstNameLabel;
	JLabel lastNameLabel;
	JLabel addressLabel;
	JLabel cityLabel;
	JLabel stateLabel;
	JLabel zipLabel; 
	JLabel phoneLabel;
	JLabel moneySpentLabel; 
	JLabel mailListLabel;
	
	//error labels for New Customer window
	JLabel firstNameLabelError;  
	JLabel lastNameLabelError;   
	JLabel addressLabelError;
	JLabel cityLabelError;	     
	JLabel stateLabelError;      
	JLabel zipLabelError;        
	JLabel phoneLabelError;      
	JLabel moneySpentLabelError;                     
	JLabel addCustomerWindowError;
	
	//text fields for Checkout window
	JTextField currentSpentField;
	JTextField currentDiscountField;
	JTextField transactionAmountField;
	JTextField amountDiscountedField;
	JTextField pendingPaymentField;
	
	//text fields for New Customer window
	JTextField firstNameField;
	JTextField lastNameField; 
	JTextField addressField;
	JTextField cityField;	
	JTextField stateField;
	JTextField zipField;
	JTextField phoneField;
	JTextField moneySpentField;
	
	//radio buttons and button group for Checkout window
	ButtonGroup mailListRadioGroup;
	JRadioButton radio1;
	JRadioButton radio2;

	//temporary integer for preferred customer array indexing
	int tempInt;
	
	//floats for Checkout calculations
	float calculatedAmountDiscounted;
	float calculatedPendingPayment;
	
	//temporary strings for New Customer input validations
	String PCfName;
	String PClName;
	String PCaddress;
	String PCcity;
	String PCstate;
	String PCzip;
	String PCphone;
	String PCmoneySpent;
	
	//StringBuilder for New Customer input validations
	StringBuilder strBuild;
	
	//boolean for New Customer input validations
	boolean error;
	
	//ArrayList for Preferred Customers
	private ArrayList<PreferredCustomer> pcArray = new ArrayList<PreferredCustomer>();
	
	//ArrayList for Checkout windows's Customer ComboBox
	private ArrayList<String> namesArray = new ArrayList<String>();
	
	public Window() {
		
		//initializes the PreferredCustomer array with PreferredCustomers
		pcArray.add(new PreferredCustomer("Royce","Duncan","123 Roady rd","Panama City","FL",32405,8501234567L,1, true, 750.00f));
		pcArray.add(new PreferredCustomer("Stevie","Nicks","456 Streety st","Panama City","FL",32405,8501234567L,2,false,1200.00f));
		pcArray.add(new PreferredCustomer("Eric","Clapton","789 Circly cir","Panama City","FL",32405,8501234567L,3,false,2075.00f));
		
		//initializes the namesArray array with the first names of the PreferredCustomers
		namesArray.add(pcArray.get(0).getFName());
		namesArray.add(pcArray.get(1).getFName());
		namesArray.add(pcArray.get(2).getFName());
				
		//sets the title bar text for the JFrame
		setTitle("Checkout");
		
		//sets the size of the JFrame window
		setSize(300, 490);
		
		//optional method to lock JFrame window size
		//setResizable(false);
		
		//specifies an action for the close button
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//adds a BorderLayout manager to the content pane
		setLayout(new FlowLayout(FlowLayout.CENTER));
		
		//calls function to build the Checkout window
		buildCheckout();
		
		//display the window
		setVisible(true);
		
	}
	
	
	//This function builds the Checkout window
	//called in the Window() method and the New Customer window's return button
	private void buildCheckout() {
		
		//clears the New Customer JFrame components
		getContentPane().removeAll();
		
		//creates panel objects for Checkout window
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
		
		//creates main panel object for Checkout window
		mainPanel = new JPanel();
		
		//button to open New Customer window
		addNewCustomerButton = new JButton("Add New Customer");
		
		//button to pay for presented transaction amount
		payButton = new JButton("Pay");
		
		//combo box for Checkout window, attains value from namesArray, initialized to unselected, sets dimension manually
		nameBox = new JComboBox(namesArray.toArray());
		nameBox.setSelectedIndex(-1);
		nameBox.setPreferredSize(new Dimension(115, 25));
		
		//creates descriptive labels for Checkout window
		customerLabel = 		new JLabel("Customer ");
		currentSpentLabel = 	new JLabel("Current Spent ");
		currentDiscountLabel = 	new JLabel("Current Discount ");
		transactionAmountLabel =new JLabel("Transaction Amount ");
		amountDiscountedLabel =	new JLabel("Discounted ");
		pendingPaymentLabel = 	new JLabel("Pending Payment ");
		
		//creates error labels for Checkout window
		transactionAmountLabelError = 	new JLabel("");
		checkoutWindowError = 		new JLabel("");
		checkoutWindowError.setPreferredSize(new Dimension(180, 25));
		
		//sets color for error labels
		transactionAmountLabelError.setForeground(Color.RED);
		checkoutWindowError.setForeground(Color.RED);
		
		//creates text fields for Checkout window
		currentSpentField = 	new JTextField(10);
		currentDiscountField = 	new JTextField(10);
		transactionAmountField =new JTextField(10);
		amountDiscountedField =	new JTextField(10);
		pendingPaymentField = 	new JTextField(10);
		
		//changes specific text fields as unEditable
		currentSpentField.setEditable(false);
		currentDiscountField.setEditable(false);
		amountDiscountedField.setEditable(false);
		pendingPaymentField.setEditable(false);
		
		//creates listeners for buttons, ComboBox, and text fields
		addNewCustomerButton.addActionListener(new addNewCusButtonListener());
		nameBox.addActionListener(new nameComboBoxListener());
		transactionAmountField.addActionListener(new transactionAmountFieldListener());
		payButton.addActionListener(new payButtonListener());
		
		//adds Add New Customer button component to the top panel
		panel1.add(addNewCustomerButton);
		
		//adds components to the main panel set
		panel2.add(customerLabel);
		panel2.add(nameBox);
		
		panel3.add(currentSpentLabel);
		panel3.add(currentSpentField);
		
		panel4.add(currentDiscountLabel);
		panel4.add(currentDiscountField);
		
		panel5.add(transactionAmountLabel);
		panel5.add(transactionAmountLabelError);
		panel5.add(transactionAmountField);
		
		panel6.add(amountDiscountedLabel);
		panel6.add(amountDiscountedField);
		
		panel7.add(pendingPaymentLabel);
		panel7.add(pendingPaymentField);
		
		panel8.add(checkoutWindowError);

		//adds Pay button component to the bottom panel
		panel9.add(payButton);
		
		//adds the main panel set to the main panel
		mainPanel.add(panel2);
		mainPanel.add(panel3);
		mainPanel.add(panel4);
		mainPanel.add(panel5);
		mainPanel.add(panel6);
		mainPanel.add(panel7);
		mainPanel.add(panel8);
		
		//sets the main panel's flow characteristics
		mainPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		mainPanel.setPreferredSize(new Dimension(260, 250));
		
		//adds the first panel directly to the top of the Checkout JFrame
		add(panel1);
		
		//adds the main panel in the middle of the Checkout JFrame 
		add(mainPanel);
		
		//adds the last panel directly to the bottom of the Checkout JFrame 
		add(panel9);
		
		//redisplays the Checkout JFrame over the New Customer JFrame
		revalidate();
		repaint();
	}
	
	//This function builds the Add New Customer window
	//called by the Checkout window's Add New Customer button
	private void buildAddCus() {
		
		//clears the Checkout JFrame components
		getContentPane().removeAll();
		
		//creates panel objects for Checkout window
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
		
		//creates main panel object for Checkout window
		mainPanel = new JPanel();
		
		//button to clear error labels and text fields
		clearButton = new JButton("Clear");
		
		//button to add New Customer details to the PreferredCustomer array
		addCusButton = new JButton("Add Customer");
		
		//button to open the Checkout window
		returnButton = new JButton("Return to Checkout");
		
		//radio buttons to choose customer's mail listing preference
		radio1 = new JRadioButton("Yes", true);
		radio2 = new JRadioButton("No");
		
		//creates mail list button group and adds the buttons to it
		mailListRadioGroup = new ButtonGroup();
		mailListRadioGroup.add(radio1);
		mailListRadioGroup.add(radio2);
		
		//creates descriptive labels for Checkout window
		firstNameLabel = 	new JLabel("First Name ");
		lastNameLabel = 	new JLabel("Last Name ");
		addressLabel = 		new JLabel("Street Address ");
		cityLabel =			new JLabel("City ");
		stateLabel =		new JLabel("State ");
		zipLabel =			new JLabel("Zip ");
		phoneLabel =		new JLabel("Phone ");
		moneySpentLabel =	new JLabel("Money Spent ");
		mailListLabel =		new JLabel("Mail List ");
		
		//creates error labels for Checkout window
		firstNameLabelError = 	new JLabel("");
		lastNameLabelError = 	new JLabel("");
		addressLabelError = 	new JLabel("");
		cityLabelError = 		new JLabel("");
		stateLabelError = 		new JLabel("");
		zipLabelError = 		new JLabel("");
		phoneLabelError = 		new JLabel("");
		moneySpentLabelError = 	new JLabel("");
		addCustomerWindowError = new JLabel("");
		
		//sets color for error labels
		firstNameLabelError.setForeground(Color.RED);
		lastNameLabelError.setForeground(Color.RED);
		addressLabelError.setForeground(Color.RED);
		cityLabelError.setForeground(Color.RED);
		stateLabelError.setForeground(Color.RED);
		zipLabelError.setForeground(Color.RED);
		phoneLabelError.setForeground(Color.RED);
		moneySpentLabelError.setForeground(Color.RED);
		addCustomerWindowError.setForeground(Color.RED);
		
		//creates text fields for New Customer window
		firstNameField = 	new JTextField(10);
		lastNameField = 	new JTextField(10);
		addressField =		new JTextField(10);
		cityField =			new JTextField(10);
		stateField =		new JTextField(10);
		zipField = 			new JTextField(10);
		phoneField =		new JTextField(10);
		moneySpentField = 	new JTextField(10);
		
		//change ComboBox component size
		nameBox.setPreferredSize(new Dimension(115, 25));
		
		//creates listeners for buttons
		clearButton.addActionListener(new clearButtonListern());
		addCusButton.addActionListener(new addCusButtonListener());
		returnButton.addActionListener(new returnButtonListener());
		
		//adds components to the main panel set
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
		panel9.setPreferredSize(new Dimension(280,30));
		
		//adds Add Customer Error Text component to middles panel
		panel10.add(addCustomerWindowError);
		
		//adds Clear and Add Customer button components to lower panel
		panel11.add(clearButton);
		panel11.add(addCusButton);

		//adds Return to Checkout button component to lowest panel, sets its size
		panel12.add(returnButton);
		panel12.setPreferredSize(new Dimension(280,40));
		
		//adds the main panel set to the main panel
		mainPanel.add(panel1);
		mainPanel.add(panel2);
		mainPanel.add(panel3);
		mainPanel.add(panel4);
		mainPanel.add(panel5);
		mainPanel.add(panel6);
		mainPanel.add(panel7);
		mainPanel.add(panel8);
		mainPanel.add(panel9);
		mainPanel.add(panel10);
		
		//sets the main panel's flow characteristics
		mainPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		mainPanel.setPreferredSize(new Dimension(250, 350));
		
		//adds the main panel to the top of the New Customer JFrame
		add(mainPanel);
		
		//adds the button panels to the bottom of the New Customer JFrame
		add(panel11);
		add(panel12);
		
		//redisplays the New Customer JFrame over the Checkout JFrame
		revalidate();
		repaint();
	}
	
	//listener for the Checkout window's Add New Customer button
	private class addNewCusButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			buildAddCus();
		}
	}
	
	//listener for the Checkout window's Name ComboBox
	private class nameComboBoxListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			tempInt = getSelectedCustomerIndex();
			currentSpentField.setText("$" + String.format("%.2f", pcArray.get(tempInt).getAmountSpent()));
			currentDiscountField.setText(((int)(100 * pcArray.get(tempInt).getDiscountRate())) + "%");
			transactionAmountField.setText("");
			amountDiscountedField.setText("");
			pendingPaymentField.setText("");
			transactionAmountLabelError.setText("");
			checkoutWindowError.setText("");
			
		}
	}
	
	//listener for the Checkout window's Transaction Amount text field
	private class transactionAmountFieldListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				transactionAmountLabelError.setText("");
				checkoutWindowError.setText("");
				
				if (nameBox.getSelectedIndex() != -1) {
					tempInt = getSelectedCustomerIndex();
					calculatedAmountDiscounted = Float.parseFloat(transactionAmountField.getText()) * pcArray.get(tempInt).getDiscountRate();
					calculatedPendingPayment = Float.parseFloat(transactionAmountField.getText()) - calculatedAmountDiscounted;
					amountDiscountedField.setText("$" + String.format("%.2f", calculatedAmountDiscounted));
					pendingPaymentField.setText("$" + String.format("%.2f", calculatedPendingPayment));
				}
				else {
					checkoutWindowError.setText("No Customer Selected");
				}
			}
			catch (Exception ex) {
				transactionAmountLabelError.setText("*");
				checkoutWindowError.setText("Improper Input");
			}
		}
	}
	
	//listener for the Checkout window's Pay button
	private class payButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				transactionAmountLabelError.setText("");
				checkoutWindowError.setText("");
				
				if (nameBox.getSelectedIndex() == -1) {
					checkoutWindowError.setText("No Customer Selected");
				}
				else if (pendingPaymentField.getText().length() == 0) {
					transactionAmountLabelError.setText("*");
					checkoutWindowError.setText("Type amount and press Enter");
				}
				else {
					tempInt = getSelectedCustomerIndex();
					pcArray.get(tempInt).addMoneySpent(Float.parseFloat(pendingPaymentField.getText().substring(1)));
					nameBox.setSelectedIndex(tempInt);
				}
			}
			catch (Exception ex) {
				transactionAmountLabelError.setText("*");
				checkoutWindowError.setText("Invalid Input");
			}
		}
	}
	
	
	//listener for the New Customer window's clear button
	private class clearButtonListern implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			firstNameField.setText("");
			lastNameField.setText("");
			addressField.setText("");
			cityField.setText("");      
			stateField.setText("");   
			zipField.setText("");       
			phoneField.setText("");     
			moneySpentField.setText("");
			
			firstNameLabelError.setText("");
			lastNameLabelError.setText("");
			addressLabelError.setText("");
			cityLabelError.setText("");
			stateLabelError.setText("");
			zipLabelError.setText("");
			phoneLabelError.setText("");
			moneySpentLabelError.setText("");
			addCustomerWindowError.setText("");
		}
	}
	
	//listener for the New Customer window's Add Customer button
	private class addCusButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			firstNameLabelError.setText("");
			lastNameLabelError.setText("");
			addressLabelError.setText("");
			cityLabelError.setText("");
			stateLabelError.setText("");
			zipLabelError.setText("");
			phoneLabelError.setText("");
			moneySpentLabelError.setText("");
			addCustomerWindowError.setText("");
			
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
				PCfName = PCfName.toLowerCase().trim();
				strBuild = new StringBuilder(PCfName);
				if (PCfName.matches("^[a-z]+$")) {
					strBuild.setCharAt(0,Character.toUpperCase(strBuild.charAt(0)));
					PCfName = strBuild.toString();
				}
				else {
					error = true;
					firstNameLabelError.setText("*");
				}
				
				PClName = PClName.toLowerCase().trim();
				strBuild = new StringBuilder(PClName);
				if (PClName.matches("^[a-z]+$")) {
					strBuild.setCharAt(0,Character.toUpperCase(strBuild.charAt(0)));
					PClName = strBuild.toString();
				}
				else {
					error = true;
					lastNameLabelError.setText("*");
				}
				
				PCaddress = PCaddress.toLowerCase().trim();
				strBuild = new StringBuilder(PCaddress);
				if (PCaddress.matches("^[0-9]+[\\s][\\sa-z]+$")) {
					PCaddress = strBuild.toString();
				}
				else {
					error = true;
					addressLabelError.setText("*");
				}
				
				PCcity = PCcity.toLowerCase().trim();
				strBuild = new StringBuilder(PCcity);
				if (PCcity.matches("^[a-z]+$")) {
					strBuild.setCharAt(0,Character.toUpperCase(strBuild.charAt(0)));
					PCcity = strBuild.toString();
				}
				else {
					error = true;
					cityLabelError.setText("*");
				}
				
				PCstate = PCstate.toUpperCase().trim();
				strBuild = new StringBuilder(PCstate);
				if (PCstate.matches("^[A-Z]{2}$")) {
					boolean correctStateInput = false;
					for (int i = 0; States.stateAbbreviations.length > i; i++) {
						if (strBuild.toString().equals(States.stateAbbreviations[i])) {
							correctStateInput = true;
							i = States.stateAbbreviations.length;
						}
					}
					
					if(correctStateInput) {
						PCstate = strBuild.toString();
					}
					else {
						error = true;
						stateLabelError.setText("*");
					}
				}
				else {
					error = true;
					stateLabelError.setText("*");
				}
				
				PCzip = PCzip.trim();
				strBuild = new StringBuilder(PCzip);
				if (PCzip.matches("^[0-9]{5}$")) {
					PCzip = strBuild.toString();
				}
				else {
					error = true;
					zipLabelError.setText("*");
				}
				
				PCphone = PCphone.trim();
				strBuild = new StringBuilder(PCphone);
				for (int i = 0; strBuild.length() > i; i++) {
					if (!Character.isDigit(strBuild.charAt(i))) {
						strBuild.deleteCharAt(i);
						i--;
					}
				}
				
				PCphone = strBuild.substring(0,strBuild.length());
				if (PCphone.matches("^[0-9]{10}$")) {
					PCphone = strBuild.toString();
				}
				else {
					error = true;
					phoneLabelError.setText("*");
				}
				
				PCmoneySpent = PCmoneySpent.trim();
				strBuild = new StringBuilder(PCmoneySpent);
				if (PCmoneySpent.matches("^([0-9]*\\.[0-9]+|[0-9]+|[0-9]+\\.)$")) {
					PCmoneySpent = strBuild.toString();
				}
				else {
					error = true;
					moneySpentLabelError.setText("*");
				}
				
				if (error) {
					addCustomerWindowError.setForeground(Color.RED);
					addCustomerWindowError.setText("Input Error");
				}
				else {
					PreferredCustomer newPC = new PreferredCustomer(
							PCfName,
							PClName,
							PCaddress,
							PCcity,
							PCstate,
							Integer.parseInt(PCzip),
							Long.parseLong(PCphone),
							pcArray.size(),
							radio1.isSelected(),
							Float.parseFloat(PCmoneySpent));
					
					pcArray.add(newPC);
					namesArray.add(newPC.getFName());
					addCustomerWindowError.setForeground(new Color(0,153,0));
					addCustomerWindowError.setText("Customer \"" + PCfName + "\" Saved!");
				}
			}
			catch (Exception ex) {
				System.out.println(ex);
			}
		}
	}
	
	//listener for the New Customer window's Return to Checkout button
	private class returnButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			buildCheckout();
		}
	}
	
	//method to retrieve the the ComboBoxes's selected Name's preferred customer array index, that was a mouth full
	private int getSelectedCustomerIndex() {
		String selection = (String) nameBox.getSelectedItem();
		tempInt = 0;
		for (int i = 0; i < pcArray.size(); i++) {
			if (selection.equals(pcArray.get(i).getFName())) {
				tempInt = i;
				i = pcArray.size();
			}
		}
		return tempInt;
	}

	//nested main method
	public static void main(String[] args) {
		new Window();
	}
}
