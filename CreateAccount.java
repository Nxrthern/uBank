/**
 * @(#)CreateAccount.java
 *
 *
 * @author 
 * @version 1.00 2012/6/5
 */

	//Required imports
	import javax.swing.*;
	import javax.swing.event.*;
	import java.awt.*;
	import java.awt.event.*;
	import java.io.*;
	import java.text.*;

public class CreateAccount extends JFrame implements ActionListener
{
	//screen stuff
	//Creates buttons for save name section
   	JButton cmdSavings = new JButton("Savings");
   	JButton cmdChequing = new JButton("Chequing Account");
   	JButton cmdNoFrills = new JButton("No Frill");
   	JLabel lblAccountName = new JLabel("Account Name:");
   	JTextField txtAccountName = new JTextField(20);
   	JLabel lblInterest = new JLabel("int");
   	JLabel lblTransactionLimit = new JLabel("trans");
   	JButton cmdCreate = new JButton("Create");
   	JButton cmdMainMenu = new JButton("Main Menu");
   	JLabel lblGeneral = new JLabel("gen");
   	JLabel lblComms = new JLabel("comms");

	//Creates an instance for the layout manager
    SpringLayout layout = new SpringLayout();
    
    public CreateAccount() 
    {
       	//Adds buttons, text field, and check box to the frame
       	this.add(cmdSavings);
       	this.add(cmdChequing);
       	this.add(cmdNoFrills);
       	this.add(lblInterest);
       	this.add(txtAccountName);
       	this.add(lblTransactionLimit);
    	this.add(cmdCreate);
    	this.add(cmdMainMenu);
    	this.add(txtAccountName);
    	this.add(lblAccountName);
    	this.add(lblGeneral);
    	this.add(lblComms);

		//Set background colours to green
		Color uBankColor = new Color(100, 100, 255);
    	this.getContentPane().setBackground(uBankColor);

    	//Set word to reference the action performed
    	cmdCreate.setActionCommand("create");
    	cmdMainMenu.setActionCommand("menu");
    	cmdSavings.setActionCommand("savings");
    	cmdChequing.setActionCommand("chequing");
    	cmdNoFrills.setActionCommand("frills");

	//Add the action listener to different objects
    	cmdCreate.addActionListener(this);
    	cmdMainMenu.addActionListener(this);
    	cmdSavings.addActionListener(this);
    	cmdChequing.addActionListener(this);
    	cmdNoFrills.addActionListener(this);

	//Set the layout for the frame
	this.getContentPane().setLayout(layout);

    	//Set the positions of the buttons on the frame using coordinates
    	layout.putConstraint(SpringLayout.WEST, cmdCreate, 200, SpringLayout.WEST, getContentPane());
    	layout.putConstraint(SpringLayout.NORTH, cmdCreate, 400, SpringLayout.NORTH, getContentPane());

    	layout.putConstraint(SpringLayout.WEST, lblInterest, 200, SpringLayout.WEST, getContentPane());
		layout.putConstraint(SpringLayout.NORTH, lblInterest, 225, SpringLayout.NORTH, getContentPane());

    	layout.putConstraint(SpringLayout.WEST, cmdMainMenu, 30, SpringLayout.WEST, getContentPane());
    	layout.putConstraint(SpringLayout.NORTH, cmdMainMenu, 100, SpringLayout.NORTH, getContentPane());

		layout.putConstraint(SpringLayout.WEST, lblGeneral, 200, SpringLayout.WEST, getContentPane());
		layout.putConstraint(SpringLayout.NORTH, lblGeneral, 275, SpringLayout.NORTH, getContentPane());

		layout.putConstraint(SpringLayout.WEST, lblAccountName, 200, SpringLayout.WEST, getContentPane());
		layout.putConstraint(SpringLayout.NORTH, lblAccountName, 160, SpringLayout.NORTH, getContentPane());
    	layout.putConstraint(SpringLayout.WEST, txtAccountName, 200, SpringLayout.WEST, getContentPane());
    	layout.putConstraint(SpringLayout.NORTH, txtAccountName, 185, SpringLayout.NORTH, getContentPane());

    	layout.putConstraint(SpringLayout.WEST, lblTransactionLimit, 290, SpringLayout.WEST, getContentPane());
		layout.putConstraint(SpringLayout.NORTH, lblTransactionLimit, 225, SpringLayout.NORTH, getContentPane());
		
    	layout.putConstraint(SpringLayout.WEST, cmdChequing, 320, SpringLayout.WEST, getContentPane());
    	layout.putConstraint(SpringLayout.NORTH, cmdChequing, 325, SpringLayout.NORTH, getContentPane());

    	layout.putConstraint(SpringLayout.WEST, cmdSavings, 200, SpringLayout.WEST, getContentPane());
    	layout.putConstraint(SpringLayout.NORTH, cmdSavings, 325, SpringLayout.NORTH, getContentPane());

    	layout.putConstraint(SpringLayout.WEST, cmdNoFrills, 480, SpringLayout.WEST, getContentPane());
    	layout.putConstraint(SpringLayout.NORTH, cmdNoFrills, 325, SpringLayout.NORTH, getContentPane());

		layout.putConstraint(SpringLayout.WEST, lblComms, 0, SpringLayout.WEST, getContentPane());
		layout.putConstraint(SpringLayout.NORTH, lblComms, 0, SpringLayout.NORTH, getContentPane());

    	//Set the layout for the frame
    	this.setSize(800,500);
    	this.setTitle("Create Account");
    	this.setLocationRelativeTo(null);				//Centres screen
    	this.setDefaultCloseOperation(EXIT_ON_CLOSE);	//Sets the x button to close program
    	this.setVisible(true);
    }    
    	
    public void actionPerformed(ActionEvent e)
    {
    	
    }
}