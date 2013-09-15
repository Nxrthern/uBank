/**
 * @(#)CalculatorScreen.java
 *
 *
 * @author
 * @version 1.00 2012/6/4
 */

//Required imports
	import javax.swing.*;
	import javax.swing.event.*;
	import java.awt.*;
	import java.awt.event.*;
	import java.io.*;
	import java.text.*;

public class CalculatorScreen extends JFrame implements ActionListener
{
	//Screen stuff
	JButton cmdMainMenu = new JButton("Main Menu");
	JButton cmdInterest = new JButton("Interest on Principle");
	JButton cmdFuture = new JButton("Future Value on Principle");
	JButton cmdCalculate = new JButton("Calculate");
	JButton cmdReset = new JButton("Reset");
	JButton cmdMortgagePay = new JButton("Mortgage Payments");
	JButton cmdMortgagePayOff = new JButton("Mortgage Payoff");
	JTextField txtPrinciple = new JTextField(10);
	JLabel lblPrinciple = new JLabel("Principle Amount:");
	JTextField txtRate = new JTextField(10);
	JLabel lblMonthly = new JLabel("Your monthly payment");
	JTextField txtMonthly = new JTextField(10);
	JLabel lblRate = new JLabel("Interest Rate:");
	JTextField txtTime = new JTextField(5);
	JLabel lblTime = new JLabel("Time Frame(in years):");
	JLabel lblComms = new JLabel("");
	
	//Creates components to add image to a label
	ImageIcon imgLogo = new ImageIcon("uBank Banner.png");
	JLabel lblImage = new JLabel(" ", imgLogo, JLabel.CENTER);

	private int flag = 1;

	//Creates an instance for the layout manager
    SpringLayout layout = new SpringLayout();

