public class Main {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder answ = new StringBuilder();
        int w1 = 0;
        int w2 = 0;
        while (w1 < word1.length() && w2 < word2.length())
        {
            answ.append(word1.charAt(w1)).append(word2.charAt(w2));
            w1++;
            w2++;
        }
        if (w1 < word1.length())
            answ.append(word1.substring(w1));
        else if (w2 < word2.length())
            answ.append(word2.substring(w2));
        return answ.toString();
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}