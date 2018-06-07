import java.util.Arrays;

class SecondLarge{
	
	static void secondLarge(int[] num){
		int first, second;
		if(num[0] > num[1]){
			first = num[0];
			second = num[1];
		} else {
			first = num[1];
			second = num[0];
		}
		
		for(int i=2; i<num.length; i++){
			if(num[i] > first){
				second = first;
				first = num[i];
			} else if(num[i]<first && num[i]>second){
				second =num[i];
			}
		}
		System.out.println(Arrays.toString(num));
		System.out.println(second);
		
	}
	
	public static void main(String[] args){
		secondLarge(new int[]{47498, 14526, 74562, 42681, 75283, 45796});
	}
}