class FirstBadVersion {

    static int firstBadVersion(int n) {
        int l = 1, r = n, mid = 0;
        while (l < r) {
            mid = l + (r - l) / 2;
            if (isBadVersion(mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }

        }
        // l==r
        return l;
    }

    static boolean isBadVersion(int n) {
        if (n <= 3) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        System.out.println(firstBadVersion(50));
    }
}
