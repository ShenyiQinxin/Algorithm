import java.util.HashMap;
import java.util.*;

class ContainsDuplicate {
    static boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Integer v : map.values()) {
            if (v >= 2) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 0 };
        System.out.println(containsDuplicate(nums));
    }
}
