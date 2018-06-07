import java.util.Arrays;

class RemoveDup{
	
	static void removeDup(int[] arr){
		int len = arr.length;
		for(int i=0; i<len; i++){
			for(int j=i+1; j<len;j++){
				if(arr[i]==arr[j]){
					arr[j] = arr[len-1];
					len--;
					//j-- then j++
					j--;
				}
			}
		}//
		int[] arrNoDup = Arrays.copyOf(arr, len);
		System.out.println(Arrays.toString(arrNoDup));
		
	}
	
	public static void main(String[] args){
		removeDup(new int[]{4, 3, 2, 4, 9, 2});
	}
}