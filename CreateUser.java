/**
 * @(#)CreateUser.java
 *
 *
 * @author
 * @version 1.00 2012/6/3
 */

	//Required imports
	import javax.swing.*;
	import javax.swing.event.*;
	import java.awt.*;
	import java.awt.event.*;
	import java.io.*;
	import java.text.*;

public class CreateUser extends JFrame implements ActionListener
{
	//these things are what they is
	String [] dayParam = {"1", "2", "3","4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
	String [] monthParam = {"Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sept", "Oct", "Nov", "Dec"};
	String [] yearParam = new String[100];
	String [] provinceParam = {"Alberta", "British Columbia", "Manitoba", "New Brunswick", "Newfoundland", "Northwest Territories", "Nova Scotia", "Nunavut", "Ontario", "Prince Edward Island", "Saskatchewan", "Quebec", "Yukon"};
	int errorNum = -1;

	//Creates buttons for frame
    static JButton cmdCreate = new JButton("Create User");
   	JButton cmdBack = new JButton("Back");

	//Creates components to add image to a label
	ImageIcon imgLogo = new ImageIcon("uBankBannerShort.png");
	JLabel lblImage = new JLabel(" ", imgLogo, JLabel.CENTER);

	//Creates buttons for create user section
   	JTextField txtLastName = new JTextField(20);
   	JTextField txtName = new JTextField(20);
   	JTextField txtPhone = new JTextField(20);
   	JTextField txtEmail = new JTextField(40);
   	JTextField txtPostal = new JTextField(10);
   	JTextField txtSin = new JTextField(10);
   	JTextField txtAddress = new JTextField(40);
   	JComboBox cboProvince = new JComboBox(provinceParam);
   	JTextField txtCity = new JTextField(20);
   	JPasswordField txtPassword = new JPasswordField(16);
   	JCheckBox chkMale = new JCheckBox("Male");
   	JCheckBox chkFemale = new JCheckBox("Female");
   	JLabel lblGender = new JLabel("Gender:");
   	JLabel lblPostal = new JLabel("Postal Code: ");
   	JLabel lblSin = new JLabel("SIN (no spaces): ");
   	JLabel lblBirth = new JLabel("Birth Day:");
   	JComboBox cboDay = new JComboBox(dayParam);
   	JComboBox cboMonth = new JComboBox(monthParam);
   	JComboBox cboYear;
   	JLabel lblLastName = new JLabel("Last Name: ");
   	JLabel lblName = new JLabel("First Name: ");
   	JLabel lblPhone = new JLabel("Phone Number:");
   	JLabel lblEmail = new JLabel("Email Address:");
   	JLabel lblComms = new JLabel("");
   	JLabel lblCity = new JLabel("City: ");
   	JLabel lblProvince = new JLabel("Province: ");
   	JLabel lblAddress = new JLabel("Street Address:");
   	JLabel lblPassword = new JLabel("Password:");

	//Creates an instance for the layout manager
    SpringLayout layout = new SpringLayout();

	//Constructs the frame
    public CreateUser()
    {
    	//Initializes year combo box
    	initializeCBO();

       	//Adds buttons, text field, and check box to the frame
       	this.add(cboDay);
       	this.add(cboMonth);
       	this.add(cboYear);
       	this.add(cboProvince);
       	this.add(lblProvince);
       	this.add(txtCity);
       	this.add(lblGender);
       	this.add(chkMale);
       	this.add(chkFemale);
       	this.add(lblCity);
       	this.add(txtAddress);
       	this.add(lblAddress);
       	this.add(txtSin);
       	this.add(lblSin);
       	this.add(txtPostal);
       	this.add(lblPostal);
       	this.add(lblEmail);
       	this.add(txtEmail);
       	this.add(txtPassword);
       	this.add(lblPassword);
       	this.add(lblBirth);
    	this.add(cmdCreate);
    	this.add(cmdBack);
    	this.add(txtPhone);
    	this.add(lblPhone);
    	this.add(txtLastName);
    	this.add(lblLastName);
    	this.add(txtName);
    	this.add(lblName);
    	this.add(lblImage);
    	this.add(lblComms);

		//Set background colours to green
		Color uBankColor = new Color(100, 100, 255);
    	this.getContentPane().setBackground(uBankColor);
    	chkMale.setBackground(uBankColor);
    	chkFemale.setBackground(uBankColor);

    	//Set word to reference the action performed
    	cmdCreate.setActionCommand("create");
    	cmdBack.setActionCommand("back");

		//Add the action listener to different objects
    	cmdCreate.addActionListener(this);
    	cmdBack.addActionListener(this);

		//Set the layout for the frame
		this.getContentPane().setLayout(layout);

    	//Set the positions of the buttons on the frame using coordinates
    	layout.putConstraint(SpringLayout.WEST, cmdCreate, 170, SpringLayout.WEST, getContentPane());
    	layout.putConstraint(SpringLayout.NORTH, cmdCreate, 600, SpringLayout.NORTH, getContentPane());

    	layout.putConstraint(SpringLayout.WEST, lblBirth, 30, SpringLayout.WEST, getContentPane());
		layout.putConstraint(SpringLayout.NORTH, lblBirth, 200, SpringLayout.NORTH, getContentPane());
    	layout.putConstraint(SpringLayout.WEST, cboDay, 30, SpringLayout.WEST, getContentPane());
    	layout.putConstraint(SpringLayout.NORTH, cboDay, 225, SpringLayout.NORTH, getContentPane());
    	layout.putConstraint(SpringLayout.WEST, cboMonth, 100, SpringLayout.WEST, getContentPane());
    	layout.putConstraint(SpringLayout.NORTH, cboMonth, 225, SpringLayout.NORTH, getContentPane());
    	layout.putConstraint(SpringLayout.WEST, cboYear, 180, SpringLayout.WEST, getContentPane());
    	layout.putConstraint(SpringLayout.NORTH, cboYear, 225, SpringLayout.NORTH, getContentPane());

    	layout.putConstraint(SpringLayout.WEST, cmdBack, 300, SpringLayout.WEST, getContentPane());
    	layout.putConstraint(SpringLayout.NORTH, cmdBack, 600, SpringLayout.NORTH, getContentPane());

		layout.putConstraint(SpringLayout.WEST, txtName, 30, SpringLayout.WEST, getContentPane());
		layout.putConstraint(SpringLayout.NORTH, txtName, 120, SpringLayout.NORTH, getContentPane());
		layout.putConstraint(SpringLayout.WEST, lblName, 30, SpringLayout.WEST, getContentPane());
		layout.putConstraint(SpringLayout.NORTH, lblName, 100, SpringLayout.NORTH, getContentPane());

		layout.putConstraint(SpringLayout.WEST, chkMale, 325, SpringLayout.WEST, getContentPane());
		layout.putConstraint(SpringLayout.NORTH, chkMale, 120, SpringLayout.NORTH, getContentPane());
		layout.putConstraint(SpringLayout.WEST, lblGender, 325, SpringLayout.WEST, getContentPane());
		layout.putConstraint(SpringLayout.NORTH, lblGender, 95, SpringLayout.NORTH, getContentPane());
		layout.putConstraint(SpringLayout.WEST, chkFemale, 385, SpringLayout.WEST, getContentPane());
		layout.putConstraint(SpringLayout.NORTH, chkFemale, 120, SpringLayout.NORTH, getContentPane());

		layout.putConstraint(SpringLayout.WEST, txtPostal, 325, SpringLayout.WEST, getContentPane());
		layout.putConstraint(SpringLayout.NORTH, txtPostal, 190, SpringLayout.NORTH, getContentPane());
		layout.putConstraint(SpringLayout.WEST, lblPostal, 325, SpringLayout.WEST, getContentPane());
		layout.putConstraint(SpringLayout.NORTH, lblPostal, 165, SpringLayout.NORTH, getContentPane());

		layout.putConstraint(SpringLayout.WEST, txtSin, 325, SpringLayout.WEST, getContentPane());
		layout.putConstraint(SpringLayout.NORTH, txtSin, 255, SpringLayout.NORTH, getContentPane());
		layout.putConstraint(SpringLayout.WEST, lblSin, 325, SpringLayout.WEST, getContentPane());
		layout.putConstraint(SpringLayout.NORTH, lblSin, 230, SpringLayout.NORTH, getContentPane());

		layout.putConstraint(SpringLayout.WEST, txtLastName, 30, SpringLayout.WEST, getContentPane());
		layout.putConstraint(SpringLayout.NORTH, txtLastName, 170, SpringLayout.NORTH, getContentPane());
		layout.putConstraint(SpringLayout.WEST, lblLastName, 30, SpringLayout.WEST, getContentPane());
		layout.putConstraint(SpringLayout.NORTH, lblLastName, 145, SpringLayout.NORTH, getContentPane());

		layout.putConstraint(SpringLayout.WEST, lblPhone, 30, SpringLayout.WEST, getContentPane());
		layout.putConstraint(SpringLayout.NORTH, lblPhone, 260, SpringLayout.NORTH, getContentPane());
    	layout.putConstraint(SpringLayout.WEST, txtPhone, 30, SpringLayout.WEST, getContentPane());
    	layout.putConstraint(SpringLayout.NORTH, txtPhone, 285, SpringLayout.NORTH, getContentPane());

    	layout.putConstraint(SpringLayout.WEST, lblEmail, 30, SpringLayout.WEST, getContentPane());
		layout.putConstraint(SpringLayout.NORTH, lblEmail, 315, SpringLayout.NORTH, getContentPane());
    	layout.putConstraint(SpringLayout.WEST, txtEmail, 30, SpringLayout.WEST, getContentPane());
    	layout.putConstraint(SpringLayout.NORTH, txtEmail, 340, SpringLayout.NORTH, getContentPane());

    	layout.putConstraint(SpringLayout.WEST, lblPassword, 30, SpringLayout.WEST, getContentPane());
		layout.putConstraint(SpringLayout.NORTH, lblPassword, 365, SpringLayout.NORTH, getContentPane());
    	layout.putConstraint(SpringLayout.WEST, txtPassword, 30, SpringLayout.WEST, getContentPane());
    	layout.putConstraint(SpringLayout.NORTH, txtPassword, 390, SpringLayout.NORTH, getContentPane());

    	layout.putConstraint(SpringLayout.WEST, lblAddress, 30, SpringLayout.WEST, getContentPane());
		layout.putConstraint(SpringLayout.NORTH, lblAddress, 415, SpringLayout.NORTH, getContentPane());
    	layout.putConstraint(SpringLayout.WEST, txtAddress, 30, SpringLayout.WEST, getContentPane());
    	layout.putConstraint(SpringLayout.NORTH, txtAddress, 440, SpringLayout.NORTH, getContentPane());

    	layout.putConstraint(SpringLayout.WEST, cboProvince, 30, SpringLayout.WEST, getContentPane());
		layout.putConstraint(SpringLayout.NORTH, cboProvince, 495, SpringLayout.NORTH, getContentPane());
    	layout.putConstraint(SpringLayout.WEST, lblProvince, 30, SpringLayout.WEST, getContentPane());
    	layout.putConstraint(SpringLayout.NORTH, lblProvince, 470, SpringLayout.NORTH, getContentPane());

    	layout.putConstraint(SpringLayout.WEST, lblCity, 30, SpringLayout.WEST, getContentPane());
		layout.putConstraint(SpringLayout.NORTH, lblCity, 525, SpringLayout.NORTH, getContentPane());
    	layout.putConstraint(SpringLayout.WEST, txtCity, 30, SpringLayout.WEST, getContentPane());
    	layout.putConstraint(SpringLayout.NORTH, txtCity, 550, SpringLayout.NORTH, getContentPane());

		layout.putConstraint(SpringLayout.WEST, lblComms, 0, SpringLayout.WEST, getContentPane());
		layout.putConstraint(SpringLayout.NORTH, lblComms, 695, SpringLayout.NORTH, getContentPane());

    	//Set the layout for the frame
    	this.setSize(600,700);
    	this.setTitle("Create User");
    	this.setLocationRelativeTo(null);				//Centres screen
    	this.setDefaultCloseOperation(EXIT_ON_CLOSE);	//Sets the x button to close program
    	this.setVisible(true);
    	lblComms.setForeground(Color.RED);

    	//Set focus on the text field
    	txtName.grabFocus();
    }//End of constructor method

	//Initialize the year combo box
    private void initializeCBO()
    {
		for(int x = 1913; x < 2013; x++)
			yearParam[x-1913] = ("" + x);

		cboYear = new JComboBox(yearParam);
    }//End of initializeCBO method

	//This method determines which component has fired and how to proceed
    public void actionPerformed(ActionEvent e)
    {
    	//Check which component has fired
		if(e.getActionCommand().equals("back"))
    	{
    		//Switch frames
    		this.dispose();

    		LoginScreen frame = new LoginScreen();
    	}
    	else if(e.getActionCommand().equals("create"))
    	{
      		//Check the validity of the input
			if(validityCheck())
			{
				//Temporary variables
				User newUser = new User();
				Gender g;
				String [] temps = {"" + cboDay.getSelectedItem(), "" + getMonth(), "" + cboYear.getSelectedItem()};
				String provinceTemp = "" + cboProvince.getSelectedItem();
				
				//Test for male and female and set gender
				if(chkMale.isSelected() == true && chkFemale.isSelected() == true)
					g = Gender.valueOf("BOTH");
				else if(chkMale.isSelected() == true)
					g = Gender.valueOf("MALE");
				else if(chkFemale.isSelected() == true)
					g = Gender.valueOf("FEMALE");
				else
					g = Gender.valueOf("NEITHER");
				
				//Make birthdate
				Date d = new Date(Integer.parseInt(temps[0]), Integer.parseInt(temps[1]), Integer.parseInt(temps[2]));

				//Use try catch for io
				try
				{
					//Declare and initialize file
					File file = new File("Profiles\\" + txtEmail.getText());
					
					//Check if file already exists
					if(!file.exists())
					{
						//Create new folder
						file.mkdirs();
						
						//Save new user
						newUser.saveUser(txtName.getText(), txtLastName.getText(), g, d, txtAddress.getText(), txtPhone.getText(), provinceTemp, txtCity.getText(), txtPostal.getText(), txtEmail.getText(), txtPassword.getText(), txtSin.getText());
						
						//Go to main screen
						this.setVisible(false);
						MainScreen frame = new MainScreen(newUser);
					}
					else
					{
						//If an error occurs display it
						errorNum = 0;
						errorOutput(errorNum);
					}//End of existing file check
				}
				catch(Exception a)
				{
					System.out.println(a);
				}//End of try catch
			}
			else
			{
				errorOutput(errorNum);
			}//End of validity check
    	}//End of component fired check
    }//End of actionPerformed method

	//Checks validity of input
    private boolean validityCheck()
    {
    	//Tests for unusable input
    	if(unusableInput())
    	{
    		errorNum = 4;
    		return false;
    	}//End of unusable input
		
		//Tests for empty fields
    	if(emptyFields())
    	{
    		errorNum = 1;
    		return false;
    	}//End of empty fields test

    	return true;
    }//End of validity check method

	//If an error is caught then it is read and displayed from file
    private void errorOutput(int errorNum)
    {
    	//Use try catch for io
		try
		{
			//Temporary variables
			BufferedReader read = new BufferedReader(new FileReader("errors.txt"));
			String [] errors = new String[getFileSize()];
			
			//Loop to read file
			for(int x = 0; x < errors.length; x++)
			{
				errors[x] = read.readLine();
			}//End of loop

			//Loop to find error
			for(int x = 0; x < errors.length - 1; x+=2)
			{
				if(errorNum == Integer.parseInt(errors[x]))
					lblComms.setText(errors[x+1]);
			}//End of loop
		}
		catch(Exception e)
		{
			System.out.println("Unaccounted error, software crash. " + errorNum);
		}//End of try catch
    }//End of errorOutput method
	
	//Method checks for empty fields
    private boolean emptyFields()
    {
    	//Test for empties
    	if(txtName.getText().length() == 0)
    		return true;
    	else if(txtLastName.getText().length() == 0)
    		return true;
    	else if(txtPhone.getText().length() == 0)
    		return true;
    	else if(txtEmail.getText().length() == 0)
    		return true;
    	else if(txtPostal.getText().length() == 0)
    		return true;
    	else if(txtAddress.getText().length() == 0)
    		return true;
    	else if(txtPassword.getText().length() == 0)
    		return true;
    	else if(txtCity.getText().length() == 0)
    		return true;
    	else if(txtSin.getText().length() == 0)
    		return true;
    	else
    		return false;
    }//End of emptyFields method

	//Returns the month selected plus 1
    private int getMonth()
    {
    	return cboMonth.getSelectedIndex() + 1;
    }//End of getMonth

	//Returns the file size
    private int getFileSize() throws IOException
    {
    	BufferedReader read = new BufferedReader(new FileReader("errors.txt"));

    	int counter = 0;

		while(read.readLine() != null)
			counter++;
		
		read.close();

		return counter;
    }//End of get file size method

	//Make calls to check usuable input
    private boolean unusableInput()
    {
    	//Test certain fields
		if(!useName())
			return true;

		if(!useLastName())
			return true;

		if(!usePhone())
			return true;

		if(!usePostal())
			return true;

		if(!useSIN())
			return true;

		return false;
    }//End of usuable input method

	//Check usability of name
    private boolean useName()
    {
    	//Loop to test characters
    	for(int x = 0; x < txtName.getText().length(); x++)
    	{
    		char temp = txtName.getText().charAt(x);
			
			//Test if character is a hyphen, apostrophe, or letter
    		if(!(temp == 45 || temp == 39 || (temp > 64 && temp < 91) || (temp > 96 && temp < 123)))
    			return false;
    	}//End of loop

    	return true;
    }//End of use name method

	//Checks the usability of last name
    private boolean useLastName()
    {
    	//Loop to test characters
    	for(int x = 0; x < txtLastName.getText().length(); x++)
    	{
    		char temp = txtLastName.getText().charAt(x);

			//Check if character is a hyphen, apostrophe, or letter
    		if(!(temp == 45 || temp == 39 || (temp > 64 && temp < 91) || (temp > 96 && temp < 123)))
    			return false;
    	}//End of loop

    	return true;
    }//End of use last name method
	
	//Checks the usability of phone
    private boolean usePhone()
    {
    	//Loop to test characters
    	for(int x = 0; x < txtPhone.getText().length(); x++)
    	{
    		char temp = txtPhone.getText().charAt(x);
			
			//Test if character is a spce, hyphen, or number
    		if(!(temp == 45 || temp == ' ' || (temp > 47 && temp < 58)))
    			return false;
    	}//End of loop

    	return true;
    }//End of use phone method

	//Checks the usability of postal
    private boolean usePostal()
    {
    	//Declare and initialize temporary variables
		int alpha = 0;
		int numero = 0;

		//Loop to test characters
		for(int x = 0; x < txtPostal.getText().length(); x++)
		{
			char temp = txtPostal.getText().charAt(x);

			//Test for space
			if(temp != ' ')
			{
				if(temp > 47 && temp < 58)
					numero++;
				else if((temp > 64 && temp < 91) || (temp > 96 && temp < 123))
					alpha++;
			}//End of space test
		}//End of loop
		
		//Tests if there are 3 letters and 3 numbers
		if(alpha == 3 && numero == 3)
			return true;
		else
			return false;
    }//End of use postal method

	//Check the usability of sin number
    private boolean useSIN()
    {
    	//Declare and initialize variables
    	int sin = 0;
    	int even = 0;
    	int digit9 = 0;
    	int odd = 0;
    	int digit = 0;

		//Get input from the user
		sin = Integer.parseInt(txtSin.getText());
			
		//Isolate the 9th digit and move the new number into result
		digit9 = sin % 10;
    
    	//Loop to find the sum of each individual even or odd digit
    	for (int x = 8; x >= 1; x--)
    	{
    		//Get new values
    		sin = sin / 10;
    		digit = sin % 10;
    	    
    	    //Test even or odd			
    		if (x % 2 == 0)
    			even += (digit * 2 % 10) + (digit * 2 / 10);  //Find the running sum of even digits and store the new result number
    		else
    			odd += digit;  //Get the running sum of odd digits and get new result value
    	}//End of loop structure
    
    	//Get the result of the even total added to the odd total
    	sin = odd + even;
    		
    	//Isolate the ones digit for the test
    	sin = sin % 10;
    	System.out.println(sin + " " + digit9);
    	
    	//Test to see if the operations returned a valid sin test
    	if (digit9 == 10 - sin)
    		return true;
    	else
    		return false;
    }//End of usable sin method
}//End of class