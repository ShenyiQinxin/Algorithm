import java.text.DecimalFormat;
/**
*
* "Tiger Runs @ The Speed Of 100 km/hour."
*/
class IntegerString{
	
	static void characterPercentage(String s){
		int length = s.length();
		int upper = 0;
		int lower = 0;
		int digit = 0;
		int others = 0;
		for(int i=0; i<length; i++){
			char c = s.charAt(i);
			if(Character.isUpperCase(c)){
				upper++;
			} else if(Character.isLowerCase(c)){
				lower++;
			} else if(Character.isDigit(c)){
				digit++;
			} else {
				others++;
			}
		}//end for
		double upperPercentage = (upper*100.0)/length;
		double lowerPercentage = (lower*100.0)/length;
		double digitPercentage= (digit*100.0)/length;
		double othersPercentage = (others*100.0)/length;
		DecimalFormat formatter = new DecimalFormat("##.##");
		System.out.println(formatter.format(upperPercentage)+"%");
		System.out.println(formatter.format(lowerPercentage)+"%");
		System.out.println(formatter.format(digitPercentage)+"%");
		System.out.println(formatter.format(othersPercentage)+"%");
	}
	
	static void test(int n, char c){
		//string -> integer
		int i1 = Integer.parseInt(n+"");
		int i2 = Integer.valueOf(n+"");
		System.out.println("Convert string to integer: "+i1+", "+i2);
		//integer -> string
		String s1 = Integer.toString(n);
		String s2 = String.valueOf(n);
		System.out.println("Convert integer to string: "+s1+", "+s2);
		//Character to uppercase
		boolean upperChar = Character.isUpperCase(c);
		boolean lowerChar = Character.isLowerCase(c);
		boolean isDigit = Character.isDigit(c);
		System.out.println(upperChar+" : "+lowerChar+" : "+isDigit);
	}
	public static void main(String[] args){
		characterPercentage("Tiger Runs @ The Speed Of 100 km/hour.");
	}
	
}