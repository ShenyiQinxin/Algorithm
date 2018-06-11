
//sort scores of 0 - highestPossibleScore by counts
/**
int[] unsortedScores = {37, 89, 41, 65, 91, 53,53,53,53};
final int HIGHEST_POSSIBLE_SCORE = 100;

int[] sortedScores = sortScores(unsortedScores, HIGHEST_POSSIBLE_SCORE);
// sortedScores: [91, 89, 65, 53, 53,53,53, 41, 37]
*/
public TopScores{
	public static int[] sortScores(int[] unorderedScores, int highestPossibleScore){
		//the counts of scores
		int[] scoreCounts = new int[highestPossibleScore+1];
		//populate the counts of each score
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
			//for each occurrence of a score, populate the score in sortedScores[]
			for(int occurrence:count){
				sortedScores[currentSortedIndex] = score;
				currentSortedIndex++;
			}
		}
		
		return sortedScores;
		
	}//end method
}