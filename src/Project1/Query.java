package Project1;

import java.util.ArrayList;

public class Query
{
	String first;
	String last;
	String nextfirst;
	String nextlast;
	public Query(String first,String last)
	{
		this.first = first;
		this.last = last;
	}
	//finds next student 
	void findNext(ArrayList<Student> arr)
	{
		for(int x = 0;x<arr.size();x++)
		{
			if(arr.get(x).firstName.equals(first)&&arr.get(x).lastName.equals(last))
			{
				if(x==arr.size()-1)//if last student in array chose the first student
				{
					nextfirst = arr.get(0).firstName;
					nextlast = arr.get(0).lastName;
				}
				else //chose next student in sorted array
				{
					nextfirst = arr.get(x+1).firstName;
					nextlast = arr.get(x+1).lastName;	
				}
			}
		}
	}
}
