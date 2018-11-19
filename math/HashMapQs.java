import java.util.*;

public class HashMapQs {

	//2, 3, 4, 5   5
	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		int key = 0;
		for(int i=0; i<nums.length; i++) {//i for 2
			key = target - nums[i];//3
			if(map.containsKey(key)) {//
				return new int[]{map.get(key), i};
			} else {
				map.put(nums[i], i);
			}
		}
		throw new IllegalArgumentException();
	}

	//"abcba"
	public static boolean canPermutePalindrome(String s) {
		Set<Character> set = new HashSet<>();
		for(char c : s.toCharArray()) {
			if(set.contains(c)) {
				set.remove(c);
			} else {
				set.add(c);
			}
		}
		return set.size()<=1;
	}

	public static int romanToInt(String s) {
		Map<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
    	map.put('V', 5);
    	map.put('X', 10);
    	map.put('L', 50);

    	map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        //VI, VII
        int num = 0;
        int l = s.length();
        for(int i=0; i<l; i++){
            // VI 
            if(i==l-1 ||  map.get(s.charAt(i))>=map.get(s.charAt(i+1))){
                num += map.get(s.charAt(i));
            } else {//IV
                num -= map.get(s.charAt(i));
            }
            
        }
        return num;
	}

	public static boolean isValid(String s) {
		Map<Character, Character> map = new HashMap<>();
		map.put('(', ')');
    	map.put('[',']');
        map.put('{','}');
        Stack<Character> stack = new Stack<>();
        for(Character c: s.toCharArray()) {
        	if(map.containsKey(c)) { //'('
        		stack.push(c);
        	} else if (map.values().contains(c)) { //')'
        		if(!stack.isEmpty() && map.get(stack.peek()) == c) {
        			stack.pop();
        		} else {
        			return false;
        		}
        	}
        }
        return stack.isEmpty();
	}

	public static int[] anagramMappings(int[] a, int[] b) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0; i< b.length; i++) {
			map.put(b[i], i);
		}
		int[] res = new int[a.length];
		for(int i=0; i<a.length; i++) {
			res[i] = map.get(a[i]);
		}
		return res;
	}

	public static List<Integer> findAnagrams(String s, String sub) {
		List<Integer> result = new ArrayList<>();
		int lengthSub = sub.length();
		int position = 0, pointer = 0;
		int[] subMap = new int[256]; //"abc"
		char[] charS = s.toCharArray(); //"abcxabcxabc"
		for(char c : sub.toCharArray()) {//[a , b, c]
			subMap[c]++; 
		}
		//"abcxabcxabc"
		while(pointer < s.length()) {
			//find 'c' in the subMap
			//find 'x'
			if(subMap[charS[pointer++]]-- >= 1) {
				lengthSub--;
			}
			if(lengthSub == 0) {
				result.add(position);
			}
			//lengthSub -> length of sub
			if(pointer - position == sub.length() && subMap[charS[position++]]++ >=0) {
				lengthSub++;
			}
		}
		return result;
	}

	//"abcdbcd"
	public static int firstUniqChar(String s) {
		int[] letters = new int[26];
		for(int i=0; i < s.length(); i++) {
			letters[s.charAt(i) - 'a']++;
		}

		for(int i=0; i < s.length(); i++) {
			if(letters[s.charAt(i)-'a']==1) {
				return i;
			}
		}
		return -1;
	}

	public static boolean isAnagram(String s, String t) {
		if(s.length() != t.length()) {
			return false;
		}
		int[] counter = new int[26];
		for(int i=0; i<s.length(); i++) {
			counter[s.charAt(i) - 'a']++;
			counter[t.charAt(i) - 'a']--;
		}
		for(int c: counter) {
			if(c!=0) {
				return false;
			}
		}
		return true;
	}

	public static List<Integer> intersection(int[] nums1, int[] nums2) {
		Set<Integer> set = new HashSet<>();
		for(int num : nums1) {
			set.add(num);
		}
		List<Integer> list = new ArrayList<>();
		for(int num : nums2) {
			if(!list.contains(num)) {
				list.add(num);
				set.remove(num);
			}
			
		}
		return list;
	} 

	public static List<Integer> intersectionMap(int[] nums1, int[] nums2) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int num : nums1) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		List<Integer> list = new ArrayList<>();
		for(int num : nums2) {
			if(map.containsKey(num) && map.get(num) > 0) {
				map.put(num, map.get(num)-1);
				list.add(num);
			}
		}
		return list;
	}



	public static void main(String[] args){
		int[] nums1 = new int[]{2,3,4,5};
		int[] nums2 = new int[]{2,3,4,6};
		
		//int[] result = twoSum(nums,5);
		
		//System.out.println(result[0]+" "+result[1]);
		//System.out.println(canPermutePalindrome("abcba"));
		//System.out.println(canPermutePalindrome("abcdba"));

		//System.out.println(romanToInt("MDC"));

		//System.out.println(isValid("(()){}"));

		// int[] a = new int[]{12, 28, 46, 32, 50};
		// int[] b = new int[]{50, 12, 32, 46, 28};
		// for(int i : anagramMappings(a, b)) {
		// 	System.out.println(i);
		// }

		//System.out.println(findAnagrams("abcxabcxabc", "abc"));


		//System.out.println(firstUniqChar("abcbca"));

		//System.out.println(isAnagram("abc", "bca"));
		System.out.println(intersectionMap(nums1, nums2));
	}
}