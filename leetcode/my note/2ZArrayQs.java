public class ZArrayQs {

//Q1==========================================================================
    public int climbStairs(int n) {
        if(n==1) return 1;
        int[] ways = new int[n+1];
        ways[1] = 1;
        ways[2] = 2;
        for(int i=3; i<=n; i++){
            ways[i] = ways[i-1] + ways[i-2];
        }
        return ways[n];
    }

    /**
    fib(0);  // => 0
    fib(1);  // => 1
    fib(2);  // => 1
    fib(3);  // => 2
    fib(4);  // => 3
    ...
      fib(n) = fib(n - 1) + fib(n - 2);
    */

    public int fib(int n) {
        if(n ==0 || n==1) {
            return n;
        }
        int[] nums = new int[n+2];
        nums[0] = 0;
        nums[1] = 1;
        for (int i=2; i<=n; i++) {
            nums[i] = nums[i-1] + nums[i-2];
        }
        return nums[n];
    }

    public int fibRecursive(int n){
        if(n<=1) return n;
        return fibRecursive(n-1)+fibRecursive(n-2);
    }

//Q2==========================================================================
    //remove val in nums[]
    public int removeElement(int[] nums, int val) {
        int j=0;
        for (int i=0; i<nums.length; i++) {
            if(nums[i] != val) {
                nums[j] =nums[i];//nums[i] is kept and move to nums[j], where j is the new array index
                j++;//j = 0, 1, 2...
            }
        }
        return j;
    }

    //remove dups in sorted nums[]
    public int removeDuplicates(int[] nums) {
        if(nums.length ==0) return 0;
        int j = 0;
        for(int curr = 1; curr<nums.length; i++){
            if(nums[j] != nums[curr]) {
                
                nums[j] =nums[curr];
                //update/move forward the last num
                j++;
            }
        }
        return j+1;
    }


    //move 0s to the end
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i=0; i<nums.length; i++) {
            if(nums[i] !=0) {
                nums[j] = nums[i];
                j++;
            }
        }
        for(int i= j; i<nums.length; i++) {
            nums[i]=0;
        }
    }
//Q3===========================================================================
//1
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        //If k >= n, rotating k times has the same effect as rotating k % n times.
        k = k% n;
        for (int start =0; count<n; start++) {
            int curr = start;
            int prevNum = nums[start];
            do{
                int next = (curr+k)%n;//jump the next k index
                int temp = nums[next];
                nums[next] = prevNum;
                prevNum = temp;
                curr = next;
                count++;
            } while (start != curr);
        }
        
    }
    //2
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
      
        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
    }
    
    private void reverse(int[] nums, int l, int r){
        while(l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }

//Q4===========================================================================
    public int[] plusOne(int[] digits) {
    	int len = digits.length;
    	for(int i=digits.length-1; i>=0; i--) {
    		if(digits[i] <9){
    			digits[i]++;
    			return digits;
    		}
    		digits[i] =0;//digits[i] was 9
    	}
    	int[] res = new int[len+1];//all 9
    	res[0] = 1;
    	return res;
    }

    //4 = min(1, 2) + min(3, 4)
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i=0; i<nums.length; i+=2) {
            sum +=nums[i];
        }
        return sum;
    }

    //
    public int islandPerimeter(int[][] grid) {
        int islands =0, neighbours = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j]==1){
                    islands++;
                    //down neighbours
                    if(i<grid.length-1 && grid[i+1][j]==1) neighbours++;
                    //right neighbours
                    if(j<grid[i].length-1 && grid[i][j+1]==1) neighbours++;
                }
            }
        }
        //each island 4, each neighbour cancel 2
            return islands * 4 - neighbours * 2;
        
    }
//Q5===========================================================================
    public void merge(int[] nums1, int m, int[] nums2, int n) {
    	int merged = m+n-1;
    	int first = m-1;
    	int second = n-1;
    	while(merged >= 0) {
    		
    		if(nums1[first] > nums2[second]) {
    			nums1[merged--] = nums1[first--];
    		} else {
    			nums1[merged--] = nums2[second--];
    		}
    		//nums1 runs out
    		if(first < 0) {
    			nums[merged--] = nums2[second--];
    			continue;
    		}
            //nums2 runs out
    		if(second <0){
    			break;
    		}
    	}
    }

    

    //two pointers
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

    public boolean isPalindrome(String s0) {
        String s = s0.toLowerCase();
        if(s.length()==0 || s== null) {
            return true;
        }
        while(l < r) {
            if(!isvalid(s.charAt(l))) {
                l++;
                continue;
            }   
            if(!isvalid(s.charAt(r))) {
                r--;
                continue;
            }   
            if(s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        
    }

    private boolean isvalid(char c) {
        if(c>='0'&&c<='9' || c>='a'&&c<='z' || c>='A' && c<='Z') {
            return true;
        }
        return false;
    }
}



    
