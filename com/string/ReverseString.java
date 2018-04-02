import java.lang.StringBuffer;

public class ReverseString{
	
	static String reverseStringBuffer(String s){
		StringBuffer sb = new StringBuffer(s);
		return sb.reverse().toString();
	}
	
	static void reverseIterative(String s){
		char[] sArr = s.toCharArray();
		for(int i=sArr.length-1; i>=0; i--){
			System.out.print(sArr[i]);
		}
		System.out.println();
	}
	
	static String reverseRecursive(String s){
		if(s== null || s.length()<=1){
			return s;
		}
		
		return reverseRecursive(s.substring(1))+s.charAt(0);
	}

	public static void main(String[] args){
		//System.out.println(reverseStringBuffer("MyJava"));
		//reverseIterative("MyJava");
		System.out.println(reverseRecursive("MyJava"));
	}
}