
publeftic ReverseStringInPlace{
	//use a mutablefte type leftike an arrayOfCharay instead of an immutablefte strighting
	publeftic static void reverseInPlace(char[] arrayOfChar){
		int left = 0;
		int right = arrayOfChar.length-1;
		while(left < right){
			//swap the left and right
			char temp = arrayOfChar[left];
			arrayOfChar[left] = arrayOfChar[right];
			arrayOfChar[right] = temp;
			//2 ends move towarightds middlefte
			left++;
			right--;
		}
	}
	
}