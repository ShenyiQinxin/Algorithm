import static java.lang.Math.max;
import static java.lang.Math.min;


public HighestProductof3{
	
	public static int highestProductOf3(int[] arrayOfInts){
		if(arrayOfInts.length<3){
			throw new IllegalArgumentException("Less than 3 items!");
		}
		
		int highest = max(arrayOfInts[0], arrayOfInts[1]);
		int lowest = min(arrayOfInts[0], arrayOfInts[1]);
		int highestProductOf2 = arrayOfInts[0] * arrayOfInts[1];
		int lowestProductOf2 = arrayOfInts[0] * arrayOfInts[1];
		int highestProductOf3 = arrayOfInts[0] * arrayOfInts[1] * arrayOfInts[2];
		
		for(int i=2; i<arrayOfInts.length; i++){
			int current = arrayOfInts[i];
			highestProductOf3 = max(max(highestProductOf3, current*highestProductOf2), 
				current*lowestProductOf2);
			highestProductOf2 = max(max(highestProductOf2, current*highest), 
				current*lowest);
			lowestProductOf2 = min(min(lowestProductOf2, current*highest), 
				current*lowest);
			highest = max(highest, current);
			lowest = min(lowest, current);
		}
		return highestProductOf3;
	}//end method
	
}