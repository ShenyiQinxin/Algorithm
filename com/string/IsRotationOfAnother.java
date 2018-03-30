

class IsRotationOfAnother{
	
	static void isRotationOfAnother(String s1, String s2){
		if(s1.length() != s2.length()){
			System.out.println(s2+" is not a rotated "+s1);
		}
		String s3 = s1+s1;
		if(s3.contains(s2)){
			System.out.println(s2 +" is a rotated "+s1);
		}
	}
	public static void main(String[] args){
		isRotationOfAnother("JavaJ2eeStrutsHibenate", "StrutsHibernateJavaJ2ee");
	}
}