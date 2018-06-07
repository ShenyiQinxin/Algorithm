import java.util.HashSet;
import java.util.Set;

public PermutationPalindrome{
	//check that each character appears an even number of times, allowing for only one character to appear an odd number of times (a middle character)
	public static boolean hasPalindromePermutation(String theString){
		//track unpaired characters 
		Set<Character> unpairedCharacters = new HashSet<>();
		for(char c: theString.toCharArray){
			//if found a pair
			if(unpairedCharacters.contains(c)){
				//remove the just-paired character
				unpairedCharacters.remove(c);
			} else {
				unpairedCharacters.add(c);
			}
		}
		//palindrome permutation has one or zero unpaired characters 
		return unpairedCharacters.size() <= 1;
	}//end method
	
}