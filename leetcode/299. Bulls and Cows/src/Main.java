import java.util.HashMap;

public class Main {
    public String getHint(String secret, String guess) {
        StringBuilder first = new StringBuilder(secret);
        StringBuilder second = new StringBuilder(guess);
        HashMap<Character, Integer> dict = new HashMap<>();
        int numA = 0;
        int numB = 0;
        for (int i = secret.length() - 1; i > -1; i--)
        {
            if (first.charAt(i) == second.charAt(i)) {
                numA++;
                first.deleteCharAt(i);
                second.deleteCharAt(i);
            }
            else {
                if (!dict.containsKey(secret.charAt(i)))
                    dict.put(secret.charAt(i), 0);
                dict.put(secret.charAt(i), dict.get(secret.charAt(i)) + 1);
            }
        }
        for (int i = 0; i < second.length(); i++)
        {
            if(dict.containsKey(second.charAt(i)) && dict.get(second.charAt(i)) > 0)
            {
                numB++;
                dict.put(second.charAt(i), dict.get(second.charAt(i)) - 1);
            }
        }
        return numA + "A" + numB + "B";
    }

    public static void main(String[] args) {
        Main ds = new Main();
        System.out.println("1A3B\n" + ds.getHint("1807", "7810") + "\n");
        System.out.println("1A1B\n" + ds.getHint("1123", "0111") + "\n");

    }
}
