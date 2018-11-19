import java.util.*;

public class StringQs {

	public static String reverseString(String str) {
		char[] charArr = str.toCharArray();
		int left = 0;
		int right = charArr.length - 1;
		for(int i=0; i<charArr.length/2; i++) {
			
		}
	}

	public static List<String> letterCasePermutation(String str) {
		List<String> ans = new ArrayList<>();
		dfs(str.toCharArray(), 0, ans);
		return ans;
	}

	private static void dfs(char[] str, int i, List<String> ans) {
		if(i == str.length) {
			ans.add(new String(str));
			return;
		} //a1b2
		
		/**
		         a1b2
		      a1b2, A1b2
		      a1b2, A1b2
		a1b2, a1B2, A1b2, A1B2
		*/
		
		dfs(str, i+1, ans); 
		if(!Character.isLetter(str[i])) return;
		str[i] ^= 1 << 5; //a1b2, A1b2. //a1b2, a1B2
		dfs(str, i+1, ans); 
		//a1b2, A1b2  //A1b2, A1B2
	}

	public static void main(String[] args) {
		System.out.println(letterCasePermutation("a1b2c3"));
	}
}
	
