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
	
	JButton addNewCustomerButton;
	JButton payButton;
	
	JComboBox nameBox;
	
	JLabel customerLabel;		
	JLabel currentSpentLabel;
	JLabel currentDiscountLabel;
	JLabel transactionAmountLabel;
	JLabel amountDiscountedLabel;
	JLabel pendingPaymentLabel;
	
	JTextField currentSpentField;
	JTextField currentDiscountField;
	JTextField transactionAmountField;
	JTextField amountDiscountedField;
	JTextField pendingPaymentField;
	
	private final int WINDOW_WIDTH = 300;
	private final int WINDOW_HEIGHT = 370;
	
	private PreferredCustomer[] PCarray = {
		new PreferredCustomer("Royce","Duncan","123 Roady rd","8501234567",1,true,750.00f),
		new PreferredCustomer("Stevie","Nicks","456 Streety st","8507654321",2,false,1200.00f),
		new PreferredCustomer("Eric","Clapton","789 Circly cir","8509632587",3,false,2075.00f),
		new PreferredCustomer("Lindsey","Stirling","741 Highway hwy","8508521478",4,true,200.00f),
		new PreferredCustomer("Stevie","Nicks","456 Streety st","8507654321",5,false,1600.00f)
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
		
		//create three buttons
		addNewCustomerButton = new JButton("Add New Customer");
		addNewCustomerButton.addActionListener(new addCusButtonListener());
		payButton = new JButton("Pay");
		
		//create combo box
		nameBox = new JComboBox(names);
		nameBox.addActionListener(new nameComboBoxListener());
		
		//create labels
		customerLabel = 			new JLabel("Customer ");
		currentSpentLabel = 		new JLabel("Current Spent ");
		currentDiscountLabel = 	new JLabel("Current Discount ");
		transactionAmountLabel = new JLabel("Transaction Amount ");
		amountDiscountedLabel =	new JLabel("Discounted ");
		pendingPaymentLabel = 	new JLabel("Pending Payment ");
		
		//create text fields
		currentSpentField = 		new JTextField(10);
		currentDiscountField = 	new JTextField(10);
		transactionAmountField = new JTextField(10);
		amountDiscountedField =	new JTextField(10);
		pendingPaymentField = 	new JTextField(10);
		
		//change component sizes
		nameBox.setPreferredSize(new Dimension(115, 25));
		
		//change some text fields to uneditable
		currentSpentField.setEditable(false);
		currentDiscountField.setEditable(false);
		amountDiscountedField.setEditable(false);
		pendingPaymentField.setEditable(false);
		
		//add main panel features
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
		
		mainPanel.add(panel2);
		mainPanel.add(panel3);
		mainPanel.add(panel4);
		mainPanel.add(panel5);
		mainPanel.add(panel6);
		mainPanel.add(panel7);
		
		add(mainPanel);
		add(panel8);

	}
	
	private class addCusButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			System.out.println("running buildAddCus()");
		}
	}
	
	private class nameComboBoxListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			String selection = (String) nameBox.getSelectedItem();
			for (int i = 0; i < PCarray.length; i++) {
				if (selection.equals(PCarray[i].getFName())) {
					currentSpentField.setText("$" + PCarray[i].getAmountSpent());    
					currentDiscountField.setText(PCarray[i].getDiscountRate() + "%"); 
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
		new Window();
		
	}

}
