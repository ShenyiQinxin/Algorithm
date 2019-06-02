/**
 * Input: [1,2,3]
 * 
 * Output: [1,2,4]
 * 
 * Explanation: The array represents the integer 123.
 */
class PlusOne {
    static int[] plusOne(int[] digits) {
        int length = digits.length;
        for (int i = length - 1; i >= 0; i++) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] result = new int[length + 1];
        result[0] = 1;
        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}