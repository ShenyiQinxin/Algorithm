/**
 * Input: "Let's take LeetCode contest"
 * 
 * Output: "s'teL ekat edoCteeL tsetnoc"
 */
class ReverseWordsIII {
    static String reverseWords(String s) {
        char[] A = s.toCharArray();
        int start = 0;
        for (int i = 0; i < A.length; i++) {
            if (i == s.length() || A[i] == ' ') {
                reverseCharacters(A, start, i - 1);
                start = i + 1;
            }
        }
        return String.valueOf(A);
    }

    static char[] reverseCharacters(char[] A, int l, int r) {
        while (l < r) {
            char tmp = A[r];
            A[r] = A[l];
            A[l] = tmp;
            l++;
            r--;
        }
        return A;
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }
}