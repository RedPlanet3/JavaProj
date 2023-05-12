public class Main {
    public int[] formStr(String s1)
    {
        int[] answ = new int[26];
        for (int i = 0; i < s1.length(); i++)
            answ[s1.charAt(i) - 'a'] += 1;
        return answ;
    }

    public boolean checkInclusion(String s1, String s2) {
        int []find;
        int start = 0;
        int end = start + s1.length() - 1;
        boolean ok = true;
        while (end < s2.length())
        {
            ok = true;
            find = formStr(s1);
            for(int i = start; i < end + 1; i++) {
                if (find[s2.charAt(i) - 'a'] - 1 < 0)
                {
                    ok = false;
                    break;
                }
                else find[s2.charAt(i) - 'a'] -= 1;
            }
            if (ok)
                return true;
            end++;
            start++;
        }
        return false;
    }

    public static void main(String[] args) {
        Main ds = new Main();
        System.out.println("false: " + ds.checkInclusion("hello", "ooolleoooleh"));
    }
}
