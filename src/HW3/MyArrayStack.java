package HW3;

public class MyArrayStack <E> 
{
	public static final int block = 1<<8;
	E[] myStack = (E[])(new Object[block]);
	int top = -1;
	MyArrayStack()
	{
	}
	MyArrayStack(E[] objects)
	{
		for(E e: objects)
			push(e);
	}
	
	int size()
	{
		return top+1;
	}
	int push(E e)
	{
		myStack[++top]=e;
		return top;
	}
	
	E peek()
	{
		E o = myStack[++top];
		return o;
	}
	E pop()
	{
		if(isEmptyStack())
		{
			return null;
		}
		else
		{
			 E o = myStack[top];
			 top--;
			 return o;
		}
	}
	  public boolean isEmptyStack() 
	  {
	    return top<0;
	  }
}
