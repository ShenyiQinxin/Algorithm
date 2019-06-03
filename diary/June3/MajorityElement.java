import java.util.HashMap;
import java.util.Map;

/**
 * Input: [2,2,1,1,1,2,2]
 *
 * Output: 2
 */
class MajorityElement {
    static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0));
        }
        Map.Entry<Integer, Integer> majorEntry = null;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (majorEntry == null || entry.getValue() > majorEntry.getValue()) {
                majorEntry = entry;
            }
        }
        return majorEntry.getKey();
    }

    public static void main(String[] args) {
        int[] nums = { 2, 2, 1, 1, 1, 2, 2 };
        System.out.println(majorityElement(nums));
    }
}
