import java.util.HashSet;
import java.util.Set;

/**
 * Input: J = "aA", S = "aAAbbbb"
 *
 * Output: 3
 */
class JewelsAndStones {
    static int numJewelsInStones(String J, String S) {
        Set<Character> jset = new HashSet<>();
        for (char j : J.toCharArray()) {
            jset.add(j);
        }
        int ans = 0;
        for (char s : S.toCharArray()) {
            if (jset.contains(s)) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String J = "aA", S = "aAAbbbb";
        System.out.println(numJewelsInStones(J, S));
    }
}
