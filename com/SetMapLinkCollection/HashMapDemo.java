import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;
import java.util.Iterator;







public class HashMapDemo{

//put(), size(), get(), for-each iterates map, iterator iterates map
	public static void hashMapTest(){
		Map<String, Integer> map = new HashMap<>();
		map.put("Lulu",123);
		map.put("Mary", 234);
		map.put("Edith", 45);
		map.put(null, null);
		map.put("Crawly", null);
		//
		map.put("Lulu",123);
		map.put("Mary", 234);
		map.put("Edith", 456);
		map.put(null, null);
		map.put("Crawly2", null);
		Set<Entry<String, Integer>> entrySet = map.entrySet();
		for(Entry<String, Integer> e: entrySet){
			System.out.println(e.getKey()+e.getValue());

		}
		System.out.println(map.size()+"...............");

		Iterator it = map.keySet().iterator();
		while(it.hasNext()){
			Object key = it.next();
			System.out.println(key+":"+map.get(key));
		}

	}

	public static void createHashMap(){
		//could plugin capacity, loadfactor and reference of another map
		Map<String, Integer> map = new HashMap<>();
		map.put("Lulu",123);
		map.put("Mary", 234);
		map.put("Edith", 59);
		//
		map.put("Lulu",123);
		map.put("Mary", 234);
		map.put("Edith", 569);

		Set<Entry<String, Integer>> entrySet = map.entrySet();
		for(Entry<String, Integer> entry: entrySet){
			System.out.println(entry.getKey()+entry.getValue());
		}
System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		//another map
		Map<String, Integer> anotherMap = new HashMap<>();
		anotherMap.put("e1",123);
		anotherMap.put("e2", 234);
		anotherMap.put("e3", 569);

		anotherMap.putAll(map);
		Set<Entry<String, Integer>> anotherEntrySet = 
		anotherMap.entrySet();
		for(Entry<String, Integer> entry: anotherEntrySet){
			System.out.println(entry.getKey()+entry.getValue());
		}
	}


	public static void main(String[] args){
		//createHashMap();
		hashMapTest();
	}
}