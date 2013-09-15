//Your Name Here

//Required imports
import java.util.*;
import java.io.*;

public class Person
{
	//Declare instance variables
	private String first;
	private String last;
	private Gender gender;
	private Date birthDate;
	private String address;
	private String phoneNumber;
	private String sin;
	private String province;
	private String city;
	private String postal;

	//Declare class variable (true about all Person objects)
	Calendar current = Calendar.getInstance();
	int day = current.get(Calendar.DAY_OF_MONTH);
	int month = current.get(Calendar.MONTH);
	int year = current.get(Calendar.YEAR);
	public Date currentDate = new Date(day, month, year);

	//Default constructor
	public Person()
	{
		this.first = "";
    	this.last = "";
    	this.phoneNumber = "";
    	this.address = "";
    	this.province = "";
    	this.city = "";
    	this.postal = "";
    	this.sin = "";
	}//End of default constructor

	//Constructs person object from file
	public Person(String email) throws IOException
	{
		initializeFromFile(email);
	}//End of from file constructor
	
	//Constructs a person object for new user
    public Person(String first, String last, Gender gender, Date birthDate, String address, String phoneNumber, String province, String city, String postal, String sin)
    {
    	this.first = first;
    	this.last = last;
    	this.gender = gender;
    	this.birthDate = birthDate;
    	this.phoneNumber = phoneNumber;
    	this.address = address;
    	this.province = province;
    	this.city = city;
    	this.postal = postal;
    	this.sin = sin;
    }//End of constructor


	/********************
	 * ACCESSOR METHODS *
	 ********************/

	//Gets the value of first.
	public String getFirst()
	{
		return this.first;
	}//End of getFirst method

	//Gets the value of last.
	public String getLast()
	{
		return this.last;
	}//End of getLast method

	//Gets the value of gender.
	public Gender getGender()
	{
		return this.gender;
	}//End of getGender method

	//Gets the value of birthDate.
	public Date getBirthDate()
	{
		return this.birthDate;
	}//End of getBirthDate method

	//Gets the value of address.
	public String getAddress()
	{
		return this.address;
	}//End of getAddress method

	//Gets the value of phoneNumber.
	public String getPhoneNumber()
	{
		return this.phoneNumber;
	}//End of getPhoneNumber method

	//Gets the value of province.
	public String getProvince()
	{
		return this.province;
	}//End of getProvince method

	//Gets the value of city.
	public String getCity()
	{
		return this.city;
	}//End of getCity method

	public String getSin()
	{
		return this.sin;
	}

	//Gets the value of postal.
	public String getPostal()
	{
		return this.postal;
	}//End of getPostal method

	/***************************
	 * END OF ACCESSOR METHODS *
	 ***************************/


	/*******************
	 * MUTATOR METHODS *
	 *******************/

	//Sets the value of first.
	public void setFirst(String first)
	{
		this.first = first;
	}//End of setFirst method

	//Sets the value of last.
	public void setLast(String last)
	{
		this.last = last;
	}//End of setLast method

	//Sets the value of gender.
	public void setGender(Gender gender)
	{
		this.gender = gender;
	}//End of setGender method

	//Sets the value of birthDate.
	public void setBirthDate(Date birthDate)
	{
		this.birthDate = birthDate;
	}//End of setBirthDate method

	//Sets the value of address.
	public void setAddress(String address)
	{
		this.address = address;
	}//End of setAddress method

	//Sets the value of phoneNumber.
	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}//End of setPhoneNumber method

	//Sets the value of province.
	public void setProvince(String province)
	{
		this.province = province;
	}//End of setProvince method

	//Sets the value of city.
	public void setCity(String city)
	{
		this.city = city;
	}//End of setCity method

	//Sets the value of postal.
	public void setPostal(String postal)
	{
		this.postal = postal;
	}//End of setPostal method

	/**************************
	 * END OF MUTATOR METHODS *
	 **************************/


    //Calcuate a person's age in years
    public int ageInYears()
    {
    	int age = 0;
    	age = (int)currentDate.calculateYears() - (int) birthDate.calculateYears();
    	return age;
    }//End of ageInYears method

	//Saves the user info to a file
    public void saveUserInfo(String path) throws IOException
    {
    	//Declare and initialize file object
    	File file = new File(path + "\\Personal.txt");
		
		//Test if the file exists
    	if(file.exists())
    	{
    	}
    	else
    		file.createNewFile();
		
		//Declare and initialize a writer object
    	PrintWriter write = new PrintWriter(new FileWriter(file, false));

		//Write information to file
    	write.println(first);
    	write.println(last);
    	write.println(gender);
    	write.println(birthDate);
    	write.println(address);
    	write.println(phoneNumber);
		write.println(province);
		write.println(city);
		write.println(postal);
		write.println(sin);

		write.close();
    }//End of saveUserInfo method
	
	//Method will initialize the object froma  file's values
    private void initializeFromFile(String email) throws IOException
    {
    	//Declare and initialize temporary variables
    	String path = "Profiles\\" + email + "\\" + email + "\\Personal.txt";
    	BufferedReader read = new BufferedReader(new FileReader(path));
		
		//Read in the values
    	first = read.readLine();
    	last = read.readLine();
    	gender = Gender.valueOf(read.readLine());
    	String [] birthday = read.readLine().split("/");
    	birthDate = new Date(Integer.parseInt(birthday[0]), Integer.parseInt(birthday[1]), Integer.parseInt(birthday[2]));
    	address = read.readLine();
    	phoneNumber = read.readLine();
    	province = read.readLine();
    	city = read.readLine();
    	postal = read.readLine();
    	sin = read.readLine();

    	read.close();
    }//End of initialize from file method

    //A String to store a Person object's data for display
    public String toString()
    {
    	String output = "";

    	output += "\nFirst Name:   " + first;
    	output += "\nLast Name:    " + last;
    	output += "\nGender:       " + gender;
    	output += "\nBirth         " + birthDate;
    	output += "\nAddress:      " + address;
    	output += "\nProvince:     " + province;
    	output += "\nCity          " + city;
    	output += "\nPhone         " + phoneNumber;
    	output += "\nPostal        " + postal;
    	output += "\nSin           " + sin;

    	output += "\nAge:          " + this.ageInYears();

    	return output;
    }//End of toString method
}//End of class