
//merge 2 sorted arrays, myArray n alicesArray
public MergeSortedArrays{
	
	public static int[] mergeArrays(int[] myArray, int[] alicesArray){
		//initialize the mergedArray
		int[] mergedArray = new int[myArray.length+alicesArray.length];
		//initialize indexes
		int currentIndexAlices = 0;
		int currentIndexMine = 0;
		int currentIndexMerged = 0;
		while(currentIndexMerged < mergedArray.length){
			
			boolean isMyArrayExhausted = currentIndexMine >= myArray.length;
			boolean isAlicesArrayExhausted = currentIndexAlices >= alicesArray.length;
			//if myArray is not exhausted, and (alicesArray is exhausted or 
			//the current item in myArray is smaller than alicesArray
			if(!isMyArrayExhausted && 
				(isAlicesArraysExhausted || 
					(myArray[currentIndexMine] < alicesArray[currentIndexAlices])
			    )){
					//add the item in myArray to mergedArray
					mergedArray[currentIndexMerged] = myArray[currentIndexMine];
					currentIndexMine++;
			} else {
				//add the item in alicesArray to mergedArray
				mergedArray[currentIndexMerged] = alicesArray[currentIndexAlice];
				currentIndexAlices++;
			}
			currentIndexMerged++;
		}
		return mergedArray;
	}
	//end method
}