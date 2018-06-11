
//reverse words in a char array (a string)
/**
char[] message = { 'c', 'a', 'k', 'e', ' ',
                   'p', 'o', 'u', 'n', 'd', ' ',
                   's', 't', 'e', 'a', 'l' };

reverseWords(message);

System.out.println(message);
// prints: "steal pound cake"
*/
public ReverseWords{
	
	public static void reverseWords(char[] message){
		//reverse all the characters in the array
		reverseCharacters(message, 0, message.length-1);
		//hold the index of the start of the current word
		//and look for the end of the current word
		int currentWordStartIndex = 0;
		for(int i=0; i<=message.length; i++){
			//if reach to the end or ' ' of the array
			if(i == message.length || message[i] == ' '){
				//reverse the characters of this word
				reverseCharacters(message, currentWordStartIndex, i-1);
				//next word starts at i+1
				currentWordStartIndex = i+1;
			}
		}
		//end for
	}
	
	private static void reverseCharacters(char[] message, int leftIndex, int rightIndex){
		while(leftIndex < rightIndex){
			char temp = message[leftIndex];
			message[leftIndex] = message[rightIndex];
			message[rightIndex] = temp;
			leftIndex++;
			rightIndex--;
		}
	}
}

/*
		for(int i=0; i<=message.length; i++){
			
			if(i == message.length || message[i] == ' '){
				
				reverseCharacters(message, currentWordStartIndex, i-1);
				
				currentWordStartIndex = i+1;
			}
		}

*/