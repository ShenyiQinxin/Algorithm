import java.util.HashMap;
class RepeatedChar{
	
	static void repeatedChar(String s){
		//char occurrences
		HashMap<Character, Integer> map = new HashMap<>();
		char[] charArr = s.toCharArray();
		for(char c: charArr){
			if(map.containsKey(c)){
				map.put(c, map.get(c)+1);
			} else {
				map.put(c, 1);
			}
		}
		//check the 1st non-repeated character
		for(char c: charArr){
			if(map.get(c) == 1){
				System.out.println("1st non-repeated character: "+c);
				break;
			}
		}
		//check for the 1st repeatedc character
		for(char c: charArr){
			if(map.get(c)>1){
				System.out.println("1st repeated character: "+c);
				break;
			}
		}
	}
	
	public static void main(String[] args){
		repeatedChar("JavaConceptOfTheDay");
	}
}