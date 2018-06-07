

class BinaryOrNot{

	static void binaryOrNot(int num){
		boolean isBi = true;
		while(num != 0){
			int temp = num%10;
			if(temp>1){
				isBi = false;
				break;
			} else {
				num /=10;
			}
		}
		if(isBi){
			System.out.println("Is a binary");
		} else {
			System.out.println("Is not a binary");
		}

	}
	public static void main(String[] args){
		binaryOrNot(101110);
		binaryOrNot(12345);
	}
	
}