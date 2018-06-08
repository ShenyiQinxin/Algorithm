import static java.lang.Math.max;

public CakeThief{
	public static long maxDuffelBagValue(CakeType[] cakeTypes, int weightCapacity){
		//array of possible maximum values at every capacity (0 - weightCapacity)
		long[] maxValuesAtCapacities = new long[weightCapacity+1];
		
		for(int currentCapacity =0; currentCapacity <= weightCapacity; currentCapacity++){
			long currentMaxValue = 0;
			
			for(CakeType cakeType: cakeTypes){
				if(cakeType.weight ==0 && cakeType.value != 0){
					throw new InfinityException();
				}
				//when it is possible to add a cake in
				if(cakeType.weight <= currentCapacity){
					long maxValueUsingCake = cakeType.value + 
						maxValuesAtCapacities[currentCapacity-cakeType.weight];
					//compare the values before and after adding a cake value 
					currentMaxValue = max(maxValueUsingCake, currentMaxValue);
				}
			}
			//maxValuesAtCapacities is updated with currentMaxValue
			maxValuesAtCapacities[currentCapacity] = currentMaxValue;
		}//end for
		
		return maxValuesAtCapacities[weightCapacity];
			
	}//end method
}

static class InfinityException extends RuntimeException {
    public InfinityException() {
        super("Max value is infinity!");
    }
}