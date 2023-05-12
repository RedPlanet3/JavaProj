import java.util.*;

class Solution {
    public boolean isValid(String s) {
        LinkedList<Character> brackets = new LinkedList<>();
        HashMap<Character, Character> openClose = new HashMap<>();
        openClose.put('}', '{');
        openClose.put(')', '(');
        openClose.put(']', '[');

        for(int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == '{' || s.charAt(i) == '(' || s.charAt(i) == '[')
                brackets.add(s.charAt(i));
            else if (brackets.size() > 0 && brackets.getLast() == openClose.get(s.charAt(i)))
                brackets.removeLast();
            else
                return false;
        }
        return brackets.size() == 0;
    }

    public static void main(String[] args) {
        System.out.println("true: " + new Solution().isValid("()[]{}"));
        System.out.println("true: " + new Solution().isValid("([{}])"));
        System.out.println("true: " + new Solution().isValid("()(){}"));
        System.out.println("false: " + new Solution().isValid("(()"));
        System.out.println("false: " + new Solution().isValid("(}"));
        System.out.println("false: " + new Solution().isValid("(}}"));
        System.out.println("false: " + new Solution().isValid("}("));
        System.out.println("false: " + new Solution().isValid("{{}]"));
        System.out.println("false: " + new Solution().isValid("(]"));
        System.out.println("true: " + new Solution().isValid(""));
        System.out.println("false: " + new Solution().isValid("{"));
    }
}