package HW3;

import java.util.Iterator;
//Charlie Sergeant implimentation of Linked List
public class MyLinkedList<E> extends MyAbstractList<E>
{
	private Node<E> head, tail;

	public MyLinkedList()
	{
	}

	public MyLinkedList(E[] objects)
	{
		super(objects);
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

	public void addFirst(E element)
	{
		Node<E> newNode = new Node<E>(element);
		newNode.next = head;
		head = newNode;
		size++;
		if (tail == null)
		{
			tail = head;
		}
	}

	public void addLast(E element)
	{
		Node<E> newNode = new Node<>(element);
		if (tail == null)
		{
			head = tail = newNode;
		} else
		{
			tail.next = newNode;
			tail = newNode;
		}
		size++;
	}

	@Override
	public void add(int index, E e)
	{
		if (index == 0)
		{
			addFirst(e);
		} else if (index >= size)
		{
			addLast(e);
		} else
		{
			Node<E> current = head;
			for (int i = 1; i < index; i++)
			{
				current = current.next;
			}
			Node<E> temp = current.next;
			current.next = new Node<>(e);
			(current.next).next = temp;
			size++;
		}
	}

	public void setFirst(E element)
	{
		head.element = element;
	}

	public void setLast(E element)
	{
		tail.element = element;
	}

	@Override
	public E set(int index, E element)
	{
		Node<E> current = head;
		E replaced;
		if (index == 0)
		{
			replaced = head.element;
			head.element = element;
			return replaced;
		} else
		{
			int i = 1;
			current = current.next;
			while (current != null)
			{
				if (i == index)
				{
					replaced = current.element;
					current.element = element;
					return replaced;
				}
				current = current.next;
				i++;
			}
		}
		return null;
	}

	public E getFirst()
	{
		return head.element;
	}

	public E getLast()
	{
		return tail.element;
	}

	@Override
	public E get(int index)
	{
		Node<E> current = head;
		if (index == 0)
		{
			return head.element;
		} else
		{
			current = current.next;
			int i = 1;
			while (current != null)
			{
				if (i == index)
				{
					return current.element;
				}
				current = current.next;
				i++;
			}
		}
		return null;
	}

	@Override
	public boolean contains(E element)
	{
		Node<E> current = head;
		while (current != null)
		{
			if (current.element == element)
			{
				return true;
			}
			current = current.next;
		}
		return false;
	}

	@Override
	public int indexOf(E element)
	{
		Node<E> current = head;
		int index = 0;
		while (current != null)
		{
			if (current.element == element)
			{
				return index;
			}
			current = current.next;
			index++;
		}
		return 0;
	}

	@Override
	public int lastIndexOf(E element)
	{
		Node<E> current = head;
		int index = 0;
		int indexAtOccurance = 0;
		while (current != null)
		{
			if (current.element == element)
			{
				indexAtOccurance = index;
			}
			current = current.next;
			index++;
		}
		return indexAtOccurance;
	}

	public E removeFirst()
	{
		E trashedHead = head.element;
		Node<E> tempNode = head.next;
		head = tempNode;
		size--;
		return trashedHead;
	}

	public E removeLast()
	{
		if (size == 1)
		{
			E temp = head.element;
			head = tail = null;
			size = 0;
			return temp;
		} else
		{
			Node<E> current = head;

			for (int i = 0; i < size - 2; i++)
			{
				current = current.next;
			}

			E temp = tail.element;
			tail = current;
			tail.next = null;
			size--;
			return temp;
		}
	}

	@Override
	public E remove(int index)
	{
		if (index == 0)
		{

			return removeFirst();
		} else if (index == size - 1)
		{
			return removeLast();
		} else
		{
			Node<E> previous = head;
			for (int i = 1; i < index; i++)
			{
				previous = previous.next;
			}
			Node<E> current = previous.next;
			previous.next = current.next;
			size--;
			return current.element;
		}
	}

	@Override
	public void clear()
	{
		head = head.next = null;
		size = 0;

	}

	@Override /** Override iterator() defined in Iterable */
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

	static class addRemoveThread<E> implements Runnable
	{
		MyLinkedList<E> mal;
		boolean add = true;

		addRemoveThread(MyLinkedList<E> mal)
		{
			this.mal = mal;
		}

		addRemoveThread(MyLinkedList<E> mal, boolean a)
		{
			this.mal = mal;
			this.add = a;
		}

		@Override
		public void run()
		{
			if (add)
				for (int i = 100; i > 4; i--)
				{
					this.mal.add((E) new Integer(i));
					System.out.println(i);
				}
			else
			{
				if (this.mal.size() > 1)
					System.out.println("-" + this.mal.remove(1));
			}
		}

	}

	public static void main(String args[])
	{
		MyLinkedList<Integer> mal = new MyLinkedList<>();
		Runnable r1 = new addRemoveThread<Integer>(mal);
		Runnable r2 = new addRemoveThread<Integer>(mal, false);
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		t1.start();
		t2.start();
		System.out.println(mal);
	}
}
