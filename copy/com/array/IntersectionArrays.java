import java.util.HashSet;
import java.util.Arrays;

class IntersectionArrays{
	
	static void intersectionArrays(String[] a1, String[] a2){
		HashSet<String> set = new HashSet<>();
		for(int i=0; i< a1.length; i++){
			for(int j=0; j < a2.length; j++){
				if(a1[i]==a2[j]){
					set.add(a1[i]);
				}
			}
		}
		
		System.out.println(set);
	}
	
	static void intersectionHashSets(String[] a1, String[] a2){
		HashSet<String> set1 = new HashSet<>(Arrays.asList(a1));
		HashSet<String> set2 = new HashSet<>(Arrays.asList(a2));
		set1.retainAll(set2);
		System.out.println(set1);
	}
	
	public static void main(String[] args){
		String[] a1 = {"ONE", "TWO", "THREE", "FOUR", "FIVE", "FOUR"};
		String[] a2 = {"THREE", "FOUR", "FIVE", "SIX", "SEVEN", "FOUR"};
		intersectionArrays(a1, a2);
		intersectionHashSets(a1, a2);
	}
}