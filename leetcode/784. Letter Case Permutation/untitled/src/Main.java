import java.util.ArrayList;
import java.util.List;

public class Main {

    public void req(List<String> lst, int ind, StringBuilder str)
    {
        while (ind < str.length() && !Character.isAlphabetic(str.charAt(ind)))
            ind++;

        if (ind < str.length()) {
            str.setCharAt(ind, Character.toUpperCase(str.charAt(ind)));
            req(lst, ind + 1, str);
            str.setCharAt(ind, Character.toLowerCase(str.charAt(ind)));
            req(lst, ind + 1, str);
        }
        else
            lst.add(str.toString());
    }
    public List<String> letterCasePermutation(String s) {
        List<String> lst = new ArrayList<>();
        req(lst, 0, new StringBuilder(s));
        return lst;
    }
//    public List<String> letterCasePermutation(String s) {
//        List<String> lst = new ArrayList<>();
//        HashSet<String> set = new HashSet<>();
//        lst.add(s);
//        int indLst = 0;
//        int strInd;
//        StringBuilder tmpStr;
//        String t;
//        while (indLst < lst.size())
//        {
//            t = lst.get(indLst);
//            strInd = 0;
//            while (strInd < t.length())
//            {
//                if (Character.isAlphabetic(t.charAt(strInd))
//                        && Character.isLowerCase(t.charAt(strInd))) {
//                    tmpStr = new StringBuilder(t);
//                    tmpStr.setCharAt(strInd, Character.toUpperCase(tmpStr.charAt(strInd)));
//                    if (!set.contains(tmpStr.toString())) {
//                        lst.add(tmpStr.toString());
//                        set.add(tmpStr.toString());
//                    }
//                }
//                strInd++;
//            }
//            indLst++;
//        }
//        return lst;
//    }
    public static void main(String[] args) {
        Main ds = new Main();
        System.out.println("[\"a1b2\",\"a1B2\",\"A1b2\",\"A1B2\"]\n" + ds.letterCasePermutation("a1b2"));
        System.out.println("[\"3z4\",\"3Z4\"]\n" + ds.letterCasePermutation("3z4"));
        System.out.println("[\"c\",\"C\"]\n" + ds.letterCasePermutation("C"));

    }
}