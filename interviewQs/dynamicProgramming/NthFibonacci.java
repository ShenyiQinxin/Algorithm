
//0,1,1,2,3,5,8,13,21...
/*
fib(0);  // => 0
fib(1);  // => 1
fib(2);  // => 1
fib(3);  // => 2
fib(4);  // => 3
...
  fib(n) = fib(n - 1) + fib(n - 2);
*/
public NthFibonacci{
	
	public static int fib(int n){
		if(n<0){
			throw new IllegalArgumentException("Index was negative. No such thing as a negative index in a series.");
		} else if(n==0 || n==1){
			return n;
		}
		//0th prePrev is 0
		//1st prev is 1
		//2nd current initialized
		//start from 2nd to nth 
		//the addtion of 0th and 1st is the 2nd
		//thus nth fib number could be calculated
		int prevPrev = 0;
		int prev = 1;
		int current = 0;
		for(int i=2; i<=n; i++){
			current = prev + prevPrev; //1
			prevPrev = prev; // 1
			prev = current; //1
		}
		return current;
		
	}//end method
	
    public static int fibRecursive(int n) {
      if (n == 0 || n == 1) {
          return n;
      }
      return fibRecursive(n - 1) + fibRecursive(n - 2);
  }
}

/*

*/