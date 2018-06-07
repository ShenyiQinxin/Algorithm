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
		for(int indexWeAreChoosingFor = 0;
		indexWeAreChoosingFor<theArray.length-1; indexWeAreChoosingFor++){
			int randomChoiceIndex = getRandom(indexWeAreChoosingFor, theArray.length-1);
			//if randomChoice is not the currrent item, swap them
			if(randomChoiceIndex != indexWeAreChoosingFor){
				int valueAtIndexWeChoosingFor = theArray[indexWeAreChoosingFor];
				theArray[indexWeAreChoosingFor] = theArray[randomChoiceIndex];
				theArray[randomChoiceIndex] = valueAtIndexWeChoosingFor;
			}
		}
	}//end method
}