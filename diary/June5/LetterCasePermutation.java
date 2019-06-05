import java.util.*;

/**
 * Input: S = "a1b2"
 * 
 * Output: ["a1b2", "a1B2", "A1b2", "A1B2"]
 */
class LetterCasePermutation {
    static List<String> letterCasePermutation(String S) {
        List<String> ans = new ArrayList<>();
        dfs(S.toCharArray(), 0, ans);
        return ans;
    }

    static void dfs(char[] S, int i, List<String> ans) {
        if (i == S.length) {
            ans.add(new String(S));
            return;
        }

        dfs(S, i + 1, ans);
        if (!Character.isLetter(S[i])) {
            return;
        }
        S[i] ^= 1 << 5;
        dfs(S, i + 1, ans);
    }

    public static List<String> getPermutations(String s) {
        int n = s.length();
        if (n <= 1) {
            return new ArrayList<>(Collections.singletonList(s));
        }
        String preLast = s.substring(0, n - 1);
        char lastChar = s.charAt(n - 1);
        List<String> ps = getPermutations(preLast);
        List<String> list = new ArrayList<>();
        for (String p : ps) {
            for (int i = 0; i < preLast.length(); i++) {
                String permutation = p.substring(0, i) + lastChar + p.substring(i);
                list.add(permutation);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        String str = "a1b2";
        // List<String> list = letterCasePermutation(str);
        List<String> list = getPermutations(str);
        System.out.println(list);
    }
}