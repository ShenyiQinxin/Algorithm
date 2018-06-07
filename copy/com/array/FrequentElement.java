import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

class FrequentElement{
	
	static void frequentElement(Integer[] arr){
		//load map
		HashMap<Integer, Integer> map = new HashMap<>();
		for(Integer i: arr){
			if(map.containsKey(i)){
				map.put(i, map.get(i)+1);
			} else {
				map.put(i, 1);
			}
		}
		System.out.println(map);
		System.out.println(map.keySet());
		System.out.println(map.values());
		//load
		Integer frequentElement = 0;
		Integer frequency = 1;
		Set<Entry<Integer, Integer>> entrySet = map.entrySet();
		System.out.println(entrySet);
		for(Entry<Integer, Integer> e: entrySet){
			if(e.getValue() > frequency){
				frequentElement = e.getKey();
				frequency = e.getValue();
			}
		}
		if(frequency>1){
			System.out.println(frequentElement+" : "+frequency);
		}
		
	}
	public static void main(String[] args){
		frequentElement(new Integer[]{4, 5, 8, 7, 4, 7, 6,7});
	}
}