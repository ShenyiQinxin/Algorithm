public class ZHashMapQs {

//Q1===========================================================================
	public int[] twoSum(int[] nums, int target) {
	    	Map<Integer> map = new HashMap<>();
	    	int rest = 0;
	    	for(int i=0; i< nums.length; i++){
	    		rest = target - mums[i];

	    		if(map.containsKey(rest)){
	    			return new int[]{map.get(rest), i}
	    		} else {
	    			map.put(nums[i], i);
	    		}
	    	}
	    	return new IllegalArgumentException("...");
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

        char[] a = s.toCharArray();
        int result = 0;
        int curr = 0;

        for(int i=0; i<a.length-1; i++){
        	curr = map.get(a[i]);
        	//II, VI
        	if(curr >= map.get(a[i+1]) || i==a.length-1) {
        		result += curr + a[i+1];
        	} else {//IV
        		result -= curr;
        	}
        }//for end
        return result;
    }


    public boolean isValid(String s) {
    	char[] a = s.toCharArray();
    	Map<Character, Character> map = new HashMap<>();
    	map.put('(', ')');
    	map.put('[',']');
        map.put('{','}');

        Stack<Character> stack = new Stack<>();
//( { 90 [ ]  } )
        for(Character c : a) {
        	if(map.containsKey(c)) {//(
        		stack.push(c);
        	} else if(map.values().contains(c)) {//)
        		if(!stack.isEmpty() && map.get(stack.peek()) == c) {//has ( in stack
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

    //
    public List<Integer> findAnagrams(String s, String p) {
    	List<Integer> result = new ArrayList<>();
    	int left = 0, right = 0, count = p.length();
    	int[] map = new int[256];//p ascii
    	char[] a = s.toCharArray();//s
    	for(char c : p.toCharArray()) map[c]++; //fill in the p map
    	while(right < s.length()) {
    		if(map[a[right++]]-- >=1) count--;//when find the 1st match char, expand the window
    		if(count == 0) result.add(left);//when count is consumed, the full p is found in s
    		if(right - left == p.length() && map[a[left++]]++ >=0) count++;
    		//when still match some of char, or window size is p length, 
    		//then decrease the window, and count++ till p.length
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
    	int[] counter = int[26];//26 letters
    	for (int i=0; i<s.length(); i++) {
    		counter[s.charAt(i)-'a']++;
    		counter[t.charAt(i)-'a']--;
    	}
    	for (int c: counter) {
    		if(c !=0) return false;
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

