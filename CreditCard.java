
import java.io.*;

public class CreditCard
{
	//Declare class variables
	private String cardID;
	private int verifier;

	//Default constructor
    public CreditCard()
    {
    	cardID = "";
    	verifier = 0;
    }//End of default constructor

	//Constructs a credit card from file
    public CreditCard(String email) throws IOException
    {
    	initializeFromFile(email);
    }//End of constructor

	//Method will initialize variables from file
    private void initializeFromFile(String email) throws IOException
    {
    	String path = "Profiles\\" + email + "\\" + email + "\\CreditCard.txt";

    	BufferedReader read = new BufferedReader(new FileReader(path));

    	cardID = read.readLine();
    	verifier = Integer.parseInt(read.readLine());
    }//End of initialize from file method

	//Method will save a new credit card object
    public void saveCreditCard(String path) throws IOException
    {
		PrintWriter write = new PrintWriter(new FileWriter(path + "\\CreditCard.txt", false));

		write.println(cardID);
		write.println(verifier);

		write.close();
    }//End of save credit card method
	
	//Respresents object as a string
    public String toString()
    {
    	String output = cardID + " " + verifier;
    	return output;
    }//End of toString method
    
    //Adds a new credit card
    public void addCreditCard()
    {
    	cardID = generateNum();
    	verifier = generateVerifier();
    }//End of add new credit card
    
    //Generates a credit card number
    private int generateNum()
    {
    	//Declare temporary variables
    	int [] alreadyInUse = new int[getFileSize()];
    	int num = 0;
    	
    	BufferedReader read = new BufferedReader(new FileReader("cardIDs.txt"));
    	
    	//Read in already in use numbers
    	for(int x = 0; x < alreadyInUse.length; x++)
    	{
    		alreadyInUse[x] = Integer.parseInt(read.readLine());
    	}//End of loop 	
    		
    	num = (int)(Math.random() * 1000000000);
    	return checkNum(num, alreadyInUse);    	
    }//End of generateNum method
    
    //Generates a 3 digit verifier code
    private int generateVerifier()
    {
    	int num = 0;
    	
    	num = (int)(Math.random() * 1000);
    	
    	return num;
    }//End of generate verifier method
    
    //Recursive method to check if the num created is already in use
    private int checkNum(int num, int [] alreadyInUse)
    {
    	//Loop to check already used numbers
    	for(int x = 0; x < alreadyInUse.length; x++)
    	{
    		//Test if already in use
    		if (num == alreadyInUse[x])
    		{
    			num = (int)(Math.random() * 1000000000);
    			checkNum(num, alreadyInUse);
    		}//End of check
    	}//End of loop
    	
    	return num;
    }//End of checkNum method
    
    //Returns the size of the file 
    private int getFileSize() throws IOException
    {
    	BufferedReader read = new BufferedReader(new FileReader("cardIDs.txt"));

    	int counter = 0;

		while(read.readLine() != null)
			counter++;
		
		read.close();

		return counter;
    }//End of count file size method
}//End of class