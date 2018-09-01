public class BinarySearchQs{
	
}

/**
704BinarySearch

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
if l<=r, then it could handle [5]

*/
class Solution {
    public int search(int[] nums, int target) {
    	if(nums==null || nums.length==0) return 0;
        int l=0, r=nums.length-1;
       //when l == r, it handles [5]
        while(l <= r){
             int mid = l + (r-l)/2;
        	if(nums[mid] == target) {
        		return mid;
        	} else if (nums[mid] > target){
        		r = mid-1;
        	} else {
        		l = mid+1;
        	}
        }
        return -1;
    }
}

/**
278FirstBadVersion

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

class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int l = 1, r = n;
        int mid = 0;
        //if l==r, then return 1
        while(l < r){
        	mid = l + (r-l)/2;
        	if(isBadVersion(mid)){
        		mid = r;
        	} else {
        		l = mid;
        	}
        	
        }
        //l==r
        return l;
    }
}

/**
69Sqrtx 

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
x/mid == mid
when l>r , return r
**********TakeAway:
2 types of BiSearch
search index:
search value:
*/
class Solution {
    public int mySqrt(int x) {
    	if(x<=1) return x;

        int l=0, r=x;
        while(l <= r){
        	int mid = l+(r-l)/2;
        	if(x/mid==mid){
        		return mid;
        	} else if(x/mid < mid){
        		r = mid-1;
        	} else {
        		l = mid+1;
        	}
        }
        //l>r
        return r;
    }
}


/**
35 search insert position
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be 
if it were inserted in order.

You may assume no duplicates in the array.

Example 1:

Input: [1,3,5,6], 5
Output: 2
Example 2:

Input: [1,3,5,6], 2
Output: 1
Example 3:

Input: [1,3,5,6], 7
Output: 4
Example 4:

Input: [1,3,5,6], 0
Output: 0

**********My thought:
binarysearch
if target == nums[i] then found it
if nums[i-1] < target < nums[i]
then insert nums[i]=target
**********better solution:
nums == null or nums.length ==0
mid = (l+r) /2
**********TakeAway:
when l is just larger than r, then return l
*/

class Solution {
    public int searchInsert(int[] nums, int target) {
    	if(nums == null||nums.length == 0) return 0;
        
        int l=0, r=nums.length-1;
        
        while(l <= r){
        	int mid = l+(r-l)/2;
        	if(nums[mid]==target){
        		return mid;
        	} else if(nums[mid]>target){
        		return r = mid-1;
        	} else {
        		l = mid+1;
        	}
        }
        // l > r
        return l;
    }
}

/*
367ValidPerfectSquare

Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:

Input: 16
Returns: True
Example 2:

Input: 14
Returns: False


**********My thought:
4*4==16, 16/4
**********better solution:

**********TakeAway:
*/
class Solution {
    public boolean isPerfectSquare(int num) {
    	
        int l=1, r=num/2;
        while(l<=r){
            //if 
        	int mid = l+(r-l)/2;
        	if(num/mid == mid){
        		return true;
        	} else if(num/mid < mid){
        		r= mid-1;
        	} else {
        		l = mid+1;
        	}
        }
        return false;

    }
}

/*
14. Longest Common Prefix
DescriptionHintsSubmissionsDiscussSolution
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
Note:

All given inputs are in lowercase letters a-z.
**********My thoughts

**********Better solution

**********Takeaways
*/
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length ==0) return "";
        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            minLength = Math.min(minLength, str.length());
        }
        int left = 1, right = minLength;
        while(left <= right) {
            int mid = left + (right - left)/2;
            if(isCommonPrefix(strs, mid)) {
                left = mid +1;//-->
            } else {
                right = mid -1;//<--
            }
        }
        return strs[0].substring(0,  (left+right)/2);
    }
    private boolean isCommonPrefix(String[] strs, int length){
        String str1 = strs[0].substring(0, length);
        for(int i=1; i< strs.length; i++){
            if(!strs[i].startsWith(str1)){
                return false;
            }
        }
        return true;
    }
}


