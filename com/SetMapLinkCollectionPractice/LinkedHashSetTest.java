import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;



class Student{
	private long id;
	private String name;

	public Student(long id, String name){
		this.id = id;
		this.name = name;
	}

	public int hashCode(){
		return (int)id;
	}

	public boolean equals(Object obj){
		return this.id == ((Student) obj).id;
	}

	public String toString(){
		return id+name;
	}


}


public class LinkedHashSetTest{

	public static void compareLinkedHashSet(){
		Set<Student> s = new LinkedHashSet<>();
		s.add(new Student(123l, "Lulu"));
		s.add(new Student(234l, "Peety"));
		s.add(new Student(345l, "Denials"));
		//dup
		s.add(new Student(123l, "Lulu"));
		s.add(new Student(234l, "Peety"));
		s.add(new Student(345l, "Denials"));

		Iterator<Student> it = s.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}

	public static void main(String[] args){
		compareLinkedHashSet();
	}
}

