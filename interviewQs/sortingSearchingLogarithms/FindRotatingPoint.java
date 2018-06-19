//  [ "k","v","a","b","c","d","e","g","i" ]
//  guess "c"
//when floorIndex +1 == ceilingIndex
//  [ "k","a","b","c","d","e","g","i" ]
public FindRotatingPoint{
	
	public static int findRotationPoint(String[] words){
		final String firstWord = words[0];
		int floorIndex = 0;
		int ceilingIndex = words.length-1;
		while(floorIndex < ceilingIndex){
			//guess a point halfway between floor and ceiling
			int guessIndex = floorIndex +((ceilingIndex-floorIndex)/2);
			if(words[guessIndex].compareTo(firstWord)>=0){
				//go right
				//["i","k","v","a","b","c","d","e","g" ] guess "k"
				//["i",|"k","v","a","b","c","d","e","g" ]
				floorIndex = guessIndex;
			} else {
				//words[guessIndex].compareTo(firstWord)>=0, go left and guess
				// [ "k","v","a","b",|"c","d","e","g","i" ] guess "c"
				ceilingIndex = guessIndex;
			}
			//floor and ceiling are converged
			//[ "v","a","b","c","d","e","g","i","k" ]
			//ceilingIndex is "a"
			if(floorIndex +1 ==ceilingIndex){
				break;
			}
		}
		return ceilingIndex;
	}//end method
	
}