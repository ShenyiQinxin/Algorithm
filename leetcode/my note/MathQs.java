public class MathQs{

}

/**
Write a program to check whether a given number is an ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.

Example 1:

Input: 6
Output: true
Explanation: 6 = 2 × 3
Example 2:

Input: 8
Output: true
Explanation: 8 = 2 × 2 × 2
Example 3:

Input: 14
Output: false 
Explanation: 14 is not ugly since it includes another prime factor 7.
Note:

1 is typically treated as an ugly number.
Input is within the 32-bit signed integer range: [−231,  231 − 1].

**********My thought:
1 is an ugly number;

num / prime 

**********better solution:
for(int i=2; i< 6 && num>0; i++){}

**********TakeAway:

*/
class Solution {
    public boolean isUgly(int num) {
        //2, 3, 4, 5
        for(int i=2; i<6 && num>0; i++){
        	while(num%i == 0) {
        		num /= i;
        	}
        	
        }
        return num==1;
    }
}

/**
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

**********My thought:


**********better solution:


**********TakeAway:
*/

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
       List<Integer> result = new LinkedList<>();
       if(p.length()> s.length()) return result;
       
       Map<Character, Integer> map = new HashMap<>();
        for(char c : p.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int counter = map.size();//the counter for p-map
        
        int begin = 0, end = 0;
        int head = 0;
        int len = Integer.MAX_VALUE;
        
        
        while(end < s.length()){
            char c = s.charAt(end);//
            if(map.containsKey(c) ){
                map.put(c, map.get(c)-1);
                if(map.get(c) == 0) counter--;//the counter for p-map
            }
            end++;
            
            while(counter == 0){
                char tempc = s.charAt(begin);
                if(map.containsKey(tempc)){
                    map.put(tempc, map.get(tempc) + 1);
                    if(map.get(tempc) > 0){
                        counter++;
                    }
                }
                if(end-begin == t.length()){
                    result.add(begin);
                }
                begin++;
            }
            
        }
        return result;
    }
}