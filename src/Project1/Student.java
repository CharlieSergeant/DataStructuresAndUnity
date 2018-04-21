package Project1;
public class Student
{
	public String firstName, lastName, month;
	public int day,year;
	//student class creates objects
	public Student(String Fn, String Ln,String month, int day, int year)
	{
		this.firstName = Fn;
		this.lastName = Ln;
		this.month=month;
		this.day = day;
		this.year = year;
	}
	//getters and setters for values
	public String getFirstName() 
	{
		return firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public String getMonth()
	{
		return month;
	} 
	
	public int getDay()
	{
		return day;
	} 
	
	public int getYear()
	{
		return year;
	} 
	
	public void setFirstName(String fName)
	{
		this.firstName = fName; 
	}
	
	public void setLastName(String lName)
	{
		this.lastName = lName;
	}
	
	public void setMonth(String month)
	{
		this.month = month;
	}
	
	public void setDay(int day)
	{
		this.day = day;
	}
	
	public void setYear(int year)
	{
		this.year = year;
	}
	//compares months between objects
	public int compareMonth(String a,String b)
	{
		if(monthCalc(a)==monthCalc(b))
			return 0;
		else if(monthCalc(a)<monthCalc(b))
			return -1;
		else
			return 1;
			
	}
	//gives months values so they can be sorted
	public int monthCalc(String a)
	{
		switch(a)
		{
			case"JANUARY":
			return 1;
			case"FEBRUARY":
			return 2;
			case"MARCH":
			return 3;
			case"APRIL":
			return 4;
			case"MAY":
			return 5;
			case"JUNE":
			return 6;
			case"JULY":
			return 7;
			case"AUGUST":
			return 8;
			case"SEPTEMBER":
			return 9;
			case"OCTOBER":
			return 10;
			case"NOVEMBER":
			return 11;
			case"DECEMBER":
			return 12;
		}
		return -1;
	}
	
	//compares the birthdays after month is calculated
	public int compareDay(Student o)
	{
		if (this.getDay() == o.getDay())
			return 0;
		else if(this.getDay()>o.getDay())
			return -1;
		else
			return 1;
	}
	//compares objects
	public int compareTo(Student o)
	{
		if(compareMonth(this.getMonth(),o.getMonth())==0)
		{//compares months
			if(compareDay(o)==0)				
			{//compares days
				if(this.getLastName().compareTo(o.getLastName())==0)
				{//compares last name
					if(this.getFirstName().compareTo(o.getFirstName())==0)
					{//compares first name
						return 0;
					}
					else if(this.getFirstName().compareTo(o.getFirstName())>0)
						return -1;
					else 
						return 1;
				}
				else if(this.getLastName().compareTo(o.getLastName())>0)
					return -1;
				else 
					return 1;
			}
			else if(compareDay(o)>0)
				return -1;
			else 					
				return 1;
		}
		else if(compareMonth(this.getMonth(),o.getMonth())<0)
			return -1;
		else
			return 1;
	}	
}
