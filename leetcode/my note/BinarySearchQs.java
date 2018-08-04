public class BinarySearchQs{
	
}

/**
Given a sorted (in ascending order) integer array nums of n elements and a target value, write a function to search target in nums. 
If target exists, then return its index, otherwise return -1.


Example 1:

Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4

Example 2:

Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1
 

Note:

You may assume that all elements in nums are unique.
n will be in the range [1, 10000].
The value of each element in nums will be in the range [-9999, 9999].

**********My thought:
2 pointers l and r , get mid untill nums[mid]==target
**********better solution:
boundary condition: nums==null and nums.length==0
mid = l+(r-l)/2
**********TakeAway:
O(lgN) < O(n)
binary problems usually ask you to find the position of the first or last element who satisfy conditions

*/
class Solution704BinarySearch {
    public int search(int[] nums, int target) {
    	int floorIndex = -1;
    	int ceilingIndex = nums.length;

        while(floorIndex+1 < ceilingIndex){
        	mid = floorIndex + (ceilingIndex - floorIndex)/2;
        	if(nums[mid]==target){
        		return mid;
        	} else if(nums[mid]>target){
        		ceilingIndex = mid;
        	} else {
        		floorIndex = mid;
        	}
        }
        return -1;
    }
}

/**

you are a product manager and currently leading a team to develop a new product. Unfortunately, 
the latest version of your product fails the quality check. Since each version is developed based on the previous version, 
all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which will return whether version is bad. 
Implement a function to find the first bad version. You should minimize the number of calls to the API.

Example:

Given n = 5, and version = 4 is the first bad version.

call isBadVersion(3) -> false
call isBadVersion(5) -> true
call isBadVersion(4) -> true

Then 4 is the first bad version. 

**********My thought:
binary search.
when isBadVersion(i) is true, isBadVersion(i-1) is not true
**********better solution:

**********TakeAway:

*/
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

class Solution278FirstBadVersion extends VersionControl {
    public int firstBadVersion(int n) {
        int l = 1, r = n;
        int mid = 0;

        while(l < r){
        	mid = l + (r-l)/2;
        	if(isBadVersion(mid)){
        		mid = r;
        	} else {
        		l = mid;
        	}
        	
        }
        //l=r
        return l;
    }
}

/**
Implement int sqrt(int x).

Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

Example 1:

Input: 4
Output: 2
Example 2:

Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since 
             the decimal part is truncated, 2 is returned.

**********My thought:
y*y=x
**********better solution:

**********TakeAway:

*/
class Solution69Sqrtx {
    public int mySqrt(int x) {
        int l=1, r=x;
        while(l<r){
        	mid = l+(r-l)/2;
        	if(mid*mid==x)
        }
    }
}