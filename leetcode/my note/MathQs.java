public class MathQs{

}

/**
263. Ugly Number

Write a program to check whether a given number is an ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.

Example 1:

Input: 6
Output: true
Explanation: 6 = 2 × 3
Example 2:

Input: 8
Output: true
Explanation: 8 = 2 × 2 × 2
Example 3:

Input: 14
Output: false 
Explanation: 14 is not ugly since it includes another prime factor 7.
Note:

1 is typically treated as an ugly number.
Input is within the 32-bit signed integer range: [−231,  231 − 1].

**********My thought:
1 is an ugly number;

num / prime 

**********better solution:
for(int i=2; i< 6 && num>0; i++){}

**********TakeAway:

*/
class Solution {
    public boolean isUgly(int num) {
        //2, 3, 4, 5
        for(int i=2; i<6 && num>0; i++){
        	while(num%i == 0) {
        		num /= i;
        	}
        	
        }
        return num==1;
    }
}

/*
258. Add Digits

Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

Example:

Input: 38
Output: 2 
Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2. 
             Since 2 has only one digit, return it.
Follow up:
Could you do it without any loop/recursion in O(1) runtime?
**********My thoughts
 if(n==0) return 0;
 return (n%10) + sumDigits(n/10);
**********Better solution
any number that is divisible by 9, the sum of the digits in the number is also divisible by 9. 
Also, here we know that the result of the problem is an integer lying in the range [0,9] .
**********Takeaways
*/
public class Solution {

    public int addDigits(int num){
    	if(num<10) {
    		return num;
    	} else if(num%9 ==0) {
    		return 9;
    	} else {
    		return num%9;   
    	}   
    }
}

/*
326. Power of Three

Given an integer, write a function to determine if it is a power of three.

Example 1:

Input: 27
Output: true
Example 2:

Input: 0
Output: false
Example 3:

Input: 9
Output: true
Example 4:

Input: 45
Output: false
Follow up:
Could you do it without using any loop / recursion?
**********My thoughts

**********Better solution

**********Takeaways
*/
public class Solution {
    public boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }

        while(n%3==0){
        	n /= 3;
        }

        return n==1;
    }
}

/*
204. Count Primes

Count the number of prime numbers less than a non-negative number, n.

Example:

Input: 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7
**********My thoughts

**********Better solution

**********Takeaways
*/

class Solution {
    public int countPrimes(int n) {
    	if(n<=1) return 0;
    	//0 1 2 3 4...
    	boolean[] notPrime = new boolean[n];
    	notPrime[0] = true;
    	notPrime[1] = true;
    	//notPrime[2] = false;
    	//notPrime[3] = false;
    	for(int i=2; i*i<n; i++) {
    		if(!notPrime[i]) {
    			for(int j=2*i; j<n; j++) {
    				notPrime[j] = true;
    			}
    		}
    	}
    	int result = 0;
    	for(boolean noP: notPrime){
    		if(!noP){
    			result++;
    		}
    	}
    	return result;
    }
}
/*
268. Missing Number
DescriptionHintsSubmissionsDiscussSolution
Given an array containing n distinct numbers 
taken from 0, 1, 2, ..., n, find the one that is missing from the array.

Example 1:

Input: [3,0,1]
Output: 2
Example 2:

Input: [9,6,4,2,3,5,7,0,1]
Output: 8
Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
**********My thoughts

**********Better solution

**********Takeaways
*/
class Solution {
    public int missingNumber(int[] nums) {
        int expect = nums.length*(nums.length+1)/2;
        int actual = 0;
        for (int num : nums) {
        	actual +=num;
        }
        return expect-actual;
    }
}

/*
7. Reverse Integer
DescriptionHintsSubmissionsDiscussSolution
Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output: 321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21
Note:
Assume we are dealing with an environment which could only store integers 
within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, 
assume that your function returns 0 when the reversed integer overflows.
**********My thoughts

**********Better solution

**********Takeaways
*/
class Solution {
    public int reverse(int x) {
    	int rev = 0;
    	while(x != 0) {
    		int pop = x%10;
    		x /= 10;
    		if(rev > Integer.MAX_VALUE/10 || (rev== Integer.MAX_VALUE/10 && pop>7)) return 0;
    		if(rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE/10 && pop<-8)) return 0;
    		rev = rev*10+pop;
    	}
    }
}

