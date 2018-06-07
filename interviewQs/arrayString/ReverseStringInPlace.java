
public ReverseStringInPlace{
	
	public static void reverse(char[] arrayOfChars){
		int leftIndex = 0;
		int rightIndex = arrayOfChars.length-1;
		while(leftIndex < rightIndex){
			//swap the leftIndex and rightIndex
			char temp = arrayOfChars[leftIndex];
			arrayOfChars[leftIndex] = arrayOfChars[rightIndex];
			arrayOfChars[rightIndex] = temp;
			//2 ends move towards middle
			leftIndex++;
			rightIndex--;
		}
	}
	
}