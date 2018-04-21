package Project1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class BirthdaySorting 
{
	public static void main(String[] args)throws IOException
	{
		File file = new File ("birthdayInputFile.txt");
		Scanner reader = new Scanner(file);
		int count = reader.nextInt();
		for(int i = 0; i<count;i++)
		{
			int c1 = reader.nextInt();
			ArrayList <Student> s = new ArrayList<>();
			for(int j = 0;j<c1;j++)
			{
				String firstName = reader.next()+ " ";
				String lastName = reader.next()+ " ";
				String month = reader.next()+ " ";
				int day = reader.nextInt();
				int year = reader.nextInt();
				Student n = new Student(firstName,lastName,month,day,year);
				s.add(n);
			}
			sortStud(s);
			int c2 = reader.nextInt();
			ArrayList<Query> myQuery = new ArrayList<>();
			for(int j = 0;j<c2;j++)
			{
				String fn = reader.next()+ " ";
				String l = reader.next()+ " ";
				Query q = new Query(fn, l);
				myQuery.add(q);
			}
			for(int x = 0;x<myQuery.size();x++)
			{
				myQuery.get(x).findNext(s);
				System.out.println(myQuery.get(x).nextfirst+" "+myQuery.get(x).nextlast+" has the closest birthday to "+myQuery.get(x).first+" "+ myQuery.get(x).last);
			}
		}
		reader.close();	
	}
	
	//sorts students by birthday
	public static ArrayList<Student> sortStud(ArrayList<Student> s)
	{
		Student temp;
		for(int x = 0;x<s.size();x++)
		{
			for(int y = x;y>0;y--)
			{
				if(s.get(y).compareTo(s.get(y-1))>0)
				{
					temp = s.get(y);
					s.set(y,s.get(y-1));
					s.set(y-1,temp);
				}
			}
		}
		return s;
	}
}

