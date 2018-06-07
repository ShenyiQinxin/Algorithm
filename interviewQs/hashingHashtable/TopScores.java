
//sort scores of 0 - highestPossibleScore by counts
public TopScores{
	public static int[] sortScores(int[] unorderedScores, int highestPossibleScore){
		//the counts of scores
		int[] scoreCounts = new int[highestPossibleScore+1];
		//populate the counts of scores
		for(int score: unorderedScores){
			scoreCounts[score]++;
		}
		//initialize sortedScores
		int[] sortedScores = new int[unorderedScores.length];
		int currentSortedIndex = 0;
		//score ranked from the highest to the lowest
		for(int score = highestPossibleScore; score>=0; score--){
			//get the count from each score, 
			int count = scoreCounts[score];
			for(int occurrence=0; occurrence<count; occurrence++){
				//if count is 2, then the occurence has 2 times, then add 2 times in sortedScores[index increasing 1 by 1]
				sortedScores[currentSortedIndex] = score;
				currentSortedIndex++;
			}
		}
		
		return sortedScores;
		
	}//end method
}