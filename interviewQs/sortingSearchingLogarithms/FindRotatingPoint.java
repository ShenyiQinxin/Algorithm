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
				floorIndex = guessIndex;
			} else {
				//guess point lesser than the first word, go left and guess
				ceilingIndex = guessIndex;
			}
			//floor and ceiling are converged
			if(floorIndex +1 ==ceilingIndex){
				break;
			}
		}
		return ceilingIndex;
	}//end method
	
}