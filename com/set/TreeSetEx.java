import java.util.TreeSet;
import java.util.Iterator;

/**
* If you don’t want any order of elements, then you can use HashSet. 
* If you want insertion order of elements to be maintained, then use LinkedHashSet. 
* If you want elements to be ordered according to some Comparator, then use TreeSet. 
* The common thing of these three implementations is that they don’t allow duplicate elements.
*/

class TreeSetEx{

	static void treeSetEx(){
		TreeSet<Employee> set = new TreeSet<>(new EmpComparator());
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
			treeSetEx();
		}
}