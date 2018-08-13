public class HashMapQs{
    
}
/**
1. Two Sum
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1]
**********My thoughts
for 2 elements in the arry, their sum is 9
return the index of them
**********Better solution
use hashmap k:v nums[i]:i
**********Takeaways
element : index use hashmap
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
    	Map<Integer> map = new HashMap<>();
    	int rest = 0;
    	for(int i=0; i< nums.length; i++){
    		rest = target - e;

    		if(map.contains(rest)){
    			return new int[]{map.get(rest), i}
    		} else {
    			map.put(nums[i], i);
    		}
    	}
    	return new IllegalArgumentException("...");
    }
 }



/*
13. Roman to Integer
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.

Example 1:

Input: "III"
Output: 3
Example 2:

Input: "IV"
Output: 4
Example 3:

Input: "IX"
Output: 9
Example 4:

Input: "LVIII"
Output: 58
Explanation: C = 100, L = 50, XXX = 30 and III = 3.
Example 5:

Input: "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
**********My thoughts
I, V, X index 1, 5, 10 etc.

**********Better solution
k : v
I : 1
the relations of a[i] and a[i+1]
the condition at a.length-1 

**********Takeaways
*/
class Solution {
    public int romanToInt(String s) {
    	Map<Character, Integer> map = new HashMap<>();
    	map.put('I', 1);
    	map.put('V', 5);
    	map.put('X', );
    	map.put('L', 50);
    	map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        char[] a = s.toCharArray();
        int result = 0;
        int curr = 0;

        for(int i=0; i<a.length-1; i++){
        	curr = map.get(a[i]);
        	//II, VI
        	if(curr >= map.get(a[i+1]) || i==a.length-1) {
        		result += curr + a[i+1];
        	} else {//IV
        		result -= curr;
        	}
        }//for end
        return result;
    }
}


/*
20. Valid Parentheses

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true
Example 2:

Input: "()[]{}"
Output: true
Example 3:

Input: "(]"
Output: false
Example 4:

Input: "([)]"
Output: false
Example 5:

Input: "{[]}"
Output: true

**********My thoughts
k : v
(  : )
stack maintains sequence of ( { [

**********Better solution
if(!stack.isEmpty() && map.get(stack.peek()) == c) {//has ( in stack
    stack.pop();
} else {
    return false;
}
**********Takeaways

*/
class Solution {
    public boolean isValid(String s) {
    	char[] a = s.toCharArray();
    	Map<Character, Character> map = new HashMap<>();
    	map.put('(', ')');
    	map.put('[',']');
        map.put('{','}');

        Stack<Character> stack = new Stack<>();
//( { 90 [ ]  } )
        for(Character c : a) {
        	if(map.containsKey(c)) {//(
        		stack.push(c);
        	} else if(map.values().contains(c)) {//)
        		if(!stack.isEmpty() && map.get(stack.peek()) == c) {//has ( in stack
        			stack.pop();
        		} else {
        			return false;
        		}
        	}
        }
        return stack.isEmpty();
    }//end
}


/*
169. Majority Element

Given an array of size n, find the majority element. The majority element is the element that appears 
more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:

Input: [3,2,3]
Output: 3
Example 2:

Input: [2,2,1,1,1,2,2]
Output: 2

**********My thoughts
count the  number which is larger than floor(n/2)
**********Better solution
Map.Entry has getkey() 
**********Takeaways
getOrDefault(num, 0)
*/
class Solution {
    public int majorityElement(int[] nums) {
    	Map<Integer, Integer> map = new HashMap<>();
    	for(int num : nums){
    		map.put(num, map.getOrDefault(num,0)+1);
    	}

    	Map.Entry<Integer, Integer> majorEntry = null;
    	for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
    		if(majorEntry==null || entry.getValue()>majorEntry.getValue()) {
    			majorEntry = entry;
    		}
    	}
    	return majorEntry.getKey();
    }
}

/*
217. Contains Duplicate
Given an array of integers, find if the array contains any duplicates.

Your function should return true if any value appears at least twice in the array, 
and it should return false if every element is distinct.

Example 1:

Input: [1,2,3,1]
Output: true
Example 2:

Input: [1,2,3,4]
Output: false
Example 3:

Input: [1,1,1,3,3,4,3,2,4,2]
Output: true

**********My thoughts
HashMap
value >=2
**********Better solution

**********Takeaways
*/
class Solution {
    public boolean containsDuplicate(int[] nums) {
    	Map<Integer, Integer> map = new HashMap<>();
    	for(int num : nums) {
    		map.put(num, map.getOrDefault(num, 0)+1);
    	}
    	for(Integer v : map.values()) {
    		if(v >=2 ) {
    			return true;
    		}
    	}
    	return false;
    }
}

