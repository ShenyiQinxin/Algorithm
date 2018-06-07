
import java.util.Arrays;
/**
*  find all pairs of elements in this array 
* such that whose sum must be equal to a given number.
*/

class PairsOfElementsInArray{
	
	static void pairsOfElementsInArray(int[] arr, int num){
		Arrays.sort(arr);
		int i=0;
		int j=arr.length-1;
		while(i<j){
			if(arr[i]+arr[j]==num){
				System.out.println(arr[i]+" + "+arr[j]+" = "+num);
				i++;
				j--;	
			} else if(arr[i]+arr[j]<num){
				i++;
			} else if (arr[i]+arr[j]>num){
				j--;
			}
		}
	}

	public static void main(String[] args){
		pairsOfElementsInArray(new int[] {4, 6, 5, -10, 8, 5, 20}, 10);
	}
}