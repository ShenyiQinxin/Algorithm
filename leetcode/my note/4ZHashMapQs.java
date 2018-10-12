public class ZHashMapQs {

//Q1===========================================================================
	public int[] twoSum(int[] nums, int target) {
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
	 

	//
    public boolean canPermutePalindrome(String s) {
    	Set<Character> set = new HashSet<>();
    	for(char c : s.toCharArray()) {
    		if(set.contains(c)){
    			set.remove(c);
    		} else {
    			set.add(c);
    		}
    	}
    	return set.size()<=1;
    }

	//
    public int romanToInt(String s) {
    	Map<Character, Integer> map = new HashMap<>();
    	map.put('I', 1);
    	map.put('V', 5);
    	map.put('X', );
    	map.put('L', 50);

    	map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int num = 0;
        int l = s.length();
        for(int i=0; i<l; i++){
        	//II, VI
        	if(map.get(s.charAt(i)) >= map.get(s.charAt(i+1)) 
                || i==l-1) {
        		num += map.get(s.charAt(i));
        	} else {//IV
        		num -= map.get(s.charAt(i));
        	}
        }//for end
        return num;
    }


    public boolean isValid(String s) {
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
    }//end

//Q2===========================================================================
    //
    public int majorityElement(int[] nums) {
    	Map<Integer, Integer> map = new HashMap<>();
    	for(int num : nums){
    		map.put(num, map.getOrDefault(num,0)+1);
    	}

    	Map.Entry<Integer, Integer> majorEntry = null;
    	for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
    		if(majorEntry==null || entry.getValue()>majorEntry.getValue()) {
    			majorEntry = entry;
    		}
    	}
    	return majorEntry.getKey();
    }

	//
    public boolean containsDuplicate(int[] nums) {
    	Map<Integer, Integer> map = new HashMap<>();
    	for(int num : nums) {
    		map.put(num, map.getOrDefault(num, 0)+1);
    	}
    	for(Integer v : map.values()) {
    		if(v >=2 ) {
    			return true;
    		}
    	}
    	return false;
    }

    //
    public int numJewelsInStones(String J, String S) {
    	Set<Character> set = new HashSet<>();
    	for(char c : J.toCharArray()) {
    		set.add(c)     
    	}
    	int count=0;
    	for(char c : S.toCharArray()) {
    		if(set.contains(c)) {
    			count++;
    		}
    	}
    	return count;
    }

    /*
    A = [12, 28, 46, 32, 50]
	B = [50, 12, 32, 46, 28]
	We should return
	[1, 4, 3, 2, 0]
*/
    public int[] anagramMappings(int[] A, int[] B) {
    	Map<Integer> map = new HashMap<>();
    	for(int i=0; i< B.length; i++){
    		map.put(B(i), i);
    	}
    	//
    	int[] res = new int[A.length];
    	for(int i=0; i< A.length; i++){
    		res[i] = map.get(A[i]);
    	}
    	return res;
    }

    //s: "cbaebabacd" p: "abc"
    //Output:
    //[0, 6]
    public List<Integer> findAnagrams(String s, String p) {
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

    //
    public int firstUniqChar(String s) {
    	
    	int[] letters = new int[26];

    	for (int i=0; i<s.length(); i++) {
    		letters[s.charAt(i)-'a']++;
    	}

    	for(int i=0; i<s.length(); i++) {
    		if(letters[s.charAt(i)-'a']==1) {
    			return i;
    		}
    	}
    	return -1;
    }

    //
    public boolean isAnagram(String s, String t) {
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

    //
    public int[] intersection(int[] nums1, int[] nums2) {
    	Set<Integer> set = new HashSet<>();
        for(int num: nums1) {
            set.add(num);
        }
        //list for intersection
        List<Integer> list = new ArrayList<>();
        for(int num:nums2){
            if(set.contains(num)){
                list.add(num);
                set.remove(num);
            }
        }
        int[] result = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            result[i] = list.get(i);
        }
        return result;
    }

    //
    public int[] intersect(int[] nums1, int[] nums2) {
    	Map<Integer, Integer> map = new HashMap<>();
    	for(int num : nums1) {
    		map.put(num, map.getOrDefault(num,0) + 1);
    	}
    	//list for intersection
    	List<Integer> list = new ArrayList<>();
    	
    	for(int num : nums2) {
    		if(map.containsKey(num) && map.get(num)>0) {
    			map.put(num, map.get(num) -1);
    			list.add(num);
    			
    		} 
    	}
        int[] result = new int[list.size()];   
        for(int i=0; i<list.size(); i++){
            result[i] = list.get(i);
        }
    	return result;
    }

