
public FindaDuplicateSpaceEdition{
	public static int findRepeat(int[] theArray){
		int floor = 1;
		int ceiling = theArray.length-1;
		while(floor < ceiling){
			int midpoint = floor + (ceiling-floor)/2;
			int lowerRangeFloor = floor;
			int lowerRangeCeiling = midpoint;
			int upperRangeFloor = midpoint + 1;
			int upperRangeCeiling = ceiling;
			
			int itemsInLowerRange = 0;
			for(int item:theArray){
				if(item >= lowerRangeFloor && item <= lowerRangeCeiling){
					itemsInLowerRange += 1;
				}
			}
			
			int distinctPossibleIntegersInLowerRange = lowerRangeCeiling - lowerRangeFloor + 1;
			if(itemsInLowerRange > distinctPossibleIntegersInLowerRange){
				//there is a dup in lower range
				floor = lowerRangeFloor;
				ceiling = lowerRangeCeiling;
			} else {
				floor = upperRangeFloor;
				ceiling = lowerRangeCeiling;
			}
		}
		//floor ceiling converged, the floor(item) is the number that repeats
		return floor;
	}//end method
}