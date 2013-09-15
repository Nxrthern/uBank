//Bradley Hamelin / Bowden
//MainScreen V0.9 - It sure as hell aint pretty but it's 100% functional.

	import java.awt.*;
	import java.awt.event.*;
	import javax.swing.*;
	import java.util.*;

public class MainScreen extends JFrame implements ActionListener
{
	//Fields to hold the amount of accounts the user has and their names
	int numBanks;
	ArrayList<String> accountNames;
	int numLoans;
	ArrayList<String> loanNames;
	int numInvests;
	ArrayList<String> investNames;

	//Create the buttons to see other screens
	JButton cmdHelp = new JButton ("Help");
	JButton cmdAbout = new JButton ("About");
	JButton cmdOptions = new JButton ("Options");
	JButton cmdLogOut = new JButton ("Log Out");

	JButton cmdSelectNewAccounts = new JButton ("Create New Account");
	JButton cmdSelectViewAccounts = new JButton ("View Accounts");
	JButton cmdSelectLedger = new JButton ("Ledger");
	JButton cmdSelectCalculator = new JButton ("Calculators");

	JButton cmdNewBankAccount = new JButton ("New Bank Account");
	JButton cmdNewLoanAccount = new JButton ("New Loan Account");
	JButton cmdNewInvestmentAccount = new JButton ("New Investment Account");
	JButton cmdNewCreditCardAccount = new JButton ("New Credit Card Account");
	JButton cmdNewDebitCardAccount = new JButton ("New Debit Card Account");

	JButton cmdBank1 = new JButton();
	JButton cmdBank2 = new JButton();
	JButton cmdBank3 = new JButton();
	JButton cmdBank4 = new JButton();

	JButton cmdLoan1 = new JButton();
	JButton cmdLoan2 = new JButton();
	JButton cmdLoan3 = new JButton();
	JButton cmdLoan4 = new JButton();

	JButton cmdInvestment1 = new JButton();
	JButton cmdInvestment2 = new JButton();
	JButton cmdInvestment3 = new JButton();
	JButton cmdInvestment4 = new JButton();

	JLabel lblMain = new JLabel ("Main Menu");

	//Create an instance of the layout manager
	SpringLayout layout = new SpringLayout();

