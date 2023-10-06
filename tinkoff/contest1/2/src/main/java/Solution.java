import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int a = 0;
        int ch = 0;
//        while (in.hasNextInt()) {
            a = in.nextInt();
            ch = 0;

            while (a > 1) {
                if ((a % 2) == 0)
                    ch++;
                else if (a % 3 == 0) {
                    ch = ch + 2;
                    a = a / 3;
                    continue;
                }
                else
                    ch = ch + 2;
                a = a / 2;
            }
            System.out.println(ch);
//        }
    }
}
