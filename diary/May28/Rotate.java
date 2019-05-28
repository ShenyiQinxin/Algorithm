/**
 * Input: [1,2,3,4,5,6,7] and k = 3 Output: [5,6,7,1,2,3,4] Explanation: rotate
 * 1 steps to the right: [7,1,2,3,4,5,6] rotate 2 steps to the right:
 * [6,7,1,2,3,4,5] rotate 3 steps to the right: [5,6,7,1,2,3,4]
 */
class Rotate {
    static void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    static int[] reverse(int[] nums, int l, int r) {
        while (l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
        return nums;
    }

    /**
     * 1 2 3 4 5 6
     *
     * 3 2 5 4 1 6
     *
     * 3 2 5 4 1 6
     *
     * 3 4 5 6 1 2
     *
     * 3 4 5 6 1 2
     *
     * 3 4 1 6 5 2
     *
     * 3 4 1 2 5 6
     *
     * 5 4 1 2 3 6
     *
     * 5 6 1 2 3 4
     *
     * @param nums
     * @param k
     */
    static void rotate2(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int i = 0; count < nums.length; i++) {
            int current = i;
            int prevNum = nums[i];
            do {
                int next = (current + k) % nums.length;

                int tmp = nums[next];
                nums[next] = prevNum;
                prevNum = tmp;

                current = next;
                count++;
            } while (i != current);
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 2, 3, 4, 5, 6, 7 };
        // rotate(nums, 3);
        rotate2(nums, 2);
    }
}
