package HW7;

public class SelectionSortRecursive
{
	public static void selectionSort(int[] arr) 
	{
	    selectionSort(arr, 0);
	}
	
	private static void selectionSort(int[] arr, int index) 
	{
	    if (index < arr.length - 1) 
	    {
	        int smallestIndex = index;
	        for (int i = index + 1; i < arr.length; i++) 
	        {
	            if (arr[i] < arr[smallestIndex]) 
	            {
	                smallestIndex = i;
	            }
	        }
	        int t = arr[index];
	        arr[index] = arr[smallestIndex];
	        arr[smallestIndex] = t;
	        selectionSort(arr, index + 1);
	    }
	}
}

