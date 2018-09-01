public class Test {

	public static void main(String[] args){
		int num = 0;
		while(num<10){
		if(num<=1) System.out.println("n/a"+num);
		for (int i=2; i<=Math.sqrt(num); i++) {
			if(num%i==0) {System.out.println("composite"+num);}

		}
		System.out.println("Prime"+num);
		num++;
		}
	}
}