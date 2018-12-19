import java.util.*;

public class ArrayQs2 {

	//input 1 output 1
	//input 2 output 1+1, 2
	//input 3 output 1+1+1, 2+1, 1+2
	//input 4 output 1+1+1+1, 2+2, 1+3, 2+1+1, 1+2+1
	public static int climbStairs(int n) {
		if(n == 1) {
			return 1;
		}
		int[] ways = new int[n+1];
		ways[1] = 1;
		ways[2] = 2;
		for(int i=3; i<=n; i++) {
			ways[i] = ways[i-1] +ways[i-2];
		}
		return ways[n];
	}

	// fib(0) => 0
	// fib(1) => 1
	// fib(2) => 1
	// fib(3) => 2
	// fib(4) => 3
	// fib(n) = fib(n-1) +fib(n-2)
	public static int fib(int n) {
		if(n == 0 || n == 1) {
			return n;
		}
		int[] nums = new int[n+2];
		nums[0] = 0;
		nums[1] = 1;
		for(int i=2; i<=n; i++) {
			nums[i] = nums[i-1] + nums[i-2];
		}
		return nums[n];
	}

	public static int fibRecursive(int n) {
		if(n == 0 || n == 1) {
			return n;
		}
		return fibRecursive(n-1) + fibRecursive(n-2);
	}

	//[Given nums = [0,1,2,2,3,0,4,2], val = 2
	public static int removeElement(int[] nums, int val) {
		if(nums.length == 0) return 0;
		int j=0;
		for(int i=0; i<nums.length; i++) {
			if(nums[i] != val) {
				nums[j] = nums[i];
				j++;
			}
		}
		return j;
	}

	public static int removeDuplicates(int[] nums) {
		if(nums.length == 0) return 0;
		return j+1;
	}

	public static int[] moveZeroes(int[] nums) {
		
		return nums;
	}

	public static int[] rotate(int[] nums, int k) {
		
	}

	private static void reverse(int[] nums, int l, int r){
		
	}
	public static int[] plusOne(int[] digits) {
		
	}
	public static int arrayPairSum(int[] nums) {
		
	}
	public int islandPerimeter(int[][] grid) {
		
	}
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		
	}
	public static boolean isPalindrome(String s0) {
		
	}
	private static boolean isvalid(char c) {
		if(c>='0'&&c<='9' || c>='a'&&c<='z' || c>='A' && c<='Z') {
            return true;
        }
        return false;
	}

	public static void main(String[] args) {

	}
}
