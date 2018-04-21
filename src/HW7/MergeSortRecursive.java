package HW7;

import java.util.LinkedList;

public class MergeSortRecursive<N>
{
	LinkedList<N> mergeSort(LinkedList<N>inlist)
	{
		if(inlist.size()==1)
			return inlist;
			else if(inlist.size()==2)
			{
				if((inlist.get(0))> inlist.get(1))
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
