import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;

class Student{
	private String name;
	private long id;


	public Student(String name, long id){
		this.name = name;
		this.id = id;

	}

//hashcode is used to decide which bucket the objects is put into, 
	//unequal objects dont share the same hashCode
	//the size of the bucket could not be too small or large
	//Java implements it that when the size is beyond a thredshold, 
	//then elements are stored in a treeMap, it the size is within a thredshold then 
	//elements are stored in a linkedlist
	public int hashCode(){
		return (int)id;
	}
//when 2 objects are unequal, their hashCode could be the same
	public boolean equals(Object obj){
		Student s = (Student) obj;
		return this.id == s.id;
	}

	public String toString(){
		return name+id;
	}
}

public class HashSetTest{

	public static void main(String[] args){
		Set<Student> students = new HashSet<>();
		students.add(new Student("Lulu", 123l));
		students.add(new Student("Deny", 223l));
		students.add(new Student("Jason", 323l));
		//dup
		students.add(new Student("Lulu", 123l));
		students.add(new Student("Deny", 223l));
		students.add(new Student("Jason", 323l));

		Iterator<Student> it = students.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
}


