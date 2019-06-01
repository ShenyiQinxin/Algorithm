import java.util.*;
class Solution {
    // k:v num:index
    static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int key = 0;
        for (int i = 0; i < nums.length; i++) {
            key = target - nums[i];
            if (!map.containsKey(key)) {
                map.put(nums[i], i);
            } else {
                return new int[] { map.get(key), i };
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 2, 7, 11, 15 };
        int[] res = twoSum(nums, 9);
        System.out.println(res);
    }
}