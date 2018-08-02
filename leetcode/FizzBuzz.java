/*
Example:

n = 15,

Return:
[
    "1",
    "2",
    "Fizz",
    "4",
    "Buzz",
    "Fizz",
    "7",
    "8",
    "Fizz",
    "Buzz",
    "11",
    "Fizz",
    "13",
    "14",
    "FizzBuzz"
]
*/
import java.util.List;
import java.util.ArrayList;

public class FizzBuzz{
	public static List<String> fizzBuzz(int n){
		List<String> list = new ArrayList<>(n);
		for(int i=1; i<=n; i++){
			if(i%3 != 0 && i%5 != 0){
				list.add(String.valueOf(i));
			} else if(i%3 == 0 && i%5!=0){
				list.add("Fizz");
			} else if(i%3!=0 && i%5==0){
				list.add("Buzz");
			} else {
				list.add("FizzBuzz");
			}
		}
		return list;
	}

	public static void main(String[] args){
		System.out.println(fizzBuzz(15));
	}
}