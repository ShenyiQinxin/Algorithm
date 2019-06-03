/**
 * 9^2=81
 * 
 * 8^2=64
 * 
 * 1^2=1
 */
class ValidPerfectSquare {
    static boolean isPerfectSquare(int num) {
        int l = 1, r = num / 2;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (num / mid == mid) {
                return true;
            } else if (num / mid < mid) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        System.out.println(isPerfectSquare(9));

    }
}