    public MainScreen(User user)
    {
    	//Initialize fields
    	this.numBanks = user.getBankInfo().getAccounts();
    	this.accountNames = user.getBankInfo().getAcctNames();
    	this.numLoans = user.getBankInfo().getLoans();
    	this.loanNames = user.getBankInfo().getLoanNames();
    	this.numInvests = user.getBankInfo().getInvestments();
    	this.investNames = user.getBankInfo().getInvestNames();

    	//Initialize GUI components
    	this.add(cmdHelp);
    	this.add(cmdAbout);
    	this.add(cmdOptions);
    	this.add(cmdLogOut);
    	this.add(cmdSelectNewAccounts);
    	this.add(cmdSelectViewAccounts);
    	this.add(cmdSelectLedger);
    	this.add(cmdSelectCalculator);
    	this.add(cmdNewBankAccount);
    	this.add(cmdNewLoanAccount);
    	this.add(cmdNewInvestmentAccount);
    	this.add(cmdNewCreditCardAccount);
    	this.add(cmdNewDebitCardAccount);
    	this.add(cmdBank1);
    	this.add(cmdBank2);
    	this.add(cmdBank3);
    	this.add(cmdBank4);
    	this.add(cmdLoan1);
    	this.add(cmdLoan2);
    	this.add(cmdLoan3);
    	this.add(cmdLoan4);
    	this.add(cmdInvestment1);
    	this.add(cmdInvestment2);
    	this.add(cmdInvestment3);
    	this.add(cmdInvestment4);
    	this.add(lblMain);

    	System.out.println(user);

    	//Format buttons
    	cmdHelp.setPreferredSize(new Dimension(150,40));
    	cmdAbout.setPreferredSize(new Dimension(150,40));
    	cmdOptions.setPreferredSize(new Dimension(150,40));
    	cmdLogOut.setPreferredSize(new Dimension(150,40));
    	cmdSelectNewAccounts.setPreferredSize(new Dimension(150,40));
    	cmdSelectViewAccounts.setPreferredSize(new Dimension(150,40));
		cmdSelectLedger.setPreferredSize(new Dimension(150,40));
		cmdSelectCalculator.setPreferredSize(new Dimension(150,40));


    	cmdHelp.setFont(new Font("Gill Sans MT", Font.PLAIN, 20));
    	cmdHelp.setForeground(Color.black);
    	cmdAbout.setFont(new Font("Gill Sans MT", Font.PLAIN, 20));
    	cmdAbout.setForeground(Color.black);
    	cmdOptions.setFont(new Font("Gill Sans MT", Font.PLAIN, 20));
    	cmdOptions.setForeground(Color.black);
    	cmdLogOut.setFont(new Font("Gill Sans MT", Font.PLAIN, 20));
    	cmdLogOut.setForeground(Color.black);

    	//Set the frame colour
		Color babyBlue = new Color(100,100,255);
    	this.getContentPane().setBackground(babyBlue);

    	//Name the buttons
		cmdHelp.setActionCommand("help");
		cmdAbout.setActionCommand("about");
		cmdOptions.setActionCommand("options");
		cmdLogOut.setActionCommand("logOut");

		cmdSelectNewAccounts.setActionCommand("selectNewAccounts");
		cmdSelectViewAccounts.setActionCommand("selectViewAccounts");
		cmdSelectLedger.setActionCommand("selectLedger");
		cmdSelectCalculator.setActionCommand("selectCalculator");

		cmdNewBankAccount.setActionCommand("newBankAccount");
    	cmdNewLoanAccount.setActionCommand("newLoanAccount");
    	cmdNewInvestmentAccount.setActionCommand("newInvestmentAccount");
    	cmdNewCreditCardAccount.setActionCommand("newCreditCardAccount");
    	cmdNewDebitCardAccount.setActionCommand("newDebitCardAccount");
    	cmdBank1.setActionCommand("bank1");
    	cmdBank2.setActionCommand("bank2");
    	cmdBank3.setActionCommand("bank3");
    	cmdBank4.setActionCommand("bank4");
    	cmdLoan1.setActionCommand("loan1");
    	cmdLoan2.setActionCommand("loan2");
    	cmdLoan3.setActionCommand("loan3");
    	cmdLoan4.setActionCommand("loan4");
    	cmdInvestment1.setActionCommand("invest1");
    	cmdInvestment2.setActionCommand("invest2");
    	cmdInvestment3.setActionCommand("invest3");
    	cmdInvestment4.setActionCommand("invest4");

    	//Add the action listener
    	cmdHelp.addActionListener(this);
		cmdAbout.addActionListener(this);
		cmdOptions.addActionListener(this);
		cmdLogOut.addActionListener(this);

		cmdSelectNewAccounts.addActionListener(this);
		cmdSelectViewAccounts.addActionListener(this);
		cmdSelectLedger.addActionListener(this);
		cmdSelectCalculator.addActionListener(this);

		cmdNewBankAccount.addActionListener(this);
    	cmdNewLoanAccount.addActionListener(this);
    	cmdNewInvestmentAccount.addActionListener(this);
    	cmdNewCreditCardAccount.addActionListener(this);
    	cmdNewDebitCardAccount.addActionListener(this);
    	cmdBank1.addActionListener(this);
    	cmdBank2.addActionListener(this);
    	cmdBank3.addActionListener(this);
    	cmdBank4.addActionListener(this);
    	cmdLoan1.addActionListener(this);
    	cmdLoan2.addActionListener(this);
    	cmdLoan3.addActionListener(this);
    	cmdLoan4.addActionListener(this);
    	cmdInvestment1.addActionListener(this);
    	cmdInvestment2.addActionListener(this);
    	cmdInvestment3.addActionListener(this);
    	cmdInvestment4.addActionListener(this);

    	//Set the layout for the frame
		this.getContentPane().setLayout(layout);

		//Set the north and west positions for the components
		//Place the base buttons in their places
		layout.putConstraint(SpringLayout.WEST, cmdHelp, 10, SpringLayout.WEST, getContentPane());
		layout.putConstraint(SpringLayout.NORTH, cmdHelp, 10, SpringLayout.NORTH, getContentPane());

		layout.putConstraint(SpringLayout.WEST, cmdAbout, 210, SpringLayout.WEST, getContentPane());
		layout.putConstraint(SpringLayout.NORTH, cmdAbout, 10, SpringLayout.NORTH, getContentPane());

		layout.putConstraint(SpringLayout.WEST, cmdOptions, 410, SpringLayout.WEST, getContentPane());
		layout.putConstraint(SpringLayout.NORTH, cmdOptions, 10, SpringLayout.NORTH, getContentPane());

		layout.putConstraint(SpringLayout.WEST, cmdLogOut, 610, SpringLayout.WEST, getContentPane());
		layout.putConstraint(SpringLayout.NORTH, cmdLogOut, 10, SpringLayout.NORTH, getContentPane());

		layout.putConstraint(SpringLayout.WEST, cmdSelectNewAccounts, 10, SpringLayout.WEST, getContentPane());
		layout.putConstraint(SpringLayout.NORTH, cmdSelectNewAccounts, 70, SpringLayout.NORTH, getContentPane());

		layout.putConstraint(SpringLayout.WEST, cmdSelectViewAccounts, 210, SpringLayout.WEST, getContentPane());
		layout.putConstraint(SpringLayout.NORTH, cmdSelectViewAccounts, 70, SpringLayout.NORTH, getContentPane());

		layout.putConstraint(SpringLayout.WEST, cmdSelectLedger, 410, SpringLayout.WEST, getContentPane());
		layout.putConstraint(SpringLayout.NORTH, cmdSelectLedger, 70, SpringLayout.NORTH, getContentPane());

		layout.putConstraint(SpringLayout.WEST, cmdSelectCalculator, 610, SpringLayout.WEST, getContentPane());
		layout.putConstraint(SpringLayout.NORTH, cmdSelectCalculator, 70, SpringLayout.NORTH, getContentPane());

		//Place the account buttons in their places
		layout.putConstraint(SpringLayout.WEST, cmdBank1, 10, SpringLayout.WEST, getContentPane());
		layout.putConstraint(SpringLayout.NORTH, cmdBank1, 130, SpringLayout.NORTH, getContentPane());

		layout.putConstraint(SpringLayout.WEST, cmdBank2, 210, SpringLayout.WEST, getContentPane());
		layout.putConstraint(SpringLayout.NORTH, cmdBank2, 130, SpringLayout.NORTH, getContentPane());

		layout.putConstraint(SpringLayout.WEST, cmdBank3, 410, SpringLayout.WEST, getContentPane());
		layout.putConstraint(SpringLayout.NORTH, cmdBank3, 130, SpringLayout.NORTH, getContentPane());

		layout.putConstraint(SpringLayout.WEST, cmdBank4, 610, SpringLayout.WEST, getContentPane());
		layout.putConstraint(SpringLayout.NORTH, cmdBank4, 130, SpringLayout.NORTH, getContentPane());

		layout.putConstraint(SpringLayout.WEST, cmdLoan1, 10, SpringLayout.WEST, getContentPane());
		layout.putConstraint(SpringLayout.NORTH, cmdLoan1, 200, SpringLayout.NORTH, getContentPane());

		layout.putConstraint(SpringLayout.WEST, cmdLoan2, 210, SpringLayout.WEST, getContentPane());
		layout.putConstraint(SpringLayout.NORTH, cmdLoan2, 200, SpringLayout.NORTH, getContentPane());

		layout.putConstraint(SpringLayout.WEST, cmdLoan3, 410, SpringLayout.WEST, getContentPane());
		layout.putConstraint(SpringLayout.NORTH, cmdLoan3, 200, SpringLayout.NORTH, getContentPane());

		layout.putConstraint(SpringLayout.WEST, cmdLoan4, 610, SpringLayout.WEST, getContentPane());
		layout.putConstraint(SpringLayout.NORTH, cmdLoan4, 200, SpringLayout.NORTH, getContentPane());

		layout.putConstraint(SpringLayout.WEST, cmdInvestment1, 10, SpringLayout.WEST, getContentPane());
		layout.putConstraint(SpringLayout.NORTH, cmdInvestment1, 270, SpringLayout.NORTH, getContentPane());

		layout.putConstraint(SpringLayout.WEST, cmdInvestment2, 210, SpringLayout.WEST, getContentPane());
		layout.putConstraint(SpringLayout.NORTH, cmdInvestment2, 270, SpringLayout.NORTH, getContentPane());

		layout.putConstraint(SpringLayout.WEST, cmdInvestment3, 410, SpringLayout.WEST, getContentPane());
		layout.putConstraint(SpringLayout.NORTH, cmdInvestment3, 270, SpringLayout.NORTH, getContentPane());

		layout.putConstraint(SpringLayout.WEST, cmdInvestment4, 610, SpringLayout.WEST, getContentPane());
		layout.putConstraint(SpringLayout.NORTH, cmdInvestment4, 270, SpringLayout.NORTH, getContentPane());

		//Place the new buttons in their places
		layout.putConstraint(SpringLayout.WEST, cmdNewBankAccount, 10, SpringLayout.WEST, getContentPane());
		layout.putConstraint(SpringLayout.NORTH, cmdNewBankAccount, 130, SpringLayout.NORTH, getContentPane());

		layout.putConstraint(SpringLayout.WEST, cmdNewLoanAccount, 240, SpringLayout.WEST, getContentPane());
		layout.putConstraint(SpringLayout.NORTH, cmdNewLoanAccount, 130, SpringLayout.NORTH, getContentPane());

		layout.putConstraint(SpringLayout.WEST, cmdNewInvestmentAccount, 10, SpringLayout.WEST, getContentPane());
		layout.putConstraint(SpringLayout.NORTH, cmdNewInvestmentAccount, 200, SpringLayout.NORTH, getContentPane());

		layout.putConstraint(SpringLayout.WEST, cmdNewCreditCardAccount, 100, SpringLayout.WEST, getContentPane());
		layout.putConstraint(SpringLayout.NORTH, cmdNewCreditCardAccount, 270, SpringLayout.NORTH, getContentPane());

		layout.putConstraint(SpringLayout.WEST, cmdNewDebitCardAccount, 400, SpringLayout.WEST, getContentPane());
		layout.putConstraint(SpringLayout.NORTH, cmdNewDebitCardAccount, 270, SpringLayout.NORTH, getContentPane());

		//Set up methods for the frame
		setSize(800,500);
		setLocationRelativeTo(null);
		setTitle("Main Menu");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		//Set inital option open
		selectNewAccounts();

    }//End of constructor

