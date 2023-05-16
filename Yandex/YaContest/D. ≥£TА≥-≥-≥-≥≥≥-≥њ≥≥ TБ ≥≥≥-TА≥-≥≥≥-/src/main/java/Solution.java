import java.util.Scanner;

public class Solution {
    public static void main(String[] arg)
    {
        Scanner in = new Scanner(System.in);

        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        if (c < 0) {
            System.out.println("NO SOLUTION");
            return;
        }
        if (a == 0) {
            System.out.println("MANY SOLUTIONS");
            return;
        }

        int x = ((int)Math.pow(c,2) - b)/ a;

        if ((a * x + b) < 0)
            System.out.println("NO SOLUTION");
        else
            System.out.println(x);
    }

}
