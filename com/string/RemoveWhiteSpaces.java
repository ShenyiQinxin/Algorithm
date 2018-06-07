


class RemoveWhiteSpaces{

	static void removeWhiteSpaces(String s){
		String sNoSpace = s.replaceAll("\\s", "");
		System.out.println(sNoSpace);
	}

	static void removeWhiteSpacesIterative(String s){
		char[] chars = s.toCharArray();
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<chars.length; i++){
			if((chars[i]!=' ') && (chars[i]!='\t')){
				sb.append(chars[i]);
			}
		}
		System.out.println(sb);
	}

	public static void main(String[] args){
		String s = "   Core Java jsp servlets      jdbc struts hibernate spring  ";
		removeWhiteSpaces(s);
		removeWhiteSpacesIterative(s);
	}
}