/**
 * Given nums = [0,1,2,2,3,0,4,2], val = 2, Your function should return length
 * =5, with the first five elements of nums containing 0, 1, 3, 0, and 4.
 */
class RemoveElements {
    static int removeElements(int[] nums, int val) {
        int j = 0; // j is the index of the new array, though at the same array space
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 2, 2, 3 };
        System.out.println(removeElements(nums, 3));
        // System.out.println(removeElements(new int[2], 2));
    }
}