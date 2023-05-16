import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public boolean index_compare(char a, char b)
    {
        if (b == a)
            return false;
        ArrayList<Character> arr = new ArrayList(Arrays.asList('I', 'V', 'X', 'L', 'C', 'D', 'M'));
        for (int i = 0; i < arr.size(); i++)
        {
            if (arr.get(i) == a)
                return true;
            if (arr.get(i) == b)
                return false;
        }
        return false;
    }
    public int romanToInt(String s) {
        int answ = 0;
        int sign = 1;

        if (s.isEmpty())
            return 0;
        for (int i = 0; i < s.length(); i++)
        {
            sign = 1;
            if ((i + 1 < s.length()) && index_compare(s.charAt(i), s.charAt(i + 1)))
                sign = -1;
            switch (s.charAt(i)) {
                case ('I'):
                    answ += 1 * sign;
                    break;
                case ('V'):
                    answ += 5 * sign;
                    break;
                case ('X'):
                    answ += 10 * sign;
                    break;
                case ('L'):
                    answ += 50 * sign;
                    break;
                case ('C'):
                    answ += 100 * sign;
                    break;
                case ('D'):
                    answ += 500 * sign;
                    break;
                case ('M'):
                    answ += 1000 * sign;
                    break;
            }
        }
        return answ;
    }
}