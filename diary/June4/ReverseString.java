/**
 * Input: ['h','e','l','l','o']
 * 
 * Output: ['o','l','l','e','h']
 * 
 * 
 * 
 */
class ReverseString {
    static void reverseString(char[] A) {
        int l = 0, r = A.length - 1;
        for (int i = 0; i < A.length / 2; i++) {
            char tmp = A[l];
            A[l] = A[r];
            A[r] = tmp;
            l++;
            r--;
        }
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
    }

    public static void main(String[] args) {
        char[] chars = { 'h', 'e', 'l', 'l', 'o' };
        reverseString(chars);
    }
}
