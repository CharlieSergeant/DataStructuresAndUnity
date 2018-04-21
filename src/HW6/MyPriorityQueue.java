package HW6;

public class MyPriorityQueue<E extends Comparable<E>> {
	  private Heap<E> heap = new Heap<E>();

	  public void offer(E newObject) {
	    heap.add(newObject);
	  }

	  public E poll() {
	    return heap.remove();
	  }

	  public int getSize() 
	  {
	    return heap.getSize();
	  }
	  
	  public boolean isEmpty()
	  {
		  return (heap.getSize()==0);
	  }
	}
