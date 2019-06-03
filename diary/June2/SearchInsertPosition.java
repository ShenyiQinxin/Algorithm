/**
 * Input: [1,3,5,6], 5
 * 
 * Output: 2
 */
class SearchInsertPosition {
    static int searchInsert(int[] nums, int target) {
        if (nums.length == 0 || nums == null) {
            return 0;
        }

        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, 5, 6 };
        System.out.println(searchInsert(nums, 5));

    }

}