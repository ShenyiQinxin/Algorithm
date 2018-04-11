
public class Employee{
	String name;
	int salary;

	public Employee(String name, int salary){
		this.name = name;
		this.salary = salary;
	}

	public String toString(){
		return name + " : " + salary;
	}

	public boolean equals(Object o){
		Employee emp = (Employee)o;
		return this.name == emp.name;
	}

	public int hashCode(){
		return salary%1000;
	}
}