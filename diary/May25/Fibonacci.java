class Fibonacci {
    /**
     * 0 1 2 3 4 5
     * 
     * 1 1 2 3 5 8
     */
    static int fibonacci(int n) {
        if (n == 1 || n == 0) {
            return n;
        }

        int[] sum = new int[n + 1];
        sum[1] = 1;
        sum[2] = 1;

        for (int i = 3; i <= n; i++) {
            sum[i] = sum[i - 1] + sum[i - 2];
        }
        return sum[n];
    }

    static int fibRecursive(int n) {
        if (n <= 1) {
            return n;
        }
        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }

    /**
     * 0 1 2 3 4 5
     * 
     * 1 2 3 5 8 13
     */
    static int climbStairs(int n) {
        if (n == 1) {
            return n;
        }
        int[] sum = new int[n + 1];
        sum[1] = 1;
        sum[2] = 2;
        for (int i = 3; i <= n; i++) {
            sum[i] = sum[i - 1] + sum[i - 2];
        }
        return sum[n];
    }

    public static void main(String[] args) {
        for (int i = 0; i < 7; i++) {
            System.out.print(fibonacci(i) + " ");
            // System.out.print(fibRecursive(i) + " ");
        }
        System.out.println();
        for (int i = 1; i < 7; i++) {
            // System.out.print(climbStairs(i) + " ");
        }

    }
}