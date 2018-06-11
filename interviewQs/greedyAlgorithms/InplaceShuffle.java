import java.util.Random;


public InplaceShuffle{
	
	private static Random rand = new Random();
	
	public static int getRandom(int floor, int ceiling){
		return rand.nextInt((ceiling-floor)+1)+floor;
	}
	
	public static void shuffle(int[] theArray){
		if(theArray.length <=1){
			return;
		}
		for(int i = 0;
		i<theArray.length-1; i++){
			//get a random number after index i
			int randomChoiceIndex = getRandom(i, theArray.length-1);
			//if randomChoice is not the item at i, swap them
			if(randomChoiceIndex != i){
				int value = theArray[i];
				theArray[i] = theArray[randomChoiceIndex];
				theArray[randomChoiceIndex] = value;
			}
		}
	}//end method
}