import java.util.Arrays;
import java.util.ArrayList;

class ArrayToList{
	
	static void arrayToList(String[] arr){
		//array -> arraylist
		ArrayList<String> al = new ArrayList<>(Arrays.asList(arr));
		System.out.println(al);
		//arraylist -> array
		String[] array = new String[al.size()];
		al.toArray(array);
		for(String a: array){
			System.out.println(a+" ");
		}
	}
	
	public static void main(String[] args){
		String[] arr = new String[]{"ANDROID", 
			"JSP", "JAVA", "STRUTS", "HADOOP", "JSF"};
		arrayToList(arr);
	}
}