	private void help()
	{
		//HelpScreen nextFrame = new HelpScreen();
			this.setVisible(false);
	}//End of help method

	private void about()
	{
		//AboutScreen nextFrame = new AboutScreen();
			this.setVisible(false);
	}//End of about method

	private void options()
	{
		//SettingsScreen nextFrame = new SettingsScreen();
			this.setVisible(false);
	}//End of setVisible method

	private void logOut()
	{
		LoginScreen nextFrame = new LoginScreen();
			this.setVisible(false);
	}//End of logOut method

	private void selectNewAccounts()
	{
		cmdNewBankAccount.setVisible(true);
    	cmdNewLoanAccount.setVisible(true);
    	cmdNewInvestmentAccount.setVisible(true);
    	cmdNewCreditCardAccount.setVisible(true);
    	cmdNewDebitCardAccount.setVisible(true);
    	cmdBank1.setVisible(false);
    	cmdBank2.setVisible(false);
    	cmdBank3.setVisible(false);
    	cmdBank4.setVisible(false);
    	cmdLoan1.setVisible(false);
    	cmdLoan2.setVisible(false);
    	cmdLoan3.setVisible(false);
    	cmdLoan4.setVisible(false);
    	cmdInvestment1.setVisible(false);
    	cmdInvestment2.setVisible(false);
    	cmdInvestment3.setVisible(false);
    	cmdInvestment4.setVisible(false);
	}//End of selectNewAccounts method

