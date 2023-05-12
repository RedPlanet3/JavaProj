import java.util.*;

public class Main {
    public static char findTheDifference(String s, String t) {
        int[] alpha = new int[26];
        for (char d: t.toCharArray())
            alpha[d - 'a'] += 1;
        for (char d: s.toCharArray())
            alpha[d - 'a'] -= 1;
        for (int i = 0; i < 26; i++)
        {
            if (alpha[i] != 0)
                return (char) (i + 'a');
        }
        return ' ';
    }
    public static void main(String[] args) {
        ;
        System.out.println("e: " + findTheDifference("abcd", "abcde"));

    }
}