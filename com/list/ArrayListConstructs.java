
import java.util.ArrayList;
class ArrayListConstructs{

	static void arrayListConstructs(){
		ArrayList<String> al1 = new ArrayList<>();
		ArrayList<String> al2 = new ArrayList<>(18);
		ArrayList<String> al3 = new ArrayList<>(al2);
		al2.ensureCapacity(20);
		al2.add("one");
		al2.add("two");
		al2.add("three");
		al2.add("four");
		al2.add("one");
		al2.add(2, "two");
		al2.trimToSize();
		System.out.println(al2.size());
		System.out.println(al2.isEmpty());
		System.out.println(al2.contains(111));
		System.out.println(al2.indexOf("one")+" "+al2.lastIndexOf("one"));
		System.out.println("arraylist maintain insertion sequence: "+al2.get(3));
		System.out.println("update an element at a position: "+al2.set(3, "fourNew")+" --> "+al2.get(3));
		System.out.println(al2.remove(3));
		System.out.println(al2.remove("one"));
		Object[] array = al2.toArray();
		for(Object s: array){
			System.out.print(s+" ");
		}
		System.out.println();
		System.out.println(al2.subList(1,3));
		al3.add("1");
		al2.addAll(al3);
		al2.addAll(0,al3);
		System.out.println("Joining al2 and al3: "+al2);
		al2.clear();
		System.out.println(al2);
		
	}

	public static void main(String[] args){
		arrayListConstructs();
	}
}