/*
771. Jewels and Stones

You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.

The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".

Example 1:

Input: J = "aA", S = "aAAbbbb"
Output: 3
Example 2:

Input: J = "z", S = "ZZ"
Output: 0
Note:

S and J will consist of letters and have length at most 50.
The characters in J are distinct.

**********My thoughts
hashmap
**********Better solution
hashset
**********Takeaways
*/
class Solution {
    public int numJewelsInStones(String J, String S) {
    	Set<Character> set = new HashSet<>();
    	for(char c : J.toCharArray()) {
    		set.add(c);
    	}
    	int count=0;
    	for(char c : S.toCharArray()) {
    		if(set.contains(c)) {
    			count++;
    		}
    	}
    	return count;
    }
}

/*
760. Find Anagram Mappings
Given two lists Aand B, and B is an anagram of A. B is an anagram of A means 
B is made by randomizing the order of the elements in A.

We want to find an index mapping P, from A to B. A mapping P[i] = j means the ith element 
in A appears in B at index j.

These lists A and B may contain duplicates. If there are multiple answers, output any of them.

For example, given

A = [12, 28, 46, 32, 50]
B = [50, 12, 32, 46, 28]
We should return
[1, 4, 3, 2, 0]
as P[0] = 1 because the 0th element of A appears at B[1], and P[1] = 4 because the 1st element of A 
appears at B[4], and so on.
Note:

A, B have equal lengths in range [1, 100].
A[i], B[i] are integers in range [0, 10^5].

**********My thoughts

**********Better solution

**********Takeaways

*/
class Solution {
    public int[] anagramMappings(int[] A, int[] B) {
    	Map<Integer> map = new HashMap<>();
    	for(int i=0; i< B.length; i++){
    		map.put(B(i), i);
    	}
    	//
    	int[] res = new int[A.length];
    	for(int i=0; i< A.length; i++){
    		res[i] = map.get(A[i]);
    	}
    	return res;
    }
}
/*
438. Find All Anagrams in a String

Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".

**********My thoughts
hashtable[256]

**********Better solution

**********Takeaways
*/
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
    	List<Integer> result = new ArrayList<>();
    	int left = 0, right = 0, count = p.length();
    	int[] map = new int[256];//p ascii
    	char[] a = s.toCharArray();//s
    	for(char c : p.toCharArray()) map[c]++; //fill in the p map
    	while(right < s.length()) {
    		if(map[a[right++]]-- >=1) count--;//when find the 1st match char, expand the window
    		if(count == 0) result.add(left);//when count is consumed, the full p is found in s
    		if(right - left == p.length() && map[a[left++]]++ >=0) count++;
    		//when still match some of char, or window size is p length, 
    		//then decrease the window, and count++ till p.length
    	}

    	return result;
    }
}

/*
387. First Unique Character in a String

Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.

**********My thoughts

**********Better solution

**********Takeaways
*/
class Solution {
    public int firstUniqChar(String s) {
    	
    	int[] letters = new int[26];

    	for (int i=0; i<s.length(); i++) {
    		letters[s.charAt(i)-'a']++;
    	}

    	for(int i=0; i<s.length(); i++) {
    		if(letters[s.charAt(i)-'a']==1) {
    			return i;
    		}
    	}
    	return -1;
    }
}

/*
242. Valid Anagram

Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?

**********My thoughts

**********Better solution

**********Takeaways
*/
class Solution {
    public boolean isAnagram(String s, String t) {
    	if(s.length() != t.length()) {
    		return false;
    	}
    	int[] counter = int[26];
    	for (int i=0; i<s.length(); i++) {
    		counter[s.charAt(i)-'a']++;
    		counter[t.charAt(i)-'a']--;
    	}
    	for (int c: counter) {
    		if(c !=0) return false;
    	}
    	return true;
    }
}

/*
266. Palindrome Permutation
DescriptionHintsSubmissionsDiscussSolution
Given a string, determine if a permutation of the string could form a palindrome.

Example 1:

Input: "code"
Output: false
Example 2:

Input: "aab"
Output: true
Example 3:

Input: "carerac"
Output: true

**********My thoughts

**********Better solution

**********Takeaways
*/

class Solution {
    public boolean canPermutePalindrome(String s) {
    	Set<Character> set = new HashSet<>();
    	for(char c : s.toCharArray()) {
    		if(set.contains(c)){
    			set.remove(c);
    		} else {
    			set.add(c);
    		}
    	}
    	return set.size()<=1;
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
What if elements of nums2 are stored on disk, and the memory is limited such that 
you cannot load all elements into the memory at once?
*/
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
    	Map<Integer, Integer> map = new HashMap<>();
    	for(int num : nums1) {
    		map.put(num, map.getOrDefault(num,0) + 1);
    	}
    	//list for intersection
    	List<Integer> list = new ArrayList<>();
    	
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
