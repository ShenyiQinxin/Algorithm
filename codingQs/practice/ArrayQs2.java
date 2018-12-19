import java.util.*;

public class ArrayQs2 {

	public static int climbStairs(int n) {
		if(n == 1) {
			return 1;
		}
		int[] ways = new int[n+1];
		ways[1] = 1;
		ways[2] = 2;
		for(int i=3; i<=n; i++) {
			ways[i] = ways[i-1] + ways[i-2];
		}
		return ways[n];
	}
	public static int fib(int n) {
		if(n == 0 || n==1) {
			return n;
		}
		int[] nums = new int[n+2];
		nums[0] = 0;
		nums[1] = 1;
		for(int i=2; i<=n; i++) {
			nums[i] = nums[i-1] + nums[i-2];
		}
		return nums[n];
	}
	public static int fibRecursive(int n) {
		if(n <= 1) {
			return n;
		}
		return fibRecursive(n-1) + fibRecursive(n-2);
	}
	public static int removeElement(int[] nums, int val) {
		if(nums.length == 0) {
			return -1;
		}
		int j=0;
		for(int i=0; i<nums.length; i++) {
			if(nums[i] != val) {
				nums[j] = nums[i];
				j++;
			}
		}
		return j;

	}
	public static int removeDuplicates(int[] nums) {
		if(nums.length == 0) {
			return 0;
		}
		int j=0;
		for(int i=1; i<nums.length; i++) {
			if(nums[j] != nums[i]) {
				j++;
				nums[j] = nums[i];
			}
		}
		return j+1;
	}
	public static int[] moveZeroes(int[] nums) {
		int j=0;
		for(int i=0; i<nums.length; i++) {
			if(nums[i] != 0) {
				nums[j] = nums[i];
				j++;
			}
		}
		for(int i=j; i<nums.length; i++) {
			nums[i] = 0;
		}
		return nums;
	}

	public static int[] rotate(int[] nums, int k) {
		int n = nums.length;
		k %= n;
		reverse(nums, 0, n-1);
		reverse(nums, 0, k-1);
		reverse(nums, k, n-1);
		return nums;
	}

	private static void reverse(int[] nums, int l, int r){
		while(l < r) {
			int temp = nums[l];
			nums[l] = nums[r];
			nums[r] = temp;
			l++;
			r--;
		}
	}
	public static int[] plusOne(int[] digits) {
		int length = digits.length;
		for(int i=length-1; i>=0; i--) {
			if(digits[i] <9) {
				digits[i]++;
				return digits;
			}
			digits[i] = 0;
		}
		int[] carry = new int[length+1];
		carry[0] = 1;
		return carry;
	}
	public static int arrayPairSum(int[] nums) {
		Arrays.sort(nums);
		int sum = 0;
		for(int i=0; i<nums.length; i+=2) {
			sum += nums[i];
		}
		return sum;
	}
	public int islandPerimeter(int[][] grid) {
		int islands =0, neighbours =0;
		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid[i].length; j++) {
				if(grid[i][j] == 1) {
					islands++;
					if(i<grid.length-1 && grid[i+1][j]==1) {
						neighbours++;
					}
					if(j<grid[i].length-1 && grid[i][j+1]==1) {
						neighbours++;
					}
				}
			}
		}
		return islands*4 - neighbours*2;
	}
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int merged = m+n-1;
		int first = m-1;
		int second = n-1;
		while(merged >=0) {
			if(first  <= 0) {
				nums1[merged--] = nums2[second--];
				continue;
			}
			if(second<0) {
				break;
			}
			if(nums1[first] > nums2[second]) {
				nums1[merged--] = nums2[first--];
			} else {
				nums1[merged--] = nums2[second--];
			}
		}
	}
	public static boolean isPalindrome(String s0) {
		String s = s0.toLowerCase();
		if(s.length() == 0 || s == null) {
			return true;
		}
		int l=0, r=s0.length()-1;
		while(l<r) {
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
		return false;
	}
	private static boolean isvalid(char c) {
		if(c>='0'&&c<='9' || c>='a'&&c<='z' || c>='A' && c<='Z') {
            return true;
        }
        return false;
	}

	public static void main(String[] args) {

	}
}
