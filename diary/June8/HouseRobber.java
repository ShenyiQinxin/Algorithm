/**
 * Input: [1,2,3,1]
 * 
 * Output: 4
 * 
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3). Total
 * amount you can rob = 1 + 3 = 4.
 */
class HouseRobber {
    static int rob(int[] nums) {
        int prevPrevMax = 0;
        int prevMax = 0;
        for (int curr : nums) {
            int tmp = prevMax;
            prevMax = Math.max(prevPrevMax + curr, prevMax);
            prevPrevMax = tmp;
        }
        return prevMax;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 1 };
        System.out.println(rob(nums));
    }
}