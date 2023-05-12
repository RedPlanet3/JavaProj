public class Main {
    public int characterReplacement(String s, int k) {
        int start;
        int end;
        int maxLen = 0;
        int trueK = k;
        for(char symb = 'A'; symb <= 'Z'; symb++) {
            start = 0;
            end = 0;
            k = trueK;
            while (end < s.length() && start < s.length()) {
                end = end < start ? start : end;
                while (end < s.length()) {
                    if (symb != s.charAt(end)) {
                        if (k > 0) k--;
                        else break;
                    }
                    end++;
                }
                maxLen = Math.max(maxLen, end - start);
                start++;
                if (start < s.length() && s.charAt(start - 1) != symb) k++;
            }
        }
        return maxLen;
    }


    public static void main(String[] args) {
        Main ds = new Main();
        System.out.println("4: " + ds.characterReplacement("ABAB", 2));
        System.out.println("4: " + ds.characterReplacement("AABABBA", 1));
        System.out.println("3: " + ds.characterReplacement("FCC", 1));
        System.out.println("3: " + ds.characterReplacement("BAAA", 0));
        System.out.println("5: " + ds.characterReplacement("BAAAB", 2));
        System.out.println("5: " + ds.characterReplacement("JDJSBAAAB", 2));
        System.out.println("7: " + ds.characterReplacement("CSOPERNFSSSR", 4));
        System.out.println("7: " + ds.characterReplacement("KRSCDCSONAJNHLBMDQGIFCPEKPOHQIHLTDIQGEKLRLCQNBOHNDQGHJPNDQPERNFSSSRDEQLFPCCCARFMDLHADJADAGNNSBNCJQOF", 4));
    }
}