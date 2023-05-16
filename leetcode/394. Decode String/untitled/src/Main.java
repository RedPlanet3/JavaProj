import java.util.ArrayList;

public class Main {
    public String decodeString(String s) {
        ArrayList<Character> arr = new ArrayList<>();
        StringBuilder answ = new StringBuilder();
        int i = 0;
        int start;
        int n;
        while (i > s.length())
        {
            start = i;
            while (s.charAt(i) != '[')
                i++;
            n = Integer.parseInt(s.substring(start,i));
            start = i++;
            while (s.charAt(i) != ']')
                i++;
            for (int j = 0; j < n; j++)
                answ.append(s.substring(start,i).toCharArray());
            i++;
        }
    }
    public static void main(String[] args) {
        Main ds = new Main();
        System.out.println("aaabcbc\n" + ds.decodeString("3[a]2[bc]"));
        System.out.println("aaabcbc\n" + ds.decodeString("3[a]2[bc]"));
    }
}