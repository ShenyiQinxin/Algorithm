public class DuplicateQs{

}

/**
Given an array of integers, find if the array contains any duplicates.

Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

Example 1:

Input: [1,2,3,1]
Output: true
Example 2:

Input: [1,2,3,4]
Output: false
Example 3:

Input: [1,1,1,3,3,4,3,2,4,2]
Output: true

**********My thought: 
hashmap

**********better solution:
hashmap
**********TakeAway:
hashmap for dups in array 
*/

class Solution217ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
    	Map<Integer, Integer> map = new HashMap<>();
    	for(Integer e:nums){
    		map.put(e, map.getOrDefault(e,0)+1);
    	}

    	for(Integer v: map.values()){
    		if(v>1){
    			return true;
    		}
    	}
    	return false;
    }
}

/**
Given an array of integers and an integer k, find out whether there are two distinct
 indices i and j in the array such that nums[i] = nums[j] and the absolute difference 
 between i and j is at most k.

Example 1:

Input: nums = [1,2,3,1], k = 3
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1
Output: true
Example 3:

Input: nums = [1,2,3,1,2,3], k = 2
Output: false

**********My thought: 
did not evern understand the question

**********better solution:
for dup elements in the array, the abs of any 2 <= k (at most)
meaning, 
if there is a pair in which abs is > k
meanwhile, there is another pair in which abs is <=k
then, it holds.

but if none of the pair is <=k , then return false
**********TakeAway:
oldv = map.put(k,newv);
*/

class Solution219ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
    	Map<Integer, Integer> map = new HashMap<>();
    	for(int i= 0; i<nums.length; i++){
    		Integer prevI = map.put(nums[i], i);
    		if(prevI!=null && i-prevI<=k){
    			return true;
    		}
    	}
    	return false;
    }
}



/**

Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:

Input: [3,2,3]
Output: 3
Example 2:

Input: [2,2,1,1,1,2,2]
Output: 2


**********My thought: 
put array in a hashmap
k:V
number: count
when count>Math.floorDiv(n/2)

**********better solution:


**********TakeAway:

*/

class Solution169MajorityElement {
    public int majorityElement(int[] nums) {

    }
}