import java.util.LinkedHashMap;
import java.util.Set;
import java.util.Iterator;
/**
* "javaconceptoftheday"
* the longest substring without repeating character is "oftheday"
*/
class LongestSubstring{
	
	static void longestSubstring(String s){
		char[] charArr = s.toCharArray();
		Set<Character> longestSubstring = null;
		int longestLength = 0;
		LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
		for(int i=0; i<charArr.length; i++){
			char ch = charArr[i];
			if(!map.containsKey(ch)){
				map.put(ch, i);
			} else {
				//if ch is in the map, then reposition i to the position of ch
				i = map.get(ch);
				//clear the map
				map.clear();
				
			}
			if(map.size() > longestLength){
				longestLength = map.size();
				longestSubstring = map.keySet();
				
			}
		}
		StringBuilder sb = new StringBuilder();
		Iterator iterator = map.keySet().iterator();
		while(iterator.hasNext()){
			Object key = iterator.next();
			sb.append(key);
			
		}
		System.out.println(sb.toString());
		System.out.println(longestLength);
		
	}
	
	public static void main(String[] args){
		longestSubstring("javaconceptoftheday");
	}
}