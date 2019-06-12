public class ArrayQs {
    static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        int[] nums = new int[n + 1];
        nums[1] = 1;
        nums[2] = 1;
        for (int i = 3; i < n + 1; i++) {
            nums[i] = nums[i - 2] + nums[i - 1];
        }
        return nums[n];
    }

    static int fibRecursive(int n) {
        if (n <= 1) {
            return n;
        }
        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }

    static int climbStairs(int n) {
        if (n == 1) {
            return n;
        }
        int[] nums = new int[n + 1];
        nums[1] = 1;
        nums[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            nums[i] = nums[i - 2] + nums[i - 1];
        }
        return nums[n];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }

}