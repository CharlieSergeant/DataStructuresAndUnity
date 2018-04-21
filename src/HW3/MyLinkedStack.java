package HW3;

import java.util.Iterator;



public class MyLinkedStack<E> 
{
	private Node<E> head, tail;
	Node top = null;
	int size = 0;
	public MyLinkedStack()
	{}
	public MyLinkedStack(E[] objects)
	{
		for(E e: objects)
			push(e);
	}
	
	int size()
	{
		return size;
	}
	int push(E e)
	{
		Node n = new Node(e);
		if(top==null)
			top = n;
		else
		{
			top = n.next;
		}
		size++;
		return size;
	}
	
	Node peek()
	{
		return top;
	}
	Node pop()
	{
		if(isEmptyStack())
		{
			return null;
		}
		else
		{
			 Node o =top;
			 top = o.next;
			 size--;
			 return o;
		}
	}
	  public boolean isEmptyStack() 
	  {
	    return top==null;
	  }
	
	public java.util.Iterator<E> iterator()
	{
		return new LinkedListIterator();
	}

	private class LinkedListIterator implements java.util.Iterator<E>
	{
		private Node<E> current = head;

		@Override
		public boolean hasNext()
		{
			return (current != null);
		}

		@Override
		public E next()
		{
			E e = current.element;
			current = current.next;
			return e;
		}

		@Override
		public void remove()
		{
		}
	}
	private static class Node<E>
	{
		E element;
		Node<E> next;

		public Node(E element)
		{
			this.element = element;
		}
	}
}
