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
	*/
	public static int removeElement(int[] nums, int val) {
		int j=0;
		for(int i=0; i<nums.length; i++) {
			if(nums[i] !=val) {
				nums[j] = nums[i];
				j++; //j wont ++ , when found the to-removed one
			}
		}
		return j;
	}


	public static void main(String[] args) {
		System.out.println(climbStairs(climbStairs(4)));
		System.out.println(fib());
	}
}