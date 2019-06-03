import java.util.HashMap;
import java.util.Map;

/**
 * Input: "IV"
 *
 * Output: 4
 */
class RomanToInteger {
    static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int num = 0;
        int l = s.length();
        for (int i = 0; i < l; i++) {// I, II, VI
            if ((i == l - 1) || map.get(s.charAt(i)) >= map.get(s.charAt(i + 1))) {
                num += map.get(s.charAt(i));
            } else {// IV
                num -= map.get(s.charAt(i));
            }
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("IV"));
    }
}
