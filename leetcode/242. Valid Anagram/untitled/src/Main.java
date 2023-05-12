public class Main {
    public boolean isAnagram(String s, String t) {
        int [] arr = new int[26];
        for(char ch: s.toCharArray())
            arr[ch - 97] += 1;
        for (char ch: t.toCharArray())
            arr[ch - 97] -= 1;
        for (int count: arr)
            if (count != 0) return false;
        return true;
    }
    public static void main(String[] args) {
        Main ds = new Main();
        System.out.println("true: " + ds.isAnagram("anagram", "nagaram"));
        System.out.println("false: " + ds.isAnagram("rat", "car"));
    }
}