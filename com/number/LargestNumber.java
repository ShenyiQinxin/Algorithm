

class LargestNumber{

	static void largestNumber(int num, int digit){
		char c = Integer.toString(digit).charAt(0);

		for(int i=num; i>0; --i){
			if(Integer.toString(i).indexOf(c)==-1){
				System.out.println(i+" "+c);
				break;
			}
		}
	}

	public static void main(String[] args){
		largestNumber(123,2);
	}
	
}