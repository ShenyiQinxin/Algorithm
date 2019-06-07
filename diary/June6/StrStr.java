class StrStr {
    /**
     * Input: haystack = "hello", needle = "ll"
     * 
     * Output: 2
     * 
     */
    static int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || haystack.length() < needle.length()) {
            return -1;
        }
        if (needle.length() == 0) {
            return 0;
        }
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String str = "hello", needle = "ll";
        System.out.println(strStr(str, needle));
    }

}