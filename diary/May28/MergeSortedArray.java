/**
 * Input:
 *
 * nums1 = [1,2,3,0,0,0], m = 3
 *
 * nums2 = [2,5,6], n = 3
 *
 * Output: [1,2,2,3,5,6]
 */
class MergeSortedArray {
    static void merge(int[] nums1, int m, int[] nums2, int n) {
        int merged = m + n - 1;
        int first = m - 1;
        int second = n - 1;
        while (merged >= 0) {
            if (nums1[first] > nums2[second]) {
                nums1[merged--] = nums1[first--];
            } else {
                nums1[merged--] = nums2[second--];
            }
            if (first < 0) {
                nums1[merged] = nums2[second--];
                continue;
            }
            if (second < 0) {
                break;
            }
        }

        for (int i = 0; i < nums1.length; i++) {
            System.out.println(nums1[i]);
        }
    }

    public static void main(String[] args) {
        merge(new int[] { 1, 2, 3, 0, 0, 0 }, 3, new int[] { 2, 5, 6 }, 3);
    }
}
