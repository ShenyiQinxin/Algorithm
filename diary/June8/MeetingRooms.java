import java.util.*;

/**
 * Input: [[0,30],[5,10],[15,20]]
 * 
 * Output: false
 */
class MeetingRooms {
    static boolean canAttendMeetings(int[][] intervals) {
        Comparator<int[]> c = (int[] a, int[] b) -> (a[0] - b[0]);
        Arrays.sort(intervals, c);
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i + 1][0]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] nums = { { 7, 10 }, { 2, 4 } };

        System.out.println(canAttendMeetings(nums));
    }
}