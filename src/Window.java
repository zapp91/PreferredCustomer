//Written By: Royce Duncan, 9/27/2018

import javax.swing.*; 		//needed for Swing classes
import java.awt.*;			//needed for FlowLayout class
import java.awt.event.*;	//needed for action listeners
import java.util.ArrayList;	//needed for ArrayLists

public class Window extends JFrame {
	
	//panels for Checkout & New Customer windows.
	private JPanel mainPanel;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panel4;
	private JPanel panel5;
	private JPanel panel6;
	private JPanel panel7;
	private JPanel panel8;
	private JPanel panel9;
	private JPanel panel10;
	private JPanel panel11;
	private JPanel panel12;
	
	//buttons for Checkout window
	private JButton addNewCustomerButton;
	private JButton payButton;
	
	//buttons for New Customer window
	private JButton clearButton;
	private JButton addCusButton;
	private JButton returnButton;
	
	//ComboBox for Checkout window
	private JComboBox nameBox;
	
	//descriptive labels for Checkout window
	private JLabel customerLabel;		
	private JLabel currentSpentLabel;
	private JLabel currentDiscountLabel;
	private JLabel transactionAmountLabel;
	private JLabel amountDiscountedLabel;
	private JLabel pendingPaymentLabel;
	
	//error labels for Checkout window
	private JLabel transactionAmountLabelError;
	private JLabel checkoutWindowError;
	
	//descriptive labels for New Customer window
	private JLabel firstNameLabel;
	private JLabel lastNameLabel;
	private JLabel addressLabel;
	private JLabel cityLabel;
	private JLabel stateLabel;
	private JLabel zipLabel; 
	private JLabel phoneLabel;
	private JLabel moneySpentLabel; 
	private JLabel mailListLabel;
	
	//error labels for New Customer window
	private JLabel firstNameLabelError;  
	private JLabel lastNameLabelError;   
	private JLabel addressLabelError;
	private JLabel cityLabelError;	     
	private JLabel stateLabelError;      
	private JLabel zipLabelError;        
	private JLabel phoneLabelError;      
	private JLabel moneySpentLabelError;                     
	private JLabel addCustomerWindowError;
	
	//text fields for Checkout window
	private JTextField currentSpentField;
	private JTextField currentDiscountField;
	private JTextField transactionAmountField;
	private JTextField amountDiscountedField;
	private JTextField pendingPaymentField;
	
	//text fields for New Customer window
	private JTextField firstNameField;
	private JTextField lastNameField; 
	private JTextField addressField;
	private JTextField cityField;	
	private JTextField stateField;
	private JTextField zipField;
	private JTextField phoneField;
	private JTextField moneySpentField;
	
	//radio buttons and button group for Checkout window
	private ButtonGroup mailListRadioGroup;
	private JRadioButton radio1;
	private JRadioButton radio2;

	//temporary integer for preferred customer array indexing
	private int tempInt;
	
	//floats for Checkout calculations
	private float calculatedAmountDiscounted;
	private float calculatedPendingPayment;
	
	//temporary strings for New Customer input validations
	private String PCfName;
	private String PClName;
	private String PCaddress;
	private String PCcity;
	private String PCstate;
	private String PCzip;
	private String PCphone;
	private String PCmoneySpent;
	
	//boolean to test if PCstate input is a valid state
	private boolean correctStateInput;
	
	//StringBuilder for New Customer input validations
	private StringBuilder strBuild;
	
	//boolean for New Customer input validations
	private boolean error;
	
	//ArrayList for Preferred Customers
	private ArrayList<PreferredCustomer> pcArray = new ArrayList<PreferredCustomer>();
	
	//ArrayList for Checkout windows's Customer ComboBox
	private ArrayList<String> namesArray = new ArrayList<String>();
	
