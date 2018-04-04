import java.util.HashSet;

class DupElements{

	static void dupElements(String[] arr){
		HashSet<String> set = new HashSet<>();
		for(String e: arr){
			if(!set.add(e)){//dup
				System.out.print(e+" ");
			}
		}
		System.out.println();
	}
	
	public static void main(String[] args){
		String[] arr = {"Java", "JSP", "Java", "JAVA", "jsp", "jsp"};
		dupElements(arr);
	}
}