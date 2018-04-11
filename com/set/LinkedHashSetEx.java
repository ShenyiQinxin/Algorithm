import java.util.LinkedHashSet;
import java.util.Iterator;
/**
* doubly linked list to maintain an insertion order
* no dup 
*/
class LinkedHashSetEx{

	static void linkedHashSetEx(){

		LinkedHashSet<Employee> set = new LinkedHashSet<>();
		set.add(new Employee("Jane", 11000));
		set.add(new Employee("Jae", 12000));
		set.add(new Employee("Jan", 13000));
		set.add(new Employee("ane", 10000));
		set.add(new Employee("ane", 10000));

		System.out.println(set);

		Iterator<Employee> it = set.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}

	}

	public static void main(String[] args){
		linkedHashSetEx();
	}

	
}