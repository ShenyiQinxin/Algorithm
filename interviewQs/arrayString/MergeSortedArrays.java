
//merge 2 sorted arrays, myArray & alicesArray
/**
*  int[] myArray = new int[]{3, 4, 6, 10, 11, 15};
*  int[] alicesArray = new int[]{1, 5, 8, 12, 14, 19};

*  System.out.println(Arrays.toString(mergeArrays(myArray, alicesArray)));
// prints [1, 3, 4, 5, 6, 8, 10, 11, 12, 14, 15, 19]
*
*/
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
					(myArray[currentIndexMine] < alicesArray[currentIndexAlices]))
			  ){
					//add the item in myArray to mergedArray
					mergedArray[currentIndexMerged] = myArray[currentIndexMine];
					currentIndexMine++;
			} else {
				//add the item in alicesArray to mergedArray
				mergedArray[currentIndexMerged] = alicesArray[currentIndexAlice];
				currentIndexAlices++;
			}
			currentIndexMerged++;
		}//end while 
		return mergedArray;
	}
	//end method
}