import java.util.Arrays;

/**
*
* [1, 4, 5, 3, 2, 8, 6]
* 7
*/

class MissNum{
	
	static void missNum(int[] arr, int num){
		int sumOfNumbers = num*(num+1)/2;
		int sumOfElements = 0;
		for(int i=0; i< arr.length; i++){
			sumOfElements += arr[i];
		}
		int miss = sumOfNumbers - sumOfElements;
		System.out.println(Arrays.toString(arr));
		System.out.println(miss);
		
	}
	public static void main(String[] args){
		missNum(new int[]{1, 4, 5, 3, 2, 8, 6}, 8);
	}
}