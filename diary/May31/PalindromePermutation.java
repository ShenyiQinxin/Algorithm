import java.util.*;

/**
 * Input: "code"
 *
 * Output: false
 *
 * Input: "carerac"
 *
 * Output: true
 */
class PalindromePermutation {
    static boolean canPermutePalindrome(String s) {
        // care
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            // c a r e
            if (set.contains(c)) {
                set.remove(c);
            } else {
                set.add(c);
            }
        }
        return set.size() <= 1;
    }

    public static void main(String[] args) {
        boolean result = canPermutePalindrome("crac");
        System.out.println(result);
    }
}
