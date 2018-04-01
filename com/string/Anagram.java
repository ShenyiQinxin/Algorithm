import java.util.Arrays;
import java.util.HashMap;
/**
* same set of characters but in different order
* “Dormitory – Dirty Room”, “keep – peek”,  “School Master – The Classroom” are some anagrams.
*/
class Anagram{
	
	static boolean anagramString(String str1, String str2){
		String s1 = str1.replaceAll("\\s","").toLowerCase();
		String s2 = str2.replaceAll("\\s","").toLowerCase();
		
		if(s1.length()!=s2.length()){
			return false;
		} else {
			char[] s1Arr = s1.toCharArray();
			char[] s2Arr = s2.toCharArray();
			//
			Arrays.sort(s1Arr);
			Arrays.sort(s2Arr);
			return Arrays.equals(s1Arr, s2Arr);
		}

	}

	static boolean anagramIterative(String str1, String str2){
		String s1 = str1.replaceAll("\\s","").toLowerCase();
		String s2 = str2.replaceAll("\\s","").toLowerCase();
		
		if(s1.length() != s2.length()){
			return false;
		} else {
			char[] s1Arr = s1.toCharArray();
			for(char c: s1Arr){
				int index = s2.indexOf(c);
				if(index != -1){
					s2 = s2.substring(0, index)+ s2.substring(index+1, s2.length());
				} else {
					return false;
				}
			}
			return true;
		}

	}


	static boolean anagramStringBuilder(String str1, String str2){
		String s1 = str1.replaceAll("\\s","").toLowerCase();
		String s2 = str2.replaceAll("\\s","").toLowerCase();
		
		if(s1.length() != s2.length()){
			return false;
		} else {
			char[] s1Arr = s1.toCharArray();
			StringBuilder sb = new StringBuilder(s2);
			for(char c: s1Arr){
				int index = sb.indexOf(c+"");
				if(index != -1){
					sb = sb.deleteCharAt(index);
				} else {
					return false;
				}
			}
			return true;
		}
	}

	static boolean anagramHashMap(String str1, String str2){
		String s1 = str1.replaceAll("\\s","").toLowerCase();
		String s2 = str2.replaceAll("\\s","").toLowerCase();
		
		if(s1.length() != s2.length()){
			return false;
		} 
		
		HashMap<Character, Integer> map = new HashMap<>();
		for(int i=0; i<s1.length(); i++){
			char key = s1.charAt(i);
			int value = 0;
			if(map.containsKey(key)){
				value = map.get(key);
			} 
			map.put(key, ++value);
			key = s2.charAt(i);
			value = 0;
			if(map.containsKey(key)) {
				value = map.get(key);
			}
			map.put(key,--value);
			
			
		}//end for
		//
		for(int v: map.values()){
			if(v != 0){
				return false;
			}
			return true;
		}
		return false;
	}


	public static void main(String[] args){
		//System.out.println(anagramString("Dormitory","Dirty Room"));
		//System.out.println(anagramIterative("Dormitoro","Dirty Room"));
		//System.out.println(anagramStringBuilder("Dormitor","Dirty Room"));
		System.out.println(anagramHashMap("Dormitory","Dirty Room"));
	}
}