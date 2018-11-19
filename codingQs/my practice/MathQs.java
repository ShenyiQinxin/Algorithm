import java.util.*;

public class MathQs2 {
	
	/* ugly numbers are positive numbers 
	whose prime factors only include 2, 3, 5 */
	public static boolean isUgly(int num) {
		/* the candidate shoulbe be divisible to
		 2, 3, 4, 5 */
		for(int i=2; i<=5 && num>0; i++) {
			while(num % i == 0) {
				num/=i;
			}
		}
		return num==1;
	}

	/*add the digits of num iteratively untill 
	there is only one digit left
	23456 -> ?
	23456%9=(2+3+4+5+6)%9
	all numbers are categorized in '<10', 
	'9divisible', '9not-divisible'
	*/
	public static int addDigits(int num) {
		if(num < 10) {
			return num;
		} else if(num % 9 == 0) {
			
			return 9;
		} else {
			return num%9;
		}
	}

	/* 3^n 
	i.e. 1, 3, 9, 27 
	negative number is not
	*/
	public static boolean isPowerOfThree(int n) {
		if(n < 0) {
			return false;
		}
		while(n%3==0) {
			n /= 3;
		}
		return n==1;
	}

	/* prime: 2, 3, 5, 7, 11 etc
	>=2 and not divisible */
	public static boolean checkPrimeNumber(int num) {
		if(num <= 1) {
			return false;
		}
		//4, ...
		for(int a=2; a<=Math.sqrt(num); a++) {
			if(num % a == 0) {
				return false;
			}
		}
		//2, 3
		return true;
	}

	/* Count the number of prime numbers 
	less than a non-negative number, n. 
	check from 2 to n,
	if i is a prime, count ++;
	*/
	public static int countPrimes(int n) {
		int count = 0;
		for(int i=2; i<=n; i++) {
			if(checkPrimeNumber(i)) {
				count++;
			}
		}
		return count;
	}

	/* happy number is defined as 
	Input: 19
	Output: true
	Explanation: 
	1^2 + 9^2 = 8^2
	82 + 22 = 68
	62 + 82 = 100
	12 + 02 + 02 = 1

	when it never ends as 1, then it is not a happy number
	*/
	public static boolean isHappy(int n) {
		//make sure the calculation does not meet the same result again
		Set<Integer> set = new HashSet<>();
		set.add(n);
		//while n is not 1, keep calculating
		while(n != 1) {
			int result = 0;
			while(n != 0) {
				result += Math.pow(n%10, 2);
				n /= 10;
			}
			if(set.add(result)) {
				n = result;
			} else {
				return false;
			}
		}
		return true;
	}

	//reverse a number (-/+)
	//1234 123 4
	public static int reverse(int x) {
		int rev = 0;
    	while(x != 0) {
    		int pop = x%10;
    		x /= 10;
    		if(rev > Integer.MAX_VALUE/10 || (rev== Integer.MAX_VALUE/10 && pop>7)) return 0;
    		if(rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE/10 && pop<-8)) return 0;
    		rev = rev*10+pop;
    	}
    	return rev;
	}

	public static boolean isPalindrome(int x) {
		//negative num is not
		//00900 is not
		if(x<0 || (x%10==0 && x!=0)) {
			return false;
		}
		int rev = 0;
		while(x > rev) {
			rev = rev*10+x%10;
			x/=10;
		}
		// x <= rev
		return x==rev || x==rev/10;
	}

	/* Input: 3
	Output: 0
	Explanation: 3! = 6, no trailing zero.
	Example 2:

	Input: 5
	Output: 1
	Explanation: 5! = 120, one trailing zero.
	*/
	public static int trailingZeroes(int n) {
		return n<5 ? 0 : n/5 + trailingZeroes(n/5);
	}

	public static List<String> fizzBuzz(int n) {
		List<String> array = new ArrayList<>();
		for(int i=1; i<=n; i++) {
			if(i%3 ==0 && i%5==0) {
				array.add("FizzBuzz");
			} else if(i%3==0) {
				array.add("Fizz");
			} else if (i%5==0) {
				array.add("Buzz");
			} else {
				array.add(String.valueOf(i));
			}
		}
		return array;
	}

	/*the person who removes the last stone will win, where he must remove
	1-3 stones each time,
	so when there are 4* stones, the person who acts first would never win*/
	public static boolean canWinWin(int n) {
		return n%4 != 0;
	}

	/* find out which number is missing among 0 - n*/
	public static int missingNumber(int[] nums) {
		int total = nums.length*(nums.length+1)/2;
		int actual = 0;
		for(int num : nums) {
			actual += num;
		}
		return total - actual;
	}


	public static void main(String[] args) {
		//System.out.println(isUgly(-9));
		//System.out.println(addDigits(91));
		//System.out.println(isPowerOfThree(-1));
		//System.out.println(checkPrimeNumber(5));
		//System.out.println(countPrimes(7));
		//System.out.println(isHappy(19));
		//System.out.println(reverse(-123));
		//System.out.println(isPalindrome(12324));
		//System.out.println(trailingZeroes(6));
		//System.out.println(fizzBuzz(14));
		//System.out.println(canWinWin(4));
		int[] nums = new int[]{0,1, 2, 3, 5};
		System.out.println(missingNumber(nums));
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
	}
}