import java.util.*;

class Solutions {
    /**
     * i:0 1 2 3 4 5
     * 
     * 0 1 1 2 3 5 8
     * 
     */
    static int fibonacci(int size) {
        if (size == 0 || size == 1) {
            return size;
        }
        int[] nums = new int[size];
        nums[0] = 1;
        nums[1] = 1;
        for (int i = 2; i < size; i++) {
            nums[i] = nums[i - 1] + nums[i - 2];
        }
        return nums[size - 1];
    }

    static int fibRecursive(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }

    /**
     * i:0 1 2 3 4 5
     * 
     * 1 2 3 5 8 13
     */
    static int climbStairs(int size) {
        if (size == 1) {
            return 1;
        }
        int[] nums = new int[size];
        nums[0] = 1;
        nums[1] = 2;
        for (int i = 2; i < size; i++) {
            nums[i] = nums[i - 1] + nums[i - 2];
        }
        return nums[size - 1];
    }

    /**
     * remove dups in the array
     * 
     * @param not sorted nums = [0,0,1,1,1,2,2,3,3,4]
     * @return 5 and [0,1,2,3,4]
     */
    static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                j++;
                // replace nums[j] by nums[i]
                // move left
                nums[j] = nums[i];
            }
        }
        return 0;
    }

    /**
     * remove all 2s in the array
     * 
     * @param nums  =[0,1,2,2,3,0,4,2]]
     * @param val=2
     * @return length 5, [0,1,3,0,4]
     */
    static int removeElements(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (val == nums[i]) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

    /**
     * 
     * nums[i] : [0,1,0,3,12]
     * 
     * nums[j] : [1,3,12,0,0]
     */
    static void moveZeroes(int[] nums) {
        if (nums.length == 0) {
            return;
        }
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
    static void mergeSortedArray(int[] nums1, int n1, int[] nums2, int n2) {
        // index for arrays
        int m = n1 + n2 - 1;
        int m1 = n1 - 1;
        int m2 = n2 - 1;
        while (m >= 0) {
            if (nums1[m1] > nums2[m2]) {
                nums1[m--] = nums1[m1--];
            } else {
                nums1[m--] = nums2[m2--];
            }
            if (m1 < 0) {
                nums1[m--] = nums2[m2--];
                continue;
            }
            if (m2 < 0) {
                break;
            }
        }
        for (int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i] + " ");
        }
    }

    /**
     * Input: [1,2,3,4,5,6,7] and k = 3
     * 
     * Output: [5,6,7,1,2,3,4]
     * 
     */
    static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    static int[] reverse(int[] nums, int l, int r) {
        while (l < r) {
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
            l++;
            r--;
        }
        return nums;
    }

    static void rotate2(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int count = 0;
        for (int i = 0; count < n; i++) {
            int current = i;
            int prevNum = nums[i];
            do {
                int next = (current + k) % n;

                int tmp = nums[next];
                nums[next] = prevNum;
                prevNum = tmp;

                current = next;
                count++;
            } while (i != current);
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    /**
     * Input: "A man, a plan, a canal: Panama" Output: true
     * 
     * Input: "race a car"
     * 
     * Output: false
     * 
     */
    static boolean isPalindrome(String s0) {
        String s = s0.toLowerCase();
        if (s == null || s.length() == 0) {
            return true;
        }
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (!isValid(s.charAt(l))) {
                l++;
                continue;
            }
            if (!isValid(s.charAt(r))) {
                r--;
                continue;
            }
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    static boolean isValid(char c) {
        if (c >= '0' && c <= '9' || c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {
            return true;
        }
        return false;
    }

    /**
     * 
     * @param grid
     * @return isLands * 4 - neighbours * 2;
     */
    static int islandPerimeter(int[][] grid) {
        int isLands = 0, neighbours = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    isLands++;
                    if ((i < grid.length - 1) && (grid[i + 1][j] == 1)) {
                        neighbours++;
                    }
                    if ((j < grid.length - 1) && (grid[i][j + 1] == 1)) {
                        neighbours++;
                    }
                }
            }
        }
        return isLands * 4 - neighbours * 2;
    }

    /**
     * Given nums = [2, 7, 11, 15], target = 9,
     * 
     * Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
     * 
     */
    static int[] twoSum(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int sum = nums[r] + nums[l];
            if (sum == target) {
                return new int[] { l, r };
            } else if (sum > target) {
                r--;
            } else {
                l++;
            }
        }
        return null;
    }

    /**
     * k:v num:index
     * 
     */
    static int[] twoSumHashMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int key = 0;
        for (int i = 0; i < nums.length; i++) {
            key = target - nums[i];
            if (map.containsKey(key)) {
                return new int[] { map.get(key), i };
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }

    /**
     * Given a sorted (in ascending order) integer array nums of n elements and a
     * target value, write a function to search target in nums. If target exists,
     * then return its index, otherwise return -1.
     */
    static int binarySearch(int[] nums, int target) {
        if (nums.length == 0 || nums == null) {
            return 0;
        }
        int l = 0, r = nums.length - 1, mid = 0;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    /**
     * Input: "code"
     *
     * Output: false
     *
     * Input: "carerac"
     *
     * Output: true
     */
    static boolean canPermutePalindrome(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                set.remove(c);
            } else {
                set.add(c);
            }
        }
        return set.size() <= 1;
    }

    public static void main(String[] args) {

        System.out.println(canPermutePalindrome("cac"));

        // int[] nums = new int[] { 2, 7, 11, 15 };
        // System.out.println(binarySearch(nums, 11));

        // int[] nums = new int[] { 2, 7, 11, 15 };
        // int[] res = twoSumHashMap(nums, 9);
        // for (int i = 0; i < res.length; i++) {
        // System.out.print(res[i] + " ");
        // }

        // int[][] array = { { 0, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0,
        // 0 } };
        // System.out.println(islandPerimeter(array));

        // System.out.println(isPalindrome("A man, a plan, a canal: Panama"));

        // int[] nums1 = { 1, 2, 3, 4, 5, 6, 7 };
        // rotate2(nums1, 3);

        // int[] nums1 = { 1, 2, 3, 0, 0, 0 };
        // int[] nums2 = { 2, 5, 6 };
        // mergeSortedArray(nums1, 3, nums2, 3);

        // int[] nums = { 0, 1, 0, 3, 12 };
        // moveZeroes(nums);
        // int[] nums = new int[] { 0, 1, 3, 2, 1, 2, 2, 3, 3, 4 };
        // System.out.println(removeDuplicates(nums));

        // int[] nums = new int[] { 0, 1, 2, 2, 3, 0, 4, 2 };
        // System.out.println(removeElements(nums, 2));

        for (int i = 1; i < 7; i++) {
            // System.out.print(fibonacci(i) + " ");
        }

        // System.out.println();
        // for (int i = 1; i < 7; i++) {
        // System.out.print(fibRecursive(i) + " ");
        // }

        // System.out.println();
        for (int i = 1; i < 7; i++) {
            // System.out.print(climbStairs(i) + " ");
        }
    }

}