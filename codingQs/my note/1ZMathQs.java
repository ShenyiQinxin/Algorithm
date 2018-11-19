 public class ZMathQs {


    /* ugly numbers are positive numbers 
    whose prime factors only include 2, 3, 5 */
    public static boolean isUgly(int num) {
        /* the candidate shoulbe be divisible to
         2, 3, 4, 5 */
        for(int i=2; i<=5 && num>0; i++) {
            while(num % i == 0) {
                num/=i;
            }
        }
        return num==1;
    }

    /*add the digits of num iteratively untill 
    there is only one digit left
    23456 -> ?
    23456%9=(2+3+4+5+6)%9
    all numbers are categorized in '<10', 
    '9divisible', '9not-divisible'
    */
    public static int addDigits(int num) {
        if(num < 10) {
            return num;
        } else if(num % 9 == 0) {
            
            return 9;
        } else {
            return num%9;
        }
    }

    /* 3^n 
    i.e. 1, 3, 9, 27 
    negative number is not
    */
    public static boolean isPowerOfThree(int n) {
        if(n < 0) {
            return false;
        }
        while(n%3==0) {
            n /= 3;
        }
        return n==1;
    }

    /* prime: 2, 3, 5, 7, 11 etc
    >=2 and not divisible */
    public static boolean checkPrimeNumber(int num) {
        if(num <= 1) {
            return false;
        }
        //4, ...
        for(int a=2; a<=Math.sqrt(num); a++) {
            if(num % a == 0) {
                return false;
            }
        }
        //2, 3
        return true;
    }
    
    //
    public int countPrimes(int n) {
       // isMultipleOfPrime[i] store whether num i is dividable by a prime num < i
        boolean[] isMultipleOfPrime = new boolean[n]; 
        // count of prime nums so far
        int count = 0;
        for (int i = 2; i < n; i++) {     // start from 2
            if (!isMultipleOfPrime[i]) {  // if i not dividable by a previous num, it's a prime
                count++;                  // count toward total num of primes seen so far
                for (int j=i; j<n; j=j+i) // mark all multiples of i as non-prime
                    isMultipleOfPrime[j] = true;
            }
        }
        return count;
    }
    
    
    //
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        while(n!=1) {
            int result = 0;
            while(n!=0){
                result += Math.pow(n%10,2);
                n/=10;
            }
            if(set.add(result)) {
                n=result;
            } else {
                return false;
            }
        }
        return true;
    }
//Q2==========================================================================
    public int reverse(int x) {
        int rev = 0;
        while(x != 0) {
            int pop = x%10;
            x /= 10;
            if(rev > Integer.MAX_VALUE/10 || (rev== Integer.MAX_VALUE/10 && pop>7)) return 0;
            if(rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE/10 && pop<-8)) return 0;
            rev = rev*10+pop;
        }
    }
    //
    public boolean isPalindrome(int x) {
        if(x<0 || (x%10==0 && x!=0)) return false;
        int reverted = 0;
        while(x > reverted) {
            reverted = reverted *10+ x%10;
            x/=10;
        }
        //for 12321, we get x=12, reverted = 123
        return x== reverted || x== reverted/10;
    }

    //
    public int trailingZeroes(int n) {
        return n<5 ? 0 : n/5 + trailingZeroes(n/5);
        
    }
//Q3==========================================================================    
    //
    public List<String> fizzBuzz(int n) {
        
        List<String> array = new ArrayList<>();
        for(int i=1; i<= n; i++){
            if(i%3==0 && i%5==0){
                array.add("FizzBuzz");
            } else if(i%3==0){
                array.add("Fizz");
            } else if(i%5==0){
                array.add("Buzz");
            } else {
                array.add(String.valueOf(i));
            }
        }
        return array;
    }
    //
    public boolean canWinNim(int n) {
        return n%4 !=0;
    }
    //
    public int missingNumber(int[] nums) {
        int expect = nums.length*(nums.length+1)/2;
        int actual = 0;
        for (int num : nums) {
            actual +=num;
        }
        return expect-actual;
    }
}