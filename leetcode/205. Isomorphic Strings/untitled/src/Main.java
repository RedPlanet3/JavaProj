import java.util.HashMap;

public class Main {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;
        HashMap<Character,Character> change = new HashMap<>();
        for(int i = 0; i < s.length(); i++)
        {
            if (change.containsKey(s.charAt(i)) || change.values().contains(t.charAt(i)))
            {
                if (!change.containsKey(s.charAt(i)) || t.charAt(i) != change.get(s.charAt(i)))
                    return false;
            }
            else
                change.put(s.charAt(i), t.charAt(i));
        }
        return true;
    }
    public static void main(String[] args) {
        Main ds = new Main();
//        System.out.println("true " + ds.isIsomorphic("egg", "add"));
//        System.out.println("false " + ds.isIsomorphic("foo", "bar"));
//        System.out.println("true " + ds.isIsomorphic("paper", "title"));
//        System.out.println("false " + ds.isIsomorphic("papr", "title"));
        System.out.println("false " + ds.isIsomorphic("badc", "baba"));
//        System.out.println("false " + ds.isIsomorphic("pll", "top"));
    }
}