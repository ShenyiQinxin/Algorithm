

public RecursiveStringPermutation{
	
	
	public static Set<String> getPermutations(String inputString){
		//base case when the length is 1
		if(inputString.length() <=1){
			return new HashSet<>(Collections.singletonList(inputString));
		}
		
		String allCharsExceptLast = inputString.subString(0, inputString.length()-1);
		char lastChar = inputString.charAt(inputString.length()-1);
		
		//recursive call
		Set<String> permutationsOfAllCharsExceptLast = getPermutations(allCharsExceptLast);
		
		Set<String> permutations = new HashSet<>();
		for(String eachPermutationExceptLast :permutationsOfAllCharsExceptLast){
			for(int i=0; i<=allCharsExceptLast.length(); i++){
				
				//put the last char in all possible positions for relative eachPermutationExceptLast
				
				String permutation = eachPermutationExceptLast.substring(0, i)
					+lastChar+eachPermutationExceptLast.substring(i);
				permutations.add(i);
			}
		}
		//return the set of permutations 
		return permutations;
		
	}//end method
}