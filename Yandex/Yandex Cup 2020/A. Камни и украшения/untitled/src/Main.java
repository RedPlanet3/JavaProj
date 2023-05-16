import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String j = in.nextLine();
        String s = in.nextLine();
        int ch = 0;

        for (int i = 0; i < s.length(); i++)
        {
            for (int k = 0; k < j.length(); k++) {
                if (s.charAt(i) == j.charAt(k)) {
                    ch++;
                    break;
                }
            }
        }
        System.out.printf(String.valueOf(ch));
    }
}