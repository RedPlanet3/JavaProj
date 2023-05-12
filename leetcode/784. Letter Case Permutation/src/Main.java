import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {

    public List<String> letterCasePermutation(String s) {
        List<String> lst = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        lst.add(s);
        int indLst = 0;
        int strInd;
        StringBuilder tmpStr;
        String t;
        while (indLst < lst.size())
        {
            t = lst.get(indLst);
            strInd = 0;
            while (strInd < t.length())
            {
                if (Character.isAlphabetic(t.charAt(strInd))
                        && Character.isLowerCase(t.charAt(strInd))) {
                    tmpStr = new StringBuilder(t);
                    tmpStr.setCharAt(strInd, Character.toUpperCase(tmpStr.charAt(strInd)));
                    if (!set.contains(tmpStr.toString())) {
                        lst.add(tmpStr.toString());
                        set.add(tmpStr.toString());
                    }
                }
                strInd++;
            }
            indLst++;
        }
        return lst;
    }

    public static void main(String[] args) {
        Main ds = new Main();
        System.out.println("[\"a1b2\",\"a1B2\",\"A1b2\",\"A1B2\"]" + ds.letterCasePermutation("a1b2"));
        System.out.println("[\"3z4\",\"3Z4\"]" + ds.letterCasePermutation("3z4"));
        System.out.println("[z, Z]" + ds.letterCasePermutation("z"));
        System.out.println("[3]" + ds.letterCasePermutation("3"));


    }

}
