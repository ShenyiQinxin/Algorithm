import java.util.Arrays;

class FindLeaders{
	
	static void findLeaders(int[] arr){
		int len = arr.length;
		int max = arr[len-1];
		System.out.println(Arrays.toString(arr));
		System.out.println(arr[len-1]);
		for(int i=len-2; i>=0; i--){
			if(arr[i] > max){
				System.out.println(arr[i]);
				max = arr[i];
			}
		}
		
	}
	
	public static void main(String[] args){
		findLeaders(new int[]{12, 9, 7, 14, 8, 6, 3});
		
	}
}