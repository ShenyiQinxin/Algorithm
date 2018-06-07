import java.util.Arrays;
import java.util.HashSet;

class UnionIntersection{
	static void union(Integer[] ... arrs){
		HashSet<Integer> set = new HashSet<>();
		for(Integer[] a: arrs){
			for(Integer i: a){
				set.add(i);
			}
		}
		System.out.println(set);
	}
	
	static void intersection(Integer[] ... arrs){
		HashSet<Integer> set0 = new HashSet<>(
			Arrays.asList(arrs[0]));
		for(int i=1; i<arrs.length; i++){
			HashSet<Integer> setI = new HashSet<>(
				Arrays.asList(arrs[i]));
			set0.retainAll(setI);
		}
		System.out.println(set0);
	}
	
	public static void main(String[] args){
		Integer[] arr1 = {2, 3, 4, 7, 1};
		Integer[] arr2 = {4, 1, 3, 5};
		Integer[] arr3 = {8, 4, 6, 2, 1};
		Integer[] arr4 = {7, 9, 4, 1};
		union(arr1, arr2, arr3, arr4);
		intersection(arr1, arr2, arr3, arr4);
	}
}