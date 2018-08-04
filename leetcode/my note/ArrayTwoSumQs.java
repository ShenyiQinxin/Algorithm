

public class ArrayTwoSumQs{

}

/**
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

**********My thoughts
use a hashmap to store int[] elements

**********Better solution
put nums in a hashMap (not use the same element twice)
for each key, cached it as a key, find a match from the rest
num: index
target-num: index
2:1
7:7

**********Takeaways
hashmap has key:value pair to index each value
value = map.get(key)
map.containsKey(key);
map.put(key,value);

time O(n), space O(n)
*/

class HashMap1TwoSum {
    public int[] twoSum(int[] nums, int target) {
    	Map<Integer, Integer> map = new HashMap<>();
    	for(int i=0; i<nums.length; i++){
    		if(!map.containsKey(num)){
    			map.put(num,i);
    		} else {
    			return new int[]{map.get(target-num[i]), i};
    		}
    	}
    	return new IllegalArgumentException("..");
    }
}

/**
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
when array is sorted, we could binary search

**********Better solution
wihout using extra space, we could achieve time O(n), space O(1)

**********Takeaways

*/
class BS167TwoSumIISortedInputArray {
    public int[] twoSum(int[] numbers, int target) {
        int low =0, high = numbers.length-1;
        while(low<high){
            int sum = numbers[low]+numbers[high];
            if(sum==target){
                return int[]{low+1, high+1};
            } else if(sum>target){
                high--;
            } else {
                low++;
            }
        }
        throw new IllegalArgumentException("..");
    }
}

/**
Given a Binary Search Tree and a target number, return true if there exist two elements in the BST 
such that their sum is equal to the given target.

Example 1:
Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 9

Output: True
Example 2:
Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 28

Output: False

**********My thoughts
search tree from the root node,
if rest < node.val search the left, else the right
**********Better solution
create an arraylist, 
inorder binary search recursively, add elements in the arraylist
get the index pair from the ordered linkedlist
**********Takeaways
Inorder traversal of a BST gives the nodes in ascending order.
inorder traversal puts the results in a listlist which contains 
the nodes sorted in ascending order.
do binary search on the arraylist(could index element)
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution653TwoSumIVInputBST {
    public boolean findTarget(TreeNode root, int k) {
      List<Integer> list = new ArrayList<>();
      inorder(root, list);
      int l=0, r=list.size()-1;
      while(l<r){
        int sum = list.get(l)+list.get(r);
        if(sum==k){
            return true;
        } else if(sum < k){
            l++;
        } else {
            r--;
        }
      }
      return false;
    }

    public void inorder(TreeNode root, List<Integer> list){
        if(root==null){
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}


/**
Design and implement a TwoSum class. It should support the following operations: add and find.

add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value.

Example 1:

add(1); add(3); add(5);
find(4) -> true
find(7) -> false

Example 2:

add(3); add(1); add(2);
find(3) -> true
find(6) -> false

**********My thoughts
use arraylist 
but Time Limit Exceeded

**********Better solution
hashmap
k:v
number: counts

**********Takeaways
hashmap deal with duplicate elements in a non-dup formate

map.getOfDefault(key,0)+1;

map.keySet();

map.get(k);

map.containsKey(k);



*/

class TwoSumIIIDataStructureDesign {
    private Map<Integer, Integer> map;
    /** Initialize your data structure here. */
    public TwoSumIIIDataStructureDesign() {
        this.map = new HashMap<>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0)+1);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {  
        for(Integer k:map.KeySet()){
            Integer rest = value - k;
            if((rest==k && map.get(k)>1) || (rest!=k && map.containsKey(rest))){
                return true;
            }
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */