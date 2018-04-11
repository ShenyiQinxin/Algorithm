import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
class RemoveDupArrayList{

	static void removeDupArrayList1(){
		ArrayList<String> list = new ArrayList<>();
		list.add("JAVA");
		list.add("J2EE");
		list.add("JSP");
		list.add("SERVLETS");
		list.add("JAVA");
		list.add("J2EE");
		list.add("JSP");
		list.add("SERVLETS");
		System.out.println(list);
		//HashSet<String> set = new HashSet<>(list);
		LinkedHashSet<String> set = new LinkedHashSet<>(list);
		System.out.println(set);
		ArrayList<String> listNoDup = new ArrayList<>(set);
		System.out.println(listNoDup);

	}

	

	public static void main(String[] args){
		removeDupArrayList1();
	}
	
}