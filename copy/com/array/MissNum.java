

class MissNum{
	
	static void missNum(int[] arr, int num){
		int sum = num*(num+1)/2;
		int sumElements = 0;
		for(int i=0; i<arr.length; i++){
			sumElements += arr[i];
		}
		int miss = sum - sumElements;
		System.out.println(miss);
	}
	
	public static void main(String[] args){
		missNum(new int[]{1, 4, 5, 3, 2, 8, 6}, 8);
	}
}