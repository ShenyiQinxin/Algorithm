/**
 * Input: [0,1,0,3,12] Output: [1,3,12,0,0]
 */

class MoveZeroes {
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
            System.out.println(nums[i]);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 0, 1, 0, 3, 12 };
        moveZeroes(nums);
    }
}