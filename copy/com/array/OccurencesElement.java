import java.util.HashMap;
import java.util.Arrays;

class OccurencesElement{
	static void occurencesElement(int[] arr){
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i: arr){
			if(map.containsKey(i)){
				map.put(i, map.get(i)+1);
			} else {
				map.put(i, 1);
			}
		}
		System.out.println(Arrays.toString(arr));
		System.out.println(map);
	}
	
	public static void main(String[] args){
		occurencesElement(new int[]{4, 5, 4, 5, 4, 6});
	}
}