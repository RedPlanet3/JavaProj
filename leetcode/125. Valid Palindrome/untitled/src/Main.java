public class Main {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) >= 'a' &&
                    s.charAt(i) <= 'z' ||
                    s.charAt(i) >= '0' &&
                            s.charAt(i) <= '9')
                str.append(s.charAt(i));
        }
        for (int i = 0; i < str.length()/2; i++)
        {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i))
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Main ds = new Main();
        System.out.println("true: " + ds.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println("false: " + ds.isPalindrome("race a car"));
        System.out.println("true: " + ds.isPalindrome(" "));

    }
}