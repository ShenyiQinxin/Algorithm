import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;
import java.util.Comparator;

class Student{
	private long id;
	private String name;

	public Student(long id, String name){
		this.id = id;
		this.name = name;
	}

	public String toString(){
		return id+name;
	}

	public long getId(){
		return id;
	}

	public String getname(){
		return name;
	}
}

class StudentComparator implements Comparator<Student>{
	//int compare(T o1,T o2)
	public int compare(Student s1, Student s2){
		return (int)(s1.getId() - s2.getId());
	}
}

public class TreeSetTest{

	public static void compareTreeSet(){
		StudentComparator studentComparator = new StudentComparator();
		Set<Student> students = new TreeSet<Student>(studentComparator);
		students.add(new Student(345l, "Edith"));
		students.add(new Student(123l, "Lulu"));
		students.add(new Student(234l, "Mary"));
		
		//
				students.add(new Student(123l, "Lulu"));
		students.add(new Student(234l, "Mary"));
		students.add(new Student(345l, "Edith"));

		Iterator<Student> it = students.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}

	public static void main(String[] args){
		compareTreeSet();
	}
}