import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Input: "()[]{}"
 *
 * Output: true
 */
class ValidParentheses {
    static boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        Stack<Character> stack = new Stack<>();
        char[] array = s.toCharArray();
        for (Character c : array) {
            if (map.containsKey(c)) {
                stack.push(c);
            } else if (map.containsValue(c)) {
                if (!stack.isEmpty() && map.get(stack.peek()) == c) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();

    }

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
    }
}
