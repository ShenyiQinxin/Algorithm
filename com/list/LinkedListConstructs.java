import java.util.LinkedList;
import java.util.Iterator;
import java.util.ArrayList;

class LinkedListConstructs{

	static LinkedList<String> linkedListConstructs(LinkedList<String> list){
		String s = "one";
		//add to the end 
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		list.add("five");
		//add to the end
		list.offer("10");
		list.offer("20");
		
		if(list.contains(s)){
			System.out.println(list.indexOf(s));
		}
		Iterator<String> it = list.descendingIterator();
		while(it.hasNext()){
			System.out.print(it.next()+" ");
		}
		System.out.println("The size of the list: "+list.size());
		
		return list;
	
	}
	static void linkedListMerge(LinkedList<String> list){
		ArrayList<String> al=new ArrayList<>();
		al.add("I");
		al.add("II");
		System.out.println(list.addAll(al));
		System.out.println(list);
		System.out.println(list.addAll(2,al));
		System.out.println(list);
		//"I" is at index 2 : set to "super"
		System.out.println(list.set(2, "super")+" : "+list.get(2)+">> The list: "+list);
		System.out.println("The clone of the list: "+list.clone());

	}
	static void linkedListQueue(LinkedList<String> list){
		//add at the tail
		list.offerFirst("zeroOffer");
		list.addFirst("zeroAdd");
		
		list.offerLast("10Offer");
		list.addLast("20Add");
		list.offerLast("10Offer");
		list.addLast("20Add");
		System.out.println(list);

		//remove from the head
		System.out.println("Remove element from the head by poll: "+list.poll());
		System.out.println("Remove element from the head by pollFirst: "+list.pollFirst());
		System.out.println("Remove element from the head by remove: "+list.remove());
		System.out.println("Remove element from the head by removeFirst: "+list.removeFirst());
		//get / remove from a specific position
		System.out.println(list.get(2));
		System.out.println(list.remove(2));
		//get/non-removal an element from the head
		System.out.println(list.element());
		System.out.println(list.getFirst());
		System.out.println(list.peek());
		System.out.println(list.peekFirst());
		//get/non-removal an element from the tail
		System.out.println(list.peekLast());
		System.out.println(list.getLast());
		System.out.println(list.lastIndexOf("II"));		
		System.out.println(list);
		System.out.println(list.removeFirstOccurrence("10Offer"));
		System.out.println(list.removeLastOccurrence("20Add"));
		System.out.println(list);
		list.clear();
		System.out.println(list);
	}

	static void linkedListStack(LinkedList<String> list){
		list.push("11");
		list.push("22");
		list.push("33");
		list.push("44");
		System.out.println(list);
		System.out.println(list.pop());
		System.out.println(list.pop());
		System.out.println(list);
	}

	public static void main(String[] args){
		LinkedList<String> list = new LinkedList<>();
		LinkedList<String> listInit = linkedListConstructs(list);
		System.out.println("=================");
		//linkedListMerge(listInit);
		linkedListQueue(listInit);
		//linkedListStack(listInit);

	}
}