	//Window constructor
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
		
	} //end window constructor
	
	
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
	} //end buildCheckout method
	
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
		stateLabel =		new JLabel("State (2 letters) ");
		zipLabel =			new JLabel("Zip ");
		phoneLabel =		new JLabel("Phone (10 digit)");
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
	} //end buildAddCus method
	
	//listener for the Checkout window's Add New Customer button
	private class addNewCusButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			buildAddCus();	//builds the New Customer window
		} //end actionPerformed method
	} //end actionPerformed class
	
	//listener for the Checkout window's Name ComboBox
	private class nameComboBoxListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			tempInt = getSelectedCustomerIndex();	//retrieves the selected names array index
			currentSpentField.setText("$" + String.format("%.2f", pcArray.get(tempInt).getAmountSpent())); //retrieves the selected customers money spent and formats the text before displaying it
			currentDiscountField.setText(((int)(100 * pcArray.get(tempInt).getDiscountRate())) + "%");	//retrieves the selected customers discount rate and formats the text before displaying it
			transactionAmountField.setText("");	//clears any previous transaction amount text
			amountDiscountedField.setText("");	//clears any previous discount text
			pendingPaymentField.setText("");	//clears any previous pending payment text
			transactionAmountLabelError.setText("");	//clears any previous transaction amount error text
			checkoutWindowError.setText("");	//clears any previous Checkout window error text
		} //end actionPerformed method
	} //end nameComboBoxListener class
	
	//listener for the Checkout window's Transaction Amount text field
	private class transactionAmountFieldListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				transactionAmountLabelError.setText("");	//clears any previous transaction amount error text
				checkoutWindowError.setText("");			//clears any previous Checkout window error text
				
				//if the name ComboBox has a selection then..
				if (nameBox.getSelectedIndex() != -1) {
					tempInt = getSelectedCustomerIndex();	//retrieve customer index
					calculatedAmountDiscounted = Float.parseFloat(transactionAmountField.getText()) * pcArray.get(tempInt).getDiscountRate();	//calculate amount discounted
					calculatedPendingPayment = Float.parseFloat(transactionAmountField.getText()) - calculatedAmountDiscounted;					//calculate remaining amount to pay
					amountDiscountedField.setText("$" + String.format("%.2f", calculatedAmountDiscounted));										//format and display calculated discount amount
					pendingPaymentField.setText("$" + String.format("%.2f", calculatedPendingPayment));											//format and display calculated remaining amount to pay
				} //else..
				else {
					checkoutWindowError.setText("No Customer Selected");	//display an error message saying that no customers are selected
				} //end if else sequence
			} //end try
			catch (Exception ex) {
				transactionAmountLabelError.setText("*");		//display error marker
				checkoutWindowError.setText("Improper Input");	//display an error message
			} //end catch
		} //end actionPerformed method
	} //end transactionAmountFieldListener class
	
	//listener for the Checkout window's Pay button
	private class payButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				transactionAmountLabelError.setText("");	//clears any previous transaction amount error text 
				checkoutWindowError.setText("");            //clears any previous Checkout window error text      
				
				//if the name ComboBox doesn't have a selection then..
				if (nameBox.getSelectedIndex() == -1) {
					checkoutWindowError.setText("No Customer Selected"); //display an error message say that none are selected
				} //else if the pending payment field is empty
				else if (pendingPaymentField.getText().length() == 0) {
					transactionAmountLabelError.setText("*");                    //display error marker     
					checkoutWindowError.setText("Type amount and press Enter");  //display an error message 
				} //else ..
				else {
					tempInt = getSelectedCustomerIndex();	//retrieve the selected names array index
					pcArray.get(tempInt).addMoneySpent(Float.parseFloat(pendingPaymentField.getText().substring(1)));	//call method to add pending payment to the amount spend for the customer
					nameBox.setSelectedIndex(tempInt);		//"reclick" the customers name from the ComboBox to update the window
				} //end if else sequence
			} //end try
			catch (Exception ex) {
				transactionAmountLabelError.setText("*");      //display error marker     
				checkoutWindowError.setText("Invalid Input");  //display an error message 
			} //end catch
		} //end actionPerformed method
	} //end payButtonListener class
	
	
	//listener for the New Customer window's clear button
	private class clearButtonListern implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			firstNameField.setText("");		     //clears text for first name field
			lastNameField.setText("");		     //clears text for last name field
			addressField.setText("");		     //clears text for address field field
			cityField.setText("");      	     //clears text for city field
			stateField.setText("");   		     //clears text for state field
			zipField.setText("");       	     //clears text for zip field
			phoneField.setText("");     	     //clears text for phone field
			moneySpentField.setText("");	     //clears text for money spent field
			
			firstNameLabelError.setText("");     //clears text for first name error field   
			lastNameLabelError.setText("");      //clears text for last name error field    
			addressLabelError.setText("");       //clears text for address field error field
			cityLabelError.setText("");          //clears text for city error field         
			stateLabelError.setText("");         //clears text for state error field        
			zipLabelError.setText("");           //clears text for zip error field          
			phoneLabelError.setText("");         //clears text for phone error field        
			moneySpentLabelError.setText("");    //clears text for money spent error field  
			addCustomerWindowError.setText("");	 //clears text for New Customer window error field 
		} //end actionPerformed method
	} //end clearButtonListern class
	
	//listener for the New Customer window's Add Customer button
	private class addCusButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			firstNameLabelError.setText("");                //clears text for first name error field         
			lastNameLabelError.setText("");                 //clears text for last name error field          
			addressLabelError.setText("");                  //clears text for address field error field      
			cityLabelError.setText("");                     //clears text for city error field               
			stateLabelError.setText("");                    //clears text for state error field              
			zipLabelError.setText("");                      //clears text for zip error field                
			phoneLabelError.setText("");                    //clears text for phone error field              
			moneySpentLabelError.setText("");               //clears text for money spent error field        
			addCustomerWindowError.setText("");             //clears text for New Customer window error field
			
			PCfName = 		firstNameField.getText();		//retrieves text from first name field   
			PClName = 		lastNameField.getText();		//retrieves text from last name field    
			PCaddress = 	addressField.getText();			//retrieves text from address field field
			PCcity = 		cityField.getText();			//retrieves text from city field         
			PCstate = 		stateField.getText();			//retrieves text from state field        
			PCzip = 		zipField.getText();				//retrieves text from zip field          
			PCphone = 		phoneField.getText();			//retrieves text from phone field        
			PCmoneySpent =	moneySpentField.getText();		//retrieves text from money spent field  
			error = false;									//boolean used to detect invalid field inputs, set to false at start
			
			//this try block encapsulates all New Customer text field validation checks
			try {
				PCfName = PCfName.toLowerCase().trim();		//trims and lower cases first name
				strBuild = new StringBuilder(PCfName);		//creates a StringBuilder based on the first name string
				if (PCfName.matches("^[a-z]+$")) {			//if the name matches the regex then..
					strBuild.setCharAt(0,Character.toUpperCase(strBuild.charAt(0)));	//uppercase the first letter
					PCfName = strBuild.toString();										//reset the first name string from the StringBuilder results
				} //else..
				else {
					error = true;						//set error boolean to true   
					firstNameLabelError.setText("*");   //display an error marker
				} //end if else sequence
				
				PClName = PClName.toLowerCase().trim(); //trims and lower cases last name                       
				strBuild = new StringBuilder(PClName);  //creates a StringBuilder based on the last name string 
				if (PClName.matches("^[a-z]+$")) {      //if the name matches the regex then..                   
					strBuild.setCharAt(0,Character.toUpperCase(strBuild.charAt(0)));    //uppercase the first letter                                 
					PClName = strBuild.toString();                                      //reset the last name string from the StringBuilder results 
				} //else..
				else {
					error = true;                      //set error boolean to true
					lastNameLabelError.setText("*");   //display an error marker  
				} //end if else sequence
				
				PCaddress = PCaddress.toLowerCase().trim();          //trims and lower cases address                      
				strBuild = new StringBuilder(PCaddress);             //creates a StringBuilder based on the address string 
				if (PCaddress.matches("^[0-9]+[\\s][\\sa-z]+$")) {   //if the address matches the regex then..                  
					PCaddress = strBuild.toString();				 	//reset the address string from the StringBuilder results 
				} //else..
				else {
					error = true;                    //set error boolean to true
					addressLabelError.setText("*");  //display an error marker  
				} //end if else sequence
				
				PCcity = PCcity.toLowerCase().trim();      //trims and lower cases city                      
				strBuild = new StringBuilder(PCcity);      //creates a StringBuilder based on the city string 
				if (PCcity.matches("^[a-z]+$")) {          //if the city matches the regex then..                  
					strBuild.setCharAt(0,Character.toUpperCase(strBuild.charAt(0)));    //uppercase the first letter                               
					PCcity = strBuild.toString();                                       //reset the city string from the StringBuilder results
				}
				else {
					error = true;                     //set error boolean to true
					cityLabelError.setText("*");      //display an error marker  
				} //end if else sequence
				
				PCstate = PCstate.toUpperCase().trim();    //trims and upper cases state                       
				strBuild = new StringBuilder(PCstate);     //creates a StringBuilder based on the state string 
				if (PCstate.matches("^[A-Z]{2}$")) {       //if the state matches the regex then..             
					correctStateInput = false;			//specific boolean to test for valid state input
					for (int i = 0; States.STATE_ABBREVIATIONS.length > i; i++) {	//loops for each state abbreviation available
						if (strBuild.toString().equals(States.STATE_ABBREVIATIONS[i])) {	//if the input string matches an abbreviation then..
							correctStateInput = true;										//set the state boolean to true
							i = States.STATE_ABBREVIATIONS.length;							//set the iterating variable to the last index
						} //end if
					} //end for loop
					
					if(correctStateInput) {				//if the state boolean is true then..
						PCstate = strBuild.toString();		//reset the state string from the StringBuilder results
					} //else..
					else {
						error = true;                 //set error boolean to true
						stateLabelError.setText("*"); //display an error marker  
					} //end if else sequence
				} //else..
				else {
					error = true;                     //set error boolean to true
					stateLabelError.setText("*");     //display an error marker  
				} //end if else sequence
				
				PCzip = PCzip.trim();                 //trims zip                      
				
				if (!PCzip.matches("^[0-9]{5}$")) {    //if the zip doesn't matches the regex then..            
					error = true;                     		//set error boolean to true
					zipLabelError.setText("*");       		//display an error marker  
				}

				PCphone = PCphone.trim();                          //trims phone                          
				strBuild = new StringBuilder(PCphone);             //creates a StringBuilder based on the phone string    
				for (int i = 0; strBuild.length() > i; i++) {      //loops through every character in the phone StringBuilder               
					if (!Character.isDigit(strBuild.charAt(i))) {		//if a character is not a digit then..
						strBuild.deleteCharAt(i);							//delete that character..
						i--;												//reset the iterating variable back one
					} //end if
				} //end for loop
				
				PCphone = strBuild.substring(0,strBuild.length());	//reset the phone string from the StringBuilder results
				if (!PCphone.matches("^[0-9]{10}$")) { 	//if phone string doesn't match regex then..
					error = true;                     		//set error boolean to true
					phoneLabelError.setText("*");     		//display an error marker 
				} //end if
				
				PCmoneySpent = PCmoneySpent.trim();                                    //trims money spent string                         
				if (!PCmoneySpent.matches("^([0-9]*\\.[0-9]+|[0-9]+|[0-9]+\\.)$")) {    //if the money spent string doesn't matches the regex then..                
					error = true;                       //set error boolean to true
					moneySpentLabelError.setText("*");  //display an error marker  
				} //end if
				
				if (error) {										//if an input error was detected then..
					addCustomerWindowError.setForeground(Color.RED);	//set the Add Customer Window error text color to red
					addCustomerWindowError.setText("Input Error");		//add an input error message
				} //else..
				else {
					
					//create a new preferred customer from the input fields
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
					
					pcArray.add(newPC);														//adds the new customer to the preferred customer array
					namesArray.add(newPC.getFName());										//adds the new customer's name to the name array
					addCustomerWindowError.setForeground(new Color(0,153,0));				//set the Add Customer Window error text color to green
					addCustomerWindowError.setText("Customer \"" + PCfName + "\" Saved!");	//add a successful save message
				} //end if else sequence
			} //end try block
			catch (Exception ex) {			//if an exception occurred then..
				System.out.println(ex);			//print the exception
			} //end catch block
		} //end actionPerformed method
	} //end addCusButtonListener class
	
	//listener for the New Customer window's Return to Checkout button
	private class returnButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			buildCheckout();	//rebuilds the Checkout window
		} //end actionPerformed method
	} //end returnButtonListener class
	
	//method to retrieve the the ComboBoxes's selected Name's preferred customer array index, that was a mouth full
	private int getSelectedCustomerIndex() {
		String selection = (String) nameBox.getSelectedItem();	//retrieves the selected name
		tempInt = 0;											//resets the tempInt to zero
		for (int i = 0; i < pcArray.size(); i++) {				//loops for every preferred customer in the array
			if (selection.equals(pcArray.get(i).getFName())) {		//if a customer matches the chosen name then..
				tempInt = i;											//sets the tempInt to the arrays index
				i = pcArray.size();										//sets the iterator to the last index
			} //end if
		} //end for loop
		return tempInt;	//return the array index
	} //end getSelectedCustomerIndex method

	//nested main method
	public static void main(String[] args) {
		new Window(); //creates a new window
	} //end main method
} //end window class
