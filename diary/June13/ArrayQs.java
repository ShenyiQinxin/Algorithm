
public class ArrayQs {
    static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        int[] nums = new int[n + 1];
        nums[1] = 1;
        nums[2] = 1;
        for (int i = 3; i < n + 1; i++) {
            nums[i] = nums[i - 2] + nums[i - 1];
        }
        return nums[n];
    }

    static int fibRecursive(int n) {
        if (n <= 1) {
            return n;
        }
        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }

    static int climbStairs(int n) {
        if (n == 1) {
            return n;
        }
        int[] nums = new int[n + 1];
        nums[1] = 1;
        nums[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            nums[i] = nums[i - 2] + nums[i - 1];
        }
        return nums[n];
    }

    /**
     * nums = [0,0,1,1,1,2,2,3,3,4] , return the length 5
     */
    static int removeDuplicatesSorted(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[j] != nums[i]) {
                j++;
                nums[j] = nums[i];
            }
        }
        return j + 1;
    }

    /**
     * Given nums = [0,1,2,2,3,0,4,2], val = 2, , return the length 5
     */
    static int removeElements(int[] nums, int val) {
        int j = 0; // j points to val of 2
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

    /**
     * Input: [0,1,0,3,12] , Output: [1,3,12,0,0]
     */
    static void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    /**
     * Input:
     *
     * nums1 = [1,2,3,0,0,0], m = 3
     *
     * nums2 = [2,5,6], n = 3
     *
     * Output: [1,2,2,3,5,6]
     */
    static void merge(int[] nums1, int m, int[] nums2, int n) {
        int merged = m + n - 1;
        int first = m - 1;
        int second = n - 1;
        while (merged >= 0) {
            if (nums1[first] > nums2[second]) {
                nums1[merged--] = nums1[first--];
            } else {
                nums1[merged--] = nums2[second--];
            }
            if (first < 0) {
                nums1[merged] = nums2[second--];
                continue;
            }
            if (second < 0) {
                break;
            }
        }
        for (int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i]);
        }
    }

    /**
     * input: [1,2,3,4,5,6,7] and k = 3
     * 
     * Output: [5,6,7,1,2,3,4]
     */
    static int[] reverse(int[] nums, int l, int r) {
        while (l < r) {
            int tmp = nums[r];
            nums[r] = nums[l];
            nums[l] = tmp;
            l++;
            r--;
        }
        return nums;
    }

    static void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 2, 3, 4, 5, 6, 7 };
        rotate(nums, 3);
    }

}