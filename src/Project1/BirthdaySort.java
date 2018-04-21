package Project1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
//Charlie Sergeant, Closest Birthday, 3/11/2018  
public class BirthdaySort
{
	public static void main(String[] args)throws IOException
	{
		//input of file
		File file = new File ("birthdayInputFile.txt");
		Scanner reader = new Scanner(file);
		int count = reader.nextInt();//number of classes
		for(int i = 0; i<count;i++)
		{
			System.out.println("Class # "+(i+1)+" :");
			System.out.println();
			int c1 = reader.nextInt();//number of students
			ArrayList <Student> s = new ArrayList<>();
			for(int j = 0;j<c1;j++)
			{
				String firstName = reader.next()+ " ";
				String lastName = reader.next()+ " ";
				String month = reader.next()+ " ";
				int day = reader.nextInt();
				int year = reader.nextInt();
				//creates student object
				Student n = new Student(firstName,lastName,month,day,year);
				s.add(n);
			}
			sortStud(s); //sorts student array by birthday
			int c2 = reader.nextInt(); //number of querys
			ArrayList<Query> myQuery = new ArrayList<>();//list of querys
			for(int j = 0;j<c2;j++)
			{
				String fn = reader.next()+ " ";
				String l = reader.next()+ " ";
				Query q = new Query(fn, l);
				myQuery.add(q);
			}
			for(int x = 0;x<myQuery.size();x++)
			{
				myQuery.get(x).findNext(s); //find closest birthday
				System.out.println(myQuery.get(x).nextfirst+" "+myQuery.get(x).nextlast+" has the closest birthday to "
				+myQuery.get(x).first+" "+ myQuery.get(x).last); //output
			}
			System.out.println();
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

