//Bradley Hamelin & Brad Bowden

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class LoginScreen extends JFrame implements ActionListener
{
	private int errorNum = -1;
	public static MainScreen mainFrame;

	//Create instances of the GUI components and initialize values
	//Create JButtons
	JButton cmdLogin = new JButton("Log In");
	JButton cmdNewUser = new JButton ("New User");

	//Create JTextFields
	JTextField txtName = new JTextField("User Name", 20);
	JPasswordField txtPass = new JPasswordField(20);

	//Create JLabels
	JLabel lblTitle = new JLabel("Welcome to uBank! Please log in or sign up.");
	JLabel lblComms = new JLabel("");

	//Create an instance of the layout manager
	SpringLayout layout = new SpringLayout();

	//Creates an instance of a LoginScreen
    public LoginScreen()
    {
    	this.add(cmdLogin);
    	this.add(cmdNewUser);
    	this.add(txtName);
    	this.add(txtPass);
    	this.add(lblComms);
    	this.add(lblTitle);

    	//Set the frame colour
    	Color babyBlue = new Color(100,100,255);
    	this.getContentPane().setBackground(babyBlue);

    	//Format the objects
		cmdLogin.setFont(new Font("Gill Sans MT", Font.PLAIN, 20));
    	cmdLogin.setForeground(Color.black);

    	cmdNewUser.setFont(new Font("Gill Sans MT", Font.PLAIN, 20));
    	cmdNewUser.setForeground(Color.black);

    	txtName.setFont(new Font("Gill Sans MT", Font.PLAIN, 30));
    	txtName.setForeground(Color.black);

    	txtPass.setFont(new Font("Gill Sans MT", Font.PLAIN, 30));
    	txtPass.setForeground(Color.black);

    	lblTitle.setFont(new Font("Gill Sans MT", Font.PLAIN, 40));
    	lblTitle.setForeground(Color.black);

    	//Name the buttons
    	cmdLogin.setActionCommand("logIn");
		cmdNewUser.setActionCommand("newUser");

		//Add the action listener to the active object
		cmdLogin.addActionListener(this);
		cmdNewUser.addActionListener(this);

		//Set the layout for the frame
		this.getContentPane().setLayout(layout);

		//Set the north and west positions for the JButtons
		layout.putConstraint(SpringLayout.WEST, cmdLogin, 220, SpringLayout.WEST, getContentPane());
		layout.putConstraint(SpringLayout.NORTH, cmdLogin, 425, SpringLayout.NORTH, getContentPane());

		layout.putConstraint(SpringLayout.WEST, cmdNewUser, 440, SpringLayout.WEST, getContentPane());
		layout.putConstraint(SpringLayout.NORTH, cmdNewUser, 425, SpringLayout.NORTH, getContentPane());

		layout.putConstraint(SpringLayout.WEST, txtName, 50, SpringLayout.WEST, getContentPane());
		layout.putConstraint(SpringLayout.NORTH, txtName, 100, SpringLayout.NORTH, getContentPane());

   		layout.putConstraint(SpringLayout.WEST, txtPass, 50, SpringLayout.WEST, getContentPane());
		layout.putConstraint(SpringLayout.NORTH, txtPass, 200, SpringLayout.NORTH, getContentPane());

		layout.putConstraint(SpringLayout.WEST, lblTitle, 30, SpringLayout.WEST, getContentPane());
		layout.putConstraint(SpringLayout.NORTH, lblTitle, 30, SpringLayout.NORTH, getContentPane());

		layout.putConstraint(SpringLayout.WEST, lblComms, 0, SpringLayout.WEST, getContentPane());
		layout.putConstraint(SpringLayout.NORTH, lblComms, 0, SpringLayout.NORTH, getContentPane());

   		//Set up methods for the frame
		setSize(800,500);
		setLocationRelativeTo(null);
		setTitle("Login");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

    }//End of LoginScreen constructor

    //A method to check if the user's username and password are correct and if so, log them in.
    public void login() throws IOException
    {
    	String email = txtName.getText();

		if(email.length() == 0 || txtPass.getText().length() == 0)
		{
			errorNum = 1;
			errorOutput(errorNum);
		}else
		{

	    	if(checkUsername())
	    	{
				User user = new User(email);
				this.setVisible(false);
				mainFrame = new MainScreen(user);
	    	}
		}
    }

    public void newUser()
    {
    	CreateUser frame = new CreateUser();
    	this.setVisible(false);
    }

    //Checks which button has been clicked and calls the associated application method
    public void actionPerformed(ActionEvent evt)
	{
		try{
		if (evt.getActionCommand().equals("logIn"))
			login();
		else if (evt.getActionCommand().equals ("newUser"))
			newUser();
		}
		catch(Exception a)
		{
			System.out.println(a);
		}
	}//End of ationPerformed method

	private boolean checkUsername()
	{
		String email = txtName.getText();

		try
		{
			File file = new File("Profiles\\" + txtName.getText());

			if(!file.exists())
			{
				errorNum = 3;
				errorOutput(errorNum);
				return false;
			}
			else
			{
				BufferedReader read = new BufferedReader(new FileReader("Profiles\\" + txtName.getText() + "\\Security.txt"));

				if(txtPass.getText().equals(read.readLine()))
				{
					return true;
				}
				else
				{
					errorNum = 2;
					errorOutput(errorNum);
					return false;
				}
			}
		}
		catch(Exception a)
		{
			System.out.println(a);
			return false;
		}
	}

	private void errorOutput(int errorNum)
    {
		try{
			BufferedReader read = new BufferedReader(new FileReader("errors.txt"));
			String [] errors = new String[getFileSize()];

			for(int x = 0; x < errors.length; x++)
			{
				errors[x] = read.readLine();
			}

			for(int x = 0; x < errors.length - 1; x+=2)
			{
				if(errorNum == Integer.parseInt(errors[x]))
					lblComms.setText(errors[x+1]);
			}
		}
		catch(Exception e){
			System.out.println("Unaccounted error, software crash. " + errorNum);
		}
    }

    private int getFileSize() throws IOException
    {
    	BufferedReader read = new BufferedReader(new FileReader("errors.txt"));

    	int counter = 0;

			while(read.readLine() != null)
				counter++;
			read.close();

		return counter;
    }
}