//Your Name Here
//A class template for a date object, which stores the object's day, month, and year

public class Date
{
	//Declare instance variables
	private int day;
	private int month;
	private int year;

	public Date()
	{
		this.day = 1;
		this.month = 1;
		this.year = 1999;
	}

    public Date(int day, int month, int year)
    {
    	this.day = day;
    	this.month = month;
    	this.year = year;
    }//End of constructor

    //A method to calculate days in the Date object
    private long calculateDays()
    {
    	long totalDays = 0;
    	 totalDays = year * 365;

    	 for (int x = 0; x < month; x++)
    	 {
    	 	switch (x)
    	 	{
    	 		case 0:		totalDays += 0;
    	 					break;

    	 		case 1:
    	 		case 3:
    	 		case 5:
    	 		case 7:
    	 		case 8:
    	 		case 12:	totalDays += 31;
    	 					break;

    	 		case 4:
    	 		case 6:
    	 		case 9:
    	 		case 11:	totalDays += 30;
    	 					break;

    	 		case 2:		totalDays += 28;

    	 	}
    	 }
    	 totalDays += day;

    	 return totalDays;
    }//End of calculateDays method

    //A method to calculate years in the Date object
    public double calculateYears()
    {
    	double totalYears = 0;

    	totalYears = this.calculateDays() / 365.0;

    	return totalYears;
    }//End of calculateYears method

    //A String to store a Person object's data for display
    public String toString()
    {
    	String output = "";

    	output = day + "/" + month + "/" + year;

    	return output;
    }//End of toStrring method


	/********************
	 * ACCESSOR METHODS *
	 ********************/

	//Gets the value of day.
	public int getDay()
	{
		return this.day;
	}//End of getDay method

	//Gets the value of month.
	public int getMonth()
	{
		return this.month;
	}//End of getMonth method

	//Gets the value of year.
	public int getYear()
	{
		return this.year;
	}//End of getYear method

	/***************************
	 * END OF ACCESSOR METHODS *
	 ***************************/


	/*******************
	 * MUTATOR METHODS *
	 *******************/

	//Sets the value of day.
	public void setDay(int day)
	{
		this.day = day;
	}//End of setDay method

	//Sets the value of month.
	public void setMonth(int month)
	{
		this.month = month;
	}//End of setMonth method

	//Sets the value of year.
	public void setYear(int year)
	{
		this.year = year;
	}//End of setYear method

	/**************************
	 * END OF MUTATOR METHODS *
	 **************************/
	
	public int calculateMonthDifference(Date lastLogged)
	{
		return 2;
	}

}//End of class