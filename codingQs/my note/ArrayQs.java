public class ArrayQs {

}
/*
167. Two Sum II - Input array is sorted

Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.

Note:

Your returned answers (both index1 and index2) are not zero-based.
You may assume that each input would have exactly one solution and you may not use the same element twice.
Example:

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.

**********My thoughts

**********Better solution

**********Takeaways
*/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        while(l < r) {
            int sum = nums[l] + nums[r];
            if(sum == target){
                return new int[]{l+1, r+1};//index stars from 1, 2, ...
            } else if(sum > target) {
                r--;
            } else {
                l++;
            }
        }
        throw new RuntimeException();
    }
}
/*
66. Plus One

Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:

Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Example 2:

Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
*/
class Solution {
    public int[] plusOne(int[] digits) {
    	int len = digits.length;
    	for(int i=digits.length-1; i>=0; i--) {
    		if(digits[i] <9){
    			digits[i]++;
    			return digits;
    		}
    		digits[i] =0;//digits[i] was 9
    	}
    	int[] res = new int[len+1];//all 9
    	res[0] = 1;
    	return res;
    }
}


/*
88. Merge Sorted Array

Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
Example:

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]

*/
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
    	int merged = m+n-1;
    	int first = m-1;
    	int second = n-1;
    	while(merged >= 0) {
    		
    		if(nums1[first] > nums2[second]) {
    			nums1[merged--] = nums1[first--];
    		} else {
    			nums1[merged--] = nums2[second--];
    		}
    		//nums1 runs out
    		if(first < 0) {
    			nums[merged--] = nums2[second--];
    			continue;
    		}
            //nums2 runs out
    		if(second <0){
    			break;
    		}
    	}
    }
}
/*
70. Climbing Stairs

You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer.

Example 1:

Input: 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
*/
class Solution {
    public int climbStairs(int n) {
    	if(n==1) return 1;
    	int[] ways = new int[n+1];
    	ways[1] = 1;
    	ways[2] = 2;
    	for(int i=3; i<=n; i++){
    		ways[i] = ways[i-1] + ways[i-2];
    	}
    	return ways[n];
    }
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
class Solution {
	public int fib(int n) {
		if(n ==0 || n==1) {
			return n;
		}
		int[] nums = new int[n+2];
		nums[0] = 0;
		nums[1] = 1;
		for (int i=2; i<=n; i++) {
			nums[i] = nums[i-1] + nums[i-2];
		}
		return nums[n];
	}

	public int fibRecursive(int n){
		if(n<=1) return n;
		return fibRecursive(n-1)+fibRecursive(n-2);
	}
}

/*
27. Remove Element

Given an array nums and a value val, remove all instances of that value in-place and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.

Example 1:

Given nums = [3,2,2,3], val = 3,

Your function should return length = 2, with the first two elements of nums being 2.

It doesn't matter what you leave beyond the returned length.
Example 2:

Given nums = [0,1,2,2,3,0,4,2], val = 2,

Your function should return length = 5, with the first five elements of nums containing 0, 1, 3, 0, and 4.

Note that the order of those five elements can be arbitrary.
*/
class Solution {
    public int removeElement(int[] nums, int val) {
    	int j=0;
    	for (int i=0; i<nums.length; i++) {
    		if(nums[i] != val) {
    			nums[j] =nums[i];//nums[i] is kept and move to nums[j], where j is the new array index
    			j++;//j = 0, 1, 2...
    		}
    	}
    	return j;
    }
}
/*
26. Remove Duplicates from Sorted Array

Given a sorted array nums, remove the duplicates in-place such that each element appear only once 
and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place 
with O(1) extra memory.

Example 1:

Given nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.

It doesn't matter what you leave beyond the returned length.
Example 2:

Given nums = [0,0,1,1,1,2,2,3,3,4],

Your function should return length = 5, with the first five elements of nums being modified to 
0, 1, 2, 3, and 4 respectively.

*/
class Solution {
    public int removeDuplicates(int[] nums) {
    	if(nums.length ==0) return 0;
    	int last = 0;
    	for(int curr = 1; curr<nums.length; i++){
    		if(nums[last] != nums[curr]) {
    			//update/move forward the last num
    			last++;
    			nums[last] =nums[curr];
    		}
    	}
    	return last+1;
    }
}

/*
283. Move Zeroes

Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations.
*/
class Solution {
    public void moveZeroes(int[] nums) {
    	int lastNoneZeroIndex = 0;
    	for (int i=0; i<nums.length; i++) {
    		if(nums[i] !=0) {
    			nums[lastNoneZeroIndex++] = nums[i];
    		}
    	}
    	for(int i= lastNoneZeroIndex; i<nums.length; i++) {
    		nums[i]=0;
    	}
    }
}


/*
561. Array Partition I

Given an array of 2n integers, your task is to group these integers into n pairs of integer, 
say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n 
as large as possible.

Example 1:
Input: [1,4,3,2]

Output: 4
Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
Note:
n is a positive integer, which is in the range of [1, 10000].
All the integers in the array will be in the range of [-10000, 10000].
*/
class Solution {
    public int arrayPairSum(int[] nums) {
    	Arrays.sort(nums);
    	int sum = 0;
    	for (int i=0; i<nums.length; i+=2) {
    		sum +=nums[i];
    	}
    	return sum;
    }
}


/*
463. Island Perimeter

You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water. 
Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, 
and there is exactly one island (i.e., one or more connected land cells). The island doesn't have "lakes" 
(water inside that isn't connected to the water around the island). One cell is a square with side length 1. 
The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

Example:

[[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]

Answer: 16
Explanation: The perimeter is the 16 yellow stripes in the image below:
**********My thoughts

**********Better solution

**********Takeaways
*/
class Solution {
    public int islandPerimeter(int[][] grid) {
        int islands =0, neighbours = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j]==1){
                    islands++;
                    //down neighbours
                    if(i<grid.length-1 && grid[i+1][j]==1) neighbours++;
                    //right neighbours
                    if(j<grid[i].length-1 && grid[i][j+1]==1) neighbours++;
                }
            }
        }
        //each island 4, each neighbour cancel 2
            return islands * 4 - neighbours * 2;
        
    }
}

/*
189. Rotate Array

Given an array, rotate the array to the right by k steps, where k is non-negative.

Example 1:

Input: [1,2,3,4,5,6,7] and k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: [-1,-100,3,99] and k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
Note:

Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
Could you do it in-place with O(1) extra space?
*****************Better solution
reverse the whole array O(n) [7,6,5,4,3,2,1]
reverse the left part 0 ~ k – 1 O(k) [5,6,7,4,3,2,1]
reverse the right part k ~ n – 1 O(n-k) [5,6,7,1,2,3,4]
****************Takeaway
If k >= n, rotating k times has the same effect as rotating k % n times.
*/
public class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        //If k >= n, rotating k times has the same effect as rotating k % n times.
        k = k% n;
        for (int start =0; count<n; start++) {
            int curr = start;
            int prevNum = nums[start];
            do{
                int next = (curr+k)%n;//jump the next k index
                int temp = nums[next];
                nums[next] = prevNum;
                prevNum = temp;
                curr = next;
                count++;
            } while (start != curr);
        }
        
    }
}
//method 2
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
      
        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
    }
    
    private void reverse(int[] nums, int l, int r){
        while(l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
}
