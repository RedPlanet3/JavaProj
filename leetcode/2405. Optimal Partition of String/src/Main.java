import java.util.HashMap;

public class Main {
    public int partitionString(String s) {
        int[] alpha = new int[26];
        int max = 1;
        for(int i = 0; i < s.length(); i++) {
            if (alpha[s.charAt(i) - 'a'] > 0)
            {
                max++;
                alpha = new int[26];
            }
            alpha[s.charAt(i) - 'a'] += 1;
        }
        return max;
    }

    public static void main(String[] args) {
        Main ds = new Main();
        System.out.println("4: " + ds.partitionString("abacaba"));
        System.out.println("6: " + ds.partitionString("ssssss"));
        System.out.println("4: " + ds.partitionString("hdklqkcssgxlvehva"));
    }
}

