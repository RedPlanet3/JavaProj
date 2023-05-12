import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public boolean isAnagram(char[] s, char[] t) {
        int [] arr = new int[26];
        for(char ch: s)
            arr[ch - 97] += 1;
        for (char ch: t)
            arr[ch - 97] -= 1;
        for (int count: arr)
            if (count != 0) return false;
        return true;
    }
    public List<Integer> findAnagrams(String s, String p) {
        int finish = p.length();
        List<Integer> indexList= new ArrayList<>();
        if (s.length() < p.length())
            return indexList;
        char[] pStr = p.toCharArray();
        char[] sStr = s.toCharArray();
        while (finish <= s.length())
        {
            if (isAnagram(Arrays.copyOfRange(sStr,finish - p.length(),finish), pStr))
                indexList.add(finish - p.length());
            finish++;
        }
        return indexList;
    }
    public static void main(String[] args) {
        Main ds = new Main();
        System.out.println("[0,6]: " + ds.findAnagrams("cbaebabacd", "abc"));
        System.out.println("[0,1,2]: " + ds.findAnagrams("abab", "ab"));
        System.out.println("[]: " + ds.findAnagrams("abab", "abh"));
    }
}