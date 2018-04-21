import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Exam1Review
{
	
	public static void main(String...strings)
	{
		//System.out.println(factorial(5));
//		n = 12345;
//		System.out.println(xMethod(10));
		//System.out.println(fib(10));
	    int[] x = {1, 2, 3, 4, 5};
	    xMethod(x, 5);

	}
	  public static void xMethod(int[] x, int length) {
		    System.out.print(" " + x[length - 1]);
		    xMethod(x, length - 1);
		  }
		}

//	static int xMethod(int n) {
//		  if (n == 1)
//		    return 1;
//		  else
//		    return n + xMethod(n - 1);
//		}

//	public static long fib(long index) {
//	    if (index == 0) // Base case
//	      return 0;
//	    else if (index == 1) // Base case
//	      return 1;
//	    else // Reduction and recursive calls
//	      return fib(index - 2) + fib(index - 1);
//	}

//	public static void xMethod(int n) {
//	    if (n > 0) {
//	      System.out.print(n % 10);
//	      xMethod(n / 10);
//	    }
//	}

//	public static long factorial(int n) {
//	    if (n == 0) // Base case
//	      return 1;
//	    else
//	      return n * factorial(n - 1); // Recursive call
//	  }
//	    Stack<String> stack1 = new Stack<String>();
//	    Stack<Object> stack2 = new Stack<Object>();
//	    stack2.push("Java");
//	    stack2.push(2);
//	    stack1.push("Sun");
//	    add(stack1, stack2);
//	    print(stack2);
//	  }
//
//	  public static <T> void add(Stack<? extends T> stack1,
//	      Stack<T> stack2) {
//	    while (!stack1.isEmpty())
//	      stack2.push(stack1.pop());
//	  }
//
//	
//public static <E> void print(Stack<Object> stack2) {
//    for (int i = 0; i < stack2.size(); i++)
//      System.out.print(stack2.get(i) + " ");
//    System.out.println();
//  }


}
