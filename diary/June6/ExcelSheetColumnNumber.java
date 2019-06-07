/**
 * A -> 1 B -> 2 C -> 3 ... Z -> 26
 * 
 * AA -> 27 AB -> 28
 */
class ExcelSheetColumnNumber {
    static int titleToNumber(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - 'A' + 1;
            result = result * 26 + num;
        }
        return result;
    }

    public static void main(String[] args) {
        String str = "AB";
        System.out.println(titleToNumber(str));
    }
}