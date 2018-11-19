public class PermutationCombinationQs{

}

/**

Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

**********My thought:
DFS
**********better solution:
Permutations
• Unique Permutations
• Combination Sum
• Letter Combination of a Phone Number
• Palindrome Partitioning
• Restore IP Address

**********TakeAway:
template of a category of permutation and combination problems
using dfs and recursion
"Since we spend O(n) time within a call, the time complexity is O(n2^n);"

O(n!) for permutation related search
*/

class Solution78Subsets {
public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if(nums==null) {	
        	return results;
        } 
        if(nums.length==0) {
        	results.add(new ArrayList<Integer>());
        	return results;
        }

        Arrays.sort(nums);
        dfs(new ArrayList<Integer>(), nums, 0, results);
        return results;
    }

//define the recursion method signature
    private void dfs(ArrayList<Integer> subsets, int[] nums, int startIndex, List<List<Integer>> results){
    	//recursion steps
    	results.add(new ArrayList<Integer>(subsets));//results.add(subset);


    	for(int i=nums.length-1; i>=startIndex; i--){//0
    		subsets.add(nums[i]);//[1]
    		dfs(subsets, nums, i+1, results);//[1,2]...
    		//just know it has done all the work from now on
    		subsets.remove(subsets.size()-1);//remove subset starts from [1,..], 
    		//so next round it starts from [2], [2,3], ...
    	}
    	//recursio exit
    	return;
}

/**
Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  Return a list of all possible strings we could create.

Examples:
Input: S = "a1b2"
Output: ["a1b2", "a1B2", "A1b2", "A1B2"]

Input: S = "3z4"
Output: ["3z4", "3Z4"]

Input: S = "12345"
Output: ["12345"]
Note:

S will be a string with length at most 12.
S will consist only of letters or digits.

**********My thought:
recursion(12 length)
tolowercase first,
then for each letter touppercase

**********better solution:
dfs
**********TakeAway:
list of strings, so the dfs does not have subsets
use position+1 to drive in next steps

*/
class Solution784LetterCasePermutation {
    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        if (S == null) {
            return res;
        }
        
        helper(S, res, 0);
        return res;
    }
    
    public void helper(String s, List<String> res, int pos) {
        if (pos == s.length()) {
            res.add(s);
            return;
        }
        if (s.charAt(pos) >= '0' && s.charAt(pos) <= '9') {
            helper(s, res, pos + 1);
            return;
        }
        
        char[] chs = s.toCharArray();
        chs[pos] = Character.toLowerCase(chs[pos]);
        helper(String.valueOf(chs), res, pos + 1);
        
        chs[pos] = Character.toUpperCase(chs[pos]);
        helper(String.valueOf(chs), res, pos + 1);
    }
}

/**
Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

**********My thought:
dfs

**********better solution:
if(subsets.size() == nums.length){
    	results.add(new ArrayList<Integer>(subsets));
  }
  so only outputs the arrays with equal length of the original array

**********TakeAway:
O(n!)
*/


class Solution {
    public List<List<Integer>> permute(int[] nums) {
    	
    	List<List<Integer>> results = new ArrayList<>();
        if(nums==null) return results;
        //
        
        dfs(new ArrayList<Integer>(), nums, results);
        return results;
    }

    private void dfs(List<Integer> subsets, int[] nums, List<List<Integer>> results){
        if(subsets.size() == nums.length){
    		results.add(new ArrayList<Integer>(subsets));
        } else {
    	    for(int i=0; i<nums.length; i++){
                if(subsets.contains(nums[i])) continue;
                subsets.add(nums[i]);
                dfs(subsets, nums, results);
                subsets.remove(subsets.size()-1);
    	    }
        }
    }
}

/**
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

Example:

Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

**********My thought:
dfs
**********better solution:
very similar to subsets

**********TakeAway:
O(2^n) for combination related search

O(k*C(n,k)) 

*/
class Solution {
    public List<List<Integer>> combine(int n, int k) {
    	List<List<Integer>> results = new ArrayList<>();
    	if(n==0) return results;
    	dfs(new ArrayList<Integer>(), 1, n, k, results);
    	return results;
    }

    private void dfs(List<Integer> combinations, int start, int n, int k, List<List<Integer>> results){
    	if(k== 0){
    		results.add(new ArrayList<Integer>(combinations));
		}
    	for(int i=start; i<=n; i++){
    		
    		combinations.add(i);
    		dfs(combinations, i+1, n, k-1, results);
    		combinations.remove(combinations.size()-1);
    	}
    }
}

