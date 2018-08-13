import java.util.HashSet;
import java.util.Iterator;
/**
* no dup, no order, add(), remove(), contains() O(n)
*/

class Student{
	private String name;
	private int rollNo;
	private String department;

	public Student(String name, int rollNo, String department){
        this.name = name;
        this.rollNo = rollNo;
        this.department = department;
    }

//for comparing Student objects
    //hashCode
    public int hashCode(){
    	return rollNo;
    }

    public boolean equals(Object obj){
    	Student student= (Student) obj;
    	return rollNo == student.rollNo;
    }

    public String toString(){
    	return name+rollNo+department;
    }
}

public class HashSetDemo{

	public static void main(String[] args){
		HashSet<Student> studentHashSet = new HashSet<Student>();
		studentHashSet.add(new Student("Avinash", 121, "ECE"));
		studentHashSet.add(new Student("Lulu", 134, "EEE"));
		studentHashSet.add(new Student("Suresh", 145, "IT"));
		//dups will not be added in
		studentHashSet.add(new Student("Avinash", 121, "ECE"));
		studentHashSet.add(new Student("Lulu", 134, "EEE"));
		studentHashSet.add(new Student("Suresh", 145, "IT"));

		Iterator<Student> it = studentHashSet.iterator();
		while(it.hasNext()){
			Student student = (Student) it.next();
			System.out.println(student);
		}
		//
		
	}
}