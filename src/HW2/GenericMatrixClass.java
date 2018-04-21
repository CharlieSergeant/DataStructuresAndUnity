package HW2;

import java.util.Scanner;

public class GenericMatrixClass
{
	  int p, q, m, n;
	public boolean validArray()
	{
		
	      Scanner scan = new Scanner(System.in);
	      System.out.print("Enter number of rows");
	      p = scan.nextInt();
	      System.out.print("Enter number of columns");
	      q = scan.nextInt();
	      System.out.print("Enter number of rows");
	      m = scan.nextInt();
	      System.out.print("Enter number of columns");
	      n = scan.nextInt();
	      if(p==m&&q==n)
	    	  return true;
	      else
	    	  return false;
	}
			
	public int[][] addArray(int[][]arr1, int[][]arr2)
	{
		
	}
	public static void main(String[] args)
	{
		GenericMatrixClass v = new GenericMatrixClass();
		if(v.validArray())
		{
			
		}
			
		
	}
	

}
