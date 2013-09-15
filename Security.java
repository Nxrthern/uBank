/**
 * @(#)Security.java
 *
 *
 * @author
 * @version 1.00 2012/6/5
 */
import java.io.*;

public class Security
{
	private String email;
	private String password;

	public Security()
	{
		//nuthin
	}

	public Security(String email, String password)
	{
		this.email = email;
		this.password = password;
	}

    public Security(String email) throws IOException
    {
    	//String encrypted = encrypt(password);
    	this.email = email;

    	initializeFromFile();
    }

    /*private String encrypt(String password)
    {
    	int key = Math.random() * 100;

    	for(int x = 0; x < key; x++)
    	{
    		for(int y = 0; y < x; y++)
    		{
    			password
    		}
    	}
    }*/

    public String getEmail()
    {
        return email;
    }

    public String getPassword()
    {
    	return password;
    }

    public void setPassword(String password)
    {
    	this.password = password;
    }

    public void setEmail(String email)
    {
    	this.email = email;
    }

    private void initializeFromFile() throws IOException
    {
    	BufferedReader read = new BufferedReader(new FileReader("Profiles\\" + email + "\\Security.txt"));

    	this.password = read.readLine();

    	read.close();
    }

    public void saveSecurity(String path) throws IOException
    {
    	File file = new File(path + "\\Security.txt");

    	if(file.exists())
    	{
    	}
    	else
    		file.createNewFile();

    	PrintWriter write = new PrintWriter(new FileWriter(file, false));

    	write.println(password);

		write.close();
    }

    public String toString()
    {
    	String output = email + " " + password;
    	return output;
    }
}