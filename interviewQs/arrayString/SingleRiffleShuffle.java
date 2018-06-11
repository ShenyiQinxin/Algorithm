/**
1. cut the deck into halves half1 and half2
2. grab a random number of cards from the top of half1 
(could be 0, must be less than or equal to the number of cards left in half1) 
and throw them into the shuffledDeck
3. grab a random number of cards from the top of half2 
(could be 0, must be less than or equal to the number of cards left in half2) 
and throw them into the shuffledDeck
4. repeat steps 2-3 until half1 and half2 are empty.
*/

public SingleRiffleShuffle{
	public static boolean isSingleRiffle(int[] half1, int[] half2, int[] shuffleDeck){
		int half1Index = 0;
		int half2Index = 0;
		for(int card: shuffleDeck){
			//if top card in half1 is the same as the top card in shuffleDeck
			if(half1Index < half1.length && card == half1[half1Index]){
				half1Index++;

			//if top card in half2 is the same as the top card in shuffleDeck
			} else if(half2Index < half2.length && card == card2[half2Index]){
				half2Index++;
			} else {
				return false;
			}
		}
		//if has not returned false yet, that means all cards in shuffleDeck are from half1 and half2, so this is a single riffle
		return true;
	} //end method
}