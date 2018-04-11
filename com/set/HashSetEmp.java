
import java.util.HashSet;
import java.util.Iterator;
/**
* no dup no order
*/
class HashSetEmp{
		static void hashSetEmp(){
			HashSet<Employee> set = new HashSet<>();
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
			hashSetEmp();
		}

}