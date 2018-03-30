/**
* "Bread butter and bread"
* bread: 2
*/
import java.util.HashMap;
import java.util.Set;

public class DupWordsInString{
	
	static void dupWords(String str){
		//
		String[] wordString= str.trim().split(" ");
		HashMap<String, Integer> wordCount = new HashMap<>();
		for(String w: wordString){
			if(wordCount.containsKey(w.toLowerCase())){
				wordCount.put(w.toLowerCase(), wordCount.get(w.toLowerCase())+1);
			} else {
				wordCount.put(w.toLowerCase(), 1);
			}
		}
		//
		Set<String> wordSet = wordCount.keySet();
		for(String w: wordSet){
			if(wordCount.get(w)>1){
				System.out.println(w+": "+wordCount.get(w));
			}
		}

	}

	public static void main(String[] args){

		dupWords("Bread butter and bread");
		dupWords(" Bread butter and butter ");
	}
}