

public ParentheticalsMatching{
	public static int getClosingParen(String sentence, int openingParenIndex){
		int openNestedParens = 0;
		for(int position = openingParenIndex+1; position< sentence.length(); position++){
			char c = sentence.charAt(position);
			if(c == '('){
				//keep a count of how many additional "(" we find 
				openNestedParens++;
			} else if(c == ')'){
				//If we find a ")" and openNestedParens is 0, we know that ")" closes our initial "(", so we return its position
				if(openNestedParens == 0){
					return position;
				} else {
					//find a ')', decrese the count
					openNestedParens--;
				}
			}
		}//end for
		throw new IllegalArgumentException("No closing parenthesis :(");
	}//end method
}