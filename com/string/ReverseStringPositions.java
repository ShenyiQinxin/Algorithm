
/**
*"I Am Not String"
*"g ni rtS toNmAI"
*/
class ReverseStringPositions{
	static void reverseStringPositions(String s){
		char[] input = s.toCharArray();
		char[] output = new char[input.length];
		for(int i=0; i<input.length; i++){
			if(input[i] == ' '){
				output[i]= ' ';
			}
		}
		int j= output.length-1;
		for(int i=0; i<input.length; i++){
			if(input[i] != ' ' && output[j]==' '){
				j--;
			} 
			if(input[i] != ' ' && output[j]!=' '){
				output[j] = input[i];
				j--;
			}
		}
			
		
		System.out.println(s+" --> "+String.valueOf(output));
	}
	
	public static void main(String[] args){
		reverseStringPositions("I Am Not String");
	}
}