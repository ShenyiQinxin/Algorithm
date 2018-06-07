
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
class ArrayToList{
	
	static void arrayToList(String[] arr){
		//
		List<String> list = Arrays.asList(arr);
		System.out.println(list);
		//
		ArrayList<String> alist = new ArrayList<>(list);
		System.out.println(alist);
		//
		String[] array = new String[alist.size()];
		alist.toArray(array);
		for(String s: array){
			System.out.print(s+" ");
		}
		System.out.println();
	}
	public static void main(String[] args){
		arrayToList(new String[]{"ANDROID", 
			"JSP", "JAVA", "STRUTS", "HADOOP", "JSF"});
	}
}