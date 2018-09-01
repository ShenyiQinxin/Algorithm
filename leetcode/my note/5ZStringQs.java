public class ZStringQs {
//Q1==========================================================================
    public String reverseString(String s) {
        char[] charArr = s.toCharArray();
        int left =0;
        int right =charArr.length-1;
        for(int i=0; i<charArr.length/2; i++){
            char temp = charArr[left];
            charArr[left] = charArr[right];
            charArr[right] = temp;
            left ++;
            right --;
        }
        return String.valueOf(charArr);
    }
}

public String reverseWords(String s) {
        char[] array = s.toCharArray();
        //reverseCharacters(array, 0, s.length()-1);
        int wordStart = 0;
        for(int i=0; i<=array.length; i++){
            if(i==s.length() || array[i] == ' '){
               reverseCharacters(array, wordStart, i-1);
                wordStart=i+1;
            }
        }
        return String.valueOf(array);
    }
    
    private char[] reverseCharacters(char[] arr, int left, int right){
        
        while(left < right){
            char temp = arr[right];
            arr[right] = arr[left];
            arr[left] = temp;
            left++;
            right--;
        }
        return arr;
    }

    
//Q2==========================================================================
    

   public List<String> letterCasePermutation(String S) {
   		List<StringBuilder> result = new ArrayList<>();
   		result.add(new StringBuilder());

   		for(char c : S.toCharArray()) {
   			int n = result.size();//n = 0, 1, 2, ...
   			if(Character.isLetter(c)) {
   				for (int i=0; i<n; i++) {
   					result.add(new StringBuilder(result.get(i)));//double
   					result.get(i).append(Character.toLowerCase(c));//first half lowercase
   					result.get(n+i).append(Character.toUpperCase(c));//last half uppercase
   				}
   			} else {
   				for(int i=0; i<n; i++) {
   					result.get(i).append(c);//every string is appended c
   				}
   			}
   		}
   }

  
  public static Set<String> getPermutations(String s) {

    // base case
    int n = s.length();
    if (n <= 1) {
        return new HashSet<>(Collections.singletonList(s));
    }

    String preLast = s.substring(0, n - 1);
    char lastChar = s.charAt(n - 1);

    // recursive call: get all possible permutations for all chars except last
    Set<String> ps = getPermutations(prelast);

    // put the last char in all possible positions for each of the above permutations
    Set<String> set = new HashSet<>();
    for (String p : ps) {
        for (int i = 0; i <= preLast.length(); i++) {
          //lastChar put in i:0, 1, ..
            String permutation = p.substring(0, i) + lastChar
                + p.substring(i);
            set.add(permutation);
        }
    }

    return set;
  }

//Q3==========================================================================
  public int strStr(String haystack, String needle) {
      if(needle == null || haystack == null ||
       	haystack.length() < needle.length()) return -1; 

      if(needle.length() == 0) return 0;

   		for (int i=0; i<=haystack.length()-needle.length(); i++) {
   			//suppose i is the start index of the needle in haystack
   			if(haystack.substring(i, i+needle.length()).equals(needle)) {
   				return i;
   			}
   		}
   		return -1;
    }

	 //AB -> 1*26+2 -> i*26+j
  public int titleToNumber(String s) {
	 	int result = 0;
	 	for (int i=0; i<s.length(); i++) {
	 		int num = s.charAt(i)-'A'+1;
	 		result = result*26 + num;
	 	}
	 	return result;
	 }

  public boolean judgeCircle(String moves) {
    	int x=0, y=0;
    	for(char move: moves.toCharArray()) {
    		if(move=='U') y--;
    		else if(move == 'D') y++;
    		else if(move == 'L') x--;
    		else if(move == 'R') x++;
    	}
    	return x==0 && y==0;
  }
