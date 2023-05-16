class Solution {
    public boolean isPalindromeStr(int x) {
        String strNum = Integer.toString(x);
        for (int i = 0; i < strNum.length()/2; i++) {
            if (strNum.charAt(i) != strNum.charAt(strNum.length() - 1 - i))
                return false;
        }
        return true;
    }

    public boolean isPalindrome(int x) {
        int tmp = x;
        int ch = 0;
        if (x < 0)
            return false;
        while (tmp > 0)
        {
            tmp = tmp / 10;
            ch++;
        }
        int i = 1;
        while (ch > 1 && x > 9) {
           if (x / (int)Math.pow(10, ch - 1) % 10 != (x % (int)Math.pow(10, i)) / (int)Math.pow(10, i -1))
               return false;
           i++;
           ch--;
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println("1: " + new Solution().isPalindromeStr(10) + " " + 10);
        System.out.println("2: " + new Solution().isPalindrome(10) + " " + 10);
        System.out.println("1: " + new Solution().isPalindromeStr(1) + " " + 1);
        System.out.println("2: " + new Solution().isPalindrome(1) + " " + 1);
        System.out.println("1: " + new Solution().isPalindromeStr(111) + " " + 111);
        System.out.println("2: " + new Solution().isPalindrome(111) + " " + 111);
        System.out.println("1: " + new Solution().isPalindromeStr(11) + " " + 11);
        System.out.println("2: " + new Solution().isPalindrome(11) + " " + 11);
        System.out.println("1: " + new Solution().isPalindromeStr(90) + " " + 90);
        System.out.println("2: " + new Solution().isPalindrome(90) + " " + 90);
        System.out.println("1: " + new Solution().isPalindromeStr(100009) + " " + 100009);
        System.out.println("2: " + new Solution().isPalindrome(100009) + " " + 100009);
        System.out.println("1: " + new Solution().isPalindromeStr(100001) + " " + 100001);
        System.out.println("2: " + new Solution().isPalindrome(100001) + " " + 100001);
        System.out.println("1: " + new Solution().isPalindromeStr(-10001) + " " + -10001);
        System.out.println("2: " + new Solution().isPalindrome(-10001) + " " + -10001);
        System.out.println("1: " + new Solution().isPalindromeStr(1000021) + " " + 1000021);
        System.out.println("2: " + new Solution().isPalindrome(1000021) + " " + 1000021);
        System.out.println("1: " + new Solution().isPalindromeStr(12321) + " " + 12321);
        System.out.println("2: " + new Solution().isPalindrome(12321) + " " + 12321);
        System.out.println("1: " + new Solution().isPalindromeStr(123321) + " " + 123321);
        System.out.println("2: " + new Solution().isPalindrome(123321) + " " + 123321);
        System.out.println("1: " + new Solution().isPalindromeStr(123421) + " " + 123421);
        System.out.println("2: " + new Solution().isPalindrome(123421) + " " + 123421);

    }
}
