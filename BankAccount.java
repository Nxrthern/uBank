//Creates a Bank Account object that holds the money of the user

import java.io.*;
import java.util.*;

public class BankAccount
{
	//Declare class fields
	private String accountName;
	private String accountType;
	private double balance;
	private double interestRate;
	private int transactionsMade;
	private int transactionsMax;
	private Date lastLoggedDate;
	private String fileName;

	//Declare and initialize field of the current date
	static Calendar current = Calendar.getInstance();
	static int day = current.get(Calendar.DAY_OF_MONTH);
	static int month = current.get(Calendar.MONTH);
	static int year = current.get(Calendar.YEAR);
	public static Date currentDate = new Date(day, month, year);

	//Creates a default BankAccount
    public BankAccount()
    {
    	accountName = "No Accounts Found";
    	accountType = "";
    	balance = 0.0;
    	interestRate = 0.0;
    	transactionsMade = 0;
    	transactionsMax = 0;
    	lastLoggedDate = new Date();
    }//End of default constructor

    //Creates a specialized bank account
    public BankAccount(String fileName) throws IOException
    {
    	balance = 0.0;
    	
    	initializeFromFile(fileName + "//Data.txt");
    	this.fileName = fileName;

    	//Calculate the interest gained since last log
    	this.calculateInterest();
    }//End of client constructor
    
    public void initializeFromFile(String fileName) throws IOException
    {  	
    	//Create a read object
	    BufferedReader input = new BufferedReader (new FileReader(fileName));
	
	    //Initialize the bank account info
	    accountName = input.readLine();
	    accountType = input.readLine();
	    balance = Double.parseDouble(input.readLine());
	    interestRate = Double.parseDouble(input.readLine());
	    transactionsMade = Integer.parseInt(input.readLine());
	    transactionsMax = Integer.parseInt(input.readLine());
	
	    //Initialize the Date
		String [] temp = (input.readLine().split(","));
		int day = Integer.parseInt(temp[0]);
		int month = Integer.parseInt(temp[1]);
		int year = Integer.parseInt(temp[2]);
		lastLoggedDate = new Date (day,month,year);
    }//End of initializeFromFile method

    //A method to deposit funds
    public void depositFunds(double deposit) throws IOException
    {
    	balance += deposit;
    	transactionsMade ++;
    	if (transactionsMade > transactionsMax)
    	{
    		balance -=2.00;
    		//Let user know they have passed max transactions
    	}
    	//Update the transaction history
    	updateHistory(deposit, true);
    }//End of depositFunds method

    //A method to withdraw funds
    public void withdrawFunds(double withdrawal) throws IOException
    {
    	balance-=withdrawal;
    	transactionsMade++;
    	if(transactionsMade > transactionsMax)
    	{
    		balance -= 2.00;
    		//Let user know they have passed maximum transactions
    	}
    	updateHistory(withdrawal, false);
    }//End of withdraw method

    //A method to update the bank accounts's text file
    public void updateAccount() throws IOException
    {
    	//Create a write object
    	PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(fileName + "\\Data.txt")));
	
	    //Update the file
    	output.println(accountName);
    	output.println(accountType);
	    output.println(balance);
	    output.println(interestRate);
	    output.println(transactionsMade);
	    output.println(transactionsMax);
	    output.println(currentDate);

    	output.close();
    }//End of updateAccount method

    //A method to calculate the interest gained since the last log in
    private void calculateInterest()
    {
	    //Calculate the difference in months
	    int monthsPassed = currentDate.calculateMonthDifference(lastLoggedDate);

	    for(int x = 0; x < monthsPassed; x++)
	    {
	    	balance += balance * interestRate;
	    }

    }//End of calulateInterest method

    //A method to update the text file of this bank
    public void updateHistory(double moneyAmount, boolean isDeposit)throws IOException
    {
    	int records = 1;//Keeps track of how many histories have been read through

    	//Create a read object
    	BufferedReader input = new BufferedReader(new FileReader(fileName + "\\History.txt"));

    	//create two arrays to hold the history in
    	String [] historyMoney = new String [10];
    	String [] historyDate = new String [10];

    	//Put the new data in the first elements
    	if (isDeposit == true)
    	{
    		historyMoney[0] = Double.toString(moneyAmount);
    	}
    	else
    		historyMoney[0] = "-" + Double.toString(moneyAmount);

    	historyDate[0] = currentDate.toString();

    	//Read in the data
    	while(input!= null && records < 10)
    	{
			historyMoney[records] = input.readLine();
			historyDate[records] = input.readLine();
			records++;
    	}
    	//Output the new arrays to the text file
    	PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(fileName + "\\History.txt")));
    	
    	for (int x = 0; x < records; x++)
    	{
    		output.println(historyMoney[x]);
    		output.println(historyDate[x]);
    	}
    	output.close();
    }//End of updateHistory method
    
    public void closeAccount(String accountName)
    {
    	
    }
}//End of class