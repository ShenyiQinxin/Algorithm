

class SwapStringsNoTemp{
	
	static void swapStringsNoTemp(String s1, String s2){
		System.out.println(s1+" "+s2);
		s1 = s1+s2;
		s2 = s1.substring(0, s1.length()-s2.length());
		s1 = s1.substring(s2.length());
		System.out.println(s1+" "+s2);
		
	}
	public static void main(String[] args){
		swapStringsNoTemp("JAVA", "J2EE");
	}
}