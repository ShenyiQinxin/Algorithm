
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Stream;
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
	static void arrayToListStream(String[] a){
		//array -> arraylist
		ArrayList<String> arraylist = new ArrayList<>(Arrays.asList(a));
		arraylist.forEach(e -> System.out.print(e+" "));//
		System.out.println();
		//arraylist -> array
		String[] array = new String[arraylist.size()];
		arraylist.toArray(array);
		Stream<String> stream = Arrays.stream(array);
		stream.forEach(e ->  System.out.print(e+" "));//
		System.out.println();
	}
	public static void main(String[] args){
		arrayToList(new String[]{"ANDROID", 
			"JSP", "JAVA", "STRUTS", "HADOOP", "JSF"});
		arrayToListStream(new String[]{"ANDROID1", 
			"JSP1", "JAVA1", "STRUTS1", "HADOOP1", "JSF1"});
	}
}