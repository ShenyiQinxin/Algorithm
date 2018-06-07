

class Palindrome{

	static int reverseNumber(int num){
		int reverse = 0;
		int remainder = 0;
		while(num != 0){
			remainder = num%10;
			reverse = (reverse*10)+remainder;
			num = num/10;
		}
		return reverse;
	}
	static boolean isPalindrome(int num){
		int reverse = reverseNumber(num);
		if(reverse == num){
			return true;
		} else {
			return false;
		}
	}

	static void palindrome(int num){
		
		if(isPalindrome(num)){
			System.out.println("Given Number is already a palindrome");
		} else {
			while(!isPalindrome(num)){ 
				int reverse = reverseNumber(num);
				int sum = num + reverse;
				System.out.println(num+" + "+reverse+" = "+sum);
				num = sum;
			}
		}
	}

	public static void main(String[] args){
		palindrome(7325);
	}
	
}