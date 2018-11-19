import java.util.*;

public class HashMapQs {
	/* {2,3,4,5}, 5 
	(k,v) : (num, index) 
	return (indexK1, indexK2) */
	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		int key = 0;
		for(int i=0; i<nums.length; i++) {//value=i=0
			key = target - nums[i];//key=3, nums[i]=2

			if(map.containsKey(key)) {
				return new int[]{map.get(key), i};
			} else {
				map.put(nums[i], i);
			}
		}
		throw new IllegalArgumentException();
	}

	/* abcba , there would be only 1 or 0 letter */
	public static boolean canPermutePalindrome(String s) {
		Set<Character> set = new HashSet<>();
		for(char c : s.toCharArray()) {
			if(set.contains(c)) {
				set.remove(c);
			} else {
				set.add(c);
			}
		}
		return set.size() <= 1;
	}

	/* IV -> 5-1  VI -> 5+1 */
	public static int romanToInt(String s) {
		Map<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
    	map.put('V', 5);
    	map.put('X', 10);
    	map.put('L', 50);

    	map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int num = 0;
        int length = s.length();
       	for(int i=0; i<length; i++) {
       		//VI
       		if(i==length-1 || map.get(s.charAt(i)) >= map.get(s.charAt(i+1))) {
       			num += map.get(s.charAt(i));
       		} else {//VI
       			num -= map.get(s.charAt(i));
       		}
       	}
       	return num;
	}

	/* d(e{abc})f is valid
	   ((} is not valid */
	public static boolean isValid(String s) {
		Map<Character, Character> map = new HashMap<>();
		map.put('(', ')');
    	map.put('[',']');
        map.put('{','}');
        Stack<Character> stack = new Stack<>();
        for(Character c : s.toCharArray()) {
        	//for every { [ ( 
        	if(map.containsKey(c)) {
        		stack.push(c);
        	} else if (map.values().contains(c)) {//among values, 
        		//the stack has one that is just its the other half
        		if(!stack.isEmpty() && map.get(stack.peek()) == c) {
        			stack.pop();
        		} else {
        			return false;
        		}
        	}
        }
        return stack.isEmpty();
	}

	/*
	A = [12, 28, 46, 32, 50]
	B = [50, 12, 32, 46, 28]
	We should return the `index of b[i] in the order of A`
	[1, 4, 3, 2, 0]
	*/
	public static int[] anagramMappings(int[] a, int[] b) {
		Map<Integer, Integer> bMap = new HashMap<>();
		for(int i=0; i<b.length; i++) {
			bMap.put(b[i], i);
		}
		int[] result = new int[a.length];
		for(int i=0; i<a.length; i++) {
			//find the a[i] from the bMap
			result[i] = bMap.get(a[i]);
		}
		return result;
	}

	/* s: "cbaebabacd" sub: "abc"
	   
	*/
	public static List<Integer> findAnagrams(String s, String p) {
		List<Integer> result = new ArrayList<>();
		int pLength = p.length();
		int left = 0, right = 0, pPosition = p.length();
		int[] pArray = new int[256];
		char[] sArray = s.toCharArray();
		for(char c : p.toCharArray()) {
			pArray[c]++;
		}
		while(right < s.length()) {
			if(pArray[sArray[right++]]-- >= 1) pPosition--;
			if(pPosition ==0) result.add(left);
			if(right-left == p.length() && pArray[sArray[left++]]++ >=0) {
				pPosition++;
			}
		}
		return result;
	}


	public static void main(String[] args){
		int[] nums1 = new int[]{12, 28, 46, 32, 50};
		int[] nums2 = new int[]{50, 12, 32, 46, 28};
		//int[] result = twoSum(nums1,7);
		//System.out.println(result[0]+" "+result[1]);
		//System.out.println(canPermutePalindrome("abcba"));
		//System.out.println(romanToInt("VI"));
		//System.out.println(isValid("((} "));
		// int[] result = anagramMappings(nums1, nums2);
		// for(int i : result) {
		// 	System.out.print(i + " ");
		// }
		
		int s = "cbaebabacd";
		int p = "abc";
		System.out.println(findAnagrams(s, p));
		System.out.println();
		System.out.println();
		System.out.println();
	}
}