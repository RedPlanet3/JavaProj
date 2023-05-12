public class Main {
    public boolean isSubsequence(String s, String t) {
        char[] find;
        if (s.length() > 0)
            find = s.toCharArray();
        else
            return true;
        int start = 0;
        char []from = t.toCharArray();
        for (int i = 0; i < from.length; i++)
        {
            if (from[i] == find[start])
                start++;
            if (start == find.length)
                return true;
        }
        return false;
    }

//    public boolean isSubsequence(String s, String t) {
//        char[] find;
//        if (!(s.length() > 0))
//            return false;
//        int target = 1;
//        for (int i = 0; i < t.length(); i++)
//            target *= t.charAt(i);
//
//    }
    public static void main(String[] args) {
        System.out.println(new Main().isSubsequence("abc", "ahbgdc"));
        System.out.println(new Main().isSubsequence("axc", "ahbgdc"));
    }
}

