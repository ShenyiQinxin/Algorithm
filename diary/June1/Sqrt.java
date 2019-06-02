class Sqrt {
    static int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int l = 0, r = x;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (x / mid == mid) {
                return mid;
            } else if (x / mid < mid) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(5));

    }
}