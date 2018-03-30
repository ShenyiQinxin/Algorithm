import java.lang.String;
import java.util.Arrays;

public class NumberWordsInString{

//method 1
	static void numberWordsInString1(String str0){
		int count=0;
		String str = str0.trim();
		for(int i=0; i<str.length(); i++){
			if(str.charAt(i)==' ' && str.charAt(i+1)!=' '){
				count++;
			}
		}
		System.out.println(count+1);
	}
//method 2
	static void numberWordsInString2(String str){
		String[] words = str.trim().split(" ");
		System.out.println(words.length);
	}
	public static void main(String[] args){
		numberWordsInString1("Java is java again java again");
		numberWordsInString2("Java is java again java again");
	}
}