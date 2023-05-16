import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int end = 0;
        int max = 0;
        HashSet<Character> tmpSet = new HashSet<>();
        while (end < s.length())
        {
            if (!tmpSet.contains(s.charAt(end)))
            {
                tmpSet.add(s.charAt(end));
                end++;
            }
            else
            {
                max = Math.max(tmpSet.size(), max);
                tmpSet.remove(s.charAt(start));
                start++;
            }
        }
        max = Math.max(tmpSet.size(), max);
        return max;
    }

}
