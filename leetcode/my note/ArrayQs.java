public class ArrayQs {

}

/*
66. Plus One
DescriptionHintsSubmissionsDiscussSolution
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
**********My thoughts

**********Better solution

**********Takeaways
*/
class Solution {
    public int[] plusOne(int[] digits) {
    	int len = digits.length;
    	for(int i=digits.length-1; i>=0; i--) {
    		if(digits[i] <9){
    			digits[i]++;
    			return digits;
    		}
    		digits[i] =0;
    	}
    	int[] res = new int[len+1];
    	res[0] = 1;
    	return res;
    }
}
/*
53. Maximum Subarray
DescriptionHintsSubmissionsDiscussSolution
Given an integer array nums, find the contiguous subarray 
(containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide 
and conquer approach, which is more subtle.
**********My thoughts

**********Better solution

**********Takeaways
*/
class Solution {
    public int maxSubArray(int[] nums) {
    	int maxSum = nums[0];
    	int currSum = nums[0];
    	for(int i=1; i<nums.length; i++){
    		currSum = currSum<=0 ? nums[i] : nums[i]+currSum;
    		maxSum = Math.max(maxSum, currSum);
    	}
    	return maxSum;
    }
}

/*
88. Merge Sorted Array
DescriptionHintsSubmissionsDiscussSolution
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
Example:

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]
**********My thoughts

**********Better solution

**********Takeaways
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
    		//[1,2,3,0,0,0] <-- 2
    		if(first < 0) {
    			nums[merged--] = nums2[second--];
    			continue;
    		}
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
**********My thoughts

**********Better solution

**********Takeaways
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
283. Move Zeroes

Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations.

**********My thoughts

**********Better solution

**********Takeaways
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
26. Remove Duplicates from Sorted Array
DescriptionHintsSubmissionsDiscussSolution
Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

Example 1:

Given nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.

It doesn't matter what you leave beyond the returned length.
Example 2:

Given nums = [0,0,1,1,1,2,2,3,3,4],

Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.

It doesn't matter what values are set beyond the returned length.
Clarification:

Confused why the returned value is an integer but your answer is an array?

Note that the input array is passed in by reference, which means modification to the input array will be known to the caller as well.

Internally you can think of this:

// nums is passed in by reference. (i.e., without making a copy)
int len = removeDuplicates(nums);

// any modification to nums in your function would be known by the caller.
// using the length returned by your function, it prints the first len elements.
for (int i = 0; i < len; i++) {
    print(nums[i]);
}
**********My thoughts

**********Better solution

**********Takeaways
*/
class Solution {
    public int removeDuplicates(int[] nums) {
    	if(nums.length ==0) return 0;
    	int last = 0;
    	for(int curr = 1; curr<nums.length; i++){
    		if(nums[last] != nums[curr]) {
    			last++;
    			nums[last] =nums[curr];
    		}
    	}
    	return last+1;
    }
}

/*
189. Rotate Array
DescriptionHintsSubmissionsDiscussSolution
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
**********My thoughts

**********Better solution

**********Takeaways
*/
public class Solution {
    public void rotate(int[] nums, int k) {
    	int n = nums.length;
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
/*
27. Remove Element
DescriptionHintsSubmissionsDiscussSolution
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

It doesn't matter what values are set beyond the returned length.
Clarification:

Confused why the returned value is an integer but your answer is an array?

Note that the input array is passed in by reference, which means modification to the input array will be known to the caller as well.

Internally you can think of this:

// nums is passed in by reference. (i.e., without making a copy)
int len = removeElement(nums, val);

// any modification to nums in your function would be known by the caller.
// using the length returned by your function, it prints the first len elements.
for (int i = 0; i < len; i++) {
    print(nums[i]);
}

**********My thoughts

**********Better solution

**********Takeaways
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
561. Array Partition I

Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.

Example 1:
Input: [1,4,3,2]

Output: 4
Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
Note:
n is a positive integer, which is in the range of [1, 10000].
All the integers in the array will be in the range of [-10000, 10000].
**********My thoughts

**********Better solution

**********Takeaways
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
349. Intersection of Two Arrays

Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Note:

Each element in the result must be unique.
The result can be in any order.
**********My thoughts

**********Better solution

**********Takeaways
*/
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
    	Set<Integer> set = new HashSet<>();
        for(int num: nums1) {
            set.add(num);
        }
        //list for intersection
        List<Integer> list = new ArrayList<>();
        for(int num:nums2){
            if(set.contains(num)){
                list.add(num);
                set.remove(num);
            }
        }
        int[] result = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            result[i] = list.get(i);
        }
        return result;
    }
}
/*
350. Intersection of Two Arrays II

Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

Note:
Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Follow up:
What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
**********My thoughts

**********Better solution

**********Takeaways
*/
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
    	Map<Integer, Integer> map = new HashMap<>();
    	for(int num : nums1) {
    		map.put(num, map.getOrDefault(num,0) + 1);
    	}
    	//list for intersection
    	ArrayList<Integer> list = new ArrayList<>();
    	
    	for(int num : nums2) {
    		if(map.containsKey(num) && map.get(num)>0) {
    			map.put(num, map.get(num) -1);
    			list.add(num);
    			
    		} 
    	}
        int[] result = new int[list.size()];   
        for(int i=0; i<list.size(); i++){
            result[i] = list.get(i);
        }
    	return result;
    }
}


/*

**********My thoughts

**********Better solution

**********Takeaways
*/