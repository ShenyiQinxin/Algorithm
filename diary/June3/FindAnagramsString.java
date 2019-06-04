import java.util.ArrayList;
import java.util.List;

class FindAnagramsString {
    /**
     * 
     * Input: s: "cbaebabacd" p: "abc"
     * 
     * 
     * Output: [0, 6]
     * 
     */
    static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || p == null) {
            return res;
        }
        int l = 0, r = 0, count = p.length();
        int[] map = new int[256];// p:"abc"
        char[] sc = s.toCharArray();// s:"cbaebabacd"
        for (char c : p.toCharArray()) {
            map[c]++;
        }
        while (r < s.length()) {
            if (map[sc[r++]]-- >= 1) {
                count--;
            }
            if (count == 0) {
                res.add(l);
            }
            if (r - l == p.length() && map[sc[l++]]++ >= 0) {
                count++;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        List<Integer> list = findAnagrams("cbaebabacd", "abc");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}