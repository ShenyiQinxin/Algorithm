import java.util.HashSet;
import java.util.Arrays;
/**
* First Array : [ONE, TWO, THREE, FOUR, FIVE, FOUR]
* Second Array : [THREE, FOUR, FIVE, SIX, SEVEN, FOUR]
* Common Elements : [FIVE, FOUR, THREE]
*
*/

class IntersectionArrays{
	
	static void intersectionArrays(String[] a1, String[] a2){
		//no dup, not sorted
		HashSet<String> set = new HashSet<>();
		for(int i=0; i<a1.length; i++){
			for(int j=0; j<a2.length; j++){
				if(a1[i].equals(a2[j])){
					set.add(a1[i]);
				}
			}
		}
		System.out.println(set);
	}
	
	static void intersectionHashSet(String[] a1, String[] a2){
		//public static <T> List<T> asList(T... a)
		//it takes an fixed sized array, returns a Collection List
		//a bridge between array and collection
		HashSet<String> set1 = new HashSet<>(Arrays.asList(a1));
		HashSet<String> set2 = new HashSet<>(Arrays.asList(a2));
		//the union of set1 and set2, kept in set1
		set1.retainAll(set2);
		System.out.println(set1);
		
	}
	
	public static void main(String[] args){
		String[] a1 = {"ONE", "TWO", "THREE", "FOUR", "FIVE", "FOUR"};
		String[] a2 = {"THREE", "FOUR", "FIVE", "SIX", "SEVEN", "FOUR"};
		intersectionArrays(a1, a2);
		intersectionHashSet(a1,a2);
	}
}