	//Screen constructor
	public CalculatorScreen()
	{
       	//Adds buttons, text field, and check box to the frame
       	this.add(cmdInterest);
       	this.add(cmdMainMenu);
       	this.add(cmdMortgagePay);
       	this.add(cmdMortgagePayOff);
       	this.add(cmdFuture);
       	this.add(cmdCalculate);
       	this.add(cmdReset);
       	this.add(txtPrinciple);
       	this.add(lblPrinciple);
       	this.add(txtRate);
       	this.add(lblRate);
       	this.add(txtMonthly);
       	this.add(lblMonthly);
       	this.add(txtTime);
       	this.add(lblComms);
       	this.add(lblTime);
       	this.add(lblImage);

		//Set background colours to green
		Color uBankColor = new Color(100, 100, 255);
    	this.getContentPane().setBackground(uBankColor);
    	cmdInterest.setBackground(uBankColor);
    	cmdInterest.setOpaque(false);
		cmdInterest.setContentAreaFilled(false);
		cmdInterest.setFocusPainted(false);
		cmdFuture.setBackground(uBankColor);
    	cmdFuture.setOpaque(false);
		cmdFuture.setContentAreaFilled(false);
		cmdFuture.setFocusPainted(false);
		cmdMortgagePay.setBackground(uBankColor);
    	cmdMortgagePay.setOpaque(false);
		cmdMortgagePay.setContentAreaFilled(false);
		cmdMortgagePay.setFocusPainted(false);
		cmdMortgagePayOff.setBackground(uBankColor);
    	cmdMortgagePayOff.setOpaque(false);
		cmdMortgagePayOff.setContentAreaFilled(false);
		cmdMortgagePayOff.setFocusPainted(false);

    	//Set word to reference the action performed
    	cmdInterest.setActionCommand("interest");
    	cmdFuture.setActionCommand("future");
    	cmdMainMenu.setActionCommand("menu");
    	cmdCalculate.setActionCommand("calculate");
    	cmdMortgagePay.setActionCommand("payments");
    	cmdMortgagePayOff.setActionCommand("payoff");
    	cmdReset.setActionCommand("reset");

		//Add the action listener to different objects
    	cmdInterest.addActionListener(this);
    	cmdMainMenu.addActionListener(this);
    	cmdReset.addActionListener(this);
    	cmdCalculate.addActionListener(this);
    	cmdFuture.addActionListener(this);
    	cmdMortgagePay.addActionListener(this);
    	cmdMortgagePayOff.addActionListener(this);

		//Set the layout for the frame
		this.getContentPane().setLayout(layout);

    	//Set the positions of the buttons on the frame using coordinates
    	layout.putConstraint(SpringLayout.WEST, cmdInterest, 150, SpringLayout.WEST, getContentPane());
    	layout.putConstraint(SpringLayout.NORTH, cmdInterest, 100, SpringLayout.NORTH, getContentPane());

    	layout.putConstraint(SpringLayout.WEST, cmdFuture, 325, SpringLayout.WEST, getContentPane());
    	layout.putConstraint(SpringLayout.NORTH, cmdFuture, 100, SpringLayout.NORTH, getContentPane());
    	
    	layout.putConstraint(SpringLayout.WEST, cmdMortgagePay, 500, SpringLayout.WEST, getContentPane());
    	layout.putConstraint(SpringLayout.NORTH, cmdMortgagePay, 100, SpringLayout.NORTH, getContentPane());
    	
    	layout.putConstraint(SpringLayout.WEST, cmdMortgagePayOff, 150, SpringLayout.WEST, getContentPane());
    	layout.putConstraint(SpringLayout.NORTH, cmdMortgagePayOff, 130, SpringLayout.NORTH, getContentPane());

		layout.putConstraint(SpringLayout.WEST, txtPrinciple, 150, SpringLayout.WEST, getContentPane());
    	layout.putConstraint(SpringLayout.NORTH, txtPrinciple, 200, SpringLayout.NORTH, getContentPane());
    	layout.putConstraint(SpringLayout.WEST, lblPrinciple, 150, SpringLayout.WEST, getContentPane());
    	layout.putConstraint(SpringLayout.NORTH, lblPrinciple, 175, SpringLayout.NORTH, getContentPane());

    	layout.putConstraint(SpringLayout.WEST, txtRate, 150, SpringLayout.WEST, getContentPane());
    	layout.putConstraint(SpringLayout.NORTH, txtRate, 265, SpringLayout.NORTH, getContentPane());
    	layout.putConstraint(SpringLayout.WEST, lblRate, 150, SpringLayout.WEST, getContentPane());
    	layout.putConstraint(SpringLayout.NORTH, lblRate, 240, SpringLayout.NORTH, getContentPane());

    	layout.putConstraint(SpringLayout.WEST, txtTime, 150, SpringLayout.WEST, getContentPane());
    	layout.putConstraint(SpringLayout.NORTH, txtTime, 330, SpringLayout.NORTH, getContentPane());
    	layout.putConstraint(SpringLayout.WEST, lblTime, 150, SpringLayout.WEST, getContentPane());
    	layout.putConstraint(SpringLayout.NORTH, lblTime, 305, SpringLayout.NORTH, getContentPane());

		layout.putConstraint(SpringLayout.WEST, txtMonthly, 150, SpringLayout.WEST, getContentPane());
    	layout.putConstraint(SpringLayout.NORTH, txtMonthly, 330, SpringLayout.NORTH, getContentPane());
    	layout.putConstraint(SpringLayout.WEST, lblMonthly, 150, SpringLayout.WEST, getContentPane());
    	layout.putConstraint(SpringLayout.NORTH, lblMonthly, 305, SpringLayout.NORTH, getContentPane());

    	layout.putConstraint(SpringLayout.WEST, cmdCalculate, 250, SpringLayout.WEST, getContentPane());
    	layout.putConstraint(SpringLayout.NORTH, cmdCalculate, 400, SpringLayout.NORTH, getContentPane());

    	layout.putConstraint(SpringLayout.WEST, cmdReset, 350, SpringLayout.WEST, getContentPane());
    	layout.putConstraint(SpringLayout.NORTH, cmdReset, 400, SpringLayout.NORTH, getContentPane());

    	layout.putConstraint(SpringLayout.WEST, cmdMainMenu, 20, SpringLayout.WEST, getContentPane());
    	layout.putConstraint(SpringLayout.NORTH, cmdMainMenu, 150, SpringLayout.NORTH, getContentPane());

    	layout.putConstraint(SpringLayout.WEST, lblComms, 300, SpringLayout.WEST, getContentPane());
		layout.putConstraint(SpringLayout.NORTH, lblComms, 300, SpringLayout.NORTH, getContentPane());

    	//Set the layout for the frame
    	this.setSize(800, 500);
    	this.setTitle("Calculator");
    	this.setLocationRelativeTo(null);				//Centres screen
    	this.setDefaultCloseOperation(EXIT_ON_CLOSE);	//Sets the x button to close program
    	this.setVisible(true);
    	txtMonthly.setVisible(false);
    	lblMonthly.setVisible(false);
	}//End of screen constructor

	//This method determines which component has fired and how to proceed
    public void actionPerformed(ActionEvent e)
    {
    	//Tests which action has fired
		if(e.getActionCommand().equals("menu"))
    	{
    		//Switch frames
    		this.setVisible(false);
    		LoginScreen.mainFrame.setVisible(true);
    	}
    	else if(e.getActionCommand().equals("interest"))
    	{
    		txtMonthly.setVisible(false);
    		lblMonthly.setVisible(false);
    		txtTime.setVisible(true);
    		lblTime.setVisible(true);
			flag = 1;
    	}
    	else if(e.getActionCommand().equals("future"))
    	{
    		txtMonthly.setVisible(false);
    		lblMonthly.setVisible(false);
    		txtTime.setVisible(true);
    		lblTime.setVisible(true);
    		flag = 2;
    	}
    	else if(e.getActionCommand().equals("payoff"))
    	{
    		txtMonthly.setVisible(true);
    		lblMonthly.setVisible(true);
    		txtTime.setVisible(false);
    		lblTime.setVisible(false);
    		flag = 4;
    	}
    	else if(e.getActionCommand().equals("payments"))
    	{
    		txtMonthly.setVisible(false);
    		lblMonthly.setVisible(false);
    		txtTime.setVisible(true);
    		lblTime.setVisible(true);
    		flag = 3;
    	}
    	else if(e.getActionCommand().equals("calculate"))
    	{
    		//Test which flag is active for method calls
    		if(flag == 1)
    			calculateInterest();
    		else if(flag == 2)
    			calculateFutureValue();
    		else if(flag == 3)
    			calculatePayments();
    		else if(flag == 4)
    			calculatePaidOff();
    	}
    	else if(e.getActionCommand().equals("reset"))
    	{
    		txtTime.setText("");
    		txtRate.setText("");
    		txtPrinciple.setText("");
    		lblComms.setText("");
    		txtMonthly.setText("");
    		txtPrinciple.grabFocus();
    	}//End of action fired check
    }//End of action performed
    
