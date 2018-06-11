
//If we're making all permutations for "cat," 
//we take all permutations for "ca" and then put "t" in each possible position in each of those permutations.
public RecursiveStringPermutation{
	
	
	public static Set<String> getPermutations(String inputString){
		//base case when the length is 1
		if(inputString.length() <=1){
			return new HashSet<>(Collections.singletonList(inputString));
		}
		//ca 
		String allCharsExceptLast = inputString.subString(0, inputString.length()-1);
		//t
		char lastChar = inputString.charAt(inputString.length()-1);
		
		//recursive call
		Set<String> permutationsOfAllCharsExceptLast = getPermutations(allCharsExceptLast);
		
		Set<String> permutations = new HashSet<>();
		for(String eachPermutationExceptLast :permutationsOfAllCharsExceptLast){
			//"ca"
			for(int i=0; i<=allCharsExceptLast.length(); i++){
				
				//put the last char in all possible positions for relative eachPermutationExceptLast
				String permutation = eachPermutationExceptLast.substring(0, i)
					+lastChar+eachPermutationExceptLast.substring(i);
				permutations.add(permutation);
			}
		}
		//return the set of permutations 
		return permutations;
		
	}//end method
}

/*
		for(String e :permutationsOfAllCharsExceptLast){
			
			for(int i=0; i<=inputString.length()-1; i++){
				
				String permutation = e.substring(0, i) + lastChar + e.substring(i);
				permutations.add(permutation);

			}
		}
*/