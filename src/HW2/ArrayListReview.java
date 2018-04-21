package HW2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class ArrayListReview <N extends Number>
{
	ArrayList<N> arr = new ArrayList<>();
	LinkedList<N> myArr = new LinkedList<>();
	
	public ArrayListReview(ArrayList <N> a,LinkedList<N> b)
	{
		this.arr = a;
		this.myArr = b;
	}
	
	public ArrayListReview()
	{
		arr = (ArrayList<N>) new ArrayList<>(Arrays.asList(new Integer[] {43,53,10}));
		myArr = (LinkedList<N>) new LinkedList<>(Arrays.asList(new Integer[] {43,53,10}));
	}
	
	public ArrayListReview(int count)
	{
		Integer []array = new Integer[count];
			for(int x = 0;x<count;x++)
			{
				array[x]= (int)(Math.random()*100);
				
			}
			arr = (ArrayList<N>) new ArrayList<>(Arrays.asList(array));
			myArr = (LinkedList<N>) new LinkedList<>(Arrays.asList(array));
			
	}
	
	void setindexValue(int index, N value) 
	{
		
	}
	
	//arrayList print
	public void print(ArrayList<Integer> arr)
	{
		for(int x = 0;x<arr.size();x++)
		{
			System.out.print((Integer)arr.get(x)+" ");
		}
		System.out.println();
	}
	
	//list print
	public void print(LinkedList<Integer> arr)
	{
		for(int x = 0;x<arr.size();x++)
		{
			System.out.print((Integer)arr.get(x)+" ");
		}
		System.out.println();
	}
	
	//prints (count) numbers of fib 
	public long Fibonacci(int count)
	{
		long now =System.nanoTime();
		ArrayList <Long>fib = new ArrayList<>();
		fib.add(0,(long) 0);
		fib.add(1,(long) 1);
		for(int x = 2;x<count;x++)
		{
			fib.add(fib.get(x-1)+fib.get(x-2));
		}
		
		for(int x = 0;x<fib.size();x++)
		{
			System.out.print(fib.get(x)+" ");
		}
		System.out.println();
		long duration = (System.nanoTime()-now);
		return duration;
	}
	
	//checks if input array is same forwards and backwards
	public boolean isPalindrome()
	{
		for(int x = 0;x<arr.size()/2;x++)
		{
			if(!(arr.get(x)==arr.get((arr.size()-x)-1)))
			{
				return false;
			}
		}
		return true;
	}
	
//	public boolean isPalindrome(List<Integer> arr)
//	{
//		for(int x = 0;x<arr.size()/2;x++)
//		{
//			if(!(arr.get(x)==arr.get((arr.size()-x)-1)))
//			{
//				return false;
//			}
//		}
//		return true;
//	}
	
	//recursive sort of a linkedlist
	LinkedList<N> mergeSort(LinkedList<N>inlist)
	{
		if(inlist.size()==1)
			return inlist;
			else if(inlist.size()==2)
			{
				if(inlist.get(0).intValue()> inlist.get(1).intValue())
					return inlist;
				else
				{
					N temp = inlist.get(0);
					inlist.set(0, inlist.get(1));
					inlist.set(1,temp);
					return inlist;
				}
			} 
			else
			{
				LinkedList<N> left = new LinkedList<N>(inlist.subList(0,inlist.size()/2));
				LinkedList<N> right = new LinkedList<N>(inlist.subList(inlist.size()/2,inlist.size()));
				return merge(mergeSort(left),mergeSort(right));
			}
	}
	
	LinkedList<N> merge(LinkedList <N> left,LinkedList<N> right)
	{
		int i = 0;
		int j = 0;
		LinkedList<N> merged = new LinkedList<>();
		while((i<left.size())&&(j<right.size()))
		{
			if(left.get(i).intValue()>right.get(j).intValue())
			{
				merged.add(left.get(i++));
			}
			else
			{
				merged.add(right.get(j++));
				
			}
		}
		while(i<left.size())
		{
			merged.add(left.get(i++));
		}
		
		while(j<right.size())
		{
			merged.add(right.get(j++));
		}
		return merged;
	}
	
	public static void main (String[] args)
	{
		long now = System.nanoTime();
		ArrayListReview a = new ArrayListReview(10);
		a.print(a.arr);
		System.out.println(a.Fibonacci(50));
		long duration = System.nanoTime()-now;
		System.out.println("Time to print first 50 fib numbers "+duration);
		System.out.println("Is the array a palindrome? "+a.isPalindrome());
		a.print(a.mergeSort(a.myArr));
	}
	
}
