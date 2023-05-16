import java.util.Arrays;

public class Main {
    public String reverseString(String str) {
        char[] s = str.toCharArray();
        char tmp;
        for (int i = 0; i < s.length/2; i++)
        {
            tmp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = tmp;
        }
        return String.valueOf(s);
    }
    public String reverseWords(String s) {
        String[] str = s.split(" ");
        for(int i = 0; i < str.length; i++)
            str[i] = reverseString(str[i]);
        return String.join(" ", str);
    }

    public static void main(String[] args) {
        Main ds = new Main();
        System.out.println("s'teL ekat edoCteeL tsetnoc\n" + ds.reverseWords("Let's take LeetCode contest"));
    }
}
