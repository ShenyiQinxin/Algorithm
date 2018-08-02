/**
Write a function that takes a string as input and returns the string reversed.

Example:
Given s = "hello", return "olleh".
*/
import java.util.Arrays;

public class ReverseString{

	public static String reverseString(String s){
		char[] array = s.toCharArray();
		int left =0;
		int right = array.length-1;
		for(int i=0; i<array.length/2; i++){
			char temp = array[right];
			array[right] = array[left];
			array[left] = temp;
			left ++;
			right --;
		}
		String reversed = Arrays.toString(array);
		return reversed;
	}

	public static void main(String[] args){
		System.out.println(reverseString("hello"));
	}
}