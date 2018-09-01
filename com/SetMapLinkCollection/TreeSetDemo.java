import java.util.TreeSet;
import java.util.Comparator;
import java.util.Iterator;
/**
* if dont want any order of elements, use HashSet,
* If want insertion order of elements to be maintained, use LinkedHashSet
* If want to order elements using Comparator, then TreeSet
* in common, they have no dups
* there are 2 ways of comparing for TreeSet:
* use comparator, do not use hashcode and equals at all
* does not use comparator
*/
class Student{
	String name;
	int rollNo;
	String department;

	public Student(String name, int rollNo, String department){
        this.name = name;
        this.rollNo = rollNo;
        this.department = department;
    }

    public String toString(){
    	return name+rollNo+department;
    }
}

class StudentComparator implements Comparator<Student>{
	public int compare(Student s1, Student s2){
		if(s1.rollNo==s2.rollNo){
			return 0;
		} else {
			return s1.name.compareTo(s2.name);
		}

	}
}
public class TreeSetDemo{

	public static void main(String[] args){
/*	StudentComparator StudentComparator = new StudentComparator();
	TreeSet<Student> treeSet = new TreeSet<>(StudentComparator);
	treeSet.add(new Student("santosh",85,"IT" ));
	treeSet.add(new Student("cherry",5,"CS" ));
	treeSet.add(new Student("Parveen",80,"Consulting" ));
//dup
	treeSet.add(new Student("santosh",85,"IT" ));
	treeSet.add(new Student("cherry",5,"CS" ));
	treeSet.add(new Student("Parveen",80,"Consulting" ));

	Iterator<Student> it = treeSet.iterator();
	while(it.hasNext()){
		System.out.println(it.next());
	}*/

	TreeSet<Integer> treeSet = new TreeSet<>();
	treeSet.add(10);
	treeSet.add(9);
	treeSet.add(0);
	treeSet.add(10);
	treeSet.add(9);
	treeSet.add(0);
	Iterator<Integer> it = treeSet.iterator();
	while(it.hasNext()){
		System.out.println(it.next());
	}
}
}