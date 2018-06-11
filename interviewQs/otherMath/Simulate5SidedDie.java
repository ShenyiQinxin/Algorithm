/*
rand7() returns each integer with equal probability.
rand5() must also return each integer with equal probability.

We simply "re-roll" whenever we get a number greater than 5
*/

public Simulate5SidedDie{
	public static int rand5() {
	    int result = 7;  // arbitrarily large
	    while (result > 5) {
	        result = rand7();
	    }
	    return result;
	}
}