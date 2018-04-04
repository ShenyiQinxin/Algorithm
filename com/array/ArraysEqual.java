import java.util.Arrays;
/**
* [21, 57, 11, 37, 24]
* [21, 57, 11, 37, 24]
* 
* [1, 57, 11, 37, 24]
*/

class ArraysEqual{
	
	static boolean arraysEqualForLoop(int[] a1, int[] a2){
		if(a1.length != a2.length){
			return false;
		}
		
		for(int i=0; i<a1.length; i++){
			if(a1[i] != a2[i]){
				return false;
			}
		}
		
		return true;
	}
	
	static boolean arraysEquals(int[] a1, int[] a2){
		boolean equalsOrNot = Arrays.equals(a1, a2);
		return equalsOrNot;
	}
	
	public static void main(String[] args){
		int[] a1 = {21, 57, 11, 37, 24};
		int[] a2 = {21, 57, 11, 37, 24};
		int[] a3 = {1, 57, 11, 37, 24};
		
		System.out.println(arraysEqualForLoop(a1, a3));
		System.out.println(arraysEquals(a1, a2));
		System.out.println(arraysEquals(a1, a3));
		
	}
}