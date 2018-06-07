import java.util.HashSet;

class DupElements{
	
	
	static void dupElements(String[] arr){
		HashSet<String> set = new HashSet<>();
		for(String a:arr){
			if(!set.add(a)){
				System.out.print(a+" ");
			}
		}
		System.out.println();
	}
	public static void main(String[] args){
		String[] arr = {"Java", "JSP", "Java", "JAVA", "jsp", "jsp"};
		dupElements(arr);
	}
}