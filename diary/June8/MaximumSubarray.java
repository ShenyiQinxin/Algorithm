/**
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * 
 * Output: 6
 * 
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 */
class MaximumSubarray {
    static int maxSubArray(int[] A) {
        int max = A[0], maxSoFar = A[0];
        for (int i = 0; i < A.length; i++) {
            maxSoFar = Math.max(maxSoFar + A[i], A[i]);
            max = Math.max(max, maxSoFar);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };

        System.out.println(maxSubArray(nums));
    }
}