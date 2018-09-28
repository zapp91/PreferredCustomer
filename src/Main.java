//Written By: Royce Duncan, 9/27/2018

import javax.swing.*; 	//needed for Swing classes
import java.awt.*;		//needed for FlowLayout class

public class Main extends JFrame {
	
	private String[] names = {"Royce", "Steve", "John"};

	public Main() {
		
		//set the title bar text
		setTitle("Check Out");
		
		//specify an action for the close button
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//add a BorderLayout manager to the content pane
		setLayout(new BorderLayout());
		
		JPanel centerPanel = new JPanel();
		JPanel southPanel = new JPanel();
		
		//create three buttons
		JButton button1 = new JButton("Button 1");
		JButton button2 = new JButton("Button 2");
		
		//create combo box
		JComboBox nameBox = new JComboBox(names);
		
		centerPanel.add(button1);
		centerPanel.add(nameBox);
		southPanel.add(button2);
		
		//add the three buttons to the content pane
		add(centerPanel, BorderLayout.CENTER);
		add(southPanel, BorderLayout.SOUTH);
		
		//pack and display the window
		pack();
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		
		new Main();
		
	}

}
