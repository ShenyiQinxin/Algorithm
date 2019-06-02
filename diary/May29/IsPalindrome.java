class IsPalindrome {
    static boolean isPalindrome(String s0) {
        String s = s0.toLowerCase();
        if (s == null || s.length() == 0) {
            return true;
        }
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (!isValid(s.charAt(l))) {
                l++;
                continue;
            }

            if (!isValid(s.charAt(r))) {
                r--;
                continue;
            }
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    static boolean isValid(char c) {
        if (c >= '0' && c <= '9' || c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
    }
}