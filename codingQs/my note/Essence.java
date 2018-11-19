public class Essence {

}


class Reverse {
	//return void or char[] is the same thing, cus the array is changed essentially
	public void reverseArray(int[] nums, int l, int r){
		while(l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
	}


    public char[] reverseCharacters(char[] arr, int left, int right){
        
        while(left < right){
            char temp = arr[right];
            arr[right] = arr[left];
            arr[left] = temp;
            left++;
            right--;
        }
        return arr;
    }

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

   
}

class BinarySearch {
	 public int search(int[] nums, int target) {
    	if(nums==null || nums.length==0) return 0;

        int l=0, r=nums.length-1;
       
        while(l <= r){
             int mid = (r+l)/2;
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
}