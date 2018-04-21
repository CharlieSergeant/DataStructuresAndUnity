package HW3;

import java.util.Iterator;
//Charlie Sergeant implimentation of Array List
public class MyArrayList<E>extends MyAbstractList<E> implements MyList<E>
{
	public static final int initialCapacity = 1<<3;
	E[] data = (E[]) new Object[initialCapacity];
	private int index;
	MyArrayList()
	{
		size = 0;
	}
	MyArrayList(E[] objects)
	{
		for(int i =0;i<objects.length; i++)
			add(i,objects[i]);
	}
	  public java.util.Iterator<E> iterator() {
		    return new ArrayListIterator();
		  }
		 
		  private class ArrayListIterator 
		      implements java.util.Iterator<E> {
		    private int current = 0; 

		    @Override
		    public boolean hasNext() {
		      return current < size;
		    }

		    @Override
		    public E next() {
		      return data[current++];
		    }

		    @Override 
		    public void remove() {
		    	if (current == 0) 
		        throw new IllegalStateException(); 
		      MyArrayList.this.remove(current - 1);
		    }
		  }

	@Override
	public void add(int index, E e)
	{
		ensureCapacity();
		for(int x = size-1;x>=index;x--)
		{
			data[x+1]=data[x];
		}
		data[index]=e;
		size++;
	}
	
	private void ensureCapacity()
	{
		if(size>= data.length)
		{
			E[] newData = (E[])new Object[size*2+1];
			System.arraycopy(data, 0, newData, 0, size);
			data = newData;
		}
	}

	@Override
	public void clear()
	{
		for(int x = 0; x<size;x++)
		{
			data[x]=null;
		}
		size = 0;
	}

	@Override
	public boolean contains(E e)
	{
		 for (int i = 0; i < size; i++)
		      if (e.equals(data[i])) 
		    	  return true;
		 return false;
	}

	@Override
	public E get(int index)
	{
		
		return null;
	}

	@Override
	public int indexOf(E e)
	{
		if(e == null)
		{
			for(int x = 0; x<size;x++)
			{
				if(data[x]==null)
					return x;
			}
		}
		else
		{
			for(int x = 0;x<size;x++)
			{
				if(e.equals(data[x]))
				{
					return x;
				}
			}
		}
		
		return -1;
	}

	@Override
	public int lastIndexOf(E e)
	{
		// TODO Auto-generated method stub
		return 0;
	}

	
	public E remove(int index)
	{
		E e = data[index];
	    for (int j = index; j < size - 1; j++)
	    {
	      data[j] = data[j + 1];
	    }
	    data[size - 1] = null;
	    size--;
	    return e;
	}

	@Override
	public E set(int index, E e)
	{
		 E old = data[index];
		 data[index] = e;
		 return old;
	}
	
	 @Override
	  public String toString() {
	    StringBuilder result = new StringBuilder("[");

	    for (int i = 0; i < size; i++) {
	      result.append(data[i]);
	      if (i < size - 1) result.append(", ");
	    }

	    return result.toString() + "]";
	  }
	 public static void main(String[] args) {
		    MyList<String> list = new MyArrayList<>();
		    //testing add methods
		    list.add("America"); 
		    System.out.println("(1) " + list);
		    list.add(0, "Canada"); 
		    System.out.println("(2) " + list);
		    //testing contains method
		    System.out.println(list.contains("America"));
		    //testing set method
		    list.set(0, "Europe");
		    System.out.println("(3) " + list);
	 }
}
