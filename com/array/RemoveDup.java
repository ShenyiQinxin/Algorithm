import java.util.Arrays;



class RemoveDup{
	
	static void removeDup(int[] arr){
		System.out.println(Arrays.toString(arr));
		int arrUniqueLength = arr.length;
		for(int i=0; i<arrUniqueLength; i++){
			for(int j=i+1; j<arrUniqueLength; j++){
				if(arr[i] == arr[j]){
					arr[j] = arr[arrUniqueLength-1];
					arrUniqueLength--;
					//to re-compare arr[i] and arr[j]
					j--;
				}
			}
		}
		//
		int[] arrNoDup = Arrays.copyOf(arr,arrUniqueLength);
		System.out.println(Arrays.toString(arrNoDup));
	}
	
	public static void main(String[] args){
		removeDup(new int[]{4, 3, 2, 4, 9, 2});
	}
}