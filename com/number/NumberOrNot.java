

class NumberOrNot{
	static boolean numberOrNot(String s){
		try{
			Integer.parseInt(s);
		}catch(NumberFormatException ex){
			return false;
		}
		return true;
	}

	public static void main(String[] args){
		System.out.println(numberOrNot("77")+" "+numberOrNot("abc"));
	}
}