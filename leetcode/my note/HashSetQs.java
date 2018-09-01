public class HashSetQs{

}

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
**********My thought: +


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

/**
Given two lists Aand B, and B is an anagram of A. B is an anagram of A means B is made by randomizing the order of the elements in A.

We want to find an index mapping P, from A to B. A mapping P[i] = j means the ith element in A appears in B at index j.

These lists A and B may contain duplicates. If there are multiple answers, output any of them.

For example, given

A = [12, 28, 46, 32, 50]
B = [50, 12, 32, 46, 28]
We should return
[1, 4, 3, 2, 0]
as P[0] = 1 because the 0th element of A appears at B[1], and P[1] = 4 because the 1st element of A appears at B[4], and so on.
Note:

A, B have equal lengths in range [1, 100].
A[i], B[i] are integers in range [0, 10^5].

*********My thought: 
A indexs the indexs
B indexs the values
if A[i]==B[j], then arr[i]=j
k:v 
A[i]:i
*********Better solution:
Hashmap
put B : i
iterate through A
get value by key from A, since A and B share elements
pass values to result[]

*********takeaways:
HashMap could be used to get value by key
since there may be dups but only output any of them, so hashmap is a good option

*/
class Solution760FindAnagramMappings {
    public int[] anagramMappings(int[] A, int[] B) {
    	Map<Integer, Integer> map = new Hashmap<>();
        for(int i=0; i<B.length; i++){
        	map.put(B[i], i);
        }
        int[] result = new int[A.length];
        for(int i=0; i<A.length; i++){
        	result[i]=map.get(A[i]);
        }
        return result;
    }
}

/**
Given a List of words, return the words that can be 
typed using letters of alphabet on only one row's of American keyboard like the image below.
Example 1:
Input: ["Hello", "Alaska", "Dad", "Peace"]
Output: ["Alaska", "Dad"]
Note:
You may use one character in the keyboard more than once.
You may assume the input string will only contain letters of alphabet.

*********My thought: 
for each word, if it belongs to one single row on keyboard
then put the word in output array
*********Better solution:

 return 
 Stream.of(words).filter(s -> 
 s.toLowerCase()
 .matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*"))
 .toArray(String[]::new);

*********takeaways:
regex, stream
*/
class Solution500KeyboardRow {//O(n^2)
    public String[] findWords(String[] words) {
    	String[] result = new String[];
        for(int[] i=0; i<words.length; i++){
        	if(wordInOneRow(word[i])){
        		result[j]=word;
        	}
        }
        return result;
    }

    private boolean wordInOneRow(String word){
    	//char[] c1= new char[7];
    	//char[] c2 = new char[9];
    	//char[] c3 = new char[10];
    	Map<Character, Integer> map = new Hashmap<>();
    	map.put('A', 2);
    	map.put('B', 1);
    	//...
    	int i=0, one=0, two=0, three=0;
    	char c = word.charAt(i);
    	for(; i<word.length; i++){
    		if(1==map.get(c)) one++;
    		if(2==map.get(c)) two++;
    		if(3==map.get(c)) three++;
    	}
    	//
    	if(one ==word.length() || two== word.length || three==word.length){
    		return true;
    	}
    	return false;
    }
}