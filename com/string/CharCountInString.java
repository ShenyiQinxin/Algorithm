import java.util.Arrays;
import java.lang.String;
import java.util.HashMap;
/**
*"Java J2EE Java JSP J2EE"
*{E=4, 2=2, v=2, =4, P=1, S=1, a=4, J=5}
*/
public class CharCountInString{


static void charCountInString(String str){
	HashMap<Character, Integer> charCountMap = new HashMap<>();
	char[] charArray = str.toCharArray();
	for(char c: charArray){
		if(charCountMap.containsKey(c)){
			charCountMap.put(c, charCountMap.get(c)+1);
		} else {
			charCountMap.put(c, 1);
		}
	}
	System.out.println(charCountMap);
}

public static void main(String[] args){
	charCountInString("Java J2EE Java JSP J2EE");
}

}
