import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

class FrequentElement{
	
	static void frequentElement(Integer[] arr){
		HashMap<Integer, Integer> map = new HashMap<>();
		for(Integer i: arr){
			if(map.containsKey(i)){
				map.put(i, map.get(i)+1);
			} else {
				map.put(i, 1);
			}
		}
		int element = 0;
		int frequency = 1;
		Set<Entry<Integer, Integer>> entrySet = map.entrySet();
		for(Entry<Integer, Integer> entry: entrySet){
			if(entry.getValue() > frequency){
				element = entry.getKey();
				frequency = entry.getValue();
			}
		}
		System.out.println(Arrays.toString(arr));
		if(frequency>1){
			System.out.println(element+" : "+frequency);
		}
	}
	
	
	public static void main(String[] args){
		frequentElement(new Integer[]{4, 5, 8, 7, 4, 7, 6,7});
	}
}