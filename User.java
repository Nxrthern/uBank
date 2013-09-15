//Required imports
import java.io.*;

public class User
{
	//Declare instance variables
	private CreditCard card;
	private BankInfo bank;
	private Person person;
	private Security secure;

	//Default constructor
	public User()
	{
		card = new CreditCard();
		bank = new BankInfo();
		person = new Person();
		secure = new Security();
	}//End of default constructor

	//Constructs a user from file
    public User(String email) throws IOException
    {
    	loadExistingUser(email);
    }//End of from file constructor
	
	//Method save a new user
    public void saveUser(String first, String last, Gender gender, Date birthDate, String address, String phoneNumber, String province, String city, String postal, String email, String password, String sin) throws IOException
    {
    	//Declare and initialize variables
		String path = "Profiles\\" + email;
		File file = new File(path + "\\" + email);
		
		//Create folder
		file.mkdirs();
		
		//Save person
		person = new Person(first,  last, gender, birthDate, address, phoneNumber, province, city, postal, sin);
		person.saveUserInfo(path + "\\" + email);

		//Save security
		secure = new Security(email, password);
		secure.saveSecurity(path);

		//Save bank info
		bank = new BankInfo();
		bank.saveBankInfo(path + "\\" + email);

		//Save credit card
		card = new CreditCard();
		card.saveCreditCard(path + "\\" + email);
    }//End of new user method

	//Loads existing user
    private void loadExistingUser(String email) throws IOException
    {
    	//Initialize the class variables
    	person = new Person(email);
    	secure = new Security(email);
        bank = new BankInfo(email);
        card = new CreditCard(email);
    }//End of load existing user
	
	//GETTERS 
    public BankInfo getBankInfo()
    {
    	return bank;
    }

    public CreditCard getCreditCard()
    {
    	return card;
    }

    public Person getPerson()
    {
    	return person;
    }

    public Security getSecurity()
    {
    	return secure;
    }//END OF GETTERS

	//Displays the object as a string
    public String toString()
    {
    	String output = person + "\n" + bank + "\n" + secure + "\n" + card;
    	return output;
    }//End of toString method
}//End of class