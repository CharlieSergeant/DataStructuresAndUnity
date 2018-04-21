import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ArrayReview
{
	int [] array = new int [10];
	int [][] array2 = {{3,4,5},{6,7,2},{5,8,1}};
	public ArrayReview()
	{
		for(int x =0;x<array.length;x++)
		{
			array[x] = (int) (Math.random()*100);
		}
	}
	
	public int [] getArray()
	{
		return array;
	}
	
	public void setArray(int[] arrayA)
	{
		array=arrayA;
	}
	
	public void print()
	{
		for(int x =0;x<array.length;x++)
		{
			System.out.print(array[x]+" ");
		}
		System.out.println();
	}
	
	public void setKthItem(int k, int item)
	{
		array[k]=item;
	}
	
	public int pickMaxIndex(int start,int end)
	{
		int max = 0;
		int place = 0;
		for(int x = start;x<end;x++)
		{
			if(array[x]>max)
			{
				max=array[x];
				place = x;
			}
		}
		return place;
	}
	
	public void selectionSort()
	{
		for(int x = 0;x<array.length-1;x++)
		{
			int index = x;
			//if y Arrval is less than x Arrval the values will be switched in the array
			for(int y = x+1;y<array.length;y++)
			{
				if(array[y]<array[index])
					index = y;
			}
			//switching the vals 
			int small = array[index];
			array[index] = array[x];
			array[x]= small;
		}
	}
	
	public void inputExport()throws IOException
	{
		//need files inport and export in the folder that ArrayReview.java is in
		//Inport
		File file = new File ("inport.txt");
		Scanner reader = new Scanner(file);
		int arr [] = new int [10];
		int count = 0;
		while(reader.hasNext())
		{
			int val = reader.nextInt();
			arr[count]=val;
			count++;
		}
		//Export
		PrintWriter printWriter = new PrintWriter("export.txt");
		for(int x = 0;x<arr.length;x++)
		{
			printWriter.println(arr[x]);
		}
		printWriter.close();
	}
	
	public static void main (String[] args) throws IOException
	{
		ArrayReview a = new ArrayReview();
		a.print();
		a.setKthItem(0, 15);
		a.print();
		System.out.println(a.pickMaxIndex(0,9));
		a.selectionSort();
		a.print();
		a.inputExport();
	}
}
