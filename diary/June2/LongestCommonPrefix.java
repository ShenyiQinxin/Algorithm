/**
 * Input: ["flower","flow","flight"]
 * 
 * Output: "fl"
 * 
 * 
 */
class LongestCommonPrefix {
    static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0 || strs == null) {
            return "";
        }
        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            minLength = Math.min(minLength, str.length());
        }
        int l = 1, r = minLength;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (isCommonPrefix(strs, mid)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        // l>r
        return strs[0].substring(0, (l + r) / 2);
    }

    static boolean isCommonPrefix(String[] strs, int length) {
        String str0 = strs[0].substring(0, length);
        for (int i = 0; i < strs.length; i++) {
            if (!strs[i].startsWith(str0)) {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        String[] strs = { "flower", "flow", "flight" };
        System.out.println(longestCommonPrefix(strs));

    }
}