    //Method calculates payments monthly to pay off mortgage
    private void calculatePayments()
    {
    	//Declare and initialize variables
    	NumberFormat nfc = NumberFormat.getCurrencyInstance();
    	double principle = Double.parseDouble(txtPrinciple.getText());
		double futureValue = principle;
		double time = Double.parseDouble(txtTime.getText()) * 12;
		double monthRate = 1 + Double.parseDouble(txtRate.getText());
		monthRate = Math.pow(monthRate, (double)1/12);
    	double payments = 0.0;
    	
    	//Loop through time frame
    	for(int x = 0; x < time; x++)
    	{
    		futureValue = futureValue * monthRate;
    		
    		//Check for years
    		if(x % 12 == 0)
    		{
    			payments = payments + futureValue / 12;
    			futureValue = futureValue - payments * 12;
    		}//End of years check
    	}//End of loop
    	
    	//Find payments value
    	payments = payments / (time / 12);
    	
    	//Output info
    	lblComms.setText("<html>The value " + nfc.format(Double.parseDouble(txtPrinciple.getText())) + 
    		" ca be paid off within that time frame if a monthly payment of " + nfc.format(payments) + " is made.<br>This is an estimate, it is likely you are able to pay much less.<html>");
    }//End of calculatepayments method
    
    //Method calculates how long it takes to pay something off given a monthly payment
    private void calculatePaidOff()
    {
    	//Declare and initialize variables
    	NumberFormat nfc = NumberFormat.getCurrencyInstance();
    	double futureValue = Double.parseDouble(txtPrinciple.getText());
    	double payments = Double.parseDouble(txtMonthly.getText());
    	double yearsToPay = 0;
    	double monthRate = 1 + Double.parseDouble(txtRate.getText());
    	monthRate = Math.pow(monthRate, (double)1/12);
    	int counter = 0;
   
   		//Loop until future value hits 0
    	while(futureValue > 0)
    	{
    		//Adjust futureValue monthly
    		futureValue += -payments;
    		futureValue = futureValue * monthRate;
    		counter++;
    		
    		if(counter % 12 == 0)
    			yearsToPay++;
    		
    		//Check for taking too long and stop the process
    		if(yearsToPay > 100)
    		{
    			lblComms.setText("It will take more than a century to pay the martgage at that payment.");
    			return;
    		}//End of too long check
    	}//End of loop
  
  		//Output
    	lblComms.setText("<html>You will be able to pay off the amount of <br>" + nfc.format(Double.parseDouble(txtPrinciple.getText())) + " in " + yearsToPay + " years at the current rate of " + txtRate.getText() + ".<html>");
    }//End of calculatePaidOff method

	//Calculate the future value on annuity
    private void calculateFutureValue()
    {
    	//Declare calculate and output
    	NumberFormat nfc = NumberFormat.getCurrencyInstance();
    	double futureValue = Double.parseDouble(txtPrinciple.getText()) * Math.pow((1 + Double.parseDouble(txtRate.getText())), Double.parseDouble(txtTime.getText()));
    	lblComms.setText("<html>The value " + nfc.format(Double.parseDouble(txtPrinciple.getText())) + " will increase to<br>" + nfc.format(futureValue) + " at a rate of " + txtRate.getText() + " over " + txtTime.getText() + " years.<html>");
    }//End of calculateFutureValue method
	
	//Method will calculate interest on annuity
    private void calculateInterest()
    {
    	//Declare calculate and output
    	NumberFormat nfc = NumberFormat.getCurrencyInstance();
    	double interest = Double.parseDouble(txtPrinciple.getText()) * Double.parseDouble(txtRate.getText()) * Double.parseDouble(txtTime.getText());
    	lblComms.setText("<html>The value " + nfc.format(Double.parseDouble(txtPrinciple.getText())) + " will total<br>" + nfc.format(interest) + " interest at a rate of " + txtRate.getText() + " over " + txtTime.getText() + " years.<html>");
    }//End of calculateInterest method
}//End of class