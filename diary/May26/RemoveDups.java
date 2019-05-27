/**
 * Given nums = [0,0,1,1,1,2,2,3,3,4],
 * 
 * Your function should return length = 5, with the first five elements of nums
 * being modified to 0, 1, 2, 3, and 4 respectively.
 */
class RemoveDups {
    static int removeDuplicates(int[] nums) {
        int j = 0;
        int current = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == nums[j]) {
                current = nums[j];
            } else if (nums[i] != current) {
                j++;
                nums[j] = nums[i];
            }
        }
        return j + 1;
    }

    static int removeDuplicatesSorted(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
            } 
        }
        return j;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        //System.out.print(removeDuplicates(nums));
        System.out.println(removeDuplicatesSorted(nums));
    }
}