/*
172. Factorial Trailing Zeroes

Given an integer n, return the number of trailing zeroes in n!.

Example 1:

Input: 3
Output: 0
Explanation: 3! = 6, no trailing zero.
Example 2:

Input: 5
Output: 1
Explanation: 5! = 120, one trailing zero.
Note: Your solution should be in logarithmic time complexity.
**********My thoughts
**********Better solution
for a given number n, we are looking how many numbers <=n have factor 5, 5×5, 5x5x5, …

1000/5 = 200

200/5 = 40

40/5 = 8

8/5 = 1

1/5 = 0

200 + 40 + 8 + 1 + 0 = 249
**********Takeaways
*/
class Solution {
    public int trailingZeroes(int n) {
    	return n<5 ? 0 : n/5 + trailingZeroes(n/5);
    	
    }
}
/*
292. Nim Game

You are playing the following Nim Game with your friend: There is a heap of stones on the table, each time one of you take turns to remove 1 to 3 stones. The one who removes the last stone will be the winner. You will take the first turn to remove the stones.

Both of you are very clever and have optimal strategies for the game. Write a function to determine whether you can win the game given the number of stones in the heap.

Example:

Input: 4
Output: false 
Explanation: If there are 4 stones in the heap, then you will never win the game;
             No matter 1, 2, or 3 stones you remove, the last stone will always be 
             removed by your friend.
**********My thoughts

**********Better solution
If there are 4 stones in the heap, then you will never win the game;
**********Takeaways
listen the hint
*/

class Solution {
    public boolean canWinNim(int n) {
        return n%4 !==0;
    }
}
/*
202. Happy Number

Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example: 

Input: 19
Output: true
Explanation: 
1^2 + 9^2 = 8^2
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1

**********My thoughts

**********Better solution

**********Takeaways
*/
class Solution {
    public boolean isHappy(int n) {
    	Set<Integer> set = new HashSet<>();
    	set.add(n);
    	while(n!=1) {
    		int result = 0;
    		while(n!=0){
	    		result += Math.pow(n%10,2);
	    		n/=10;
    		}
    		if(set.add(result)) {
    			n=result;
    		} else {
    			return false;
    		}
    	}
    	return true;
    }

}
/*
9. Palindrome Number
DescriptionHintsSubmissionsDiscussSolution
Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

Example 1:

Input: 121
Output: true
Example 2:

Input: -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
Follow up:

Coud you solve it without converting the integer to a string?
**********My thoughts

**********Better solution

**********Takeaways
*/
class Solution {
    public boolean isPalindrome(int x) {
    	if(x<0 || (x%10==0 && x!=0)) return false;
    	int reverted = 0;
    	while(x > reverted) {
    		reverted = reverted *10+ x%10;
    		x/=10;
    	}
    	//for 12321, we get x=12, reverted = 123
    	return x== reverted || x== reverted/10;
    }
}

/*
412. Fizz Buzz
DescriptionHintsSubmissionsDiscussSolution
Write a program that outputs the string representation of numbers from 1 to n.

But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.

Example:

n = 15,

Return:
[
    "1",
    "2",
    "Fizz",
    "4",
    "Buzz",
    "Fizz",
    "7",
    "8",
    "Fizz",
    "Buzz",
    "11",
    "Fizz",
    "13",
    "14",
    "FizzBuzz"
]
**********My thoughts

**********Better solution

**********Takeaways
*/
class Solution {
    public List<String> fizzBuzz(int n) {
        
        List<String> array = new ArrayList<>();
        for(int i=1; i<= n; i++){
            if(i%3==0 && i%5==0){
                array.add("FizzBuzz");
            } else if(i%3==0){
                array.add("Fizz");
            } else if(i%5==0){
                array.add("Buzz");
            } else {
                array.add(String.valueOf(i));
            }
        }
        return array;
    }
}