	private void selectViewAccounts()
	{
		cmdNewBankAccount.setVisible(false);
    	cmdNewLoanAccount.setVisible(false);
    	cmdNewInvestmentAccount.setVisible(false);
    	cmdNewCreditCardAccount.setVisible(false);
    	cmdNewDebitCardAccount.setVisible(false);

		if(numBanks >= 1)
		{
    		cmdBank1.setVisible(true);
    		cmdBank1.setText(accountNames.get(0));
		}
    	if(numBanks >= 2)
    	{
    		cmdBank2.setVisible(true);
    		cmdBank2.setText(accountNames.get(1));
    	}
    	if(numBanks >= 3)
    	{
    		cmdBank3.setVisible(true);
    		cmdBank3.setText(accountNames.get(2));
    	}
    	if(numBanks >= 4)
    	{
    		cmdBank4.setVisible(true);
    		cmdBank4.setText(accountNames.get(3));
    	}

    	if(numLoans >= 1)
    	{
    		cmdLoan1.setVisible(true);
    		cmdLoan1.setText(loanNames.get(0));
    	}
    	if(numLoans >= 2)
    	{
    		cmdLoan2.setVisible(true);
    		cmdLoan2.setText(loanNames.get(1));
    	}
    	if(numLoans >= 3)
    	{
    		cmdLoan3.setVisible(true);
    		cmdLoan3.setText(loanNames.get(2));
    	}
    	if(numLoans >= 4)
    	{
    		cmdLoan4.setVisible(true);
    		cmdLoan4.setText(loanNames.get(3));
    	}

    	if(numInvests >= 1)
    	{
    		cmdInvestment1.setVisible(false);
    		cmdInvestment1.setText(investNames.get(0));
    	}
    	if(numInvests >= 2)
    	{
    		cmdInvestment2.setVisible(false);
    		cmdInvestment2.setText(investNames.get(1));
    	}
    	if(numInvests >= 3)
    	{
    		cmdInvestment3.setVisible(false);
    		cmdInvestment3.setText(investNames.get(2));
    	}
    	if(numInvests >= 4)
    	{
    		cmdInvestment4.setVisible(false);
    		cmdInvestment4.setText(investNames.get(3));
    	}
	}//End of selectViewAccounts method

