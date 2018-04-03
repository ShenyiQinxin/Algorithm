
/**
*"Java Concept Of The Day"
*"avaJ tpecnoC fO ehT yaD"
*/
class ReverseEachWord{
	static void reverseEachWord(String s){
		String[] words = s.split(" ");
		String reStr = "";
		for(int i=0; i<words.length; i++){
			String w = words[i];
			String reversed ="";
			for(int j=w.length()-1; j>=0; j--){
				reversed +=w.charAt(j);
			}
			reStr += reversed+" ";
		}
		System.out.println(reStr);
	}
	
	public static void main(String[] args){
		reverseEachWord("Java Concept Of The Day");
	}
	
}