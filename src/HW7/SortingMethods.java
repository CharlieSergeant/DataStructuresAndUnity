package HW7;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class SortingMethods
{
	public static int[] doInsertionSort(int[] input)
	{
		int temp;
		for (int i = 1; i < input.length; i++)
		{
			for (int j = i; j > 0; j--)
			{
				if (input[j] < input[j - 1])
				{
					temp = input[j];
					input[j] = input[j - 1];
					input[j - 1] = temp;
				}
			}
		}
		return input;
	}

	public static void insertionSortRecursive(int arr[], int n)
	{
		if (n <= 1)
			return;
		insertionSortRecursive(arr, n - 1);
		int last = arr[n - 1];
		int j = n - 2;
		while (j >= 0 && arr[j] > last)
		{
			arr[j + 1] = arr[j];
			j--;
		}
		arr[j + 1] = last;
	}

	public static int[] doSelectionSort(int[] arr)
	{
		for (int i = 0; i < arr.length - 1; i++)
		{
			int index = i;
			for (int j = i + 1; j < arr.length; j++)
				if (arr[j] < arr[index])
					index = j;

			int smallerNumber = arr[index];
			arr[index] = arr[i];
			arr[i] = smallerNumber;
		}
		return arr;
	}

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

	// first method, sort method
	public static void quickSortRecursive(int[] list)
	{
		quickSortRecursive(list, 0, list.length - 1);
	}

	// helper method
	public static void quickSortRecursive(int[] list, int first, int last)
	{
		if (last > first)
		{
			int pivotIndex = partition(list, first, last);// make pivot
			quickSortRecursive(list, first, pivotIndex - 1);// left half before
															// pivot
			quickSortRecursive(list, pivotIndex + 1, last);// right half after
															// pivot
		}
	}

	// pivot maker
	public static int partition(int[] list, int first, int last)
	{
		int pivot = list[first];
		int low = first + 1;
		int high = last;

		while (high > low)
		{
			// searches foward from left
			while (low <= high && list[low] <= pivot)
				low++;

			// searches backward from right
			while (low <= high && list[high] > pivot)
				high--;

			// swap elements in the list
			if (high > low)
			{
				int temp = list[high];
				list[high] = list[low];
				list[low] = temp;
			}
		}
		while (high > first && list[high] >= pivot)
			high--;

		// swap pivot with list[high]
		if (pivot > list[high])
		{
			list[first] = list[high];
			list[high] = pivot;
			return high;
		} else
		{
			return first;
		}

	}

	public class QuickSort<T extends Number>
	{
		private int first, last, boundLo, boundHi, pivot;
		int temp[] = { 0, 0 };

		public QuickSort()
		{
			super();
		}

		public void sort(List<T> list)
		{

			Deque<int[]> stack = new ArrayDeque<int[]>();

			first = 0;
			last = list.size() - 1;

			stack.push(new int[] { first, last });

			while (!stack.isEmpty())
			{
				sortStep(list, stack);
			}
		}

		private void sortStep(List<T> list, Deque<int[]> stack)
		{

			temp = stack.pop();
			first = temp[0];
			last = temp[1];

			boundLo = first;
			boundHi = last;
			pivot = last;

			while (first < last)
			{
				if (list.get(first).doubleValue() >= list.get(pivot).doubleValue())
				{
					last--;
					if (first != last)
						Collections.swap(list, first, last);
					Collections.swap(list, last, pivot);
					pivot--;
				} else
					first++;
			}

			if (boundLo < (pivot - 1))
				stack.add(new int[] { boundLo, pivot - 1 });

			if (boundHi > (pivot + 1))
				stack.add(new int[] { pivot + 1, boundHi });
		}

	}

	public static void bubbleSort(int[] list)
	{
		boolean needNextPass = true;
		for (int k = 1; k < list.length && needNextPass; k++)
		{
			needNextPass = false;
			for (int i = 0; i < list.length - k; i++)
			{
				if (list[i] > list[i + 1])
				{
					int temp = list[i];
					list[i] = list[i + 1];
					list[i + 1] = temp;
					needNextPass = true;
				}
			}
		}
	}

	static void bubbleSortRecursive(int arr[], int n)
	{
		// Base case
		if (n == 1)
			return;

		// One pass of bubble sort. After
		// this pass, the largest element
		// is moved (or bubbled) to end.
		for (int i = 0; i < n - 1; i++)
			if (arr[i] > arr[i + 1])
			{
				// swap arr[i], arr[i+1]
				int temp = arr[i];
				arr[i] = arr[i + 1];
				arr[i + 1] = temp;
			}

		// Largest element is fixed,
		// recur for remaining array
		bubbleSortRecursive(arr, n - 1);
	}

	public static void mergeSortRecur(int[] list)
	{
		if (list.length > 1)
		{
			int[] firstHalf = new int[list.length / 2];
			System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
			mergeSortRecur(firstHalf);

			int secondHalfLength = list.length - list.length / 2;
			int[] secondHalf = new int[secondHalfLength];
			System.arraycopy(list, list.length / 2, secondHalf, 0, secondHalfLength);
			mergeSortRecur(secondHalf);
			merge(firstHalf, secondHalf, list);
		}
	}

	public static void merge(int[] list1, int[] list2, int[] temp)
	{
		int curr1 = 0;
		int curr2 = 0;
		int curr3 = 0;

		while (curr1 < list1.length && curr2 < list2.length)
		{
			if (list1[curr1] < list2[curr2])
				temp[curr3++] = list1[curr1++];
			else
				temp[curr3++] = list2[curr2++];
		}

		while (curr1 < list1.length)
			temp[curr3++] = list1[curr1++];

		while (curr2 < list2.length)
			temp[curr3++] = list2[curr2++];
	}

	public static void mergeSort(int[] array)
	{
		if (array == null)
		{
			return;
		}

		if (array.length > 1)
		{
			int mid = array.length / 2;

			// Split left part
			int[] left = new int[mid];
			for (int i = 0; i < mid; i++)
			{
				left[i] = array[i];
			}

			// Split right part
			int[] right = new int[array.length - mid];
			for (int i = mid; i < array.length; i++)
			{
				right[i - mid] = array[i];
			}
			mergeSort(left);
			mergeSort(right);

			int i = 0;
			int j = 0;
			int k = 0;

			// Merge left and right arrays
			while (i < left.length && j < right.length)
			{
				if (left[i] < right[j])
				{
					array[k] = left[i];
					i++;
				} else
				{
					array[k] = right[j];
					j++;
				}
				k++;
			}
			// Collect remaining elements
			while (i < left.length)
			{
				array[k] = left[i];
				i++;
				k++;
			}
			while (j < right.length)
			{
				array[k] = right[j];
				j++;
				k++;
			}
		}
	}

	public static void print(int[] arr)
	{
		for (int x = 0; x < arr.length; x++)
		{
			System.out.print(arr[x] + " ");
		}
	}
	
	public static int [] genRanList(int length)
	{
		int [] arr = new int[length];
		for(int x = 0;x<length;x++)
		{
			arr[x] = (int)(Math.random()*100+1);
		}
		return arr;
	}
	public static void main(String[] args)
	{
		int[] list = genRanList(10);
		print(list);
		System.out.println();
		mergeSortRecur(list);
		System.out.println("Merge sort Recursive");
		print(doInsertionSort(list));
	}
}