	/*private void selectLedger()
	{
		LedgerScreen nextFrame = new LedgerScreen();
		this.setVisible(false);
	}//End of selectLedger method*/

	private void selectCalculator()
	{
		CalculatorScreen nextFrame = new CalculatorScreen();
		LoginScreen.mainFrame.setVisible(false);
	}//End of selectCalculator method
/*
	private void newBankAccount()
	{
		CreateAccountScreen nextFrame = new CreateAccountScreen();
		this.setVisible(false);
	}//End of newBankAccount method

	private void newLoanAccount()
	{
		CreateLoanScreen nextFrame = new CreateLoanScreen();
		this.setVisible(false);
	}//End of newLoanAccount method

	private void newInvestmentAccount()
	{
		CreateInvestmentScreen nextFrame = new CreateInvestmentScreen();
		this.setVisible(false);
	}//End of newInvestmentAccount method

	private void newCreditCardAccount()
	{
		CreateCreditCardScreen nextFrame = new CreateCreditCardScreen();
		this.setVisible(false);
	}//End of newCreditCardAccount method

	private void newDebitCardAccount()
	{
		CreateDebitCardScreen nextFrame = new CreateDebitCardScreen();
		this.setVisible(false);
	}//End of newDebitCardAccount method

	private void viewBank1()
	{
		AccountDisplayScreen nextFrame = new AccountDisplayScreen(accountNames[0]);
		this.setVisible(false);
	}//End of viewBank1 method

	private void viewBank2()
	{
		AccountDisplayScreen nextFrame = new AccountDisplayScreen(accountNames[1]);
		this.setVisible(false);
	}//End of viewBank2 method

	private void viewBank3()
	{
		AccountDisplayScreen nextFrame = new AccountDisplayScreen(accountNames[2]);
		this.setVisible(false);
	}//End of viewBank3 method

	private void viewBank4()
	{
		AccountDisplayScreen nextFrame = new AccountDisplayScreen(accountNames[3]);
		this.setVisible(false);
	}//End of viewBank4 method

	private void viewLoan1()
	{
		AccountDisplayScreen nextFrame = new AccountDisplayScreen(loanNames[0]);
		this.setVisible(false);
	}//End of viewLoan1 method

	private void viewLoan2()
	{
		AccountDisplayScreen nextFrame = new AccountDisplayScreen(loanNames[1]);
		this.setVisible(false);
	}//End of viewLoan2 method

	private void viewLoan3()
	{
		AccountDisplayScreen nextFrame = new AccountDisplayScreen(loanNames[2]);
		this.setVisible(false);
	}//End of viewLoan3 method

	private void viewLoan4()
	{
		AccountDisplayScreen nextFrame = new AccountDisplayScreen(loanNames[3]);
		this.setVisible(false);
	}//End of viewLoan4 method

	private void viewInvest1()
	{
		AccountDisplayScreen nextFrame = new AccountDisplayScreen(investNames[0]);
		this.setVisible(false);
	}//End of viewInvest1 method

	private void viewInvest2()
	{
		AccountDisplayScreen nextFrame = new AccountDisplayScreen(investNames[1]);
		this.setVisible(false);
	}//End of viewInvest2 method

	private void viewInvest3()
	{
		AccountDisplayScreen nextFrame = new AccountDisplayScreen(investNames[2]);
		this.setVisible(false);
	}//End of viewInvest3 method

	private void viewInvest4()
	{
		AccountDisplayScreen nextFrame = new AccountDisplayScreen(investNames[3]);
		this.setVisible(false);
	}*///End of viewInvest4 method

