//Written By: Royce Duncan, 9/27/2018

import javax.swing.*; 	//needed for Swing classes
import java.awt.*;		//needed for FlowLayout class
import java.awt.event.*;//needed for action listeners
import java.util.ArrayList;

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
	
	JLabel transactionAmountLabelError;
	JLabel transactionWindowError;
	
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
	JLabel addCustomerWindowError;
	
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
	private final int WINDOW_HEIGHT = 490;

	private ArrayList<PreferredCustomer> pcArray = new ArrayList<PreferredCustomer>();
	private ArrayList<String> namesArray = new ArrayList<String>();
	
	public Window() {
		
		pcArray.add(new PreferredCustomer("Royce","Duncan","123 Roady rd","Panama City","FL",32405,8501234567L,1, true, 750.00f));
		pcArray.add(new PreferredCustomer("Stevie","Nicks","456 Streety st","Panama City","FL",32405,8501234567L,2,false,1200.00f));
		pcArray.add(new PreferredCustomer("Eric","Clapton","789 Circly cir","Panama City","FL",32405,8501234567L,3,false,2075.00f));
		pcArray.add(new PreferredCustomer("Lindsey","Stirling","741 Highway hwy","Panama City","FL",32405,8501234567L,4,true,200.00f));
		pcArray.add(new PreferredCustomer("John","Ray","456 Streety st","Panama City","FL",32405,8501234567L,5,false,1600.00f));
		
		namesArray.add(pcArray.get(0).getFName());
		namesArray.add(pcArray.get(1).getFName());
		namesArray.add(pcArray.get(2).getFName());
		namesArray.add(pcArray.get(3).getFName());
		namesArray.add(pcArray.get(4).getFName());
				
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
		nameBox = new JComboBox(namesArray.toArray());
		nameBox.setSelectedIndex(-1);
		
		//create labels
		customerLabel = 		new JLabel("Customer ");
		currentSpentLabel = 	new JLabel("Current Spent ");
		currentDiscountLabel = 	new JLabel("Current Discount ");
		transactionAmountLabel =new JLabel("Transaction Amount ");
		amountDiscountedLabel =	new JLabel("Discounted ");
		pendingPaymentLabel = 	new JLabel("Pending Payment ");
		
		//error label set
		transactionAmountLabelError = 	new JLabel("");
		transactionWindowError = 		new JLabel("");
		transactionWindowError.setPreferredSize(new Dimension(180, 25));
		
		transactionAmountLabelError.setForeground(Color.RED);
		transactionWindowError.setForeground(Color.RED);
		
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
		panel5.add(transactionAmountLabelError);
		panel5.add(transactionAmountField);
		
		panel6.add(amountDiscountedLabel);
		panel6.add(amountDiscountedField);
		
		panel7.add(pendingPaymentLabel);
		panel7.add(pendingPaymentField);
		panel8.add(transactionWindowError);

		panel9.add(payButton);
		
		mainPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		mainPanel.setPreferredSize(new Dimension(260, 250));
		
		add(panel1);
		
		mainPanel.add(panel2);
		mainPanel.add(panel3);
		mainPanel.add(panel4);
		mainPanel.add(panel5);
		mainPanel.add(panel6);
		mainPanel.add(panel7);
		mainPanel.add(panel8);
		
		add(mainPanel);
		add(panel9);
		
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
		
		//error label set
		firstNameLabelError = 	new JLabel("");
		lastNameLabelError = 	new JLabel("");
		addressLabelError = 	new JLabel("");
		cityLabelError = 		new JLabel("");
		stateLabelError = 		new JLabel("");
		zipLabelError = 		new JLabel("");
		phoneLabelError = 		new JLabel("");
		moneySpentLabelError = 	new JLabel("");
		addCustomerWindowError = new JLabel("");
		
		firstNameLabelError.setForeground(Color.RED);
		lastNameLabelError.setForeground(Color.RED);
		addressLabelError.setForeground(Color.RED);
		cityLabelError.setForeground(Color.RED);
		stateLabelError.setForeground(Color.RED);
		zipLabelError.setForeground(Color.RED);
		phoneLabelError.setForeground(Color.RED);
		moneySpentLabelError.setForeground(Color.RED);
		addCustomerWindowError.setForeground(Color.RED);
		
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
		panel9.setPreferredSize(new Dimension(280,30));
		
		panel10.add(addCustomerWindowError);
		
		panel11.add(clearButton);
		panel11.add(addCusButton);

		panel12.add(returnButton);
		panel12.setPreferredSize(new Dimension(280,40));
		
		mainPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		mainPanel.setPreferredSize(new Dimension(250, 350));
		
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
			
		add(mainPanel);
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
			currentSpentField.setText("$" + String.format("%.2f", pcArray.get(tempInt).getAmountSpent()));
			currentDiscountField.setText(((int)(100 * pcArray.get(tempInt).getDiscountRate())) + "%");
			transactionAmountField.setText("");
			amountDiscountedField.setText("");
			pendingPaymentField.setText("");
			transactionAmountLabelError.setText("");
			transactionWindowError.setText("");
			
		}
	}
	
	private class transactionAmountFieldListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				transactionAmountLabelError.setText("");
				transactionWindowError.setText("");
				
				if (nameBox.getSelectedIndex() != -1) {
					tempInt = getSelectedCustomerIndex();
					calculatedAmountDiscounted = Float.parseFloat(transactionAmountField.getText()) * pcArray.get(tempInt).getDiscountRate();
					calculatedPendingPayment = Float.parseFloat(transactionAmountField.getText()) - calculatedAmountDiscounted;
					amountDiscountedField.setText("$" + String.format("%.2f", calculatedAmountDiscounted));
					pendingPaymentField.setText("$" + String.format("%.2f", calculatedPendingPayment));
				}
				else {
					transactionWindowError.setText("No Customer Selected");
				}
			}
			catch (Exception ex) {
				transactionAmountLabelError.setText("*");
				transactionWindowError.setText("Improper Input");
			}
		}
	}
	
	private class payButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				transactionAmountLabelError.setText("");
				transactionWindowError.setText("");
				
				if (nameBox.getSelectedIndex() == -1) {
					transactionWindowError.setText("No Customer Selected");
				}
				else if (pendingPaymentField.getText().length() == 0) {
					transactionAmountLabelError.setText("*");
					transactionWindowError.setText("Type amount and press Enter");
				}
				else {
					tempInt = getSelectedCustomerIndex();
					pcArray.get(tempInt).addMoneySpent(Float.parseFloat(pendingPaymentField.getText().substring(1)));
					nameBox.setSelectedIndex(tempInt);
				}
			}
			catch (Exception ex) {
				transactionAmountLabelError.setText("*");
				transactionWindowError.setText("Invalid Input");
			}
		}
	}
	
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
				if (PCaddress.matches("^[0-9]+[\\sa-z]+$")) {
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
				
				strBuild = new StringBuilder(PCphone.trim());
				if (PCphone.matches("^[0-9]{10}$")) {
					PCphone = strBuild.toString();
				}
				else {
					error = true;
					phoneLabelError.setText("*");
				}
				
				strBuild = new StringBuilder(PCmoneySpent.trim());
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
	
	private class returnButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			buildCheckout();
		}
	}
	
	private int getSelectedCustomerIndex() {
		String selection = (String) nameBox.getSelectedItem();
		int tempInt = 0;
		for (int i = 0; i < pcArray.size(); i++) {
			if (selection.equals(pcArray.get(i).getFName())) {
				tempInt = i;
				i = pcArray.size();
			}
		}
		return tempInt;
	}

	public static void main(String[] args) {
		new Window();
	}
}
