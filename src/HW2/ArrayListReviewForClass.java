package HW2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class ArrayListReviewForClass <N extends Number>
{
	ArrayList<N> arr = new ArrayList<>();
	LinkedList<N> myArr = new LinkedList<>();
	PriorityQueue<N> myPQ = new PriorityQueue<>();
	public ArrayListReviewForClass(ArrayList <N> a,LinkedList<N> b,PriorityQueue<N> c)
	{
		this.arr = a;
		this.myArr = b;
		this.myPQ = c;
	}
	
	public ArrayListReviewForClass()
	{
		arr = (ArrayList<N>) new ArrayList<>(Arrays.asList(new Integer[] {43,53,10}));
		myArr = (LinkedList<N>) new LinkedList<>(Arrays.asList(new Integer[] {43,53,10}));
		myPQ.offer((N) new Integer (45));
		myPQ.offer((N) new Integer (53));
		myPQ.offer((N) new Integer (10));
	}
	
	public ArrayListReviewForClass(int count)
	{
		Integer []array = new Integer[count];
			for(int x = 0;x<count;x++)
			{
				array[x]= (int)(Math.random()*100);
				
			}
			arr = (ArrayList<N>) new ArrayList<>(Arrays.asList(array));
			myArr = (LinkedList<N>) new LinkedList<>(Arrays.asList(array));
			
	}
	
	void setindexValuie(int index, N value) 
	{
		
	}
	
	public void print(ArrayList<Integer> arr)
	{
		for(int x = 0;x<arr.size();x++)
		{
			System.out.print((Integer)arr.get(x)+" ");
		}
		System.out.println();
	}
	
	public void print(LinkedList<Integer> arr)
	{
		for(int x = 0;x<arr.size();x++)
		{
			System.out.print((Integer)arr.get(x)+" ");
		}
		System.out.println();
	}
	
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
//	public void mergeSort(ArrayList<Integer> arr)
//	{
//		if(arr.size()>1)
//		{
//			//splitting the array into halfs
//			//first half
//			ArrayList<Integer> first = new ArrayList<>(arr.size()/2);
//			int mid = arr.size()/2;
//			int end = arr.size();
//			for(int x = 0;x<mid;x++)
//			{
//				first.add(arr.get(x));
//			}
//			mergeSort(first);
//			//second half
//			ArrayList<Integer> second = new ArrayList<>(arr.size()-arr.size()/2);
//			for(int x = mid;x<end;x++)
//			{
//				second.add(arr.get(x));
//			}
//			mergeSort(second);
//			merge(first,second,arr);
//		}
//	}
//	
//	public LinkedList<N> merge(LinkedList<N> first,LinkedList<N> second,LinkedList<N> temp)
//	{
//		int c1 = 0;//Counter for first half
//		int c2 = 0;//counter for secound half
//		int c3 = 0;//counter for temp
//		
//		while(c1<first.size()&&c2<second.size())
//			if(first.get(c1).intValue()>second.get(c2).intValue())
//				temp.set(c3++, first.get(c1++));
//			else
//				temp.set(c3++, second.get(c2++));
//		
//		while(c1<first.size())
//			temp.set(c3++, first.get(c1++));
//		
//		while(c2<second.size())
//			temp.set(c3++, second.get(c1++));	
//		
//		return temp;
//	}
	
	public static void main (String[] args)
	{
//		long now = System.nanoTime();
		ArrayListReview a = new ArrayListReview(10);
//		a.print(a.arr);
//		System.out.println(a.Fibonacci(50));
//		long duration = System.nanoTime()-now;
//		System.out.println(duration);
//		System.out.println(a.isPalindrome());
		LinkedList <Integer> ar = new LinkedList<>(Arrays.asList(0,3,5,6,1,2,7,8));
		a.mergeSort(a.myArr);
		a.print(a.mergeSort(ar));
//		for(Object n:a.myPQ)
//		{
//			int m = ((Number) n).intValue();
//			System.out.print(m+"\t");
//		}
//		System.out.println();
//			System.out.println(((Number) a.myPQ.poll()).intValue());
//			System.out.println(((Number) a.myPQ.poll()).intValue());
//			System.out.println(((Number) a.myPQ.poll()).intValue());
//			for(Object n:a.myPQ)
//			{
//				int m = ((Number) n).intValue();
//				System.out.print(m+"\t");
//			}
//			System.out.println();
//			System.out.println(a.myPQ);
//		ArrayListReview a = new ArrayListReview(1000000);
//		long now = System.nanoTime();
//		a.arr.add(0,999);
//		long duration = System.nanoTime()-now;
//		System.out.println(duration);
//		now = System.nanoTime();
//		a.myArr.addFirst(999);
//		duration = System.nanoTime()-now;
//		System.out.println(duration);
		
	}
	
}
