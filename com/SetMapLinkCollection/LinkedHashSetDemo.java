import java.util.Iterator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
* ordered HashSet, insertion order, doubly linked list
* 
* a list of Student, stand in order of arrival, each one is unique
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

	public int hashCode(){
		return rollNo;
	}

	public boolean equals(Object obj){
		Student student = (Student) obj;
		return rollNo == student.rollNo;
	}

	public String toString(){
		return name+rollNo+department;
	}
}

public class LinkedHashSetDemo{

	public static void main(String[] args){
		Set<Student> linkedHashSet = new LinkedHashSet<>();
		linkedHashSet.add(new Student("Jack", 020,"ECE"));
		linkedHashSet.add(new Student("Peter", 031,"IT"));
		linkedHashSet.add(new Student("Ramesh", 021,"CS"));
		//dups
		linkedHashSet.add(new Student("Jack", 021,"ECE"));
		linkedHashSet.add(new Student("Peter", 031,"IT"));
		linkedHashSet.add(new Student("Ramesh", 021,"CS"));
		//
		Iterator<Student> it = linkedHashSet.iterator();
		while(it.hasNext()){
			Student student = (Student)it.next();
			System.out.println(student);
		}
	}
}