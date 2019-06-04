import java.util.*;

/**
 * A = [12, 28, 46, 32, 50]
 *
 * B = [50, 12, 32, 46, 28]
 *
 * We should return [1, 4, 3,2, 0]
 */
class FindAnagramMappings {
    static int[] anagramMappings(int[] A, int[] B) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < B.length; i++) {
            map.put(B[i], i);
        }
        int[] res = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            res[i] = map.get(A[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = { 12, 28, 46, 32, 50 };
        int[] B = { 50, 12, 32, 46, 28 };
        int[] nums = anagramMappings(A, B);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
