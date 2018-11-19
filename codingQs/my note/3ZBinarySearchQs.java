public class ZBinarySearchQs{
    //Q1===========================================================================
    public static int[] twoSum(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        while(l < r) {
            int sum = nums[l] + nums[r];
            if(sum == target) {
                return new int[] {l+1, r+1};//index stars from 1, 2, ...
            } else if (sum > target) {
                r--;
            } else {
                l++;

            }
        }
        return null;
    }
//===========================================================================
	class Solution extends VersionControl {
	    public int firstBadVersion(int n) {
	        int l = 1, r = n, mid = 0;
	        //if l==r, then return 1
	        while(l < r){
	        	mid = l + (r-l)/2;
	        	if(isBadVersion(mid)){
	        		r = mid;
	        	} else {
	        		l = mid+1;
	        	}
	        	
	        }
	        //l==r
	        return l;
	    }
	}

	//
    public int search(int[] nums, int target) {
    	if(nums==null || nums.length==0) return 0;
        int l=0, r=nums.length-1, mid = 0;
       //when l == r, it handles [5]
        while(l <= r){
            mid = l + (r-l)/2;
        	if(nums[mid] == target) {
        		return mid;
        	} else if (nums[mid] > target){
        		r = mid-1;
        	} else {
        		l = mid+1;
        	}
        }
        return -1;
    }
    //
    public int mySqrt(int x) {
    	if(x<=1) return x;

        int l=2, r=x;
        while(l < r){
        	int mid = l+(r-l)/2;
        	if(x/mid==mid){
        		return mid;
        	} else if(x/mid < mid){
        		r = mid-1;
        	} else {
        		l = mid+1;
        	}
        }
        //l>=r
        return r;
    }


    public int searchInsert(int[] nums, int target) {
    	if(nums == null||nums.length == 0) return 0;
        
        int l=0, r=nums.length-1;
        
        while(l <= r){
        	int mid = l+(r-l)/2;
        	if(nums[mid]==target){
        		return mid;
        	} else if(nums[mid]>target){
        		return r = mid-1;
        	} else {
        		l = mid+1;
        	}
        }
        // l > r
        return l;
    }


    public boolean isPerfectSquare(int num) {
    	
        int l=1, r=num/2;
        while(l<=r){
            //if 
        	int mid = l+(r-l)/2;
        	if(num/mid == mid){
        		return true;
        	} else if(num/mid < mid){
        		r= mid-1;
        	} else {
        		l = mid+1;
        	}
        }
        return false;

    }

    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length ==0) return "";
        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            minLength = Math.min(minLength, str.length());
        }
        int l = 1, r = minLength;
        while(l <= r) {
            int mid = l + (r - l)/2;
            if(isCommonPrefix(strs, mid)) {
                l = mid +1;//-->
            } else {
                r = mid -1;//<--
            }
        }
        return strs[0].substring(0,  (l+r)/2);
    }
    private boolean isCommonPrefix(String[] strs, int length){
        String str1 = strs[0].substring(0, length);
        for(int i=1; i< strs.length; i++){
            if(!strs[i].startsWith(str1)){
                return false;
            }
        }
        return true;
    }



