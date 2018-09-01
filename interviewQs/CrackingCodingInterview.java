public class CrackingCodingInterview{
	//array
	public static boolean isUniqueChars(String inputString){
		if(inputString.length()>128){
			return false;
		}
		boolean[] charSet = new boolean[128];
		for(int i=0; i<str.length(); i++){
			int c = inputString.charAt(i);
			
			//if the value is true, we meet this c again, 
			//then there are non-unique chars
			if(charSet[c]){
				return false;
			}
			//flag the value of this c as true
			charSet[c] = true;
		}
	}
	
	public static boolean checkPermutation(String s1, String s2){
		if(s1.length != s2.length){
			return false;
		}
		
		for(char c:s1.toCharArray()){
			//char -> int
			letter[c]++;
		}
		for(char c:s2.toCharArray()){
			letter[c]--;
			if(letter[c]<0){
				return false;
			}
		}
		return true;
	}
	
	public static String sort(String inputString){
		char[] sortedCharArray = Arrays.sort(inputString.toCharArray());
		return new String(sortedCharArray);
	}
	public static boolean checkPermutationSorting(String s1, String s2){
		if(s1.length != s2.length){
			return false;
		}
		return sort(s1).equals(sort(s2));
	}
	
	public static void replaceSpaces(char[] str, int length){
		int spaceCount = 0, newLength;
		for(int i=0; i<length; i++){
			if(str[i] == ' '){
				spaceCount++;
			}
		}
		newLength = length + spaceCount*2;
		for(int i=length-1; i>=0; i--){
			if(str[i] == ' '){
				str[newLength-1] = '0';
				str[newLength-2] = '2';
				str[newLength-3] = '%';
				newLength = newLength-3;
			} else {
				//newLength is in sync with length
				str[newLength-1] = str[i];
				newLength --;
			}
		}
		
	}
	
	public static boolean hasPalindromePermutation(String theString){
		//if there are repeated characters, and only one unique character, then
		//theString is a palindrom permutation
		for(char c: theString.toCharArray){
			if(unpairedCharacters.contains(c)){
				unpairedCharacters.remove(c);
			} else {
				unpairedCharacters.add(c);
			}
		}
		return unpairedCharacters.size() <=1;
	}
	
	
	public static boolean oneEditReplace(String s1, String s2) {
			boolean foundDifference = false;
			for (int i = 0; i < s1.length(); i++) {
				if (s1.charAt(i) != s2.charAt(i)) {
					if (foundDifference) {
						return false;
					}
				
					foundDifference = true;
				}
			}
			return true;
		}
	
		/* Check if you can insert a character into s1 to make s2. */
	public static boolean oneEditInsert(String s1, String s2) {
			int index1 = 0;
			int index2 = 0;
			while (index2 < s2.length() && index1 < s1.length()) {
				if (s1.charAt(index1) != s2.charAt(index2)) {
					if (index1 != index2) {
						return false;
					}		
					index2++;
				} else {
					index1++;
					index2++;
				}
			}
			return true;
		}	
	
	public static boolean oneEditAway(String first, String second) {
			if (first.length() == second.length()) {
				return oneEditReplace(first, second);
			} else if (first.length() + 1 == second.length()) {
				return oneEditInsert(first, second);
			} else if (first.length() - 1 == second.length()) {
				return oneEditInsert(second, first);
			} 
			return false;
		}
	
	
	public static String compress(String str) {
				StringBuilder compressed = new StringBuilder();
				int countConsecutive = 0;
				for (int i = 0; i < str.length(); i++) {
					countConsecutive++;
			
					/* If next character is different than current, append this char to result.*/
					if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
						compressed.append(str.charAt(i));
						compressed.append(countConsecutive);
						countConsecutive = 0;
					}
				}
				return compressed.length() < str.length() ? compressed.toString() : str;
	}
	
	public static boolean isSubstring(String big, String small) {
			if (big.indexOf(small) >= 0) {
				return true;
			} else {
				return false;
			}
		}
	
	public static boolean isRotation(String s1, String s2) {
		    int len = s1.length();
		    /* check that s1 and s2 are equal length and not empty */
		    if (len == s2.length() && len > 0) { 
		    	/* concatenate s1 and s1 within new buffer */
		    	String s1s1 = s1 + s1;
		    	return isSubstring(s1s1, s2);
		    }
		    return false;
	}
	
	//linked list 
	public static LinkedListNode partition(LinkedListNode node, int x) {
			LinkedListNode head = node;
			LinkedListNode tail = node;
		
			/* Partition list */
			while (node != null) {
				LinkedListNode next = node.next;
				if (node.data < x) {
					/* Insert node at head. */
					node.next = head;
					head = node;
				} else {
					/* Insert node at tail. */
					tail.next = node;
					tail = node;
				}	
				node = next;
			}
			tail.next = null;
		
			return head;
	}
	//01210
	public static boolean isPalindrome(LinkedListNode head) {
			LinkedListNode fast = head;
			LinkedListNode slow = head;
		
			Stack<Integer> stack = new Stack<Integer>();
		
			while (fast != null && fast.next != null) {
				stack.push(slow.data);
				slow = slow.next;
				fast = fast.next.next;			
			}
		
			/* Has odd number of elements, so skip the middle */
			if (fast != null) { 
				slow = slow.next;
			}
		
			while (slow != null) {
				int top = stack.pop().intValue();
				if (top != slow.data) {
					return false;
				}
				slow = slow.next;
			}
			return true;
	}
	//intersection
	public static class Result {
			public LinkedListNode tail;
			public int size;
			public Result(LinkedListNode tail, int size) {
				this.tail = tail;
				this.size = size;
			}
		}
	
		public static Result getTailAndSize(LinkedListNode list) {
			if (list == null) return null;
		
			int size = 1;
			LinkedListNode current = list;
			while (current.next != null) {
				size++;
				current = current.next;
			}
			return new Result(current, size);
		}
	
		public static LinkedListNode getKthNode(LinkedListNode head, int k) {
			LinkedListNode current = head;
			while (k > 0 && current != null) {
				current = current.next;
				k--;
			}
			return current;
		}
	
		public static LinkedListNode findIntersection(LinkedListNode list1, LinkedListNode list2) {
			if (list1 == null || list2 == null) return null;
		
			/* Get tail and sizes. */
			Result result1 = getTailAndSize(list1);
			Result result2 = getTailAndSize(list2);
		
			/* If different tail nodes, then there's no intersection. */
			if (result1.tail != result2.tail) {
				return null;
			}
		
			/* Set pointers to the start of each linked list. */
			LinkedListNode shorter = result1.size < result2.size ? list1 : list2;
			LinkedListNode longer = result1.size < result2.size ? list2 : list1;
		
			/* Advance the pointer for the longer linked list by the difference in lengths. */
			longer = getKthNode(longer, Math.abs(result1.size - result2.size));
		
			/* Move both pointers until you have a collision. */
			while (shorter != longer) {
				shorter = shorter.next;
				longer = longer.next;
			}
		
			/* Return either one. */
			return longer; 
		}
	
	
	
}