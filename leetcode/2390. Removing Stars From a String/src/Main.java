import java.util.ArrayList;

public class Main {
//    public boolean isStar(String str)
//    {
//        for (char i: str.toCharArray()) {
//            if (i == '*')
//                return true;
//        }
//        return false;
//    }
//    public String removeStars(String s) {
//        StringBuilder str = new StringBuilder(s);
//        int start = str.length() - 1;
//        int end = str.length() - 1;
//        int tmp;
//        while (isStar(str.toString())) {
//            while (start > -1 && end > -1) {
//                while (start > -1 && str.charAt(start) != '*') start--;
//                end = start;
//                if (start > -1 && str.charAt(start) == '*') while (end > -1 && str.charAt(end) == '*') end--;
//                if (start - end > 0) {
//                    tmp = end - (start - end);
//                    str.delete(end - (start - end) + 1, start + 1);
//                    start = tmp - 1;
//                }
//            }
//        }
//        return str.toString();
//    }


    public String removeStars(String s) {

        ArrayList<Character> stack = new ArrayList<>();

        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == '*')
                stack.remove(stack.size() - 1);
            else
                stack.add(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        for (char subArray : stack) {
            sb.append(subArray);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Main ds = new Main();
        System.out.println("lecoe\n" + ds.removeStars("leet**cod*e"));
        System.out.println("\n" + ds.removeStars("erase*****"));
        System.out.println("erase\n" + ds.removeStars("erase"));

    }
}