	//Create actions
	public void actionPerformed(ActionEvent evt)
	{
		/*Make actions for Top buttons
		if (evt.getActionCommand().equals("help"))
			help();
		else if (evt.getActionCommand().equals("about"))
			about();
		else if (evt.getActionCommand().equals("options"))
			options();
		else if (evt.getActionCommand().equals("logOut"))
			logOut();

		//Make actions for selection buttons
		else if (evt.getActionCommand().equals("selectNewAccounts"))
		//	selectNewAccounts();
		else if (evt.getActionCommand().equals("selectViewAccounts"))
		//	selectViewAccounts();
		else if (evt.getActionCommand().equals("selectLedger"))
			//selectLedger();
		else */if (evt.getActionCommand().equals("selectCalculator"))
			selectCalculator();
/*
		//Make actions for new account buttons
		else if (evt.getActionCommand().equals("newBankAccount"))
		//	newBankAccount();
		else if (evt.getActionCommand().equals("newLoanAccount"))
		//	newLoanAccount();
		else if (evt.getActionCommand().equals("newInvestmentAccount"))
			//newInvestmentAccount();
		else if (evt.getActionCommand().equals("newCreditCardAccount"))
			//newCreditCardAccount();
		else if (evt.getActionCommand().equals("newDebitCardAccount"))
			//newDebitCardAccount();

		//Make actions for view account buttons
		else if (evt.getActionCommand().equals("bank1"))
			//viewBank1();
		else if (evt.getActionCommand().equals("bank2"))
			//viewBank2();
		else if (evt.getActionCommand().equals("bank3"))
			//viewBank3();
		else if (evt.getActionCommand().equals("bank4"))
			//viewBank4();
		else if (evt.getActionCommand().equals("loan1"))
			//viewLoan1();
		else if (evt.getActionCommand().equals("loan2"))
			//viewLoan2();
		else if (evt.getActionCommand().equals("loan3"))
			//viewLoan3();
		else if (evt.getActionCommand().equals("loan4"))
			//viewLoan4();
		else if (evt.getActionCommand().equals("invest1"))
			//viewInvest1();
		else if (evt.getActionCommand().equals("invest2"))
			//viewInvest2();
		else if (evt.getActionCommand().equals("invest3"))
			//viewInvest3();
		else if (evt.getActionCommand().equals("invest4"))
			//viewInvest4();
*/
	}//End of actionPerformed method

}//End of class
