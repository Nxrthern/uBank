/*
 *	This class displays the setting screen and holds its functionality
 *	of being able to save and update user information. Fully commented.	
 *
 */

//Required imports
	import javax.swing.*;
	import javax.swing.event.*;
	import java.awt.*;
	import java.awt.event.*;
	import java.io.*;
	import java.util.*;

public class SettingsScreen extends JFrame implements ActionListener
{
	//Class variables
	private int [] updateTrackerPerson = new int[9];
	private int [] updateTrackerSecure = new int[2];
	private int errorNum = -1;
	private String [] dayParam = {"1", "2", "3","4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
	private String [] monthParam = {"Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sept", "Oct", "Nov", "Dec"};
	private String [] yearParam = new String[100];
	private String [] provinceParam = {"Alberta", "British Columbia", "Manitoba", "New Brunswick", "Newfoundland", "Northwest Territories", "Nova Scotia", "Nunavut", "Ontario", "Prince Edward Island", "Saskatchewan", "Quebec", "Yukon"};

	//Creates components to add image to a label
	ImageIcon imgLogo = new ImageIcon("uBank Banner.png");
	JLabel lblImage = new JLabel("", imgLogo, JLabel.CENTER);

	//Screen stuff
	JButton cmdMainMenu = new JButton("Main Menu");
	JButton cmdSave = new JButton("Save Changes");
	JButton cmdEditBank = new JButton("Edit Bank Info");
	JButton cmdEditPerson = new JButton("Edit Peronsal Info");
	JButton cmdEditSecurity = new JButton("Edit Security");
	JButton [] cmdEditPersons = new JButton[9];
	JTextField [] txtEditPersons = new JTextField[9];
	JPasswordField txtEditPassword = new JPasswordField(16);
	JButton cmdEditPassword = new JButton("Edit");
	JButton cmdEditPin = new JButton("Edit");
	JTextField txtEditPin = new JTextField(16);
	JButton cmdBankPin = new JButton("Edit B");
	JButton cmdReset = new JButton("Reset Fields");
	JComboBox cboDay = new JComboBox(dayParam);
   	JComboBox cboMonth = new JComboBox(monthParam);
   	JComboBox cboYear;
   	JComboBox cboProvince = new JComboBox(provinceParam);
   	JCheckBox chkMale = new JCheckBox("Male");
   	JCheckBox chkFemale = new JCheckBox("Female");
	JLabel lblComms = new JLabel("");
	JLabel lblPin = new JLabel("");
	JLabel lblEmail;
	JLabel lblPassword;
	JLabel lblName;
	JLabel lblLastName;
	JLabel lblGender;
	JLabel lblBirth;
	JLabel lblAddress;
	JLabel lblPhone;
	JLabel lblProvince;
	JLabel lblCity;
	JLabel lblPostal;

	User updatingUser;

	//Creates an instance for the layout manager
    SpringLayout layout = new SpringLayout();

	//Screen constructor
	public SettingsScreen(User user)
	{
		//Initialize otherwise unknown variables
		initializeCBO();
		updatingUser = user;
		lblName = new JLabel("First Name: " + user.getPerson().getFirst());
		lblLastName  = new JLabel("Last Name: " + user.getPerson().getLast());
		lblGender = new JLabel("Gender: " + user.getPerson().getGender());
		lblBirth = new JLabel("Birthday: " + user.getPerson().getBirthDate());
		lblAddress = new JLabel("Addess: " + user.getPerson().getAddress());
		lblPhone = new JLabel("Phone Number: " + user.getPerson().getPhoneNumber());
		lblProvince = new JLabel("Province: " + user.getPerson().getProvince());
		lblCity = new JLabel("City: " + user.getPerson().getCity());
		lblPostal = new JLabel("Postal: " + user.getPerson().getPostal());
		lblEmail = new JLabel("Email: " + user.getSecurity().getEmail());
		lblPassword = new JLabel("Password: " + user.getSecurity().getPassword());

       	//Adds buttons, text field, and check box to the frame
		this.add(cmdMainMenu);
		this.add(cmdSave);
		this.add(cmdEditBank);
		this.add(cmdEditPerson);
		this.add(cmdEditSecurity);
		this.add(cmdEditPassword);
		this.add(cmdReset);
		this.add(cboDay);
		this.add(cboMonth);
		this.add(cboYear);
		this.add(cboProvince);
		this.add(chkMale);
		this.add(chkFemale);
		this.add(lblEmail);
		this.add(lblPassword);
		this.add(lblName);
		this.add(lblLastName);
		this.add(lblGender);
		this.add(lblBirth);
		this.add(lblAddress);
		this.add(lblPhone);
		this.add(lblProvince);
		this.add(lblCity);
		this.add(lblPostal);
		this.add(lblComms);
		this.add(lblImage);
		this.add(txtEditPassword);
	
		//Add the array list buttons and fields
		addPersonalsButtons();
		addPersonalFields();

		//Set background colours to uBank blue
		Color uBankColor = new Color(100, 100, 255);
    	this.getContentPane().setBackground(uBankColor);
    	cmdEditBank.setBackground(uBankColor);
    	cmdEditBank.setOpaque(false);
		cmdEditBank.setContentAreaFilled(false);
		cmdEditBank.setFocusPainted(false);
		cmdEditPerson.setBackground(uBankColor);
    	cmdEditPerson.setOpaque(false);
		cmdEditPerson.setContentAreaFilled(false);
		cmdEditPerson.setFocusPainted(false);
		cmdEditSecurity.setBackground(uBankColor);
    	cmdEditSecurity.setOpaque(false);
		cmdEditSecurity.setContentAreaFilled(false);
		cmdEditSecurity.setFocusPainted(false);
		cmdEditPassword.setBackground(uBankColor);
    	cmdEditPassword.setOpaque(false);
		cmdEditPassword.setContentAreaFilled(false);
		cmdEditPassword.setFocusPainted(false);
		chkMale.setBackground(uBankColor);
    	chkFemale.setBackground(uBankColor);

    	//Set word to reference the action performed
    	cmdMainMenu.setActionCommand("menu");
    	cmdSave.setActionCommand("save");
    	cmdReset.setActionCommand("reset");
    	cmdEditPerson.setActionCommand("person");
    	cmdEditBank.setActionCommand("bank");
		cmdEditSecurity.setActionCommand("security");
		cmdEditPassword.setActionCommand("password");

		//Add the action listener to different objects
    	cmdMainMenu.addActionListener(this);
    	cmdSave.addActionListener(this);
    	cmdReset.addActionListener(this);
    	cmdEditPerson.addActionListener(this);
    	cmdEditBank.addActionListener(this);
    	cmdEditSecurity.addActionListener(this);
    	cmdEditPassword.addActionListener(this);

		//Set the layout for the frame
		this.getContentPane().setLayout(layout);

    	//Set the positions of the buttons on the frame using coordinates
    	layout.putConstraint(SpringLayout.WEST, cmdMainMenu, 20, SpringLayout.WEST, getContentPane());
    	layout.putConstraint(SpringLayout.NORTH, cmdMainMenu, 150, SpringLayout.NORTH, getContentPane());

    	layout.putConstraint(SpringLayout.WEST, lblComms, 300, SpringLayout.WEST, getContentPane());
		layout.putConstraint(SpringLayout.NORTH, lblComms, 300, SpringLayout.NORTH, getContentPane());

		layout.putConstraint(SpringLayout.WEST, cmdEditPerson, 150, SpringLayout.WEST, getContentPane());
    	layout.putConstraint(SpringLayout.NORTH, cmdEditPerson, 100, SpringLayout.NORTH, getContentPane());

    	layout.putConstraint(SpringLayout.WEST, cmdEditPassword, 350, SpringLayout.WEST, getContentPane());
    	layout.putConstraint(SpringLayout.NORTH, cmdEditPassword, 170, SpringLayout.NORTH, getContentPane());

    	layout.putConstraint(SpringLayout.WEST, txtEditPassword, 420, SpringLayout.WEST, getContentPane());
    	layout.putConstraint(SpringLayout.NORTH, txtEditPassword, 170, SpringLayout.NORTH, getContentPane());

    	layout.putConstraint(SpringLayout.WEST, cboDay, 420, SpringLayout.WEST, getContentPane());
    	layout.putConstraint(SpringLayout.NORTH, cboDay, 220, SpringLayout.NORTH, getContentPane());

    	layout.putConstraint(SpringLayout.WEST, cboMonth, 480, SpringLayout.WEST, getContentPane());
    	layout.putConstraint(SpringLayout.NORTH, cboMonth, 220, SpringLayout.NORTH, getContentPane());

    	layout.putConstraint(SpringLayout.WEST, cboYear, 560, SpringLayout.WEST, getContentPane());
    	layout.putConstraint(SpringLayout.NORTH, cboYear, 220, SpringLayout.NORTH, getContentPane());

    	layout.putConstraint(SpringLayout.WEST, cboProvince, 420, SpringLayout.WEST, getContentPane());
    	layout.putConstraint(SpringLayout.NORTH, cboProvince, 295, SpringLayout.NORTH, getContentPane());

    	layout.putConstraint(SpringLayout.WEST, chkMale, 420, SpringLayout.WEST, getContentPane());
    	layout.putConstraint(SpringLayout.NORTH, chkMale, 195, SpringLayout.NORTH, getContentPane());

    	layout.putConstraint(SpringLayout.WEST, chkFemale, 480, SpringLayout.WEST, getContentPane());
    	layout.putConstraint(SpringLayout.NORTH, chkFemale, 195, SpringLayout.NORTH, getContentPane());

		layout.putConstraint(SpringLayout.WEST, lblEmail, 150, SpringLayout.WEST, getContentPane());
    	layout.putConstraint(SpringLayout.NORTH, lblEmail, 145, SpringLayout.NORTH, getContentPane());

    	layout.putConstraint(SpringLayout.WEST, lblPassword, 150, SpringLayout.WEST, getContentPane());
    	layout.putConstraint(SpringLayout.NORTH, lblPassword, 170, SpringLayout.NORTH, getContentPane());

    	layout.putConstraint(SpringLayout.WEST, lblName, 150, SpringLayout.WEST, getContentPane());
    	layout.putConstraint(SpringLayout.NORTH, lblName, 145, SpringLayout.NORTH, getContentPane());

    	layout.putConstraint(SpringLayout.WEST, lblLastName, 150, SpringLayout.WEST, getContentPane());
    	layout.putConstraint(SpringLayout.NORTH, lblLastName, 170, SpringLayout.NORTH, getContentPane());

    	layout.putConstraint(SpringLayout.WEST, lblGender, 150, SpringLayout.WEST, getContentPane());
    	layout.putConstraint(SpringLayout.NORTH, lblGender, 195, SpringLayout.NORTH, getContentPane());

    	layout.putConstraint(SpringLayout.WEST, lblBirth, 150, SpringLayout.WEST, getContentPane());
    	layout.putConstraint(SpringLayout.NORTH, lblBirth, 220, SpringLayout.NORTH, getContentPane());

    	layout.putConstraint(SpringLayout.WEST, lblAddress, 150, SpringLayout.WEST, getContentPane());
    	layout.putConstraint(SpringLayout.NORTH, lblAddress, 245, SpringLayout.NORTH, getContentPane());

    	layout.putConstraint(SpringLayout.WEST, lblPhone, 150, SpringLayout.WEST, getContentPane());
    	layout.putConstraint(SpringLayout.NORTH, lblPhone, 270, SpringLayout.NORTH, getContentPane());

    	layout.putConstraint(SpringLayout.WEST, lblProvince, 150, SpringLayout.WEST, getContentPane());
    	layout.putConstraint(SpringLayout.NORTH, lblProvince, 295, SpringLayout.NORTH, getContentPane());

    	layout.putConstraint(SpringLayout.WEST, lblCity, 150, SpringLayout.WEST, getContentPane());
    	layout.putConstraint(SpringLayout.NORTH, lblCity, 320, SpringLayout.NORTH, getContentPane());

    	layout.putConstraint(SpringLayout.WEST, lblPostal, 150, SpringLayout.WEST, getContentPane());
    	layout.putConstraint(SpringLayout.NORTH, lblPostal, 345, SpringLayout.NORTH, getContentPane());

    	layout.putConstraint(SpringLayout.WEST, lblComms, 100, SpringLayout.WEST, getContentPane());
    	layout.putConstraint(SpringLayout.NORTH, lblComms, 370, SpringLayout.NORTH, getContentPane());

    	layout.putConstraint(SpringLayout.WEST, cmdEditBank, 290, SpringLayout.WEST, getContentPane());
    	layout.putConstraint(SpringLayout.NORTH, cmdEditBank, 100, SpringLayout.NORTH, getContentPane());

    	layout.putConstraint(SpringLayout.WEST, cmdEditSecurity, 425, SpringLayout.WEST, getContentPane());
    	layout.putConstraint(SpringLayout.NORTH, cmdEditSecurity, 100, SpringLayout.NORTH, getContentPane());

    	layout.putConstraint(SpringLayout.WEST, cmdReset, 150, SpringLayout.WEST, getContentPane());
    	layout.putConstraint(SpringLayout.NORTH, cmdReset, 400, SpringLayout.NORTH, getContentPane());

    	layout.putConstraint(SpringLayout.WEST, cmdSave, 300, SpringLayout.WEST, getContentPane());
    	layout.putConstraint(SpringLayout.NORTH, cmdSave, 400, SpringLayout.NORTH, getContentPane());

    	//Set the layout for the frame
    	this.setSize(800, 500);
    	this.setTitle("Settings");
    	this.setLocationRelativeTo(null);				//Centres screen
    	this.setDefaultCloseOperation(EXIT_ON_CLOSE);	//Sets the x button to close program
    	this.setVisible(true);

    	//Hide components not in use at default
    	lblEmail.setVisible(false);
    	lblPassword.setVisible(false);
    	cmdEditPassword.setVisible(false);
    	txtEditPassword.setVisible(false);
    	cboDay.setVisible(false);
    	cboMonth.setVisible(false);
    	cboYear.setVisible(false);
    	cboProvince.setVisible(false);
    	chkMale.setVisible(false);
    	chkFemale.setVisible(false);
	}//End of screen constrcutor

	//This method determines which component has fired and how to proceed
    public void actionPerformed(ActionEvent e)
    {
    	//Test which action has fired
		if(e.getActionCommand().equals("menu"))
    	{
    		//Switch frames
    		this.setVisible(false);
    		LoginScreen.mainFrame.setVisible(true);
    	}
    	else if(e.getActionCommand().equals("save"))
    	{
    		//Attempt save catch for IO
    		try
    		{
				saveChanges();
    		}
    		catch(Exception a)
    		{
    			System.out.println(a);
    		}//End of try catch
    	}
    	else if(e.getActionCommand().equals("bank"))
    	{
    		hideComponents();
    	}
    	else if(e.getActionCommand().equals("person"))
    	{
			hideComponents();
			lblName.setVisible(true);
			lblLastName.setVisible(true);
			lblGender.setVisible(true);
			lblBirth.setVisible(true);
			lblAddress.setVisible(true);
			lblPhone.setVisible(true);
			lblProvince.setVisible(true);
			lblCity.setVisible(true);
			lblPostal.setVisible(true);
			showPersonals();
    	}
    	else if(e.getActionCommand().equals("security"))
    	{
			hideComponents();
			cmdEditPassword.setVisible(true);
			lblEmail.setVisible(true);
			lblPassword.setVisible(true);
    	}
    	else if(e.getActionCommand().equals("reset"))
    	{
    		//Resets the trackers
			for(int x = 0; x < txtEditPersons.length; x++)
			{
				if(x < 2)
					updateTrackerSecure[x] = 0;

				updateTrackerPerson[x] = 0;
				lblComms.setText("");
				txtEditPersons[x].setText("Enter new data");
			}//End of loop
			
			//Make fields invisible again
			for(int x = 0; x < txtEditPersons.length; x++)
    		{
    			txtEditPersons[x].setVisible(false);
    		}
    		
    		txtEditPassword.setVisible(false);
    		
    	}
    	else if(e.getActionCommand().equals("password"))
    	{
    		updateTrackerSecure[1] = 1;
			txtEditPassword.setVisible(true);
    	}
    	else if(e.getActionCommand().equals("0"))
    	{
    		updateTrackerPerson[0] = 1;
			txtEditPersons[0].setVisible(true);
    	}
    	else if(e.getActionCommand().equals("1"))
    	{
    		updateTrackerPerson[1] = 1;
			txtEditPersons[1].setVisible(true);
    	}
    	else if(e.getActionCommand().equals("2"))
    	{
    		updateTrackerPerson[2] = 1;
			chkMale.setVisible(true);
			chkFemale.setVisible(true);
    	}
    	else if(e.getActionCommand().equals("3"))
    	{
    		updateTrackerPerson[3] = 1;
			cboDay.setVisible(true);
			cboMonth.setVisible(true);
			cboYear.setVisible(true);
    	}
    	else if(e.getActionCommand().equals("4"))
    	{
    		updateTrackerPerson[4] = 1;
			txtEditPersons[4].setVisible(true);
    	}
    	else if(e.getActionCommand().equals("5"))
    	{
    		updateTrackerPerson[5] = 1;
			txtEditPersons[5].setVisible(true);
    	}
    	else if(e.getActionCommand().equals("6"))
    	{
    		updateTrackerPerson[6] = 1;
    		cboProvince.setVisible(true);
    	}
    	else if(e.getActionCommand().equals("7"))
    	{
    		updateTrackerPerson[7] = 1;
    		txtEditPersons[7].setVisible(true);
    	}
    	else if(e.getActionCommand().equals("8"))
    	{
    		updateTrackerPerson[8] = 1;
    		txtEditPersons[8].setVisible(true);
    	}//End of action fired block
    }//End of actionPerformed method
	
	//Initialize and add arraylist of buttons
    private void addPersonalsButtons()
    {
    	//Temp variables for initialization
    	Color uBankColor = new Color(100, 100, 255);
    	int tracker = 140;
		
		//Loop to make settings for each button
    	for(int x = 0; x < cmdEditPersons.length; x++)
    	{
    		cmdEditPersons[x] = new JButton("Edit");
    		this.add(cmdEditPersons[x]);
    		cmdEditPersons[x].setBackground(uBankColor);
    		cmdEditPersons[x].setOpaque(false);
			cmdEditPersons[x].setContentAreaFilled(false);
			cmdEditPersons[x].setFocusPainted(false);
			cmdEditPersons[x].setActionCommand("" + x);
			cmdEditPersons[x].addActionListener(this);
			layout.putConstraint(SpringLayout.WEST, cmdEditPersons[x], 350, SpringLayout.WEST, getContentPane());
    		layout.putConstraint(SpringLayout.NORTH, cmdEditPersons[x], tracker, SpringLayout.NORTH, getContentPane());
    		
    		//Increment tracker for new position
    		tracker+=25;
    	}//End of loop
    }//End of add personals buttons method

	//Initializes and adds array list o fields
    private void addPersonalFields()
    {
    	//Temporary variable
    	int tracker = 145;

		//Loop to initialize an make settings
    	for(int x = 0; x < cmdEditPersons.length; x++)
    	{
    		txtEditPersons[x] = new JTextField(20);

    		if(x == 4)
    			txtEditPersons[x] = new JTextField(30);

    		txtEditPersons[x].setText("Enter new data");
    		this.add(txtEditPersons[x]);
			layout.putConstraint(SpringLayout.WEST, txtEditPersons[x], 420, SpringLayout.WEST, getContentPane());
    		layout.putConstraint(SpringLayout.NORTH, txtEditPersons[x], tracker, SpringLayout.NORTH, getContentPane());
    		txtEditPersons[x].setVisible(false);
    		tracker+=25;
    	}//End of loop
    }//End of add personal fields method
	
	//Hides everything when switching tabs
    private void hideComponents()
    {
    	hidePersonals();
    	lblEmail.setVisible(false);
    	lblPassword.setVisible(false);
    	cmdEditPassword.setVisible(false);
    	txtEditPassword.setVisible(false);
    	lblName.setVisible(false);
    	lblLastName.setVisible(false);
    	lblGender.setVisible(false);
    	lblBirth.setVisible(false);
    	lblAddress.setVisible(false);
    	lblPhone.setVisible(false);
    	lblProvince.setVisible(false);
    	lblCity.setVisible(false);
    	lblPostal.setVisible(false);
    	cboDay.setVisible(false);
    	cboMonth.setVisible(false);
    	cboYear.setVisible(false);
    	cboProvince.setVisible(false);
    	chkMale.setVisible(false);
    	chkFemale.setVisible(false);
		
		//Loop to hide fields
    	for(int x = 0; x < txtEditPersons.length; x++)
    	{
    		txtEditPersons[x].setVisible(false);
    	}//End of loop
    }//End of hide components method

	//Displays all the edit buttons for person
    private void showPersonals()
    {
    	for(int x = 0; x < cmdEditPersons.length; x++)
    	{
    		cmdEditPersons[x].setVisible(true);
    	}
    }//End of show personals

	//Hides all the edit buttons for person
    private void hidePersonals()
    {
    	for(int x = 0; x < cmdEditPersons.length; x++)
    	{
    		cmdEditPersons[x].setVisible(false);
    	}
    }//End of hide personals
	
	//Initializes the combo box
    private void initializeCBO()
    {
		for(int x = 1913; x < 2013; x++)
			yearParam[x-1913] = ("" + x);

		cboYear = new JComboBox(yearParam);
    }//End of initialize cbo method

	//Method will attempt to save changes by first checking for correct input
    private void saveChanges() throws IOException
    {
    	//Check for valid information
    	if(proceedToSave())
    	{
    		save();
    		lblComms.setText("Information will appear updated upon next login, save was successful.");
    	}
    	else
    	{
    		errorNum = 4;
    		errorOutput(errorNum);
    	}//End of validity check
    }//End of save changes method

	//Method sets the variables that have changed and writes them to a file
    private void save() throws IOException
    {
    	//Loop to check the update tracker for person
		for(int x = 0; x < updateTrackerPerson.length; x++)
		{
			//Test which fields to update
			if(updateTrackerPerson[x] == 1)
			{
				//Test which field is to be set
				if(x == 0)
					updatingUser.getPerson().setFirst(txtEditPersons[0].getText());
				else if(x == 1)
					updatingUser.getPerson().setLast(txtEditPersons[1].getText());
				else if(x == 2)
				{
					if(chkMale.isSelected() == true && chkFemale.isSelected() == true)
						updatingUser.getPerson().setGender(Gender.valueOf("Both"));
					else if(chkMale.isSelected() == true)
						updatingUser.getPerson().setGender(Gender.valueOf("Male"));
					else if(chkFemale.isSelected() == true)
						updatingUser.getPerson().setGender(Gender.valueOf("Female"));
					else
						updatingUser.getPerson().setGender(Gender.valueOf("Neither"));
				}
				else if(x == 3)
				{
					String [] temps = {"" + cboDay.getSelectedItem(), "" + getMonth(), "" + cboYear.getSelectedItem()};
					updatingUser.getPerson().setBirthDate(new Date(Integer.parseInt(temps[0]), Integer.parseInt(temps[1]), Integer.parseInt(temps[2])));
				}
				else if(x == 4)
					updatingUser.getPerson().setAddress(txtEditPersons[4].getText());
				else if(x == 5)
					updatingUser.getPerson().setPhoneNumber(txtEditPersons[5].getText());
				else if(x == 6)
					updatingUser.getPerson().setProvince("" + cboProvince.getSelectedItem());
				else if(x == 7)
					updatingUser.getPerson().setCity(txtEditPersons[7].getText());
				else if(x == 8)
					updatingUser.getPerson().setPostal(txtEditPersons[8].getText());
			}//End of which field to update test
		}//End of loop for personals
		
		//Update the person object
		updatingUser.getPerson().saveUserInfo("Profiles\\" + updatingUser.getSecurity().getEmail() + "\\" + updatingUser.getSecurity().getEmail());
		
		//Test if password is to be updated
		if(updateTrackerSecure[1] == 1)
		{
			updatingUser.getSecurity().setPassword(txtEditPassword.getText());
			updatingUser.getSecurity().saveSecurity("Profiles\\" + updatingUser.getSecurity().getEmail());
		}//End of update password check
    }//End of save method
	
	//Returns a boolean if the input is all cleared as valid 
    private boolean proceedToSave()
    {
    	//Loop to check if certain fields need error checking
    	for(int x = 0; x < updateTrackerPerson.length; x++)
    	{
    		//Check for a name update and call useful method
    		if(updateTrackerPerson[0] == 1)
    		{
    			if(!useName())
    				return false;
    		}//End of name check

			//Check for a last name update and call useful metho
    		if(updateTrackerPerson[1] == 1)
    		{
    			if(!useLastName())
    				return false;
    		}//End of last name check
			
			//Check for a phone update and call useful method
    		if(updateTrackerPerson[5] == 1)
    		{
    			if(!usePhone())
    				return false;
    		}//End of phone check
			
			//Check for a postal code update and call useful method
    		if(updateTrackerPerson[8] == 1)
    		{
    			if(!usePostal())
    				return false;
    		}//End of postal code check
    	}//End of loop

    	return true;
    }//End of proceedToSave method

	//Check the validity of the name
    private boolean useName()
    {
    	//Loop to check the characters
    	for(int x = 0; x < txtEditPersons[0].getText().length(); x++)
    	{
    		char temp = txtEditPersons[0].getText().charAt(x);
			
			//Test if the char is a hyphen, apostrophe, or letter
    		if(!(temp == 45 || temp == 39 || (temp > 64 && temp < 91) || (temp > 96 && temp < 123)))
    			return false;
    	}//End of loop

    	return true;
    }//End of use name method

	//Check validity of the last name
    private boolean useLastName()
    {
    	//Loop to check characters
    	for(int x = 0; x < txtEditPersons[1].getText().length(); x++)
    	{
    		char temp = txtEditPersons[1].getText().charAt(x);
			
			//Test if the char is a hyphen, apostrophe, or letter
    		if(!(temp == 45 || temp == 39 || (temp > 64 && temp < 91) || (temp > 96 && temp < 123)))
    			return false;
    	}//End of loop

    	return true;
    }//End of use last name method

	//Check the validity of the phone number
    private boolean usePhone()
    {
    	//Loop to test the characters
    	for(int x = 0; x < txtEditPersons[5].getText().length(); x++)
    	{
    		char temp = txtEditPersons[5].getText().charAt(x);

			//Check for a character not equalling a number or hyphen
    		if(!(temp == 45 || temp == ' ' || (temp > 47 && temp < 58)))
    			return false;
    	}//End of loop

    	return true;
    }//End of use phone method

	//Check the validity of the postal code
    private boolean usePostal()
    {
    	//Tmporary variables
		int alpha = 0;
		int numero = 0;
		
		//Loop to test characters
		for(int x = 0; x < txtEditPersons[8].getText().length(); x++)
		{
			char temp = txtEditPersons[8].getText().charAt(x);
			
			//Check if a space
			if(temp != ' ')
			{
				//Check if number of letter
				if(temp > 47 && temp < 58)
					numero++;
				else if((temp > 64 && temp < 91) || (temp > 96 && temp < 123))
					alpha++;
			}//End of space check
		}//End of loop

		//Test if there are 3 each
		if(alpha == 3 && numero == 3)
			return true;
		else
			return false;
    }//End of postal code validity method

	//Uses the error number to output the error from a file
    private void errorOutput(int errorNum)
    {
    	//Use try catch for io
		try
		{
			BufferedReader read = new BufferedReader(new FileReader("errors.txt"));
			String [] errors = new String[getFileSize()];

			//Loop to read errors
			for(int x = 0; x < errors.length; x++)
			{
				errors[x] = read.readLine();
			}//End of loop

			//Loop to check error number
			for(int x = 0; x < errors.length - 1; x+=2)
			{
				if(errorNum == Integer.parseInt(errors[x]))
					lblComms.setText(errors[x+1]);
			}//End of loop
		}
		catch(Exception e)
		{
			System.out.println("Unaccounted error, software crash. " + errorNum);
		}//End of try catch block
    }//End of errorOutput method

	//Returns the size of the file 
    private int getFileSize() throws IOException
    {
    	BufferedReader read = new BufferedReader(new FileReader("errors.txt"));

    	int counter = 0;

		while(read.readLine() != null)
			counter++;
		
		read.close();

		return counter;
    }//End of count file size method

	//Returns month number form
    private int getMonth()
    {
    	return cboMonth.getSelectedIndex() + 1;
    }//End of getMonth
}//End of class