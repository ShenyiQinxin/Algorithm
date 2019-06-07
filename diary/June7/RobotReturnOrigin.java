/**
 * Input: "UD"
 *
 * Output: true
 *
 * Explanation: The robot moves up once, and then down once. All moves have the
 * same magnitude, so it ended up at the origin where it started. Therefore, we
 * return true.
 */
class RobotReturnOrigin {
    static boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        for (char move : moves.toCharArray()) {
            if (move == 'D') {
                y--;
            } else if (move == 'U') {
                y++;
            } else if (move == 'R') {
                x++;
            } else if (move == 'L') {
                x--;
            }
        }
        return x == 0 && y == 0;
    }

    public static void main(String[] args) {
        System.out.println(judgeCircle("DU"));
    }
}
