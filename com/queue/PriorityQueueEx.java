
import java.util.PriorityQueue;
/**
* order employee records in the ascending order of their salaries 
* or you may want to order the customers on their id’s.
*/
class PriorityQueueEx{
	
	static void priorityQueueEx(){
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.offer(1);
		pq.offer(7);
		pq.offer(5);
		pq.offer(4);
		pq.offer(8);
		System.out.println(pq);
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq);
	}

	static void priorityQueueEmployee(){
		EmpComparator comparator = new EmpComparator();
		PriorityQueue<Employee> pqe = new PriorityQueue<>(7, comparator);
		pqe.offer(new Employee("Jane", 15000));
		pqe.offer(new Employee("Jae", 19000));
		pqe.offer(new Employee("Jne", 14000));
		pqe.offer(new Employee("ane", 11000));
		pqe.offer(new Employee("Jaene", 15000));
		pqe.offer(new Employee("Janee", 10000));
		pqe.offer(new Employee("Janen", 12000));
		System.out.println(pqe);
		System.out.println(pqe.poll());
		System.out.println(pqe.poll());
		System.out.println(pqe);
	}


	public static void main(String[] args){
		//priorityQueueEx();
		priorityQueueEmployee();
	}


}

