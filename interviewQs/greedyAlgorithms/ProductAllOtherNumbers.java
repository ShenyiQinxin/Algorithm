

public ProductAllOtherNumbers{
	public static int[] getProductsOfAllIntsExceptAtIndex(int[] intArray){
		if(intArray.length<2){
			throw new IllegalArgumentException("Getting the product of numbers at other indices requires at least 2 numbers");
			
		}
		//an array of products for the indexes
		int[] productOfAllIntsExceptAtIndex = new int[intArray.length];
		//productSoFar is used to save the product
		int productSoFar = 1;
		//product of integers before each index
		for(int i=0; i<intArray.length; i++){
			productsOfAllIntsExceptAtIndex[i] = productSoFar;
			productSoFar *= intArray[i];
		}
	
		productSoFar = 1;
		//product of all the integers after each index
		for(int i= intArray.length - 1; i>=0; i--){
			//multiply the product after the index
			productsOfAllIntsExceptAtIndex[i] *= productSoFar;
			productSoFar *= intArray[i];
		}
		return productsOfAllIntsExceptAtIndex;
	}//end method
}