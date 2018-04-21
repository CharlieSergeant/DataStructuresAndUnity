package HW6;

public class PriorityQueueTest 
{ 
	static class Patient implements Comparable<Patient> 
	{
		private String name;
		private int priority;
		public Patient(String name, int priority) 
		{
			this.name = name;
			this.priority = priority;
		} 
		@Override 
		public String toString() 
		{
			return name + "(priority:" + priority + ")";
		}
		@Override
		public int compareTo(Patient patient) 
		{
			return this.priority - patient.priority;
		} 
	}
	public static void main(String[] args) 
	{ 
		Patient patient1 = new Patient("John", 2);
		Patient patient2 = new Patient("Jim", 1);
		Patient patient3 = new Patient("Tim", 5); 
		Patient patient4 = new Patient("Cindy", 7);
		MyPriorityQueue<Patient> priorityQueue= new MyPriorityQueue<>();
		priorityQueue.offer(patient1);
		priorityQueue.offer(patient2);
		priorityQueue.offer(patient3);
		priorityQueue.offer(patient4);
		 while (priorityQueue.getSize() > 0)
		 {
			 System.out.print(priorityQueue.poll() + " "); 
		 }
	}
}
