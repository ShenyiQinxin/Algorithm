

public NthFibonacci{
	
	public static int fib(int n){
		if(n<0){
			throw new IllegalArgumentException("Index was negative. No such thing as a negative index in a series.");
		} else if(n==0 || n==1){
			return n;
		}
		int prevPrev = 0;
		int prev = 0;
		int current = 0;
		for(int i=1; i<n; i++){
			current = prev + prevPrev;
			prevPrev = prev;
			prev = current;
		}
		return current;
	}//end method
	
}