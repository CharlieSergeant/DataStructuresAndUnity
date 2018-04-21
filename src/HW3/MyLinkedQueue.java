package HW3;
public class MyLinkedQueue<E>
{
	private Node<E> head, tail;
//	Node top = null;
//	Node bot = null;
	int size = 0;
	public MyLinkedQueue()
	{}
	public MyLinkedQueue(E[] objects)
	{
		for(E e: objects)
			offer(e);
	}
	
	int size()
	{
		return size;
	}
	//add element onto or into queue
	int offer(E e)
	{
		Node n = new Node(e,null,null);
		n.element = e;
		n.next=null;
		n.prev = null;
		if(isEmptyStack())//starting new queue
		{
			head = tail;
			head=n;
			
		}
		else //there is atleast one element
		{
			n.next = tail.prev;
			tail=n;
		}
		size++;
		return size;
	}
	
	Node peek()
	{
		if(isEmptyStack())
		{
			return null;
		}
		return head;
	}
	
	Node poll()
	{
		Node tmp=head;
		if(isEmptyStack())
		{
			return null;
		}
		if(size()==1)
		{
			tail = null;
			head = null;
			size =0;
			return tmp;
		}
		 head=head.prev;
		 head.next = null;
		 size--;
		 return tmp;
	}
	  public boolean isEmptyStack() 
	  {
	    return head==null;
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
		Node<E> prev;

		public Node(E element, Node next, Node prev)
		{
			this.element = element;
			this.next = next;
			this.prev = prev;
		}
	}
}

