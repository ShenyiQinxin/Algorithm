import java.util.Arrays;
/**
*The leaders are the largest element among its righthand side
* 
*in [12, 9, 7, 14, 8, 6, 3] are :
*3
*6
*8
*14
*/
class FindLeaders{
	
	static void findLeaders(int[] arr){
		int arrLength = arr.length;
		int max = arr[arrLength-1];
		System.out.println(Arrays.toString(arr));
		//the last element is a leader
		System.out.println(arr[arrLength-1]);	
		//start from the 2nd largest index
		for(int i=arr.length-2; i>=0; i--){
			if(arr[i] > max) {
				System.out.println(arr[i]);
				max = arr[i];
			}
		}
		
	}
	public static void main(String[] args){
		findLeaders(new int[]{12, 9, 7, 14, 8, 6, 3});
	}
}