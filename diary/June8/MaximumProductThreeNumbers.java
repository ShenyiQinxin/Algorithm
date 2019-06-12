/**
 * Input: [1,2,3]
 * 
 * Output: 6
 */
class MaximumProductThreeNumbers {
    static int maximumProduct(int[] nums) {
        if (nums.length < 3) {
            new IllegalArgumentException();
        }

        int highest = Math.max(nums[0], nums[1]);
        int lowest = Math.min(nums[0], nums[1]);

        int highestProduct2 = nums[0] * nums[1];
        int lowestProduct2 = nums[0] * nums[1];

        int highestProduct3 = nums[0] * nums[1] * nums[2];

        for (int i = 2; i < nums.length; i++) {
            int curr = nums[i];
            highestProduct3 = Math.max(Math.max(highestProduct2, highestProduct2 * curr), lowestProduct2 * curr);
            highestProduct2 = Math.max(Math.max(highestProduct2, curr * highest), curr * lowest);
            lowestProduct2 = Math.min(Math.min(lowestProduct2, curr * highest), curr * lowest);
            highest = Math.max(highest, curr);
            lowest = Math.min(lowest, curr);
        }
        return highestProduct3;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };

        System.out.println(maximumProduct(nums));
    }
}