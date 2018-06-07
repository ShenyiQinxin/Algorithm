import java.util.Arrays;

class ReverseArray{
	
	static void reverseArray(int[] arr){
		
		int temp = 0;
		for(int i=0; i<arr.length/2; i++){
			temp = arr[i];
			arr[i] = arr[arr.length-1-i];
			arr[arr.length-1-i]= temp;
		}
		System.out.println(Arrays.toString(arr));
	}
	
	public static void main(String[] args){
		reverseArray(new int[]{4, 5, 8, 9, 10});
	}
}