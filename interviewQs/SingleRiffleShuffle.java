

public SingleRiffleShuffle{
	public static boolean isSingleRiffle(int[] half1, int[] half2, int[] shuffleDeck){
		int half1Index = 0;
		int half2Index = 0;
		for(int card: shuffleDeck){
			//if top card in half1 is the same as the top card in shuffleDeck
			if(half1Index < half1.length && card == half1[half2Index]){
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