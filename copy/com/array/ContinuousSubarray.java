

class ContinuousSubarray{
	
	static void continuousSubarray(int[] arr, int num){
		int sum = arr[0];
		int start = 0;
		if(sum == num){
			System.out.println(sum);
		}
		for(int i=1; i<arr.length; i++){
			sum += arr[i];
			while(sum>num && start <= i-1){
				sum -= arr[start];
				start++;
			}
			if(sum == num){
				for(int j = start; j <= i; j++){
					System.out.print(arr[j]+" ");
				}
				System.out.println();
			}
		}
	}
	//
	static void continuousSubarrayForLoop(int[] arr, int num){
		int sum = 0;
		for(int i=0; i<arr.length; i++){
			sum = arr[i];
			if(sum == num){
				System.out.println(sum);
			}
			for(int j=i+1; j<arr.length; j++){
				sum += arr[j];
				if(sum == num){
					for(int k=i; k<=j; k++){
						System.out.print(arr[k]+" ");
					}
					System.out.println();
				} else if (sum < num){
					continue;
				} else if (sum > num){
					break;
				}
			}
		}
	}
	public static void main(String[] args){
		int[] arr = {26, 15, 12, 8, 6, 32,12, 8, 6};
		int num = 26;
		continuousSubarray(arr, num);
		continuousSubarrayForLoop(arr, num);
	}
}