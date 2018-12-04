import java.util.*;

public class ArrayQs {

	/*
	Input: 1
	Output: 1 
	Explanation: Only one way 
	1 step

	Input: 2
	Output: 2
	Explanation: There are two ways to climb to the top.
	1. 1 step + 1 step
	2. 2 steps

	Input: 3
	Output: 3
	Explanation: There are three ways to climb to the top.
	1. 1 step + 1 step + 1 step
	2. 1 step + 2 steps
	3. 2 steps + 1 step 
	ways[3]=ways[1]+ways[1];
	
	when adding one step, the ways to achieve it is adding 1 step on top of each way from before.
	*/
	public static int climbStairs(int n) {
		if(n == 1) {
			return 1;
		}
		int[] ways = new int[n+1];
		ways[1] = 1;
		ways[2] = 2;
		for(int i=3; i<=n; i++) {
			ways[i] = ways[i-1]+ ways[i-2];
		}
		return ways[n];
	}

	/* 
	fib(0);  // => 0
	fib(1);  // => 1
	fib(2);  // => 1
	fib(3);  // => 2
	fib(4);  // => 3
	...
    fib(n) = fib(n - 1) + fib(n - 2);
	*/
	public static int fib(int n) {
		if(n == 0 || n==1) {
			return n;
		}
		int[] nums = new int[n+2];
		nums[0] = 0;
		nums[1] = 1;
		for(int i=2; i<=n; i++) {
			nums[i] = nums[i-1]+nums[i-2];
		}
		return nums[n];
	}

	public static int fibRecursive(int n) {
		if(n<=1) {
			return n;
		}
		return fibRecursive(n-1) + fibRecursive(n-2);
	}

	/* 
	remove all instances of that value in-place and return the new length.
	[1,2,3,4,4]  4
	*/
	public static int removeElement(int[] nums, int val) {
		if(nums.length == 0) return 0;
		int j=0;
		for(int i=0; i<nums.length; i++) {
			if(nums[i] !=val) {
				nums[j] = nums[i];
				j++; //j wont ++ , when found the to-removed one
			}
		}
		return j;
	}

	/* Given a sorted array nums, remove the duplicates in-place 
	such that each element appear only once 
	and return the new length */
	public static int removeDuplicates(int[] nums) {
		if(nums.length == 0) return 0;
		int j=0;
		for(int i=1; i<nums.length; i++) {
			if(nums[j] != nums[i]) {
				j++;
				nums[j] = nums[i];
			}
		}
		return j+1;
	}

	/* Input: [0,1,0,3,12]
	   Output: [1,3,12,0,0]
	*/
	public static int[] moveZeroes(int[] nums) {
		int j=0;
		for(int i=0; i<nums.length; i++) {
			if(nums[i] != 0) {
				nums[j] = nums[i];
				j++;
			}
		}
		for(int i=j; i<nums.length; i++) {
			nums[i]=0;
		}
		return nums;
	}

	/* Input: [1,2,3,4,5,6,7] and k = 3
	   Output: [5,6,7,1,2,3,4] */
	public static int[] rotate(int[] nums, int k) {
		int n = nums.length;
		k %= n;

		//[7654321]
		reverse(nums, 0, n-1);
		//[567 4321]
		reverse(nums, 0, k-1);
		//[567 1234]
		reverse(nums, k, n-1);
		return nums;
	}

	private static void reverse(int[] nums, int l, int r){
		while(l < r) {
			int temp = nums[l];
			nums[l] = nums[r];
			nums[r] = temp;
			l++;
			r--;
		}
	}

	/* 123+1 
		129+1 
	*/
	public static int[] plusOne(int[] digits) {
		int length = digits.length;
		for(int i=digits.length-1; i>=0; i--) {
			if(digits[i] < 9) {
				digits[i]++;
				return digits;//if there is no carry-over
			}
			//if digits[i]=9
			digits[i]=0;
		}
		//if there is a carry-over
		int[] carry = new int[length+1];
		carry[0] = 1;
		return carry;
	}

	/* 4 = min(1, 2) + min(3, 4) */
    public static int arrayPairSum(int[] nums) {
    	Arrays.sort(nums);
    	int sum = 0;
    	for(int i=0; i<nums.length; i+=2) {
    		sum += nums[i];
    	}
    	return sum;
    }

    /* 
	[[0,1,0,0],
	 [1,1,1,0],
	 [0,1,0,0],
	 [1,1,0,0]]

	 Answer: 16
Explanation: The perimeter is the 16 yellow stripes in the image
    */
    public int islandPerimeter(int[][] grid) {
    	int islands = 0, neighbours = 0;
    	for(int i=0; i<grid.length; i++) {
    		for(int j=0; j<grid[i].length; j++) {
    			if(grid[i][j] == 1) {
    				islands++;
    				if(i<grid.length-1 && grid[i+1][j] == 1) neighbours++;
    				if(j<grid[i].length-1 && grid[i][j+1] == 1) neighbours++;
    			}
    		}
    	}
    	return islands*4 - neighbours*2;
    }

    /* 
	Input:
	nums1 = [1,2,3,0,0,0], m = 3
	nums2 = [2,5,6],       n = 3

	Output: [1,2,2,3,5,6]
    */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
    	int merged = m+n-1;
        int first = m-1;
        int second = n-1;
        while(merged >=0){
            if(first < 0){
               nums1[merged--] = nums2[second--];
               continue;
            }
            if(second < 0){
                break;
            }
            if(nums1[first] > nums2[second]){
                nums1[merged--] =  nums1[first--];
            } else {
                nums1[merged--] = nums2[second--];
            }
            System.out.println(nums1[merged]);
        }
    }

    /* 1a4b67b8a */
	public static boolean isPalindrome(String s0) {
		String s = s0.toLowerCase();
		if(s.length() ==0 || s == null) {
			return true;
		}
		int l=0, r=s0.length()-1;
		while(l<r) {
			if(!isvalid(s.charAt(l))) {
				l++;
				continue;
			}
			if(!isvalid(s.charAt(r))) {
				r--;
				continue;
			}
			if(s.charAt(l) != s.charAt(r)) {
				return false;
			}
			l++;
			r--;
		}
		return true;
	}
	private static boolean isvalid(char c) {
        if(c>='0'&&c<='9' || c>='a'&&c<='z' || c>='A' && c<='Z') {
            return true;
        }
        return false;
    }


	public static void main(String[] args) {
		int[] nums = new int[]{1, 2, 3, 4,5,6,7};
		int[] nums1 = new int[]{10};
		int[] nums2 = new int[]{4,5,60};
		//System.out.println(climbStairs(climbStairs(4)));
		//System.out.println(fib(4));
		//System.out.println(fibRecursive(4));
		//System.out.println(removeElement(nums, 4));
		//System.out.println(removeDuplicates(nums));
		// for(int i: moveZeroes(nums)) {
		// 	System.out.print(i+" ");
		// }
		for(int i: rotate(nums, 3)) {
			//System.out.print(i+" ");
		}
		//System.out.println(plusOne(nums));
		//System.out.println(arrayPairSum(nums));		
		//System.out.println(isPalindrome("1a4b67b8a"));
		System.out.println();

		
	}
}