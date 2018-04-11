
/**
*153 = 1^3 + 5^3 + 3^3 = 1 + 125 + 27 = 153
*/
class ArmstrongNumber{
	
	static void armstrongNumber(int num0){
		int len = String.valueOf(num0).length();
		int num = num0;
		int sum = 0;
		while(num != 0){
			int last = num %10;
			int toPower = 1;
			for(int i=0; i<len; i++){
				toPower = toPower*last;
			}
			sum = sum+toPower;
			num = num/10;
		}

		if(sum == num0){
			System.out.println(num0+" is an armstrong number");
		} else {
			System.out.println(num0+" is not an armstrong number");
		}

	}
	public static void main(String[] args){
		armstrongNumber(153);
	}

}