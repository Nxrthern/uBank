/**
 * @(#)BankInfo.java
 *
 *
 * @author
 * @version 1.00 2012/6/7
 */

import java.util.*;
import java.io.*;

public class BankInfo
{
	//instance variables
	private int accounts;
	private ArrayList<String> acctNames;
	private int loans;
	private ArrayList<String> loanNames;
	private int investment;
	private ArrayList<String> investNames;

	//default constructor
	public BankInfo()
	{
		accounts = 0;
		acctNames = new ArrayList<String>();
		loans = 0;
		loanNames = new ArrayList<String>();
		investment = 0;
		investNames = new ArrayList<String>();
	}

	//existing user constructor
    public BankInfo(String email) throws IOException
    {
    	String path = "Profiles\\" + email + "\\" + email + "\\BankInfo.txt";
    	initializeFromFile(path);
    }

    //initialize existing user details
    private void initializeFromFile(String path) throws IOException
    {
    	BufferedReader read = new BufferedReader(new FileReader(path));
		acctNames = new ArrayList<String>();
		loanNames = new ArrayList<String>();
		investNames = new ArrayList<String>();

    	accounts = Integer.parseInt(read.readLine());

    	for(int x = 0; x < accounts; x++)
    	{
    		acctNames.add(read.readLine());
    	}

    	loans = Integer.parseInt(read.readLine());

    	for(int x = 0; x < loans; x++)
    	{
    		loanNames.add(read.readLine());
    	}

    	investment = Integer.parseInt(read.readLine());

    	for(int x = 0; x < investment; x++)
    	{
    		investNames.add(read.readLine());
    	}
    }

	public ArrayList<String> getAcctNames()
	{
		return acctNames;
	}

	public ArrayList<String> getLoanNames()
	{
		return loanNames;
	}

	public ArrayList<String> getInvestNames()
	{
		return investNames;
	}

	public int getAccounts()
	{
		return accounts;
	}

	public int getLoans()
	{
		return loans;
	}

	public int getInvestments()
	{
		return investment;
	}

    //saves or overwrites existing file
    public void saveBankInfo(String path) throws IOException
    {
		PrintWriter write = new PrintWriter(new FileWriter(path + "\\BankInfo.txt"), false);

		write.println(accounts);

		for(int x = 0; x < acctNames.size(); x++)
			write.println(acctNames.get(x));

		write.println(loans);

		for(int x = 0; x < loanNames.size(); x++)
			write.println(loanNames.get(x));

		write.println(investment);

		for(int x = 0; x < investNames.size(); x++)
			write.println(investNames.get(x));

		write.close();
    }

    public String toString()
    {
    	String output = accounts + " " + acctNames + " " + loans + " " + loanNames;
    	return output;
    }
}