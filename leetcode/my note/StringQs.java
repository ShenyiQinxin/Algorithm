public class StringQs {

}

/*
344. Reverse String

Write a function that takes a string as input and returns the string reversed.

Example:
Given s = "hello", return "olleh".

**********My thoughts

**********Better solution

**********Takeaways
*/
class Solution {
    public String reverseString(String s) {
        char[] charArr = s.toCharArray();
        int left =0;
        int right =charArr.length-1;
        for(int i=0; i<charArr.length/2; i++){
            char temp = charArr[left];
            charArr[left] = charArr[right];
            charArr[right] = temp;
            left ++;
            right --;
        }
        return String.valueOf(charArr);
    }
}
/*
557. Reverse Words in a String III
Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:
Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Note: In the string, each word is separated by single space and there will not be any extra space in the string.

**********My thoughts
"Let's take LeetCode contest"
without reverseCharacters()
"s'teL ekat edoCteeL tsetnoc"
with reverseCharacters()
"contest LeetCode take Let's"
**********Better solution

**********Takeaways
*/
class Solution {
    public String reverseWords(String s) {
        char[] array = s.toCharArray();
        //reverseCharacters(array, 0, s.length()-1);
        int wordStart = 0;
        for(int i=0; i<=array.length; i++){
            if(i==s.length() || array[i] == ' '){
               reverseCharacters(array, wordStart, i-1);
                wordStart=i+1;
            }
        }
        return String.valueOf(array);
    }
    
    private char[] reverseCharacters(char[] arr, int left, int right){
        
        while(left < right){
            char temp = arr[right];
            arr[right] = arr[left];
            arr[left] = temp;
            left++;
            right--;
        }
        return arr;
    }
}

/*
125. Valid Palindrome
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false

**********My thoughts
lowercase uppercase
isvalid
null or 0
left and right equal or not
**********Better solution

**********Takeaways
*/
class Solution {
    public boolean isPalindrome(String s0) {
       // String s = s0.toLowerCase();
        if(s.length()==0 || s== null) {
        	return true;
        }
        while(l < r) {
        	if(!isvalid(s.charAt(l))) {
        		l++;
        		continue;
        	}	
        	if(!isvalid(s.charAt(r))) {
        		r--;
        		continue;
        	}	
        	if(s.charAt(l) != s.charAt(r)) {
        		return false;
        	}
        	l++;
        	r--;
        }
        
    }

    private boolean isvalid(char c) {
    	if(c>='0'&&c<='9' || c>='a'&&c<='z' || c>='A' && c<='Z') {
    		return true;
    	}
    	return false;
    }
}

/*
784. Letter Case Permutation
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

**********My thoughts
1. use an arraylist to put strings in
2. get permutation of lower/upper case
**********Better solution

**********Takeaways
*/
class Solution {
   public List<String> letterCasePermutation(String S) {
   		List<StringBuilder> result = new ArrayList<>();
   		result.add(new StringBuilder());

   		for(char c : S.toCharArray()) {
   			int n = result.size();//n = 0, 1, 2, ...
   			if(Character.isLetter(c)) {
   				for (int i=0; i<n; i++) {
   					result.add(new StringBuilder(result.get(i)));//double
   					result.get(i).append(Character.toLowerCase(c));//first half lowercase
   					result.get(n+i).append(Character.toUpperCase(c));//last half uppercase
   				}
   			} else {
   				for(int i=0; i<n; i++) {
   					result.get(i).append(c);//every string is appended c
   				}
   			}
   		}
   }

   
}

/*
Write a recursive method for generating all permutations of an input string. Return them as a set.
These are our permutations of "cat":

  cat
cta
atc
act
tac
tca
*/
class Solution{
  public static Set<String> getPermutations(String s) {

    // base case
    int n = s.length();
    if (n <= 1) {
        return new HashSet<>(Collections.singletonList(s));
    }

    String preLast = s.substring(0, n - 1);
    char lastChar = s.charAt(n - 1);

    // recursive call: get all possible permutations for all chars except last
    Set<String> ps = getPermutations(prelast);

    // put the last char in all possible positions for each of the above permutations
    Set<String> set = new HashSet<>();
    for (String p : ps) {
        for (int i = 0; i <= preLast.length(); i++) {
          //lastChar put in i:0, 1, ..
            String permutation = p.substring(0, i) + lastChar
                + p.substring(i);
            set.add(permutation);
        }
    }

    return set;
}
}

/*
28. Implement strStr()

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. 
This is consistent to C's strstr() and Java's indexOf().
**********My thoughts

**********Better solution

**********Takeaways
*/
class Solution {
    public int strStr(String haystack, String needle) {
      if(needle == null || haystack == null ||
       	haystack.length() < needle.length()) return -1; 

      if(needle.length() == 0) return 0;

   		for (int i=0; i<=haystack.length()-needle.length(); i++) {
   			//suppose i is the start index of the needle in haystack
   			if(haystack.substring(i, i+needle.length()).equals(needle)) {
   				return i;
   			}
   		}
   		return -1;
    }
}

/*
171. Excel Sheet Column Number

Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
    ...
Example 1:

Input: "A"
Output: 1
Example 2:

Input: "AB"
Output: 28
Example 3:

Input: "ZY"
Output: 701
**********My thoughts

**********Better solution

**********Takeaways
*/
class Solution {
	 //AB -> 1*26+2 -> i*26+j
	 public int titleToNumber(String s) {
	 	int result = 0;
	 	for (int i=0; i<s.length(); i++) {
	 		int num = s.charAt(i)-'A'+1;
	 		result = result*26 + num;
	 	}
	 	return result;
	 }
}
/*
657. Judge Route Circle
DescriptionHintsSubmissionsDiscussSolution
Initially, there is a Robot at position (0, 0). Given a sequence of its moves, judge if this robot 
makes a circle, which means it moves back to the original place.

The move sequence is represented by a string. And each move is represent by a character. 
The valid robot moves are R (Right), L (Left), U (Up) and D (down). 
The output should be true or false representing whether the robot makes a circle.

Example 1:
Input: "UD"
Output: true
Example 2:
Input: "LL"
Output: false
**********My thoughts

**********Better solution
Initially, the robot is at (x, y) = (0, 0). If the move is 'U',
 the robot goes to (x, y-1); if the move is 'R', the robot goes to (x, y) = (x+1, y), and so on.
**********Takeaways
*/
class Solution {
    public boolean judgeCircle(String moves) {
    	int x=0, y=0;
    	for(char move: moves.toCharArray()) {
    		if(move=='U') y--;
    		else if(move == 'D') y++;
    		else if(move == 'L') x--;
    		else if(move == 'R') x++;
    	}
    	return x==0 && y==0;
    }
}
