public class StringQs {

	/* Given s = "hello", return "olleh". */
	public static String reverseString(String s) {
		char[] charArr = s.toCharArray();
		int l = 0, r = s.length()-1;
		for(int i=0; i<charArr.length-1; i++) {
			char temp = charArr[l];
			charArr[l] = charArr[r];
			charArr[r] = temp;
			l ++;
			r --;
		}
		return String.valueOf(charArr);
	}

	/* Input: "Let's take LeetCode contest"
	   Output: "s'teL ekat edoCteeL tsetnoc"
	*/
	public static String reverseWords(String s) {
		char[] array = s.toCharArray();
		int wordStart = 0;
		for(int i=0; i<= array.length; i++) {
			if(i == s.length() || array[i] == ' ') {
				reverseCharacters(array, wordStart, i-1);
				wordStart = i+1;
			}
		}
		return String.valueOf(array);
	}

	private static char[] reverseCharacters(char[] arr, int left, int right){
		while(left < right) {
			char temp = arr[right];
			arr[right] = arr[left];
			arr[left] = temp;
			left++;
			right--;
		}
		return arr;
	}

public static List<String> letterCasePermutation(String S) {
}



	public static void main(String[] args) {
		//System.out.println(reverseString("hello"));
		System.out.println(reverseWords("Let's take LeetCode contest"));
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
	}
}