
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Collection;

class HashMapConstruct{

	static HashMap<String, Integer> hashMapConstruct(){
		HashMap<String, Integer> map = new HashMap<>();
		HashMap<String, Integer> mapCapacity = new HashMap<>(30);
		HashMap<String, Integer> mapLoadfactor = new HashMap<>(30, 0.75f);
		HashMap<String, Integer> mapByOtherMap = new HashMap<>(map);

		return map;
	}

	static HashMap<String, Integer> hashMapIteration(HashMap<String, Integer>  map){
		map.put("one",1);
		map.put("two",2);
		map.put("three",3);
		map.put("four",4);
		map.put("five",5);
		map.put("six",6);
		
		Set<Entry<String,Integer>> set=map.entrySet();
		for(Entry<String, Integer> entry: set){
			System.out.println(entry.getKey()+" : "+entry.getValue());
		}
		HashMap<String, Integer> anotherMap = new HashMap<>();
		anotherMap.put("seven",7);
		anotherMap.put("eight",8);
		anotherMap.putAll(map);
		System.out.println(anotherMap);		
		
		Set<String> keys = anotherMap.keySet();
		Collection<Integer> is = anotherMap.values();
		for(String k:keys){
			System.out.print(k+" ");
		}
		System.out.println();		

		for(Integer i:is){
			System.out.print(i+" ");
		}
		System.out.println();		

		return anotherMap;
	}


	static HashMap<String, Integer> hashMapOp(HashMap<String, Integer>  map){
		//the same as putIfAbsent
		System.out.println(map.put("eight",8));
		System.out.println(map.putIfAbsent("nine",9));
		System.out.println(map.containsKey("eight")
			+" : "+map.remove("eight")
			+" : "+map.get("eight")
			+" : "+map.replace("eight", 88)
			+" : "+map.replace("eight", 88, 8)
			+". "+map.size());		
		map.clear();
		return map;
	}

	public static void main(String[] args){
		HashMap<String, Integer> map =hashMapConstruct();
		map = hashMapIteration(map);
		hashMapOp(map);
	}
	
}