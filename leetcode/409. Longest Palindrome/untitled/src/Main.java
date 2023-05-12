
import java.util.HashSet;

public class Main {
//    public int longestPalindrome(String s) {
//        HashSet<Character> setCh = new HashSet<>(52);
//        int pairs = 0;
//        for (int i = 0; i < s.length(); i++)
//        {
//            if (setCh.contains(s.charAt(i)))
//            {
//                pairs++;
//                setCh.remove(s.charAt(i));
//            }
//            else
//                setCh.add(s.charAt(i));
//        }
//        return pairs * 2 + (setCh.size() > 0? 1 : 0);
//    }
    public int longestPalindrome(String s) {
        int [] arr = new int[52];
        int pairs = 0;
        int indTmp;
        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) < 91)
                indTmp = s.charAt(i) - 65;
            else
                indTmp = s.charAt(i) - 71;
            if (arr[indTmp] != 0)
            {
                pairs++;
                arr[indTmp] = 0;
            }
            else
                arr[indTmp] = 1;
        }
        for (int i : arr) {
            if (i != 0)
                return pairs * 2 + 1;
        }
        return pairs * 2;
    }
    public static void main(String[] args) {
        Main ds = new Main();
        System.out.println("7: " + ds.longestPalindrome("abccccdd"));
        System.out.println("1: " + ds.longestPalindrome("a"));
        System.out.println("1: " + ds.longestPalindrome("Aa"));
        System.out.println("0: " + ds.longestPalindrome(""));
        System.out.println("5: " + ds.longestPalindrome("aaaaa"));

    }
}