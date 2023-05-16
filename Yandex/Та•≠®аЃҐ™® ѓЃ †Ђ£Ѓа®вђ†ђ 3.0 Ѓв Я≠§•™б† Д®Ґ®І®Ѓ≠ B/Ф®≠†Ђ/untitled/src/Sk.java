import java.util.*;

public class Sk {
    public static char back(ArrayList<Object[]> stack)
    {
        char last = '.';
        if (stack.size() > 0)
            last = (char)stack.get(stack.size() - 1)[0];
        return last;
    }
    public static int backInd(ArrayList<Object[]> stack)
    {
        int last = -1;
        if (stack.size() > 0)
            last = (int)stack.get(stack.size() - 1)[1];
        return last;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine().trim();
        HashMap<Character, Character> sk = new HashMap<>();
        sk.put(')', '(');
        sk.put(']', '[');
        sk.put('}', '{');
        HashSet<Character> open = new HashSet<>();
        open.add('(');
        open.add('[');
        open.add('{');
        ArrayList<Object[]> stack = new ArrayList<>();
        int i;
        for (i = 0; i < str.length(); i++)
        {
            if (open.contains(str.charAt(i))) {
                stack.add(new Object[]{str.charAt(i), i});

            }
            else if (sk.containsKey(str.charAt(i))) {
                if (sk.get(str.charAt(i)) == back(stack))
                    stack.remove(stack.size() - 1);
                else
                    break;
            }

        }
        if (i < str.length())
            System.out.println(i + 1);
        else if (stack.size() > 0)
            System.out.println(backInd(stack) + 1);
        else
            System.out.println("Success");
    }
}
