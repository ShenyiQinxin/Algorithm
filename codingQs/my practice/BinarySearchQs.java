import java.util.*;
public class BinarySearchQs {

	/* return the indexes of two numbers when target equals 
	them adding up. 
	
	*/
	public static int[] twoSum(int[] nums, int target) {
		if(nums.length ==0 || nums ==null) {
			return null;
		}

		int l = 0, r = nums.length-1, mid = 0;
		while(l < r) {
			int sum = nums[l] + nums[r];
			if(sum == target) {
				return new int[]{l+1, r+1};
			} else if(sum>target){
				r--;
			} else {
				l++;
			}
		}
		return null;
	}

	/* Given n = 5, and version = 4 is the first bad version.
	call isBadVersion(3) -> false
	call isBadVersion(5) -> true
	call isBadVersion(4) -> true

	Then 4 is the first bad version. 
	*/
	public static boolean isBadVersion(int n) {
		if(n == 2 || n == 3) {
			return true;
		}
		return false;
	}
	public static int firstBadVersion(int n) {
		int l = 1, r = n, mid = 0;
		while(l<r) {
			mid = l + (r-l)/2;
			if(isBadVersion(mid)) {
				r = mid;
			} else {
				l = mid + 1;
			}
		}
		return l;
	}

	public static int binarySearch(int[] nums, int target) {
		if(nums.length == 0 || nums == null) {
			return -1;
		}
		int l = 0, r = nums.length-1, mid = 0;
		while(l <= r) {
			mid = l + (r-l)/2;
			if(nums[mid] == target) {
				return mid;
			} else if (nums[mid]>target) {
				r = mid -1;
			} else {
				l = mid+1;
			}
		}
		return -1;
	}

	/* square root of a positive number */
	public static int mySqrt(int x) {
		if(x==1) {
			return x;
		}
		int l=2, r=x, mid = 0;
		while(l<r) {
			mid = l + (r-l)/2;
			if(x/mid==mid) {
				return mid;
			} else if(x/mid<mid) {
				r = mid-1;
			} else {
				l = mid+1;
			}
		}// l>=r, r or l
		return l;
	}

	/* positive integer num, 16 true, 14 false */
	public static boolean isPerfectSquare(int num) {
		int l=1, r=num/2, mid=0;
		while(l<=r){
			mid = l+(r-l)/2;
			if(num/mid==mid){
				return true;
			}else if(num/mid<mid) {
				r = mid-1;
			}else {
				l=mid+1;
			}
		}
		return false;
	}

	/* nums is an array of sorted integers */
	public static int searchInsert(int[] nums, int target) {
		if(nums==null || nums.length==0) {
			return -1;
		}
		int l=0, r=nums.length-1, mid = 0;
		while(l <= r) {
			mid = l+(r-l)/2;
			if(nums[mid]==target){
				return mid;
			} else if(nums[mid]>target){
				r = mid-1;
			} else {
				l = mid+1;
			}
		}
		return l;
	}

	public static String longestCommonPrefix(String[] strs) {
		if(strs == null || strs.length == 0) {
			return "";
		}
		int minLength = Integer.MAX_VALUE;
		for(String str : strs) {
			minLength = Math.min(minLength, strs.length);
		}
		int l = 1, r = minLength, mid = 0;
		while(l <= r) {
			mid = l + (r-l)/2;
			if(isCommonPrefix(strs, mid)) {
				l = mid+1;
			} else {
				r = mid-1;
			}
		}
		return strs[0].substring(0, (l+r)/2);
	}

	public static boolean isCommonPrefix(String[] strs, int length){
		String str1 = strs[0].substring(0, length);
		for(int i=1; i<strs.length; i++) {
			if(!strs[i].startsWith(str1)) {
				return false;
			}
		}
		return true;
	}


	public static void main(String[] args) {
		int[] nums = new int[]{1, 2, 5, 40};
		String[] strs = {"abcd", "abc", "abcde", "a"};
		//int[] result = twoSum(nums, 5);
		// for(int e : result) {
		// 	System.out.print(e+" ");
		// }
		//System.out.println(firstBadVersion(5));
		//System.out.println(binarySearch(nums, 4));
		//System.out.println(mySqrt(9));
		//System.out.println(isPerfectSquare(14));
		//System.out.println(searchInsert(nums, 6));
		System.out.println(longestCommonPrefix(strs));
		System.out.println();
		System.out.println();
	}
}