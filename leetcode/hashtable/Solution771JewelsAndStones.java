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
My thought: 
put each letter in S into a hashmap
a:1 
A:2 
b:4

Iterate through J, for each letter, check if it is in S map, if yes, count++;


better solution:
use a hashSet for J
add each J letter in the hashSet,

for each letter in S, if a letter in J equals it,
then count++;
*/
class Solution771JewelsAndStones{
	public int numJewelsInStones(String J, String S) {
	}
}