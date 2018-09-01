 public class ZMathQs {
//Q1===========================================================================
    public int[] twoSum(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        while(l < r) {
            int sum = nums[l] + nums[r];
            if(sum == target){
                return new int[]{l+1, r+1};//index stars from 1, 2, ...
            } else if(sum > target) {
                r--;
            } else {
                l++;
            }
        }
        throw new RuntimeException();
    }

    //
    public boolean isUgly(int num) {
        //2,3,5
        //2, 3, 4, 5
        for(int i=2; i<6 && num>0; i++){
            while(num%i == 0) {
                num /= i;
            }
            
        }
        return num==1;
    }
    //23456%9=(2+3+4+5+6)%9
    public int addDigits(int num){
        if(num<10) {
            return num;
        } else if(num%9 ==0) {
            return 9;
            //the question asks the sum to be single-digit-and 9 is the largest single-digit number
        } else {
            return num%9;   
        }   
    }
    //
    public boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }

        while(n%3==0){
            n /= 3;
        }

        return n==1;
    }

    public boolean checkPrimeNumber(int number) { 
      if(number <= 1) { 
         return false; 
      } 
      //4

      for(int a = 2; a <= Math.sqrt(number); a++) { 
         if(number % a == 0) { 
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