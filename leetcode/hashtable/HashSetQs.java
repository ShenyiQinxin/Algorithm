/**
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
*/


/*
**********My thought: 
put each letter in S into a hashmap
a:1 
A:2 
b:4

Iterate through J, for each letter, check if it is in S map, if yes, count++;


**********better solution:
use a hashSet for J
add each J letter in the hashSet,

for each letter in S, if a letter in J equals it,
then count++;

**********TakeAway:
1. collection hashset, methods(add, contains) and features(J are distinct, so Js are added in the hashset)
2. for loop
3. string convert to char[](toCharArray)

*/
public class HashSetQs{

}
class Solution771JewelsAndStones{
	public int numJewelsInStones(String J, String S) {
		Set<Character> Jset = HashSet<>();
		for(Character c: J.toCharArray()){
			Jset.add(c);
		}
		int count = 0;
		for(Character s: S.toCharArray()){
			if(Jset.contains(s)){
				count++;
			}
		}
		return count;
	}
}

//next up, a very similar one
/**
Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:
Each element in the result must be unique.
The result can be in any order.

**********My thought: 
1. for each nums1 element, compare it with each num2 element, 
when they equal, then put element into a new array.
2. since each element is unique, then we put each of nums1 n num2 in a hashset,
3. retainall()

the problem: set is not easy for getting each int element out, 
if it was String, then it would be easier

**********better solution:
for adding unique element from nums1, use hashset
use an arraylist to acquire the intersection elements in nums2, and remove them from set
iterate throughh arraylist to put each element into an int[]

**********TakeAway:
hasset use to store unique element in (set.add(e), set.contains(e))
arraylist is to add mutual elements in(list.add(e), set.remove(e))
remove the compared elements
list is easy for get element by id (list.get(i))
*/

class Solution349IntersectionOfTwoArrays{
	public int[] intersection(int[] nums1, int[] nums2) {
			Set<Integer> set = new HashSet<>();
			for(int e: nums1){
				set.add(e);
			}
			List<Integer> list = new ArrayList<>();
			for(Integer e: nums2){
				if(set.contains(e)){
					list.add(e);
					set.remove(e);
				}
			}
			int[] result = new int[list.size()];
			for(int i=0; i< lis.size(); i++){
				result[i]= list.get(i);
			}
			return result;
	}
}